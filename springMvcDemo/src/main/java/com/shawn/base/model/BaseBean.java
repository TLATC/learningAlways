package com.shawn.base.model;

import java.io.Serializable;

/**
 * @ClassName: BaseBean
 * @Description 基础Bean
 * @author: Shawn Wu
 * @date: 2019/2/1 16:18
 * @version:
 */
public class BaseBean implements Serializable {

    /**
     * 序列化。用以分布式调用或其他情况的网络数据传输
     */
    private static final long serialVersionUID = 8237913239742557480L;

    /**
     * 创建人
     */
    private String creater;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间
     */
    private String modifiedTime;
    /**
     * 软删标识（0表示未删除，1表示已删除）
     */
    private String delTag;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }
}