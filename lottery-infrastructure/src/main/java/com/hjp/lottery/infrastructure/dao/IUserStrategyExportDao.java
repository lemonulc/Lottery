package com.hjp.lottery.infrastructure.dao;

import com.hjp.lottery.infrastructure.po.UserStrategyExport;
import com.hjp.middleware.db.router.annotation.DBRouter;
import com.hjp.middleware.db.router.annotation.DBRouterStrategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：hjp
 * @date: 2023-05-31
 * @Copyright： hjp
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {
    /**
     * 新增数据
     * @param userStrategyExport 用户策略
     */
    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    /**
     * 查询数据
     * @param uId 用户ID
     * @return 用户策略
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}
