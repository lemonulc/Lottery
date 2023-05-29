package com.hjp.lottery.domain.strategy.service.algorithm;

import com.hjp.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.util.List;

public interface IDrawAlgorithm {
    void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfoList);

    boolean isExistRateTuple(Long strategyId);

    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}
