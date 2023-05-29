package com.hjp.lottery.domain.strategy.model.aggregates;

import com.hjp.lottery.infrastructure.po.Strategy;
import com.hjp.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

public class StrategyRich {
    // 策略ID
    private Long strategyId;
    // 策略配置
    private Strategy strategy;
    // 策略明细
    private List<StrategyDetail> strategyDetailList;

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetail> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }
}
