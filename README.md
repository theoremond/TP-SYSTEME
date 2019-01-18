# MODULE Système

## TP2



### Simulation d'une patisserie

Le but de l'exercice est d'implanter en Java une patisserie qui propose des gâteaux au chocolat à des clients. 

Des patissiers fournissent les gâteaux, tandis que les clients les achetent.

#### A

Au moins deux patrons viennent à l'esprit pour résoudre le problème: le producteur/consommateur et le lecteur/rédacteur.

Pourquoi le patron lecteur/rédacteur n'est pas approprié ?

#### B

   On suppose que la (les files d'attentes) sont gérées par des Arraylist.

On a 4 classes:

    Patisserie qui a les méthodes: depose, achete et getstock
    Patissier qui implante Runnable et dépose des patisseries
    Client qui implante Runnable également et achète
    Gâteau qui symbolise un gâteau ^_^


Faire une analyse du problème et au moins donner un schéma expliquant comment est géré l'exclusion mutuelle

Quelles sont les classes qui feront moniteurs ?

Comment sont lancés les threads ?

Implémanter la simulation (pensez sérieusement à la gestion des exceptions)

### 2. Simulation d'une patisserie avec collection ThreadSafe

On souhaite maintenant utiliser une collection Threadsafe. Utilisons par exemple la  ArrayBlockingQueue qui implante la  BlockingQueue.

Cette collection fonctionne comme une FIFO.

Lisez attentivement la documentation pour prendre connaissance des méthodes de cette classe (offer, poll, size entre autre).

Comment se fait l'exclusion mutuelle ?

Quelles sont les classes qui feront moniteurs ?

Revoyez votre code précédent pour utiliser cette collection.
 
### 3. Fin de programme
L'objectif est ici de terminer proprement l'exécution de votre programme, en garantissant que tous les éléments placés dans la file d'attente sont bien traités.
Il est donc interdit de tuer les threads ou d'employer ce type de fonctionnement.

#### A

Une première solution simple est de limiter le nombre de gateaux pris par un consommateur, puis de stopper les producteurs lorsqu'il y a trop de gateaux (quand la ArrayBlockingQueue est pleine).
Implémentez cette solution sur votre projet précédent.
Est ce une bonne approche ? (noil y a mieux, on est d'accord, pourquoi ?)

#### B

Une autre solution pour procéder à l'arrêt du programme consiste à utiliser le patron  poison pill : pilule empoisonnée.
L'idée est de placer des éléments particuliers par les producteurs (autant que de consommateurs) qui vont tuer chaque consommateur. Quand un consommateur consomme une de ces pilules empoisonnée, il s'arrête de fonctionner.

Pour cela, on peut ajouter une constante à la classe Gâteau:

    public  class Gateau {
        // gateau empoisonné !
        public  static  final GATEAU_EMPOISONNE =  new Gateau() ;
    }

Modifiez le code des Clients pour qu'ils s'arrêtent lorsqu'il reçoivent un gâteau empoisonné.

Modifez le code  de la méthode Main pour arrêter les patissiers au bout de 20 itérations et envoyer les gateaux empoisonnés aux clients.

#### C

Quel est l'inconvient de cette solution ?