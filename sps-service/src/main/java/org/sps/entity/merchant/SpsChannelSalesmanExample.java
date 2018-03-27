package org.sps.entity.merchant;

import java.util.ArrayList;
import java.util.List;

public class SpsChannelSalesmanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelSalesmanExample() {
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

        public Criteria andSalesmanIdIsNull() {
            addCriterion("salesman_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIsNotNull() {
            addCriterion("salesman_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdEqualTo(Integer value) {
            addCriterion("salesman_id =", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotEqualTo(Integer value) {
            addCriterion("salesman_id <>", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThan(Integer value) {
            addCriterion("salesman_id >", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("salesman_id >=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThan(Integer value) {
            addCriterion("salesman_id <", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThanOrEqualTo(Integer value) {
            addCriterion("salesman_id <=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIn(List<Integer> values) {
            addCriterion("salesman_id in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotIn(List<Integer> values) {
            addCriterion("salesman_id not in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdBetween(Integer value1, Integer value2) {
            addCriterion("salesman_id between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("salesman_id not between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameIsNull() {
            addCriterion("salesman_name is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameIsNotNull() {
            addCriterion("salesman_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameEqualTo(String value) {
            addCriterion("salesman_name =", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotEqualTo(String value) {
            addCriterion("salesman_name <>", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameGreaterThan(String value) {
            addCriterion("salesman_name >", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_name >=", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameLessThan(String value) {
            addCriterion("salesman_name <", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameLessThanOrEqualTo(String value) {
            addCriterion("salesman_name <=", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameLike(String value) {
            addCriterion("salesman_name like", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotLike(String value) {
            addCriterion("salesman_name not like", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameIn(List<String> values) {
            addCriterion("salesman_name in", values, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotIn(List<String> values) {
            addCriterion("salesman_name not in", values, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameBetween(String value1, String value2) {
            addCriterion("salesman_name between", value1, value2, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotBetween(String value1, String value2) {
            addCriterion("salesman_name not between", value1, value2, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardIsNull() {
            addCriterion("salesman_idCard is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardIsNotNull() {
            addCriterion("salesman_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardEqualTo(String value) {
            addCriterion("salesman_idCard =", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardNotEqualTo(String value) {
            addCriterion("salesman_idCard <>", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardGreaterThan(String value) {
            addCriterion("salesman_idCard >", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_idCard >=", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardLessThan(String value) {
            addCriterion("salesman_idCard <", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardLessThanOrEqualTo(String value) {
            addCriterion("salesman_idCard <=", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardLike(String value) {
            addCriterion("salesman_idCard like", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardNotLike(String value) {
            addCriterion("salesman_idCard not like", value, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardIn(List<String> values) {
            addCriterion("salesman_idCard in", values, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardNotIn(List<String> values) {
            addCriterion("salesman_idCard not in", values, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardBetween(String value1, String value2) {
            addCriterion("salesman_idCard between", value1, value2, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdcardNotBetween(String value1, String value2) {
            addCriterion("salesman_idCard not between", value1, value2, "salesmanIdcard");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneIsNull() {
            addCriterion("salesman_phone is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneIsNotNull() {
            addCriterion("salesman_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneEqualTo(String value) {
            addCriterion("salesman_phone =", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneNotEqualTo(String value) {
            addCriterion("salesman_phone <>", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneGreaterThan(String value) {
            addCriterion("salesman_phone >", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_phone >=", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneLessThan(String value) {
            addCriterion("salesman_phone <", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneLessThanOrEqualTo(String value) {
            addCriterion("salesman_phone <=", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneLike(String value) {
            addCriterion("salesman_phone like", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneNotLike(String value) {
            addCriterion("salesman_phone not like", value, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneIn(List<String> values) {
            addCriterion("salesman_phone in", values, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneNotIn(List<String> values) {
            addCriterion("salesman_phone not in", values, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneBetween(String value1, String value2) {
            addCriterion("salesman_phone between", value1, value2, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanPhoneNotBetween(String value1, String value2) {
            addCriterion("salesman_phone not between", value1, value2, "salesmanPhone");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailIsNull() {
            addCriterion("salesman_email is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailIsNotNull() {
            addCriterion("salesman_email is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailEqualTo(String value) {
            addCriterion("salesman_email =", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailNotEqualTo(String value) {
            addCriterion("salesman_email <>", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailGreaterThan(String value) {
            addCriterion("salesman_email >", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_email >=", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailLessThan(String value) {
            addCriterion("salesman_email <", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailLessThanOrEqualTo(String value) {
            addCriterion("salesman_email <=", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailLike(String value) {
            addCriterion("salesman_email like", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailNotLike(String value) {
            addCriterion("salesman_email not like", value, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailIn(List<String> values) {
            addCriterion("salesman_email in", values, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailNotIn(List<String> values) {
            addCriterion("salesman_email not in", values, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailBetween(String value1, String value2) {
            addCriterion("salesman_email between", value1, value2, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanEmailNotBetween(String value1, String value2) {
            addCriterion("salesman_email not between", value1, value2, "salesmanEmail");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityIsNull() {
            addCriterion("salesman_city is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityIsNotNull() {
            addCriterion("salesman_city is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityEqualTo(String value) {
            addCriterion("salesman_city =", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityNotEqualTo(String value) {
            addCriterion("salesman_city <>", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityGreaterThan(String value) {
            addCriterion("salesman_city >", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_city >=", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityLessThan(String value) {
            addCriterion("salesman_city <", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityLessThanOrEqualTo(String value) {
            addCriterion("salesman_city <=", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityLike(String value) {
            addCriterion("salesman_city like", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityNotLike(String value) {
            addCriterion("salesman_city not like", value, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityIn(List<String> values) {
            addCriterion("salesman_city in", values, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityNotIn(List<String> values) {
            addCriterion("salesman_city not in", values, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityBetween(String value1, String value2) {
            addCriterion("salesman_city between", value1, value2, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmanCityNotBetween(String value1, String value2) {
            addCriterion("salesman_city not between", value1, value2, "salesmanCity");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumIsNull() {
            addCriterion("salesmane_channel_num is null");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumIsNotNull() {
            addCriterion("salesmane_channel_num is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumEqualTo(String value) {
            addCriterion("salesmane_channel_num =", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumNotEqualTo(String value) {
            addCriterion("salesmane_channel_num <>", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumGreaterThan(String value) {
            addCriterion("salesmane_channel_num >", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumGreaterThanOrEqualTo(String value) {
            addCriterion("salesmane_channel_num >=", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumLessThan(String value) {
            addCriterion("salesmane_channel_num <", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumLessThanOrEqualTo(String value) {
            addCriterion("salesmane_channel_num <=", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumLike(String value) {
            addCriterion("salesmane_channel_num like", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumNotLike(String value) {
            addCriterion("salesmane_channel_num not like", value, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumIn(List<String> values) {
            addCriterion("salesmane_channel_num in", values, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumNotIn(List<String> values) {
            addCriterion("salesmane_channel_num not in", values, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumBetween(String value1, String value2) {
            addCriterion("salesmane_channel_num between", value1, value2, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andSalesmaneChannelNumNotBetween(String value1, String value2) {
            addCriterion("salesmane_channel_num not between", value1, value2, "salesmaneChannelNum");
            return (Criteria) this;
        }

        public Criteria andBei1IsNull() {
            addCriterion("bei1 is null");
            return (Criteria) this;
        }

        public Criteria andBei1IsNotNull() {
            addCriterion("bei1 is not null");
            return (Criteria) this;
        }

        public Criteria andBei1EqualTo(String value) {
            addCriterion("bei1 =", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1NotEqualTo(String value) {
            addCriterion("bei1 <>", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1GreaterThan(String value) {
            addCriterion("bei1 >", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1GreaterThanOrEqualTo(String value) {
            addCriterion("bei1 >=", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1LessThan(String value) {
            addCriterion("bei1 <", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1LessThanOrEqualTo(String value) {
            addCriterion("bei1 <=", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1Like(String value) {
            addCriterion("bei1 like", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1NotLike(String value) {
            addCriterion("bei1 not like", value, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1In(List<String> values) {
            addCriterion("bei1 in", values, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1NotIn(List<String> values) {
            addCriterion("bei1 not in", values, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1Between(String value1, String value2) {
            addCriterion("bei1 between", value1, value2, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei1NotBetween(String value1, String value2) {
            addCriterion("bei1 not between", value1, value2, "bei1");
            return (Criteria) this;
        }

        public Criteria andBei2IsNull() {
            addCriterion("bei2 is null");
            return (Criteria) this;
        }

        public Criteria andBei2IsNotNull() {
            addCriterion("bei2 is not null");
            return (Criteria) this;
        }

        public Criteria andBei2EqualTo(String value) {
            addCriterion("bei2 =", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotEqualTo(String value) {
            addCriterion("bei2 <>", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2GreaterThan(String value) {
            addCriterion("bei2 >", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2GreaterThanOrEqualTo(String value) {
            addCriterion("bei2 >=", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2LessThan(String value) {
            addCriterion("bei2 <", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2LessThanOrEqualTo(String value) {
            addCriterion("bei2 <=", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2Like(String value) {
            addCriterion("bei2 like", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotLike(String value) {
            addCriterion("bei2 not like", value, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2In(List<String> values) {
            addCriterion("bei2 in", values, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotIn(List<String> values) {
            addCriterion("bei2 not in", values, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2Between(String value1, String value2) {
            addCriterion("bei2 between", value1, value2, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei2NotBetween(String value1, String value2) {
            addCriterion("bei2 not between", value1, value2, "bei2");
            return (Criteria) this;
        }

        public Criteria andBei3IsNull() {
            addCriterion("bei3 is null");
            return (Criteria) this;
        }

        public Criteria andBei3IsNotNull() {
            addCriterion("bei3 is not null");
            return (Criteria) this;
        }

        public Criteria andBei3EqualTo(String value) {
            addCriterion("bei3 =", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3NotEqualTo(String value) {
            addCriterion("bei3 <>", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3GreaterThan(String value) {
            addCriterion("bei3 >", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3GreaterThanOrEqualTo(String value) {
            addCriterion("bei3 >=", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3LessThan(String value) {
            addCriterion("bei3 <", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3LessThanOrEqualTo(String value) {
            addCriterion("bei3 <=", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3Like(String value) {
            addCriterion("bei3 like", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3NotLike(String value) {
            addCriterion("bei3 not like", value, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3In(List<String> values) {
            addCriterion("bei3 in", values, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3NotIn(List<String> values) {
            addCriterion("bei3 not in", values, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3Between(String value1, String value2) {
            addCriterion("bei3 between", value1, value2, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei3NotBetween(String value1, String value2) {
            addCriterion("bei3 not between", value1, value2, "bei3");
            return (Criteria) this;
        }

        public Criteria andBei4IsNull() {
            addCriterion("bei4 is null");
            return (Criteria) this;
        }

        public Criteria andBei4IsNotNull() {
            addCriterion("bei4 is not null");
            return (Criteria) this;
        }

        public Criteria andBei4EqualTo(String value) {
            addCriterion("bei4 =", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4NotEqualTo(String value) {
            addCriterion("bei4 <>", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4GreaterThan(String value) {
            addCriterion("bei4 >", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4GreaterThanOrEqualTo(String value) {
            addCriterion("bei4 >=", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4LessThan(String value) {
            addCriterion("bei4 <", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4LessThanOrEqualTo(String value) {
            addCriterion("bei4 <=", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4Like(String value) {
            addCriterion("bei4 like", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4NotLike(String value) {
            addCriterion("bei4 not like", value, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4In(List<String> values) {
            addCriterion("bei4 in", values, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4NotIn(List<String> values) {
            addCriterion("bei4 not in", values, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4Between(String value1, String value2) {
            addCriterion("bei4 between", value1, value2, "bei4");
            return (Criteria) this;
        }

        public Criteria andBei4NotBetween(String value1, String value2) {
            addCriterion("bei4 not between", value1, value2, "bei4");
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