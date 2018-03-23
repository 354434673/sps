package com.sps.entity.merchant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SpsChannelStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpsChannelStatisticsExample() {
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

        public Criteria andStatisticsIdIsNull() {
            addCriterion("statistics_id is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdIsNotNull() {
            addCriterion("statistics_id is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdEqualTo(Integer value) {
            addCriterion("statistics_id =", value, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdNotEqualTo(Integer value) {
            addCriterion("statistics_id <>", value, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdGreaterThan(Integer value) {
            addCriterion("statistics_id >", value, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics_id >=", value, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdLessThan(Integer value) {
            addCriterion("statistics_id <", value, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdLessThanOrEqualTo(Integer value) {
            addCriterion("statistics_id <=", value, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdIn(List<Integer> values) {
            addCriterion("statistics_id in", values, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdNotIn(List<Integer> values) {
            addCriterion("statistics_id not in", values, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdBetween(Integer value1, Integer value2) {
            addCriterion("statistics_id between", value1, value2, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics_id not between", value1, value2, "statisticsId");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumIsNull() {
            addCriterion("statistics_pass_order_num is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumIsNotNull() {
            addCriterion("statistics_pass_order_num is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumEqualTo(Integer value) {
            addCriterion("statistics_pass_order_num =", value, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumNotEqualTo(Integer value) {
            addCriterion("statistics_pass_order_num <>", value, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumGreaterThan(Integer value) {
            addCriterion("statistics_pass_order_num >", value, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics_pass_order_num >=", value, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumLessThan(Integer value) {
            addCriterion("statistics_pass_order_num <", value, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("statistics_pass_order_num <=", value, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumIn(List<Integer> values) {
            addCriterion("statistics_pass_order_num in", values, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumNotIn(List<Integer> values) {
            addCriterion("statistics_pass_order_num not in", values, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("statistics_pass_order_num between", value1, value2, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics_pass_order_num not between", value1, value2, "statisticsPassOrderNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountIsNull() {
            addCriterion("statistics_pass_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountIsNotNull() {
            addCriterion("statistics_pass_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountEqualTo(BigDecimal value) {
            addCriterion("statistics_pass_order_amount =", value, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("statistics_pass_order_amount <>", value, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("statistics_pass_order_amount >", value, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("statistics_pass_order_amount >=", value, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountLessThan(BigDecimal value) {
            addCriterion("statistics_pass_order_amount <", value, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("statistics_pass_order_amount <=", value, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountIn(List<BigDecimal> values) {
            addCriterion("statistics_pass_order_amount in", values, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("statistics_pass_order_amount not in", values, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("statistics_pass_order_amount between", value1, value2, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsPassOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("statistics_pass_order_amount not between", value1, value2, "statisticsPassOrderAmount");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumIsNull() {
            addCriterion("statistics_sku_num is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumIsNotNull() {
            addCriterion("statistics_sku_num is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumEqualTo(Integer value) {
            addCriterion("statistics_sku_num =", value, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumNotEqualTo(Integer value) {
            addCriterion("statistics_sku_num <>", value, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumGreaterThan(Integer value) {
            addCriterion("statistics_sku_num >", value, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics_sku_num >=", value, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumLessThan(Integer value) {
            addCriterion("statistics_sku_num <", value, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumLessThanOrEqualTo(Integer value) {
            addCriterion("statistics_sku_num <=", value, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumIn(List<Integer> values) {
            addCriterion("statistics_sku_num in", values, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumNotIn(List<Integer> values) {
            addCriterion("statistics_sku_num not in", values, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumBetween(Integer value1, Integer value2) {
            addCriterion("statistics_sku_num between", value1, value2, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuNumNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics_sku_num not between", value1, value2, "statisticsSkuNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceIsNull() {
            addCriterion("statistics_sku_price is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceIsNotNull() {
            addCriterion("statistics_sku_price is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceEqualTo(BigDecimal value) {
            addCriterion("statistics_sku_price =", value, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceNotEqualTo(BigDecimal value) {
            addCriterion("statistics_sku_price <>", value, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceGreaterThan(BigDecimal value) {
            addCriterion("statistics_sku_price >", value, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("statistics_sku_price >=", value, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceLessThan(BigDecimal value) {
            addCriterion("statistics_sku_price <", value, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("statistics_sku_price <=", value, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceIn(List<BigDecimal> values) {
            addCriterion("statistics_sku_price in", values, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceNotIn(List<BigDecimal> values) {
            addCriterion("statistics_sku_price not in", values, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("statistics_sku_price between", value1, value2, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("statistics_sku_price not between", value1, value2, "statisticsSkuPrice");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumIsNull() {
            addCriterion("statistics_collaborate_shopkeeper_num is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumIsNotNull() {
            addCriterion("statistics_collaborate_shopkeeper_num is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumEqualTo(Integer value) {
            addCriterion("statistics_collaborate_shopkeeper_num =", value, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumNotEqualTo(Integer value) {
            addCriterion("statistics_collaborate_shopkeeper_num <>", value, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumGreaterThan(Integer value) {
            addCriterion("statistics_collaborate_shopkeeper_num >", value, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics_collaborate_shopkeeper_num >=", value, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumLessThan(Integer value) {
            addCriterion("statistics_collaborate_shopkeeper_num <", value, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumLessThanOrEqualTo(Integer value) {
            addCriterion("statistics_collaborate_shopkeeper_num <=", value, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumIn(List<Integer> values) {
            addCriterion("statistics_collaborate_shopkeeper_num in", values, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumNotIn(List<Integer> values) {
            addCriterion("statistics_collaborate_shopkeeper_num not in", values, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumBetween(Integer value1, Integer value2) {
            addCriterion("statistics_collaborate_shopkeeper_num between", value1, value2, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsCollaborateShopkeeperNumNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics_collaborate_shopkeeper_num not between", value1, value2, "statisticsCollaborateShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumIsNull() {
            addCriterion("statistics_deal_shopkeeper_num is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumIsNotNull() {
            addCriterion("statistics_deal_shopkeeper_num is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumEqualTo(Integer value) {
            addCriterion("statistics_deal_shopkeeper_num =", value, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumNotEqualTo(Integer value) {
            addCriterion("statistics_deal_shopkeeper_num <>", value, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumGreaterThan(Integer value) {
            addCriterion("statistics_deal_shopkeeper_num >", value, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics_deal_shopkeeper_num >=", value, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumLessThan(Integer value) {
            addCriterion("statistics_deal_shopkeeper_num <", value, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumLessThanOrEqualTo(Integer value) {
            addCriterion("statistics_deal_shopkeeper_num <=", value, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumIn(List<Integer> values) {
            addCriterion("statistics_deal_shopkeeper_num in", values, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumNotIn(List<Integer> values) {
            addCriterion("statistics_deal_shopkeeper_num not in", values, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumBetween(Integer value1, Integer value2) {
            addCriterion("statistics_deal_shopkeeper_num between", value1, value2, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsDealShopkeeperNumNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics_deal_shopkeeper_num not between", value1, value2, "statisticsDealShopkeeperNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyIsNull() {
            addCriterion("statistics_shopkeeper_avg_money is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyIsNotNull() {
            addCriterion("statistics_shopkeeper_avg_money is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyEqualTo(BigDecimal value) {
            addCriterion("statistics_shopkeeper_avg_money =", value, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyNotEqualTo(BigDecimal value) {
            addCriterion("statistics_shopkeeper_avg_money <>", value, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyGreaterThan(BigDecimal value) {
            addCriterion("statistics_shopkeeper_avg_money >", value, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("statistics_shopkeeper_avg_money >=", value, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyLessThan(BigDecimal value) {
            addCriterion("statistics_shopkeeper_avg_money <", value, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("statistics_shopkeeper_avg_money <=", value, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyIn(List<BigDecimal> values) {
            addCriterion("statistics_shopkeeper_avg_money in", values, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyNotIn(List<BigDecimal> values) {
            addCriterion("statistics_shopkeeper_avg_money not in", values, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("statistics_shopkeeper_avg_money between", value1, value2, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("statistics_shopkeeper_avg_money not between", value1, value2, "statisticsShopkeeperAvgMoney");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumIsNull() {
            addCriterion("statistics_shopkeeper_avg_num is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumIsNotNull() {
            addCriterion("statistics_shopkeeper_avg_num is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumEqualTo(Integer value) {
            addCriterion("statistics_shopkeeper_avg_num =", value, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumNotEqualTo(Integer value) {
            addCriterion("statistics_shopkeeper_avg_num <>", value, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumGreaterThan(Integer value) {
            addCriterion("statistics_shopkeeper_avg_num >", value, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("statistics_shopkeeper_avg_num >=", value, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumLessThan(Integer value) {
            addCriterion("statistics_shopkeeper_avg_num <", value, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumLessThanOrEqualTo(Integer value) {
            addCriterion("statistics_shopkeeper_avg_num <=", value, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumIn(List<Integer> values) {
            addCriterion("statistics_shopkeeper_avg_num in", values, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumNotIn(List<Integer> values) {
            addCriterion("statistics_shopkeeper_avg_num not in", values, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumBetween(Integer value1, Integer value2) {
            addCriterion("statistics_shopkeeper_avg_num between", value1, value2, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsShopkeeperAvgNumNotBetween(Integer value1, Integer value2) {
            addCriterion("statistics_shopkeeper_avg_num not between", value1, value2, "statisticsShopkeeperAvgNum");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankIsNull() {
            addCriterion("statistics_sku_sales_rank is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankIsNotNull() {
            addCriterion("statistics_sku_sales_rank is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankEqualTo(String value) {
            addCriterion("statistics_sku_sales_rank =", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankNotEqualTo(String value) {
            addCriterion("statistics_sku_sales_rank <>", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankGreaterThan(String value) {
            addCriterion("statistics_sku_sales_rank >", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankGreaterThanOrEqualTo(String value) {
            addCriterion("statistics_sku_sales_rank >=", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankLessThan(String value) {
            addCriterion("statistics_sku_sales_rank <", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankLessThanOrEqualTo(String value) {
            addCriterion("statistics_sku_sales_rank <=", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankLike(String value) {
            addCriterion("statistics_sku_sales_rank like", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankNotLike(String value) {
            addCriterion("statistics_sku_sales_rank not like", value, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankIn(List<String> values) {
            addCriterion("statistics_sku_sales_rank in", values, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankNotIn(List<String> values) {
            addCriterion("statistics_sku_sales_rank not in", values, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankBetween(String value1, String value2) {
            addCriterion("statistics_sku_sales_rank between", value1, value2, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuSalesRankNotBetween(String value1, String value2) {
            addCriterion("statistics_sku_sales_rank not between", value1, value2, "statisticsSkuSalesRank");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceIsNull() {
            addCriterion("\"statistics_sku_price_ market_difference\" is null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceIsNotNull() {
            addCriterion("\"statistics_sku_price_ market_difference\" is not null");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceEqualTo(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" =", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceNotEqualTo(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" <>", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceGreaterThan(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" >", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceGreaterThanOrEqualTo(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" >=", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceLessThan(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" <", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceLessThanOrEqualTo(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" <=", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceLike(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" like", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceNotLike(String value) {
            addCriterion("\"statistics_sku_price_ market_difference\" not like", value, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceIn(List<String> values) {
            addCriterion("\"statistics_sku_price_ market_difference\" in", values, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceNotIn(List<String> values) {
            addCriterion("\"statistics_sku_price_ market_difference\" not in", values, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceBetween(String value1, String value2) {
            addCriterion("\"statistics_sku_price_ market_difference\" between", value1, value2, "statisticsSkuPriceMarketDifference");
            return (Criteria) this;
        }

        public Criteria andStatisticsSkuPriceMarketDifferenceNotBetween(String value1, String value2) {
            addCriterion("\"statistics_sku_price_ market_difference\" not between", value1, value2, "statisticsSkuPriceMarketDifference");
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