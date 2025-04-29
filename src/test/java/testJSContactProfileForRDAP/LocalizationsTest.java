package testJSContactProfileForRDAP;

import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LocalizationsTest {

    @Test
    public void testLocalizations() throws IOException {

        String json = "{" +
                "\"name\": {\"full\":\"Vasya Pupkin\"}," +
                "\"language\": \"en\"," +
                "\"organizations\": { \"org\": {\"name\": \"My Company\" } }, " +
                "\"addresses\":{" +
                    "\"addr\": {" +
                        "\"components\": [" +
                            "{\"kind\": \"name\", \"value\": \"1 Street\"}," +
                            "{\"kind\": \"postOfficeBox\", \"value\":\"01001\"}," +
                            "{\"kind\": \"locality\", \"value\": \"Kyiv\"}" +
                        "]," +
                        "\"countryCode\":\"UA\"" +
                    "}" +
                "}," +
                "\"localizations\":{" +
                    "\"ua\": {" +
                        "\"name\": {\"full\":\"VВася Пупкин\"}," +
                        "\"organizations\": {" +
                               "\"org\": {\"name\": \"Моя Компания\" } " +
                        "}," +
                        "\"addresses\":{" +
                            "\"addr\":{" +
                                "\"components\": [" +
                                    "{\"kind\": \"name\",\"value\": \"1, Улица\"}," +
                                    "{\"kind\": \"postOfficeBox\",\"value\":\"01001\"}," +
                                    "{\"kind\": \"locality\",\"value\":\"Киев\"}" +
                                "], " +
                                "\"countryCode\":\"UA\"" +
                            "}" +
                        "}" +
                    "}" +
                "}" +
                "}";


        Card jsCard = Card.toCard(json);
        assertEquals("testLocalizations - 1", jsCard.getName().getFull(), "Vasya Pupkin");
        assertEquals("testLocalizations - 2", jsCard.getOrganizations().get("org").getName(),"My Company");
        assertFalse("testLocalizations - 3", jsCard.getAddresses().isEmpty());
        assertEquals("testLocalizations - 4", jsCard.getAddresses().get("addr").getComponents().length, 3);
        assertEquals("testLocalizations - 5", jsCard.getAddresses().get("addr").getComponents()[0].getKind(), "name");
        assertEquals("testLocalizations - 6", jsCard.getAddresses().get("addr").getComponents()[0].getValue(), "1 Street");
        assertEquals("testLocalizations - 7", jsCard.getAddresses().get("addr").getComponents()[1].getKind(), "postOfficeBox");
        assertEquals("testLocalizations - 8", jsCard.getAddresses().get("addr").getComponents()[1].getValue(), "01001");
        assertEquals("testLocalizations - 9", jsCard.getAddresses().get("addr").getComponents()[2].getKind(), "locality");
        assertEquals("testLocalizations - 10", jsCard.getAddresses().get("addr").getComponents()[2].getValue(), "Kyiv");
        assertEquals("testLocalizations - 11", jsCard.getAddresses().get("addr").getCountryCode(), "UA");
        assertEquals("testLocalizations - 12", jsCard.getLanguage(), "en");

        assertEquals("testLocalizations - 1.ua", jsCard.getLocalizations().get("ua").getName().getFull(), "VВася Пупкин");
        assertEquals("testLocalizations - 2.ua", jsCard.getLocalizations().get("ua").getOrganizations().get("org").getName(), "Моя Компания");
        assertFalse("testLocalizations - 3.ua", jsCard.getLocalizations().get("ua").getAddresses().isEmpty());
        assertEquals("testLocalizations - 4.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents().length, 3);
        assertEquals("testLocalizations - 5.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[0].getKind(), "name");
        assertEquals("testLocalizations - 6.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[0].getValue(), "1, Улица");
        assertEquals("testLocalizations - 7.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[1].getKind(), "postOfficeBox");
        assertEquals("testLocalizations - 8.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[1].getValue(), "01001");
        assertEquals("testLocalizations - 9.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[2].getKind(), "locality");
        assertEquals("testLocalizations - 10.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[2].getValue(), "Киев");
        assertEquals("testLocalizations - 11.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getCountryCode(), "UA");

    }

}