package davidedangelo;

import com.github.javafaker.Faker;
import davidedangelo.exception.ElementoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Locale;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W3-D5-FridayExercise");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        try{

        }catch (ElementoNonTrovatoException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }
}
