package com.sps.entity.shopkeeper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpsShopkeeperPicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsShopkeeperPicExample() {
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

        public Criteria andPicIdIsNull() {
            addCriterion("pic_id is null");
            return (Criteria) this;
        }

        public Criteria andPicIdIsNotNull() {
            addCriterion("pic_id is not null");
            return (Criteria) this;
        }

        public Criteria andPicIdEqualTo(Integer value) {
            addCriterion("pic_id =", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotEqualTo(Integer value) {
            addCriterion("pic_id <>", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThan(Integer value) {
            addCriterion("pic_id >", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_id >=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThan(Integer value) {
            addCriterion("pic_id <", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdLessThanOrEqualTo(Integer value) {
            addCriterion("pic_id <=", value, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdIn(List<Integer> values) {
            addCriterion("pic_id in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotIn(List<Integer> values) {
            addCriterion("pic_id not in", values, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdBetween(Integer value1, Integer value2) {
            addCriterion("pic_id between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_id not between", value1, value2, "picId");
            return (Criteria) this;
        }

        public Criteria andPicSrcIsNull() {
            addCriterion("pic_src is null");
            return (Criteria) this;
        }

        public Criteria andPicSrcIsNotNull() {
            addCriterion("pic_src is not null");
            return (Criteria) this;
        }

        public Criteria andPicSrcEqualTo(String value) {
            addCriterion("pic_src =", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotEqualTo(String value) {
            addCriterion("pic_src <>", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcGreaterThan(String value) {
            addCriterion("pic_src >", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcGreaterThanOrEqualTo(String value) {
            addCriterion("pic_src >=", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLessThan(String value) {
            addCriterion("pic_src <", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLessThanOrEqualTo(String value) {
            addCriterion("pic_src <=", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcLike(String value) {
            addCriterion("pic_src like", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotLike(String value) {
            addCriterion("pic_src not like", value, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcIn(List<String> values) {
            addCriterion("pic_src in", values, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotIn(List<String> values) {
            addCriterion("pic_src not in", values, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcBetween(String value1, String value2) {
            addCriterion("pic_src between", value1, value2, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicSrcNotBetween(String value1, String value2) {
            addCriterion("pic_src not between", value1, value2, "picSrc");
            return (Criteria) this;
        }

        public Criteria andPicTypeIsNull() {
            addCriterion("pic_type is null");
            return (Criteria) this;
        }

        public Criteria andPicTypeIsNotNull() {
            addCriterion("pic_type is not null");
            return (Criteria) this;
        }

        public Criteria andPicTypeEqualTo(Integer value) {
            addCriterion("pic_type =", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotEqualTo(Integer value) {
            addCriterion("pic_type <>", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeGreaterThan(Integer value) {
            addCriterion("pic_type >", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_type >=", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLessThan(Integer value) {
            addCriterion("pic_type <", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pic_type <=", value, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeIn(List<Integer> values) {
            addCriterion("pic_type in", values, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotIn(List<Integer> values) {
            addCriterion("pic_type not in", values, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeBetween(Integer value1, Integer value2) {
            addCriterion("pic_type between", value1, value2, "picType");
            return (Criteria) this;
        }

        public Criteria andPicTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_type not between", value1, value2, "picType");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeIsNull() {
            addCriterion("pic_upload_time is null");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeIsNotNull() {
            addCriterion("pic_upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeEqualTo(Date value) {
            addCriterion("pic_upload_time =", value, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeNotEqualTo(Date value) {
            addCriterion("pic_upload_time <>", value, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeGreaterThan(Date value) {
            addCriterion("pic_upload_time >", value, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pic_upload_time >=", value, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeLessThan(Date value) {
            addCriterion("pic_upload_time <", value, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("pic_upload_time <=", value, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeIn(List<Date> values) {
            addCriterion("pic_upload_time in", values, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeNotIn(List<Date> values) {
            addCriterion("pic_upload_time not in", values, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeBetween(Date value1, Date value2) {
            addCriterion("pic_upload_time between", value1, value2, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("pic_upload_time not between", value1, value2, "picUploadTime");
            return (Criteria) this;
        }

        public Criteria andPicOldNameIsNull() {
            addCriterion("pic_old_name is null");
            return (Criteria) this;
        }

        public Criteria andPicOldNameIsNotNull() {
            addCriterion("pic_old_name is not null");
            return (Criteria) this;
        }

        public Criteria andPicOldNameEqualTo(String value) {
            addCriterion("pic_old_name =", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameNotEqualTo(String value) {
            addCriterion("pic_old_name <>", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameGreaterThan(String value) {
            addCriterion("pic_old_name >", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_old_name >=", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameLessThan(String value) {
            addCriterion("pic_old_name <", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameLessThanOrEqualTo(String value) {
            addCriterion("pic_old_name <=", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameLike(String value) {
            addCriterion("pic_old_name like", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameNotLike(String value) {
            addCriterion("pic_old_name not like", value, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameIn(List<String> values) {
            addCriterion("pic_old_name in", values, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameNotIn(List<String> values) {
            addCriterion("pic_old_name not in", values, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameBetween(String value1, String value2) {
            addCriterion("pic_old_name between", value1, value2, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicOldNameNotBetween(String value1, String value2) {
            addCriterion("pic_old_name not between", value1, value2, "picOldName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameIsNull() {
            addCriterion("pic_new_name is null");
            return (Criteria) this;
        }

        public Criteria andPicNewNameIsNotNull() {
            addCriterion("pic_new_name is not null");
            return (Criteria) this;
        }

        public Criteria andPicNewNameEqualTo(String value) {
            addCriterion("pic_new_name =", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotEqualTo(String value) {
            addCriterion("pic_new_name <>", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameGreaterThan(String value) {
            addCriterion("pic_new_name >", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameGreaterThanOrEqualTo(String value) {
            addCriterion("pic_new_name >=", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameLessThan(String value) {
            addCriterion("pic_new_name <", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameLessThanOrEqualTo(String value) {
            addCriterion("pic_new_name <=", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameLike(String value) {
            addCriterion("pic_new_name like", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotLike(String value) {
            addCriterion("pic_new_name not like", value, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameIn(List<String> values) {
            addCriterion("pic_new_name in", values, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotIn(List<String> values) {
            addCriterion("pic_new_name not in", values, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameBetween(String value1, String value2) {
            addCriterion("pic_new_name between", value1, value2, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicNewNameNotBetween(String value1, String value2) {
            addCriterion("pic_new_name not between", value1, value2, "picNewName");
            return (Criteria) this;
        }

        public Criteria andPicStateIsNull() {
            addCriterion("pic_state is null");
            return (Criteria) this;
        }

        public Criteria andPicStateIsNotNull() {
            addCriterion("pic_state is not null");
            return (Criteria) this;
        }

        public Criteria andPicStateEqualTo(Integer value) {
            addCriterion("pic_state =", value, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateNotEqualTo(Integer value) {
            addCriterion("pic_state <>", value, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateGreaterThan(Integer value) {
            addCriterion("pic_state >", value, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pic_state >=", value, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateLessThan(Integer value) {
            addCriterion("pic_state <", value, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateLessThanOrEqualTo(Integer value) {
            addCriterion("pic_state <=", value, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateIn(List<Integer> values) {
            addCriterion("pic_state in", values, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateNotIn(List<Integer> values) {
            addCriterion("pic_state not in", values, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateBetween(Integer value1, Integer value2) {
            addCriterion("pic_state between", value1, value2, "picState");
            return (Criteria) this;
        }

        public Criteria andPicStateNotBetween(Integer value1, Integer value2) {
            addCriterion("pic_state not between", value1, value2, "picState");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeIsNull() {
            addCriterion("pic_creat_time is null");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeIsNotNull() {
            addCriterion("pic_creat_time is not null");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeEqualTo(Date value) {
            addCriterion("pic_creat_time =", value, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeNotEqualTo(Date value) {
            addCriterion("pic_creat_time <>", value, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeGreaterThan(Date value) {
            addCriterion("pic_creat_time >", value, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pic_creat_time >=", value, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeLessThan(Date value) {
            addCriterion("pic_creat_time <", value, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("pic_creat_time <=", value, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeIn(List<Date> values) {
            addCriterion("pic_creat_time in", values, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeNotIn(List<Date> values) {
            addCriterion("pic_creat_time not in", values, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeBetween(Date value1, Date value2) {
            addCriterion("pic_creat_time between", value1, value2, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("pic_creat_time not between", value1, value2, "picCreatTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeIsNull() {
            addCriterion("pic_update_time is null");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeIsNotNull() {
            addCriterion("pic_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeEqualTo(Date value) {
            addCriterion("pic_update_time =", value, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeNotEqualTo(Date value) {
            addCriterion("pic_update_time <>", value, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeGreaterThan(Date value) {
            addCriterion("pic_update_time >", value, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pic_update_time >=", value, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeLessThan(Date value) {
            addCriterion("pic_update_time <", value, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("pic_update_time <=", value, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeIn(List<Date> values) {
            addCriterion("pic_update_time in", values, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeNotIn(List<Date> values) {
            addCriterion("pic_update_time not in", values, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("pic_update_time between", value1, value2, "picUpdateTime");
            return (Criteria) this;
        }

        public Criteria andPicUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("pic_update_time not between", value1, value2, "picUpdateTime");
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