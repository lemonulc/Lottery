package com.hjp.lottery.domain.award.service.factory;

import com.hjp.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author：hjp
 * @date: 2023-05-30
 * @Copyright： hjp
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {
    public IDistributionGoods getDistributionGoodsService(Integer awardType) {
        return goodsMap.get(awardType);
    }
}
