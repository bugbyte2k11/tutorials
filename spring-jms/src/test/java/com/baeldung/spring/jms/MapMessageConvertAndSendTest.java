package com.baeldung.spring.jms;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MapMessageConvertAndSendTest {

    private static SampleJmsMessageSender messageProducer;

    @SuppressWarnings("resource")
    @BeforeClass
    public static void setUp() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
          "classpath:EmbeddedActiveMQ.xml", "classpath:applicationContext.xml");
        messageProducer = (SampleJmsMessageSender) applicationContext.getBean("SampleJmsMessageSender");
    }

    @Test
    public void testSendMessage() {
        messageProducer.sendMessage(new Employee("JavaDeveloper2", 22));
    }

}
