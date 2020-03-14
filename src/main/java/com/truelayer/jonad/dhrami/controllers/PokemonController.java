package com.truelayer.jonad.dhrami.controllers;

import com.truelayer.jonad.dhrami.modules.Pokemon;
import com.truelayer.jonad.dhrami.services.PokemonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonad dhrami on 14/03/2020.
 */

@RestController
@EnableAutoConfiguration
@Api(value="Retrieve Pokemon Shakespearean Description", description="Operations for getting shakespearean description for given Pokemon name")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    @GetMapping("pokemon/{name}")
    @ResponseBody
    @ApiOperation(value = "Retrieve Shakespearean Description for a given pokemon name", response = Pokemon.class)
    ResponseEntity<?> getPokemonByName(@PathVariable("name") String pokemonName) {

        Pokemon pokemon = pokemonService.getPokemonShakespeareanDescriptionByName(pokemonName);

        if (pokemon == null ){
            return new ResponseEntity<>("Pokemon " + pokemonName + " doesn't contain a description", null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pokemon, null, HttpStatus.OK);

    }


}
