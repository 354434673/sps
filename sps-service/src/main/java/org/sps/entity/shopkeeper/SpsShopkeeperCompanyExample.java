package org.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperCompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperCompanyExample() {
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

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameIsNull() {
            addCriterion("company_shop_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameIsNotNull() {
            addCriterion("company_shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameEqualTo(String value) {
            addCriterion("company_shop_name =", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameNotEqualTo(String value) {
            addCriterion("company_shop_name <>", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameGreaterThan(String value) {
            addCriterion("company_shop_name >", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_shop_name >=", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameLessThan(String value) {
            addCriterion("company_shop_name <", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameLessThanOrEqualTo(String value) {
            addCriterion("company_shop_name <=", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameLike(String value) {
            addCriterion("company_shop_name like", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameNotLike(String value) {
            addCriterion("company_shop_name not like", value, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameIn(List<String> values) {
            addCriterion("company_shop_name in", values, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameNotIn(List<String> values) {
            addCriterion("company_shop_name not in", values, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameBetween(String value1, String value2) {
            addCriterion("company_shop_name between", value1, value2, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyShopNameNotBetween(String value1, String value2) {
            addCriterion("company_shop_name not between", value1, value2, "companyShopName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameIsNull() {
            addCriterion("company_corp_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameIsNotNull() {
            addCriterion("company_corp_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameEqualTo(String value) {
            addCriterion("company_corp_name =", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameNotEqualTo(String value) {
            addCriterion("company_corp_name <>", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameGreaterThan(String value) {
            addCriterion("company_corp_name >", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_corp_name >=", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameLessThan(String value) {
            addCriterion("company_corp_name <", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameLessThanOrEqualTo(String value) {
            addCriterion("company_corp_name <=", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameLike(String value) {
            addCriterion("company_corp_name like", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameNotLike(String value) {
            addCriterion("company_corp_name not like", value, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameIn(List<String> values) {
            addCriterion("company_corp_name in", values, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameNotIn(List<String> values) {
            addCriterion("company_corp_name not in", values, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameBetween(String value1, String value2) {
            addCriterion("company_corp_name between", value1, value2, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyCorpNameNotBetween(String value1, String value2) {
            addCriterion("company_corp_name not between", value1, value2, "companyCorpName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameIsNull() {
            addCriterion("company_business_province_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameIsNotNull() {
            addCriterion("company_business_province_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameEqualTo(String value) {
            addCriterion("company_business_province_name =", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameNotEqualTo(String value) {
            addCriterion("company_business_province_name <>", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameGreaterThan(String value) {
            addCriterion("company_business_province_name >", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_province_name >=", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameLessThan(String value) {
            addCriterion("company_business_province_name <", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("company_business_province_name <=", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameLike(String value) {
            addCriterion("company_business_province_name like", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameNotLike(String value) {
            addCriterion("company_business_province_name not like", value, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameIn(List<String> values) {
            addCriterion("company_business_province_name in", values, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameNotIn(List<String> values) {
            addCriterion("company_business_province_name not in", values, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameBetween(String value1, String value2) {
            addCriterion("company_business_province_name between", value1, value2, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceNameNotBetween(String value1, String value2) {
            addCriterion("company_business_province_name not between", value1, value2, "companyBusinessProvinceName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeIsNull() {
            addCriterion("company_business_province_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeIsNotNull() {
            addCriterion("company_business_province_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeEqualTo(String value) {
            addCriterion("company_business_province_code =", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeNotEqualTo(String value) {
            addCriterion("company_business_province_code <>", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeGreaterThan(String value) {
            addCriterion("company_business_province_code >", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_province_code >=", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeLessThan(String value) {
            addCriterion("company_business_province_code <", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("company_business_province_code <=", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeLike(String value) {
            addCriterion("company_business_province_code like", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeNotLike(String value) {
            addCriterion("company_business_province_code not like", value, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeIn(List<String> values) {
            addCriterion("company_business_province_code in", values, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeNotIn(List<String> values) {
            addCriterion("company_business_province_code not in", values, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeBetween(String value1, String value2) {
            addCriterion("company_business_province_code between", value1, value2, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("company_business_province_code not between", value1, value2, "companyBusinessProvinceCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameIsNull() {
            addCriterion("company_business_city_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameIsNotNull() {
            addCriterion("company_business_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameEqualTo(String value) {
            addCriterion("company_business_city_name =", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameNotEqualTo(String value) {
            addCriterion("company_business_city_name <>", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameGreaterThan(String value) {
            addCriterion("company_business_city_name >", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_city_name >=", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameLessThan(String value) {
            addCriterion("company_business_city_name <", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameLessThanOrEqualTo(String value) {
            addCriterion("company_business_city_name <=", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameLike(String value) {
            addCriterion("company_business_city_name like", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameNotLike(String value) {
            addCriterion("company_business_city_name not like", value, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameIn(List<String> values) {
            addCriterion("company_business_city_name in", values, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameNotIn(List<String> values) {
            addCriterion("company_business_city_name not in", values, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameBetween(String value1, String value2) {
            addCriterion("company_business_city_name between", value1, value2, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityNameNotBetween(String value1, String value2) {
            addCriterion("company_business_city_name not between", value1, value2, "companyBusinessCityName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeIsNull() {
            addCriterion("company_business_city_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeIsNotNull() {
            addCriterion("company_business_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeEqualTo(String value) {
            addCriterion("company_business_city_code =", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeNotEqualTo(String value) {
            addCriterion("company_business_city_code <>", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeGreaterThan(String value) {
            addCriterion("company_business_city_code >", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_city_code >=", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeLessThan(String value) {
            addCriterion("company_business_city_code <", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeLessThanOrEqualTo(String value) {
            addCriterion("company_business_city_code <=", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeLike(String value) {
            addCriterion("company_business_city_code like", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeNotLike(String value) {
            addCriterion("company_business_city_code not like", value, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeIn(List<String> values) {
            addCriterion("company_business_city_code in", values, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeNotIn(List<String> values) {
            addCriterion("company_business_city_code not in", values, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeBetween(String value1, String value2) {
            addCriterion("company_business_city_code between", value1, value2, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessCityCodeNotBetween(String value1, String value2) {
            addCriterion("company_business_city_code not between", value1, value2, "companyBusinessCityCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameIsNull() {
            addCriterion("company_business_area_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameIsNotNull() {
            addCriterion("company_business_area_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameEqualTo(String value) {
            addCriterion("company_business_area_name =", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameNotEqualTo(String value) {
            addCriterion("company_business_area_name <>", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameGreaterThan(String value) {
            addCriterion("company_business_area_name >", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_area_name >=", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameLessThan(String value) {
            addCriterion("company_business_area_name <", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameLessThanOrEqualTo(String value) {
            addCriterion("company_business_area_name <=", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameLike(String value) {
            addCriterion("company_business_area_name like", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameNotLike(String value) {
            addCriterion("company_business_area_name not like", value, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameIn(List<String> values) {
            addCriterion("company_business_area_name in", values, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameNotIn(List<String> values) {
            addCriterion("company_business_area_name not in", values, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameBetween(String value1, String value2) {
            addCriterion("company_business_area_name between", value1, value2, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNameNotBetween(String value1, String value2) {
            addCriterion("company_business_area_name not between", value1, value2, "companyBusinessAreaName");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeIsNull() {
            addCriterion("company_business_area_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeIsNotNull() {
            addCriterion("company_business_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeEqualTo(String value) {
            addCriterion("company_business_area_code =", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeNotEqualTo(String value) {
            addCriterion("company_business_area_code <>", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeGreaterThan(String value) {
            addCriterion("company_business_area_code >", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_area_code >=", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeLessThan(String value) {
            addCriterion("company_business_area_code <", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("company_business_area_code <=", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeLike(String value) {
            addCriterion("company_business_area_code like", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeNotLike(String value) {
            addCriterion("company_business_area_code not like", value, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeIn(List<String> values) {
            addCriterion("company_business_area_code in", values, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeNotIn(List<String> values) {
            addCriterion("company_business_area_code not in", values, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeBetween(String value1, String value2) {
            addCriterion("company_business_area_code between", value1, value2, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaCodeNotBetween(String value1, String value2) {
            addCriterion("company_business_area_code not between", value1, value2, "companyBusinessAreaCode");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngIsNull() {
            addCriterion("company_business_lng is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngIsNotNull() {
            addCriterion("company_business_lng is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngEqualTo(String value) {
            addCriterion("company_business_lng =", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngNotEqualTo(String value) {
            addCriterion("company_business_lng <>", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngGreaterThan(String value) {
            addCriterion("company_business_lng >", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_lng >=", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngLessThan(String value) {
            addCriterion("company_business_lng <", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngLessThanOrEqualTo(String value) {
            addCriterion("company_business_lng <=", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngLike(String value) {
            addCriterion("company_business_lng like", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngNotLike(String value) {
            addCriterion("company_business_lng not like", value, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngIn(List<String> values) {
            addCriterion("company_business_lng in", values, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngNotIn(List<String> values) {
            addCriterion("company_business_lng not in", values, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngBetween(String value1, String value2) {
            addCriterion("company_business_lng between", value1, value2, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLngNotBetween(String value1, String value2) {
            addCriterion("company_business_lng not between", value1, value2, "companyBusinessLng");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatIsNull() {
            addCriterion("company_business_lat is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatIsNotNull() {
            addCriterion("company_business_lat is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatEqualTo(String value) {
            addCriterion("company_business_lat =", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatNotEqualTo(String value) {
            addCriterion("company_business_lat <>", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatGreaterThan(String value) {
            addCriterion("company_business_lat >", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_lat >=", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatLessThan(String value) {
            addCriterion("company_business_lat <", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatLessThanOrEqualTo(String value) {
            addCriterion("company_business_lat <=", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatLike(String value) {
            addCriterion("company_business_lat like", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatNotLike(String value) {
            addCriterion("company_business_lat not like", value, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatIn(List<String> values) {
            addCriterion("company_business_lat in", values, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatNotIn(List<String> values) {
            addCriterion("company_business_lat not in", values, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatBetween(String value1, String value2) {
            addCriterion("company_business_lat between", value1, value2, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessLatNotBetween(String value1, String value2) {
            addCriterion("company_business_lat not between", value1, value2, "companyBusinessLat");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrIsNull() {
            addCriterion("company_business_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrIsNotNull() {
            addCriterion("company_business_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrEqualTo(String value) {
            addCriterion("company_business_addr =", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrNotEqualTo(String value) {
            addCriterion("company_business_addr <>", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrGreaterThan(String value) {
            addCriterion("company_business_addr >", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_addr >=", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrLessThan(String value) {
            addCriterion("company_business_addr <", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrLessThanOrEqualTo(String value) {
            addCriterion("company_business_addr <=", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrLike(String value) {
            addCriterion("company_business_addr like", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrNotLike(String value) {
            addCriterion("company_business_addr not like", value, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrIn(List<String> values) {
            addCriterion("company_business_addr in", values, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrNotIn(List<String> values) {
            addCriterion("company_business_addr not in", values, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrBetween(String value1, String value2) {
            addCriterion("company_business_addr between", value1, value2, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrNotBetween(String value1, String value2) {
            addCriterion("company_business_addr not between", value1, value2, "companyBusinessAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrIsNull() {
            addCriterion("company_gps_addr is null");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrIsNotNull() {
            addCriterion("company_gps_addr is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrEqualTo(String value) {
            addCriterion("company_gps_addr =", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrNotEqualTo(String value) {
            addCriterion("company_gps_addr <>", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrGreaterThan(String value) {
            addCriterion("company_gps_addr >", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrGreaterThanOrEqualTo(String value) {
            addCriterion("company_gps_addr >=", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrLessThan(String value) {
            addCriterion("company_gps_addr <", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrLessThanOrEqualTo(String value) {
            addCriterion("company_gps_addr <=", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrLike(String value) {
            addCriterion("company_gps_addr like", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrNotLike(String value) {
            addCriterion("company_gps_addr not like", value, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrIn(List<String> values) {
            addCriterion("company_gps_addr in", values, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrNotIn(List<String> values) {
            addCriterion("company_gps_addr not in", values, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrBetween(String value1, String value2) {
            addCriterion("company_gps_addr between", value1, value2, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyGpsAddrNotBetween(String value1, String value2) {
            addCriterion("company_gps_addr not between", value1, value2, "companyGpsAddr");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipIsNull() {
            addCriterion("company_business_addr_ownership is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipIsNotNull() {
            addCriterion("company_business_addr_ownership is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipEqualTo(String value) {
            addCriterion("company_business_addr_ownership =", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipNotEqualTo(String value) {
            addCriterion("company_business_addr_ownership <>", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipGreaterThan(String value) {
            addCriterion("company_business_addr_ownership >", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipGreaterThanOrEqualTo(String value) {
            addCriterion("company_business_addr_ownership >=", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipLessThan(String value) {
            addCriterion("company_business_addr_ownership <", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipLessThanOrEqualTo(String value) {
            addCriterion("company_business_addr_ownership <=", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipLike(String value) {
            addCriterion("company_business_addr_ownership like", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipNotLike(String value) {
            addCriterion("company_business_addr_ownership not like", value, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipIn(List<String> values) {
            addCriterion("company_business_addr_ownership in", values, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipNotIn(List<String> values) {
            addCriterion("company_business_addr_ownership not in", values, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipBetween(String value1, String value2) {
            addCriterion("company_business_addr_ownership between", value1, value2, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAddrOwnershipNotBetween(String value1, String value2) {
            addCriterion("company_business_addr_ownership not between", value1, value2, "companyBusinessAddrOwnership");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeIsNull() {
            addCriterion("company_operatio_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeIsNotNull() {
            addCriterion("company_operatio_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeEqualTo(Integer value) {
            addCriterion("company_operatio_time =", value, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeNotEqualTo(Integer value) {
            addCriterion("company_operatio_time <>", value, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeGreaterThan(Integer value) {
            addCriterion("company_operatio_time >", value, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_operatio_time >=", value, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeLessThan(Integer value) {
            addCriterion("company_operatio_time <", value, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeLessThanOrEqualTo(Integer value) {
            addCriterion("company_operatio_time <=", value, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeIn(List<Integer> values) {
            addCriterion("company_operatio_time in", values, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeNotIn(List<Integer> values) {
            addCriterion("company_operatio_time not in", values, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeBetween(Integer value1, Integer value2) {
            addCriterion("company_operatio_time between", value1, value2, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyOperatioTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("company_operatio_time not between", value1, value2, "companyOperatioTime");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumIsNull() {
            addCriterion("company_employee_num is null");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumIsNotNull() {
            addCriterion("company_employee_num is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumEqualTo(Integer value) {
            addCriterion("company_employee_num =", value, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumNotEqualTo(Integer value) {
            addCriterion("company_employee_num <>", value, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumGreaterThan(Integer value) {
            addCriterion("company_employee_num >", value, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_employee_num >=", value, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumLessThan(Integer value) {
            addCriterion("company_employee_num <", value, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumLessThanOrEqualTo(Integer value) {
            addCriterion("company_employee_num <=", value, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumIn(List<Integer> values) {
            addCriterion("company_employee_num in", values, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumNotIn(List<Integer> values) {
            addCriterion("company_employee_num not in", values, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumBetween(Integer value1, Integer value2) {
            addCriterion("company_employee_num between", value1, value2, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyEmployeeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("company_employee_num not between", value1, value2, "companyEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaIsNull() {
            addCriterion("company_business_area is null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaIsNotNull() {
            addCriterion("company_business_area is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaEqualTo(Double value) {
            addCriterion("company_business_area =", value, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNotEqualTo(Double value) {
            addCriterion("company_business_area <>", value, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaGreaterThan(Double value) {
            addCriterion("company_business_area >", value, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("company_business_area >=", value, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaLessThan(Double value) {
            addCriterion("company_business_area <", value, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaLessThanOrEqualTo(Double value) {
            addCriterion("company_business_area <=", value, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaIn(List<Double> values) {
            addCriterion("company_business_area in", values, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNotIn(List<Double> values) {
            addCriterion("company_business_area not in", values, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaBetween(Double value1, Double value2) {
            addCriterion("company_business_area between", value1, value2, "companyBusinessArea");
            return (Criteria) this;
        }

        public Criteria andCompanyBusinessAreaNotBetween(Double value1, Double value2) {
            addCriterion("company_business_area not between", value1, value2, "companyBusinessArea");
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

        public Criteria andCompanyUsernameIsNull() {
            addCriterion("company_username is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameIsNotNull() {
            addCriterion("company_username is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameEqualTo(String value) {
            addCriterion("company_username =", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameNotEqualTo(String value) {
            addCriterion("company_username <>", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameGreaterThan(String value) {
            addCriterion("company_username >", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("company_username >=", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameLessThan(String value) {
            addCriterion("company_username <", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameLessThanOrEqualTo(String value) {
            addCriterion("company_username <=", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameLike(String value) {
            addCriterion("company_username like", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameNotLike(String value) {
            addCriterion("company_username not like", value, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameIn(List<String> values) {
            addCriterion("company_username in", values, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameNotIn(List<String> values) {
            addCriterion("company_username not in", values, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameBetween(String value1, String value2) {
            addCriterion("company_username between", value1, value2, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyUsernameNotBetween(String value1, String value2) {
            addCriterion("company_username not between", value1, value2, "companyUsername");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeIsNull() {
            addCriterion("company_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeIsNotNull() {
            addCriterion("company_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeEqualTo(Date value) {
            addCriterion("company_creat_time =", value, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeNotEqualTo(Date value) {
            addCriterion("company_creat_time <>", value, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeGreaterThan(Date value) {
            addCriterion("company_creat_time >", value, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("company_creat_time >=", value, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeLessThan(Date value) {
            addCriterion("company_creat_time <", value, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("company_creat_time <=", value, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeIn(List<Date> values) {
            addCriterion("company_creat_time in", values, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeNotIn(List<Date> values) {
            addCriterion("company_creat_time not in", values, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeBetween(Date value1, Date value2) {
            addCriterion("company_creat_time between", value1, value2, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("company_creat_time not between", value1, value2, "companyCreatTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeIsNull() {
            addCriterion("company_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeIsNotNull() {
            addCriterion("company_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeEqualTo(Date value) {
            addCriterion("company_update_time =", value, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeNotEqualTo(Date value) {
            addCriterion("company_update_time <>", value, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeGreaterThan(Date value) {
            addCriterion("company_update_time >", value, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("company_update_time >=", value, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeLessThan(Date value) {
            addCriterion("company_update_time <", value, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("company_update_time <=", value, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeIn(List<Date> values) {
            addCriterion("company_update_time in", values, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeNotIn(List<Date> values) {
            addCriterion("company_update_time not in", values, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("company_update_time between", value1, value2, "companyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCompanyUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("company_update_time not between", value1, value2, "companyUpdateTime");
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