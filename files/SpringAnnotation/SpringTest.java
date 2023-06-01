package ru.itmo.razrab;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itmo.razrab.trash.Juggler;


public class SpringTest {
    private static ApplicationContext ctx;

    private static Logger logger = LoggerFactory.getLogger(SpringTest.class);

    private Juggler jFirst;

    @BeforeAll
    public static void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext("ru.itmo.razrab.conf");
        /*
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("ru.itmo.razrab.conf");
        ctx.refresh();
         */
    }
    @Test
    public void testSpring() throws Exception {
        Juggler firstJuggler=ctx.getBean("conf.juggler", Juggler.class);
        firstJuggler.perform();
        Juggler secondJuggler=ctx.getBean("comp.juggler", Juggler.class);
        firstJuggler.perform();

        DriverManagerDataSource dataSource= (DriverManagerDataSource) ctx.getBean("DaoConfig.dataSource");
        dataSource.getConnection();
    }
}