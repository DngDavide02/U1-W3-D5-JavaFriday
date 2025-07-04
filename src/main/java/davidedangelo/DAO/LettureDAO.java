package davidedangelo.DAO;

import davidedangelo.entities.Letture;
import davidedangelo.entities.Libri;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class LettureDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W3-D5-FridayExercise");

    public void aggiungi(Letture letture){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(letture);
            em.getTransaction().commit();
            System.out.println("aggiunto con successo");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine aggiungi

    public void ricercaPerISBN(int ISBN) {
        EntityManager em = emf.createEntityManager();
        try {
            Letture lettura = em.find(Letture.class, ISBN);
            if (lettura != null) {
                System.out.println(lettura); // usa il toString()
            } else {
                System.out.println("Nessuna lettura trovata con ISBN: " + ISBN);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine ricercaISBN

    public void ricercaPerTitolo(String titolo) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Letture> risultati = em.createQuery("SELECT l FROM Letture l WHERE LOWER(l.titolo) LIKE LOWER(:titolo)", Letture.class)
                    .setParameter("titolo", "%" + titolo + "%")
                    .getResultList();
            if (risultati.isEmpty()) {
                System.out.println("titolo contenente: " + titolo + "non trovato");
            } else {
                risultati.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }//fine ricerca per titolo

    public void ricercaPerAnno(int anno){
        EntityManager em = emf.createEntityManager();
        try{
            List<Letture> risultati = em.createQuery("SELECT l FROM Letture l WHERE l.anno_pubblicazione = :anno", Letture.class)
                    .setParameter("anno", anno)
                    .getResultList();
            if (risultati.isEmpty()) {
                System.out.println("anno: " + anno + " non ha dato nulla");
            } else {
                risultati.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine ricerca per anno

    public void ricercaPerAutore (String autore){
        EntityManager em = emf.createEntityManager();
        try {
            List<Libri> risultati = em.createQuery("SELECT l FROM Libri l WHERE LOWER(l.autore) LIKE LOWER(:autore)", Libri.class)
                    .setParameter("autore", "%"+autore+"%")
                    .getResultList();
            if (risultati.isEmpty()) {
                System.out.println("Nessun libro trovato con autore: " + autore);
            } else {
                risultati.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine ricerca per autore

    public void rimuoviPerISBN(int ISBN){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Letture lettura = em.find(Letture.class, ISBN);
            if (lettura != null) {
                em.remove(lettura);
                em.getTransaction().commit();
            } else {
                System.out.println("Nessun elemento trovato con ISBN: " + ISBN);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
    }//fine rimuovi per isbn
}
