package com.baidu.pikaq.core.test.db.commit.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void persist(User user) {
        LOGGER.info("Persisting {}", user);

        if (user.getEmail() == null || user.getName() == null) {
            throw new IllegalArgumentException("User email and user name are required.");
        }
    }
}
