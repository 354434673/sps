package com.sps.entity.merchant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SpsChannelGuaranteeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelGuaranteeExample() {
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

        public Criteria andGuaranteeIdIsNull() {
            addCriterion("guarantee_id is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdIsNotNull() {
            addCriterion("guarantee_id is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdEqualTo(Integer value) {
            addCriterion("guarantee_id =", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdNotEqualTo(Integer value) {
            addCriterion("guarantee_id <>", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdGreaterThan(Integer value) {
            addCriterion("guarantee_id >", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("guarantee_id >=", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdLessThan(Integer value) {
            addCriterion("guarantee_id <", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdLessThanOrEqualTo(Integer value) {
            addCriterion("guarantee_id <=", value, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdIn(List<Integer> values) {
            addCriterion("guarantee_id in", values, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdNotIn(List<Integer> values) {
            addCriterion("guarantee_id not in", values, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdBetween(Integer value1, Integer value2) {
            addCriterion("guarantee_id between", value1, value2, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("guarantee_id not between", value1, value2, "guaranteeId");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationIsNull() {
            addCriterion("guarantee_situation is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationIsNotNull() {
            addCriterion("guarantee_situation is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationEqualTo(String value) {
            addCriterion("guarantee_situation =", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationNotEqualTo(String value) {
            addCriterion("guarantee_situation <>", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationGreaterThan(String value) {
            addCriterion("guarantee_situation >", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_situation >=", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationLessThan(String value) {
            addCriterion("guarantee_situation <", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationLessThanOrEqualTo(String value) {
            addCriterion("guarantee_situation <=", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationLike(String value) {
            addCriterion("guarantee_situation like", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationNotLike(String value) {
            addCriterion("guarantee_situation not like", value, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationIn(List<String> values) {
            addCriterion("guarantee_situation in", values, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationNotIn(List<String> values) {
            addCriterion("guarantee_situation not in", values, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationBetween(String value1, String value2) {
            addCriterion("guarantee_situation between", value1, value2, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeSituationNotBetween(String value1, String value2) {
            addCriterion("guarantee_situation not between", value1, value2, "guaranteeSituation");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositIsNull() {
            addCriterion("guarantee_deposit is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositIsNotNull() {
            addCriterion("guarantee_deposit is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositEqualTo(BigDecimal value) {
            addCriterion("guarantee_deposit =", value, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositNotEqualTo(BigDecimal value) {
            addCriterion("guarantee_deposit <>", value, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositGreaterThan(BigDecimal value) {
            addCriterion("guarantee_deposit >", value, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_deposit >=", value, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositLessThan(BigDecimal value) {
            addCriterion("guarantee_deposit <", value, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("guarantee_deposit <=", value, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositIn(List<BigDecimal> values) {
            addCriterion("guarantee_deposit in", values, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositNotIn(List<BigDecimal> values) {
            addCriterion("guarantee_deposit not in", values, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_deposit between", value1, value2, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("guarantee_deposit not between", value1, value2, "guaranteeDeposit");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneIsNull() {
            addCriterion("guarantee_corp_phone is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneIsNotNull() {
            addCriterion("guarantee_corp_phone is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneEqualTo(String value) {
            addCriterion("guarantee_corp_phone =", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneNotEqualTo(String value) {
            addCriterion("guarantee_corp_phone <>", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneGreaterThan(String value) {
            addCriterion("guarantee_corp_phone >", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_corp_phone >=", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneLessThan(String value) {
            addCriterion("guarantee_corp_phone <", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneLessThanOrEqualTo(String value) {
            addCriterion("guarantee_corp_phone <=", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneLike(String value) {
            addCriterion("guarantee_corp_phone like", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneNotLike(String value) {
            addCriterion("guarantee_corp_phone not like", value, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneIn(List<String> values) {
            addCriterion("guarantee_corp_phone in", values, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneNotIn(List<String> values) {
            addCriterion("guarantee_corp_phone not in", values, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneBetween(String value1, String value2) {
            addCriterion("guarantee_corp_phone between", value1, value2, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeCorpPhoneNotBetween(String value1, String value2) {
            addCriterion("guarantee_corp_phone not between", value1, value2, "guaranteeCorpPhone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameIsNull() {
            addCriterion("guarantee_finance_contactName is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameIsNotNull() {
            addCriterion("guarantee_finance_contactName is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameEqualTo(String value) {
            addCriterion("guarantee_finance_contactName =", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameNotEqualTo(String value) {
            addCriterion("guarantee_finance_contactName <>", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameGreaterThan(String value) {
            addCriterion("guarantee_finance_contactName >", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_finance_contactName >=", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameLessThan(String value) {
            addCriterion("guarantee_finance_contactName <", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameLessThanOrEqualTo(String value) {
            addCriterion("guarantee_finance_contactName <=", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameLike(String value) {
            addCriterion("guarantee_finance_contactName like", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameNotLike(String value) {
            addCriterion("guarantee_finance_contactName not like", value, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameIn(List<String> values) {
            addCriterion("guarantee_finance_contactName in", values, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameNotIn(List<String> values) {
            addCriterion("guarantee_finance_contactName not in", values, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameBetween(String value1, String value2) {
            addCriterion("guarantee_finance_contactName between", value1, value2, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactnameNotBetween(String value1, String value2) {
            addCriterion("guarantee_finance_contactName not between", value1, value2, "guaranteeFinanceContactname");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneIsNull() {
            addCriterion("guarantee_finance_contactPhone is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneIsNotNull() {
            addCriterion("guarantee_finance_contactPhone is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneEqualTo(String value) {
            addCriterion("guarantee_finance_contactPhone =", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneNotEqualTo(String value) {
            addCriterion("guarantee_finance_contactPhone <>", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneGreaterThan(String value) {
            addCriterion("guarantee_finance_contactPhone >", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_finance_contactPhone >=", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneLessThan(String value) {
            addCriterion("guarantee_finance_contactPhone <", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneLessThanOrEqualTo(String value) {
            addCriterion("guarantee_finance_contactPhone <=", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneLike(String value) {
            addCriterion("guarantee_finance_contactPhone like", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneNotLike(String value) {
            addCriterion("guarantee_finance_contactPhone not like", value, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneIn(List<String> values) {
            addCriterion("guarantee_finance_contactPhone in", values, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneNotIn(List<String> values) {
            addCriterion("guarantee_finance_contactPhone not in", values, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneBetween(String value1, String value2) {
            addCriterion("guarantee_finance_contactPhone between", value1, value2, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeFinanceContactphoneNotBetween(String value1, String value2) {
            addCriterion("guarantee_finance_contactPhone not between", value1, value2, "guaranteeFinanceContactphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameIsNull() {
            addCriterion("guarantee_business_LeaderName is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameIsNotNull() {
            addCriterion("guarantee_business_LeaderName is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameEqualTo(String value) {
            addCriterion("guarantee_business_LeaderName =", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameNotEqualTo(String value) {
            addCriterion("guarantee_business_LeaderName <>", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameGreaterThan(String value) {
            addCriterion("guarantee_business_LeaderName >", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_business_LeaderName >=", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameLessThan(String value) {
            addCriterion("guarantee_business_LeaderName <", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameLessThanOrEqualTo(String value) {
            addCriterion("guarantee_business_LeaderName <=", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameLike(String value) {
            addCriterion("guarantee_business_LeaderName like", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameNotLike(String value) {
            addCriterion("guarantee_business_LeaderName not like", value, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameIn(List<String> values) {
            addCriterion("guarantee_business_LeaderName in", values, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameNotIn(List<String> values) {
            addCriterion("guarantee_business_LeaderName not in", values, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameBetween(String value1, String value2) {
            addCriterion("guarantee_business_LeaderName between", value1, value2, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeadernameNotBetween(String value1, String value2) {
            addCriterion("guarantee_business_LeaderName not between", value1, value2, "guaranteeBusinessLeadername");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneIsNull() {
            addCriterion("guarantee_business_LeaderPhone is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneIsNotNull() {
            addCriterion("guarantee_business_LeaderPhone is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneEqualTo(String value) {
            addCriterion("guarantee_business_LeaderPhone =", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneNotEqualTo(String value) {
            addCriterion("guarantee_business_LeaderPhone <>", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneGreaterThan(String value) {
            addCriterion("guarantee_business_LeaderPhone >", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_business_LeaderPhone >=", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneLessThan(String value) {
            addCriterion("guarantee_business_LeaderPhone <", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneLessThanOrEqualTo(String value) {
            addCriterion("guarantee_business_LeaderPhone <=", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneLike(String value) {
            addCriterion("guarantee_business_LeaderPhone like", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneNotLike(String value) {
            addCriterion("guarantee_business_LeaderPhone not like", value, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneIn(List<String> values) {
            addCriterion("guarantee_business_LeaderPhone in", values, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneNotIn(List<String> values) {
            addCriterion("guarantee_business_LeaderPhone not in", values, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneBetween(String value1, String value2) {
            addCriterion("guarantee_business_LeaderPhone between", value1, value2, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessLeaderphoneNotBetween(String value1, String value2) {
            addCriterion("guarantee_business_LeaderPhone not between", value1, value2, "guaranteeBusinessLeaderphone");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordIsNull() {
            addCriterion("guarantee_business_phone_password is null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordIsNotNull() {
            addCriterion("guarantee_business_phone_password is not null");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordEqualTo(String value) {
            addCriterion("guarantee_business_phone_password =", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordNotEqualTo(String value) {
            addCriterion("guarantee_business_phone_password <>", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordGreaterThan(String value) {
            addCriterion("guarantee_business_phone_password >", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("guarantee_business_phone_password >=", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordLessThan(String value) {
            addCriterion("guarantee_business_phone_password <", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordLessThanOrEqualTo(String value) {
            addCriterion("guarantee_business_phone_password <=", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordLike(String value) {
            addCriterion("guarantee_business_phone_password like", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordNotLike(String value) {
            addCriterion("guarantee_business_phone_password not like", value, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordIn(List<String> values) {
            addCriterion("guarantee_business_phone_password in", values, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordNotIn(List<String> values) {
            addCriterion("guarantee_business_phone_password not in", values, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordBetween(String value1, String value2) {
            addCriterion("guarantee_business_phone_password between", value1, value2, "guaranteeBusinessPhonePassword");
            return (Criteria) this;
        }

        public Criteria andGuaranteeBusinessPhonePasswordNotBetween(String value1, String value2) {
            addCriterion("guarantee_business_phone_password not between", value1, value2, "guaranteeBusinessPhonePassword");
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