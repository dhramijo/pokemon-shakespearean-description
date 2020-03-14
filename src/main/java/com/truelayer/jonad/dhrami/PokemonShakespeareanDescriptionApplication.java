package com.truelayer.jonad.dhrami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jonad dhrami on 14/03/2020.
 */

@SpringBootApplication
public class PokemonShakespeareanDescriptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokemonShakespeareanDescriptionApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

}
