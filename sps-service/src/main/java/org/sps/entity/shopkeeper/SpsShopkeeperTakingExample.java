package org.sps.entity.shopkeeper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperTakingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperTakingExample() {
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

        public Criteria andTakingIdIsNull() {
            addCriterion("taking_id is null");
            return (Criteria) this;
        }

        public Criteria andTakingIdIsNotNull() {
            addCriterion("taking_id is not null");
            return (Criteria) this;
        }

        public Criteria andTakingIdEqualTo(Integer value) {
            addCriterion("taking_id =", value, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdNotEqualTo(Integer value) {
            addCriterion("taking_id <>", value, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdGreaterThan(Integer value) {
            addCriterion("taking_id >", value, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("taking_id >=", value, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdLessThan(Integer value) {
            addCriterion("taking_id <", value, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdLessThanOrEqualTo(Integer value) {
            addCriterion("taking_id <=", value, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdIn(List<Integer> values) {
            addCriterion("taking_id in", values, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdNotIn(List<Integer> values) {
            addCriterion("taking_id not in", values, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdBetween(Integer value1, Integer value2) {
            addCriterion("taking_id between", value1, value2, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("taking_id not between", value1, value2, "takingId");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverIsNull() {
            addCriterion("taking_month_avg_turnover is null");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverIsNotNull() {
            addCriterion("taking_month_avg_turnover is not null");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverEqualTo(BigDecimal value) {
            addCriterion("taking_month_avg_turnover =", value, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverNotEqualTo(BigDecimal value) {
            addCriterion("taking_month_avg_turnover <>", value, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverGreaterThan(BigDecimal value) {
            addCriterion("taking_month_avg_turnover >", value, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("taking_month_avg_turnover >=", value, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverLessThan(BigDecimal value) {
            addCriterion("taking_month_avg_turnover <", value, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverLessThanOrEqualTo(BigDecimal value) {
            addCriterion("taking_month_avg_turnover <=", value, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverIn(List<BigDecimal> values) {
            addCriterion("taking_month_avg_turnover in", values, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverNotIn(List<BigDecimal> values) {
            addCriterion("taking_month_avg_turnover not in", values, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taking_month_avg_turnover between", value1, value2, "takingMonthAvgTurnover");
            return (Criteria) this;
        }

        public Criteria andTakingMonthAvgTurnoverNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("taking_month_avg_turnover not between", value1, value2, "takingMonthAvgTurnover");
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

        public Criteria andTakingUsernameIsNull() {
            addCriterion("taking_username is null");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameIsNotNull() {
            addCriterion("taking_username is not null");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameEqualTo(String value) {
            addCriterion("taking_username =", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameNotEqualTo(String value) {
            addCriterion("taking_username <>", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameGreaterThan(String value) {
            addCriterion("taking_username >", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("taking_username >=", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameLessThan(String value) {
            addCriterion("taking_username <", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameLessThanOrEqualTo(String value) {
            addCriterion("taking_username <=", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameLike(String value) {
            addCriterion("taking_username like", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameNotLike(String value) {
            addCriterion("taking_username not like", value, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameIn(List<String> values) {
            addCriterion("taking_username in", values, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameNotIn(List<String> values) {
            addCriterion("taking_username not in", values, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameBetween(String value1, String value2) {
            addCriterion("taking_username between", value1, value2, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingUsernameNotBetween(String value1, String value2) {
            addCriterion("taking_username not between", value1, value2, "takingUsername");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeIsNull() {
            addCriterion("taking_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeIsNotNull() {
            addCriterion("taking_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeEqualTo(Date value) {
            addCriterion("taking_creat_time =", value, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeNotEqualTo(Date value) {
            addCriterion("taking_creat_time <>", value, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeGreaterThan(Date value) {
            addCriterion("taking_creat_time >", value, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("taking_creat_time >=", value, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeLessThan(Date value) {
            addCriterion("taking_creat_time <", value, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("taking_creat_time <=", value, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeIn(List<Date> values) {
            addCriterion("taking_creat_time in", values, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeNotIn(List<Date> values) {
            addCriterion("taking_creat_time not in", values, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeBetween(Date value1, Date value2) {
            addCriterion("taking_creat_time between", value1, value2, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("taking_creat_time not between", value1, value2, "takingCreatTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeIsNull() {
            addCriterion("taking_update_time is null");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeIsNotNull() {
            addCriterion("taking_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeEqualTo(Date value) {
            addCriterion("taking_update_time =", value, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeNotEqualTo(Date value) {
            addCriterion("taking_update_time <>", value, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeGreaterThan(Date value) {
            addCriterion("taking_update_time >", value, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("taking_update_time >=", value, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeLessThan(Date value) {
            addCriterion("taking_update_time <", value, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("taking_update_time <=", value, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeIn(List<Date> values) {
            addCriterion("taking_update_time in", values, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeNotIn(List<Date> values) {
            addCriterion("taking_update_time not in", values, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("taking_update_time between", value1, value2, "takingUpdateTime");
            return (Criteria) this;
        }

        public Criteria andTakingUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("taking_update_time not between", value1, value2, "takingUpdateTime");
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