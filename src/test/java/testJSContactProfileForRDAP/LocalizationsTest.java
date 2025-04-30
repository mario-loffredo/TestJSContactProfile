package testJSContactProfileForRDAP;

import org.junit.Test;
import java.io.IOException;

import static org.junit.Assert.*;

public class LocalizationsTest {

    @Test
    public void testLocalizations() throws IOException {

        String json = "{" +
                "\"@type\": \"Card\"," +
                "\"version\": \"2.0\"," +
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
                "\"phones\": {" +
                    "\"voice\": {" +
                        "\"features\": { \"voice\": true }, " +
                        "\"number\": \"tel:+380-1522-3433333\" " +
                    "}," +
                    "\"fax\": { " +
                        "\"features\": { \"fax\": true }, " +
                        "\"number\": \"tel:+380-30-901820\" " +
                    "}" +
                "}," +
                "\"emails\": { " +
                    "\"email\": { " +
                        "\"address\": \"info@mycompany.com\"" +
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
        assertEquals("testLocalizations - 4", jsCard.getAddresses().size(), 1);
        assertEquals("testLocalizations - 5", jsCard.getAddresses().get("addr").getComponents().length, 3);
        assertEquals("testLocalizations - 6", jsCard.getAddresses().get("addr").getComponents()[0].getKind(), "name");
        assertEquals("testLocalizations - 7", jsCard.getAddresses().get("addr").getComponents()[0].getValue(), "1 Street");
        assertEquals("testLocalizations - 8", jsCard.getAddresses().get("addr").getComponents()[1].getKind(), "postOfficeBox");
        assertEquals("testLocalizations - 9", jsCard.getAddresses().get("addr").getComponents()[1].getValue(), "01001");
        assertEquals("testLocalizations - 10", jsCard.getAddresses().get("addr").getComponents()[2].getKind(), "locality");
        assertEquals("testLocalizations - 11", jsCard.getAddresses().get("addr").getComponents()[2].getValue(), "Kyiv");
        assertEquals("testLocalizations - 12", jsCard.getAddresses().get("addr").getCountryCode(), "UA");
        assertEquals("testLocalizations - 13", jsCard.getLanguage(), "en");
        assertFalse("testLocalizations - 14", jsCard.getPhones().isEmpty());
        assertEquals("testLocalizations - 15", jsCard.getPhones().size(), 2);
        assertEquals("testLocalizations - 16", jsCard.getPhones().get("voice").getNumber(), "tel:+380-1522-3433333");
        assertFalse("testLocalizations - 17", jsCard.getPhones().get("voice").getFeatures().isEmpty());
        assertEquals("testLocalizations - 18", jsCard.getPhones().get("voice").getFeatures().size(), 1);
        assertTrue("testLocalizations - 19", jsCard.getPhones().get("voice").getFeatures().get("voice"));
        assertEquals("testLocalizations - 20", jsCard.getPhones().get("fax").getNumber(), "tel:+380-30-901820");
        assertFalse("testLocalizations - 21", jsCard.getPhones().get("fax").getFeatures().isEmpty());
        assertEquals("testLocalizations - 22", jsCard.getPhones().get("fax").getFeatures().size(), 1);
        assertTrue("testLocalizations - 23", jsCard.getPhones().get("fax").getFeatures().get("fax"));
        assertFalse("testLocalizations - 24", jsCard.getEmails().isEmpty());
        assertEquals("testLocalizations - 25", jsCard.getEmails().size(), 1);
        assertEquals("testLocalizations - 26", jsCard.getEmails().get("email").getAddress(), "info@mycompany.com");

        assertEquals("testLocalizations - 1.ua", jsCard.getLocalizations().get("ua").getName().getFull(), "VВася Пупкин");
        assertEquals("testLocalizations - 2.ua", jsCard.getLocalizations().get("ua").getOrganizations().get("org").getName(), "Моя Компания");
        assertFalse("testLocalizations - 3.ua", jsCard.getLocalizations().get("ua").getAddresses().isEmpty());
        assertEquals("testLocalizations - 4.ua", jsCard.getLocalizations().get("ua").getAddresses().size(), 1);
        assertEquals("testLocalizations - 5.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents().length, 3);
        assertEquals("testLocalizations - 6.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[0].getKind(), "name");
        assertEquals("testLocalizations - 7.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[0].getValue(), "1, Улица");
        assertEquals("testLocalizations - 8.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[1].getKind(), "postOfficeBox");
        assertEquals("testLocalizations - 9.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[1].getValue(), "01001");
        assertEquals("testLocalizations - 10.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[2].getKind(), "locality");
        assertEquals("testLocalizations - 11.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getComponents()[2].getValue(), "Киев");
        assertEquals("testLocalizations - 12.ua", jsCard.getLocalizations().get("ua").getAddresses().get("addr").getCountryCode(), "UA");

    }

    @Test
    public void testLocalizeCard() throws IOException {

        String json = "{" +
                "\"@type\": \"Card\"," +
                "\"version\": \"2.0\"," +
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
                "\"phones\": {" +
                    "\"voice\": {" +
                        "\"features\": { \"voice\": true }, " +
                        "\"number\": \"tel:+380-1522-3433333\" " +
                    "}," +
                    "\"fax\": { " +
                        "\"features\": { \"fax\": true }, " +
                        "\"number\": \"tel:+380-30-901820\" " +
                    "}" +
                "}," +
                "\"emails\": { " +
                    "\"email\": { " +
                        "\"address\": \"info@mycompany.com\"" +
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


        Card jsMainCard = Card.toCard(json);
        Card jsCard = jsMainCard.getLocalizedVersion("ua");
        //To print the localized card on stdout uncomment the following line
        //System.out.println(jsCard.toJson());
        assertEquals("testLocalizedCard - 1.ua", jsCard.getName().getFull(), "VВася Пупкин");
        assertEquals("testLocalizedCard - 2.ua", jsCard.getOrganizations().get("org").getName(), "Моя Компания");
        assertFalse("testLocalizedCard - 3.ua", jsCard.getAddresses().isEmpty());
        assertEquals("testLocalizedCard - 4.ua", jsCard.getAddresses().size(), 1);
        assertEquals("testLocalizedCard - 5.ua", jsCard.getAddresses().get("addr").getComponents().length, 3);
        assertEquals("testLocalizedCard - 6.ua", jsCard.getAddresses().get("addr").getComponents()[0].getKind(), "name");
        assertEquals("testLocalizedCard - 7.ua", jsCard.getAddresses().get("addr").getComponents()[0].getValue(), "1, Улица");
        assertEquals("testLocalizedCard - 8.ua", jsCard.getAddresses().get("addr").getComponents()[1].getKind(), "postOfficeBox");
        assertEquals("testLocalizedCard - 9.ua", jsCard.getAddresses().get("addr").getComponents()[1].getValue(), "01001");
        assertEquals("testLocalizedCard - 10.ua", jsCard.getAddresses().get("addr").getComponents()[2].getKind(), "locality");
        assertEquals("testLocalizedCard - 11.ua", jsCard.getAddresses().get("addr").getComponents()[2].getValue(), "Киев");
        assertEquals("testLocalizedCard - 12.ua", jsCard.getAddresses().get("addr").getCountryCode(), "UA");
        assertEquals("testLocalizedCard - 13", jsCard.getLanguage(), "ua");
        assertFalse("testLocalizedCard - 14", jsCard.getPhones().isEmpty());
        assertEquals("testLocalizedCard - 15", jsCard.getPhones().size(), 2);
        assertEquals("testLocalizedCard - 16", jsCard.getPhones().get("voice").getNumber(), "tel:+380-1522-3433333");
        assertFalse("testLocalizedCard - 17", jsCard.getPhones().get("voice").getFeatures().isEmpty());
        assertEquals("testLocalizedCard - 18", jsCard.getPhones().get("voice").getFeatures().size(), 1);
        assertTrue("testLocalizedCard - 19", jsCard.getPhones().get("voice").getFeatures().get("voice"));
        assertEquals("testLocalizedCard - 20", jsCard.getPhones().get("fax").getNumber(), "tel:+380-30-901820");
        assertFalse("testLocalizedCard - 21", jsCard.getPhones().get("fax").getFeatures().isEmpty());
        assertEquals("testLocalizedCard - 22", jsCard.getPhones().get("fax").getFeatures().size(), 1);
        assertTrue("testLocalizedCard - 23", jsCard.getPhones().get("fax").getFeatures().get("fax"));
        assertFalse("testLocalizedCard - 24", jsCard.getEmails().isEmpty());
        assertEquals("testLocalizedCard - 25", jsCard.getEmails().size(), 1);
        assertEquals("testLocalizedCard - 26", jsCard.getEmails().get("email").getAddress(), "info@mycompany.com");
        assertNull("testLocalizedCard - 27", jsCard.getLocalizations());
    }

}