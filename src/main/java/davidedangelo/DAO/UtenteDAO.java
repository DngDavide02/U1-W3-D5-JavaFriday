package davidedangelo.DAO;

import davidedangelo.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UtenteDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W3-D5-FridayExercise");

    public void salvaUtente(Utente utente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(utente);
            em.getTransaction().commit();
            System.out.println("utente salvato");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//salva

    public void eliminaUtente(Utente utente) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Utente utenteDaEliminare = em.find(Utente.class, utente.getNumero_tessera());
            if (utenteDaEliminare != null) {
                em.remove(utenteDaEliminare);
                System.out.println("utente eliminato");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }//elimina

}
