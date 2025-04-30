package testJSContactProfileForRDAP;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Name {

    NameComponent[] components;

    String full;

}
