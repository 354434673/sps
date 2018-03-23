package com.sps.entity.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsMenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNull() {
            addCriterion("menu_name is null");
            return (Criteria) this;
        }

        public Criteria andMenuNameIsNotNull() {
            addCriterion("menu_name is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNameEqualTo(String value) {
            addCriterion("menu_name =", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotEqualTo(String value) {
            addCriterion("menu_name <>", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThan(String value) {
            addCriterion("menu_name >", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameGreaterThanOrEqualTo(String value) {
            addCriterion("menu_name >=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThan(String value) {
            addCriterion("menu_name <", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLessThanOrEqualTo(String value) {
            addCriterion("menu_name <=", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameLike(String value) {
            addCriterion("menu_name like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotLike(String value) {
            addCriterion("menu_name not like", value, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameIn(List<String> values) {
            addCriterion("menu_name in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotIn(List<String> values) {
            addCriterion("menu_name not in", values, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameBetween(String value1, String value2) {
            addCriterion("menu_name between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNameNotBetween(String value1, String value2) {
            addCriterion("menu_name not between", value1, value2, "menuName");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeIsNull() {
            addCriterion("menu_nodeType is null");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeIsNotNull() {
            addCriterion("menu_nodeType is not null");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeEqualTo(Integer value) {
            addCriterion("menu_nodeType =", value, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeNotEqualTo(Integer value) {
            addCriterion("menu_nodeType <>", value, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeGreaterThan(Integer value) {
            addCriterion("menu_nodeType >", value, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_nodeType >=", value, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeLessThan(Integer value) {
            addCriterion("menu_nodeType <", value, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeLessThanOrEqualTo(Integer value) {
            addCriterion("menu_nodeType <=", value, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeIn(List<Integer> values) {
            addCriterion("menu_nodeType in", values, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeNotIn(List<Integer> values) {
            addCriterion("menu_nodeType not in", values, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeBetween(Integer value1, Integer value2) {
            addCriterion("menu_nodeType between", value1, value2, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuNodetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_nodeType not between", value1, value2, "menuNodetype");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNull() {
            addCriterion("menu_url is null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIsNotNull() {
            addCriterion("menu_url is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUrlEqualTo(String value) {
            addCriterion("menu_url =", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotEqualTo(String value) {
            addCriterion("menu_url <>", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThan(String value) {
            addCriterion("menu_url >", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlGreaterThanOrEqualTo(String value) {
            addCriterion("menu_url >=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThan(String value) {
            addCriterion("menu_url <", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLessThanOrEqualTo(String value) {
            addCriterion("menu_url <=", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlLike(String value) {
            addCriterion("menu_url like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotLike(String value) {
            addCriterion("menu_url not like", value, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlIn(List<String> values) {
            addCriterion("menu_url in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotIn(List<String> values) {
            addCriterion("menu_url not in", values, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlBetween(String value1, String value2) {
            addCriterion("menu_url between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuUrlNotBetween(String value1, String value2) {
            addCriterion("menu_url not between", value1, value2, "menuUrl");
            return (Criteria) this;
        }

        public Criteria andMenuParentidIsNull() {
            addCriterion("menu_parentId is null");
            return (Criteria) this;
        }

        public Criteria andMenuParentidIsNotNull() {
            addCriterion("menu_parentId is not null");
            return (Criteria) this;
        }

        public Criteria andMenuParentidEqualTo(Integer value) {
            addCriterion("menu_parentId =", value, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidNotEqualTo(Integer value) {
            addCriterion("menu_parentId <>", value, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidGreaterThan(Integer value) {
            addCriterion("menu_parentId >", value, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_parentId >=", value, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidLessThan(Integer value) {
            addCriterion("menu_parentId <", value, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidLessThanOrEqualTo(Integer value) {
            addCriterion("menu_parentId <=", value, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidIn(List<Integer> values) {
            addCriterion("menu_parentId in", values, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidNotIn(List<Integer> values) {
            addCriterion("menu_parentId not in", values, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidBetween(Integer value1, Integer value2) {
            addCriterion("menu_parentId between", value1, value2, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_parentId not between", value1, value2, "menuParentid");
            return (Criteria) this;
        }

        public Criteria andMenuStateIsNull() {
            addCriterion("menu_state is null");
            return (Criteria) this;
        }

        public Criteria andMenuStateIsNotNull() {
            addCriterion("menu_state is not null");
            return (Criteria) this;
        }

        public Criteria andMenuStateEqualTo(Integer value) {
            addCriterion("menu_state =", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotEqualTo(Integer value) {
            addCriterion("menu_state <>", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateGreaterThan(Integer value) {
            addCriterion("menu_state >", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_state >=", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateLessThan(Integer value) {
            addCriterion("menu_state <", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateLessThanOrEqualTo(Integer value) {
            addCriterion("menu_state <=", value, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateIn(List<Integer> values) {
            addCriterion("menu_state in", values, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotIn(List<Integer> values) {
            addCriterion("menu_state not in", values, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateBetween(Integer value1, Integer value2) {
            addCriterion("menu_state between", value1, value2, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuStateNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_state not between", value1, value2, "menuState");
            return (Criteria) this;
        }

        public Criteria andMenuSortIsNull() {
            addCriterion("menu_sort is null");
            return (Criteria) this;
        }

        public Criteria andMenuSortIsNotNull() {
            addCriterion("menu_sort is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSortEqualTo(Integer value) {
            addCriterion("menu_sort =", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortNotEqualTo(Integer value) {
            addCriterion("menu_sort <>", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortGreaterThan(Integer value) {
            addCriterion("menu_sort >", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_sort >=", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortLessThan(Integer value) {
            addCriterion("menu_sort <", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortLessThanOrEqualTo(Integer value) {
            addCriterion("menu_sort <=", value, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortIn(List<Integer> values) {
            addCriterion("menu_sort in", values, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortNotIn(List<Integer> values) {
            addCriterion("menu_sort not in", values, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortBetween(Integer value1, Integer value2) {
            addCriterion("menu_sort between", value1, value2, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuSortNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_sort not between", value1, value2, "menuSort");
            return (Criteria) this;
        }

        public Criteria andMenuMarkIsNull() {
            addCriterion("menu_mark is null");
            return (Criteria) this;
        }

        public Criteria andMenuMarkIsNotNull() {
            addCriterion("menu_mark is not null");
            return (Criteria) this;
        }

        public Criteria andMenuMarkEqualTo(Integer value) {
            addCriterion("menu_mark =", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotEqualTo(Integer value) {
            addCriterion("menu_mark <>", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkGreaterThan(Integer value) {
            addCriterion("menu_mark >", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_mark >=", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkLessThan(Integer value) {
            addCriterion("menu_mark <", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkLessThanOrEqualTo(Integer value) {
            addCriterion("menu_mark <=", value, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkIn(List<Integer> values) {
            addCriterion("menu_mark in", values, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotIn(List<Integer> values) {
            addCriterion("menu_mark not in", values, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkBetween(Integer value1, Integer value2) {
            addCriterion("menu_mark between", value1, value2, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_mark not between", value1, value2, "menuMark");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterIsNull() {
            addCriterion("menu_creater is null");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterIsNotNull() {
            addCriterion("menu_creater is not null");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterEqualTo(String value) {
            addCriterion("menu_creater =", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterNotEqualTo(String value) {
            addCriterion("menu_creater <>", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterGreaterThan(String value) {
            addCriterion("menu_creater >", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("menu_creater >=", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterLessThan(String value) {
            addCriterion("menu_creater <", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterLessThanOrEqualTo(String value) {
            addCriterion("menu_creater <=", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterLike(String value) {
            addCriterion("menu_creater like", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterNotLike(String value) {
            addCriterion("menu_creater not like", value, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterIn(List<String> values) {
            addCriterion("menu_creater in", values, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterNotIn(List<String> values) {
            addCriterion("menu_creater not in", values, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterBetween(String value1, String value2) {
            addCriterion("menu_creater between", value1, value2, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreaterNotBetween(String value1, String value2) {
            addCriterion("menu_creater not between", value1, value2, "menuCreater");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeIsNull() {
            addCriterion("menu_creatTime is null");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeIsNotNull() {
            addCriterion("menu_creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeEqualTo(Date value) {
            addCriterion("menu_creatTime =", value, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeNotEqualTo(Date value) {
            addCriterion("menu_creatTime <>", value, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeGreaterThan(Date value) {
            addCriterion("menu_creatTime >", value, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("menu_creatTime >=", value, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeLessThan(Date value) {
            addCriterion("menu_creatTime <", value, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("menu_creatTime <=", value, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeIn(List<Date> values) {
            addCriterion("menu_creatTime in", values, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeNotIn(List<Date> values) {
            addCriterion("menu_creatTime not in", values, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeBetween(Date value1, Date value2) {
            addCriterion("menu_creatTime between", value1, value2, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("menu_creatTime not between", value1, value2, "menuCreattime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeIsNull() {
            addCriterion("menu_updateTime is null");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeIsNotNull() {
            addCriterion("menu_updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeEqualTo(Date value) {
            addCriterion("menu_updateTime =", value, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeNotEqualTo(Date value) {
            addCriterion("menu_updateTime <>", value, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeGreaterThan(Date value) {
            addCriterion("menu_updateTime >", value, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("menu_updateTime >=", value, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeLessThan(Date value) {
            addCriterion("menu_updateTime <", value, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("menu_updateTime <=", value, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeIn(List<Date> values) {
            addCriterion("menu_updateTime in", values, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeNotIn(List<Date> values) {
            addCriterion("menu_updateTime not in", values, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("menu_updateTime between", value1, value2, "menuUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMenuUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("menu_updateTime not between", value1, value2, "menuUpdatetime");
            return (Criteria) this;
        }
        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("r1.role_id in", values, "roldId");
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