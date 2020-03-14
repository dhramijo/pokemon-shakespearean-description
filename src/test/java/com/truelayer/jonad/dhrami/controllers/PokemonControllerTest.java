package com.truelayer.jonad.dhrami.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by jonad dhrami on 14/03/2020.
 */

@SpringBootTest
@AutoConfigureMockMvc
public class PokemonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_shouldReturnPokemonShakespeareanDescriptionByName() throws Exception {
        String pokemonDescription = "";
        mockMvc.perform(get("/pokemon/charizard"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name" , is("charizard")));
                //.andExpect(jsonPath("$.description" , is(pokemonDescription)));
    }

    @Test
    public void test_shouldNotReturnPokemonShakespeareanDescriptionForInvalidPokemonName() throws Exception {
        mockMvc.perform(get("/pokemon/chari"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}