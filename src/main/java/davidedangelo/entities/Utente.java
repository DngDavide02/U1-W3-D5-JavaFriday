package davidedangelo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Utente {
    @Id
    private int numero_tessera;
    private String nome;
    private String cognome;
    private LocalDate data_di_nascita;

    public Utente(){}

    public Utente(int numero_tessera, String nome, String cognome, LocalDate data_di_nascita) {
        this.numero_tessera = numero_tessera;
        this.nome = nome;
        this.cognome = cognome;
        this.data_di_nascita = data_di_nascita;
    }

    public int getNumero_tessera() {
        return numero_tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
