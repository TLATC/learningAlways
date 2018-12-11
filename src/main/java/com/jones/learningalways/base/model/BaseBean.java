package com.jones.learningalways.base.model;

import java.io.Serializable;

/**
 * 系统名称: learningAlways
 * 模块名称:
 * 类 名 称: BaseBean
 * 软件版权: Jones
 * 功能说明：基础Bean的封装
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/5/20 14:22
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class BaseBean implements Serializable {

    /**
     * 序列化。用以分布式调用或其他情况的网络数据传输
     */
    private static final long serialVersionUID = 8237913239742557480L;

    /**
     * 主键ID
     */
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
