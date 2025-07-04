package davidedangelo.DAO;

import davidedangelo.entities.Letture;
import davidedangelo.entities.Libri;
import davidedangelo.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class PrestitoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W3-D5-FridayExercise");

    public void aggiungi(Prestito prestito){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(prestito);
            em.getTransaction().commit();
            System.out.println("aggiunto con successo");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine aggiungi

    public void rimuovi(int id){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Prestito p = em.find(Prestito.class, id);
            if (p != null){
                em.remove(p);
                System.out.println("rimosso con successo");
            }
            em.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine rimuovi

    public void prestitiAttivi(int numero_tessera){
        EntityManager em = emf.createEntityManager();
        try{
            List<Prestito> lista = em.createQuery(
                    "SELECT p FROM Prestito p WHERE p.utente.numero_tessera = :tessera AND p.restituzione_effettiva IS NULL", Prestito.class)
                    .setParameter("tessera", numero_tessera)
                    .getResultList();

            if (lista.isEmpty()) {
                System.out.println("Nessun prestito attivo per tessera: " + numero_tessera);
            } else {
                System.out.println("Prestiti attivi per tessera " + numero_tessera + ":");
                lista.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println("Errore ricerca prestiti attivi: " + e.getMessage());
        }finally {
            em.close();
        }
    }//fine prestiti attivi

    public void prestitiScaduti(){
        EntityManager em = emf.createEntityManager();
        try {
            List<Prestito> lista = em.createQuery(
                    "SELECT p FROM Prestito p WHERE p.restituzione_prevista < :data AND p.restituzione_effettiva IS NULL", Prestito.class)
                    .setParameter("data", LocalDate.now())
                    .getResultList();

            if (lista.isEmpty()) {
                System.out.println("Nessun prestito scaduto non restituito.");
            } else {
                System.out.println("Prestiti scaduti e non ancora restituiti:");
                lista.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println("Errore ricerca prestiti scaduti: " + e.getMessage());
        }finally {
            em.close();
        }
    }//fine prestiti scaduti
}
