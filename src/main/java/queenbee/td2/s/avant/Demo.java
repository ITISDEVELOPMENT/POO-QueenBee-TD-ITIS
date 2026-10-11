package queenbee.td2.s.avant;

public class Demo {

    public static void main(String[] args) {
        GestionAlertes gestion = new GestionAlertes();
        gestion.traiterPesee("R-01", 42.0, 39.0);   // chute de 3 kg : alerte
        gestion.traiterPesee("R-02", 45.2, 45.0);   // chute de 0,2 kg : rien
        System.out.println("Journal : " + gestion.journal());
    }
}
