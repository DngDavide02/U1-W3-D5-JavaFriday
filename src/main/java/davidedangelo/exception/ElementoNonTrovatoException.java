package davidedangelo.exception;

public class ElementoNonTrovatoException extends RuntimeException {
    public ElementoNonTrovatoException(String ISBN) {
        super("Elemento con ISBN " + ISBN + " non trovato");
    }
}
