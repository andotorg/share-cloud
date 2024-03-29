package org.andot.account.mapper;

import java.util.List;
import org.andot.account.entity.UserFile;
import org.andot.account.entity.UserFileCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int countByExample(UserFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByExample(UserFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int deleteByPrimaryKey(Integer userFileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insert(UserFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int insertSelective(UserFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<UserFile> selectByExampleWithRowbounds(UserFileCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    List<UserFile> selectByExample(UserFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    UserFile selectByPrimaryKey(Integer userFileId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserFile record, @Param("example") UserFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByExample(@Param("record") UserFile record, @Param("example") UserFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKeySelective(UserFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    int updateByPrimaryKey(UserFile record);
}