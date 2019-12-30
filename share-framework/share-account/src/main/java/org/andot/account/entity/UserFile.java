package org.andot.account.entity;

import java.io.Serializable;

public class UserFile implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_file.user_file_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer userFileId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_file.file_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer fileId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_file.user_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_file.user_file_id
     *
     * @return the value of user_file.user_file_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getUserFileId() {
        return userFileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_file.user_file_id
     *
     * @param userFileId the value for user_file.user_file_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setUserFileId(Integer userFileId) {
        this.userFileId = userFileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_file.file_id
     *
     * @return the value of user_file.file_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_file.file_id
     *
     * @param fileId the value for user_file.file_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_file.user_id
     *
     * @return the value of user_file.user_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_file.user_id
     *
     * @param userId the value for user_file.user_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userFileId=").append(userFileId);
        sb.append(", fileId=").append(fileId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserFile other = (UserFile) that;
        return (this.getUserFileId() == null ? other.getUserFileId() == null : this.getUserFileId().equals(other.getUserFileId()))
            && (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_file
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserFileId() == null) ? 0 : getUserFileId().hashCode());
        result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }
}