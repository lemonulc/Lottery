package com.hjp.lottery.rpc;

import com.hjp.lottery.rpc.req.ActivityReq;
import com.hjp.lottery.rpc.res.ActivityRes;

public interface IActivityBooth {
    ActivityRes queryActivityById(ActivityReq req);
}
