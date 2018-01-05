package org.sps.entity.merchant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SpsChannelLogisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelLogisticsExample() {
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

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(Integer value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(Integer value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(Integer value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(Integer value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<Integer> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<Integer> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(Integer value1, Integer value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayIsNull() {
            addCriterion("logistics_way is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayIsNotNull() {
            addCriterion("logistics_way is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayEqualTo(String value) {
            addCriterion("logistics_way =", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotEqualTo(String value) {
            addCriterion("logistics_way <>", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayGreaterThan(String value) {
            addCriterion("logistics_way >", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_way >=", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayLessThan(String value) {
            addCriterion("logistics_way <", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayLessThanOrEqualTo(String value) {
            addCriterion("logistics_way <=", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayLike(String value) {
            addCriterion("logistics_way like", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotLike(String value) {
            addCriterion("logistics_way not like", value, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayIn(List<String> values) {
            addCriterion("logistics_way in", values, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotIn(List<String> values) {
            addCriterion("logistics_way not in", values, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayBetween(String value1, String value2) {
            addCriterion("logistics_way between", value1, value2, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsWayNotBetween(String value1, String value2) {
            addCriterion("logistics_way not between", value1, value2, "logisticsWay");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameIsNull() {
            addCriterion("logistics_cooperation_name is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameIsNotNull() {
            addCriterion("logistics_cooperation_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameEqualTo(String value) {
            addCriterion("logistics_cooperation_name =", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameNotEqualTo(String value) {
            addCriterion("logistics_cooperation_name <>", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameGreaterThan(String value) {
            addCriterion("logistics_cooperation_name >", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_cooperation_name >=", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameLessThan(String value) {
            addCriterion("logistics_cooperation_name <", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameLessThanOrEqualTo(String value) {
            addCriterion("logistics_cooperation_name <=", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameLike(String value) {
            addCriterion("logistics_cooperation_name like", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameNotLike(String value) {
            addCriterion("logistics_cooperation_name not like", value, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameIn(List<String> values) {
            addCriterion("logistics_cooperation_name in", values, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameNotIn(List<String> values) {
            addCriterion("logistics_cooperation_name not in", values, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameBetween(String value1, String value2) {
            addCriterion("logistics_cooperation_name between", value1, value2, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsCooperationNameNotBetween(String value1, String value2) {
            addCriterion("logistics_cooperation_name not between", value1, value2, "logisticsCooperationName");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostIsNull() {
            addCriterion("logistics_all_cost is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostIsNotNull() {
            addCriterion("logistics_all_cost is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostEqualTo(BigDecimal value) {
            addCriterion("logistics_all_cost =", value, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostNotEqualTo(BigDecimal value) {
            addCriterion("logistics_all_cost <>", value, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostGreaterThan(BigDecimal value) {
            addCriterion("logistics_all_cost >", value, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("logistics_all_cost >=", value, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostLessThan(BigDecimal value) {
            addCriterion("logistics_all_cost <", value, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("logistics_all_cost <=", value, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostIn(List<BigDecimal> values) {
            addCriterion("logistics_all_cost in", values, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostNotIn(List<BigDecimal> values) {
            addCriterion("logistics_all_cost not in", values, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("logistics_all_cost between", value1, value2, "logisticsAllCost");
            return (Criteria) this;
        }

        public Criteria andLogisticsAllCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("logistics_all_cost not between", value1, value2, "logisticsAllCost");
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