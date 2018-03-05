package org.sps.entity.balance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BalanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BalanceExample() {
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

        public Criteria andBalanceIdIsNull() {
            addCriterion("balance_id is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIdIsNotNull() {
            addCriterion("balance_id is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceIdEqualTo(Integer value) {
            addCriterion("balance_id =", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotEqualTo(Integer value) {
            addCriterion("balance_id <>", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdGreaterThan(Integer value) {
            addCriterion("balance_id >", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance_id >=", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdLessThan(Integer value) {
            addCriterion("balance_id <", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdLessThanOrEqualTo(Integer value) {
            addCriterion("balance_id <=", value, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdIn(List<Integer> values) {
            addCriterion("balance_id in", values, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotIn(List<Integer> values) {
            addCriterion("balance_id not in", values, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdBetween(Integer value1, Integer value2) {
            addCriterion("balance_id between", value1, value2, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("balance_id not between", value1, value2, "balanceId");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeIsNull() {
            addCriterion("balance_type is null");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeIsNotNull() {
            addCriterion("balance_type is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeEqualTo(String value) {
            addCriterion("balance_type =", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotEqualTo(String value) {
            addCriterion("balance_type <>", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeGreaterThan(String value) {
            addCriterion("balance_type >", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("balance_type >=", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeLessThan(String value) {
            addCriterion("balance_type <", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeLessThanOrEqualTo(String value) {
            addCriterion("balance_type <=", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeLike(String value) {
            addCriterion("balance_type like", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotLike(String value) {
            addCriterion("balance_type not like", value, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeIn(List<String> values) {
            addCriterion("balance_type in", values, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotIn(List<String> values) {
            addCriterion("balance_type not in", values, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeBetween(String value1, String value2) {
            addCriterion("balance_type between", value1, value2, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceTypeNotBetween(String value1, String value2) {
            addCriterion("balance_type not between", value1, value2, "balanceType");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountIsNull() {
            addCriterion("balance_amount is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountIsNotNull() {
            addCriterion("balance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountEqualTo(BigDecimal value) {
            addCriterion("balance_amount =", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountNotEqualTo(BigDecimal value) {
            addCriterion("balance_amount <>", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountGreaterThan(BigDecimal value) {
            addCriterion("balance_amount >", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_amount >=", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountLessThan(BigDecimal value) {
            addCriterion("balance_amount <", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_amount <=", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountIn(List<BigDecimal> values) {
            addCriterion("balance_amount in", values, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountNotIn(List<BigDecimal> values) {
            addCriterion("balance_amount not in", values, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_amount between", value1, value2, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_amount not between", value1, value2, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedIsNull() {
            addCriterion("balance_amount_used is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedIsNotNull() {
            addCriterion("balance_amount_used is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedEqualTo(BigDecimal value) {
            addCriterion("balance_amount_used =", value, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedNotEqualTo(BigDecimal value) {
            addCriterion("balance_amount_used <>", value, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedGreaterThan(BigDecimal value) {
            addCriterion("balance_amount_used >", value, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_amount_used >=", value, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedLessThan(BigDecimal value) {
            addCriterion("balance_amount_used <", value, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_amount_used <=", value, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedIn(List<BigDecimal> values) {
            addCriterion("balance_amount_used in", values, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedNotIn(List<BigDecimal> values) {
            addCriterion("balance_amount_used not in", values, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_amount_used between", value1, value2, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_amount_used not between", value1, value2, "balanceAmountUsed");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableIsNull() {
            addCriterion("balance_amount_usable is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableIsNotNull() {
            addCriterion("balance_amount_usable is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableEqualTo(BigDecimal value) {
            addCriterion("balance_amount_usable =", value, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableNotEqualTo(BigDecimal value) {
            addCriterion("balance_amount_usable <>", value, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableGreaterThan(BigDecimal value) {
            addCriterion("balance_amount_usable >", value, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_amount_usable >=", value, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableLessThan(BigDecimal value) {
            addCriterion("balance_amount_usable <", value, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_amount_usable <=", value, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableIn(List<BigDecimal> values) {
            addCriterion("balance_amount_usable in", values, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableNotIn(List<BigDecimal> values) {
            addCriterion("balance_amount_usable not in", values, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_amount_usable between", value1, value2, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountUsableNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_amount_usable not between", value1, value2, "balanceAmountUsable");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateIsNull() {
            addCriterion("balance_expire_date is null");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateIsNotNull() {
            addCriterion("balance_expire_date is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateEqualTo(Date value) {
            addCriterion("balance_expire_date =", value, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateNotEqualTo(Date value) {
            addCriterion("balance_expire_date <>", value, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateGreaterThan(Date value) {
            addCriterion("balance_expire_date >", value, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterion("balance_expire_date >=", value, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateLessThan(Date value) {
            addCriterion("balance_expire_date <", value, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateLessThanOrEqualTo(Date value) {
            addCriterion("balance_expire_date <=", value, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateIn(List<Date> values) {
            addCriterion("balance_expire_date in", values, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateNotIn(List<Date> values) {
            addCriterion("balance_expire_date not in", values, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateBetween(Date value1, Date value2) {
            addCriterion("balance_expire_date between", value1, value2, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceExpireDateNotBetween(Date value1, Date value2) {
            addCriterion("balance_expire_date not between", value1, value2, "balanceExpireDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateIsNull() {
            addCriterion("balance_start_date is null");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateIsNotNull() {
            addCriterion("balance_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateEqualTo(Date value) {
            addCriterion("balance_start_date =", value, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateNotEqualTo(Date value) {
            addCriterion("balance_start_date <>", value, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateGreaterThan(Date value) {
            addCriterion("balance_start_date >", value, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("balance_start_date >=", value, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateLessThan(Date value) {
            addCriterion("balance_start_date <", value, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateLessThanOrEqualTo(Date value) {
            addCriterion("balance_start_date <=", value, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateIn(List<Date> values) {
            addCriterion("balance_start_date in", values, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateNotIn(List<Date> values) {
            addCriterion("balance_start_date not in", values, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateBetween(Date value1, Date value2) {
            addCriterion("balance_start_date between", value1, value2, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStartDateNotBetween(Date value1, Date value2) {
            addCriterion("balance_start_date not between", value1, value2, "balanceStartDate");
            return (Criteria) this;
        }

        public Criteria andBalanceStateIsNull() {
            addCriterion("balance_state is null");
            return (Criteria) this;
        }

        public Criteria andBalanceStateIsNotNull() {
            addCriterion("balance_state is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceStateEqualTo(Integer value) {
            addCriterion("balance_state =", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotEqualTo(Integer value) {
            addCriterion("balance_state <>", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateGreaterThan(Integer value) {
            addCriterion("balance_state >", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance_state >=", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateLessThan(Integer value) {
            addCriterion("balance_state <", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateLessThanOrEqualTo(Integer value) {
            addCriterion("balance_state <=", value, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateIn(List<Integer> values) {
            addCriterion("balance_state in", values, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotIn(List<Integer> values) {
            addCriterion("balance_state not in", values, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateBetween(Integer value1, Integer value2) {
            addCriterion("balance_state between", value1, value2, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceStateNotBetween(Integer value1, Integer value2) {
            addCriterion("balance_state not between", value1, value2, "balanceState");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumIsNull() {
            addCriterion("balance_client_num is null");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumIsNotNull() {
            addCriterion("balance_client_num is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumEqualTo(String value) {
            addCriterion("balance_client_num =", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumNotEqualTo(String value) {
            addCriterion("balance_client_num <>", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumGreaterThan(String value) {
            addCriterion("balance_client_num >", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumGreaterThanOrEqualTo(String value) {
            addCriterion("balance_client_num >=", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumLessThan(String value) {
            addCriterion("balance_client_num <", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumLessThanOrEqualTo(String value) {
            addCriterion("balance_client_num <=", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumLike(String value) {
            addCriterion("balance_client_num like", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumNotLike(String value) {
            addCriterion("balance_client_num not like", value, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumIn(List<String> values) {
            addCriterion("balance_client_num in", values, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumNotIn(List<String> values) {
            addCriterion("balance_client_num not in", values, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumBetween(String value1, String value2) {
            addCriterion("balance_client_num between", value1, value2, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andBalanceClientNumNotBetween(String value1, String value2) {
            addCriterion("balance_client_num not between", value1, value2, "balanceClientNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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