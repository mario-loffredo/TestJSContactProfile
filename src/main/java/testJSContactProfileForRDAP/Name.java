package testJSContactProfileForRDAP;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Name {

    NameComponent[] components;

    String full;

}
