package org.andot.account.entity;

import java.util.ArrayList;
import java.util.List;

public class ElementOperatePowerCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public ElementOperatePowerCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andElementPowerIdIsNull() {
            addCriterion("element_power_id is null");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdIsNotNull() {
            addCriterion("element_power_id is not null");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdEqualTo(Integer value) {
            addCriterion("element_power_id =", value, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdNotEqualTo(Integer value) {
            addCriterion("element_power_id <>", value, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdGreaterThan(Integer value) {
            addCriterion("element_power_id >", value, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("element_power_id >=", value, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdLessThan(Integer value) {
            addCriterion("element_power_id <", value, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("element_power_id <=", value, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdIn(List<Integer> values) {
            addCriterion("element_power_id in", values, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdNotIn(List<Integer> values) {
            addCriterion("element_power_id not in", values, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdBetween(Integer value1, Integer value2) {
            addCriterion("element_power_id between", value1, value2, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andElementPowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("element_power_id not between", value1, value2, "elementPowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdIsNull() {
            addCriterion("operate_power_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdIsNotNull() {
            addCriterion("operate_power_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdEqualTo(Integer value) {
            addCriterion("operate_power_id =", value, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdNotEqualTo(Integer value) {
            addCriterion("operate_power_id <>", value, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdGreaterThan(Integer value) {
            addCriterion("operate_power_id >", value, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operate_power_id >=", value, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdLessThan(Integer value) {
            addCriterion("operate_power_id <", value, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("operate_power_id <=", value, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdIn(List<Integer> values) {
            addCriterion("operate_power_id in", values, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdNotIn(List<Integer> values) {
            addCriterion("operate_power_id not in", values, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdBetween(Integer value1, Integer value2) {
            addCriterion("operate_power_id between", value1, value2, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andOperatePowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operate_power_id not between", value1, value2, "operatePowerId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdIsNull() {
            addCriterion("page_element_id is null");
            return (Criteria) this;
        }

        public Criteria andPageElementIdIsNotNull() {
            addCriterion("page_element_id is not null");
            return (Criteria) this;
        }

        public Criteria andPageElementIdEqualTo(Integer value) {
            addCriterion("page_element_id =", value, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdNotEqualTo(Integer value) {
            addCriterion("page_element_id <>", value, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdGreaterThan(Integer value) {
            addCriterion("page_element_id >", value, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("page_element_id >=", value, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdLessThan(Integer value) {
            addCriterion("page_element_id <", value, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdLessThanOrEqualTo(Integer value) {
            addCriterion("page_element_id <=", value, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdIn(List<Integer> values) {
            addCriterion("page_element_id in", values, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdNotIn(List<Integer> values) {
            addCriterion("page_element_id not in", values, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdBetween(Integer value1, Integer value2) {
            addCriterion("page_element_id between", value1, value2, "pageElementId");
            return (Criteria) this;
        }

        public Criteria andPageElementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("page_element_id not between", value1, value2, "pageElementId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table element_operate_power
     *
     * @mbggenerated do_not_delete_during_merge Thu Jan 10 10:32:10 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}