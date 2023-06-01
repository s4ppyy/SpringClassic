package jdbc.template;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class JdbcTemplateSpringMain {
    public static void main(String[] args) {
        String[] arrFor = {"springConfigJdbcTemplate.xml"};
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(arrFor);

        JdbcTemplate template = context.getBean("bisJdbcTemplate", JdbcTemplate.class);
        System.out.println(template.queryForObject("select 1 from dual",Integer.class));
    }
}
