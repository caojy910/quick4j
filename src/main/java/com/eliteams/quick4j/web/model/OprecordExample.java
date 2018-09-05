package com.eliteams.quick4j.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OprecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OprecordExample() {
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

        public Criteria andOpengineerIsNull() {
            addCriterion("opengineer is null");
            return (Criteria) this;
        }

        public Criteria andOpengineerIsNotNull() {
            addCriterion("opengineer is not null");
            return (Criteria) this;
        }

        public Criteria andOpengineerEqualTo(Long value) {
            addCriterion("opengineer =", value, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerNotEqualTo(Long value) {
            addCriterion("opengineer <>", value, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerGreaterThan(Long value) {
            addCriterion("opengineer >", value, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerGreaterThanOrEqualTo(Long value) {
            addCriterion("opengineer >=", value, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerLessThan(Long value) {
            addCriterion("opengineer <", value, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerLessThanOrEqualTo(Long value) {
            addCriterion("opengineer <=", value, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerIn(List<Long> values) {
            addCriterion("opengineer in", values, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerNotIn(List<Long> values) {
            addCriterion("opengineer not in", values, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerBetween(Long value1, Long value2) {
            addCriterion("opengineer between", value1, value2, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpengineerNotBetween(Long value1, Long value2) {
            addCriterion("opengineer not between", value1, value2, "opengineer");
            return (Criteria) this;
        }

        public Criteria andOpdateIsNull() {
            addCriterion("opdate is null");
            return (Criteria) this;
        }

        public Criteria andOpdateIsNotNull() {
            addCriterion("opdate is not null");
            return (Criteria) this;
        }

        public Criteria andOpdateEqualTo(Date value) {
            addCriterion("opdate =", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateNotEqualTo(Date value) {
            addCriterion("opdate <>", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateGreaterThan(Date value) {
            addCriterion("opdate >", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("opdate >=", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateLessThan(Date value) {
            addCriterion("opdate <", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateLessThanOrEqualTo(Date value) {
            addCriterion("opdate <=", value, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateIn(List<Date> values) {
            addCriterion("opdate in", values, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateNotIn(List<Date> values) {
            addCriterion("opdate not in", values, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateBetween(Date value1, Date value2) {
            addCriterion("opdate between", value1, value2, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpdateNotBetween(Date value1, Date value2) {
            addCriterion("opdate not between", value1, value2, "opdate");
            return (Criteria) this;
        }

        public Criteria andOpcontentIsNull() {
            addCriterion("opcontent is null");
            return (Criteria) this;
        }

        public Criteria andOpcontentIsNotNull() {
            addCriterion("opcontent is not null");
            return (Criteria) this;
        }

        public Criteria andOpcontentEqualTo(String value) {
            addCriterion("opcontent =", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentNotEqualTo(String value) {
            addCriterion("opcontent <>", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentGreaterThan(String value) {
            addCriterion("opcontent >", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentGreaterThanOrEqualTo(String value) {
            addCriterion("opcontent >=", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentLessThan(String value) {
            addCriterion("opcontent <", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentLessThanOrEqualTo(String value) {
            addCriterion("opcontent <=", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentLike(String value) {
            addCriterion("opcontent like", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentNotLike(String value) {
            addCriterion("opcontent not like", value, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentIn(List<String> values) {
            addCriterion("opcontent in", values, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentNotIn(List<String> values) {
            addCriterion("opcontent not in", values, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentBetween(String value1, String value2) {
            addCriterion("opcontent between", value1, value2, "opcontent");
            return (Criteria) this;
        }

        public Criteria andOpcontentNotBetween(String value1, String value2) {
            addCriterion("opcontent not between", value1, value2, "opcontent");
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