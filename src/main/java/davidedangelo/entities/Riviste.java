package davidedangelo.entities;

import davidedangelo.Enum.Periodicita;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class Riviste extends Letture{
    private Periodicita tipo_periodicita;

    public Riviste(){}

    public Riviste(UUID codice_ISBN, String titolo, Integer anno_pubblicazione, Integer numero_pagine, Periodicita tipo_periodicita) {
        super(codice_ISBN, titolo, anno_pubblicazione, numero_pagine);
        this.tipo_periodicita = tipo_periodicita;
    }

    public Periodicita getTipo_periodicita() {
        return tipo_periodicita;
    }

    public void setTipo_periodicita(Periodicita tipo_periodicita) {
        this.tipo_periodicita = tipo_periodicita;
    }
}
