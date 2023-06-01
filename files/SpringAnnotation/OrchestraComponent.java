package ru.itmo.razrab.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.itmo.razrab.trash.Juggler;

@Component
public class OrchestraComponent {
    @Bean(name="comp.juggler")
    public Juggler firstJuggler() {
        return new Juggler();
    }


}
