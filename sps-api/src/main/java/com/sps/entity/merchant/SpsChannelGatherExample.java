package com.sps.entity.merchant;

import java.util.ArrayList;
import java.util.List;

public class SpsChannelGatherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelGatherExample() {
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

        public Criteria andGatherIdIsNull() {
            addCriterion("gather_id is null");
            return (Criteria) this;
        }

        public Criteria andGatherIdIsNotNull() {
            addCriterion("gather_id is not null");
            return (Criteria) this;
        }

        public Criteria andGatherIdEqualTo(Integer value) {
            addCriterion("gather_id =", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotEqualTo(Integer value) {
            addCriterion("gather_id <>", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdGreaterThan(Integer value) {
            addCriterion("gather_id >", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gather_id >=", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdLessThan(Integer value) {
            addCriterion("gather_id <", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdLessThanOrEqualTo(Integer value) {
            addCriterion("gather_id <=", value, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdIn(List<Integer> values) {
            addCriterion("gather_id in", values, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotIn(List<Integer> values) {
            addCriterion("gather_id not in", values, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdBetween(Integer value1, Integer value2) {
            addCriterion("gather_id between", value1, value2, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gather_id not between", value1, value2, "gatherId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdIsNull() {
            addCriterion("gather_bank_id is null");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdIsNotNull() {
            addCriterion("gather_bank_id is not null");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdEqualTo(String value) {
            addCriterion("gather_bank_id =", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdNotEqualTo(String value) {
            addCriterion("gather_bank_id <>", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdGreaterThan(String value) {
            addCriterion("gather_bank_id >", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdGreaterThanOrEqualTo(String value) {
            addCriterion("gather_bank_id >=", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdLessThan(String value) {
            addCriterion("gather_bank_id <", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdLessThanOrEqualTo(String value) {
            addCriterion("gather_bank_id <=", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdLike(String value) {
            addCriterion("gather_bank_id like", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdNotLike(String value) {
            addCriterion("gather_bank_id not like", value, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdIn(List<String> values) {
            addCriterion("gather_bank_id in", values, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdNotIn(List<String> values) {
            addCriterion("gather_bank_id not in", values, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdBetween(String value1, String value2) {
            addCriterion("gather_bank_id between", value1, value2, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherBankIdNotBetween(String value1, String value2) {
            addCriterion("gather_bank_id not between", value1, value2, "gatherBankId");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameIsNull() {
            addCriterion("gather_owner_name is null");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameIsNotNull() {
            addCriterion("gather_owner_name is not null");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameEqualTo(String value) {
            addCriterion("gather_owner_name =", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameNotEqualTo(String value) {
            addCriterion("gather_owner_name <>", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameGreaterThan(String value) {
            addCriterion("gather_owner_name >", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("gather_owner_name >=", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameLessThan(String value) {
            addCriterion("gather_owner_name <", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("gather_owner_name <=", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameLike(String value) {
            addCriterion("gather_owner_name like", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameNotLike(String value) {
            addCriterion("gather_owner_name not like", value, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameIn(List<String> values) {
            addCriterion("gather_owner_name in", values, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameNotIn(List<String> values) {
            addCriterion("gather_owner_name not in", values, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameBetween(String value1, String value2) {
            addCriterion("gather_owner_name between", value1, value2, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherOwnerNameNotBetween(String value1, String value2) {
            addCriterion("gather_owner_name not between", value1, value2, "gatherOwnerName");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardIsNull() {
            addCriterion("gather_idCard is null");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardIsNotNull() {
            addCriterion("gather_idCard is not null");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardEqualTo(String value) {
            addCriterion("gather_idCard =", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardNotEqualTo(String value) {
            addCriterion("gather_idCard <>", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardGreaterThan(String value) {
            addCriterion("gather_idCard >", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("gather_idCard >=", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardLessThan(String value) {
            addCriterion("gather_idCard <", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardLessThanOrEqualTo(String value) {
            addCriterion("gather_idCard <=", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardLike(String value) {
            addCriterion("gather_idCard like", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardNotLike(String value) {
            addCriterion("gather_idCard not like", value, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardIn(List<String> values) {
            addCriterion("gather_idCard in", values, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardNotIn(List<String> values) {
            addCriterion("gather_idCard not in", values, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardBetween(String value1, String value2) {
            addCriterion("gather_idCard between", value1, value2, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherIdcardNotBetween(String value1, String value2) {
            addCriterion("gather_idCard not between", value1, value2, "gatherIdcard");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneIsNull() {
            addCriterion("gather_phone is null");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneIsNotNull() {
            addCriterion("gather_phone is not null");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneEqualTo(String value) {
            addCriterion("gather_phone =", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneNotEqualTo(String value) {
            addCriterion("gather_phone <>", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneGreaterThan(String value) {
            addCriterion("gather_phone >", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("gather_phone >=", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneLessThan(String value) {
            addCriterion("gather_phone <", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneLessThanOrEqualTo(String value) {
            addCriterion("gather_phone <=", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneLike(String value) {
            addCriterion("gather_phone like", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneNotLike(String value) {
            addCriterion("gather_phone not like", value, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneIn(List<String> values) {
            addCriterion("gather_phone in", values, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneNotIn(List<String> values) {
            addCriterion("gather_phone not in", values, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneBetween(String value1, String value2) {
            addCriterion("gather_phone between", value1, value2, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherPhoneNotBetween(String value1, String value2) {
            addCriterion("gather_phone not between", value1, value2, "gatherPhone");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankIsNull() {
            addCriterion("gather_deposit_bank is null");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankIsNotNull() {
            addCriterion("gather_deposit_bank is not null");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankEqualTo(String value) {
            addCriterion("gather_deposit_bank =", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankNotEqualTo(String value) {
            addCriterion("gather_deposit_bank <>", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankGreaterThan(String value) {
            addCriterion("gather_deposit_bank >", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankGreaterThanOrEqualTo(String value) {
            addCriterion("gather_deposit_bank >=", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankLessThan(String value) {
            addCriterion("gather_deposit_bank <", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankLessThanOrEqualTo(String value) {
            addCriterion("gather_deposit_bank <=", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankLike(String value) {
            addCriterion("gather_deposit_bank like", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankNotLike(String value) {
            addCriterion("gather_deposit_bank not like", value, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankIn(List<String> values) {
            addCriterion("gather_deposit_bank in", values, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankNotIn(List<String> values) {
            addCriterion("gather_deposit_bank not in", values, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankBetween(String value1, String value2) {
            addCriterion("gather_deposit_bank between", value1, value2, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherDepositBankNotBetween(String value1, String value2) {
            addCriterion("gather_deposit_bank not between", value1, value2, "gatherDepositBank");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchIsNull() {
            addCriterion("gather_bank_branch is null");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchIsNotNull() {
            addCriterion("gather_bank_branch is not null");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchEqualTo(String value) {
            addCriterion("gather_bank_branch =", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchNotEqualTo(String value) {
            addCriterion("gather_bank_branch <>", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchGreaterThan(String value) {
            addCriterion("gather_bank_branch >", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchGreaterThanOrEqualTo(String value) {
            addCriterion("gather_bank_branch >=", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchLessThan(String value) {
            addCriterion("gather_bank_branch <", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchLessThanOrEqualTo(String value) {
            addCriterion("gather_bank_branch <=", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchLike(String value) {
            addCriterion("gather_bank_branch like", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchNotLike(String value) {
            addCriterion("gather_bank_branch not like", value, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchIn(List<String> values) {
            addCriterion("gather_bank_branch in", values, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchNotIn(List<String> values) {
            addCriterion("gather_bank_branch not in", values, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchBetween(String value1, String value2) {
            addCriterion("gather_bank_branch between", value1, value2, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankBranchNotBetween(String value1, String value2) {
            addCriterion("gather_bank_branch not between", value1, value2, "gatherBankBranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchIsNull() {
            addCriterion("gather_bank_subBranch is null");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchIsNotNull() {
            addCriterion("gather_bank_subBranch is not null");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchEqualTo(String value) {
            addCriterion("gather_bank_subBranch =", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchNotEqualTo(String value) {
            addCriterion("gather_bank_subBranch <>", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchGreaterThan(String value) {
            addCriterion("gather_bank_subBranch >", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchGreaterThanOrEqualTo(String value) {
            addCriterion("gather_bank_subBranch >=", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchLessThan(String value) {
            addCriterion("gather_bank_subBranch <", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchLessThanOrEqualTo(String value) {
            addCriterion("gather_bank_subBranch <=", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchLike(String value) {
            addCriterion("gather_bank_subBranch like", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchNotLike(String value) {
            addCriterion("gather_bank_subBranch not like", value, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchIn(List<String> values) {
            addCriterion("gather_bank_subBranch in", values, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchNotIn(List<String> values) {
            addCriterion("gather_bank_subBranch not in", values, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchBetween(String value1, String value2) {
            addCriterion("gather_bank_subBranch between", value1, value2, "gatherBankSubbranch");
            return (Criteria) this;
        }

        public Criteria andGatherBankSubbranchNotBetween(String value1, String value2) {
            addCriterion("gather_bank_subBranch not between", value1, value2, "gatherBankSubbranch");
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