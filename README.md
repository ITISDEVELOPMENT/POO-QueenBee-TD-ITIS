# POO-QueenBee-TD

Travaux dirigés du module **Programmation Avancée & Design Patterns** (Master 1), sur le projet fil rouge
**QueenBee** (plateforme apicole de l'association BeeAfrica). Une séance = 1 h 30 = 2 ou 3 fonctionnalités du
cahier des charges, chacune en version `avant` puis `apres`, et un exercice corrigé.

| TD | Paquet | Fonctionnalités du cahier des charges | Exercice |
|---|---|---|---|
| TD1 Programmation fonctionnelle | `queenbee.td1` | Règles d'alerte de l'administrateur (Lambda) ; trames valides UC-CY02 (Streams) ; visites prioritaires UC-C01 (Streams) | Poids moyen d'un site (UC-G01) |
| TD2 SOLID | `queenbee.td2` | S : alertes UC-A02 ; O : types de risque ; D : inspection hors ligne UC-A01 | Ajouter le risque « humidité excessive » sans modifier l'évaluateur |
| TD3 Clean Code | `queenbee.td3` | Validation d'une récolte UC-C02 ; connexion UC-T01 | Déclaration d'une récolte UC-A03 |
| TD4 Refactoring | `queenbee.td4` | Score de risque et priorisation des visites UC-C01, en 4 étapes (`etape1`…`apres`) | Validation d'une trame UC-CY02 |

Lancer une démo : la classe `Demo` du paquet voulu. Tests : `mvn test` (JDK 21), un fichier par TD.
