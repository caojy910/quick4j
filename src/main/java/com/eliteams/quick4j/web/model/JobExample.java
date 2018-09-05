package com.eliteams.quick4j.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDeciveidIsNull() {
            addCriterion("deciveid is null");
            return (Criteria) this;
        }

        public Criteria andDeciveidIsNotNull() {
            addCriterion("deciveid is not null");
            return (Criteria) this;
        }

        public Criteria andDeciveidEqualTo(Long value) {
            addCriterion("deciveid =", value, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidNotEqualTo(Long value) {
            addCriterion("deciveid <>", value, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidGreaterThan(Long value) {
            addCriterion("deciveid >", value, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidGreaterThanOrEqualTo(Long value) {
            addCriterion("deciveid >=", value, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidLessThan(Long value) {
            addCriterion("deciveid <", value, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidLessThanOrEqualTo(Long value) {
            addCriterion("deciveid <=", value, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidIn(List<Long> values) {
            addCriterion("deciveid in", values, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidNotIn(List<Long> values) {
            addCriterion("deciveid not in", values, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidBetween(Long value1, Long value2) {
            addCriterion("deciveid between", value1, value2, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDeciveidNotBetween(Long value1, Long value2) {
            addCriterion("deciveid not between", value1, value2, "deciveid");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLastsuggestIsNull() {
            addCriterion("lastsuggest is null");
            return (Criteria) this;
        }

        public Criteria andLastsuggestIsNotNull() {
            addCriterion("lastsuggest is not null");
            return (Criteria) this;
        }

        public Criteria andLastsuggestEqualTo(String value) {
            addCriterion("lastsuggest =", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestNotEqualTo(String value) {
            addCriterion("lastsuggest <>", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestGreaterThan(String value) {
            addCriterion("lastsuggest >", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestGreaterThanOrEqualTo(String value) {
            addCriterion("lastsuggest >=", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestLessThan(String value) {
            addCriterion("lastsuggest <", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestLessThanOrEqualTo(String value) {
            addCriterion("lastsuggest <=", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestLike(String value) {
            addCriterion("lastsuggest like", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestNotLike(String value) {
            addCriterion("lastsuggest not like", value, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestIn(List<String> values) {
            addCriterion("lastsuggest in", values, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestNotIn(List<String> values) {
            addCriterion("lastsuggest not in", values, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestBetween(String value1, String value2) {
            addCriterion("lastsuggest between", value1, value2, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLastsuggestNotBetween(String value1, String value2) {
            addCriterion("lastsuggest not between", value1, value2, "lastsuggest");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridIsNull() {
            addCriterion("localengineerid is null");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridIsNotNull() {
            addCriterion("localengineerid is not null");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridEqualTo(Long value) {
            addCriterion("localengineerid =", value, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridNotEqualTo(Long value) {
            addCriterion("localengineerid <>", value, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridGreaterThan(Long value) {
            addCriterion("localengineerid >", value, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridGreaterThanOrEqualTo(Long value) {
            addCriterion("localengineerid >=", value, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridLessThan(Long value) {
            addCriterion("localengineerid <", value, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridLessThanOrEqualTo(Long value) {
            addCriterion("localengineerid <=", value, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridIn(List<Long> values) {
            addCriterion("localengineerid in", values, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridNotIn(List<Long> values) {
            addCriterion("localengineerid not in", values, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridBetween(Long value1, Long value2) {
            addCriterion("localengineerid between", value1, value2, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andLocalengineeridNotBetween(Long value1, Long value2) {
            addCriterion("localengineerid not between", value1, value2, "localengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridIsNull() {
            addCriterion("remoteengineerid is null");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridIsNotNull() {
            addCriterion("remoteengineerid is not null");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridEqualTo(Long value) {
            addCriterion("remoteengineerid =", value, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridNotEqualTo(Long value) {
            addCriterion("remoteengineerid <>", value, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridGreaterThan(Long value) {
            addCriterion("remoteengineerid >", value, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridGreaterThanOrEqualTo(Long value) {
            addCriterion("remoteengineerid >=", value, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridLessThan(Long value) {
            addCriterion("remoteengineerid <", value, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridLessThanOrEqualTo(Long value) {
            addCriterion("remoteengineerid <=", value, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridIn(List<Long> values) {
            addCriterion("remoteengineerid in", values, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridNotIn(List<Long> values) {
            addCriterion("remoteengineerid not in", values, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridBetween(Long value1, Long value2) {
            addCriterion("remoteengineerid between", value1, value2, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andRemoteengineeridNotBetween(Long value1, Long value2) {
            addCriterion("remoteengineerid not between", value1, value2, "remoteengineerid");
            return (Criteria) this;
        }

        public Criteria andDevicestateIsNull() {
            addCriterion("devicestate is null");
            return (Criteria) this;
        }

        public Criteria andDevicestateIsNotNull() {
            addCriterion("devicestate is not null");
            return (Criteria) this;
        }

        public Criteria andDevicestateEqualTo(Integer value) {
            addCriterion("devicestate =", value, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateNotEqualTo(Integer value) {
            addCriterion("devicestate <>", value, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateGreaterThan(Integer value) {
            addCriterion("devicestate >", value, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("devicestate >=", value, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateLessThan(Integer value) {
            addCriterion("devicestate <", value, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateLessThanOrEqualTo(Integer value) {
            addCriterion("devicestate <=", value, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateIn(List<Integer> values) {
            addCriterion("devicestate in", values, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateNotIn(List<Integer> values) {
            addCriterion("devicestate not in", values, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateBetween(Integer value1, Integer value2) {
            addCriterion("devicestate between", value1, value2, "devicestate");
            return (Criteria) this;
        }

        public Criteria andDevicestateNotBetween(Integer value1, Integer value2) {
            addCriterion("devicestate not between", value1, value2, "devicestate");
            return (Criteria) this;
        }

        public Criteria andJobstateIsNull() {
            addCriterion("jobstate is null");
            return (Criteria) this;
        }

        public Criteria andJobstateIsNotNull() {
            addCriterion("jobstate is not null");
            return (Criteria) this;
        }

        public Criteria andJobstateEqualTo(Integer value) {
            addCriterion("jobstate =", value, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateNotEqualTo(Integer value) {
            addCriterion("jobstate <>", value, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateGreaterThan(Integer value) {
            addCriterion("jobstate >", value, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("jobstate >=", value, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateLessThan(Integer value) {
            addCriterion("jobstate <", value, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateLessThanOrEqualTo(Integer value) {
            addCriterion("jobstate <=", value, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateIn(List<Integer> values) {
            addCriterion("jobstate in", values, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateNotIn(List<Integer> values) {
            addCriterion("jobstate not in", values, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateBetween(Integer value1, Integer value2) {
            addCriterion("jobstate between", value1, value2, "jobstate");
            return (Criteria) this;
        }

        public Criteria andJobstateNotBetween(Integer value1, Integer value2) {
            addCriterion("jobstate not between", value1, value2, "jobstate");
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