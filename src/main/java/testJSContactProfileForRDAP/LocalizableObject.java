package testJSContactProfileForRDAP;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class LocalizableObject {

    Name name;

    Map<String, Organization> organizations;

    Map<String, Address> addresses;
}
