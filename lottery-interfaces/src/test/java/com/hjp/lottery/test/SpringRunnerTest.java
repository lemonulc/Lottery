package com.hjp.lottery.test;

import com.alibaba.fastjson.JSON;
import com.hjp.lottery.common.Constants;
import com.hjp.lottery.domain.activity.model.req.ActivityConfigReq;
import com.hjp.lottery.domain.activity.model.vo.ActivityVO;
import com.hjp.lottery.domain.activity.model.vo.StrategyDetailVO;
import com.hjp.lottery.domain.activity.model.vo.StrategyVO;
import com.hjp.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.hjp.lottery.domain.activity.service.stateflow.IStateHandler;
import com.hjp.lottery.domain.award.model.req.GoodsReq;
import com.hjp.lottery.domain.award.model.res.DistributionRes;
import com.hjp.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.hjp.lottery.domain.award.service.goods.IDistributionGoods;
import com.hjp.lottery.domain.strategy.model.req.DrawReq;
import com.hjp.lottery.domain.strategy.model.res.DrawResult;
import com.hjp.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.hjp.lottery.domain.strategy.service.draw.IDrawExec;
import com.hjp.lottery.infrastructure.dao.IActivityDao;
import com.hjp.lottery.infrastructure.po.Activity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description:
 * @author：hjp
 * @date: 2023-05-30
 * @Copyright： hjp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRunnerTest {

    private Logger logger = LoggerFactory.getLogger(SpringRunnerTest.class);

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IDrawExec drawExec;

    @Resource
    DistributionGoodsFactory distributionGoodsFactory;

    @Resource
    IStateHandler stateHandler;

    @Test
    public void test_alterState() {
        logger.info("提交审核，测试：{}", JSON.toJSONString(stateHandler.arraignment(100001L, Constants.ActivityState.EDIT)));
        logger.info("审核通过，测试：{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.ARRAIGNMENT)));
        logger.info("运行活动，测试：{}", JSON.toJSONString(stateHandler.doing(100001L, Constants.ActivityState.PASS)));
        logger.info("二次提审，测试：{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.EDIT)));
    }


    @Test
    public void test_award() {
        // 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));

        // 判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            logger.info("未中奖 DrawAwardInfo is null");
            return;
        }

        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getuId(), "2109313442431", drawAwardInfo.getAwardId(), drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        logger.info("测试结果：{}", JSON.toJSONString(distributionRes));
    }

    @Test
    public void test_drawExec() {
        drawExec.doDrawExec(new DrawReq("小傅哥", 10001L));
        drawExec.doDrawExec(new DrawReq("小佳佳", 10001L));
        drawExec.doDrawExec(new DrawReq("小蜗牛", 10001L));
        drawExec.doDrawExec(new DrawReq("八杯水", 10001L));
    }

    @Test
    public void test_insert() {
        Activity activity = new Activity();
        activity.setActivityId(100001L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("xiaofuge");
        activityDao.insert(activity);
    }

    @Test
    public void test_select() {
        Activity activity = activityDao.queryActivityById(100001L);
        logger.info("测试结果：{}", JSON.toJSONString(activity));
    }

}

