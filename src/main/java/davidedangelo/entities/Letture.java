package davidedangelo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Letture {
    @Id
    protected UUID codice_ISBN;
    protected String titolo;
    protected Integer anno_pubblicazione;
    protected Integer numero_pagine;

    public Letture(){}

    public Letture(UUID codice_ISBN, String titolo, Integer anno_pubblicazione, Integer numero_pagine) {
        this.codice_ISBN = codice_ISBN;
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public UUID getCodice_ISBN() {
        return codice_ISBN;
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
}
