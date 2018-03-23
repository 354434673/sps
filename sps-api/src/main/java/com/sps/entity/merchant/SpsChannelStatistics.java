package com.sps.entity.merchant;

import java.io.Serializable;
import java.math.BigDecimal;

public class SpsChannelStatistics implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1L;

	private Integer statisticsId;

    private Integer statisticsPassOrderNum;

    private BigDecimal statisticsPassOrderAmount;

    private Integer statisticsSkuNum;

    private BigDecimal statisticsSkuPrice;

    private Integer statisticsCollaborateShopkeeperNum;

    private Integer statisticsDealShopkeeperNum;

    private BigDecimal statisticsShopkeeperAvgMoney;

    private Integer statisticsShopkeeperAvgNum;

    private String statisticsSkuSalesRank;

    private String statisticsSkuPriceMarketDifference;

    private String channelNum;

    public Integer getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(Integer statisticsId) {
        this.statisticsId = statisticsId;
    }

    public Integer getStatisticsPassOrderNum() {
        return statisticsPassOrderNum;
    }

    public void setStatisticsPassOrderNum(Integer statisticsPassOrderNum) {
        this.statisticsPassOrderNum = statisticsPassOrderNum;
    }

    public BigDecimal getStatisticsPassOrderAmount() {
        return statisticsPassOrderAmount;
    }

    public void setStatisticsPassOrderAmount(BigDecimal statisticsPassOrderAmount) {
        this.statisticsPassOrderAmount = statisticsPassOrderAmount;
    }

    public Integer getStatisticsSkuNum() {
        return statisticsSkuNum;
    }

    public void setStatisticsSkuNum(Integer statisticsSkuNum) {
        this.statisticsSkuNum = statisticsSkuNum;
    }

    public BigDecimal getStatisticsSkuPrice() {
        return statisticsSkuPrice;
    }

    public void setStatisticsSkuPrice(BigDecimal statisticsSkuPrice) {
        this.statisticsSkuPrice = statisticsSkuPrice;
    }

    public Integer getStatisticsCollaborateShopkeeperNum() {
        return statisticsCollaborateShopkeeperNum;
    }

    public void setStatisticsCollaborateShopkeeperNum(Integer statisticsCollaborateShopkeeperNum) {
        this.statisticsCollaborateShopkeeperNum = statisticsCollaborateShopkeeperNum;
    }

    public Integer getStatisticsDealShopkeeperNum() {
        return statisticsDealShopkeeperNum;
    }

    public void setStatisticsDealShopkeeperNum(Integer statisticsDealShopkeeperNum) {
        this.statisticsDealShopkeeperNum = statisticsDealShopkeeperNum;
    }

    public BigDecimal getStatisticsShopkeeperAvgMoney() {
        return statisticsShopkeeperAvgMoney;
    }

    public void setStatisticsShopkeeperAvgMoney(BigDecimal statisticsShopkeeperAvgMoney) {
        this.statisticsShopkeeperAvgMoney = statisticsShopkeeperAvgMoney;
    }

    public Integer getStatisticsShopkeeperAvgNum() {
        return statisticsShopkeeperAvgNum;
    }

    public void setStatisticsShopkeeperAvgNum(Integer statisticsShopkeeperAvgNum) {
        this.statisticsShopkeeperAvgNum = statisticsShopkeeperAvgNum;
    }

    public String getStatisticsSkuSalesRank() {
        return statisticsSkuSalesRank;
    }

    public void setStatisticsSkuSalesRank(String statisticsSkuSalesRank) {
        this.statisticsSkuSalesRank = statisticsSkuSalesRank == null ? null : statisticsSkuSalesRank.trim();
    }

    public String getStatisticsSkuPriceMarketDifference() {
        return statisticsSkuPriceMarketDifference;
    }

    public void setStatisticsSkuPriceMarketDifference(String statisticsSkuPriceMarketDifference) {
        this.statisticsSkuPriceMarketDifference = statisticsSkuPriceMarketDifference == null ? null : statisticsSkuPriceMarketDifference.trim();
    }

    public String getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(String channelNum) {
        this.channelNum = channelNum == null ? null : channelNum.trim();
    }
}