package org.andot.account.entity;

import java.io.Serializable;

public class RoleOperatePower implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_operate_power.role_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer rolePowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer operatePowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_operate_power.role_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_operate_power.role_power_id
     *
     * @return the value of role_operate_power.role_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getRolePowerId() {
        return rolePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_operate_power.role_power_id
     *
     * @param rolePowerId the value for role_operate_power.role_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setRolePowerId(Integer rolePowerId) {
        this.rolePowerId = rolePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_operate_power.operate_power_id
     *
     * @return the value of role_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getOperatePowerId() {
        return operatePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_operate_power.operate_power_id
     *
     * @param operatePowerId the value for role_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setOperatePowerId(Integer operatePowerId) {
        this.operatePowerId = operatePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_operate_power.role_id
     *
     * @return the value of role_operate_power.role_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_operate_power.role_id
     *
     * @param roleId the value for role_operate_power.role_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rolePowerId=").append(rolePowerId);
        sb.append(", operatePowerId=").append(operatePowerId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_operate_power
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
        RoleOperatePower other = (RoleOperatePower) that;
        return (this.getRolePowerId() == null ? other.getRolePowerId() == null : this.getRolePowerId().equals(other.getRolePowerId()))
            && (this.getOperatePowerId() == null ? other.getOperatePowerId() == null : this.getOperatePowerId().equals(other.getOperatePowerId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRolePowerId() == null) ? 0 : getRolePowerId().hashCode());
        result = prime * result + ((getOperatePowerId() == null) ? 0 : getOperatePowerId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        return result;
    }
}