package com.hjp.lottery.domain.support.ids.policy;

import com.hjp.lottery.domain.support.ids.IIdGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author：hjp
 * @date: 2023-05-31
 * @Copyright： hjp
 */
@Component
public class RandomNumeric implements IIdGenerator {
    @Override
    public long nextId() {
        return Long.parseLong(RandomStringUtils.randomNumeric(11));
    }
}
