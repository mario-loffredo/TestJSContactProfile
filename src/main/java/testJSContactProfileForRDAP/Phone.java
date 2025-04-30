package testJSContactProfileForRDAP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    String number;

    Map<String,Boolean> features;

}
