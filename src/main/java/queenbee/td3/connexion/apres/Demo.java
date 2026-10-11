package queenbee.td3.connexion.apres;

public class Demo {

    public static void main(String[] args) {
        ServiceConnexion service = new ServiceConnexion();
        service.creerCompte("awa@coop.sn", "Miel2027", Role.APICULTRICE);
        service.creerCompte("kofi@beeafrica.org", "Ruche45", Role.COORDINATEUR);

        System.out.println(service.seConnecter("awa@coop.sn", "Miel2027", null));
        System.out.println(service.seConnecter("kofi@beeafrica.org", "Ruche45", "000000"));
        for (int tentative = 0; tentative < ServiceConnexion.TENTATIVES_AVANT_BLOCAGE; tentative++) {
            service.seConnecter("kofi@beeafrica.org", "mauvais", null);
        }
        System.out.println(service.seConnecter("kofi@beeafrica.org", "Ruche45", "123456"));
    }
}
