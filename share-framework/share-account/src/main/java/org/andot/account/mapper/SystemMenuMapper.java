package org.andot.account.mapper;

import java.util.List;
import org.andot.account.entity.SystemMenu;
import org.andot.account.entity.SystemMenuCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SystemMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int countByExample(SystemMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByExample(SystemMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByPrimaryKey(Integer systemMenuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insert(SystemMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insertSelective(SystemMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<SystemMenu> selectByExampleWithRowbounds(SystemMenuCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<SystemMenu> selectByExample(SystemMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    SystemMenu selectByPrimaryKey(Integer systemMenuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") SystemMenu record, @Param("example") SystemMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExample(@Param("record") SystemMenu record, @Param("example") SystemMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKeySelective(SystemMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKey(SystemMenu record);
}