package davidedangelo.entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Letture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codice_ISBN")
    protected int codice_ISBN;

    protected String titolo;
    protected Integer anno_pubblicazione;
    protected Integer numero_pagine;

    public Letture() {}

    public Letture(String titolo, Integer anno_pubblicazione, Integer numero_pagine) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public int getCodice_ISBN() {
        return codice_ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(Integer anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public Integer getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(Integer numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "Letture{" +
                "codice_ISBN=" + codice_ISBN +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
