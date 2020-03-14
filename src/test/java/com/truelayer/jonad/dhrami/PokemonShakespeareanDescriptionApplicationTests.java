package com.truelayer.jonad.dhrami;

import static org.junit.Assert.assertNotNull;

import com.truelayer.jonad.dhrami.controllers.PokemonController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PokemonShakespeareanDescriptionApplicationTests {

    @Autowired
    PokemonController pokemonController;

    @Test
    void contextLoads() {
        assertNotNull(pokemonController);
    }

}
