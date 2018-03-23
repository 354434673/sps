package com.sps.entity.merchant;

import java.util.ArrayList;
import java.util.List;

public class SpsChannelBusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelBusinessExample() {
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

        public Criteria andBusinessIdIsNull() {
            addCriterion("business_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIsNotNull() {
            addCriterion("business_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIdEqualTo(Integer value) {
            addCriterion("business_id =", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotEqualTo(Integer value) {
            addCriterion("business_id <>", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThan(Integer value) {
            addCriterion("business_id >", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("business_id >=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThan(Integer value) {
            addCriterion("business_id <", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdLessThanOrEqualTo(Integer value) {
            addCriterion("business_id <=", value, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdIn(List<Integer> values) {
            addCriterion("business_id in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotIn(List<Integer> values) {
            addCriterion("business_id not in", values, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdBetween(Integer value1, Integer value2) {
            addCriterion("business_id between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("business_id not between", value1, value2, "businessId");
            return (Criteria) this;
        }

        public Criteria andBusinessProductIsNull() {
            addCriterion("business_product is null");
            return (Criteria) this;
        }

        public Criteria andBusinessProductIsNotNull() {
            addCriterion("business_product is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessProductEqualTo(String value) {
            addCriterion("business_product =", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductNotEqualTo(String value) {
            addCriterion("business_product <>", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductGreaterThan(String value) {
            addCriterion("business_product >", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductGreaterThanOrEqualTo(String value) {
            addCriterion("business_product >=", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductLessThan(String value) {
            addCriterion("business_product <", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductLessThanOrEqualTo(String value) {
            addCriterion("business_product <=", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductLike(String value) {
            addCriterion("business_product like", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductNotLike(String value) {
            addCriterion("business_product not like", value, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductIn(List<String> values) {
            addCriterion("business_product in", values, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductNotIn(List<String> values) {
            addCriterion("business_product not in", values, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductBetween(String value1, String value2) {
            addCriterion("business_product between", value1, value2, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessProductNotBetween(String value1, String value2) {
            addCriterion("business_product not between", value1, value2, "businessProduct");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("business_type is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("business_type is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(String value) {
            addCriterion("business_type =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(String value) {
            addCriterion("business_type <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(String value) {
            addCriterion("business_type >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("business_type >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(String value) {
            addCriterion("business_type <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("business_type <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLike(String value) {
            addCriterion("business_type like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotLike(String value) {
            addCriterion("business_type not like", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<String> values) {
            addCriterion("business_type in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<String> values) {
            addCriterion("business_type not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(String value1, String value2) {
            addCriterion("business_type between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("business_type not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandIsNull() {
            addCriterion("business_brand is null");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandIsNotNull() {
            addCriterion("business_brand is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandEqualTo(String value) {
            addCriterion("business_brand =", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandNotEqualTo(String value) {
            addCriterion("business_brand <>", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandGreaterThan(String value) {
            addCriterion("business_brand >", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandGreaterThanOrEqualTo(String value) {
            addCriterion("business_brand >=", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandLessThan(String value) {
            addCriterion("business_brand <", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandLessThanOrEqualTo(String value) {
            addCriterion("business_brand <=", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandLike(String value) {
            addCriterion("business_brand like", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandNotLike(String value) {
            addCriterion("business_brand not like", value, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandIn(List<String> values) {
            addCriterion("business_brand in", values, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandNotIn(List<String> values) {
            addCriterion("business_brand not in", values, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandBetween(String value1, String value2) {
            addCriterion("business_brand between", value1, value2, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessBrandNotBetween(String value1, String value2) {
            addCriterion("business_brand not between", value1, value2, "businessBrand");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("business_scope is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("business_scope is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("business_scope =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("business_scope <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("business_scope >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("business_scope >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("business_scope <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("business_scope <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("business_scope like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("business_scope not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("business_scope in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("business_scope not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("business_scope between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("business_scope not between", value1, value2, "businessScope");
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