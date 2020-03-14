package com.truelayer.jonad.dhrami.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truelayer.jonad.dhrami.modules.Pokemon;
import com.truelayer.jonad.dhrami.services.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by jonad dhrami on 14/03/2020.
 */
@Component
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${pokemon.api.url}")
    private String pokemonAPIUrl;

    @Value("${shakespeare.api.url}")
    private String shakespeareAPIUrl;

    @Value("${pokemon.api.description}")
    private String pokemonAPIDescription;

    private static final Logger log = LoggerFactory.getLogger(PokemonServiceImpl.class);

    /**
     * generate rest request to PokemonAPI
     * @return Pokemon with Shakespearean Description
     */
    @Override
    public Pokemon getPokemonShakespeareanDescriptionByName(String pokemonName) {

        HttpHeaders headers = getHttpHeaders();

        try{
            log.info("Request is sending to PokemonAPI endpoint resource");
            ResponseEntity<String> response = restTemplate.exchange(pokemonAPIUrl + pokemonName, HttpMethod.GET, new HttpEntity<>(null, headers), String.class);

            // Parse JSON response from PokemonAPI to get Pokemon's description
            String pokemonDescription = pokemonAPIJsonParsing(response);

            // Send request to Shakespeare Translation API to get Pokemon's Shakespeare Translation
            String pokemonDescriptionTranslated = getShakespeareTranslation(pokemonDescription);

            return new Pokemon(pokemonName,pokemonDescriptionTranslated.replaceAll("[\\\\|\"]",""));

        }catch (Exception exc){
            log.info("Selected pokemon name: " + pokemonName + ", doesn't contain data");
        }

        return null;
    }

    /**
     * Send request to Shakespeare Translation API endpoint
     * @return Pokemon description translated in Shakespearean
     */
    public String getShakespeareTranslation(String description) {

        HttpHeaders headers = getHttpHeaders();
        ObjectMapper mapper = new ObjectMapper();

        try{
            log.info("request sent to Shakespeare translator API endpoint resource");
            ResponseEntity<String> response = restTemplate.exchange(shakespeareAPIUrl + description, HttpMethod.POST, new HttpEntity<>(description, headers), String.class);

            JsonNode rootNode = mapper.readTree(Objects.requireNonNull(response.getBody()));
            JsonNode locatedNode = rootNode.at("/contents/translated");

            String shakespeareanDescription = locatedNode.toString();

            return shakespeareanDescription;

        } catch (JsonProcessingException e) {
            log.debug("Error while translating pokemon's description");
        }

        return null;
    }

    /**
     * parse JSON response from PokemonAPI endpoint
     * @return Pokemon description
     */
    private String pokemonAPIJsonParsing(ResponseEntity<String> result) {

        log.info("Started Json parsing of PokemonAPI response");

        String pokemonDescription = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(result.getBody());
            JsonNode locatedNode = rootNode.findValue(pokemonAPIDescription);

            Iterator<JsonNode> elements = locatedNode.elements();
            while (elements.hasNext()) {
                JsonNode items = elements.next();
                // Take the first pokemon description in english
                if (items.at("/language/name").asText().equals("en")) {
                    pokemonDescription = items.get("flavor_text").toString().replaceAll("\\\\n"," ");
                    break;
                }

            }
        } catch (JsonProcessingException e) {
            log.info("Error while parsing PokemonAPI JSON response");
        }

        log.info("Parsing Finished Correctly!");
        return pokemonDescription;
    }

    /**
     * generate http headers for rest request
     * @return http header generated
     */
    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        return headers;
    }

}
