### Baptiste Fournié 

# Rapport Programmation avancée


## Architecture Matérielle)


## TP 1)

### a) Conception architecturale

### b)Thread 

### c) Cycle de vie 
    Voici une version plus familière du rapport :

---

#### Cycle de Vie d'un Thread

##### 1. Les Différents États

Un thread (ou processus léger) passe par trois états principaux pendant son cycle de vie :

1. **Prêt** : Le thread est prêt à être exécuté, il attend juste qu'un cœur du processeur se libère.
2. **En exécution** : Le thread est en train de tourner sur un cœur.
3. **Bloqué** : Le thread est en pause, en attente d'une ressource pour continuer.

##### 2. Choix du Thread et Rôle de l'OS

Quand un thread est prêt à être exécuté, c'est l'OS qui décide quel thread doit être envoyé vers un cœur grâce à un algorithme de sélection. Une fois choisi, il passe en état d'exécution. 

Cependant, l'OS peut à tout moment suspendre un thread (le mettre en pause) et l'envoyer dans l'état bloqué, généralement parce qu'il attend une ressource spécifique (comme l'accès à un fichier ou un verrou). Pendant qu'il est bloqué, il ne consomme aucune ressource CPU, et l'OS peut donc réutiliser ces ressources pour d'autres threads.

##### 3. Changement de Cœur et Gestion Transparente

Un thread peut très bien reprendre sur un autre cœur après avoir été bloqué. Ce changement est totalement pris en charge par l'OS. De notre côté, on ne sait pas vraiment sur quel cœur tourne un thread à un moment donné, c'est l'OS qui gère ça. Ce qu'on peut faire, c'est s'assurer que les threads sont bien synchronisés entre eux et qu'ils partagent les ressources correctement.

##### 4. Lancement et Gestion du Thread

La première fois qu'on lance un thread avec `start()`, c'est nous qui prenons l'initiative. Ensuite, c'est l'OS qui prend le relais et décide où et quand le thread va être exécuté.

###### 5. Attente de Ressources

Quand un thread est bloqué, il attend simplement la ressource nécessaire pour reprendre. Pendant cette attente, il n'utilise aucune ressource processeur, ce qui permet à l'OS de libérer ces ressources pour d'autres tâches.

###### 6. Fin du Thread

Une fois que le thread a terminé d'exécuter sa méthode `run()`, il est terminé pour de bon. Il disparaît du système et ne peut plus être relancé.



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
    Zoom sur sémaphore:
        -  sémaphore (sens littéral : Post de signalisation sur les côtes)
        Stop t'as pas le droit = Wait() ( tous les threads sont bloqués , stop accées à la ressource)
        thread dis je sors = signal() (1 threas envoie un signal au sémaphore pour dire que le thread a fini d'utiliser la ressource) 
        Signal choix un thread et le met en état exéutionn et le place dans la ressource critique.
        - Deux types de sémaphores:
            1er: binaire thread passe 1 par 1
            2 eme : thread passe en groupe en même temps
        Semaphore Binaire : Si la valeur initial est égale à 1 alors la ressource critique est libre , si la valeur initiale est équivalente à 0 alors la ressource est bloqué et les threads aussi.
        Sync Wait fais attendre les thraeds si la valeur est égale à 0 en attendant que la valeur revienne à 1.
        Sync Signal dis aux atres threads que la ressource est débloqué et fais revenir la valeur initial à 1.
        Un thread ne peut pas jamais allez en section critique dans un code. Si un mobile est trop lent comparé aux autres mobiles. Il sera toujours dans la file d'attente car l'algorithme de séléction pourra jamais le choisir. Car les autres threads auront toujours le temps de retourner dans la file.
    


## Notes Annexes
Etude archicteturale de certains d'ordinateurs de TP:

|            | G25                        | I21                        | G24                        | OnePlus 9                  |
|------------|----------------------------|----------------------------|----------------------------|----------------------------|
| **CPU**    | i7 4770, 4c/8t, 3.4GHz, 3.9GHz Turbo, 64-bit | i7 4770, 4c/8t, 3.4GHz, 3.9GHz Turbo, 64-bit | i7-12700T, 12c/20t, 8p-core, 1.4GHz - 4.7GHz Turbo, 64-bit | Qualcomm SM8350 Snapdragon 888 (5 nm), 64-bit, 1x 2.84 GHz Cortex-X1, 3x 2.42 GHz Cortex-A78, 4x 1.80 GHz Cortex-A55 |
| **RAM**    | 8Go RAM Micron MT16KTF1G64AZ-1 1G8E1 DDR3 PC3L-12800U 2Rx8, 1600MHz, 1.35v CL11 | 2x8Go RAM Micron MT16KTF1G64AZ-1 1G8E1 DDR3 PC3L-12800U 2Rx8, 1600MHz, 1.35v CL11 | 2x32Go RAM Micron MT62C208085L-48A1 SO-DIMM DDR5 PC5-38400 2Rx8, 4800MHz, 1.1v CL40 | 12Go RAM |
| **GPU**    | eGPU Intel, Intel® HD Graphics 4600, 350MHz mode de base, 1.2GHz Turbo, 2Go RAM for VRAM | eGPU Intel, Intel® HD Graphics 4600, 350MHz mode de base, 1.2GHz Turbo, 2Go RAM for VRAM | eGPU Intel, Intel® HD Graphics 770, 300MHz mode de base, 1.5GHz Turbo | Adreno 660, 5 nm, 702 MHz, 0.5 TFLOPS, LPDDR5-8400 |
| **Disque (C:)** | LITEONIT LCS-256M6S-11 2.5 cm 256Go, SATA 6Go/s | LITEONIT LCS-256M6S-11 2.5 cm 256Go, SATA 6Go/s | SOLIDIM SPDFKNGU512GZ 512Go M.2 | 256Go UFS 3.0 |
| **Type de disque** | SSD | SSD | SSD | SSD |
| **Fichier de pagination** | Oui | Oui | Oui | - |
| **Fichier d’échange** | Oui | Oui | Oui | - |

