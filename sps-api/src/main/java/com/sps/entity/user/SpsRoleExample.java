package com.sps.entity.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeIsNull() {
            addCriterion("role_describe is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeIsNotNull() {
            addCriterion("role_describe is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeEqualTo(String value) {
            addCriterion("role_describe =", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotEqualTo(String value) {
            addCriterion("role_describe <>", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeGreaterThan(String value) {
            addCriterion("role_describe >", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("role_describe >=", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeLessThan(String value) {
            addCriterion("role_describe <", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeLessThanOrEqualTo(String value) {
            addCriterion("role_describe <=", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeLike(String value) {
            addCriterion("role_describe like", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotLike(String value) {
            addCriterion("role_describe not like", value, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeIn(List<String> values) {
            addCriterion("role_describe in", values, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotIn(List<String> values) {
            addCriterion("role_describe not in", values, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeBetween(String value1, String value2) {
            addCriterion("role_describe between", value1, value2, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleDescribeNotBetween(String value1, String value2) {
            addCriterion("role_describe not between", value1, value2, "roleDescribe");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterIsNull() {
            addCriterion("role_creater is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterIsNotNull() {
            addCriterion("role_creater is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterEqualTo(String value) {
            addCriterion("role_creater =", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterNotEqualTo(String value) {
            addCriterion("role_creater <>", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterGreaterThan(String value) {
            addCriterion("role_creater >", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("role_creater >=", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterLessThan(String value) {
            addCriterion("role_creater <", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterLessThanOrEqualTo(String value) {
            addCriterion("role_creater <=", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterLike(String value) {
            addCriterion("role_creater like", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterNotLike(String value) {
            addCriterion("role_creater not like", value, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterIn(List<String> values) {
            addCriterion("role_creater in", values, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterNotIn(List<String> values) {
            addCriterion("role_creater not in", values, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterBetween(String value1, String value2) {
            addCriterion("role_creater between", value1, value2, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreaterNotBetween(String value1, String value2) {
            addCriterion("role_creater not between", value1, value2, "roleCreater");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeIsNull() {
            addCriterion("role_creatTime is null");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeIsNotNull() {
            addCriterion("role_creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeEqualTo(Date value) {
            addCriterion("role_creatTime =", value, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeNotEqualTo(Date value) {
            addCriterion("role_creatTime <>", value, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeGreaterThan(Date value) {
            addCriterion("role_creatTime >", value, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("role_creatTime >=", value, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeLessThan(Date value) {
            addCriterion("role_creatTime <", value, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("role_creatTime <=", value, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeIn(List<Date> values) {
            addCriterion("role_creatTime in", values, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeNotIn(List<Date> values) {
            addCriterion("role_creatTime not in", values, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeBetween(Date value1, Date value2) {
            addCriterion("role_creatTime between", value1, value2, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("role_creatTime not between", value1, value2, "roleCreattime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIsNull() {
            addCriterion("role_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIsNotNull() {
            addCriterion("role_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeEqualTo(Date value) {
            addCriterion("role_updateTime =", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotEqualTo(Date value) {
            addCriterion("role_updateTime <>", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeGreaterThan(Date value) {
            addCriterion("role_updateTime >", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("role_updateTime >=", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLessThan(Date value) {
            addCriterion("role_updateTime <", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("role_updateTime <=", value, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeIn(List<Date> values) {
            addCriterion("role_updateTime in", values, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotIn(List<Date> values) {
            addCriterion("role_updateTime not in", values, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("role_updateTime between", value1, value2, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("role_updateTime not between", value1, value2, "roleUpdatetime");
            return (Criteria) this;
        }

        public Criteria andRoleStateIsNull() {
            addCriterion("role_state is null");
            return (Criteria) this;
        }

        public Criteria andRoleStateIsNotNull() {
            addCriterion("role_state is not null");
            return (Criteria) this;
        }

        public Criteria andRoleStateEqualTo(Integer value) {
            addCriterion("role_state =", value, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateNotEqualTo(Integer value) {
            addCriterion("role_state <>", value, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateGreaterThan(Integer value) {
            addCriterion("role_state >", value, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_state >=", value, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateLessThan(Integer value) {
            addCriterion("role_state <", value, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateLessThanOrEqualTo(Integer value) {
            addCriterion("role_state <=", value, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateIn(List<Integer> values) {
            addCriterion("role_state in", values, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateNotIn(List<Integer> values) {
            addCriterion("role_state not in", values, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateBetween(Integer value1, Integer value2) {
            addCriterion("role_state between", value1, value2, "roleState");
            return (Criteria) this;
        }

        public Criteria andRoleStateNotBetween(Integer value1, Integer value2) {
            addCriterion("role_state not between", value1, value2, "roleState");
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