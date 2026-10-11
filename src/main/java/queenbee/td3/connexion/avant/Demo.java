package queenbee.td3.connexion.avant;

public class Demo {

    public static void main(String[] args) {
        Auth a = new Auth();
        a.mdp.put("awa@coop.sn", "Miel2027");
        a.r.put("awa@coop.sn", 1);
        a.mdp.put("kofi@beeafrica.org", "Ruche45");
        a.r.put("kofi@beeafrica.org", 2);

        System.out.println(a.log("awa@coop.sn", "Miel2027", null));
        System.out.println(a.log("kofi@beeafrica.org", "Ruche45", "000000"));
        for (int i = 0; i < 5; i++) {
            a.log("kofi@beeafrica.org", "mauvais", null);
        }
        System.out.println(a.log("kofi@beeafrica.org", "Ruche45", "123456"));
    }
}
