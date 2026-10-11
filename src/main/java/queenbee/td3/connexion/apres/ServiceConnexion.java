package queenbee.td3.connexion.apres;

import java.util.HashMap;
import java.util.Map;

/**
 * UC-T01 « Authentification » : double authentification pour coordinateurs, gestionnaires
 * et administrateurs ; compte bloqué après 5 tentatives.
 */
public class ServiceConnexion {

    public static final int TENTATIVES_AVANT_BLOCAGE = 5;
    public static final String CODE_DE_VERIFICATION_ATTENDU = "123456";   // simulation du code reçu par SMS

    private final Map<String, Compte> comptesParEmail = new HashMap<>();

    public void creerCompte(String email, String motDePasse, Role role) {
        comptesParEmail.put(email, new Compte(motDePasse, role));
    }

    public ResultatConnexion seConnecter(String email, String motDePasse, String codeDeVerification) {
        Compte compte = comptesParEmail.get(email);

        if (compte == null) {
            return ResultatConnexion.IDENTIFIANTS_INCORRECTS;
        }
        if (estBloque(compte)) {
            return ResultatConnexion.COMPTE_BLOQUE;
        }
        if (!compte.motDePasseCorrect(motDePasse)) {
            compte.ajouterEchec();
            return ResultatConnexion.IDENTIFIANTS_INCORRECTS;
        }
        if (codeDeVerificationManquant(compte, codeDeVerification)) {
            return ResultatConnexion.CODE_DE_VERIFICATION_INVALIDE;
        }
        compte.remettreEchecsAZero();
        return ResultatConnexion.REUSSIE;
    }

    private boolean estBloque(Compte compte) {
        return compte.tentativesEchouees() >= TENTATIVES_AVANT_BLOCAGE;
    }

    private boolean codeDeVerificationManquant(Compte compte, String codeDeVerification) {
        return compte.role().exigeCodeDeVerification()
                && !CODE_DE_VERIFICATION_ATTENDU.equals(codeDeVerification);
    }
}
