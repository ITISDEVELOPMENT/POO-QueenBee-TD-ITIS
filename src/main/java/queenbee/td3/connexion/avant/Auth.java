package queenbee.td3.connexion.avant;

import java.util.HashMap;
import java.util.Map;

public class Auth {

    // email -> mot de passe
    public Map<String, String> mdp = new HashMap<>();
    // email -> role (1 = apicultrice, 2 = coordinateur, 3 = gestionnaire, 4 = admin)
    public Map<String, Integer> r = new HashMap<>();
    // email -> nombre d'erreurs
    public Map<String, Integer> nb = new HashMap<>();

    public String log(String e, String p, String c) {
        if (mdp.containsKey(e)) {
            if (nb.getOrDefault(e, 0) < 5) {
                if (mdp.get(e).equals(p)) {
                    if (r.get(e) > 1) {
                        if (c != null && c.equals("123456")) {
                            nb.put(e, 0);
                            return "OK";
                        } else {
                            return "ERR2";
                        }
                    } else {
                        nb.put(e, 0);
                        return "OK";
                    }
                } else {
                    nb.put(e, nb.getOrDefault(e, 0) + 1);
                    return "ERR1";
                }
            } else {
                return "ERR3";
            }
        } else {
            return "ERR1";
        }
    }
}
