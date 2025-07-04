Spiegazione progetto biblioteca

Ho creato diverse classi che rappresentano i dati principali: 

-Utenti, 

-Letture (classe astratta che si divide con i figli libri o riviste) 

-Prestiti. 

Le letture sono state organizzate usando l’ereditarietà JPA con JOINED, così da condividere i campi comuni e avere tabelle separate per libri e riviste (mi sembrava una buona scelta per non avere troppe classi vuote e soprattuto per una questione di (anche se in questo caso fittizia) futura manutenzione).

Per gestire valori fissi come i generi dei libri o la periodicità delle riviste ho usato degli enum Generi e Periodicità

Ho usato la libreria Faker per generare dati casuali realistici e facilitare il tutto senza dover scrivere i dati ad ogni test.

Le operazioni sul database sono state inserite in classi DAO dedicate:

-LettureDAO (che si occupa di tutta la parte dei libri)

-PrestitoDAO (che si occupa di tutta la parte prestiti)

-UtenteDAO(che si occupa solo del salvataggio e della eliminazione degli utenti, ma che ho preferito dividere dal resto)


Infine, la classe principale crea alcuni utenti, libri, riviste e prestiti, li salva nel database e mostra alcune ricerche e operazioni, per dimostrare il funzionamento complessivo.