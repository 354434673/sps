package com.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperAccountExample() {
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

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(Integer value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(Integer value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(Integer value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(Integer value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Integer value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<Integer> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<Integer> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(Integer value1, Integer value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(Integer value1, Integer value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountNumIsNull() {
            addCriterion("account_num is null");
            return (Criteria) this;
        }

        public Criteria andAccountNumIsNotNull() {
            addCriterion("account_num is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNumEqualTo(String value) {
            addCriterion("account_num =", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotEqualTo(String value) {
            addCriterion("account_num <>", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumGreaterThan(String value) {
            addCriterion("account_num >", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumGreaterThanOrEqualTo(String value) {
            addCriterion("account_num >=", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumLessThan(String value) {
            addCriterion("account_num <", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumLessThanOrEqualTo(String value) {
            addCriterion("account_num <=", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumLike(String value) {
            addCriterion("account_num like", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotLike(String value) {
            addCriterion("account_num not like", value, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumIn(List<String> values) {
            addCriterion("account_num in", values, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotIn(List<String> values) {
            addCriterion("account_num not in", values, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumBetween(String value1, String value2) {
            addCriterion("account_num between", value1, value2, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountNumNotBetween(String value1, String value2) {
            addCriterion("account_num not between", value1, value2, "accountNum");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeIsNull() {
            addCriterion("account_start_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeIsNotNull() {
            addCriterion("account_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeEqualTo(Date value) {
            addCriterion("account_start_time =", value, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeNotEqualTo(Date value) {
            addCriterion("account_start_time <>", value, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeGreaterThan(Date value) {
            addCriterion("account_start_time >", value, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("account_start_time >=", value, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeLessThan(Date value) {
            addCriterion("account_start_time <", value, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("account_start_time <=", value, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeIn(List<Date> values) {
            addCriterion("account_start_time in", values, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeNotIn(List<Date> values) {
            addCriterion("account_start_time not in", values, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeBetween(Date value1, Date value2) {
            addCriterion("account_start_time between", value1, value2, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("account_start_time not between", value1, value2, "accountStartTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeIsNull() {
            addCriterion("account_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeIsNotNull() {
            addCriterion("account_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeEqualTo(Date value) {
            addCriterion("account_end_time =", value, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeNotEqualTo(Date value) {
            addCriterion("account_end_time <>", value, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeGreaterThan(Date value) {
            addCriterion("account_end_time >", value, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("account_end_time >=", value, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeLessThan(Date value) {
            addCriterion("account_end_time <", value, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("account_end_time <=", value, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeIn(List<Date> values) {
            addCriterion("account_end_time in", values, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeNotIn(List<Date> values) {
            addCriterion("account_end_time not in", values, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeBetween(Date value1, Date value2) {
            addCriterion("account_end_time between", value1, value2, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("account_end_time not between", value1, value2, "accountEndTime");
            return (Criteria) this;
        }

        public Criteria andAccountValidityIsNull() {
            addCriterion("account_validity is null");
            return (Criteria) this;
        }

        public Criteria andAccountValidityIsNotNull() {
            addCriterion("account_validity is not null");
            return (Criteria) this;
        }

        public Criteria andAccountValidityEqualTo(Date value) {
            addCriterion("account_validity =", value, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityNotEqualTo(Date value) {
            addCriterion("account_validity <>", value, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityGreaterThan(Date value) {
            addCriterion("account_validity >", value, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityGreaterThanOrEqualTo(Date value) {
            addCriterion("account_validity >=", value, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityLessThan(Date value) {
            addCriterion("account_validity <", value, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityLessThanOrEqualTo(Date value) {
            addCriterion("account_validity <=", value, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityIn(List<Date> values) {
            addCriterion("account_validity in", values, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityNotIn(List<Date> values) {
            addCriterion("account_validity not in", values, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityBetween(Date value1, Date value2) {
            addCriterion("account_validity between", value1, value2, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountValidityNotBetween(Date value1, Date value2) {
            addCriterion("account_validity not between", value1, value2, "accountValidity");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentIsNull() {
            addCriterion("account_down_payment is null");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentIsNotNull() {
            addCriterion("account_down_payment is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentEqualTo(Double value) {
            addCriterion("account_down_payment =", value, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentNotEqualTo(Double value) {
            addCriterion("account_down_payment <>", value, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentGreaterThan(Double value) {
            addCriterion("account_down_payment >", value, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentGreaterThanOrEqualTo(Double value) {
            addCriterion("account_down_payment >=", value, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentLessThan(Double value) {
            addCriterion("account_down_payment <", value, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentLessThanOrEqualTo(Double value) {
            addCriterion("account_down_payment <=", value, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentIn(List<Double> values) {
            addCriterion("account_down_payment in", values, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentNotIn(List<Double> values) {
            addCriterion("account_down_payment not in", values, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentBetween(Double value1, Double value2) {
            addCriterion("account_down_payment between", value1, value2, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountDownPaymentNotBetween(Double value1, Double value2) {
            addCriterion("account_down_payment not between", value1, value2, "accountDownPayment");
            return (Criteria) this;
        }

        public Criteria andAccountStateIsNull() {
            addCriterion("account_state is null");
            return (Criteria) this;
        }

        public Criteria andAccountStateIsNotNull() {
            addCriterion("account_state is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStateEqualTo(Integer value) {
            addCriterion("account_state =", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotEqualTo(Integer value) {
            addCriterion("account_state <>", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateGreaterThan(Integer value) {
            addCriterion("account_state >", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_state >=", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLessThan(Integer value) {
            addCriterion("account_state <", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateLessThanOrEqualTo(Integer value) {
            addCriterion("account_state <=", value, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateIn(List<Integer> values) {
            addCriterion("account_state in", values, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotIn(List<Integer> values) {
            addCriterion("account_state not in", values, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateBetween(Integer value1, Integer value2) {
            addCriterion("account_state between", value1, value2, "accountState");
            return (Criteria) this;
        }

        public Criteria andAccountStateNotBetween(Integer value1, Integer value2) {
            addCriterion("account_state not between", value1, value2, "accountState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridIsNull() {
            addCriterion("shopkeeper_customerId is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridIsNotNull() {
            addCriterion("shopkeeper_customerId is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridEqualTo(String value) {
            addCriterion("shopkeeper_customerId =", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridNotEqualTo(String value) {
            addCriterion("shopkeeper_customerId <>", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridGreaterThan(String value) {
            addCriterion("shopkeeper_customerId >", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_customerId >=", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridLessThan(String value) {
            addCriterion("shopkeeper_customerId <", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_customerId <=", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridLike(String value) {
            addCriterion("shopkeeper_customerId like", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridNotLike(String value) {
            addCriterion("shopkeeper_customerId not like", value, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridIn(List<String> values) {
            addCriterion("shopkeeper_customerId in", values, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridNotIn(List<String> values) {
            addCriterion("shopkeeper_customerId not in", values, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridBetween(String value1, String value2) {
            addCriterion("shopkeeper_customerId between", value1, value2, "shopkeeperCustomerid");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCustomeridNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_customerId not between", value1, value2, "shopkeeperCustomerid");
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