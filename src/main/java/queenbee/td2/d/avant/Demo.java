package queenbee.td2.d.avant;

public class Demo {

    public static void main(String[] args) {
        ServiceInspection service = new ServiceInspection();
        service.enregistrer(new Inspection("R-01", "Reine presente, colonie calme"));
        System.out.println("L'inspection a-t-elle ete envoyee ? Impossible de simuler le retour du reseau.");
    }
}
