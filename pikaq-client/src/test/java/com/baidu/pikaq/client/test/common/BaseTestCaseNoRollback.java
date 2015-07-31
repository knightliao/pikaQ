package com.baidu.pikaq.client.test.common;

import org.junit.Ignore;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

/**
 * 所有测试类的基类
 *
 * @author liaoqiqi
 * @version 2013-12-13
 */
@TestExecutionListeners(BaseTestBeforeClass.class)
@ContextConfiguration(locations = "classpath:**/applicationContextClient.xml")
@ActiveProfiles({"db-test"})
@Ignore
public abstract class BaseTestCaseNoRollback extends AbstractTestCase {

}
