package com.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperPersonalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperPersonalExample() {
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

        public Criteria andPersonalIdIsNull() {
            addCriterion("personal_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdIsNotNull() {
            addCriterion("personal_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdEqualTo(Integer value) {
            addCriterion("personal_id =", value, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdNotEqualTo(Integer value) {
            addCriterion("personal_id <>", value, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdGreaterThan(Integer value) {
            addCriterion("personal_id >", value, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("personal_id >=", value, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdLessThan(Integer value) {
            addCriterion("personal_id <", value, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdLessThanOrEqualTo(Integer value) {
            addCriterion("personal_id <=", value, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdIn(List<Integer> values) {
            addCriterion("personal_id in", values, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdNotIn(List<Integer> values) {
            addCriterion("personal_id not in", values, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdBetween(Integer value1, Integer value2) {
            addCriterion("personal_id between", value1, value2, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("personal_id not between", value1, value2, "personalId");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameIsNull() {
            addCriterion("personal_client_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameIsNotNull() {
            addCriterion("personal_client_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameEqualTo(String value) {
            addCriterion("personal_client_name =", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameNotEqualTo(String value) {
            addCriterion("personal_client_name <>", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameGreaterThan(String value) {
            addCriterion("personal_client_name >", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("personal_client_name >=", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameLessThan(String value) {
            addCriterion("personal_client_name <", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameLessThanOrEqualTo(String value) {
            addCriterion("personal_client_name <=", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameLike(String value) {
            addCriterion("personal_client_name like", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameNotLike(String value) {
            addCriterion("personal_client_name not like", value, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameIn(List<String> values) {
            addCriterion("personal_client_name in", values, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameNotIn(List<String> values) {
            addCriterion("personal_client_name not in", values, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameBetween(String value1, String value2) {
            addCriterion("personal_client_name between", value1, value2, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalClientNameNotBetween(String value1, String value2) {
            addCriterion("personal_client_name not between", value1, value2, "personalClientName");
            return (Criteria) this;
        }

        public Criteria andPersonalSexIsNull() {
            addCriterion("personal_sex is null");
            return (Criteria) this;
        }

        public Criteria andPersonalSexIsNotNull() {
            addCriterion("personal_sex is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalSexEqualTo(String value) {
            addCriterion("personal_sex =", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexNotEqualTo(String value) {
            addCriterion("personal_sex <>", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexGreaterThan(String value) {
            addCriterion("personal_sex >", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexGreaterThanOrEqualTo(String value) {
            addCriterion("personal_sex >=", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexLessThan(String value) {
            addCriterion("personal_sex <", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexLessThanOrEqualTo(String value) {
            addCriterion("personal_sex <=", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexLike(String value) {
            addCriterion("personal_sex like", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexNotLike(String value) {
            addCriterion("personal_sex not like", value, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexIn(List<String> values) {
            addCriterion("personal_sex in", values, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexNotIn(List<String> values) {
            addCriterion("personal_sex not in", values, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexBetween(String value1, String value2) {
            addCriterion("personal_sex between", value1, value2, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalSexNotBetween(String value1, String value2) {
            addCriterion("personal_sex not between", value1, value2, "personalSex");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardIsNull() {
            addCriterion("personal_idCard is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardIsNotNull() {
            addCriterion("personal_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardEqualTo(String value) {
            addCriterion("personal_idCard =", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardNotEqualTo(String value) {
            addCriterion("personal_idCard <>", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardGreaterThan(String value) {
            addCriterion("personal_idCard >", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("personal_idCard >=", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardLessThan(String value) {
            addCriterion("personal_idCard <", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardLessThanOrEqualTo(String value) {
            addCriterion("personal_idCard <=", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardLike(String value) {
            addCriterion("personal_idCard like", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardNotLike(String value) {
            addCriterion("personal_idCard not like", value, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardIn(List<String> values) {
            addCriterion("personal_idCard in", values, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardNotIn(List<String> values) {
            addCriterion("personal_idCard not in", values, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardBetween(String value1, String value2) {
            addCriterion("personal_idCard between", value1, value2, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardNotBetween(String value1, String value2) {
            addCriterion("personal_idCard not between", value1, value2, "personalIdcard");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartIsNull() {
            addCriterion("personal_idCard_validity_start is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartIsNotNull() {
            addCriterion("personal_idCard_validity_start is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartEqualTo(String value) {
            addCriterion("personal_idCard_validity_start =", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartNotEqualTo(String value) {
            addCriterion("personal_idCard_validity_start <>", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartGreaterThan(String value) {
            addCriterion("personal_idCard_validity_start >", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartGreaterThanOrEqualTo(String value) {
            addCriterion("personal_idCard_validity_start >=", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartLessThan(String value) {
            addCriterion("personal_idCard_validity_start <", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartLessThanOrEqualTo(String value) {
            addCriterion("personal_idCard_validity_start <=", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartLike(String value) {
            addCriterion("personal_idCard_validity_start like", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartNotLike(String value) {
            addCriterion("personal_idCard_validity_start not like", value, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartIn(List<String> values) {
            addCriterion("personal_idCard_validity_start in", values, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartNotIn(List<String> values) {
            addCriterion("personal_idCard_validity_start not in", values, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartBetween(String value1, String value2) {
            addCriterion("personal_idCard_validity_start between", value1, value2, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityStartNotBetween(String value1, String value2) {
            addCriterion("personal_idCard_validity_start not between", value1, value2, "personalIdcardValidityStart");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndIsNull() {
            addCriterion("personal_idCard_validity_end is null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndIsNotNull() {
            addCriterion("personal_idCard_validity_end is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndEqualTo(String value) {
            addCriterion("personal_idCard_validity_end =", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndNotEqualTo(String value) {
            addCriterion("personal_idCard_validity_end <>", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndGreaterThan(String value) {
            addCriterion("personal_idCard_validity_end >", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndGreaterThanOrEqualTo(String value) {
            addCriterion("personal_idCard_validity_end >=", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndLessThan(String value) {
            addCriterion("personal_idCard_validity_end <", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndLessThanOrEqualTo(String value) {
            addCriterion("personal_idCard_validity_end <=", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndLike(String value) {
            addCriterion("personal_idCard_validity_end like", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndNotLike(String value) {
            addCriterion("personal_idCard_validity_end not like", value, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndIn(List<String> values) {
            addCriterion("personal_idCard_validity_end in", values, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndNotIn(List<String> values) {
            addCriterion("personal_idCard_validity_end not in", values, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndBetween(String value1, String value2) {
            addCriterion("personal_idCard_validity_end between", value1, value2, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalIdcardValidityEndNotBetween(String value1, String value2) {
            addCriterion("personal_idCard_validity_end not between", value1, value2, "personalIdcardValidityEnd");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityIsNull() {
            addCriterion("personal_licence_issuing_authority is null");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityIsNotNull() {
            addCriterion("personal_licence_issuing_authority is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityEqualTo(String value) {
            addCriterion("personal_licence_issuing_authority =", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityNotEqualTo(String value) {
            addCriterion("personal_licence_issuing_authority <>", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityGreaterThan(String value) {
            addCriterion("personal_licence_issuing_authority >", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityGreaterThanOrEqualTo(String value) {
            addCriterion("personal_licence_issuing_authority >=", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityLessThan(String value) {
            addCriterion("personal_licence_issuing_authority <", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityLessThanOrEqualTo(String value) {
            addCriterion("personal_licence_issuing_authority <=", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityLike(String value) {
            addCriterion("personal_licence_issuing_authority like", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityNotLike(String value) {
            addCriterion("personal_licence_issuing_authority not like", value, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityIn(List<String> values) {
            addCriterion("personal_licence_issuing_authority in", values, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityNotIn(List<String> values) {
            addCriterion("personal_licence_issuing_authority not in", values, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityBetween(String value1, String value2) {
            addCriterion("personal_licence_issuing_authority between", value1, value2, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalLicenceIssuingAuthorityNotBetween(String value1, String value2) {
            addCriterion("personal_licence_issuing_authority not between", value1, value2, "personalLicenceIssuingAuthority");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeIsNull() {
            addCriterion("personal_age is null");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeIsNotNull() {
            addCriterion("personal_age is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeEqualTo(Integer value) {
            addCriterion("personal_age =", value, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeNotEqualTo(Integer value) {
            addCriterion("personal_age <>", value, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeGreaterThan(Integer value) {
            addCriterion("personal_age >", value, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("personal_age >=", value, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeLessThan(Integer value) {
            addCriterion("personal_age <", value, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeLessThanOrEqualTo(Integer value) {
            addCriterion("personal_age <=", value, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeIn(List<Integer> values) {
            addCriterion("personal_age in", values, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeNotIn(List<Integer> values) {
            addCriterion("personal_age not in", values, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeBetween(Integer value1, Integer value2) {
            addCriterion("personal_age between", value1, value2, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("personal_age not between", value1, value2, "personalAge");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusIsNull() {
            addCriterion("personal_marital_status is null");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusIsNotNull() {
            addCriterion("personal_marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusEqualTo(String value) {
            addCriterion("personal_marital_status =", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusNotEqualTo(String value) {
            addCriterion("personal_marital_status <>", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusGreaterThan(String value) {
            addCriterion("personal_marital_status >", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("personal_marital_status >=", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusLessThan(String value) {
            addCriterion("personal_marital_status <", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusLessThanOrEqualTo(String value) {
            addCriterion("personal_marital_status <=", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusLike(String value) {
            addCriterion("personal_marital_status like", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusNotLike(String value) {
            addCriterion("personal_marital_status not like", value, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusIn(List<String> values) {
            addCriterion("personal_marital_status in", values, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusNotIn(List<String> values) {
            addCriterion("personal_marital_status not in", values, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusBetween(String value1, String value2) {
            addCriterion("personal_marital_status between", value1, value2, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalMaritalStatusNotBetween(String value1, String value2) {
            addCriterion("personal_marital_status not between", value1, value2, "personalMaritalStatus");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneIsNull() {
            addCriterion("personal_phone is null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneIsNotNull() {
            addCriterion("personal_phone is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneEqualTo(String value) {
            addCriterion("personal_phone =", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneNotEqualTo(String value) {
            addCriterion("personal_phone <>", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneGreaterThan(String value) {
            addCriterion("personal_phone >", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("personal_phone >=", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneLessThan(String value) {
            addCriterion("personal_phone <", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneLessThanOrEqualTo(String value) {
            addCriterion("personal_phone <=", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneLike(String value) {
            addCriterion("personal_phone like", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneNotLike(String value) {
            addCriterion("personal_phone not like", value, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneIn(List<String> values) {
            addCriterion("personal_phone in", values, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneNotIn(List<String> values) {
            addCriterion("personal_phone not in", values, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneBetween(String value1, String value2) {
            addCriterion("personal_phone between", value1, value2, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhoneNotBetween(String value1, String value2) {
            addCriterion("personal_phone not between", value1, value2, "personalPhone");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordIsNull() {
            addCriterion("personal_phone_password is null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordIsNotNull() {
            addCriterion("personal_phone_password is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordEqualTo(String value) {
            addCriterion("personal_phone_password =", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordNotEqualTo(String value) {
            addCriterion("personal_phone_password <>", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordGreaterThan(String value) {
            addCriterion("personal_phone_password >", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("personal_phone_password >=", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordLessThan(String value) {
            addCriterion("personal_phone_password <", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordLessThanOrEqualTo(String value) {
            addCriterion("personal_phone_password <=", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordLike(String value) {
            addCriterion("personal_phone_password like", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordNotLike(String value) {
            addCriterion("personal_phone_password not like", value, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordIn(List<String> values) {
            addCriterion("personal_phone_password in", values, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordNotIn(List<String> values) {
            addCriterion("personal_phone_password not in", values, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordBetween(String value1, String value2) {
            addCriterion("personal_phone_password between", value1, value2, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPhonePasswordNotBetween(String value1, String value2) {
            addCriterion("personal_phone_password not between", value1, value2, "personalPhonePassword");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileIsNull() {
            addCriterion("personal_placeOfDomicile is null");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileIsNotNull() {
            addCriterion("personal_placeOfDomicile is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileEqualTo(String value) {
            addCriterion("personal_placeOfDomicile =", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileNotEqualTo(String value) {
            addCriterion("personal_placeOfDomicile <>", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileGreaterThan(String value) {
            addCriterion("personal_placeOfDomicile >", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileGreaterThanOrEqualTo(String value) {
            addCriterion("personal_placeOfDomicile >=", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileLessThan(String value) {
            addCriterion("personal_placeOfDomicile <", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileLessThanOrEqualTo(String value) {
            addCriterion("personal_placeOfDomicile <=", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileLike(String value) {
            addCriterion("personal_placeOfDomicile like", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileNotLike(String value) {
            addCriterion("personal_placeOfDomicile not like", value, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileIn(List<String> values) {
            addCriterion("personal_placeOfDomicile in", values, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileNotIn(List<String> values) {
            addCriterion("personal_placeOfDomicile not in", values, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileBetween(String value1, String value2) {
            addCriterion("personal_placeOfDomicile between", value1, value2, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalPlaceofdomicileNotBetween(String value1, String value2) {
            addCriterion("personal_placeOfDomicile not between", value1, value2, "personalPlaceofdomicile");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionIsNull() {
            addCriterion("personal_living_condition is null");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionIsNotNull() {
            addCriterion("personal_living_condition is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionEqualTo(String value) {
            addCriterion("personal_living_condition =", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionNotEqualTo(String value) {
            addCriterion("personal_living_condition <>", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionGreaterThan(String value) {
            addCriterion("personal_living_condition >", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionGreaterThanOrEqualTo(String value) {
            addCriterion("personal_living_condition >=", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionLessThan(String value) {
            addCriterion("personal_living_condition <", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionLessThanOrEqualTo(String value) {
            addCriterion("personal_living_condition <=", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionLike(String value) {
            addCriterion("personal_living_condition like", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionNotLike(String value) {
            addCriterion("personal_living_condition not like", value, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionIn(List<String> values) {
            addCriterion("personal_living_condition in", values, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionNotIn(List<String> values) {
            addCriterion("personal_living_condition not in", values, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionBetween(String value1, String value2) {
            addCriterion("personal_living_condition between", value1, value2, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionNotBetween(String value1, String value2) {
            addCriterion("personal_living_condition not between", value1, value2, "personalLivingCondition");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherIsNull() {
            addCriterion("personal_living_condition_other is null");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherIsNotNull() {
            addCriterion("personal_living_condition_other is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherEqualTo(String value) {
            addCriterion("personal_living_condition_other =", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherNotEqualTo(String value) {
            addCriterion("personal_living_condition_other <>", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherGreaterThan(String value) {
            addCriterion("personal_living_condition_other >", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherGreaterThanOrEqualTo(String value) {
            addCriterion("personal_living_condition_other >=", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherLessThan(String value) {
            addCriterion("personal_living_condition_other <", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherLessThanOrEqualTo(String value) {
            addCriterion("personal_living_condition_other <=", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherLike(String value) {
            addCriterion("personal_living_condition_other like", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherNotLike(String value) {
            addCriterion("personal_living_condition_other not like", value, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherIn(List<String> values) {
            addCriterion("personal_living_condition_other in", values, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherNotIn(List<String> values) {
            addCriterion("personal_living_condition_other not in", values, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherBetween(String value1, String value2) {
            addCriterion("personal_living_condition_other between", value1, value2, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingConditionOtherNotBetween(String value1, String value2) {
            addCriterion("personal_living_condition_other not between", value1, value2, "personalLivingConditionOther");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressIsNull() {
            addCriterion("personal_living_address is null");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressIsNotNull() {
            addCriterion("personal_living_address is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressEqualTo(String value) {
            addCriterion("personal_living_address =", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressNotEqualTo(String value) {
            addCriterion("personal_living_address <>", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressGreaterThan(String value) {
            addCriterion("personal_living_address >", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("personal_living_address >=", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressLessThan(String value) {
            addCriterion("personal_living_address <", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressLessThanOrEqualTo(String value) {
            addCriterion("personal_living_address <=", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressLike(String value) {
            addCriterion("personal_living_address like", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressNotLike(String value) {
            addCriterion("personal_living_address not like", value, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressIn(List<String> values) {
            addCriterion("personal_living_address in", values, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressNotIn(List<String> values) {
            addCriterion("personal_living_address not in", values, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressBetween(String value1, String value2) {
            addCriterion("personal_living_address between", value1, value2, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalLivingAddressNotBetween(String value1, String value2) {
            addCriterion("personal_living_address not between", value1, value2, "personalLivingAddress");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpIsNull() {
            addCriterion("personal_none_corp is null");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpIsNotNull() {
            addCriterion("personal_none_corp is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpEqualTo(String value) {
            addCriterion("personal_none_corp =", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpNotEqualTo(String value) {
            addCriterion("personal_none_corp <>", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpGreaterThan(String value) {
            addCriterion("personal_none_corp >", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpGreaterThanOrEqualTo(String value) {
            addCriterion("personal_none_corp >=", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpLessThan(String value) {
            addCriterion("personal_none_corp <", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpLessThanOrEqualTo(String value) {
            addCriterion("personal_none_corp <=", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpLike(String value) {
            addCriterion("personal_none_corp like", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpNotLike(String value) {
            addCriterion("personal_none_corp not like", value, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpIn(List<String> values) {
            addCriterion("personal_none_corp in", values, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpNotIn(List<String> values) {
            addCriterion("personal_none_corp not in", values, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpBetween(String value1, String value2) {
            addCriterion("personal_none_corp between", value1, value2, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNoneCorpNotBetween(String value1, String value2) {
            addCriterion("personal_none_corp not between", value1, value2, "personalNoneCorp");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameIsNull() {
            addCriterion("personal_nickname is null");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameIsNotNull() {
            addCriterion("personal_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameEqualTo(String value) {
            addCriterion("personal_nickname =", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameNotEqualTo(String value) {
            addCriterion("personal_nickname <>", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameGreaterThan(String value) {
            addCriterion("personal_nickname >", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("personal_nickname >=", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameLessThan(String value) {
            addCriterion("personal_nickname <", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameLessThanOrEqualTo(String value) {
            addCriterion("personal_nickname <=", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameLike(String value) {
            addCriterion("personal_nickname like", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameNotLike(String value) {
            addCriterion("personal_nickname not like", value, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameIn(List<String> values) {
            addCriterion("personal_nickname in", values, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameNotIn(List<String> values) {
            addCriterion("personal_nickname not in", values, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameBetween(String value1, String value2) {
            addCriterion("personal_nickname between", value1, value2, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalNicknameNotBetween(String value1, String value2) {
            addCriterion("personal_nickname not between", value1, value2, "personalNickname");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameIsNull() {
            addCriterion("personal_username is null");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameIsNotNull() {
            addCriterion("personal_username is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameEqualTo(String value) {
            addCriterion("personal_username =", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameNotEqualTo(String value) {
            addCriterion("personal_username <>", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameGreaterThan(String value) {
            addCriterion("personal_username >", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("personal_username >=", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameLessThan(String value) {
            addCriterion("personal_username <", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameLessThanOrEqualTo(String value) {
            addCriterion("personal_username <=", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameLike(String value) {
            addCriterion("personal_username like", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameNotLike(String value) {
            addCriterion("personal_username not like", value, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameIn(List<String> values) {
            addCriterion("personal_username in", values, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameNotIn(List<String> values) {
            addCriterion("personal_username not in", values, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameBetween(String value1, String value2) {
            addCriterion("personal_username between", value1, value2, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalUsernameNotBetween(String value1, String value2) {
            addCriterion("personal_username not between", value1, value2, "personalUsername");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeIsNull() {
            addCriterion("personal_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeIsNotNull() {
            addCriterion("personal_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeEqualTo(Date value) {
            addCriterion("personal_creat_time =", value, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeNotEqualTo(Date value) {
            addCriterion("personal_creat_time <>", value, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeGreaterThan(Date value) {
            addCriterion("personal_creat_time >", value, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("personal_creat_time >=", value, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeLessThan(Date value) {
            addCriterion("personal_creat_time <", value, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("personal_creat_time <=", value, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeIn(List<Date> values) {
            addCriterion("personal_creat_time in", values, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeNotIn(List<Date> values) {
            addCriterion("personal_creat_time not in", values, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeBetween(Date value1, Date value2) {
            addCriterion("personal_creat_time between", value1, value2, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("personal_creat_time not between", value1, value2, "personalCreatTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeIsNull() {
            addCriterion("personal_update_time is null");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeIsNotNull() {
            addCriterion("personal_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeEqualTo(Date value) {
            addCriterion("personal_update_time =", value, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeNotEqualTo(Date value) {
            addCriterion("personal_update_time <>", value, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeGreaterThan(Date value) {
            addCriterion("personal_update_time >", value, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("personal_update_time >=", value, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeLessThan(Date value) {
            addCriterion("personal_update_time <", value, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("personal_update_time <=", value, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeIn(List<Date> values) {
            addCriterion("personal_update_time in", values, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeNotIn(List<Date> values) {
            addCriterion("personal_update_time not in", values, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("personal_update_time between", value1, value2, "personalUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPersonalUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("personal_update_time not between", value1, value2, "personalUpdateTime");
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