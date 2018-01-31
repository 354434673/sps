package org.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperExample() {
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

        public Criteria andShopkeeperIdIsNull() {
            addCriterion("shopkeeper_id is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdIsNotNull() {
            addCriterion("shopkeeper_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdEqualTo(Integer value) {
            addCriterion("shopkeeper_id =", value, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdNotEqualTo(Integer value) {
            addCriterion("shopkeeper_id <>", value, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdGreaterThan(Integer value) {
            addCriterion("shopkeeper_id >", value, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopkeeper_id >=", value, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdLessThan(Integer value) {
            addCriterion("shopkeeper_id <", value, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdLessThanOrEqualTo(Integer value) {
            addCriterion("shopkeeper_id <=", value, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdIn(List<Integer> values) {
            addCriterion("shopkeeper_id in", values, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdNotIn(List<Integer> values) {
            addCriterion("shopkeeper_id not in", values, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdBetween(Integer value1, Integer value2) {
            addCriterion("shopkeeper_id between", value1, value2, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shopkeeper_id not between", value1, value2, "shopkeeperId");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityIsNull() {
            addCriterion("shopkeeper_city is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityIsNotNull() {
            addCriterion("shopkeeper_city is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityEqualTo(String value) {
            addCriterion("shopkeeper_city =", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityNotEqualTo(String value) {
            addCriterion("shopkeeper_city <>", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityGreaterThan(String value) {
            addCriterion("shopkeeper_city >", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_city >=", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityLessThan(String value) {
            addCriterion("shopkeeper_city <", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_city <=", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityLike(String value) {
            addCriterion("shopkeeper_city like", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityNotLike(String value) {
            addCriterion("shopkeeper_city not like", value, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityIn(List<String> values) {
            addCriterion("shopkeeper_city in", values, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityNotIn(List<String> values) {
            addCriterion("shopkeeper_city not in", values, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityBetween(String value1, String value2) {
            addCriterion("shopkeeper_city between", value1, value2, "shopkeeperCity");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCityNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_city not between", value1, value2, "shopkeeperCity");
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

        public Criteria andShopkeeperApproveTypeIsNull() {
            addCriterion("shopkeeper_approve_type is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeIsNotNull() {
            addCriterion("shopkeeper_approve_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeEqualTo(String value) {
            addCriterion("shopkeeper_approve_type =", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeNotEqualTo(String value) {
            addCriterion("shopkeeper_approve_type <>", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeGreaterThan(String value) {
            addCriterion("shopkeeper_approve_type >", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_approve_type >=", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeLessThan(String value) {
            addCriterion("shopkeeper_approve_type <", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_approve_type <=", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeLike(String value) {
            addCriterion("shopkeeper_approve_type like", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeNotLike(String value) {
            addCriterion("shopkeeper_approve_type not like", value, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeIn(List<String> values) {
            addCriterion("shopkeeper_approve_type in", values, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeNotIn(List<String> values) {
            addCriterion("shopkeeper_approve_type not in", values, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeBetween(String value1, String value2) {
            addCriterion("shopkeeper_approve_type between", value1, value2, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveTypeNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_approve_type not between", value1, value2, "shopkeeperApproveType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoIsNull() {
            addCriterion("shopkeeper_approve_no is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoIsNotNull() {
            addCriterion("shopkeeper_approve_no is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoEqualTo(String value) {
            addCriterion("shopkeeper_approve_no =", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoNotEqualTo(String value) {
            addCriterion("shopkeeper_approve_no <>", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoGreaterThan(String value) {
            addCriterion("shopkeeper_approve_no >", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_approve_no >=", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoLessThan(String value) {
            addCriterion("shopkeeper_approve_no <", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_approve_no <=", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoLike(String value) {
            addCriterion("shopkeeper_approve_no like", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoNotLike(String value) {
            addCriterion("shopkeeper_approve_no not like", value, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoIn(List<String> values) {
            addCriterion("shopkeeper_approve_no in", values, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoNotIn(List<String> values) {
            addCriterion("shopkeeper_approve_no not in", values, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoBetween(String value1, String value2) {
            addCriterion("shopkeeper_approve_no between", value1, value2, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperApproveNoNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_approve_no not between", value1, value2, "shopkeeperApproveNo");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductIsNull() {
            addCriterion("shopkeeper_product is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductIsNotNull() {
            addCriterion("shopkeeper_product is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductEqualTo(String value) {
            addCriterion("shopkeeper_product =", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductNotEqualTo(String value) {
            addCriterion("shopkeeper_product <>", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductGreaterThan(String value) {
            addCriterion("shopkeeper_product >", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_product >=", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductLessThan(String value) {
            addCriterion("shopkeeper_product <", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_product <=", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductLike(String value) {
            addCriterion("shopkeeper_product like", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductNotLike(String value) {
            addCriterion("shopkeeper_product not like", value, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductIn(List<String> values) {
            addCriterion("shopkeeper_product in", values, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductNotIn(List<String> values) {
            addCriterion("shopkeeper_product not in", values, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductBetween(String value1, String value2) {
            addCriterion("shopkeeper_product between", value1, value2, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperProductNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_product not between", value1, value2, "shopkeeperProduct");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceIsNull() {
            addCriterion("shopkeeper_register_source is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceIsNotNull() {
            addCriterion("shopkeeper_register_source is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceEqualTo(String value) {
            addCriterion("shopkeeper_register_source =", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceNotEqualTo(String value) {
            addCriterion("shopkeeper_register_source <>", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceGreaterThan(String value) {
            addCriterion("shopkeeper_register_source >", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_register_source >=", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceLessThan(String value) {
            addCriterion("shopkeeper_register_source <", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_register_source <=", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceLike(String value) {
            addCriterion("shopkeeper_register_source like", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceNotLike(String value) {
            addCriterion("shopkeeper_register_source not like", value, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceIn(List<String> values) {
            addCriterion("shopkeeper_register_source in", values, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceNotIn(List<String> values) {
            addCriterion("shopkeeper_register_source not in", values, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceBetween(String value1, String value2) {
            addCriterion("shopkeeper_register_source between", value1, value2, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperRegisterSourceNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_register_source not between", value1, value2, "shopkeeperRegisterSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceIsNull() {
            addCriterion("shopkeeper_client_source is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceIsNotNull() {
            addCriterion("shopkeeper_client_source is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceEqualTo(String value) {
            addCriterion("shopkeeper_client_source =", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceNotEqualTo(String value) {
            addCriterion("shopkeeper_client_source <>", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceGreaterThan(String value) {
            addCriterion("shopkeeper_client_source >", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_client_source >=", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceLessThan(String value) {
            addCriterion("shopkeeper_client_source <", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_client_source <=", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceLike(String value) {
            addCriterion("shopkeeper_client_source like", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceNotLike(String value) {
            addCriterion("shopkeeper_client_source not like", value, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceIn(List<String> values) {
            addCriterion("shopkeeper_client_source in", values, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceNotIn(List<String> values) {
            addCriterion("shopkeeper_client_source not in", values, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceBetween(String value1, String value2) {
            addCriterion("shopkeeper_client_source between", value1, value2, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperClientSourceNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_client_source not between", value1, value2, "shopkeeperClientSource");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeIsNull() {
            addCriterion("shopkeeper_channel_type is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeIsNotNull() {
            addCriterion("shopkeeper_channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeEqualTo(String value) {
            addCriterion("shopkeeper_channel_type =", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeNotEqualTo(String value) {
            addCriterion("shopkeeper_channel_type <>", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeGreaterThan(String value) {
            addCriterion("shopkeeper_channel_type >", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_channel_type >=", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeLessThan(String value) {
            addCriterion("shopkeeper_channel_type <", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_channel_type <=", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeLike(String value) {
            addCriterion("shopkeeper_channel_type like", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeNotLike(String value) {
            addCriterion("shopkeeper_channel_type not like", value, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeIn(List<String> values) {
            addCriterion("shopkeeper_channel_type in", values, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeNotIn(List<String> values) {
            addCriterion("shopkeeper_channel_type not in", values, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeBetween(String value1, String value2) {
            addCriterion("shopkeeper_channel_type between", value1, value2, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperChannelTypeNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_channel_type not between", value1, value2, "shopkeeperChannelType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumIsNull() {
            addCriterion("shopkeeper_default_channel_num is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumIsNotNull() {
            addCriterion("shopkeeper_default_channel_num is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_num =", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumNotEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_num <>", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumGreaterThan(String value) {
            addCriterion("shopkeeper_default_channel_num >", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_num >=", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumLessThan(String value) {
            addCriterion("shopkeeper_default_channel_num <", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_num <=", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumLike(String value) {
            addCriterion("shopkeeper_default_channel_num like", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumNotLike(String value) {
            addCriterion("shopkeeper_default_channel_num not like", value, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumIn(List<String> values) {
            addCriterion("shopkeeper_default_channel_num in", values, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumNotIn(List<String> values) {
            addCriterion("shopkeeper_default_channel_num not in", values, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumBetween(String value1, String value2) {
            addCriterion("shopkeeper_default_channel_num between", value1, value2, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNumNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_default_channel_num not between", value1, value2, "shopkeeperDefaultChannelNum");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameIsNull() {
            addCriterion("shopkeeper_default_channel_name is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameIsNotNull() {
            addCriterion("shopkeeper_default_channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_name =", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameNotEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_name <>", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameGreaterThan(String value) {
            addCriterion("shopkeeper_default_channel_name >", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_name >=", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameLessThan(String value) {
            addCriterion("shopkeeper_default_channel_name <", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_default_channel_name <=", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameLike(String value) {
            addCriterion("shopkeeper_default_channel_name like", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameNotLike(String value) {
            addCriterion("shopkeeper_default_channel_name not like", value, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameIn(List<String> values) {
            addCriterion("shopkeeper_default_channel_name in", values, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameNotIn(List<String> values) {
            addCriterion("shopkeeper_default_channel_name not in", values, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameBetween(String value1, String value2) {
            addCriterion("shopkeeper_default_channel_name between", value1, value2, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperDefaultChannelNameNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_default_channel_name not between", value1, value2, "shopkeeperDefaultChannelName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameIsNull() {
            addCriterion("shopkeeper_salesman_name is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameIsNotNull() {
            addCriterion("shopkeeper_salesman_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameEqualTo(String value) {
            addCriterion("shopkeeper_salesman_name =", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameNotEqualTo(String value) {
            addCriterion("shopkeeper_salesman_name <>", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameGreaterThan(String value) {
            addCriterion("shopkeeper_salesman_name >", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_salesman_name >=", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameLessThan(String value) {
            addCriterion("shopkeeper_salesman_name <", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_salesman_name <=", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameLike(String value) {
            addCriterion("shopkeeper_salesman_name like", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameNotLike(String value) {
            addCriterion("shopkeeper_salesman_name not like", value, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameIn(List<String> values) {
            addCriterion("shopkeeper_salesman_name in", values, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameNotIn(List<String> values) {
            addCriterion("shopkeeper_salesman_name not in", values, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameBetween(String value1, String value2) {
            addCriterion("shopkeeper_salesman_name between", value1, value2, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanNameNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_salesman_name not between", value1, value2, "shopkeeperSalesmanName");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardIsNull() {
            addCriterion("shopkeeper_salesman_idcard is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardIsNotNull() {
            addCriterion("shopkeeper_salesman_idcard is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardEqualTo(String value) {
            addCriterion("shopkeeper_salesman_idcard =", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardNotEqualTo(String value) {
            addCriterion("shopkeeper_salesman_idcard <>", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardGreaterThan(String value) {
            addCriterion("shopkeeper_salesman_idcard >", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_salesman_idcard >=", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardLessThan(String value) {
            addCriterion("shopkeeper_salesman_idcard <", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_salesman_idcard <=", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardLike(String value) {
            addCriterion("shopkeeper_salesman_idcard like", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardNotLike(String value) {
            addCriterion("shopkeeper_salesman_idcard not like", value, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardIn(List<String> values) {
            addCriterion("shopkeeper_salesman_idcard in", values, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardNotIn(List<String> values) {
            addCriterion("shopkeeper_salesman_idcard not in", values, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardBetween(String value1, String value2) {
            addCriterion("shopkeeper_salesman_idcard between", value1, value2, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperSalesmanIdcardNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_salesman_idcard not between", value1, value2, "shopkeeperSalesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeIsNull() {
            addCriterion("shopkeeper_commodity_type is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeIsNotNull() {
            addCriterion("shopkeeper_commodity_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeEqualTo(String value) {
            addCriterion("shopkeeper_commodity_type =", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeNotEqualTo(String value) {
            addCriterion("shopkeeper_commodity_type <>", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeGreaterThan(String value) {
            addCriterion("shopkeeper_commodity_type >", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_commodity_type >=", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeLessThan(String value) {
            addCriterion("shopkeeper_commodity_type <", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_commodity_type <=", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeLike(String value) {
            addCriterion("shopkeeper_commodity_type like", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeNotLike(String value) {
            addCriterion("shopkeeper_commodity_type not like", value, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeIn(List<String> values) {
            addCriterion("shopkeeper_commodity_type in", values, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeNotIn(List<String> values) {
            addCriterion("shopkeeper_commodity_type not in", values, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeBetween(String value1, String value2) {
            addCriterion("shopkeeper_commodity_type between", value1, value2, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCommodityTypeNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_commodity_type not between", value1, value2, "shopkeeperCommodityType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelIsNull() {
            addCriterion("shopkeeper_business_model is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelIsNotNull() {
            addCriterion("shopkeeper_business_model is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelEqualTo(String value) {
            addCriterion("shopkeeper_business_model =", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelNotEqualTo(String value) {
            addCriterion("shopkeeper_business_model <>", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelGreaterThan(String value) {
            addCriterion("shopkeeper_business_model >", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_business_model >=", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelLessThan(String value) {
            addCriterion("shopkeeper_business_model <", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_business_model <=", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelLike(String value) {
            addCriterion("shopkeeper_business_model like", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelNotLike(String value) {
            addCriterion("shopkeeper_business_model not like", value, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelIn(List<String> values) {
            addCriterion("shopkeeper_business_model in", values, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelNotIn(List<String> values) {
            addCriterion("shopkeeper_business_model not in", values, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelBetween(String value1, String value2) {
            addCriterion("shopkeeper_business_model between", value1, value2, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessModelNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_business_model not between", value1, value2, "shopkeeperBusinessModel");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandIsNull() {
            addCriterion("shopkeeper_brand is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandIsNotNull() {
            addCriterion("shopkeeper_brand is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandEqualTo(String value) {
            addCriterion("shopkeeper_brand =", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandNotEqualTo(String value) {
            addCriterion("shopkeeper_brand <>", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandGreaterThan(String value) {
            addCriterion("shopkeeper_brand >", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_brand >=", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandLessThan(String value) {
            addCriterion("shopkeeper_brand <", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_brand <=", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandLike(String value) {
            addCriterion("shopkeeper_brand like", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandNotLike(String value) {
            addCriterion("shopkeeper_brand not like", value, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandIn(List<String> values) {
            addCriterion("shopkeeper_brand in", values, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandNotIn(List<String> values) {
            addCriterion("shopkeeper_brand not in", values, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandBetween(String value1, String value2) {
            addCriterion("shopkeeper_brand between", value1, value2, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBrandNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_brand not between", value1, value2, "shopkeeperBrand");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeIsNull() {
            addCriterion("shopkeeper_business_type is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeIsNotNull() {
            addCriterion("shopkeeper_business_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeEqualTo(String value) {
            addCriterion("shopkeeper_business_type =", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeNotEqualTo(String value) {
            addCriterion("shopkeeper_business_type <>", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeGreaterThan(String value) {
            addCriterion("shopkeeper_business_type >", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_business_type >=", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeLessThan(String value) {
            addCriterion("shopkeeper_business_type <", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_business_type <=", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeLike(String value) {
            addCriterion("shopkeeper_business_type like", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeNotLike(String value) {
            addCriterion("shopkeeper_business_type not like", value, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeIn(List<String> values) {
            addCriterion("shopkeeper_business_type in", values, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeNotIn(List<String> values) {
            addCriterion("shopkeeper_business_type not in", values, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeBetween(String value1, String value2) {
            addCriterion("shopkeeper_business_type between", value1, value2, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperBusinessTypeNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_business_type not between", value1, value2, "shopkeeperBusinessType");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateIsNull() {
            addCriterion("shopkeeper_state is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateIsNotNull() {
            addCriterion("shopkeeper_state is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateEqualTo(Integer value) {
            addCriterion("shopkeeper_state =", value, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateNotEqualTo(Integer value) {
            addCriterion("shopkeeper_state <>", value, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateGreaterThan(Integer value) {
            addCriterion("shopkeeper_state >", value, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("shopkeeper_state >=", value, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateLessThan(Integer value) {
            addCriterion("shopkeeper_state <", value, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateLessThanOrEqualTo(Integer value) {
            addCriterion("shopkeeper_state <=", value, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateIn(List<Integer> values) {
            addCriterion("shopkeeper_state in", values, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateNotIn(List<Integer> values) {
            addCriterion("shopkeeper_state not in", values, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateBetween(Integer value1, Integer value2) {
            addCriterion("shopkeeper_state between", value1, value2, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperStateNotBetween(Integer value1, Integer value2) {
            addCriterion("shopkeeper_state not between", value1, value2, "shopkeeperState");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerIsNull() {
            addCriterion("shopkeeper_referrer is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerIsNotNull() {
            addCriterion("shopkeeper_referrer is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerEqualTo(String value) {
            addCriterion("shopkeeper_referrer =", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerNotEqualTo(String value) {
            addCriterion("shopkeeper_referrer <>", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerGreaterThan(String value) {
            addCriterion("shopkeeper_referrer >", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_referrer >=", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerLessThan(String value) {
            addCriterion("shopkeeper_referrer <", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_referrer <=", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerLike(String value) {
            addCriterion("shopkeeper_referrer like", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerNotLike(String value) {
            addCriterion("shopkeeper_referrer not like", value, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerIn(List<String> values) {
            addCriterion("shopkeeper_referrer in", values, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerNotIn(List<String> values) {
            addCriterion("shopkeeper_referrer not in", values, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerBetween(String value1, String value2) {
            addCriterion("shopkeeper_referrer between", value1, value2, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperReferrerNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_referrer not between", value1, value2, "shopkeeperReferrer");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameIsNull() {
            addCriterion("shopkeeper_username is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameIsNotNull() {
            addCriterion("shopkeeper_username is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameEqualTo(String value) {
            addCriterion("shopkeeper_username =", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameNotEqualTo(String value) {
            addCriterion("shopkeeper_username <>", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameGreaterThan(String value) {
            addCriterion("shopkeeper_username >", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("shopkeeper_username >=", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameLessThan(String value) {
            addCriterion("shopkeeper_username <", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameLessThanOrEqualTo(String value) {
            addCriterion("shopkeeper_username <=", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameLike(String value) {
            addCriterion("shopkeeper_username like", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameNotLike(String value) {
            addCriterion("shopkeeper_username not like", value, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameIn(List<String> values) {
            addCriterion("shopkeeper_username in", values, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameNotIn(List<String> values) {
            addCriterion("shopkeeper_username not in", values, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameBetween(String value1, String value2) {
            addCriterion("shopkeeper_username between", value1, value2, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUsernameNotBetween(String value1, String value2) {
            addCriterion("shopkeeper_username not between", value1, value2, "shopkeeperUsername");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeIsNull() {
            addCriterion("shopkeeper_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeIsNotNull() {
            addCriterion("shopkeeper_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeEqualTo(Date value) {
            addCriterion("shopkeeper_creat_time =", value, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeNotEqualTo(Date value) {
            addCriterion("shopkeeper_creat_time <>", value, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeGreaterThan(Date value) {
            addCriterion("shopkeeper_creat_time >", value, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shopkeeper_creat_time >=", value, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeLessThan(Date value) {
            addCriterion("shopkeeper_creat_time <", value, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("shopkeeper_creat_time <=", value, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeIn(List<Date> values) {
            addCriterion("shopkeeper_creat_time in", values, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeNotIn(List<Date> values) {
            addCriterion("shopkeeper_creat_time not in", values, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeBetween(Date value1, Date value2) {
            addCriterion("shopkeeper_creat_time between", value1, value2, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("shopkeeper_creat_time not between", value1, value2, "shopkeeperCreatTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeIsNull() {
            addCriterion("shopkeeper_update_time is null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeIsNotNull() {
            addCriterion("shopkeeper_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeEqualTo(Date value) {
            addCriterion("shopkeeper_update_time =", value, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeNotEqualTo(Date value) {
            addCriterion("shopkeeper_update_time <>", value, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeGreaterThan(Date value) {
            addCriterion("shopkeeper_update_time >", value, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("shopkeeper_update_time >=", value, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeLessThan(Date value) {
            addCriterion("shopkeeper_update_time <", value, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("shopkeeper_update_time <=", value, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeIn(List<Date> values) {
            addCriterion("shopkeeper_update_time in", values, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeNotIn(List<Date> values) {
            addCriterion("shopkeeper_update_time not in", values, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("shopkeeper_update_time between", value1, value2, "shopkeeperUpdateTime");
            return (Criteria) this;
        }

        public Criteria andShopkeeperUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("shopkeeper_update_time not between", value1, value2, "shopkeeperUpdateTime");
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