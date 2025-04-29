package testJSContactProfile;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    AddressComponent[] components;

    String full;

    String countryCode;
}
