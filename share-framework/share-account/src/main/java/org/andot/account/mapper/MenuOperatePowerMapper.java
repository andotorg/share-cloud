package org.andot.account.mapper;

import java.util.List;
import org.andot.account.entity.MenuOperatePower;
import org.andot.account.entity.MenuOperatePowerCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MenuOperatePowerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int countByExample(MenuOperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByExample(MenuOperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByPrimaryKey(Integer menuPowerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insert(MenuOperatePower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insertSelective(MenuOperatePower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<MenuOperatePower> selectByExampleWithRowbounds(MenuOperatePowerCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<MenuOperatePower> selectByExample(MenuOperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    MenuOperatePower selectByPrimaryKey(Integer menuPowerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") MenuOperatePower record, @Param("example") MenuOperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExample(@Param("record") MenuOperatePower record, @Param("example") MenuOperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKeySelective(MenuOperatePower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKey(MenuOperatePower record);
}