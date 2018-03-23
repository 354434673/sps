package org.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperRepaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperRepaymentExample() {
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

        public Criteria andRepaymentIdIsNull() {
            addCriterion("repayment_id is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdIsNotNull() {
            addCriterion("repayment_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdEqualTo(Integer value) {
            addCriterion("repayment_id =", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdNotEqualTo(Integer value) {
            addCriterion("repayment_id <>", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdGreaterThan(Integer value) {
            addCriterion("repayment_id >", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_id >=", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdLessThan(Integer value) {
            addCriterion("repayment_id <", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_id <=", value, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdIn(List<Integer> values) {
            addCriterion("repayment_id in", values, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdNotIn(List<Integer> values) {
            addCriterion("repayment_id not in", values, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdBetween(Integer value1, Integer value2) {
            addCriterion("repayment_id between", value1, value2, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_id not between", value1, value2, "repaymentId");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidIsNull() {
            addCriterion("repayment_bankId is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidIsNotNull() {
            addCriterion("repayment_bankId is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidEqualTo(String value) {
            addCriterion("repayment_bankId =", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidNotEqualTo(String value) {
            addCriterion("repayment_bankId <>", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidGreaterThan(String value) {
            addCriterion("repayment_bankId >", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_bankId >=", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidLessThan(String value) {
            addCriterion("repayment_bankId <", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidLessThanOrEqualTo(String value) {
            addCriterion("repayment_bankId <=", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidLike(String value) {
            addCriterion("repayment_bankId like", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidNotLike(String value) {
            addCriterion("repayment_bankId not like", value, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidIn(List<String> values) {
            addCriterion("repayment_bankId in", values, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidNotIn(List<String> values) {
            addCriterion("repayment_bankId not in", values, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidBetween(String value1, String value2) {
            addCriterion("repayment_bankId between", value1, value2, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentBankidNotBetween(String value1, String value2) {
            addCriterion("repayment_bankId not between", value1, value2, "repaymentBankid");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankIsNull() {
            addCriterion("repayment_deposit_bank is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankIsNotNull() {
            addCriterion("repayment_deposit_bank is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankEqualTo(String value) {
            addCriterion("repayment_deposit_bank =", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankNotEqualTo(String value) {
            addCriterion("repayment_deposit_bank <>", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankGreaterThan(String value) {
            addCriterion("repayment_deposit_bank >", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_deposit_bank >=", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankLessThan(String value) {
            addCriterion("repayment_deposit_bank <", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankLessThanOrEqualTo(String value) {
            addCriterion("repayment_deposit_bank <=", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankLike(String value) {
            addCriterion("repayment_deposit_bank like", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankNotLike(String value) {
            addCriterion("repayment_deposit_bank not like", value, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankIn(List<String> values) {
            addCriterion("repayment_deposit_bank in", values, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankNotIn(List<String> values) {
            addCriterion("repayment_deposit_bank not in", values, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankBetween(String value1, String value2) {
            addCriterion("repayment_deposit_bank between", value1, value2, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentDepositBankNotBetween(String value1, String value2) {
            addCriterion("repayment_deposit_bank not between", value1, value2, "repaymentDepositBank");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneIsNull() {
            addCriterion("repayment_phone is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneIsNotNull() {
            addCriterion("repayment_phone is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneEqualTo(String value) {
            addCriterion("repayment_phone =", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneNotEqualTo(String value) {
            addCriterion("repayment_phone <>", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneGreaterThan(String value) {
            addCriterion("repayment_phone >", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_phone >=", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneLessThan(String value) {
            addCriterion("repayment_phone <", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneLessThanOrEqualTo(String value) {
            addCriterion("repayment_phone <=", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneLike(String value) {
            addCriterion("repayment_phone like", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneNotLike(String value) {
            addCriterion("repayment_phone not like", value, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneIn(List<String> values) {
            addCriterion("repayment_phone in", values, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneNotIn(List<String> values) {
            addCriterion("repayment_phone not in", values, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneBetween(String value1, String value2) {
            addCriterion("repayment_phone between", value1, value2, "repaymentPhone");
            return (Criteria) this;
        }

        public Criteria andRepaymentPhoneNotBetween(String value1, String value2) {
            addCriterion("repayment_phone not between", value1, value2, "repaymentPhone");
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

        public Criteria andRepaymentUsernameIsNull() {
            addCriterion("repayment_username is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameIsNotNull() {
            addCriterion("repayment_username is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameEqualTo(String value) {
            addCriterion("repayment_username =", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameNotEqualTo(String value) {
            addCriterion("repayment_username <>", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameGreaterThan(String value) {
            addCriterion("repayment_username >", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_username >=", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameLessThan(String value) {
            addCriterion("repayment_username <", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameLessThanOrEqualTo(String value) {
            addCriterion("repayment_username <=", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameLike(String value) {
            addCriterion("repayment_username like", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameNotLike(String value) {
            addCriterion("repayment_username not like", value, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameIn(List<String> values) {
            addCriterion("repayment_username in", values, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameNotIn(List<String> values) {
            addCriterion("repayment_username not in", values, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameBetween(String value1, String value2) {
            addCriterion("repayment_username between", value1, value2, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentUsernameNotBetween(String value1, String value2) {
            addCriterion("repayment_username not between", value1, value2, "repaymentUsername");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeIsNull() {
            addCriterion("repayment_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeIsNotNull() {
            addCriterion("repayment_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeEqualTo(Date value) {
            addCriterion("repayment_creat_time =", value, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeNotEqualTo(Date value) {
            addCriterion("repayment_creat_time <>", value, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeGreaterThan(Date value) {
            addCriterion("repayment_creat_time >", value, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repayment_creat_time >=", value, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeLessThan(Date value) {
            addCriterion("repayment_creat_time <", value, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("repayment_creat_time <=", value, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeIn(List<Date> values) {
            addCriterion("repayment_creat_time in", values, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeNotIn(List<Date> values) {
            addCriterion("repayment_creat_time not in", values, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeBetween(Date value1, Date value2) {
            addCriterion("repayment_creat_time between", value1, value2, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("repayment_creat_time not between", value1, value2, "repaymentCreatTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeIsNull() {
            addCriterion("repayment_update_time is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeIsNotNull() {
            addCriterion("repayment_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeEqualTo(Date value) {
            addCriterion("repayment_update_time =", value, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeNotEqualTo(Date value) {
            addCriterion("repayment_update_time <>", value, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeGreaterThan(Date value) {
            addCriterion("repayment_update_time >", value, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repayment_update_time >=", value, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeLessThan(Date value) {
            addCriterion("repayment_update_time <", value, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("repayment_update_time <=", value, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeIn(List<Date> values) {
            addCriterion("repayment_update_time in", values, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeNotIn(List<Date> values) {
            addCriterion("repayment_update_time not in", values, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("repayment_update_time between", value1, value2, "repaymentUpdateTime");
            return (Criteria) this;
        }

        public Criteria andRepaymentUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("repayment_update_time not between", value1, value2, "repaymentUpdateTime");
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