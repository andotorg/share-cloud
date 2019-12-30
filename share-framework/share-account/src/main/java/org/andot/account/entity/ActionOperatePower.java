package org.andot.account.entity;

import java.io.Serializable;

public class ActionOperatePower implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column action_operate_power.action_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer actionPowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column action_operate_power.action_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer actionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column action_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer operatePowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table action_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column action_operate_power.action_power_id
     *
     * @return the value of action_operate_power.action_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getActionPowerId() {
        return actionPowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column action_operate_power.action_power_id
     *
     * @param actionPowerId the value for action_operate_power.action_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setActionPowerId(Integer actionPowerId) {
        this.actionPowerId = actionPowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column action_operate_power.action_id
     *
     * @return the value of action_operate_power.action_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getActionId() {
        return actionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column action_operate_power.action_id
     *
     * @param actionId the value for action_operate_power.action_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column action_operate_power.operate_power_id
     *
     * @return the value of action_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getOperatePowerId() {
        return operatePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column action_operate_power.operate_power_id
     *
     * @param operatePowerId the value for action_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setOperatePowerId(Integer operatePowerId) {
        this.operatePowerId = operatePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", actionPowerId=").append(actionPowerId);
        sb.append(", actionId=").append(actionId);
        sb.append(", operatePowerId=").append(operatePowerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_operate_power
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
        ActionOperatePower other = (ActionOperatePower) that;
        return (this.getActionPowerId() == null ? other.getActionPowerId() == null : this.getActionPowerId().equals(other.getActionPowerId()))
            && (this.getActionId() == null ? other.getActionId() == null : this.getActionId().equals(other.getActionId()))
            && (this.getOperatePowerId() == null ? other.getOperatePowerId() == null : this.getOperatePowerId().equals(other.getOperatePowerId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table action_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActionPowerId() == null) ? 0 : getActionPowerId().hashCode());
        result = prime * result + ((getActionId() == null) ? 0 : getActionId().hashCode());
        result = prime * result + ((getOperatePowerId() == null) ? 0 : getOperatePowerId().hashCode());
        return result;
    }
}