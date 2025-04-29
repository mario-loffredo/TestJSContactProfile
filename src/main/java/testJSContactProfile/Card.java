package testJSContactProfile;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Card extends LocalizableObject implements Serializable {

    private static ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("@type")
    @Builder.Default
    String _type = "Card";

    String version;

    String language;

    Map<String, LocalizableObject> localizations;

    public static Card toCard(String json) throws JsonProcessingException {

        return mapper.readValue(json, Card.class);

    }

}
