package com.shawn.learningalways.mybatisgenerator.model;

public class MybatisGeneratorDO {
    /**
     * 主键id
     */
    private String id;

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 批次
     */
    private String batchNum;

    /**
     * 批次插入时间
     */
    private String batchCreationTime;

    /**
     * 规则状态0未匹配1匹配失败2匹配成功3重复数据
     */
    private String ruleState;

    /**
     * 规则匹配时间
     */
    private String ruleModifiedTime;

    /**
     * 问卷ID
     */
    private String qnaireId;

    private String qnairestate;

    private String qnairemodifiedtime;

    private String activityid;

    private String priority;

    private String appointmentdate;

    private String appointmenttime;

    private String appointmenttimeslot;

    private String datastate;

    private String returnstate;

    private String ismatchqnaire;

    private String extractiontime;

    private String modifiedtime;

    private String num;

    private String queue;

    private String checknum;

    private String isvisittwo;

    private String feedbackresult;

    private String feedbackphone;

    private String returnvisittime;

    private String problemtype;

    private String disposetime;

    private String disposeresult;

    private String visittwoinserttime;

    private String visitcount;

    private String calllostflag;

    private String lastvisitresult;

    private String lastvisituser;

    private String visitagentid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getBatchCreationTime() {
        return batchCreationTime;
    }

    public void setBatchCreationTime(String batchCreationTime) {
        this.batchCreationTime = batchCreationTime;
    }

    public String getRuleState() {
        return ruleState;
    }

    public void setRuleState(String ruleState) {
        this.ruleState = ruleState;
    }

    public String getRuleModifiedTime() {
        return ruleModifiedTime;
    }

    public void setRuleModifiedTime(String ruleModifiedTime) {
        this.ruleModifiedTime = ruleModifiedTime;
    }

    public String getQnaireId() {
        return qnaireId;
    }

    public void setQnaireId(String qnaireId) {
        this.qnaireId = qnaireId;
    }

    public String getQnairestate() {
        return qnairestate;
    }

    public void setQnairestate(String qnairestate) {
        this.qnairestate = qnairestate == null ? null : qnairestate.trim();
    }

    public String getQnairemodifiedtime() {
        return qnairemodifiedtime;
    }

    public void setQnairemodifiedtime(String qnairemodifiedtime) {
        this.qnairemodifiedtime = qnairemodifiedtime == null ? null : qnairemodifiedtime.trim();
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid == null ? null : activityid.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate == null ? null : appointmentdate.trim();
    }

    public String getAppointmenttime() {
        return appointmenttime;
    }

    public void setAppointmenttime(String appointmenttime) {
        this.appointmenttime = appointmenttime == null ? null : appointmenttime.trim();
    }

    public String getAppointmenttimeslot() {
        return appointmenttimeslot;
    }

    public void setAppointmenttimeslot(String appointmenttimeslot) {
        this.appointmenttimeslot = appointmenttimeslot == null ? null : appointmenttimeslot.trim();
    }

    public String getDatastate() {
        return datastate;
    }

    public void setDatastate(String datastate) {
        this.datastate = datastate == null ? null : datastate.trim();
    }

    public String getReturnstate() {
        return returnstate;
    }

    public void setReturnstate(String returnstate) {
        this.returnstate = returnstate == null ? null : returnstate.trim();
    }

    public String getIsmatchqnaire() {
        return ismatchqnaire;
    }

    public void setIsmatchqnaire(String ismatchqnaire) {
        this.ismatchqnaire = ismatchqnaire == null ? null : ismatchqnaire.trim();
    }

    public String getExtractiontime() {
        return extractiontime;
    }

    public void setExtractiontime(String extractiontime) {
        this.extractiontime = extractiontime == null ? null : extractiontime.trim();
    }

    public String getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(String modifiedtime) {
        this.modifiedtime = modifiedtime == null ? null : modifiedtime.trim();
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public String getChecknum() {
        return checknum;
    }

    public void setChecknum(String checknum) {
        this.checknum = checknum == null ? null : checknum.trim();
    }

    public String getIsvisittwo() {
        return isvisittwo;
    }

    public void setIsvisittwo(String isvisittwo) {
        this.isvisittwo = isvisittwo == null ? null : isvisittwo.trim();
    }

    public String getFeedbackresult() {
        return feedbackresult;
    }

    public void setFeedbackresult(String feedbackresult) {
        this.feedbackresult = feedbackresult == null ? null : feedbackresult.trim();
    }

    public String getFeedbackphone() {
        return feedbackphone;
    }

    public void setFeedbackphone(String feedbackphone) {
        this.feedbackphone = feedbackphone == null ? null : feedbackphone.trim();
    }

    public String getReturnvisittime() {
        return returnvisittime;
    }

    public void setReturnvisittime(String returnvisittime) {
        this.returnvisittime = returnvisittime == null ? null : returnvisittime.trim();
    }

    public String getProblemtype() {
        return problemtype;
    }

    public void setProblemtype(String problemtype) {
        this.problemtype = problemtype == null ? null : problemtype.trim();
    }

    public String getDisposetime() {
        return disposetime;
    }

    public void setDisposetime(String disposetime) {
        this.disposetime = disposetime == null ? null : disposetime.trim();
    }

    public String getDisposeresult() {
        return disposeresult;
    }

    public void setDisposeresult(String disposeresult) {
        this.disposeresult = disposeresult == null ? null : disposeresult.trim();
    }

    public String getVisittwoinserttime() {
        return visittwoinserttime;
    }

    public void setVisittwoinserttime(String visittwoinserttime) {
        this.visittwoinserttime = visittwoinserttime == null ? null : visittwoinserttime.trim();
    }

    public String getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(String visitcount) {
        this.visitcount = visitcount == null ? null : visitcount.trim();
    }

    public String getCalllostflag() {
        return calllostflag;
    }

    public void setCalllostflag(String calllostflag) {
        this.calllostflag = calllostflag == null ? null : calllostflag.trim();
    }

    public String getLastvisitresult() {
        return lastvisitresult;
    }

    public void setLastvisitresult(String lastvisitresult) {
        this.lastvisitresult = lastvisitresult == null ? null : lastvisitresult.trim();
    }

    public String getLastvisituser() {
        return lastvisituser;
    }

    public void setLastvisituser(String lastvisituser) {
        this.lastvisituser = lastvisituser == null ? null : lastvisituser.trim();
    }

    public String getVisitagentid() {
        return visitagentid;
    }

    public void setVisitagentid(String visitagentid) {
        this.visitagentid = visitagentid == null ? null : visitagentid.trim();
    }
}