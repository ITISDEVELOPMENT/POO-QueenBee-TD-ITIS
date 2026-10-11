package queenbee.td2.s.apres;

public class Demo {

    public static void main(String[] args) {
        JournalAlertes journal = new JournalAlertes();
        ServiceAlertes service = new ServiceAlertes(new DetecteurEssaimage(2.5), new NotificateurSms(), journal);
        service.traiterPesee("R-01", 42.0, 39.0);
        service.traiterPesee("R-02", 45.2, 45.0);
        System.out.println("Journal : " + journal.lignes());
    }
}
