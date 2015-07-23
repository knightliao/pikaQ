package com.baidu.pikaq.client.test.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.baidu.pikaq.client.test.tests.simpletest.CreateTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.PikaQSendTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.UpdateTestCase;

@RunWith(Suite.class)
@SuiteClasses({CreateTestCase.class, PikaQSendTestCase.class, UpdateTestCase.class})
public class AllTestSuite {

}
