## EsameJavaNegozio

Simulazione Negozio di articoli elettronici. Esame di Algoritmi e Strutture Dati in Java 02/09/2019 prof. Vitantonio Bevilacqua

## Traccia

![Traccia](https://i.imgur.com/Pkj0QEj.jpg)

## F.A.Q.

#### Come lo faccio partire?

```shell script
$ git clone https://github.com/DoubleHub/EsameJavaNegozio
```

Aprire con il tuo IDE (preferibilmente IntelliJ IDEA), cliccare su Play per avviare il programma da Main.java

#### Che cosa diamine sono gli Optional?

Gli ```Optional``` sono una bellissima feature di Java 8 che mi consente di gestire i valori potenzialmente ```null``` (per gli amici nullable) in 
maniera semplice e sicura! Wow! Niente più ```NullPointerException```! Quasi non ci credo...

Funzionano così: un oggetto potenzialmente ```null``` si trova all'interno di una generica istanza ```Optional<T>```, e per 
recuperare il suo valore devo per forza utilizzare ```orElse``` oppure ```orElseThrow```. Questi due metodi vengono eseguiti
quando il valore interno dell'Optional è null. Esempio pratico lo trovate nel metodo ```Venditore::vendiArticolo```

```java
Articolo articoloDaVendere = direttoreAssociato.getArticoloByNome(articolo.getNome())
    .orElseThrow(() -> new ArticleNotFoundException(this, articolo.getNome()));
```

Il metodo ```Manager::getArticoloByNome``` ritorna un ```Optional``` di ```Articolo``` (```Optional<Articolo>``` in javese). 
Significa che il valore interno è potenzialmente ```null```! (nel caso in cui l'articolo richiesto da nome non si trovasse 
nell'inventario del manager). Quindi per prenderlo quando effettivamente non è ```null```, uso ```orElseThrow``` per tirare
la mia ArticleNotFoundException nel caso in cui davvero l'articolo non sia stato trovato. Comodissimo cazzo!
Ma perché non le insegnano ste cose mi devo incazzà eh dio... dio bello!

Lezione finita, adesso andate e utilizzate quei fottuti Optional se volete passare qualsiasi colloquio di lavoro come
programmatore Java, sfaticati del cazzo lol e mi raccomando informatevi meglio su internet a riguardo perché ci sono un
sacco di cose da dire sugli Optional e io sinceramente non ho voglia voi non mi pagate quindi ciao

#### Cosa combini con stream().sorted() e .filter()?

Gli ```Stream``` sono un'altra feature importante di Java 8. Ci consentono di utilizzare una sorta di programmazione funzionale
in Java! Io li uso perché mi trovo bene e anche perché di solito non passerete mai nessuna code review se non li usate quindi
usateli perché salvano vite umane e non scherzo.

No, non vi spiegherò cosa sono. Cercate su Google "stream java 8" pigroni!!!

#### Cos'è .forEach()?

E' una funzione che accetta come parametro una lambda. Itera tutta la ```List``` e ti consente di chiamare una funzione che ha come argomento il valore corrente
della ```List``` che stai iterando. Figata! Se vi vedo ancora fare i for stile C vi impicco personalmente!!!

Functional = Functioning (always) tenetelo a mente

#### Modello E/R del programma?

Tutti i miei SQL niggas capiranno che questo programma implementa una specie di modello simil-E/R:

- A 1 Manager sono associati N Seller (Venditore)
- A 1 Manager sono associati N Article (Articolo)

E' idiota come modello ma è esattamente ciò che chiede la traccia alla fine no? No? Boh io non li capisco sti esami...
(pssst! Non è davvero un modello E/R! E' più una cosa astratta)
