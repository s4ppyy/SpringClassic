package ru.itmo.razrab.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
@PropertySource("classpath:properties-config.prop")
public class DaoConfig {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean(name="DaoConfig.dataSource")
    public DriverManagerDataSource dataSource() {
        System.out.println(username);
        DriverManagerDataSource drvDs=new DriverManagerDataSource(url,username,password);
       // drvDs.setDriverClassName("org.postgresql.Driver");
        return drvDs;
    }
}