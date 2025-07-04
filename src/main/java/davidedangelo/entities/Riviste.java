package davidedangelo.entities;

import davidedangelo.Enum.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Riviste extends Letture {
    @Enumerated(EnumType.STRING)
    private Periodicita tipo_periodicita;

    public Riviste() {}

    public Riviste(String titolo, Integer anno_pubblicazione, Integer numero_pagine, Periodicita tipo_periodicita) {
        super(titolo, anno_pubblicazione, numero_pagine);
        this.tipo_periodicita = tipo_periodicita;
    }

    public Periodicita getTipo_periodicita() {
        return tipo_periodicita;
    }

    public void setTipo_periodicita(Periodicita tipo_periodicita) {
        this.tipo_periodicita = tipo_periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "codice_ISBN=" + codice_ISBN +
                ", titolo='" + titolo + '\'' +
                ", numero_pagine=" + numero_pagine +
                ", anno_pubblicazione=" + anno_pubblicazione +
                '}';
    }
}
