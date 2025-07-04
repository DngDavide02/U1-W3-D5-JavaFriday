package davidedangelo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "id_utente", referencedColumnName = "numero_tessera", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn (name = "id_elemento_prestato", referencedColumnName = "codice_ISBN", nullable = false)
    private Letture elemento_prestato;

    private LocalDate inizio_prestito;
    private LocalDate restituzione_prevista;
    private LocalDate restituzione_effettiva;

    public Prestito(){}

    public Prestito(Utente utente, Letture elemento_prestato, LocalDate inizio_prestito, LocalDate restituzione_prevista, LocalDate restituzione_effettiva) {
        this.utente = utente;
        this.elemento_prestato = elemento_prestato;
        this.inizio_prestito = inizio_prestito;
        this.restituzione_prevista = restituzione_prevista;
        this.restituzione_effettiva = restituzione_effettiva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Letture getElemento_prestato() {
        return elemento_prestato;
    }

    public void setElemento_prestato(Letture elemento_prestato) {
        this.elemento_prestato = elemento_prestato;
    }

    public LocalDate getInizio_prestito() {
        return inizio_prestito;
    }

    public void setInizio_prestito(LocalDate inizio_prestito) {
        this.inizio_prestito = inizio_prestito;
    }

    public LocalDate getRestituzione_prevista() {
        return restituzione_prevista;
    }

    public void setRestituzione_prevista(LocalDate restituzione_prevista) {
        this.restituzione_prevista = restituzione_prevista;
    }

    public LocalDate getRestituzione_effettiva() {
        return restituzione_effettiva;
    }

    public void setRestituzione_effettiva(LocalDate restituzione_effettiva) {
        this.restituzione_effettiva = restituzione_effettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elemento_prestato=" + elemento_prestato +
                ", inizio_prestito=" + inizio_prestito +
                ", restituzione_prevista=" + restituzione_prevista +
                ", restituzione_effettiva=" + restituzione_effettiva +
                '}';
    }
}
