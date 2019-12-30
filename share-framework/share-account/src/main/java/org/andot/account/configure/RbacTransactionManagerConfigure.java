package org.andot.account.configure;

import org.andot.graphene.common.configure.PlatTransactionManagerConfigure;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.*;

/***
 * 注释说明 @see org.andot.core.configure.PlatTransactionManagerConfigure
 */
@ConfigurationProperties(prefix = "transaction-attribute.account")
@Configuration
public class RbacTransactionManagerConfigure implements PlatTransactionManagerConfigure {

    private List<String> methodName;
    private List<String> methodNameReadonly;

    public void setMethodName(List<String> methodName) {
        this.methodName = methodName;
    }
    public void setMethodNameReadonly(List<String> methodNameReadonly) {
        this.methodNameReadonly = methodNameReadonly;
    }

    @Bean("txRbacSource")
    @Override
    public TransactionAttributeSource transactionAttributeSource() {
        NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource = new NameMatchTransactionAttributeSource();
        //创建规则对象
        RuleBasedTransactionAttribute ruleBasedTransactionAttribute = new RuleBasedTransactionAttribute();
        //设置超时时间
        ruleBasedTransactionAttribute.setTimeout(30000);
        //创建并添加事务回滚的异常（支持添加多个），默认为RuntimeException
        RollbackRuleAttribute rollbackRuleAttrException = new RollbackRuleAttribute(Exception.class);
        List<RollbackRuleAttribute> rollbackRuleAttributeList = new ArrayList<>();
        rollbackRuleAttributeList.add(rollbackRuleAttrException);
        ruleBasedTransactionAttribute.setRollbackRules(rollbackRuleAttributeList);
        ruleBasedTransactionAttribute.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        ruleBasedTransactionAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        Map<String, TransactionAttribute> txMethodPrefixMap = new HashMap<>();
        Iterator<String> iterator = methodName.iterator();
        while (iterator.hasNext()){
            txMethodPrefixMap.put(iterator.next(), ruleBasedTransactionAttribute);
        }
        Iterator<String> iteratorReadonly = methodNameReadonly.iterator();
        while (iteratorReadonly.hasNext()){
            ruleBasedTransactionAttribute.setReadOnly(true);
            txMethodPrefixMap.put(iteratorReadonly.next(), ruleBasedTransactionAttribute);
        }
        nameMatchTransactionAttributeSource.setNameMap(txMethodPrefixMap);
        return nameMatchTransactionAttributeSource;
    }

    @Override
    public AspectJExpressionPointcutAdvisor pointcutAdvisor(TransactionInterceptor txRbacInterceptor) {
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setAdvice(txRbacInterceptor);
        pointcutAdvisor.setExpression("execution (* org.andot.account.service.impl.*.*(..))");
        return pointcutAdvisor;
    }

    @Bean("txRbacInterceptor")
    @Override
    public TransactionInterceptor getTransactionInterceptor(PlatformTransactionManager txRbacTransactionManager) {
        return new TransactionInterceptor(txRbacTransactionManager, this.transactionAttributeSource());
    }
}
