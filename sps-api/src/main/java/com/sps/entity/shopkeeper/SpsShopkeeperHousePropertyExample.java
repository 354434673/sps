package com.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperHousePropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperHousePropertyExample() {
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

        public Criteria andHouseIdIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouseIdIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIdEqualTo(Integer value) {
            addCriterion("house_id =", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotEqualTo(Integer value) {
            addCriterion("house_id <>", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThan(Integer value) {
            addCriterion("house_id >", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_id >=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThan(Integer value) {
            addCriterion("house_id <", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdLessThanOrEqualTo(Integer value) {
            addCriterion("house_id <=", value, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdIn(List<Integer> values) {
            addCriterion("house_id in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotIn(List<Integer> values) {
            addCriterion("house_id not in", values, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdBetween(Integer value1, Integer value2) {
            addCriterion("house_id between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("house_id not between", value1, value2, "houseId");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveIsNull() {
            addCriterion("house_is_have is null");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveIsNotNull() {
            addCriterion("house_is_have is not null");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveEqualTo(Integer value) {
            addCriterion("house_is_have =", value, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveNotEqualTo(Integer value) {
            addCriterion("house_is_have <>", value, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveGreaterThan(Integer value) {
            addCriterion("house_is_have >", value, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("house_is_have >=", value, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveLessThan(Integer value) {
            addCriterion("house_is_have <", value, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveLessThanOrEqualTo(Integer value) {
            addCriterion("house_is_have <=", value, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveIn(List<Integer> values) {
            addCriterion("house_is_have in", values, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveNotIn(List<Integer> values) {
            addCriterion("house_is_have not in", values, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveBetween(Integer value1, Integer value2) {
            addCriterion("house_is_have between", value1, value2, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseIsHaveNotBetween(Integer value1, Integer value2) {
            addCriterion("house_is_have not between", value1, value2, "houseIsHave");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNull() {
            addCriterion("house_area is null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIsNotNull() {
            addCriterion("house_area is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAreaEqualTo(Double value) {
            addCriterion("house_area =", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotEqualTo(Double value) {
            addCriterion("house_area <>", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThan(Double value) {
            addCriterion("house_area >", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaGreaterThanOrEqualTo(Double value) {
            addCriterion("house_area >=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThan(Double value) {
            addCriterion("house_area <", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaLessThanOrEqualTo(Double value) {
            addCriterion("house_area <=", value, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaIn(List<Double> values) {
            addCriterion("house_area in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotIn(List<Double> values) {
            addCriterion("house_area not in", values, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaBetween(Double value1, Double value2) {
            addCriterion("house_area between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAreaNotBetween(Double value1, Double value2) {
            addCriterion("house_area not between", value1, value2, "houseArea");
            return (Criteria) this;
        }

        public Criteria andHouseAddrIsNull() {
            addCriterion("house_addr is null");
            return (Criteria) this;
        }

        public Criteria andHouseAddrIsNotNull() {
            addCriterion("house_addr is not null");
            return (Criteria) this;
        }

        public Criteria andHouseAddrEqualTo(String value) {
            addCriterion("house_addr =", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotEqualTo(String value) {
            addCriterion("house_addr <>", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrGreaterThan(String value) {
            addCriterion("house_addr >", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrGreaterThanOrEqualTo(String value) {
            addCriterion("house_addr >=", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrLessThan(String value) {
            addCriterion("house_addr <", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrLessThanOrEqualTo(String value) {
            addCriterion("house_addr <=", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrLike(String value) {
            addCriterion("house_addr like", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotLike(String value) {
            addCriterion("house_addr not like", value, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrIn(List<String> values) {
            addCriterion("house_addr in", values, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotIn(List<String> values) {
            addCriterion("house_addr not in", values, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrBetween(String value1, String value2) {
            addCriterion("house_addr between", value1, value2, "houseAddr");
            return (Criteria) this;
        }

        public Criteria andHouseAddrNotBetween(String value1, String value2) {
            addCriterion("house_addr not between", value1, value2, "houseAddr");
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

        public Criteria andHouseUsernameIsNull() {
            addCriterion("house_username is null");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameIsNotNull() {
            addCriterion("house_username is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameEqualTo(String value) {
            addCriterion("house_username =", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameNotEqualTo(String value) {
            addCriterion("house_username <>", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameGreaterThan(String value) {
            addCriterion("house_username >", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("house_username >=", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameLessThan(String value) {
            addCriterion("house_username <", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameLessThanOrEqualTo(String value) {
            addCriterion("house_username <=", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameLike(String value) {
            addCriterion("house_username like", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameNotLike(String value) {
            addCriterion("house_username not like", value, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameIn(List<String> values) {
            addCriterion("house_username in", values, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameNotIn(List<String> values) {
            addCriterion("house_username not in", values, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameBetween(String value1, String value2) {
            addCriterion("house_username between", value1, value2, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseUsernameNotBetween(String value1, String value2) {
            addCriterion("house_username not between", value1, value2, "houseUsername");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeIsNull() {
            addCriterion("house_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeIsNotNull() {
            addCriterion("house_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeEqualTo(Date value) {
            addCriterion("house_creat_time =", value, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeNotEqualTo(Date value) {
            addCriterion("house_creat_time <>", value, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeGreaterThan(Date value) {
            addCriterion("house_creat_time >", value, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("house_creat_time >=", value, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeLessThan(Date value) {
            addCriterion("house_creat_time <", value, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("house_creat_time <=", value, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeIn(List<Date> values) {
            addCriterion("house_creat_time in", values, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeNotIn(List<Date> values) {
            addCriterion("house_creat_time not in", values, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeBetween(Date value1, Date value2) {
            addCriterion("house_creat_time between", value1, value2, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("house_creat_time not between", value1, value2, "houseCreatTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeIsNull() {
            addCriterion("house_update_time is null");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeIsNotNull() {
            addCriterion("house_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeEqualTo(Date value) {
            addCriterion("house_update_time =", value, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeNotEqualTo(Date value) {
            addCriterion("house_update_time <>", value, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeGreaterThan(Date value) {
            addCriterion("house_update_time >", value, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("house_update_time >=", value, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeLessThan(Date value) {
            addCriterion("house_update_time <", value, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("house_update_time <=", value, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeIn(List<Date> values) {
            addCriterion("house_update_time in", values, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeNotIn(List<Date> values) {
            addCriterion("house_update_time not in", values, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("house_update_time between", value1, value2, "houseUpdateTime");
            return (Criteria) this;
        }

        public Criteria andHouseUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("house_update_time not between", value1, value2, "houseUpdateTime");
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