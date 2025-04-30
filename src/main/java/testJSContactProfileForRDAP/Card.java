package testJSContactProfileForRDAP;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "@type", "version", "language",
        "name", "organizations",
        "emails", "phones",
        "addresses",
        "localizations"
        })

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card extends LocalizableObject implements Serializable {

    private static ObjectMapper mapper = new ObjectMapper();

    @JsonProperty("@type")
    String _type = "Card";

    String version;

    String language;

    Map<String,Phone> phones;

    Map<String, LocalizableObject> localizations;

    public static Card toCard(String json) throws JsonProcessingException {

        return mapper.readValue(json, Card.class);

    }

    public String toJson() throws JsonProcessingException {

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);

    }

    @Override
    public Card clone() {
        try {
            return toCard(this.toJson());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @JsonIgnore
    public Card getLocalizedVersion(String language) {

        if (localizations == null)
            return null;

        LocalizableObject localizationsPerLanguage = localizations.get(language);

        if (localizationsPerLanguage == null)
            return null;

        Card localizedCard = this.clone();
        if (localizations.get(language).getName()!=null)
            localizedCard.setName(localizations.get(language).getName());
        if (localizations.get(language).getOrganizations()!=null)
            localizedCard.setOrganizations(localizations.get(language).getOrganizations());
        if (localizations.get(language).getAddresses()!=null)
            localizedCard.setAddresses(localizations.get(language).getAddresses());
        if (localizations.get(language).getEmails()!=null)
            localizedCard.setEmails(localizations.get(language).getEmails());

        localizedCard.setLanguage(language);
        localizedCard.setLocalizations(null);

        return localizedCard;
    }


}
