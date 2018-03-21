package com.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperCarPropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperCarPropertyExample() {
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

        public Criteria andCarIdIsNull() {
            addCriterion("car_id is null");
            return (Criteria) this;
        }

        public Criteria andCarIdIsNotNull() {
            addCriterion("car_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarIdEqualTo(Integer value) {
            addCriterion("car_id =", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotEqualTo(Integer value) {
            addCriterion("car_id <>", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThan(Integer value) {
            addCriterion("car_id >", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_id >=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThan(Integer value) {
            addCriterion("car_id <", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdLessThanOrEqualTo(Integer value) {
            addCriterion("car_id <=", value, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdIn(List<Integer> values) {
            addCriterion("car_id in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotIn(List<Integer> values) {
            addCriterion("car_id not in", values, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdBetween(Integer value1, Integer value2) {
            addCriterion("car_id between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIdNotBetween(Integer value1, Integer value2) {
            addCriterion("car_id not between", value1, value2, "carId");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveIsNull() {
            addCriterion("car_is_have is null");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveIsNotNull() {
            addCriterion("car_is_have is not null");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveEqualTo(Integer value) {
            addCriterion("car_is_have =", value, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveNotEqualTo(Integer value) {
            addCriterion("car_is_have <>", value, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveGreaterThan(Integer value) {
            addCriterion("car_is_have >", value, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_is_have >=", value, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveLessThan(Integer value) {
            addCriterion("car_is_have <", value, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveLessThanOrEqualTo(Integer value) {
            addCriterion("car_is_have <=", value, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveIn(List<Integer> values) {
            addCriterion("car_is_have in", values, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveNotIn(List<Integer> values) {
            addCriterion("car_is_have not in", values, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveBetween(Integer value1, Integer value2) {
            addCriterion("car_is_have between", value1, value2, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarIsHaveNotBetween(Integer value1, Integer value2) {
            addCriterion("car_is_have not between", value1, value2, "carIsHave");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumIsNull() {
            addCriterion("car_chassis_num is null");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumIsNotNull() {
            addCriterion("car_chassis_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumEqualTo(String value) {
            addCriterion("car_chassis_num =", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumNotEqualTo(String value) {
            addCriterion("car_chassis_num <>", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumGreaterThan(String value) {
            addCriterion("car_chassis_num >", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumGreaterThanOrEqualTo(String value) {
            addCriterion("car_chassis_num >=", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumLessThan(String value) {
            addCriterion("car_chassis_num <", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumLessThanOrEqualTo(String value) {
            addCriterion("car_chassis_num <=", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumLike(String value) {
            addCriterion("car_chassis_num like", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumNotLike(String value) {
            addCriterion("car_chassis_num not like", value, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumIn(List<String> values) {
            addCriterion("car_chassis_num in", values, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumNotIn(List<String> values) {
            addCriterion("car_chassis_num not in", values, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumBetween(String value1, String value2) {
            addCriterion("car_chassis_num between", value1, value2, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarChassisNumNotBetween(String value1, String value2) {
            addCriterion("car_chassis_num not between", value1, value2, "carChassisNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumIsNull() {
            addCriterion("car_plate_num is null");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumIsNotNull() {
            addCriterion("car_plate_num is not null");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumEqualTo(String value) {
            addCriterion("car_plate_num =", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumNotEqualTo(String value) {
            addCriterion("car_plate_num <>", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumGreaterThan(String value) {
            addCriterion("car_plate_num >", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumGreaterThanOrEqualTo(String value) {
            addCriterion("car_plate_num >=", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumLessThan(String value) {
            addCriterion("car_plate_num <", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumLessThanOrEqualTo(String value) {
            addCriterion("car_plate_num <=", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumLike(String value) {
            addCriterion("car_plate_num like", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumNotLike(String value) {
            addCriterion("car_plate_num not like", value, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumIn(List<String> values) {
            addCriterion("car_plate_num in", values, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumNotIn(List<String> values) {
            addCriterion("car_plate_num not in", values, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumBetween(String value1, String value2) {
            addCriterion("car_plate_num between", value1, value2, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarPlateNumNotBetween(String value1, String value2) {
            addCriterion("car_plate_num not between", value1, value2, "carPlateNum");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNull() {
            addCriterion("car_brand is null");
            return (Criteria) this;
        }

        public Criteria andCarBrandIsNotNull() {
            addCriterion("car_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCarBrandEqualTo(String value) {
            addCriterion("car_brand =", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotEqualTo(String value) {
            addCriterion("car_brand <>", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThan(String value) {
            addCriterion("car_brand >", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandGreaterThanOrEqualTo(String value) {
            addCriterion("car_brand >=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThan(String value) {
            addCriterion("car_brand <", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLessThanOrEqualTo(String value) {
            addCriterion("car_brand <=", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandLike(String value) {
            addCriterion("car_brand like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotLike(String value) {
            addCriterion("car_brand not like", value, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandIn(List<String> values) {
            addCriterion("car_brand in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotIn(List<String> values) {
            addCriterion("car_brand not in", values, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandBetween(String value1, String value2) {
            addCriterion("car_brand between", value1, value2, "carBrand");
            return (Criteria) this;
        }

        public Criteria andCarBrandNotBetween(String value1, String value2) {
            addCriterion("car_brand not between", value1, value2, "carBrand");
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

        public Criteria andCarUsernameIsNull() {
            addCriterion("car_username is null");
            return (Criteria) this;
        }

        public Criteria andCarUsernameIsNotNull() {
            addCriterion("car_username is not null");
            return (Criteria) this;
        }

        public Criteria andCarUsernameEqualTo(String value) {
            addCriterion("car_username =", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameNotEqualTo(String value) {
            addCriterion("car_username <>", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameGreaterThan(String value) {
            addCriterion("car_username >", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("car_username >=", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameLessThan(String value) {
            addCriterion("car_username <", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameLessThanOrEqualTo(String value) {
            addCriterion("car_username <=", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameLike(String value) {
            addCriterion("car_username like", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameNotLike(String value) {
            addCriterion("car_username not like", value, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameIn(List<String> values) {
            addCriterion("car_username in", values, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameNotIn(List<String> values) {
            addCriterion("car_username not in", values, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameBetween(String value1, String value2) {
            addCriterion("car_username between", value1, value2, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarUsernameNotBetween(String value1, String value2) {
            addCriterion("car_username not between", value1, value2, "carUsername");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeIsNull() {
            addCriterion("car_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeIsNotNull() {
            addCriterion("car_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeEqualTo(Date value) {
            addCriterion("car_creat_time =", value, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeNotEqualTo(Date value) {
            addCriterion("car_creat_time <>", value, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeGreaterThan(Date value) {
            addCriterion("car_creat_time >", value, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("car_creat_time >=", value, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeLessThan(Date value) {
            addCriterion("car_creat_time <", value, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("car_creat_time <=", value, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeIn(List<Date> values) {
            addCriterion("car_creat_time in", values, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeNotIn(List<Date> values) {
            addCriterion("car_creat_time not in", values, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeBetween(Date value1, Date value2) {
            addCriterion("car_creat_time between", value1, value2, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("car_creat_time not between", value1, value2, "carCreatTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeIsNull() {
            addCriterion("car_update_time is null");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeIsNotNull() {
            addCriterion("car_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeEqualTo(Date value) {
            addCriterion("car_update_time =", value, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeNotEqualTo(Date value) {
            addCriterion("car_update_time <>", value, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeGreaterThan(Date value) {
            addCriterion("car_update_time >", value, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("car_update_time >=", value, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeLessThan(Date value) {
            addCriterion("car_update_time <", value, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("car_update_time <=", value, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeIn(List<Date> values) {
            addCriterion("car_update_time in", values, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeNotIn(List<Date> values) {
            addCriterion("car_update_time not in", values, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("car_update_time between", value1, value2, "carUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCarUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("car_update_time not between", value1, value2, "carUpdateTime");
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