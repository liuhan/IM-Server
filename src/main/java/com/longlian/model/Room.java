package com.longlian.model;

import java.util.Date;

/**
 *
 * tablename:room
 */
public class Room {
    /**
     *
     * field:id  column:id
     * 
     */
    private Long id;

    /**
     *
     * field:createId  column:create_id
     * 
     */
    private Long createId;

    /**
     *
     * field:createTime  column:create_time
     * 
     */
    private Date createTime;

    /**
     * 0-开启1-关闭
     *
     * field:status  column:status
     * 
     */
    private String status;

    /**
     *
     * field:closeTime  column:close_time
     * 
     */
    private Date closeTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}