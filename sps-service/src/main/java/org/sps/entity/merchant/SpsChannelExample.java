package org.sps.entity.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsChannelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelExample() {
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

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelCityIsNull() {
            addCriterion("channel_city is null");
            return (Criteria) this;
        }

        public Criteria andChannelCityIsNotNull() {
            addCriterion("channel_city is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCityEqualTo(String value) {
            addCriterion("channel_city =", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityNotEqualTo(String value) {
            addCriterion("channel_city <>", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityGreaterThan(String value) {
            addCriterion("channel_city >", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityGreaterThanOrEqualTo(String value) {
            addCriterion("channel_city >=", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityLessThan(String value) {
            addCriterion("channel_city <", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityLessThanOrEqualTo(String value) {
            addCriterion("channel_city <=", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityLike(String value) {
            addCriterion("channel_city like", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityNotLike(String value) {
            addCriterion("channel_city not like", value, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityIn(List<String> values) {
            addCriterion("channel_city in", values, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityNotIn(List<String> values) {
            addCriterion("channel_city not in", values, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityBetween(String value1, String value2) {
            addCriterion("channel_city between", value1, value2, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelCityNotBetween(String value1, String value2) {
            addCriterion("channel_city not between", value1, value2, "channelCity");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumIsNull() {
            addCriterion("channel_salesman_num is null");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumIsNotNull() {
            addCriterion("channel_salesman_num is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumEqualTo(String value) {
            addCriterion("channel_salesman_num =", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumNotEqualTo(String value) {
            addCriterion("channel_salesman_num <>", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumGreaterThan(String value) {
            addCriterion("channel_salesman_num >", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumGreaterThanOrEqualTo(String value) {
            addCriterion("channel_salesman_num >=", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumLessThan(String value) {
            addCriterion("channel_salesman_num <", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumLessThanOrEqualTo(String value) {
            addCriterion("channel_salesman_num <=", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumLike(String value) {
            addCriterion("channel_salesman_num like", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumNotLike(String value) {
            addCriterion("channel_salesman_num not like", value, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumIn(List<String> values) {
            addCriterion("channel_salesman_num in", values, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumNotIn(List<String> values) {
            addCriterion("channel_salesman_num not in", values, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumBetween(String value1, String value2) {
            addCriterion("channel_salesman_num between", value1, value2, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNumNotBetween(String value1, String value2) {
            addCriterion("channel_salesman_num not between", value1, value2, "channelSalesmanNum");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameIsNull() {
            addCriterion("channel_salesman_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameIsNotNull() {
            addCriterion("channel_salesman_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameEqualTo(String value) {
            addCriterion("channel_salesman_name =", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameNotEqualTo(String value) {
            addCriterion("channel_salesman_name <>", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameGreaterThan(String value) {
            addCriterion("channel_salesman_name >", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_salesman_name >=", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameLessThan(String value) {
            addCriterion("channel_salesman_name <", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameLessThanOrEqualTo(String value) {
            addCriterion("channel_salesman_name <=", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameLike(String value) {
            addCriterion("channel_salesman_name like", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameNotLike(String value) {
            addCriterion("channel_salesman_name not like", value, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameIn(List<String> values) {
            addCriterion("channel_salesman_name in", values, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameNotIn(List<String> values) {
            addCriterion("channel_salesman_name not in", values, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameBetween(String value1, String value2) {
            addCriterion("channel_salesman_name between", value1, value2, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelSalesmanNameNotBetween(String value1, String value2) {
            addCriterion("channel_salesman_name not between", value1, value2, "channelSalesmanName");
            return (Criteria) this;
        }

        public Criteria andChannelNumIsNull() {
            addCriterion("channel_num is null");
            return (Criteria) this;
        }

        public Criteria andChannelNumIsNotNull() {
            addCriterion("channel_num is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNumEqualTo(String value) {
            addCriterion("channel_num =", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumNotEqualTo(String value) {
            addCriterion("channel_num <>", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumGreaterThan(String value) {
            addCriterion("channel_num >", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumGreaterThanOrEqualTo(String value) {
            addCriterion("channel_num >=", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumLessThan(String value) {
            addCriterion("channel_num <", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumLessThanOrEqualTo(String value) {
            addCriterion("channel_num <=", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumLike(String value) {
            addCriterion("channel_num like", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumNotLike(String value) {
            addCriterion("channel_num not like", value, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumIn(List<String> values) {
            addCriterion("channel_num in", values, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumNotIn(List<String> values) {
            addCriterion("channel_num not in", values, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumBetween(String value1, String value2) {
            addCriterion("channel_num between", value1, value2, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelNumNotBetween(String value1, String value2) {
            addCriterion("channel_num not between", value1, value2, "channelNum");
            return (Criteria) this;
        }

        public Criteria andChannelStateIsNull() {
            addCriterion("channel_state is null");
            return (Criteria) this;
        }

        public Criteria andChannelStateIsNotNull() {
            addCriterion("channel_state is not null");
            return (Criteria) this;
        }

        public Criteria andChannelStateEqualTo(Integer value) {
            addCriterion("channel_state =", value, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateNotEqualTo(Integer value) {
            addCriterion("channel_state <>", value, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateGreaterThan(Integer value) {
            addCriterion("channel_state >", value, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_state >=", value, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateLessThan(Integer value) {
            addCriterion("channel_state <", value, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateLessThanOrEqualTo(Integer value) {
            addCriterion("channel_state <=", value, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateIn(List<Integer> values) {
            addCriterion("channel_state in", values, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateNotIn(List<Integer> values) {
            addCriterion("channel_state not in", values, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateBetween(Integer value1, Integer value2) {
            addCriterion("channel_state between", value1, value2, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelStateNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_state not between", value1, value2, "channelState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateIsNull() {
            addCriterion("channel_flow_state is null");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateIsNotNull() {
            addCriterion("channel_flow_state is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateEqualTo(Integer value) {
            addCriterion("channel_flow_state =", value, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateNotEqualTo(Integer value) {
            addCriterion("channel_flow_state <>", value, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateGreaterThan(Integer value) {
            addCriterion("channel_flow_state >", value, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_flow_state >=", value, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateLessThan(Integer value) {
            addCriterion("channel_flow_state <", value, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateLessThanOrEqualTo(Integer value) {
            addCriterion("channel_flow_state <=", value, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateIn(List<Integer> values) {
            addCriterion("channel_flow_state in", values, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateNotIn(List<Integer> values) {
            addCriterion("channel_flow_state not in", values, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateBetween(Integer value1, Integer value2) {
            addCriterion("channel_flow_state between", value1, value2, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelFlowStateNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_flow_state not between", value1, value2, "channelFlowState");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeIsNull() {
            addCriterion("channel_up_time is null");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeIsNotNull() {
            addCriterion("channel_up_time is not null");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeEqualTo(Date value) {
            addCriterion("channel_up_time =", value, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeNotEqualTo(Date value) {
            addCriterion("channel_up_time <>", value, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeGreaterThan(Date value) {
            addCriterion("channel_up_time >", value, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("channel_up_time >=", value, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeLessThan(Date value) {
            addCriterion("channel_up_time <", value, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeLessThanOrEqualTo(Date value) {
            addCriterion("channel_up_time <=", value, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeIn(List<Date> values) {
            addCriterion("channel_up_time in", values, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeNotIn(List<Date> values) {
            addCriterion("channel_up_time not in", values, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeBetween(Date value1, Date value2) {
            addCriterion("channel_up_time between", value1, value2, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelUpTimeNotBetween(Date value1, Date value2) {
            addCriterion("channel_up_time not between", value1, value2, "channelUpTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeIsNull() {
            addCriterion("channel_freeze_time is null");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeIsNotNull() {
            addCriterion("channel_freeze_time is not null");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeEqualTo(Date value) {
            addCriterion("channel_freeze_time =", value, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeNotEqualTo(Date value) {
            addCriterion("channel_freeze_time <>", value, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeGreaterThan(Date value) {
            addCriterion("channel_freeze_time >", value, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("channel_freeze_time >=", value, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeLessThan(Date value) {
            addCriterion("channel_freeze_time <", value, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeLessThanOrEqualTo(Date value) {
            addCriterion("channel_freeze_time <=", value, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeIn(List<Date> values) {
            addCriterion("channel_freeze_time in", values, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeNotIn(List<Date> values) {
            addCriterion("channel_freeze_time not in", values, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeBetween(Date value1, Date value2) {
            addCriterion("channel_freeze_time between", value1, value2, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andChannelFreezeTimeNotBetween(Date value1, Date value2) {
            addCriterion("channel_freeze_time not between", value1, value2, "channelFreezeTime");
            return (Criteria) this;
        }

        public Criteria andStandby1IsNull() {
            addCriterion("standby1 is null");
            return (Criteria) this;
        }

        public Criteria andStandby1IsNotNull() {
            addCriterion("standby1 is not null");
            return (Criteria) this;
        }

        public Criteria andStandby1EqualTo(String value) {
            addCriterion("standby1 =", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1NotEqualTo(String value) {
            addCriterion("standby1 <>", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1GreaterThan(String value) {
            addCriterion("standby1 >", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1GreaterThanOrEqualTo(String value) {
            addCriterion("standby1 >=", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1LessThan(String value) {
            addCriterion("standby1 <", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1LessThanOrEqualTo(String value) {
            addCriterion("standby1 <=", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1Like(String value) {
            addCriterion("standby1 like", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1NotLike(String value) {
            addCriterion("standby1 not like", value, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1In(List<String> values) {
            addCriterion("standby1 in", values, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1NotIn(List<String> values) {
            addCriterion("standby1 not in", values, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1Between(String value1, String value2) {
            addCriterion("standby1 between", value1, value2, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby1NotBetween(String value1, String value2) {
            addCriterion("standby1 not between", value1, value2, "standby1");
            return (Criteria) this;
        }

        public Criteria andStandby2IsNull() {
            addCriterion("standby2 is null");
            return (Criteria) this;
        }

        public Criteria andStandby2IsNotNull() {
            addCriterion("standby2 is not null");
            return (Criteria) this;
        }

        public Criteria andStandby2EqualTo(String value) {
            addCriterion("standby2 =", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2NotEqualTo(String value) {
            addCriterion("standby2 <>", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2GreaterThan(String value) {
            addCriterion("standby2 >", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2GreaterThanOrEqualTo(String value) {
            addCriterion("standby2 >=", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2LessThan(String value) {
            addCriterion("standby2 <", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2LessThanOrEqualTo(String value) {
            addCriterion("standby2 <=", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2Like(String value) {
            addCriterion("standby2 like", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2NotLike(String value) {
            addCriterion("standby2 not like", value, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2In(List<String> values) {
            addCriterion("standby2 in", values, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2NotIn(List<String> values) {
            addCriterion("standby2 not in", values, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2Between(String value1, String value2) {
            addCriterion("standby2 between", value1, value2, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby2NotBetween(String value1, String value2) {
            addCriterion("standby2 not between", value1, value2, "standby2");
            return (Criteria) this;
        }

        public Criteria andStandby3IsNull() {
            addCriterion("standby3 is null");
            return (Criteria) this;
        }

        public Criteria andStandby3IsNotNull() {
            addCriterion("standby3 is not null");
            return (Criteria) this;
        }

        public Criteria andStandby3EqualTo(String value) {
            addCriterion("standby3 =", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3NotEqualTo(String value) {
            addCriterion("standby3 <>", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3GreaterThan(String value) {
            addCriterion("standby3 >", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3GreaterThanOrEqualTo(String value) {
            addCriterion("standby3 >=", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3LessThan(String value) {
            addCriterion("standby3 <", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3LessThanOrEqualTo(String value) {
            addCriterion("standby3 <=", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3Like(String value) {
            addCriterion("standby3 like", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3NotLike(String value) {
            addCriterion("standby3 not like", value, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3In(List<String> values) {
            addCriterion("standby3 in", values, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3NotIn(List<String> values) {
            addCriterion("standby3 not in", values, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3Between(String value1, String value2) {
            addCriterion("standby3 between", value1, value2, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby3NotBetween(String value1, String value2) {
            addCriterion("standby3 not between", value1, value2, "standby3");
            return (Criteria) this;
        }

        public Criteria andStandby4IsNull() {
            addCriterion("standby4 is null");
            return (Criteria) this;
        }

        public Criteria andStandby4IsNotNull() {
            addCriterion("standby4 is not null");
            return (Criteria) this;
        }

        public Criteria andStandby4EqualTo(String value) {
            addCriterion("standby4 =", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4NotEqualTo(String value) {
            addCriterion("standby4 <>", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4GreaterThan(String value) {
            addCriterion("standby4 >", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4GreaterThanOrEqualTo(String value) {
            addCriterion("standby4 >=", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4LessThan(String value) {
            addCriterion("standby4 <", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4LessThanOrEqualTo(String value) {
            addCriterion("standby4 <=", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4Like(String value) {
            addCriterion("standby4 like", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4NotLike(String value) {
            addCriterion("standby4 not like", value, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4In(List<String> values) {
            addCriterion("standby4 in", values, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4NotIn(List<String> values) {
            addCriterion("standby4 not in", values, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4Between(String value1, String value2) {
            addCriterion("standby4 between", value1, value2, "standby4");
            return (Criteria) this;
        }

        public Criteria andStandby4NotBetween(String value1, String value2) {
            addCriterion("standby4 not between", value1, value2, "standby4");
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