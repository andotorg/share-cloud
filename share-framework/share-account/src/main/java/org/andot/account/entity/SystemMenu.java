package org.andot.account.entity;

import java.io.Serializable;

public class SystemMenu implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_menu.system_menu_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer systemMenuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_menu.system_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer systemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_menu.menu_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private Integer menuId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_menu.system_menu_id
     *
     * @return the value of system_menu.system_menu_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getSystemMenuId() {
        return systemMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_menu.system_menu_id
     *
     * @param systemMenuId the value for system_menu.system_menu_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setSystemMenuId(Integer systemMenuId) {
        this.systemMenuId = systemMenuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_menu.system_id
     *
     * @return the value of system_menu.system_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getSystemId() {
        return systemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_menu.system_id
     *
     * @param systemId the value for system_menu.system_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_menu.menu_id
     *
     * @return the value of system_menu.menu_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_menu.menu_id
     *
     * @param menuId the value for system_menu.menu_id
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", systemMenuId=").append(systemMenuId);
        sb.append(", systemId=").append(systemId);
        sb.append(", menuId=").append(menuId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
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
        SystemMenu other = (SystemMenu) that;
        return (this.getSystemMenuId() == null ? other.getSystemMenuId() == null : this.getSystemMenuId().equals(other.getSystemMenuId()))
            && (this.getSystemId() == null ? other.getSystemId() == null : this.getSystemId().equals(other.getSystemId()))
            && (this.getMenuId() == null ? other.getMenuId() == null : this.getMenuId().equals(other.getMenuId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_menu
     *
     * @mbggenerated Thu Jan 10 10:32:10 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSystemMenuId() == null) ? 0 : getSystemMenuId().hashCode());
        result = prime * result + ((getSystemId() == null) ? 0 : getSystemId().hashCode());
        result = prime * result + ((getMenuId() == null) ? 0 : getMenuId().hashCode());
        return result;
    }
}