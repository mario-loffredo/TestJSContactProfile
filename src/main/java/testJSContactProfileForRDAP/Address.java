package testJSContactProfileForRDAP;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    AddressComponent[] components;

    String full;

    String countryCode;
}
