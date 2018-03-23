package com.sps.entity.merchant;

import java.util.ArrayList;
import java.util.List;

public class SpsChannelEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelEnterpriseExample() {
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoIsNull() {
            addCriterion("enterprise_businesslicense_no is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoIsNotNull() {
            addCriterion("enterprise_businesslicense_no is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoEqualTo(String value) {
            addCriterion("enterprise_businesslicense_no =", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoNotEqualTo(String value) {
            addCriterion("enterprise_businesslicense_no <>", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoGreaterThan(String value) {
            addCriterion("enterprise_businesslicense_no >", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_businesslicense_no >=", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoLessThan(String value) {
            addCriterion("enterprise_businesslicense_no <", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoLessThanOrEqualTo(String value) {
            addCriterion("enterprise_businesslicense_no <=", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoLike(String value) {
            addCriterion("enterprise_businesslicense_no like", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoNotLike(String value) {
            addCriterion("enterprise_businesslicense_no not like", value, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoIn(List<String> values) {
            addCriterion("enterprise_businesslicense_no in", values, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoNotIn(List<String> values) {
            addCriterion("enterprise_businesslicense_no not in", values, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoBetween(String value1, String value2) {
            addCriterion("enterprise_businesslicense_no between", value1, value2, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinesslicenseNoNotBetween(String value1, String value2) {
            addCriterion("enterprise_businesslicense_no not between", value1, value2, "enterpriseBusinesslicenseNo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameIsNull() {
            addCriterion("enterprise_company_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameIsNotNull() {
            addCriterion("enterprise_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameEqualTo(String value) {
            addCriterion("enterprise_company_name =", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameNotEqualTo(String value) {
            addCriterion("enterprise_company_name <>", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameGreaterThan(String value) {
            addCriterion("enterprise_company_name >", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_company_name >=", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameLessThan(String value) {
            addCriterion("enterprise_company_name <", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_company_name <=", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameLike(String value) {
            addCriterion("enterprise_company_name like", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameNotLike(String value) {
            addCriterion("enterprise_company_name not like", value, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameIn(List<String> values) {
            addCriterion("enterprise_company_name in", values, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameNotIn(List<String> values) {
            addCriterion("enterprise_company_name not in", values, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameBetween(String value1, String value2) {
            addCriterion("enterprise_company_name between", value1, value2, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_company_name not between", value1, value2, "enterpriseCompanyName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrIsNull() {
            addCriterion("enterprise_company_register_addr is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrIsNotNull() {
            addCriterion("enterprise_company_register_addr is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrEqualTo(String value) {
            addCriterion("enterprise_company_register_addr =", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrNotEqualTo(String value) {
            addCriterion("enterprise_company_register_addr <>", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrGreaterThan(String value) {
            addCriterion("enterprise_company_register_addr >", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_company_register_addr >=", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrLessThan(String value) {
            addCriterion("enterprise_company_register_addr <", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrLessThanOrEqualTo(String value) {
            addCriterion("enterprise_company_register_addr <=", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrLike(String value) {
            addCriterion("enterprise_company_register_addr like", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrNotLike(String value) {
            addCriterion("enterprise_company_register_addr not like", value, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrIn(List<String> values) {
            addCriterion("enterprise_company_register_addr in", values, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrNotIn(List<String> values) {
            addCriterion("enterprise_company_register_addr not in", values, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrBetween(String value1, String value2) {
            addCriterion("enterprise_company_register_addr between", value1, value2, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRegisterAddrNotBetween(String value1, String value2) {
            addCriterion("enterprise_company_register_addr not between", value1, value2, "enterpriseCompanyRegisterAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrIsNull() {
            addCriterion("enterprise_company_realit_addr is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrIsNotNull() {
            addCriterion("enterprise_company_realit_addr is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrEqualTo(String value) {
            addCriterion("enterprise_company_realit_addr =", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrNotEqualTo(String value) {
            addCriterion("enterprise_company_realit_addr <>", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrGreaterThan(String value) {
            addCriterion("enterprise_company_realit_addr >", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_company_realit_addr >=", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrLessThan(String value) {
            addCriterion("enterprise_company_realit_addr <", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrLessThanOrEqualTo(String value) {
            addCriterion("enterprise_company_realit_addr <=", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrLike(String value) {
            addCriterion("enterprise_company_realit_addr like", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrNotLike(String value) {
            addCriterion("enterprise_company_realit_addr not like", value, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrIn(List<String> values) {
            addCriterion("enterprise_company_realit_addr in", values, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrNotIn(List<String> values) {
            addCriterion("enterprise_company_realit_addr not in", values, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrBetween(String value1, String value2) {
            addCriterion("enterprise_company_realit_addr between", value1, value2, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCompanyRealitAddrNotBetween(String value1, String value2) {
            addCriterion("enterprise_company_realit_addr not between", value1, value2, "enterpriseCompanyRealitAddr");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIsNull() {
            addCriterion("enterprise_corp is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIsNotNull() {
            addCriterion("enterprise_corp is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpEqualTo(String value) {
            addCriterion("enterprise_corp =", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpNotEqualTo(String value) {
            addCriterion("enterprise_corp <>", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpGreaterThan(String value) {
            addCriterion("enterprise_corp >", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_corp >=", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpLessThan(String value) {
            addCriterion("enterprise_corp <", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpLessThanOrEqualTo(String value) {
            addCriterion("enterprise_corp <=", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpLike(String value) {
            addCriterion("enterprise_corp like", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpNotLike(String value) {
            addCriterion("enterprise_corp not like", value, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIn(List<String> values) {
            addCriterion("enterprise_corp in", values, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpNotIn(List<String> values) {
            addCriterion("enterprise_corp not in", values, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpBetween(String value1, String value2) {
            addCriterion("enterprise_corp between", value1, value2, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpNotBetween(String value1, String value2) {
            addCriterion("enterprise_corp not between", value1, value2, "enterpriseCorp");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardIsNull() {
            addCriterion("enterprise_corp_idCard is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardIsNotNull() {
            addCriterion("enterprise_corp_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardEqualTo(String value) {
            addCriterion("enterprise_corp_idCard =", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardNotEqualTo(String value) {
            addCriterion("enterprise_corp_idCard <>", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardGreaterThan(String value) {
            addCriterion("enterprise_corp_idCard >", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_corp_idCard >=", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardLessThan(String value) {
            addCriterion("enterprise_corp_idCard <", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardLessThanOrEqualTo(String value) {
            addCriterion("enterprise_corp_idCard <=", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardLike(String value) {
            addCriterion("enterprise_corp_idCard like", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardNotLike(String value) {
            addCriterion("enterprise_corp_idCard not like", value, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardIn(List<String> values) {
            addCriterion("enterprise_corp_idCard in", values, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardNotIn(List<String> values) {
            addCriterion("enterprise_corp_idCard not in", values, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardBetween(String value1, String value2) {
            addCriterion("enterprise_corp_idCard between", value1, value2, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCorpIdcardNotBetween(String value1, String value2) {
            addCriterion("enterprise_corp_idCard not between", value1, value2, "enterpriseCorpIdcard");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeIsNull() {
            addCriterion("enterprise_operatio_time is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeIsNotNull() {
            addCriterion("enterprise_operatio_time is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeEqualTo(Integer value) {
            addCriterion("enterprise_operatio_time =", value, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeNotEqualTo(Integer value) {
            addCriterion("enterprise_operatio_time <>", value, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeGreaterThan(Integer value) {
            addCriterion("enterprise_operatio_time >", value, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_operatio_time >=", value, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeLessThan(Integer value) {
            addCriterion("enterprise_operatio_time <", value, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_operatio_time <=", value, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeIn(List<Integer> values) {
            addCriterion("enterprise_operatio_time in", values, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeNotIn(List<Integer> values) {
            addCriterion("enterprise_operatio_time not in", values, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_operatio_time between", value1, value2, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseOperatioTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_operatio_time not between", value1, value2, "enterpriseOperatioTime");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumIsNull() {
            addCriterion("enterprise_employee_num is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumIsNotNull() {
            addCriterion("enterprise_employee_num is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumEqualTo(Integer value) {
            addCriterion("enterprise_employee_num =", value, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumNotEqualTo(Integer value) {
            addCriterion("enterprise_employee_num <>", value, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumGreaterThan(Integer value) {
            addCriterion("enterprise_employee_num >", value, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_employee_num >=", value, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumLessThan(Integer value) {
            addCriterion("enterprise_employee_num <", value, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_employee_num <=", value, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumIn(List<Integer> values) {
            addCriterion("enterprise_employee_num in", values, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumNotIn(List<Integer> values) {
            addCriterion("enterprise_employee_num not in", values, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_employee_num between", value1, value2, "enterpriseEmployeeNum");
            return (Criteria) this;
        }

        public Criteria andEnterpriseEmployeeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_employee_num not between", value1, value2, "enterpriseEmployeeNum");
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