package davidedangelo.entities;

import davidedangelo.Enum.Generi;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Libri extends Letture {
    private String autore;
    @Enumerated(EnumType.STRING)
    private Generi genere;

    public Libri() {}

    public Libri(String titolo, Integer anno_pubblicazione, Integer numero_pagine, String autore, Generi genere) {
        super(titolo, anno_pubblicazione, numero_pagine);
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

    @Override
    public String toString() {
        return "Libri{" +
                "codice_ISBN=" + codice_ISBN +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
