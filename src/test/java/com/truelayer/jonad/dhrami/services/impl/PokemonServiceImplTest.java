package com.truelayer.jonad.dhrami.services.impl;

import com.truelayer.jonad.dhrami.modules.Pokemon;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;

/**
 * Created by jonad dhrami on 14/03/2020.
 */

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PokemonServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    PokemonServiceImpl pokemonService;

    @Test
    void test_ShouldReturnPokemonShakespeareanDescriptionByName() {

        Pokemon pokemon = new Pokemon("charizard",
                "charizard flies 'round the sky in search of powerful opponents. " +
                        "'t breathes fire of such most wondrous heat yond 't melts aught. However, " +
                        "'t nev'r turns its fiery breath on any opponent weaker than itself.");

        when(restTemplate.exchange(anyString(), any(), any(HttpEntity.class), eq(String.class)))
                .thenReturn(new ResponseEntity(String.class, HttpStatus.OK));

        Pokemon response = pokemonService.getPokemonShakespeareanDescriptionByName("charizard");

        Assert.assertEquals(pokemon.getDescription(),response.getDescription());

    }

    @Test
    public void test_shouldNotReturnPokemonShakespeareanDescriptionForInvalidPokemonName() throws Exception {

        when(restTemplate.exchange(anyString(), any(), any(HttpEntity.class),eq(Pokemon.class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        Pokemon response = pokemonService.getPokemonShakespeareanDescriptionByName("dreamer");

        Assert.assertEquals(null,response);
    }

}