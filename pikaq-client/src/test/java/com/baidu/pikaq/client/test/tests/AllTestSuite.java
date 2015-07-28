package com.baidu.pikaq.client.test.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.baidu.pikaq.client.test.tests.simpletest.PIkaQUpdateTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.PikaQCreateTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.PikaQSendTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.error.PikaQCreateLocalErrorTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.error.PikaQCreateQErrorTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.error.RabbitQCreateLocalErrorTestCase;
import com.baidu.pikaq.client.test.tests.simpletest.error.RabbitQCreateQErrorTestCase;

@RunWith(Suite.class)
@SuiteClasses({PikaQCreateTestCase.class, PikaQSendTestCase.class, PIkaQUpdateTestCase.class,
                  PikaQCreateLocalErrorTestCase.class, RabbitQCreateLocalErrorTestCase.class,
                  PikaQCreateQErrorTestCase.class, RabbitQCreateQErrorTestCase.class})
public class AllTestSuite {

}
