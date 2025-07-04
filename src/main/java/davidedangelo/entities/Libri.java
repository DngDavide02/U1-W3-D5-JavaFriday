package davidedangelo.entities;

import davidedangelo.Enum.Generi;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Libri extends Letture{
    private String autore;
    private Generi genere;

    public Libri(){}

    public Libri(UUID codice_ISBN, String titolo, Integer anno_pubblicazione, Integer numero_pagine, String autore, Generi genere) {
        super(codice_ISBN, titolo, anno_pubblicazione, numero_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Generi getGenere() {
        return genere;
    }

    public void setGenere(Generi genere) {
        this.genere = genere;
    }
}
