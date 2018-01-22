package com.sps.entity.merchant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsChannelOpenAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelOpenAccountExample() {
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(Integer value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(Integer value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(Integer value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(Integer value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(Integer value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<Integer> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<Integer> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(Integer value1, Integer value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(Integer value1, Integer value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumIsNull() {
            addCriterion("open_admin_num is null");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumIsNotNull() {
            addCriterion("open_admin_num is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumEqualTo(String value) {
            addCriterion("open_admin_num =", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumNotEqualTo(String value) {
            addCriterion("open_admin_num <>", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumGreaterThan(String value) {
            addCriterion("open_admin_num >", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumGreaterThanOrEqualTo(String value) {
            addCriterion("open_admin_num >=", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumLessThan(String value) {
            addCriterion("open_admin_num <", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumLessThanOrEqualTo(String value) {
            addCriterion("open_admin_num <=", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumLike(String value) {
            addCriterion("open_admin_num like", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumNotLike(String value) {
            addCriterion("open_admin_num not like", value, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumIn(List<String> values) {
            addCriterion("open_admin_num in", values, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumNotIn(List<String> values) {
            addCriterion("open_admin_num not in", values, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumBetween(String value1, String value2) {
            addCriterion("open_admin_num between", value1, value2, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminNumNotBetween(String value1, String value2) {
            addCriterion("open_admin_num not between", value1, value2, "openAdminNum");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneIsNull() {
            addCriterion("open_admin_phone is null");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneIsNotNull() {
            addCriterion("open_admin_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneEqualTo(String value) {
            addCriterion("open_admin_phone =", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneNotEqualTo(String value) {
            addCriterion("open_admin_phone <>", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneGreaterThan(String value) {
            addCriterion("open_admin_phone >", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("open_admin_phone >=", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneLessThan(String value) {
            addCriterion("open_admin_phone <", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneLessThanOrEqualTo(String value) {
            addCriterion("open_admin_phone <=", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneLike(String value) {
            addCriterion("open_admin_phone like", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneNotLike(String value) {
            addCriterion("open_admin_phone not like", value, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneIn(List<String> values) {
            addCriterion("open_admin_phone in", values, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneNotIn(List<String> values) {
            addCriterion("open_admin_phone not in", values, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneBetween(String value1, String value2) {
            addCriterion("open_admin_phone between", value1, value2, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenAdminPhoneNotBetween(String value1, String value2) {
            addCriterion("open_admin_phone not between", value1, value2, "openAdminPhone");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIsNull() {
            addCriterion("open_start_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIsNotNull() {
            addCriterion("open_start_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeEqualTo(Date value) {
            addCriterion("open_start_time =", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotEqualTo(Date value) {
            addCriterion("open_start_time <>", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeGreaterThan(Date value) {
            addCriterion("open_start_time >", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_start_time >=", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeLessThan(Date value) {
            addCriterion("open_start_time <", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_start_time <=", value, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeIn(List<Date> values) {
            addCriterion("open_start_time in", values, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotIn(List<Date> values) {
            addCriterion("open_start_time not in", values, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeBetween(Date value1, Date value2) {
            addCriterion("open_start_time between", value1, value2, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_start_time not between", value1, value2, "openStartTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIsNull() {
            addCriterion("open_end_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIsNotNull() {
            addCriterion("open_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeEqualTo(Date value) {
            addCriterion("open_end_time =", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotEqualTo(Date value) {
            addCriterion("open_end_time <>", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeGreaterThan(Date value) {
            addCriterion("open_end_time >", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_end_time >=", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeLessThan(Date value) {
            addCriterion("open_end_time <", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_end_time <=", value, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeIn(List<Date> values) {
            addCriterion("open_end_time in", values, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotIn(List<Date> values) {
            addCriterion("open_end_time not in", values, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeBetween(Date value1, Date value2) {
            addCriterion("open_end_time between", value1, value2, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_end_time not between", value1, value2, "openEndTime");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductIsNull() {
            addCriterion("open_apply_product is null");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductIsNotNull() {
            addCriterion("open_apply_product is not null");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductEqualTo(String value) {
            addCriterion("open_apply_product =", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductNotEqualTo(String value) {
            addCriterion("open_apply_product <>", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductGreaterThan(String value) {
            addCriterion("open_apply_product >", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductGreaterThanOrEqualTo(String value) {
            addCriterion("open_apply_product >=", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductLessThan(String value) {
            addCriterion("open_apply_product <", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductLessThanOrEqualTo(String value) {
            addCriterion("open_apply_product <=", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductLike(String value) {
            addCriterion("open_apply_product like", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductNotLike(String value) {
            addCriterion("open_apply_product not like", value, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductIn(List<String> values) {
            addCriterion("open_apply_product in", values, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductNotIn(List<String> values) {
            addCriterion("open_apply_product not in", values, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductBetween(String value1, String value2) {
            addCriterion("open_apply_product between", value1, value2, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenApplyProductNotBetween(String value1, String value2) {
            addCriterion("open_apply_product not between", value1, value2, "openApplyProduct");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateIsNull() {
            addCriterion("open_sell_rate is null");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateIsNotNull() {
            addCriterion("open_sell_rate is not null");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateEqualTo(Integer value) {
            addCriterion("open_sell_rate =", value, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateNotEqualTo(Integer value) {
            addCriterion("open_sell_rate <>", value, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateGreaterThan(Integer value) {
            addCriterion("open_sell_rate >", value, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_sell_rate >=", value, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateLessThan(Integer value) {
            addCriterion("open_sell_rate <", value, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateLessThanOrEqualTo(Integer value) {
            addCriterion("open_sell_rate <=", value, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateIn(List<Integer> values) {
            addCriterion("open_sell_rate in", values, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateNotIn(List<Integer> values) {
            addCriterion("open_sell_rate not in", values, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateBetween(Integer value1, Integer value2) {
            addCriterion("open_sell_rate between", value1, value2, "openSellRate");
            return (Criteria) this;
        }

        public Criteria andOpenSellRateNotBetween(Integer value1, Integer value2) {
            addCriterion("open_sell_rate not between", value1, value2, "openSellRate");
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