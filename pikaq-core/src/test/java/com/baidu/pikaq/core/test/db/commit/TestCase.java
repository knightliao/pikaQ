package com.baidu.pikaq.core.test.db.commit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.pikaq.core.test.common.BaseSpringTestCase;
import com.baidu.pikaq.core.test.db.commit.model.UserService;

public class TestCase extends BaseSpringTestCase {

    protected static final Logger LOGGER = LoggerFactory.getLogger(TestCase.class);

    @Autowired
    private UserService userService;

    @BeforeClass
    public static void beforeClass() throws ClassNotFoundException {
        Class.forName("org.hsqldb.jdbcDriver");
    }

    @Test
    public void createUser() {
        userService.createUser("test_email", "test_name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createUserFailure() {
        userService.createUser(null, "test_name");
    }
}
