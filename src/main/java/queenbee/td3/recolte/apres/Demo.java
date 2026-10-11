package queenbee.td3.recolte.apres;

public class Demo {

    public static void main(String[] args) {
        ValidationRecolte validation = new ValidationRecolte();
        System.out.println(validation.verifier("R-01", 18.0, 20.0));
        System.out.println(validation.verifier("R-02", 25.0, 20.0));
    }
}
