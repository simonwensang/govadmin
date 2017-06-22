package com.cpt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EventExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNull() {
            addCriterion("community is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIsNotNull() {
            addCriterion("community is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityEqualTo(String value) {
            addCriterion("community =", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotEqualTo(String value) {
            addCriterion("community <>", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThan(String value) {
            addCriterion("community >", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityGreaterThanOrEqualTo(String value) {
            addCriterion("community >=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThan(String value) {
            addCriterion("community <", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLessThanOrEqualTo(String value) {
            addCriterion("community <=", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityLike(String value) {
            addCriterion("community like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotLike(String value) {
            addCriterion("community not like", value, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityIn(List<String> values) {
            addCriterion("community in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotIn(List<String> values) {
            addCriterion("community not in", values, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityBetween(String value1, String value2) {
            addCriterion("community between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityNotBetween(String value1, String value2) {
            addCriterion("community not between", value1, value2, "community");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Integer value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Integer value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Integer value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Integer value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Integer> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Integer> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andWindowIsNull() {
            addCriterion("window is null");
            return (Criteria) this;
        }

        public Criteria andWindowIsNotNull() {
            addCriterion("window is not null");
            return (Criteria) this;
        }

        public Criteria andWindowEqualTo(String value) {
            addCriterion("window =", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotEqualTo(String value) {
            addCriterion("window <>", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowGreaterThan(String value) {
            addCriterion("window >", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowGreaterThanOrEqualTo(String value) {
            addCriterion("window >=", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLessThan(String value) {
            addCriterion("window <", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLessThanOrEqualTo(String value) {
            addCriterion("window <=", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLike(String value) {
            addCriterion("window like", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotLike(String value) {
            addCriterion("window not like", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowIn(List<String> values) {
            addCriterion("window in", values, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotIn(List<String> values) {
            addCriterion("window not in", values, "window");
            return (Criteria) this;
        }

        public Criteria andWindowBetween(String value1, String value2) {
            addCriterion("window between", value1, value2, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotBetween(String value1, String value2) {
            addCriterion("window not between", value1, value2, "window");
            return (Criteria) this;
        }

        public Criteria andWindowIdIsNull() {
            addCriterion("window_id is null");
            return (Criteria) this;
        }

        public Criteria andWindowIdIsNotNull() {
            addCriterion("window_id is not null");
            return (Criteria) this;
        }

        public Criteria andWindowIdEqualTo(Integer value) {
            addCriterion("window_id =", value, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdNotEqualTo(Integer value) {
            addCriterion("window_id <>", value, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdGreaterThan(Integer value) {
            addCriterion("window_id >", value, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("window_id >=", value, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdLessThan(Integer value) {
            addCriterion("window_id <", value, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdLessThanOrEqualTo(Integer value) {
            addCriterion("window_id <=", value, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdIn(List<Integer> values) {
            addCriterion("window_id in", values, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdNotIn(List<Integer> values) {
            addCriterion("window_id not in", values, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdBetween(Integer value1, Integer value2) {
            addCriterion("window_id between", value1, value2, "windowId");
            return (Criteria) this;
        }

        public Criteria andWindowIdNotBetween(Integer value1, Integer value2) {
            addCriterion("window_id not between", value1, value2, "windowId");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAppellantIsNull() {
            addCriterion("appellant is null");
            return (Criteria) this;
        }

        public Criteria andAppellantIsNotNull() {
            addCriterion("appellant is not null");
            return (Criteria) this;
        }

        public Criteria andAppellantEqualTo(String value) {
            addCriterion("appellant =", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantNotEqualTo(String value) {
            addCriterion("appellant <>", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantGreaterThan(String value) {
            addCriterion("appellant >", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantGreaterThanOrEqualTo(String value) {
            addCriterion("appellant >=", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantLessThan(String value) {
            addCriterion("appellant <", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantLessThanOrEqualTo(String value) {
            addCriterion("appellant <=", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantLike(String value) {
            addCriterion("appellant like", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantNotLike(String value) {
            addCriterion("appellant not like", value, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantIn(List<String> values) {
            addCriterion("appellant in", values, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantNotIn(List<String> values) {
            addCriterion("appellant not in", values, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantBetween(String value1, String value2) {
            addCriterion("appellant between", value1, value2, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantNotBetween(String value1, String value2) {
            addCriterion("appellant not between", value1, value2, "appellant");
            return (Criteria) this;
        }

        public Criteria andAppellantTelIsNull() {
            addCriterion("appellant_tel is null");
            return (Criteria) this;
        }

        public Criteria andAppellantTelIsNotNull() {
            addCriterion("appellant_tel is not null");
            return (Criteria) this;
        }

        public Criteria andAppellantTelEqualTo(String value) {
            addCriterion("appellant_tel =", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelNotEqualTo(String value) {
            addCriterion("appellant_tel <>", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelGreaterThan(String value) {
            addCriterion("appellant_tel >", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelGreaterThanOrEqualTo(String value) {
            addCriterion("appellant_tel >=", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelLessThan(String value) {
            addCriterion("appellant_tel <", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelLessThanOrEqualTo(String value) {
            addCriterion("appellant_tel <=", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelLike(String value) {
            addCriterion("appellant_tel like", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelNotLike(String value) {
            addCriterion("appellant_tel not like", value, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelIn(List<String> values) {
            addCriterion("appellant_tel in", values, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelNotIn(List<String> values) {
            addCriterion("appellant_tel not in", values, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelBetween(String value1, String value2) {
            addCriterion("appellant_tel between", value1, value2, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantTelNotBetween(String value1, String value2) {
            addCriterion("appellant_tel not between", value1, value2, "appellantTel");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkIsNull() {
            addCriterion("appellant_remark is null");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkIsNotNull() {
            addCriterion("appellant_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkEqualTo(String value) {
            addCriterion("appellant_remark =", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkNotEqualTo(String value) {
            addCriterion("appellant_remark <>", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkGreaterThan(String value) {
            addCriterion("appellant_remark >", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("appellant_remark >=", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkLessThan(String value) {
            addCriterion("appellant_remark <", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkLessThanOrEqualTo(String value) {
            addCriterion("appellant_remark <=", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkLike(String value) {
            addCriterion("appellant_remark like", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkNotLike(String value) {
            addCriterion("appellant_remark not like", value, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkIn(List<String> values) {
            addCriterion("appellant_remark in", values, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkNotIn(List<String> values) {
            addCriterion("appellant_remark not in", values, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkBetween(String value1, String value2) {
            addCriterion("appellant_remark between", value1, value2, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andAppellantRemarkNotBetween(String value1, String value2) {
            addCriterion("appellant_remark not between", value1, value2, "appellantRemark");
            return (Criteria) this;
        }

        public Criteria andEventNoIsNull() {
            addCriterion("event_no is null");
            return (Criteria) this;
        }

        public Criteria andEventNoIsNotNull() {
            addCriterion("event_no is not null");
            return (Criteria) this;
        }

        public Criteria andEventNoEqualTo(String value) {
            addCriterion("event_no =", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoNotEqualTo(String value) {
            addCriterion("event_no <>", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoGreaterThan(String value) {
            addCriterion("event_no >", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoGreaterThanOrEqualTo(String value) {
            addCriterion("event_no >=", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoLessThan(String value) {
            addCriterion("event_no <", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoLessThanOrEqualTo(String value) {
            addCriterion("event_no <=", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoLike(String value) {
            addCriterion("event_no like", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoNotLike(String value) {
            addCriterion("event_no not like", value, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoIn(List<String> values) {
            addCriterion("event_no in", values, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoNotIn(List<String> values) {
            addCriterion("event_no not in", values, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoBetween(String value1, String value2) {
            addCriterion("event_no between", value1, value2, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventNoNotBetween(String value1, String value2) {
            addCriterion("event_no not between", value1, value2, "eventNo");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("event_type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("event_type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(Byte value) {
            addCriterion("event_type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(Byte value) {
            addCriterion("event_type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(Byte value) {
            addCriterion("event_type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("event_type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(Byte value) {
            addCriterion("event_type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(Byte value) {
            addCriterion("event_type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<Byte> values) {
            addCriterion("event_type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<Byte> values) {
            addCriterion("event_type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(Byte value1, Byte value2) {
            addCriterion("event_type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("event_type not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (Criteria) this;
        }

        public Criteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (Criteria) this;
        }

        public Criteria andReportTimeEqualTo(String value) {
            addCriterion("report_time =", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotEqualTo(String value) {
            addCriterion("report_time <>", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThan(String value) {
            addCriterion("report_time >", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("report_time >=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThan(String value) {
            addCriterion("report_time <", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLessThanOrEqualTo(String value) {
            addCriterion("report_time <=", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeLike(String value) {
            addCriterion("report_time like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotLike(String value) {
            addCriterion("report_time not like", value, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeIn(List<String> values) {
            addCriterion("report_time in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotIn(List<String> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeBetween(String value1, String value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andReportTimeNotBetween(String value1, String value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Byte value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Byte value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Byte value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Byte value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Byte value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Byte value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Byte> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Byte> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Byte value1, Byte value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Byte value1, Byte value2) {
            addCriterion("grade not between", value1, value2, "grade");
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

        public Criteria andAttachmentIsNull() {
            addCriterion("attachment is null");
            return (Criteria) this;
        }

        public Criteria andAttachmentIsNotNull() {
            addCriterion("attachment is not null");
            return (Criteria) this;
        }

        public Criteria andAttachmentEqualTo(String value) {
            addCriterion("attachment =", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotEqualTo(String value) {
            addCriterion("attachment <>", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThan(String value) {
            addCriterion("attachment >", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentGreaterThanOrEqualTo(String value) {
            addCriterion("attachment >=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThan(String value) {
            addCriterion("attachment <", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLessThanOrEqualTo(String value) {
            addCriterion("attachment <=", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentLike(String value) {
            addCriterion("attachment like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotLike(String value) {
            addCriterion("attachment not like", value, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentIn(List<String> values) {
            addCriterion("attachment in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotIn(List<String> values) {
            addCriterion("attachment not in", values, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentBetween(String value1, String value2) {
            addCriterion("attachment between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andAttachmentNotBetween(String value1, String value2) {
            addCriterion("attachment not between", value1, value2, "attachment");
            return (Criteria) this;
        }

        public Criteria andCommitUserIsNull() {
            addCriterion("commit_user is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIsNotNull() {
            addCriterion("commit_user is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserEqualTo(String value) {
            addCriterion("commit_user =", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotEqualTo(String value) {
            addCriterion("commit_user <>", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserGreaterThan(String value) {
            addCriterion("commit_user >", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserGreaterThanOrEqualTo(String value) {
            addCriterion("commit_user >=", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLessThan(String value) {
            addCriterion("commit_user <", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLessThanOrEqualTo(String value) {
            addCriterion("commit_user <=", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLike(String value) {
            addCriterion("commit_user like", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotLike(String value) {
            addCriterion("commit_user not like", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserIn(List<String> values) {
            addCriterion("commit_user in", values, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotIn(List<String> values) {
            addCriterion("commit_user not in", values, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserBetween(String value1, String value2) {
            addCriterion("commit_user between", value1, value2, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotBetween(String value1, String value2) {
            addCriterion("commit_user not between", value1, value2, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNull() {
            addCriterion("commit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNotNull() {
            addCriterion("commit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdEqualTo(Integer value) {
            addCriterion("commit_user_id =", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotEqualTo(Integer value) {
            addCriterion("commit_user_id <>", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThan(Integer value) {
            addCriterion("commit_user_id >", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commit_user_id >=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThan(Integer value) {
            addCriterion("commit_user_id <", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("commit_user_id <=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIn(List<Integer> values) {
            addCriterion("commit_user_id in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotIn(List<Integer> values) {
            addCriterion("commit_user_id not in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdBetween(Integer value1, Integer value2) {
            addCriterion("commit_user_id between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commit_user_id not between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("commit_time is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("commit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Date value) {
            addCriterion("commit_time =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Date value) {
            addCriterion("commit_time <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Date value) {
            addCriterion("commit_time >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commit_time >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Date value) {
            addCriterion("commit_time <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("commit_time <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Date> values) {
            addCriterion("commit_time in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Date> values) {
            addCriterion("commit_time not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Date value1, Date value2) {
            addCriterion("commit_time between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("commit_time not between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNull() {
            addCriterion("auditor is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIsNotNull() {
            addCriterion("auditor is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorEqualTo(String value) {
            addCriterion("auditor =", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotEqualTo(String value) {
            addCriterion("auditor <>", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThan(String value) {
            addCriterion("auditor >", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorGreaterThanOrEqualTo(String value) {
            addCriterion("auditor >=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThan(String value) {
            addCriterion("auditor <", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLessThanOrEqualTo(String value) {
            addCriterion("auditor <=", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorLike(String value) {
            addCriterion("auditor like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotLike(String value) {
            addCriterion("auditor not like", value, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIn(List<String> values) {
            addCriterion("auditor in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotIn(List<String> values) {
            addCriterion("auditor not in", values, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorBetween(String value1, String value2) {
            addCriterion("auditor between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorNotBetween(String value1, String value2) {
            addCriterion("auditor not between", value1, value2, "auditor");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIsNull() {
            addCriterion("auditor_id is null");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIsNotNull() {
            addCriterion("auditor_id is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorIdEqualTo(Integer value) {
            addCriterion("auditor_id =", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotEqualTo(Integer value) {
            addCriterion("auditor_id <>", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdGreaterThan(Integer value) {
            addCriterion("auditor_id >", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditor_id >=", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLessThan(Integer value) {
            addCriterion("auditor_id <", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdLessThanOrEqualTo(Integer value) {
            addCriterion("auditor_id <=", value, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdIn(List<Integer> values) {
            addCriterion("auditor_id in", values, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotIn(List<Integer> values) {
            addCriterion("auditor_id not in", values, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdBetween(Integer value1, Integer value2) {
            addCriterion("auditor_id between", value1, value2, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("auditor_id not between", value1, value2, "auditorId");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeIsNull() {
            addCriterion("auditor_time is null");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeIsNotNull() {
            addCriterion("auditor_time is not null");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeEqualTo(Date value) {
            addCriterion("auditor_time =", value, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeNotEqualTo(Date value) {
            addCriterion("auditor_time <>", value, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeGreaterThan(Date value) {
            addCriterion("auditor_time >", value, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auditor_time >=", value, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeLessThan(Date value) {
            addCriterion("auditor_time <", value, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeLessThanOrEqualTo(Date value) {
            addCriterion("auditor_time <=", value, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeIn(List<Date> values) {
            addCriterion("auditor_time in", values, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeNotIn(List<Date> values) {
            addCriterion("auditor_time not in", values, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeBetween(Date value1, Date value2) {
            addCriterion("auditor_time between", value1, value2, "auditorTime");
            return (Criteria) this;
        }

        public Criteria andAuditorTimeNotBetween(Date value1, Date value2) {
            addCriterion("auditor_time not between", value1, value2, "auditorTime");
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

        public Criteria andRespDepartmentIdEqualTo(Integer value) {
            addCriterion("resp_department_id =", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdNotEqualTo(Integer value) {
            addCriterion("resp_department_id <>", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdGreaterThan(Integer value) {
            addCriterion("resp_department_id >", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("resp_department_id >=", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdLessThan(Integer value) {
            addCriterion("resp_department_id <", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("resp_department_id <=", value, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdIn(List<Integer> values) {
            addCriterion("resp_department_id in", values, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdNotIn(List<Integer> values) {
            addCriterion("resp_department_id not in", values, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdBetween(Integer value1, Integer value2) {
            addCriterion("resp_department_id between", value1, value2, "respDepartmentId");
            return (Criteria) this;
        }

        public Criteria andRespDepartmentIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andResponsibleIdEqualTo(Integer value) {
            addCriterion("responsible_id =", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotEqualTo(Integer value) {
            addCriterion("responsible_id <>", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdGreaterThan(Integer value) {
            addCriterion("responsible_id >", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("responsible_id >=", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLessThan(Integer value) {
            addCriterion("responsible_id <", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdLessThanOrEqualTo(Integer value) {
            addCriterion("responsible_id <=", value, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdIn(List<Integer> values) {
            addCriterion("responsible_id in", values, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotIn(List<Integer> values) {
            addCriterion("responsible_id not in", values, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdBetween(Integer value1, Integer value2) {
            addCriterion("responsible_id between", value1, value2, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andResponsibleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("responsible_id not between", value1, value2, "responsibleId");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNull() {
            addCriterion("expiry_date is null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNotNull() {
            addCriterion("expiry_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateEqualTo(String value) {
            addCriterion("expiry_date =", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotEqualTo(String value) {
            addCriterion("expiry_date <>", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThan(String value) {
            addCriterion("expiry_date >", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThanOrEqualTo(String value) {
            addCriterion("expiry_date >=", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThan(String value) {
            addCriterion("expiry_date <", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThanOrEqualTo(String value) {
            addCriterion("expiry_date <=", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLike(String value) {
            addCriterion("expiry_date like", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotLike(String value) {
            addCriterion("expiry_date not like", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIn(List<String> values) {
            addCriterion("expiry_date in", values, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotIn(List<String> values) {
            addCriterion("expiry_date not in", values, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateBetween(String value1, String value2) {
            addCriterion("expiry_date between", value1, value2, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotBetween(String value1, String value2) {
            addCriterion("expiry_date not between", value1, value2, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andRequestIsNull() {
            addCriterion("request is null");
            return (Criteria) this;
        }

        public Criteria andRequestIsNotNull() {
            addCriterion("request is not null");
            return (Criteria) this;
        }

        public Criteria andRequestEqualTo(String value) {
            addCriterion("request =", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotEqualTo(String value) {
            addCriterion("request <>", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestGreaterThan(String value) {
            addCriterion("request >", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestGreaterThanOrEqualTo(String value) {
            addCriterion("request >=", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLessThan(String value) {
            addCriterion("request <", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLessThanOrEqualTo(String value) {
            addCriterion("request <=", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestLike(String value) {
            addCriterion("request like", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotLike(String value) {
            addCriterion("request not like", value, "request");
            return (Criteria) this;
        }

        public Criteria andRequestIn(List<String> values) {
            addCriterion("request in", values, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotIn(List<String> values) {
            addCriterion("request not in", values, "request");
            return (Criteria) this;
        }

        public Criteria andRequestBetween(String value1, String value2) {
            addCriterion("request between", value1, value2, "request");
            return (Criteria) this;
        }

        public Criteria andRequestNotBetween(String value1, String value2) {
            addCriterion("request not between", value1, value2, "request");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkIsNull() {
            addCriterion("audit_remark is null");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkIsNotNull() {
            addCriterion("audit_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkEqualTo(String value) {
            addCriterion("audit_remark =", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkNotEqualTo(String value) {
            addCriterion("audit_remark <>", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkGreaterThan(String value) {
            addCriterion("audit_remark >", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("audit_remark >=", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkLessThan(String value) {
            addCriterion("audit_remark <", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkLessThanOrEqualTo(String value) {
            addCriterion("audit_remark <=", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkLike(String value) {
            addCriterion("audit_remark like", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkNotLike(String value) {
            addCriterion("audit_remark not like", value, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkIn(List<String> values) {
            addCriterion("audit_remark in", values, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkNotIn(List<String> values) {
            addCriterion("audit_remark not in", values, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkBetween(String value1, String value2) {
            addCriterion("audit_remark between", value1, value2, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andAuditRemarkNotBetween(String value1, String value2) {
            addCriterion("audit_remark not between", value1, value2, "auditRemark");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNull() {
            addCriterion("handler is null");
            return (Criteria) this;
        }

        public Criteria andHandlerIsNotNull() {
            addCriterion("handler is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerEqualTo(String value) {
            addCriterion("handler =", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotEqualTo(String value) {
            addCriterion("handler <>", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThan(String value) {
            addCriterion("handler >", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerGreaterThanOrEqualTo(String value) {
            addCriterion("handler >=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThan(String value) {
            addCriterion("handler <", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLessThanOrEqualTo(String value) {
            addCriterion("handler <=", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerLike(String value) {
            addCriterion("handler like", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotLike(String value) {
            addCriterion("handler not like", value, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerIn(List<String> values) {
            addCriterion("handler in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotIn(List<String> values) {
            addCriterion("handler not in", values, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerBetween(String value1, String value2) {
            addCriterion("handler between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerNotBetween(String value1, String value2) {
            addCriterion("handler not between", value1, value2, "handler");
            return (Criteria) this;
        }

        public Criteria andHandlerIdIsNull() {
            addCriterion("handler_id is null");
            return (Criteria) this;
        }

        public Criteria andHandlerIdIsNotNull() {
            addCriterion("handler_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandlerIdEqualTo(Integer value) {
            addCriterion("handler_id =", value, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdNotEqualTo(Integer value) {
            addCriterion("handler_id <>", value, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdGreaterThan(Integer value) {
            addCriterion("handler_id >", value, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("handler_id >=", value, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdLessThan(Integer value) {
            addCriterion("handler_id <", value, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdLessThanOrEqualTo(Integer value) {
            addCriterion("handler_id <=", value, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdIn(List<Integer> values) {
            addCriterion("handler_id in", values, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdNotIn(List<Integer> values) {
            addCriterion("handler_id not in", values, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdBetween(Integer value1, Integer value2) {
            addCriterion("handler_id between", value1, value2, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandlerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("handler_id not between", value1, value2, "handlerId");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(String value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(String value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(String value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(String value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(String value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(String value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLike(String value) {
            addCriterion("handle_time like", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotLike(String value) {
            addCriterion("handle_time not like", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<String> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<String> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(String value1, String value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(String value1, String value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleResultIsNull() {
            addCriterion("handle_result is null");
            return (Criteria) this;
        }

        public Criteria andHandleResultIsNotNull() {
            addCriterion("handle_result is not null");
            return (Criteria) this;
        }

        public Criteria andHandleResultEqualTo(String value) {
            addCriterion("handle_result =", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotEqualTo(String value) {
            addCriterion("handle_result <>", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultGreaterThan(String value) {
            addCriterion("handle_result >", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultGreaterThanOrEqualTo(String value) {
            addCriterion("handle_result >=", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLessThan(String value) {
            addCriterion("handle_result <", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLessThanOrEqualTo(String value) {
            addCriterion("handle_result <=", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultLike(String value) {
            addCriterion("handle_result like", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotLike(String value) {
            addCriterion("handle_result not like", value, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultIn(List<String> values) {
            addCriterion("handle_result in", values, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotIn(List<String> values) {
            addCriterion("handle_result not in", values, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultBetween(String value1, String value2) {
            addCriterion("handle_result between", value1, value2, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleResultNotBetween(String value1, String value2) {
            addCriterion("handle_result not between", value1, value2, "handleResult");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkIsNull() {
            addCriterion("handle_remark is null");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkIsNotNull() {
            addCriterion("handle_remark is not null");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkEqualTo(String value) {
            addCriterion("handle_remark =", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotEqualTo(String value) {
            addCriterion("handle_remark <>", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkGreaterThan(String value) {
            addCriterion("handle_remark >", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("handle_remark >=", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkLessThan(String value) {
            addCriterion("handle_remark <", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkLessThanOrEqualTo(String value) {
            addCriterion("handle_remark <=", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkLike(String value) {
            addCriterion("handle_remark like", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotLike(String value) {
            addCriterion("handle_remark not like", value, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkIn(List<String> values) {
            addCriterion("handle_remark in", values, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotIn(List<String> values) {
            addCriterion("handle_remark not in", values, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkBetween(String value1, String value2) {
            addCriterion("handle_remark between", value1, value2, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andHandleRemarkNotBetween(String value1, String value2) {
            addCriterion("handle_remark not between", value1, value2, "handleRemark");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Integer value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Integer value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Integer value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Integer value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Integer> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Integer> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEventStatusIsNull() {
            addCriterion("event_status is null");
            return (Criteria) this;
        }

        public Criteria andEventStatusIsNotNull() {
            addCriterion("event_status is not null");
            return (Criteria) this;
        }

        public Criteria andEventStatusEqualTo(Byte value) {
            addCriterion("event_status =", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotEqualTo(Byte value) {
            addCriterion("event_status <>", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusGreaterThan(Byte value) {
            addCriterion("event_status >", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("event_status >=", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLessThan(Byte value) {
            addCriterion("event_status <", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusLessThanOrEqualTo(Byte value) {
            addCriterion("event_status <=", value, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusIn(List<Byte> values) {
            addCriterion("event_status in", values, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotIn(List<Byte> values) {
            addCriterion("event_status not in", values, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusBetween(Byte value1, Byte value2) {
            addCriterion("event_status between", value1, value2, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andEventStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("event_status not between", value1, value2, "eventStatus");
            return (Criteria) this;
        }

        public Criteria andCcUserIsNull() {
            addCriterion("cc_user is null");
            return (Criteria) this;
        }

        public Criteria andCcUserIsNotNull() {
            addCriterion("cc_user is not null");
            return (Criteria) this;
        }

        public Criteria andCcUserEqualTo(String value) {
            addCriterion("cc_user =", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotEqualTo(String value) {
            addCriterion("cc_user <>", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserGreaterThan(String value) {
            addCriterion("cc_user >", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserGreaterThanOrEqualTo(String value) {
            addCriterion("cc_user >=", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserLessThan(String value) {
            addCriterion("cc_user <", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserLessThanOrEqualTo(String value) {
            addCriterion("cc_user <=", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserLike(String value) {
            addCriterion("cc_user like", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotLike(String value) {
            addCriterion("cc_user not like", value, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserIn(List<String> values) {
            addCriterion("cc_user in", values, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotIn(List<String> values) {
            addCriterion("cc_user not in", values, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserBetween(String value1, String value2) {
            addCriterion("cc_user between", value1, value2, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserNotBetween(String value1, String value2) {
            addCriterion("cc_user not between", value1, value2, "ccUser");
            return (Criteria) this;
        }

        public Criteria andCcUserIdIsNull() {
            addCriterion("cc_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCcUserIdIsNotNull() {
            addCriterion("cc_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCcUserIdEqualTo(Integer value) {
            addCriterion("cc_user_id =", value, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdNotEqualTo(Integer value) {
            addCriterion("cc_user_id <>", value, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdGreaterThan(Integer value) {
            addCriterion("cc_user_id >", value, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cc_user_id >=", value, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdLessThan(Integer value) {
            addCriterion("cc_user_id <", value, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("cc_user_id <=", value, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdIn(List<Integer> values) {
            addCriterion("cc_user_id in", values, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdNotIn(List<Integer> values) {
            addCriterion("cc_user_id not in", values, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdBetween(Integer value1, Integer value2) {
            addCriterion("cc_user_id between", value1, value2, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andCcUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cc_user_id not between", value1, value2, "ccUserId");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Byte value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Byte value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Byte value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Byte value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Byte value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Byte> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Byte> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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