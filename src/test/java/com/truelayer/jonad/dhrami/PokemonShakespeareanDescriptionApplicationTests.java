package com.truelayer.jonad.dhrami;

import com.truelayer.jonad.dhrami.controllers.PokemonController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PokemonShakespeareanDescriptionApplicationTests {

    @Autowired
    PokemonController pokemonController;

    @Test
    void contextLoads() {
        assertNotNull(pokemonController);
    }

}
