package org.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperCreditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperCreditExample() {
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

        public Criteria andCreditIdIsNull() {
            addCriterion("credit_id is null");
            return (Criteria) this;
        }

        public Criteria andCreditIdIsNotNull() {
            addCriterion("credit_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreditIdEqualTo(Integer value) {
            addCriterion("credit_id =", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotEqualTo(Integer value) {
            addCriterion("credit_id <>", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdGreaterThan(Integer value) {
            addCriterion("credit_id >", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_id >=", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLessThan(Integer value) {
            addCriterion("credit_id <", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLessThanOrEqualTo(Integer value) {
            addCriterion("credit_id <=", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdIn(List<Integer> values) {
            addCriterion("credit_id in", values, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotIn(List<Integer> values) {
            addCriterion("credit_id not in", values, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdBetween(Integer value1, Integer value2) {
            addCriterion("credit_id between", value1, value2, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_id not between", value1, value2, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameIsNull() {
            addCriterion("credit_username is null");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameIsNotNull() {
            addCriterion("credit_username is not null");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameEqualTo(String value) {
            addCriterion("credit_username =", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameNotEqualTo(String value) {
            addCriterion("credit_username <>", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameGreaterThan(String value) {
            addCriterion("credit_username >", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("credit_username >=", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameLessThan(String value) {
            addCriterion("credit_username <", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameLessThanOrEqualTo(String value) {
            addCriterion("credit_username <=", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameLike(String value) {
            addCriterion("credit_username like", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameNotLike(String value) {
            addCriterion("credit_username not like", value, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameIn(List<String> values) {
            addCriterion("credit_username in", values, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameNotIn(List<String> values) {
            addCriterion("credit_username not in", values, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameBetween(String value1, String value2) {
            addCriterion("credit_username between", value1, value2, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditUsernameNotBetween(String value1, String value2) {
            addCriterion("credit_username not between", value1, value2, "creditUsername");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordIsNull() {
            addCriterion("credit_password is null");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordIsNotNull() {
            addCriterion("credit_password is not null");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordEqualTo(String value) {
            addCriterion("credit_password =", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordNotEqualTo(String value) {
            addCriterion("credit_password <>", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordGreaterThan(String value) {
            addCriterion("credit_password >", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("credit_password >=", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordLessThan(String value) {
            addCriterion("credit_password <", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordLessThanOrEqualTo(String value) {
            addCriterion("credit_password <=", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordLike(String value) {
            addCriterion("credit_password like", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordNotLike(String value) {
            addCriterion("credit_password not like", value, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordIn(List<String> values) {
            addCriterion("credit_password in", values, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordNotIn(List<String> values) {
            addCriterion("credit_password not in", values, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordBetween(String value1, String value2) {
            addCriterion("credit_password between", value1, value2, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditPasswordNotBetween(String value1, String value2) {
            addCriterion("credit_password not between", value1, value2, "creditPassword");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyIsNull() {
            addCriterion("credit_verify is null");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyIsNotNull() {
            addCriterion("credit_verify is not null");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyEqualTo(String value) {
            addCriterion("credit_verify =", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyNotEqualTo(String value) {
            addCriterion("credit_verify <>", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyGreaterThan(String value) {
            addCriterion("credit_verify >", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyGreaterThanOrEqualTo(String value) {
            addCriterion("credit_verify >=", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyLessThan(String value) {
            addCriterion("credit_verify <", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyLessThanOrEqualTo(String value) {
            addCriterion("credit_verify <=", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyLike(String value) {
            addCriterion("credit_verify like", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyNotLike(String value) {
            addCriterion("credit_verify not like", value, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyIn(List<String> values) {
            addCriterion("credit_verify in", values, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyNotIn(List<String> values) {
            addCriterion("credit_verify not in", values, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyBetween(String value1, String value2) {
            addCriterion("credit_verify between", value1, value2, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditVerifyNotBetween(String value1, String value2) {
            addCriterion("credit_verify not between", value1, value2, "creditVerify");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeIsNull() {
            addCriterion("credit_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeIsNotNull() {
            addCriterion("credit_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeEqualTo(Date value) {
            addCriterion("credit_creat_time =", value, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeNotEqualTo(Date value) {
            addCriterion("credit_creat_time <>", value, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeGreaterThan(Date value) {
            addCriterion("credit_creat_time >", value, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("credit_creat_time >=", value, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeLessThan(Date value) {
            addCriterion("credit_creat_time <", value, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("credit_creat_time <=", value, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeIn(List<Date> values) {
            addCriterion("credit_creat_time in", values, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeNotIn(List<Date> values) {
            addCriterion("credit_creat_time not in", values, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeBetween(Date value1, Date value2) {
            addCriterion("credit_creat_time between", value1, value2, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("credit_creat_time not between", value1, value2, "creditCreatTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeIsNull() {
            addCriterion("credit_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeIsNotNull() {
            addCriterion("credit_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeEqualTo(Date value) {
            addCriterion("credit_update_time =", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeNotEqualTo(Date value) {
            addCriterion("credit_update_time <>", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeGreaterThan(Date value) {
            addCriterion("credit_update_time >", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("credit_update_time >=", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeLessThan(Date value) {
            addCriterion("credit_update_time <", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("credit_update_time <=", value, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeIn(List<Date> values) {
            addCriterion("credit_update_time in", values, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeNotIn(List<Date> values) {
            addCriterion("credit_update_time not in", values, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("credit_update_time between", value1, value2, "creditUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreditUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("credit_update_time not between", value1, value2, "creditUpdateTime");
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