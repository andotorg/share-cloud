package org.andot.account.mapper;

import java.util.List;
import org.andot.account.entity.OperatePower;
import org.andot.account.entity.OperatePowerCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OperatePowerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int countByExample(OperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByExample(OperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByPrimaryKey(Integer operatePowerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insert(OperatePower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insertSelective(OperatePower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<OperatePower> selectByExampleWithRowbounds(OperatePowerCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<OperatePower> selectByExample(OperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    OperatePower selectByPrimaryKey(Integer operatePowerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") OperatePower record, @Param("example") OperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExample(@Param("record") OperatePower record, @Param("example") OperatePowerCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKeySelective(OperatePower record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKey(OperatePower record);
}