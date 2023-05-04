Nom       : Augereau	
Prénom    : Robin
Groupe TP : E

Les « ... » indiquent les endroits à compléter.

=====[ Temps passé ]============================================================

Ces informations de temps sont demandées à titre indicatif et ne sont pas
prises en compte dans la notation du projet.


* Temps passé sur la V1 : 6 heures 00 minutes
* Temps passé sur la V2 : 3 heures 45 minutes

Pour la V2 on ne tiendra pas compte du temps passé sur la V1.


=====[ Questions ]==============================================================

--------------------------------------------------------------------------------
Pourquoi l'exception `OperationInterditeException` ne peut pas être définie
comme vérifiée par le compilateur ?
--------------------------------------------------------------------------------

L'exception `OperationInterditeException` ne peut pas être considérée comme exception vérifiée, car elle ne peut pas être prédite avant l'exécution du programme. Elle se produit lorsque le joueur tente de modifier le jeu, ce qui est interdit, et est détectée par la procuration lorsqu'elle intercepte l'appel à la méthode `retirer()`.

--------------------------------------------------------------------------------
Expliquer ce qu'il faut faire pour ajouter un nouveau niveau de jeu, par
exemple la stratégie lente (C13).  Pour plus de précision, on numérotera
les étapes à faire.
--------------------------------------------------------------------------------

Il suffit d'ajouter d'ajouter un cas `case` dans la structure case de la méthode `stringToStrategie` de la classe `Jouer.java` 

--------------------------------------------------------------------------------
Expliquer ce qui permet, dans votre conception, de changer dynamiquement
(en cours d'exécution du programme) la stratégie d'un joueur (C14).
--------------------------------------------------------------------------------

Il suffirait de modifier la stratégie du joueur en utilisant la méthode setNiveau de la classe `Joueur`.
