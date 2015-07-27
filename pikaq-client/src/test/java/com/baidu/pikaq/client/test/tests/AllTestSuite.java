package com.baidu.pikaq.client.test.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.baidu.pikaq.client.test.tests.simpletest.PIkaQUpdateTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.PikaQCreateTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.PikaQSendTestCase;

@RunWith(Suite.class)
@SuiteClasses({PikaQCreateTestCase.class, PikaQSendTestCase.class, PIkaQUpdateTestCase.class})
public class AllTestSuite {

}
