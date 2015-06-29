package com.baidu.pikaq.core.test.db.commit.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baidu.pikaq.core.db.commit.AfterCommit;
import com.baidu.pikaq.core.db.commit.BeforeCommit;

@Service
public class UserCacheImpl implements UserCache {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserCacheImpl.class);

    @Override
    @AfterCommit
    public void add(User user) {
        LOGGER.info("Adding {} to cache", user);
    }

    @Override
    @BeforeCommit
    public void add2(User user) {
        LOGGER.info("Adding2 {} to cache", user);
    }
}
