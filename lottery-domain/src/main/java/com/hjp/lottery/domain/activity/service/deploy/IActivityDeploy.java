package com.hjp.lottery.domain.activity.service.deploy;

import com.hjp.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @description:
 * @author：hjp
 * @date: 2023-05-30
 * @Copyright： hjp
 */
public interface IActivityDeploy {
    /**
     * 创建活动信息
     *
     * @param req 活动配置信息
     */
    void createActivity(ActivityConfigReq req);

    /**
     * 修改活动信息
     *
     * @param req 活动配置信息
     */
    void updateActivity(ActivityConfigReq req);
}
