package com.cpt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventResponseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventResponseExample() {
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

        public Criteria andEventIdIsNull() {
            addCriterion("event_id is null");
            return (Criteria) this;
        }

        public Criteria andEventIdIsNotNull() {
            addCriterion("event_id is not null");
            return (Criteria) this;
        }

        public Criteria andEventIdEqualTo(Integer value) {
            addCriterion("event_id =", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotEqualTo(Integer value) {
            addCriterion("event_id <>", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThan(Integer value) {
            addCriterion("event_id >", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_id >=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThan(Integer value) {
            addCriterion("event_id <", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdLessThanOrEqualTo(Integer value) {
            addCriterion("event_id <=", value, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdIn(List<Integer> values) {
            addCriterion("event_id in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotIn(List<Integer> values) {
            addCriterion("event_id not in", values, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdBetween(Integer value1, Integer value2) {
            addCriterion("event_id between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andEventIdNotBetween(Integer value1, Integer value2) {
            addCriterion("event_id not between", value1, value2, "eventId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIsNull() {
            addCriterion("resp_department is null");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIsNotNull() {
            addCriterion("resp_department is not null");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentEqualTo(String value) {
            addCriterion("resp_department =", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentNotEqualTo(String value) {
            addCriterion("resp_department <>", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentGreaterThan(String value) {
            addCriterion("resp_department >", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("resp_department >=", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentLessThan(String value) {
            addCriterion("resp_department <", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentLessThanOrEqualTo(String value) {
            addCriterion("resp_department <=", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentLike(String value) {
            addCriterion("resp_department like", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentNotLike(String value) {
            addCriterion("resp_department not like", value, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIn(List<String> values) {
            addCriterion("resp_department in", values, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentNotIn(List<String> values) {
            addCriterion("resp_department not in", values, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentBetween(String value1, String value2) {
            addCriterion("resp_department between", value1, value2, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentNotBetween(String value1, String value2) {
            addCriterion("resp_department not between", value1, value2, "respDepartment");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdIsNull() {
            addCriterion("resp_department_id is null");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdIsNotNull() {
            addCriterion("resp_department_id is not null");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdEqualTo(Long value) {
            addCriterion("resp_department_id =", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdNotEqualTo(Long value) {
            addCriterion("resp_department_id <>", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdGreaterThan(Long value) {
            addCriterion("resp_department_id >", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("resp_department_id >=", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdLessThan(Long value) {
            addCriterion("resp_department_id <", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdLessThanOrEqualTo(Long value) {
            addCriterion("resp_department_id <=", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdIn(List<Long> values) {
            addCriterion("resp_department_id in", values, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdNotIn(List<Long> values) {
            addCriterion("resp_department_id not in", values, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdBetween(Long value1, Long value2) {
            addCriterion("resp_department_id between", value1, value2, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdNotBetween(Long value1, Long value2) {
            addCriterion("resp_department_id not between", value1, value2, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIsNull() {
            addCriterion("responsible is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleIsNotNull() {
            addCriterion("responsible is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleEqualTo(String value) {
            addCriterion("responsible =", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotEqualTo(String value) {
            addCriterion("responsible <>", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleGreaterThan(String value) {
            addCriterion("responsible >", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleGreaterThanOrEqualTo(String value) {
            addCriterion("responsible >=", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleLessThan(String value) {
            addCriterion("responsible <", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleLessThanOrEqualTo(String value) {
            addCriterion("responsible <=", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleLike(String value) {
            addCriterion("responsible like", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotLike(String value) {
            addCriterion("responsible not like", value, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleIn(List<String> values) {
            addCriterion("responsible in", values, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotIn(List<String> values) {
            addCriterion("responsible not in", values, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleBetween(String value1, String value2) {
            addCriterion("responsible between", value1, value2, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleNotBetween(String value1, String value2) {
            addCriterion("responsible not between", value1, value2, "responsible");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIsNull() {
            addCriterion("responsible_id is null");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIsNotNull() {
            addCriterion("responsible_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdEqualTo(Long value) {
            addCriterion("responsible_id =", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotEqualTo(Long value) {
            addCriterion("responsible_id <>", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdGreaterThan(Long value) {
            addCriterion("responsible_id >", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("responsible_id >=", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLessThan(Long value) {
            addCriterion("responsible_id <", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLessThanOrEqualTo(Long value) {
            addCriterion("responsible_id <=", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIn(List<Long> values) {
            addCriterion("responsible_id in", values, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotIn(List<Long> values) {
            addCriterion("responsible_id not in", values, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdBetween(Long value1, Long value2) {
            addCriterion("responsible_id between", value1, value2, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotBetween(Long value1, Long value2) {
            addCriterion("responsible_id not between", value1, value2, "responsibleId");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
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