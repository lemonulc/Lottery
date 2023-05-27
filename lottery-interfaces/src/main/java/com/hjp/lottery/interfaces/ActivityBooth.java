package com.hjp.lottery.interfaces;

import com.hjp.lottery.common.Constants;
import com.hjp.lottery.common.Result;
import com.hjp.lottery.infrastructure.dao.IActivityDao;
import com.hjp.lottery.infrastructure.po.Activity;
import com.hjp.lottery.rpc.IActivityBooth;
import com.hjp.lottery.rpc.dto.ActivityDto;
import com.hjp.lottery.rpc.req.ActivityReq;
import com.hjp.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * 活动展台
 */
@DubboService
public class ActivityBooth implements IActivityBooth {
    @Resource
    IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }

}
