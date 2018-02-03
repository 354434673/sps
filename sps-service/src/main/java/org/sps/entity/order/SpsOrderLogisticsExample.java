package org.sps.entity.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsOrderLogisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsOrderLogisticsExample() {
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

        public Criteria andLogisticsIdIsNull() {
            addCriterion("logistics_id is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIsNotNull() {
            addCriterion("logistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdEqualTo(Integer value) {
            addCriterion("logistics_id =", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotEqualTo(Integer value) {
            addCriterion("logistics_id <>", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThan(Integer value) {
            addCriterion("logistics_id >", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_id >=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThan(Integer value) {
            addCriterion("logistics_id <", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_id <=", value, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdIn(List<Integer> values) {
            addCriterion("logistics_id in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotIn(List<Integer> values) {
            addCriterion("logistics_id not in", values, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdBetween(Integer value1, Integer value2) {
            addCriterion("logistics_id between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_id not between", value1, value2, "logisticsId");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIsNull() {
            addCriterion("logistics_name is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIsNotNull() {
            addCriterion("logistics_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameEqualTo(String value) {
            addCriterion("logistics_name =", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotEqualTo(String value) {
            addCriterion("logistics_name <>", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameGreaterThan(String value) {
            addCriterion("logistics_name >", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_name >=", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLessThan(String value) {
            addCriterion("logistics_name <", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLessThanOrEqualTo(String value) {
            addCriterion("logistics_name <=", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameLike(String value) {
            addCriterion("logistics_name like", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotLike(String value) {
            addCriterion("logistics_name not like", value, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameIn(List<String> values) {
            addCriterion("logistics_name in", values, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotIn(List<String> values) {
            addCriterion("logistics_name not in", values, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameBetween(String value1, String value2) {
            addCriterion("logistics_name between", value1, value2, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsNameNotBetween(String value1, String value2) {
            addCriterion("logistics_name not between", value1, value2, "logisticsName");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherIsNull() {
            addCriterion("logistics_other is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherIsNotNull() {
            addCriterion("logistics_other is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherEqualTo(String value) {
            addCriterion("logistics_other =", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherNotEqualTo(String value) {
            addCriterion("logistics_other <>", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherGreaterThan(String value) {
            addCriterion("logistics_other >", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_other >=", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherLessThan(String value) {
            addCriterion("logistics_other <", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherLessThanOrEqualTo(String value) {
            addCriterion("logistics_other <=", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherLike(String value) {
            addCriterion("logistics_other like", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherNotLike(String value) {
            addCriterion("logistics_other not like", value, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherIn(List<String> values) {
            addCriterion("logistics_other in", values, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherNotIn(List<String> values) {
            addCriterion("logistics_other not in", values, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherBetween(String value1, String value2) {
            addCriterion("logistics_other between", value1, value2, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsOtherNotBetween(String value1, String value2) {
            addCriterion("logistics_other not between", value1, value2, "logisticsOther");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumIsNull() {
            addCriterion("logistics_num is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumIsNotNull() {
            addCriterion("logistics_num is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumEqualTo(Integer value) {
            addCriterion("logistics_num =", value, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumNotEqualTo(Integer value) {
            addCriterion("logistics_num <>", value, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumGreaterThan(Integer value) {
            addCriterion("logistics_num >", value, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("logistics_num >=", value, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumLessThan(Integer value) {
            addCriterion("logistics_num <", value, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumLessThanOrEqualTo(Integer value) {
            addCriterion("logistics_num <=", value, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumIn(List<Integer> values) {
            addCriterion("logistics_num in", values, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumNotIn(List<Integer> values) {
            addCriterion("logistics_num not in", values, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumBetween(Integer value1, Integer value2) {
            addCriterion("logistics_num between", value1, value2, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsNumNotBetween(Integer value1, Integer value2) {
            addCriterion("logistics_num not between", value1, value2, "logisticsNum");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherIsNull() {
            addCriterion("logistics_voucher is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherIsNotNull() {
            addCriterion("logistics_voucher is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherEqualTo(String value) {
            addCriterion("logistics_voucher =", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherNotEqualTo(String value) {
            addCriterion("logistics_voucher <>", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherGreaterThan(String value) {
            addCriterion("logistics_voucher >", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherGreaterThanOrEqualTo(String value) {
            addCriterion("logistics_voucher >=", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherLessThan(String value) {
            addCriterion("logistics_voucher <", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherLessThanOrEqualTo(String value) {
            addCriterion("logistics_voucher <=", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherLike(String value) {
            addCriterion("logistics_voucher like", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherNotLike(String value) {
            addCriterion("logistics_voucher not like", value, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherIn(List<String> values) {
            addCriterion("logistics_voucher in", values, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherNotIn(List<String> values) {
            addCriterion("logistics_voucher not in", values, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherBetween(String value1, String value2) {
            addCriterion("logistics_voucher between", value1, value2, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsVoucherNotBetween(String value1, String value2) {
            addCriterion("logistics_voucher not between", value1, value2, "logisticsVoucher");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeIsNull() {
            addCriterion("logistics_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeIsNotNull() {
            addCriterion("logistics_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeEqualTo(Date value) {
            addCriterion("logistics_creat_time =", value, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeNotEqualTo(Date value) {
            addCriterion("logistics_creat_time <>", value, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeGreaterThan(Date value) {
            addCriterion("logistics_creat_time >", value, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logistics_creat_time >=", value, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeLessThan(Date value) {
            addCriterion("logistics_creat_time <", value, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("logistics_creat_time <=", value, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeIn(List<Date> values) {
            addCriterion("logistics_creat_time in", values, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeNotIn(List<Date> values) {
            addCriterion("logistics_creat_time not in", values, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeBetween(Date value1, Date value2) {
            addCriterion("logistics_creat_time between", value1, value2, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("logistics_creat_time not between", value1, value2, "logisticsCreatTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeIsNull() {
            addCriterion("logistics_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeIsNotNull() {
            addCriterion("logistics_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeEqualTo(Date value) {
            addCriterion("logistics_update_time =", value, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeNotEqualTo(Date value) {
            addCriterion("logistics_update_time <>", value, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeGreaterThan(Date value) {
            addCriterion("logistics_update_time >", value, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logistics_update_time >=", value, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeLessThan(Date value) {
            addCriterion("logistics_update_time <", value, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("logistics_update_time <=", value, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeIn(List<Date> values) {
            addCriterion("logistics_update_time in", values, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeNotIn(List<Date> values) {
            addCriterion("logistics_update_time not in", values, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("logistics_update_time between", value1, value2, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLogisticsUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("logistics_update_time not between", value1, value2, "logisticsUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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