package com.hjp.lottery.domain.strategy.service.draw;

import com.hjp.lottery.domain.strategy.model.req.DrawReq;
import com.hjp.lottery.domain.strategy.model.res.DrawResult;

public interface IDrawExec {
    DrawResult doDrawExec(DrawReq req);
}
