package org.sps.entity.merchant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SpsChannelAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelAccountExample() {
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

        public Criteria andAccountCreditLineIsNull() {
            addCriterion("account_credit_line is null");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineIsNotNull() {
            addCriterion("account_credit_line is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineEqualTo(BigDecimal value) {
            addCriterion("account_credit_line =", value, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineNotEqualTo(BigDecimal value) {
            addCriterion("account_credit_line <>", value, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineGreaterThan(BigDecimal value) {
            addCriterion("account_credit_line >", value, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("account_credit_line >=", value, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineLessThan(BigDecimal value) {
            addCriterion("account_credit_line <", value, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineLessThanOrEqualTo(BigDecimal value) {
            addCriterion("account_credit_line <=", value, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineIn(List<BigDecimal> values) {
            addCriterion("account_credit_line in", values, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineNotIn(List<BigDecimal> values) {
            addCriterion("account_credit_line not in", values, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_credit_line between", value1, value2, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditLineNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_credit_line not between", value1, value2, "accountCreditLine");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentIsNull() {
            addCriterion("account_credit_present is null");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentIsNotNull() {
            addCriterion("account_credit_present is not null");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentEqualTo(BigDecimal value) {
            addCriterion("account_credit_present =", value, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentNotEqualTo(BigDecimal value) {
            addCriterion("account_credit_present <>", value, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentGreaterThan(BigDecimal value) {
            addCriterion("account_credit_present >", value, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("account_credit_present >=", value, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentLessThan(BigDecimal value) {
            addCriterion("account_credit_present <", value, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("account_credit_present <=", value, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentIn(List<BigDecimal> values) {
            addCriterion("account_credit_present in", values, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentNotIn(List<BigDecimal> values) {
            addCriterion("account_credit_present not in", values, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_credit_present between", value1, value2, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountCreditPresentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_credit_present not between", value1, value2, "accountCreditPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositIsNull() {
            addCriterion("account_deposit is null");
            return (Criteria) this;
        }

        public Criteria andAccountDepositIsNotNull() {
            addCriterion("account_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDepositEqualTo(BigDecimal value) {
            addCriterion("account_deposit =", value, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositNotEqualTo(BigDecimal value) {
            addCriterion("account_deposit <>", value, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositGreaterThan(BigDecimal value) {
            addCriterion("account_deposit >", value, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("account_deposit >=", value, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositLessThan(BigDecimal value) {
            addCriterion("account_deposit <", value, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("account_deposit <=", value, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositIn(List<BigDecimal> values) {
            addCriterion("account_deposit in", values, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositNotIn(List<BigDecimal> values) {
            addCriterion("account_deposit not in", values, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_deposit between", value1, value2, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_deposit not between", value1, value2, "accountDeposit");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentIsNull() {
            addCriterion("account_deposit_present is null");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentIsNotNull() {
            addCriterion("account_deposit_present is not null");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentEqualTo(BigDecimal value) {
            addCriterion("account_deposit_present =", value, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentNotEqualTo(BigDecimal value) {
            addCriterion("account_deposit_present <>", value, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentGreaterThan(BigDecimal value) {
            addCriterion("account_deposit_present >", value, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("account_deposit_present >=", value, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentLessThan(BigDecimal value) {
            addCriterion("account_deposit_present <", value, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("account_deposit_present <=", value, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentIn(List<BigDecimal> values) {
            addCriterion("account_deposit_present in", values, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentNotIn(List<BigDecimal> values) {
            addCriterion("account_deposit_present not in", values, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_deposit_present between", value1, value2, "accountDepositPresent");
            return (Criteria) this;
        }

        public Criteria andAccountDepositPresentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("account_deposit_present not between", value1, value2, "accountDepositPresent");
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