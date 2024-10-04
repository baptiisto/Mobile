### Baptiste Fournié 

# Rapport Programmation avancée


## Architecture Matérielle)


## TP 1)

### a)Conception architecturale

### b)Thread 

### c) Cycle de vie 
    Procéssus léger : un cycle de vie
    3 états:
    -
    -
    -
    Algorithme  de séléction pour choisir un thread prêt à être exécuté. 
    Va envoyer le processus sur le coeur 
    thread passe en état exécution
    L'os peut susprendre l'éxécution : thread va être en état bloqué
    Le thread  peut rependre dans un notre coeur . C'est L'os qui gére tout ca 
    Nous on sait pas ou se trouve précisément les threads . On peut juste gérer la dépendance entre les threads.
    La premiére fois qu'unn thread est lancé par start ca vient de nous sinon c'est L'os qui décide.
    Le thread bloqué n'utilise pas de ressources. L'os sait qu'il a une ressource de libre car thread bloqué.
    On attend une ressource pour être rééxécuté ( je parle du thread)
    Quand terminer la méthode run , le thread est finito , il disparait à jamais 
    

### d) Explication du code

#### TP2)
    On a aussi fait du parralélisme en faisant marcher plusieurs mobiles en même temps chaque mobile était dans un thread. On a mis une vitesse différente à tous les mobiles.
Pourquoi les A et B se superposent ?

    Les threads veulent afficher leur string au même endroit. Ils sont tous les deux indépendants
    Ils accédent toutes les deux à la ressource critique System.out.Ils le font sur une boucle for qui est la section critique.


### e) Gestion des taches et des sections critique
    Pas envie que les threads accéssent à la meme zone mémoire 
    Dufaud est i , on veut touys faire à i++ à dufaud. 
    Corruption mémoire car 15 threads sur la meme zone mémoire est une MAUVAISE IDEE
    Gestion séquentielle de la mémoire
    une ressource critique c'est une zone mémoire , un tableau , case i , un eul processus à la foid qu'il peut utiliser
    section critique , un portyion de code qu'un seul thread peut éxécuté à la fois , section critique utilisé quand thread utilise la même ressource
    exclusion mutuelle : P1 et P2 accedent à la meme ressource critique, P1 accede à la ressource , P2 est automatiquement exclu et inversement marche avec infini de processus 
    Traiter l'exclsuion muteuelle 
    principe d'exclusion mutuelle:
    4 principes:
    - Un processus dans un instant critique , soit personne traverse la portion de code soit 1. 0 ou 1
    - En dehors de la portion de code , si un processus est bloqué alors un autre doit pouvoir entrer en section critique à condition que le 1 er principe sooit respecté
    - Si plusieurs processus attendnetd de rentré dans la secttion critique; l'un deux doit pouvoir y entrer au bout d'un moment fini ( si pas fait ca , le code se fige, tous les processus attendnet comme de singes, les processus s'est arréte pendnat la boucle car ils sont trop CONS)
    - Meme solution pour tous lkes processus , ils faut qu'il travaillent avec les meme regles
    Application de ces 4 principes , c'est le MUUUUUUUUUUUUUUUUUUUUUUTTTTTTTTTTTTTTTTTTTTTTTTTTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEXXXXXXXXXXXXXXXXXXX (mutal exclusiion askip d'aprés dufaud Kun)
    On peut utiliser les sémaphores pour utiliser le mutex 
    On utilsie en java synchronised qui est un verrouy mutex . Permet de gérer less sections critiques (protection d'un bout de code)
    On fait un synchronised , lors de la méthode ,soit on met le bout de code eentre accolade . On mettra ca en oeuvre lors du TP2
    oh bebou (ntm)
    inverse de asynchrone ( cest son rival)
    Plusieurs facons de gerer plusieurs séquences d'actions
    - Exclusion
        Bloc synchro
        methode synchro
        sémaphore
    - Moniteur ( protége les données , un seul processus peut accéder à ladite donné)
    

    


## Notes Annexes

