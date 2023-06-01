package ru.itmo.razrab;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itmo.razrab.trash.Performer;
import ru.itmo.razrab.trash.Saxophone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;


public class SpringTest {
    private static ApplicationContext ctx;
    private static Logger logger = LoggerFactory.getLogger(SpringTest.class);

    @BeforeAll
    public static void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext("springConfig.xml");

    }
    @Test
    public void testSpring() throws Exception {
        if (ctx.containsBean("poeticDuke")) {
            Performer performerOne = ctx.getBean("poeticDuke", Performer.class);
            System.out.println("test permform = " + performerOne);
            performerOne.perform();
            Performer performerTwo = ctx.getBean("poeticDuke", Performer.class);            }
        Saxophone saxOne  = ctx.getBean("saxophone", Saxophone.class);
        Saxophone saxTwo  = ctx.getBean("saxophone", Saxophone.class);

        assertThat(saxOne,sameInstance(saxTwo));

        logger.debug("debugMy");
        logger.info("tst");
    }
}