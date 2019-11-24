package com.shawn.learningalways.mybatisgenerator.model;

import java.util.ArrayList;
import java.util.List;

public class MybatisGeneratorDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MybatisGeneratorDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNull() {
            addCriterion("TEMPLATEID is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIsNotNull() {
            addCriterion("TEMPLATEID is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateIdEqualTo(String value) {
            addCriterion("TEMPLATEID =", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotEqualTo(String value) {
            addCriterion("TEMPLATEID <>", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThan(String value) {
            addCriterion("TEMPLATEID >", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEMPLATEID >=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThan(String value) {
            addCriterion("TEMPLATEID <", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(String value) {
            addCriterion("TEMPLATEID <=", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdLike(String value) {
            addCriterion("TEMPLATEID like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            addCriterion("TEMPLATEID not like", value, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdIn(List<String> values) {
            addCriterion("TEMPLATEID in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotIn(List<String> values) {
            addCriterion("TEMPLATEID not in", values, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdBetween(String value1, String value2) {
            addCriterion("TEMPLATEID between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andTemplateIdNotBetween(String value1, String value2) {
            addCriterion("TEMPLATEID not between", value1, value2, "templateId");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNull() {
            addCriterion("BATCHNUM is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNotNull() {
            addCriterion("BATCHNUM is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumEqualTo(String value) {
            addCriterion("BATCHNUM =", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotEqualTo(String value) {
            addCriterion("BATCHNUM <>", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThan(String value) {
            addCriterion("BATCHNUM >", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThanOrEqualTo(String value) {
            addCriterion("BATCHNUM >=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThan(String value) {
            addCriterion("BATCHNUM <", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThanOrEqualTo(String value) {
            addCriterion("BATCHNUM <=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLike(String value) {
            addCriterion("BATCHNUM like", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotLike(String value) {
            addCriterion("BATCHNUM not like", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumIn(List<String> values) {
            addCriterion("BATCHNUM in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotIn(List<String> values) {
            addCriterion("BATCHNUM not in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumBetween(String value1, String value2) {
            addCriterion("BATCHNUM between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotBetween(String value1, String value2) {
            addCriterion("BATCHNUM not between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeIsNull() {
            addCriterion("BATCHCREATIONTIME is null");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeIsNotNull() {
            addCriterion("BATCHCREATIONTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeEqualTo(String value) {
            addCriterion("BATCHCREATIONTIME =", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeNotEqualTo(String value) {
            addCriterion("BATCHCREATIONTIME <>", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeGreaterThan(String value) {
            addCriterion("BATCHCREATIONTIME >", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeGreaterThanOrEqualTo(String value) {
            addCriterion("BATCHCREATIONTIME >=", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeLessThan(String value) {
            addCriterion("BATCHCREATIONTIME <", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeLessThanOrEqualTo(String value) {
            addCriterion("BATCHCREATIONTIME <=", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeLike(String value) {
            addCriterion("BATCHCREATIONTIME like", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeNotLike(String value) {
            addCriterion("BATCHCREATIONTIME not like", value, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeIn(List<String> values) {
            addCriterion("BATCHCREATIONTIME in", values, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeNotIn(List<String> values) {
            addCriterion("BATCHCREATIONTIME not in", values, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeBetween(String value1, String value2) {
            addCriterion("BATCHCREATIONTIME between", value1, value2, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andBatchCreationTimeNotBetween(String value1, String value2) {
            addCriterion("BATCHCREATIONTIME not between", value1, value2, "batchCreationTime");
            return (Criteria) this;
        }

        public Criteria andRuleStateIsNull() {
            addCriterion("RULESTATE is null");
            return (Criteria) this;
        }

        public Criteria andRuleStateIsNotNull() {
            addCriterion("RULESTATE is not null");
            return (Criteria) this;
        }

        public Criteria andRuleStateEqualTo(String value) {
            addCriterion("RULESTATE =", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateNotEqualTo(String value) {
            addCriterion("RULESTATE <>", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateGreaterThan(String value) {
            addCriterion("RULESTATE >", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateGreaterThanOrEqualTo(String value) {
            addCriterion("RULESTATE >=", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateLessThan(String value) {
            addCriterion("RULESTATE <", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateLessThanOrEqualTo(String value) {
            addCriterion("RULESTATE <=", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateLike(String value) {
            addCriterion("RULESTATE like", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateNotLike(String value) {
            addCriterion("RULESTATE not like", value, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateIn(List<String> values) {
            addCriterion("RULESTATE in", values, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateNotIn(List<String> values) {
            addCriterion("RULESTATE not in", values, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateBetween(String value1, String value2) {
            addCriterion("RULESTATE between", value1, value2, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleStateNotBetween(String value1, String value2) {
            addCriterion("RULESTATE not between", value1, value2, "ruleState");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeIsNull() {
            addCriterion("RULEMODIFIEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeIsNotNull() {
            addCriterion("RULEMODIFIEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeEqualTo(String value) {
            addCriterion("RULEMODIFIEDTIME =", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeNotEqualTo(String value) {
            addCriterion("RULEMODIFIEDTIME <>", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeGreaterThan(String value) {
            addCriterion("RULEMODIFIEDTIME >", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("RULEMODIFIEDTIME >=", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeLessThan(String value) {
            addCriterion("RULEMODIFIEDTIME <", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeLessThanOrEqualTo(String value) {
            addCriterion("RULEMODIFIEDTIME <=", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeLike(String value) {
            addCriterion("RULEMODIFIEDTIME like", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeNotLike(String value) {
            addCriterion("RULEMODIFIEDTIME not like", value, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeIn(List<String> values) {
            addCriterion("RULEMODIFIEDTIME in", values, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeNotIn(List<String> values) {
            addCriterion("RULEMODIFIEDTIME not in", values, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeBetween(String value1, String value2) {
            addCriterion("RULEMODIFIEDTIME between", value1, value2, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andRuleModifiedTimeNotBetween(String value1, String value2) {
            addCriterion("RULEMODIFIEDTIME not between", value1, value2, "ruleModifiedTime");
            return (Criteria) this;
        }

        public Criteria andQnaireIdIsNull() {
            addCriterion("QNAIREID is null");
            return (Criteria) this;
        }

        public Criteria andQnaireIdIsNotNull() {
            addCriterion("QNAIREID is not null");
            return (Criteria) this;
        }

        public Criteria andQnaireIdEqualTo(String value) {
            addCriterion("QNAIREID =", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdNotEqualTo(String value) {
            addCriterion("QNAIREID <>", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdGreaterThan(String value) {
            addCriterion("QNAIREID >", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdGreaterThanOrEqualTo(String value) {
            addCriterion("QNAIREID >=", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdLessThan(String value) {
            addCriterion("QNAIREID <", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdLessThanOrEqualTo(String value) {
            addCriterion("QNAIREID <=", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdLike(String value) {
            addCriterion("QNAIREID like", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdNotLike(String value) {
            addCriterion("QNAIREID not like", value, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdIn(List<String> values) {
            addCriterion("QNAIREID in", values, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdNotIn(List<String> values) {
            addCriterion("QNAIREID not in", values, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdBetween(String value1, String value2) {
            addCriterion("QNAIREID between", value1, value2, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnaireIdNotBetween(String value1, String value2) {
            addCriterion("QNAIREID not between", value1, value2, "qnaireId");
            return (Criteria) this;
        }

        public Criteria andQnairestateIsNull() {
            addCriterion("QNAIRESTATE is null");
            return (Criteria) this;
        }

        public Criteria andQnairestateIsNotNull() {
            addCriterion("QNAIRESTATE is not null");
            return (Criteria) this;
        }

        public Criteria andQnairestateEqualTo(String value) {
            addCriterion("QNAIRESTATE =", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateNotEqualTo(String value) {
            addCriterion("QNAIRESTATE <>", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateGreaterThan(String value) {
            addCriterion("QNAIRESTATE >", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateGreaterThanOrEqualTo(String value) {
            addCriterion("QNAIRESTATE >=", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateLessThan(String value) {
            addCriterion("QNAIRESTATE <", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateLessThanOrEqualTo(String value) {
            addCriterion("QNAIRESTATE <=", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateLike(String value) {
            addCriterion("QNAIRESTATE like", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateNotLike(String value) {
            addCriterion("QNAIRESTATE not like", value, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateIn(List<String> values) {
            addCriterion("QNAIRESTATE in", values, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateNotIn(List<String> values) {
            addCriterion("QNAIRESTATE not in", values, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateBetween(String value1, String value2) {
            addCriterion("QNAIRESTATE between", value1, value2, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairestateNotBetween(String value1, String value2) {
            addCriterion("QNAIRESTATE not between", value1, value2, "qnairestate");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeIsNull() {
            addCriterion("QNAIREMODIFIEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeIsNotNull() {
            addCriterion("QNAIREMODIFIEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeEqualTo(String value) {
            addCriterion("QNAIREMODIFIEDTIME =", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeNotEqualTo(String value) {
            addCriterion("QNAIREMODIFIEDTIME <>", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeGreaterThan(String value) {
            addCriterion("QNAIREMODIFIEDTIME >", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeGreaterThanOrEqualTo(String value) {
            addCriterion("QNAIREMODIFIEDTIME >=", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeLessThan(String value) {
            addCriterion("QNAIREMODIFIEDTIME <", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeLessThanOrEqualTo(String value) {
            addCriterion("QNAIREMODIFIEDTIME <=", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeLike(String value) {
            addCriterion("QNAIREMODIFIEDTIME like", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeNotLike(String value) {
            addCriterion("QNAIREMODIFIEDTIME not like", value, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeIn(List<String> values) {
            addCriterion("QNAIREMODIFIEDTIME in", values, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeNotIn(List<String> values) {
            addCriterion("QNAIREMODIFIEDTIME not in", values, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeBetween(String value1, String value2) {
            addCriterion("QNAIREMODIFIEDTIME between", value1, value2, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andQnairemodifiedtimeNotBetween(String value1, String value2) {
            addCriterion("QNAIREMODIFIEDTIME not between", value1, value2, "qnairemodifiedtime");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNull() {
            addCriterion("ACTIVITYID is null");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNotNull() {
            addCriterion("ACTIVITYID is not null");
            return (Criteria) this;
        }

        public Criteria andActivityidEqualTo(String value) {
            addCriterion("ACTIVITYID =", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotEqualTo(String value) {
            addCriterion("ACTIVITYID <>", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThan(String value) {
            addCriterion("ACTIVITYID >", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVITYID >=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThan(String value) {
            addCriterion("ACTIVITYID <", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThanOrEqualTo(String value) {
            addCriterion("ACTIVITYID <=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLike(String value) {
            addCriterion("ACTIVITYID like", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotLike(String value) {
            addCriterion("ACTIVITYID not like", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidIn(List<String> values) {
            addCriterion("ACTIVITYID in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotIn(List<String> values) {
            addCriterion("ACTIVITYID not in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidBetween(String value1, String value2) {
            addCriterion("ACTIVITYID between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotBetween(String value1, String value2) {
            addCriterion("ACTIVITYID not between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("PRIORITY is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("PRIORITY is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("PRIORITY =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("PRIORITY <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("PRIORITY >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("PRIORITY >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("PRIORITY <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("PRIORITY <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("PRIORITY like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("PRIORITY not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("PRIORITY in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("PRIORITY not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("PRIORITY between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("PRIORITY not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateIsNull() {
            addCriterion("APPOINTMENTDATE is null");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateIsNotNull() {
            addCriterion("APPOINTMENTDATE is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateEqualTo(String value) {
            addCriterion("APPOINTMENTDATE =", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateNotEqualTo(String value) {
            addCriterion("APPOINTMENTDATE <>", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateGreaterThan(String value) {
            addCriterion("APPOINTMENTDATE >", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateGreaterThanOrEqualTo(String value) {
            addCriterion("APPOINTMENTDATE >=", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateLessThan(String value) {
            addCriterion("APPOINTMENTDATE <", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateLessThanOrEqualTo(String value) {
            addCriterion("APPOINTMENTDATE <=", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateLike(String value) {
            addCriterion("APPOINTMENTDATE like", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateNotLike(String value) {
            addCriterion("APPOINTMENTDATE not like", value, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateIn(List<String> values) {
            addCriterion("APPOINTMENTDATE in", values, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateNotIn(List<String> values) {
            addCriterion("APPOINTMENTDATE not in", values, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateBetween(String value1, String value2) {
            addCriterion("APPOINTMENTDATE between", value1, value2, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmentdateNotBetween(String value1, String value2) {
            addCriterion("APPOINTMENTDATE not between", value1, value2, "appointmentdate");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeIsNull() {
            addCriterion("APPOINTMENTTIME is null");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeIsNotNull() {
            addCriterion("APPOINTMENTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeEqualTo(String value) {
            addCriterion("APPOINTMENTTIME =", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeNotEqualTo(String value) {
            addCriterion("APPOINTMENTTIME <>", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeGreaterThan(String value) {
            addCriterion("APPOINTMENTTIME >", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPOINTMENTTIME >=", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeLessThan(String value) {
            addCriterion("APPOINTMENTTIME <", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeLessThanOrEqualTo(String value) {
            addCriterion("APPOINTMENTTIME <=", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeLike(String value) {
            addCriterion("APPOINTMENTTIME like", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeNotLike(String value) {
            addCriterion("APPOINTMENTTIME not like", value, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeIn(List<String> values) {
            addCriterion("APPOINTMENTTIME in", values, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeNotIn(List<String> values) {
            addCriterion("APPOINTMENTTIME not in", values, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeBetween(String value1, String value2) {
            addCriterion("APPOINTMENTTIME between", value1, value2, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeNotBetween(String value1, String value2) {
            addCriterion("APPOINTMENTTIME not between", value1, value2, "appointmenttime");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotIsNull() {
            addCriterion("APPOINTMENTTIMESLOT is null");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotIsNotNull() {
            addCriterion("APPOINTMENTTIMESLOT is not null");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotEqualTo(String value) {
            addCriterion("APPOINTMENTTIMESLOT =", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotNotEqualTo(String value) {
            addCriterion("APPOINTMENTTIMESLOT <>", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotGreaterThan(String value) {
            addCriterion("APPOINTMENTTIMESLOT >", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotGreaterThanOrEqualTo(String value) {
            addCriterion("APPOINTMENTTIMESLOT >=", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotLessThan(String value) {
            addCriterion("APPOINTMENTTIMESLOT <", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotLessThanOrEqualTo(String value) {
            addCriterion("APPOINTMENTTIMESLOT <=", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotLike(String value) {
            addCriterion("APPOINTMENTTIMESLOT like", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotNotLike(String value) {
            addCriterion("APPOINTMENTTIMESLOT not like", value, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotIn(List<String> values) {
            addCriterion("APPOINTMENTTIMESLOT in", values, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotNotIn(List<String> values) {
            addCriterion("APPOINTMENTTIMESLOT not in", values, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotBetween(String value1, String value2) {
            addCriterion("APPOINTMENTTIMESLOT between", value1, value2, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andAppointmenttimeslotNotBetween(String value1, String value2) {
            addCriterion("APPOINTMENTTIMESLOT not between", value1, value2, "appointmenttimeslot");
            return (Criteria) this;
        }

        public Criteria andDatastateIsNull() {
            addCriterion("DATASTATE is null");
            return (Criteria) this;
        }

        public Criteria andDatastateIsNotNull() {
            addCriterion("DATASTATE is not null");
            return (Criteria) this;
        }

        public Criteria andDatastateEqualTo(String value) {
            addCriterion("DATASTATE =", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateNotEqualTo(String value) {
            addCriterion("DATASTATE <>", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateGreaterThan(String value) {
            addCriterion("DATASTATE >", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateGreaterThanOrEqualTo(String value) {
            addCriterion("DATASTATE >=", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateLessThan(String value) {
            addCriterion("DATASTATE <", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateLessThanOrEqualTo(String value) {
            addCriterion("DATASTATE <=", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateLike(String value) {
            addCriterion("DATASTATE like", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateNotLike(String value) {
            addCriterion("DATASTATE not like", value, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateIn(List<String> values) {
            addCriterion("DATASTATE in", values, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateNotIn(List<String> values) {
            addCriterion("DATASTATE not in", values, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateBetween(String value1, String value2) {
            addCriterion("DATASTATE between", value1, value2, "datastate");
            return (Criteria) this;
        }

        public Criteria andDatastateNotBetween(String value1, String value2) {
            addCriterion("DATASTATE not between", value1, value2, "datastate");
            return (Criteria) this;
        }

        public Criteria andReturnstateIsNull() {
            addCriterion("RETURNSTATE is null");
            return (Criteria) this;
        }

        public Criteria andReturnstateIsNotNull() {
            addCriterion("RETURNSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andReturnstateEqualTo(String value) {
            addCriterion("RETURNSTATE =", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateNotEqualTo(String value) {
            addCriterion("RETURNSTATE <>", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateGreaterThan(String value) {
            addCriterion("RETURNSTATE >", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateGreaterThanOrEqualTo(String value) {
            addCriterion("RETURNSTATE >=", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateLessThan(String value) {
            addCriterion("RETURNSTATE <", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateLessThanOrEqualTo(String value) {
            addCriterion("RETURNSTATE <=", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateLike(String value) {
            addCriterion("RETURNSTATE like", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateNotLike(String value) {
            addCriterion("RETURNSTATE not like", value, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateIn(List<String> values) {
            addCriterion("RETURNSTATE in", values, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateNotIn(List<String> values) {
            addCriterion("RETURNSTATE not in", values, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateBetween(String value1, String value2) {
            addCriterion("RETURNSTATE between", value1, value2, "returnstate");
            return (Criteria) this;
        }

        public Criteria andReturnstateNotBetween(String value1, String value2) {
            addCriterion("RETURNSTATE not between", value1, value2, "returnstate");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireIsNull() {
            addCriterion("ISMATCHQNAIRE is null");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireIsNotNull() {
            addCriterion("ISMATCHQNAIRE is not null");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireEqualTo(String value) {
            addCriterion("ISMATCHQNAIRE =", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireNotEqualTo(String value) {
            addCriterion("ISMATCHQNAIRE <>", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireGreaterThan(String value) {
            addCriterion("ISMATCHQNAIRE >", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireGreaterThanOrEqualTo(String value) {
            addCriterion("ISMATCHQNAIRE >=", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireLessThan(String value) {
            addCriterion("ISMATCHQNAIRE <", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireLessThanOrEqualTo(String value) {
            addCriterion("ISMATCHQNAIRE <=", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireLike(String value) {
            addCriterion("ISMATCHQNAIRE like", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireNotLike(String value) {
            addCriterion("ISMATCHQNAIRE not like", value, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireIn(List<String> values) {
            addCriterion("ISMATCHQNAIRE in", values, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireNotIn(List<String> values) {
            addCriterion("ISMATCHQNAIRE not in", values, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireBetween(String value1, String value2) {
            addCriterion("ISMATCHQNAIRE between", value1, value2, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andIsmatchqnaireNotBetween(String value1, String value2) {
            addCriterion("ISMATCHQNAIRE not between", value1, value2, "ismatchqnaire");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeIsNull() {
            addCriterion("EXTRACTIONTIME is null");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeIsNotNull() {
            addCriterion("EXTRACTIONTIME is not null");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeEqualTo(String value) {
            addCriterion("EXTRACTIONTIME =", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeNotEqualTo(String value) {
            addCriterion("EXTRACTIONTIME <>", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeGreaterThan(String value) {
            addCriterion("EXTRACTIONTIME >", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeGreaterThanOrEqualTo(String value) {
            addCriterion("EXTRACTIONTIME >=", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeLessThan(String value) {
            addCriterion("EXTRACTIONTIME <", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeLessThanOrEqualTo(String value) {
            addCriterion("EXTRACTIONTIME <=", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeLike(String value) {
            addCriterion("EXTRACTIONTIME like", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeNotLike(String value) {
            addCriterion("EXTRACTIONTIME not like", value, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeIn(List<String> values) {
            addCriterion("EXTRACTIONTIME in", values, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeNotIn(List<String> values) {
            addCriterion("EXTRACTIONTIME not in", values, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeBetween(String value1, String value2) {
            addCriterion("EXTRACTIONTIME between", value1, value2, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andExtractiontimeNotBetween(String value1, String value2) {
            addCriterion("EXTRACTIONTIME not between", value1, value2, "extractiontime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNull() {
            addCriterion("MODIFIEDTIME is null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIsNotNull() {
            addCriterion("MODIFIEDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeEqualTo(String value) {
            addCriterion("MODIFIEDTIME =", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotEqualTo(String value) {
            addCriterion("MODIFIEDTIME <>", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThan(String value) {
            addCriterion("MODIFIEDTIME >", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIEDTIME >=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThan(String value) {
            addCriterion("MODIFIEDTIME <", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLessThanOrEqualTo(String value) {
            addCriterion("MODIFIEDTIME <=", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeLike(String value) {
            addCriterion("MODIFIEDTIME like", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotLike(String value) {
            addCriterion("MODIFIEDTIME not like", value, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeIn(List<String> values) {
            addCriterion("MODIFIEDTIME in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotIn(List<String> values) {
            addCriterion("MODIFIEDTIME not in", values, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeBetween(String value1, String value2) {
            addCriterion("MODIFIEDTIME between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andModifiedtimeNotBetween(String value1, String value2) {
            addCriterion("MODIFIEDTIME not between", value1, value2, "modifiedtime");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("NUM is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("NUM is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(String value) {
            addCriterion("NUM =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(String value) {
            addCriterion("NUM <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(String value) {
            addCriterion("NUM >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(String value) {
            addCriterion("NUM >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(String value) {
            addCriterion("NUM <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(String value) {
            addCriterion("NUM <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLike(String value) {
            addCriterion("NUM like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotLike(String value) {
            addCriterion("NUM not like", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<String> values) {
            addCriterion("NUM in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<String> values) {
            addCriterion("NUM not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(String value1, String value2) {
            addCriterion("NUM between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(String value1, String value2) {
            addCriterion("NUM not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andQueueIsNull() {
            addCriterion("QUEUE is null");
            return (Criteria) this;
        }

        public Criteria andQueueIsNotNull() {
            addCriterion("QUEUE is not null");
            return (Criteria) this;
        }

        public Criteria andQueueEqualTo(String value) {
            addCriterion("QUEUE =", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotEqualTo(String value) {
            addCriterion("QUEUE <>", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueGreaterThan(String value) {
            addCriterion("QUEUE >", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueGreaterThanOrEqualTo(String value) {
            addCriterion("QUEUE >=", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLessThan(String value) {
            addCriterion("QUEUE <", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLessThanOrEqualTo(String value) {
            addCriterion("QUEUE <=", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueLike(String value) {
            addCriterion("QUEUE like", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotLike(String value) {
            addCriterion("QUEUE not like", value, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueIn(List<String> values) {
            addCriterion("QUEUE in", values, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotIn(List<String> values) {
            addCriterion("QUEUE not in", values, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueBetween(String value1, String value2) {
            addCriterion("QUEUE between", value1, value2, "queue");
            return (Criteria) this;
        }

        public Criteria andQueueNotBetween(String value1, String value2) {
            addCriterion("QUEUE not between", value1, value2, "queue");
            return (Criteria) this;
        }

        public Criteria andChecknumIsNull() {
            addCriterion("CHECKNUM is null");
            return (Criteria) this;
        }

        public Criteria andChecknumIsNotNull() {
            addCriterion("CHECKNUM is not null");
            return (Criteria) this;
        }

        public Criteria andChecknumEqualTo(String value) {
            addCriterion("CHECKNUM =", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotEqualTo(String value) {
            addCriterion("CHECKNUM <>", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumGreaterThan(String value) {
            addCriterion("CHECKNUM >", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumGreaterThanOrEqualTo(String value) {
            addCriterion("CHECKNUM >=", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLessThan(String value) {
            addCriterion("CHECKNUM <", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLessThanOrEqualTo(String value) {
            addCriterion("CHECKNUM <=", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumLike(String value) {
            addCriterion("CHECKNUM like", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotLike(String value) {
            addCriterion("CHECKNUM not like", value, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumIn(List<String> values) {
            addCriterion("CHECKNUM in", values, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotIn(List<String> values) {
            addCriterion("CHECKNUM not in", values, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumBetween(String value1, String value2) {
            addCriterion("CHECKNUM between", value1, value2, "checknum");
            return (Criteria) this;
        }

        public Criteria andChecknumNotBetween(String value1, String value2) {
            addCriterion("CHECKNUM not between", value1, value2, "checknum");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoIsNull() {
            addCriterion("ISVISITTWO is null");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoIsNotNull() {
            addCriterion("ISVISITTWO is not null");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoEqualTo(String value) {
            addCriterion("ISVISITTWO =", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoNotEqualTo(String value) {
            addCriterion("ISVISITTWO <>", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoGreaterThan(String value) {
            addCriterion("ISVISITTWO >", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoGreaterThanOrEqualTo(String value) {
            addCriterion("ISVISITTWO >=", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoLessThan(String value) {
            addCriterion("ISVISITTWO <", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoLessThanOrEqualTo(String value) {
            addCriterion("ISVISITTWO <=", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoLike(String value) {
            addCriterion("ISVISITTWO like", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoNotLike(String value) {
            addCriterion("ISVISITTWO not like", value, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoIn(List<String> values) {
            addCriterion("ISVISITTWO in", values, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoNotIn(List<String> values) {
            addCriterion("ISVISITTWO not in", values, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoBetween(String value1, String value2) {
            addCriterion("ISVISITTWO between", value1, value2, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andIsvisittwoNotBetween(String value1, String value2) {
            addCriterion("ISVISITTWO not between", value1, value2, "isvisittwo");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultIsNull() {
            addCriterion("FEEDBACKRESULT is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultIsNotNull() {
            addCriterion("FEEDBACKRESULT is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultEqualTo(String value) {
            addCriterion("FEEDBACKRESULT =", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultNotEqualTo(String value) {
            addCriterion("FEEDBACKRESULT <>", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultGreaterThan(String value) {
            addCriterion("FEEDBACKRESULT >", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACKRESULT >=", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultLessThan(String value) {
            addCriterion("FEEDBACKRESULT <", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACKRESULT <=", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultLike(String value) {
            addCriterion("FEEDBACKRESULT like", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultNotLike(String value) {
            addCriterion("FEEDBACKRESULT not like", value, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultIn(List<String> values) {
            addCriterion("FEEDBACKRESULT in", values, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultNotIn(List<String> values) {
            addCriterion("FEEDBACKRESULT not in", values, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultBetween(String value1, String value2) {
            addCriterion("FEEDBACKRESULT between", value1, value2, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackresultNotBetween(String value1, String value2) {
            addCriterion("FEEDBACKRESULT not between", value1, value2, "feedbackresult");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneIsNull() {
            addCriterion("FEEDBACKPHONE is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneIsNotNull() {
            addCriterion("FEEDBACKPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneEqualTo(String value) {
            addCriterion("FEEDBACKPHONE =", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneNotEqualTo(String value) {
            addCriterion("FEEDBACKPHONE <>", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneGreaterThan(String value) {
            addCriterion("FEEDBACKPHONE >", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneGreaterThanOrEqualTo(String value) {
            addCriterion("FEEDBACKPHONE >=", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneLessThan(String value) {
            addCriterion("FEEDBACKPHONE <", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneLessThanOrEqualTo(String value) {
            addCriterion("FEEDBACKPHONE <=", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneLike(String value) {
            addCriterion("FEEDBACKPHONE like", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneNotLike(String value) {
            addCriterion("FEEDBACKPHONE not like", value, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneIn(List<String> values) {
            addCriterion("FEEDBACKPHONE in", values, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneNotIn(List<String> values) {
            addCriterion("FEEDBACKPHONE not in", values, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneBetween(String value1, String value2) {
            addCriterion("FEEDBACKPHONE between", value1, value2, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andFeedbackphoneNotBetween(String value1, String value2) {
            addCriterion("FEEDBACKPHONE not between", value1, value2, "feedbackphone");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeIsNull() {
            addCriterion("RETURNVISITTIME is null");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeIsNotNull() {
            addCriterion("RETURNVISITTIME is not null");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeEqualTo(String value) {
            addCriterion("RETURNVISITTIME =", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeNotEqualTo(String value) {
            addCriterion("RETURNVISITTIME <>", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeGreaterThan(String value) {
            addCriterion("RETURNVISITTIME >", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeGreaterThanOrEqualTo(String value) {
            addCriterion("RETURNVISITTIME >=", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeLessThan(String value) {
            addCriterion("RETURNVISITTIME <", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeLessThanOrEqualTo(String value) {
            addCriterion("RETURNVISITTIME <=", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeLike(String value) {
            addCriterion("RETURNVISITTIME like", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeNotLike(String value) {
            addCriterion("RETURNVISITTIME not like", value, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeIn(List<String> values) {
            addCriterion("RETURNVISITTIME in", values, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeNotIn(List<String> values) {
            addCriterion("RETURNVISITTIME not in", values, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeBetween(String value1, String value2) {
            addCriterion("RETURNVISITTIME between", value1, value2, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andReturnvisittimeNotBetween(String value1, String value2) {
            addCriterion("RETURNVISITTIME not between", value1, value2, "returnvisittime");
            return (Criteria) this;
        }

        public Criteria andProblemtypeIsNull() {
            addCriterion("PROBLEMTYPE is null");
            return (Criteria) this;
        }

        public Criteria andProblemtypeIsNotNull() {
            addCriterion("PROBLEMTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andProblemtypeEqualTo(String value) {
            addCriterion("PROBLEMTYPE =", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeNotEqualTo(String value) {
            addCriterion("PROBLEMTYPE <>", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeGreaterThan(String value) {
            addCriterion("PROBLEMTYPE >", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeGreaterThanOrEqualTo(String value) {
            addCriterion("PROBLEMTYPE >=", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeLessThan(String value) {
            addCriterion("PROBLEMTYPE <", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeLessThanOrEqualTo(String value) {
            addCriterion("PROBLEMTYPE <=", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeLike(String value) {
            addCriterion("PROBLEMTYPE like", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeNotLike(String value) {
            addCriterion("PROBLEMTYPE not like", value, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeIn(List<String> values) {
            addCriterion("PROBLEMTYPE in", values, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeNotIn(List<String> values) {
            addCriterion("PROBLEMTYPE not in", values, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeBetween(String value1, String value2) {
            addCriterion("PROBLEMTYPE between", value1, value2, "problemtype");
            return (Criteria) this;
        }

        public Criteria andProblemtypeNotBetween(String value1, String value2) {
            addCriterion("PROBLEMTYPE not between", value1, value2, "problemtype");
            return (Criteria) this;
        }

        public Criteria andDisposetimeIsNull() {
            addCriterion("DISPOSETIME is null");
            return (Criteria) this;
        }

        public Criteria andDisposetimeIsNotNull() {
            addCriterion("DISPOSETIME is not null");
            return (Criteria) this;
        }

        public Criteria andDisposetimeEqualTo(String value) {
            addCriterion("DISPOSETIME =", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeNotEqualTo(String value) {
            addCriterion("DISPOSETIME <>", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeGreaterThan(String value) {
            addCriterion("DISPOSETIME >", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeGreaterThanOrEqualTo(String value) {
            addCriterion("DISPOSETIME >=", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeLessThan(String value) {
            addCriterion("DISPOSETIME <", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeLessThanOrEqualTo(String value) {
            addCriterion("DISPOSETIME <=", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeLike(String value) {
            addCriterion("DISPOSETIME like", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeNotLike(String value) {
            addCriterion("DISPOSETIME not like", value, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeIn(List<String> values) {
            addCriterion("DISPOSETIME in", values, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeNotIn(List<String> values) {
            addCriterion("DISPOSETIME not in", values, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeBetween(String value1, String value2) {
            addCriterion("DISPOSETIME between", value1, value2, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposetimeNotBetween(String value1, String value2) {
            addCriterion("DISPOSETIME not between", value1, value2, "disposetime");
            return (Criteria) this;
        }

        public Criteria andDisposeresultIsNull() {
            addCriterion("DISPOSERESULT is null");
            return (Criteria) this;
        }

        public Criteria andDisposeresultIsNotNull() {
            addCriterion("DISPOSERESULT is not null");
            return (Criteria) this;
        }

        public Criteria andDisposeresultEqualTo(String value) {
            addCriterion("DISPOSERESULT =", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultNotEqualTo(String value) {
            addCriterion("DISPOSERESULT <>", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultGreaterThan(String value) {
            addCriterion("DISPOSERESULT >", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultGreaterThanOrEqualTo(String value) {
            addCriterion("DISPOSERESULT >=", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultLessThan(String value) {
            addCriterion("DISPOSERESULT <", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultLessThanOrEqualTo(String value) {
            addCriterion("DISPOSERESULT <=", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultLike(String value) {
            addCriterion("DISPOSERESULT like", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultNotLike(String value) {
            addCriterion("DISPOSERESULT not like", value, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultIn(List<String> values) {
            addCriterion("DISPOSERESULT in", values, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultNotIn(List<String> values) {
            addCriterion("DISPOSERESULT not in", values, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultBetween(String value1, String value2) {
            addCriterion("DISPOSERESULT between", value1, value2, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andDisposeresultNotBetween(String value1, String value2) {
            addCriterion("DISPOSERESULT not between", value1, value2, "disposeresult");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeIsNull() {
            addCriterion("VISITTWOINSERTTIME is null");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeIsNotNull() {
            addCriterion("VISITTWOINSERTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeEqualTo(String value) {
            addCriterion("VISITTWOINSERTTIME =", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeNotEqualTo(String value) {
            addCriterion("VISITTWOINSERTTIME <>", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeGreaterThan(String value) {
            addCriterion("VISITTWOINSERTTIME >", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeGreaterThanOrEqualTo(String value) {
            addCriterion("VISITTWOINSERTTIME >=", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeLessThan(String value) {
            addCriterion("VISITTWOINSERTTIME <", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeLessThanOrEqualTo(String value) {
            addCriterion("VISITTWOINSERTTIME <=", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeLike(String value) {
            addCriterion("VISITTWOINSERTTIME like", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeNotLike(String value) {
            addCriterion("VISITTWOINSERTTIME not like", value, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeIn(List<String> values) {
            addCriterion("VISITTWOINSERTTIME in", values, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeNotIn(List<String> values) {
            addCriterion("VISITTWOINSERTTIME not in", values, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeBetween(String value1, String value2) {
            addCriterion("VISITTWOINSERTTIME between", value1, value2, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisittwoinserttimeNotBetween(String value1, String value2) {
            addCriterion("VISITTWOINSERTTIME not between", value1, value2, "visittwoinserttime");
            return (Criteria) this;
        }

        public Criteria andVisitcountIsNull() {
            addCriterion("VISITCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andVisitcountIsNotNull() {
            addCriterion("VISITCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andVisitcountEqualTo(String value) {
            addCriterion("VISITCOUNT =", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountNotEqualTo(String value) {
            addCriterion("VISITCOUNT <>", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountGreaterThan(String value) {
            addCriterion("VISITCOUNT >", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountGreaterThanOrEqualTo(String value) {
            addCriterion("VISITCOUNT >=", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountLessThan(String value) {
            addCriterion("VISITCOUNT <", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountLessThanOrEqualTo(String value) {
            addCriterion("VISITCOUNT <=", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountLike(String value) {
            addCriterion("VISITCOUNT like", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountNotLike(String value) {
            addCriterion("VISITCOUNT not like", value, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountIn(List<String> values) {
            addCriterion("VISITCOUNT in", values, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountNotIn(List<String> values) {
            addCriterion("VISITCOUNT not in", values, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountBetween(String value1, String value2) {
            addCriterion("VISITCOUNT between", value1, value2, "visitcount");
            return (Criteria) this;
        }

        public Criteria andVisitcountNotBetween(String value1, String value2) {
            addCriterion("VISITCOUNT not between", value1, value2, "visitcount");
            return (Criteria) this;
        }

        public Criteria andCalllostflagIsNull() {
            addCriterion("CALLLOSTFLAG is null");
            return (Criteria) this;
        }

        public Criteria andCalllostflagIsNotNull() {
            addCriterion("CALLLOSTFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCalllostflagEqualTo(String value) {
            addCriterion("CALLLOSTFLAG =", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagNotEqualTo(String value) {
            addCriterion("CALLLOSTFLAG <>", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagGreaterThan(String value) {
            addCriterion("CALLLOSTFLAG >", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagGreaterThanOrEqualTo(String value) {
            addCriterion("CALLLOSTFLAG >=", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagLessThan(String value) {
            addCriterion("CALLLOSTFLAG <", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagLessThanOrEqualTo(String value) {
            addCriterion("CALLLOSTFLAG <=", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagLike(String value) {
            addCriterion("CALLLOSTFLAG like", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagNotLike(String value) {
            addCriterion("CALLLOSTFLAG not like", value, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagIn(List<String> values) {
            addCriterion("CALLLOSTFLAG in", values, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagNotIn(List<String> values) {
            addCriterion("CALLLOSTFLAG not in", values, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagBetween(String value1, String value2) {
            addCriterion("CALLLOSTFLAG between", value1, value2, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andCalllostflagNotBetween(String value1, String value2) {
            addCriterion("CALLLOSTFLAG not between", value1, value2, "calllostflag");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultIsNull() {
            addCriterion("LASTVISITRESULT is null");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultIsNotNull() {
            addCriterion("LASTVISITRESULT is not null");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultEqualTo(String value) {
            addCriterion("LASTVISITRESULT =", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultNotEqualTo(String value) {
            addCriterion("LASTVISITRESULT <>", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultGreaterThan(String value) {
            addCriterion("LASTVISITRESULT >", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultGreaterThanOrEqualTo(String value) {
            addCriterion("LASTVISITRESULT >=", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultLessThan(String value) {
            addCriterion("LASTVISITRESULT <", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultLessThanOrEqualTo(String value) {
            addCriterion("LASTVISITRESULT <=", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultLike(String value) {
            addCriterion("LASTVISITRESULT like", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultNotLike(String value) {
            addCriterion("LASTVISITRESULT not like", value, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultIn(List<String> values) {
            addCriterion("LASTVISITRESULT in", values, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultNotIn(List<String> values) {
            addCriterion("LASTVISITRESULT not in", values, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultBetween(String value1, String value2) {
            addCriterion("LASTVISITRESULT between", value1, value2, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisitresultNotBetween(String value1, String value2) {
            addCriterion("LASTVISITRESULT not between", value1, value2, "lastvisitresult");
            return (Criteria) this;
        }

        public Criteria andLastvisituserIsNull() {
            addCriterion("LASTVISITUSER is null");
            return (Criteria) this;
        }

        public Criteria andLastvisituserIsNotNull() {
            addCriterion("LASTVISITUSER is not null");
            return (Criteria) this;
        }

        public Criteria andLastvisituserEqualTo(String value) {
            addCriterion("LASTVISITUSER =", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserNotEqualTo(String value) {
            addCriterion("LASTVISITUSER <>", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserGreaterThan(String value) {
            addCriterion("LASTVISITUSER >", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserGreaterThanOrEqualTo(String value) {
            addCriterion("LASTVISITUSER >=", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserLessThan(String value) {
            addCriterion("LASTVISITUSER <", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserLessThanOrEqualTo(String value) {
            addCriterion("LASTVISITUSER <=", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserLike(String value) {
            addCriterion("LASTVISITUSER like", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserNotLike(String value) {
            addCriterion("LASTVISITUSER not like", value, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserIn(List<String> values) {
            addCriterion("LASTVISITUSER in", values, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserNotIn(List<String> values) {
            addCriterion("LASTVISITUSER not in", values, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserBetween(String value1, String value2) {
            addCriterion("LASTVISITUSER between", value1, value2, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andLastvisituserNotBetween(String value1, String value2) {
            addCriterion("LASTVISITUSER not between", value1, value2, "lastvisituser");
            return (Criteria) this;
        }

        public Criteria andVisitagentidIsNull() {
            addCriterion("VISITAGENTID is null");
            return (Criteria) this;
        }

        public Criteria andVisitagentidIsNotNull() {
            addCriterion("VISITAGENTID is not null");
            return (Criteria) this;
        }

        public Criteria andVisitagentidEqualTo(String value) {
            addCriterion("VISITAGENTID =", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidNotEqualTo(String value) {
            addCriterion("VISITAGENTID <>", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidGreaterThan(String value) {
            addCriterion("VISITAGENTID >", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidGreaterThanOrEqualTo(String value) {
            addCriterion("VISITAGENTID >=", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidLessThan(String value) {
            addCriterion("VISITAGENTID <", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidLessThanOrEqualTo(String value) {
            addCriterion("VISITAGENTID <=", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidLike(String value) {
            addCriterion("VISITAGENTID like", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidNotLike(String value) {
            addCriterion("VISITAGENTID not like", value, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidIn(List<String> values) {
            addCriterion("VISITAGENTID in", values, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidNotIn(List<String> values) {
            addCriterion("VISITAGENTID not in", values, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidBetween(String value1, String value2) {
            addCriterion("VISITAGENTID between", value1, value2, "visitagentid");
            return (Criteria) this;
        }

        public Criteria andVisitagentidNotBetween(String value1, String value2) {
            addCriterion("VISITAGENTID not between", value1, value2, "visitagentid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}