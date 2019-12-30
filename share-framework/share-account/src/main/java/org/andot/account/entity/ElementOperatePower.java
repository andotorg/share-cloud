package org.andot.account.entity;

import java.io.Serializable;

public class ElementOperatePower implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column element_operate_power.element_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer elementPowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column element_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer operatePowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column element_operate_power.page_element_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer pageElementId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column element_operate_power.element_power_id
     *
     * @return the value of element_operate_power.element_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getElementPowerId() {
        return elementPowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column element_operate_power.element_power_id
     *
     * @param elementPowerId the value for element_operate_power.element_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setElementPowerId(Integer elementPowerId) {
        this.elementPowerId = elementPowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column element_operate_power.operate_power_id
     *
     * @return the value of element_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getOperatePowerId() {
        return operatePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column element_operate_power.operate_power_id
     *
     * @param operatePowerId the value for element_operate_power.operate_power_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setOperatePowerId(Integer operatePowerId) {
        this.operatePowerId = operatePowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column element_operate_power.page_element_id
     *
     * @return the value of element_operate_power.page_element_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getPageElementId() {
        return pageElementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column element_operate_power.page_element_id
     *
     * @param pageElementId the value for element_operate_power.page_element_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setPageElementId(Integer pageElementId) {
        this.pageElementId = pageElementId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", elementPowerId=").append(elementPowerId);
        sb.append(", operatePowerId=").append(operatePowerId);
        sb.append(", pageElementId=").append(pageElementId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
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
        ElementOperatePower other = (ElementOperatePower) that;
        return (this.getElementPowerId() == null ? other.getElementPowerId() == null : this.getElementPowerId().equals(other.getElementPowerId()))
            && (this.getOperatePowerId() == null ? other.getOperatePowerId() == null : this.getOperatePowerId().equals(other.getOperatePowerId()))
            && (this.getPageElementId() == null ? other.getPageElementId() == null : this.getPageElementId().equals(other.getPageElementId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table element_operate_power
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getElementPowerId() == null) ? 0 : getElementPowerId().hashCode());
        result = prime * result + ((getOperatePowerId() == null) ? 0 : getOperatePowerId().hashCode());
        result = prime * result + ((getPageElementId() == null) ? 0 : getPageElementId().hashCode());
        return result;
    }
}