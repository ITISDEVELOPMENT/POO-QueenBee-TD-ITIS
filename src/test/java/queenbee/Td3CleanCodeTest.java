package queenbee;

import org.junit.jupiter.api.Test;
import queenbee.td3.connexion.apres.Role;
import queenbee.td3.connexion.apres.ServiceConnexion;
import queenbee.td3.exercice.CorrectionDeclaration;
import queenbee.td3.exercice.ExerciceDeclaration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** TD3 : le code nettoyé donne exactement les mêmes réponses que le code de départ. */
class Td3CleanCodeTest {

    @Test
    void validation_de_recolte_identique() {
        var avant = new queenbee.td3.recolte.avant.Rec();
        var apres = new queenbee.td3.recolte.apres.ValidationRecolte();
        double[][] cas = {{18, 20}, {25, 20}, {23, 20}, {17, 20}, {9, 12}};
        for (double[] c : cas) {
            assertEquals(avant.calc("R", c[0], c[1]), apres.verifier("R", c[0], c[1]));
        }
    }

    @Test
    void connexion_memes_regles_avant_et_apres() {
        var avant = new queenbee.td3.connexion.avant.Auth();
        avant.mdp.put("awa", "Miel2027");
        avant.r.put("awa", 1);
        avant.mdp.put("kofi", "Ruche45");
        avant.r.put("kofi", 2);
        var apres = new ServiceConnexion();
        apres.creerCompte("awa", "Miel2027", Role.APICULTRICE);
        apres.creerCompte("kofi", "Ruche45", Role.COORDINATEUR);

        assertEquals("OK", avant.log("awa", "Miel2027", null));
        assertEquals("REUSSIE", apres.seConnecter("awa", "Miel2027", null).name());
        assertEquals("ERR2", avant.log("kofi", "Ruche45", "000000"));
        assertEquals("CODE_DE_VERIFICATION_INVALIDE", apres.seConnecter("kofi", "Ruche45", "000000").name());
        assertEquals("ERR1", avant.log("inconnu", "x", null));
        assertEquals("IDENTIFIANTS_INCORRECTS", apres.seConnecter("inconnu", "x", null).name());

        for (int i = 0; i < 5; i++) {
            avant.log("kofi", "mauvais", null);
            apres.seConnecter("kofi", "mauvais", null);
        }
        assertEquals("ERR3", avant.log("kofi", "Ruche45", "123456"));
        assertEquals("COMPTE_BLOQUE", apres.seConnecter("kofi", "Ruche45", "123456").name());
    }

    @Test
    void exercice_declaration_identique() {
        ExerciceDeclaration avant = new ExerciceDeclaration();
        CorrectionDeclaration apres = new CorrectionDeclaration();
        double[] volumes = {-1, 0, 0.5, 18, 60, 60.1, 200};
        String[] dates = {null, "", "2027-02-10"};
        for (double volume : volumes) {
            for (String date : dates) {
                assertEquals(avant.ok(volume, date), apres.declarationAcceptable(volume, date));
            }
        }
    }
}
