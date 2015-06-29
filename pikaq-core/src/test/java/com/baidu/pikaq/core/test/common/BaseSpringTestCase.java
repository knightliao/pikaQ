package com.baidu.pikaq.core.test.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class BaseSpringTestCase {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseSpringTestCase.class);

    @Test
    public void pass() {

    }

}
