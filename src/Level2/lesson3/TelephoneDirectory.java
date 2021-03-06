package Level2.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {

    private HashMap<String, ArrayList<String>> telephoneDirectory= new HashMap<>();

    public void add(String surname, String telephone){
        if (this.telephoneDirectory.containsKey(surname)){
            this.telephoneDirectory.get(surname).add(telephone);
        } else {
            this.telephoneDirectory.put(surname, new ArrayList<>(Collections.singletonList(telephone)));
        }
    }

    public ArrayList<String> get(String surname){
        return telephoneDirectory.getOrDefault(surname, new ArrayList<>());
    }
}
