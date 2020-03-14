package com.truelayer.jonad.dhrami.modules;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by jonad dhrami on 14/03/2020.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Data
public class Pokemon {

    private String name;
    private String description;

}
