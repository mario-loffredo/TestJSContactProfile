package testJSContactProfileForRDAP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizableObject {

    Name name;

    Map<String, Organization> organizations;

    Map<String, Address> addresses;

}
