package com.hjp.lottery.domain.strategy.repository;

import com.hjp.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.hjp.lottery.infrastructure.po.Award;

public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);
}
