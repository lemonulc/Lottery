package com.hjp.lottery.domain.strategy.repository.impl;

import com.hjp.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.hjp.lottery.domain.strategy.repository.IStrategyRepository;
import com.hjp.lottery.infrastructure.dao.IAwardDao;
import com.hjp.lottery.infrastructure.dao.IStrategyDao;
import com.hjp.lottery.infrastructure.dao.IStrategyDetailDao;
import com.hjp.lottery.infrastructure.po.Award;
import com.hjp.lottery.infrastructure.po.Strategy;
import com.hjp.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }
}
