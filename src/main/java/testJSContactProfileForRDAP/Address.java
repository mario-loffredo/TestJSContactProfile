package testJSContactProfileForRDAP;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    AddressComponent[] components;

    String full;

    String countryCode;
}
