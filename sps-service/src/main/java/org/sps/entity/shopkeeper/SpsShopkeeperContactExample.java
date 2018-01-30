package org.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperContactExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperContactExample() {
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

        public Criteria andContactIdIsNull() {
            addCriterion("contact_id is null");
            return (Criteria) this;
        }

        public Criteria andContactIdIsNotNull() {
            addCriterion("contact_id is not null");
            return (Criteria) this;
        }

        public Criteria andContactIdEqualTo(Integer value) {
            addCriterion("contact_id =", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotEqualTo(Integer value) {
            addCriterion("contact_id <>", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThan(Integer value) {
            addCriterion("contact_id >", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contact_id >=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThan(Integer value) {
            addCriterion("contact_id <", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdLessThanOrEqualTo(Integer value) {
            addCriterion("contact_id <=", value, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdIn(List<Integer> values) {
            addCriterion("contact_id in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotIn(List<Integer> values) {
            addCriterion("contact_id not in", values, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdBetween(Integer value1, Integer value2) {
            addCriterion("contact_id between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contact_id not between", value1, value2, "contactId");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactRelationIsNull() {
            addCriterion("contact_relation is null");
            return (Criteria) this;
        }

        public Criteria andContactRelationIsNotNull() {
            addCriterion("contact_relation is not null");
            return (Criteria) this;
        }

        public Criteria andContactRelationEqualTo(String value) {
            addCriterion("contact_relation =", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationNotEqualTo(String value) {
            addCriterion("contact_relation <>", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationGreaterThan(String value) {
            addCriterion("contact_relation >", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationGreaterThanOrEqualTo(String value) {
            addCriterion("contact_relation >=", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationLessThan(String value) {
            addCriterion("contact_relation <", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationLessThanOrEqualTo(String value) {
            addCriterion("contact_relation <=", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationLike(String value) {
            addCriterion("contact_relation like", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationNotLike(String value) {
            addCriterion("contact_relation not like", value, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationIn(List<String> values) {
            addCriterion("contact_relation in", values, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationNotIn(List<String> values) {
            addCriterion("contact_relation not in", values, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationBetween(String value1, String value2) {
            addCriterion("contact_relation between", value1, value2, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactRelationNotBetween(String value1, String value2) {
            addCriterion("contact_relation not between", value1, value2, "contactRelation");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
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

        public Criteria andContactUsernameIsNull() {
            addCriterion("contact_username is null");
            return (Criteria) this;
        }

        public Criteria andContactUsernameIsNotNull() {
            addCriterion("contact_username is not null");
            return (Criteria) this;
        }

        public Criteria andContactUsernameEqualTo(String value) {
            addCriterion("contact_username =", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameNotEqualTo(String value) {
            addCriterion("contact_username <>", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameGreaterThan(String value) {
            addCriterion("contact_username >", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_username >=", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameLessThan(String value) {
            addCriterion("contact_username <", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameLessThanOrEqualTo(String value) {
            addCriterion("contact_username <=", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameLike(String value) {
            addCriterion("contact_username like", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameNotLike(String value) {
            addCriterion("contact_username not like", value, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameIn(List<String> values) {
            addCriterion("contact_username in", values, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameNotIn(List<String> values) {
            addCriterion("contact_username not in", values, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameBetween(String value1, String value2) {
            addCriterion("contact_username between", value1, value2, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactUsernameNotBetween(String value1, String value2) {
            addCriterion("contact_username not between", value1, value2, "contactUsername");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeIsNull() {
            addCriterion("contact_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeIsNotNull() {
            addCriterion("contact_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeEqualTo(Date value) {
            addCriterion("contact_creat_time =", value, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeNotEqualTo(Date value) {
            addCriterion("contact_creat_time <>", value, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeGreaterThan(Date value) {
            addCriterion("contact_creat_time >", value, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("contact_creat_time >=", value, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeLessThan(Date value) {
            addCriterion("contact_creat_time <", value, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("contact_creat_time <=", value, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeIn(List<Date> values) {
            addCriterion("contact_creat_time in", values, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeNotIn(List<Date> values) {
            addCriterion("contact_creat_time not in", values, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeBetween(Date value1, Date value2) {
            addCriterion("contact_creat_time between", value1, value2, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("contact_creat_time not between", value1, value2, "contactCreatTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeIsNull() {
            addCriterion("contact_update_time is null");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeIsNotNull() {
            addCriterion("contact_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeEqualTo(Date value) {
            addCriterion("contact_update_time =", value, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeNotEqualTo(Date value) {
            addCriterion("contact_update_time <>", value, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeGreaterThan(Date value) {
            addCriterion("contact_update_time >", value, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("contact_update_time >=", value, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeLessThan(Date value) {
            addCriterion("contact_update_time <", value, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("contact_update_time <=", value, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeIn(List<Date> values) {
            addCriterion("contact_update_time in", values, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeNotIn(List<Date> values) {
            addCriterion("contact_update_time not in", values, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("contact_update_time between", value1, value2, "contactUpdateTime");
            return (Criteria) this;
        }

        public Criteria andContactUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("contact_update_time not between", value1, value2, "contactUpdateTime");
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