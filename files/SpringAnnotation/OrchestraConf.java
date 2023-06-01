package ru.itmo.razrab.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itmo.razrab.trash.Juggler;

@Configuration
public class OrchestraConf {
    @Bean(name="conf.juggler")
    public Juggler firstJuggler()
    {
        return new Juggler();
    }
}
