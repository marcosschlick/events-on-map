package event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EventRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Event("12º ChoriCeva",
                    "Um festival gastronômico e cultural na fronteira Brasil-Uruguai que celebra os sabores locais com choripan, cervejas artesanais e música ao vivo.",
                    LocalDateTime.of(2025, 11, 15, 18, 0),
                    -30.896195327429446, -55.535213662812524)));
            log.info("Preloading " + repository.save(new Event("5º Oktoberfest da Marchi Pizzaria",
                    "Uma festa alemã de rua com música ao vivo, chopp gelado, gastronomia e Espaço Kids, em um evento sustentável onde você leva seu próprio copo.",
                    LocalDateTime.of(2025, 11, 1, 17, 0),
                    -30.887951229615123, -55.531081445818074)));
        };
    }
}