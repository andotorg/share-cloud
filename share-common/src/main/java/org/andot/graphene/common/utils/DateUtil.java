package org.andot.graphene.common.utils;

import java.util.Date;
import java.util.List;

/***
 * 日期工具类，对日期格式化，计算一些需要的日期等
 */
public class DateUtil {
    /***
     *  根据开始时间和结束时间计算出每天时间放入集合中返回
     *  用在需要时间作为显示的地方
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 每天字符串集合
     */
    public static List<?> getStartEndCalcEveryDay(Date startDate, Date endDate, Class clazz){
        if(Date.class.equals(clazz)){

        }else if(String.class.equals(clazz)){

        }
        return null;
    }

}
