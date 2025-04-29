package testJSContactProfile;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressComponent {

    String kind;

    String value;
}
