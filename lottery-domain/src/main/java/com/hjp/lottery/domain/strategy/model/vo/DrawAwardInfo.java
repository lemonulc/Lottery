package com.hjp.lottery.domain.strategy.model.vo;

/**
 * @description:
 * @author：hjp
 * @date: 2023-05-29
 * @Copyright： hjp
 */
public class DrawAwardInfo {
    /**
     * 奖品ID
     */
    private String rewardId;

    /**
     * 奖品名称
     */
    private String awardName;

    public DrawAwardInfo() {
    }

    public DrawAwardInfo(String rewardId, String awardName) {
        this.rewardId = rewardId;
        this.awardName = awardName;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

}
