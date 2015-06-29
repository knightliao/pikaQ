package com.baidu.pikaq.core.test.db.commit.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.pikaq.core.db.commit.CommitExecutorFactory;
import com.baidu.pikaq.core.db.commit.executor.CommitExecutor;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserCache userCache;

    @Autowired
    private EmailSender emailSender;

    private CommitExecutor afterCommitExecutor = CommitExecutorFactory.getAfterCommitDefaultImpl();

    @Override
    @Transactional
    public User createUser(final String email, final String name) {

        LOGGER.info("Creating new user with email={} and name={}", email, name);

        User user = new User(email, name);

        // user will be added to cache after commit, annotation way
        userCache.add(user);

        User user2 = new User(email + "2", name + "2");

        // user will be added to cache before commit, annotation way
        userCache.add2(user2);

        // email will be sent after commit, programmatic way
        afterCommitExecutor.execute(new Runnable() {
            @Override
            public void run() {
                emailSender.sendEmail(email, "Welcome", "Welcome aboard dear " + name);
            }
        });

        userDao.persist(user);

        return user;
    }

}
