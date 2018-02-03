package org.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperInvitationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperInvitationExample() {
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

        public Criteria andInvitationIdIsNull() {
            addCriterion("invitation_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitationIdIsNotNull() {
            addCriterion("invitation_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationIdEqualTo(Integer value) {
            addCriterion("invitation_id =", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotEqualTo(Integer value) {
            addCriterion("invitation_id <>", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdGreaterThan(Integer value) {
            addCriterion("invitation_id >", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("invitation_id >=", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdLessThan(Integer value) {
            addCriterion("invitation_id <", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdLessThanOrEqualTo(Integer value) {
            addCriterion("invitation_id <=", value, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdIn(List<Integer> values) {
            addCriterion("invitation_id in", values, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotIn(List<Integer> values) {
            addCriterion("invitation_id not in", values, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdBetween(Integer value1, Integer value2) {
            addCriterion("invitation_id between", value1, value2, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("invitation_id not between", value1, value2, "invitationId");
            return (Criteria) this;
        }

        public Criteria andInvitationNameIsNull() {
            addCriterion("invitation_name is null");
            return (Criteria) this;
        }

        public Criteria andInvitationNameIsNotNull() {
            addCriterion("invitation_name is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationNameEqualTo(String value) {
            addCriterion("invitation_name =", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameNotEqualTo(String value) {
            addCriterion("invitation_name <>", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameGreaterThan(String value) {
            addCriterion("invitation_name >", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_name >=", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameLessThan(String value) {
            addCriterion("invitation_name <", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameLessThanOrEqualTo(String value) {
            addCriterion("invitation_name <=", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameLike(String value) {
            addCriterion("invitation_name like", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameNotLike(String value) {
            addCriterion("invitation_name not like", value, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameIn(List<String> values) {
            addCriterion("invitation_name in", values, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameNotIn(List<String> values) {
            addCriterion("invitation_name not in", values, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameBetween(String value1, String value2) {
            addCriterion("invitation_name between", value1, value2, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationNameNotBetween(String value1, String value2) {
            addCriterion("invitation_name not between", value1, value2, "invitationName");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneIsNull() {
            addCriterion("invitation_phone is null");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneIsNotNull() {
            addCriterion("invitation_phone is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneEqualTo(String value) {
            addCriterion("invitation_phone =", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneNotEqualTo(String value) {
            addCriterion("invitation_phone <>", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneGreaterThan(String value) {
            addCriterion("invitation_phone >", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_phone >=", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneLessThan(String value) {
            addCriterion("invitation_phone <", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneLessThanOrEqualTo(String value) {
            addCriterion("invitation_phone <=", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneLike(String value) {
            addCriterion("invitation_phone like", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneNotLike(String value) {
            addCriterion("invitation_phone not like", value, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneIn(List<String> values) {
            addCriterion("invitation_phone in", values, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneNotIn(List<String> values) {
            addCriterion("invitation_phone not in", values, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneBetween(String value1, String value2) {
            addCriterion("invitation_phone between", value1, value2, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationPhoneNotBetween(String value1, String value2) {
            addCriterion("invitation_phone not between", value1, value2, "invitationPhone");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeIsNull() {
            addCriterion("invitation_time is null");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeIsNotNull() {
            addCriterion("invitation_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeEqualTo(Date value) {
            addCriterion("invitation_time =", value, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeNotEqualTo(Date value) {
            addCriterion("invitation_time <>", value, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeGreaterThan(Date value) {
            addCriterion("invitation_time >", value, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invitation_time >=", value, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeLessThan(Date value) {
            addCriterion("invitation_time <", value, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeLessThanOrEqualTo(Date value) {
            addCriterion("invitation_time <=", value, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeIn(List<Date> values) {
            addCriterion("invitation_time in", values, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeNotIn(List<Date> values) {
            addCriterion("invitation_time not in", values, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeBetween(Date value1, Date value2) {
            addCriterion("invitation_time between", value1, value2, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationTimeNotBetween(Date value1, Date value2) {
            addCriterion("invitation_time not between", value1, value2, "invitationTime");
            return (Criteria) this;
        }

        public Criteria andInvitationStateIsNull() {
            addCriterion("invitation_state is null");
            return (Criteria) this;
        }

        public Criteria andInvitationStateIsNotNull() {
            addCriterion("invitation_state is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationStateEqualTo(String value) {
            addCriterion("invitation_state =", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateNotEqualTo(String value) {
            addCriterion("invitation_state <>", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateGreaterThan(String value) {
            addCriterion("invitation_state >", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_state >=", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateLessThan(String value) {
            addCriterion("invitation_state <", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateLessThanOrEqualTo(String value) {
            addCriterion("invitation_state <=", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateLike(String value) {
            addCriterion("invitation_state like", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateNotLike(String value) {
            addCriterion("invitation_state not like", value, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateIn(List<String> values) {
            addCriterion("invitation_state in", values, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateNotIn(List<String> values) {
            addCriterion("invitation_state not in", values, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateBetween(String value1, String value2) {
            addCriterion("invitation_state between", value1, value2, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationStateNotBetween(String value1, String value2) {
            addCriterion("invitation_state not between", value1, value2, "invitationState");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeIsNull() {
            addCriterion("invitation_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeIsNotNull() {
            addCriterion("invitation_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeEqualTo(Date value) {
            addCriterion("invitation_creat_time =", value, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeNotEqualTo(Date value) {
            addCriterion("invitation_creat_time <>", value, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeGreaterThan(Date value) {
            addCriterion("invitation_creat_time >", value, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invitation_creat_time >=", value, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeLessThan(Date value) {
            addCriterion("invitation_creat_time <", value, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("invitation_creat_time <=", value, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeIn(List<Date> values) {
            addCriterion("invitation_creat_time in", values, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeNotIn(List<Date> values) {
            addCriterion("invitation_creat_time not in", values, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeBetween(Date value1, Date value2) {
            addCriterion("invitation_creat_time between", value1, value2, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("invitation_creat_time not between", value1, value2, "invitationCreatTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeIsNull() {
            addCriterion("invitation_update_time is null");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeIsNotNull() {
            addCriterion("invitation_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeEqualTo(Date value) {
            addCriterion("invitation_update_time =", value, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeNotEqualTo(Date value) {
            addCriterion("invitation_update_time <>", value, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeGreaterThan(Date value) {
            addCriterion("invitation_update_time >", value, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("invitation_update_time >=", value, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeLessThan(Date value) {
            addCriterion("invitation_update_time <", value, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("invitation_update_time <=", value, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeIn(List<Date> values) {
            addCriterion("invitation_update_time in", values, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeNotIn(List<Date> values) {
            addCriterion("invitation_update_time not in", values, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("invitation_update_time between", value1, value2, "invitationUpdateTime");
            return (Criteria) this;
        }

        public Criteria andInvitationUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("invitation_update_time not between", value1, value2, "invitationUpdateTime");
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