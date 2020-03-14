package com.truelayer.jonad.dhrami.services.impl;

import com.truelayer.jonad.dhrami.modules.Pokemon;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;

/**
 * Created by jonad dhrami on 14/03/2020.
 */

@SpringBootTest
class PokemonServiceImplTest {

    @MockBean
    private RestTemplate restTemplate;

    @InjectMocks
    PokemonServiceImpl pokemonService = new PokemonServiceImpl();

    @Test
    void getPokemonShakespeareanDescriptionByName() {

        Pokemon pokemon = new Pokemon("charizard",
                "Charizard flies around the sky in search of powerful opponents");

        Mockito.when(restTemplate.exchange(anyString(), any(), any(HttpEntity.class), eq(Pokemon.class)))
                .thenReturn(new ResponseEntity(String.class, HttpStatus.OK));

        Pokemon response = pokemonService.getPokemonShakespeareanDescriptionByName("charizard");

        Assert.assertEquals(pokemon.getName(),response.getName());

    }

    @Test
    public void getCategorisedTransactionsThrowExceptionInvalidInput() throws Exception {

        Mockito.when(restTemplate.exchange(anyString(), any(), any(HttpEntity.class),eq(Pokemon.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        Pokemon response = pokemonService.getPokemonShakespeareanDescriptionByName("dreamer");

        Assert.assertEquals(null,response);
    }

}