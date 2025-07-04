package davidedangelo;

import com.github.javafaker.Faker;
import davidedangelo.DAO.LettureDAO;
import davidedangelo.DAO.PrestitoDAO;
import davidedangelo.DAO.UtenteDAO;
import davidedangelo.Enum.Generi;
import davidedangelo.Enum.Periodicita;
import davidedangelo.entities.Libri;
import davidedangelo.entities.Prestito;
import davidedangelo.entities.Riviste;
import davidedangelo.entities.Utente;
import davidedangelo.exception.ElementoNonTrovatoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U1-W3-D5-FridayExercise");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Faker faker = new Faker(Locale.ITALY);
        UtenteDAO utenteDAO = new UtenteDAO();
        LettureDAO lettureDAO = new LettureDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();

        try{
            Date birthDate1 = faker.date().birthday(18, 80);
            LocalDate dataDiNascita1 = birthDate1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date birthDate2 = faker.date().birthday(18, 80);
            LocalDate dataDiNascita2 = birthDate2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date birthDate3 = faker.date().birthday(18, 80);
            LocalDate dataDiNascita3 = birthDate3.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Date birthDate4 = faker.date().birthday(18, 80);
            LocalDate dataDiNascita4 = birthDate4.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Utente utente1 = new Utente(1001, faker.name().firstName(), faker.name().lastName(), dataDiNascita1);
            Utente utente2 = new Utente(1002, faker.name().firstName(), faker.name().lastName(), dataDiNascita2);
            Utente utente3 = new Utente(1003, faker.name().firstName(), faker.name().lastName(), dataDiNascita3);
            Utente utente4 = new Utente(1004, faker.name().firstName(), faker.name().lastName(), dataDiNascita4);

            Libri libro1 = new Libri(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(100, 800),
                    faker.book().author(),
                    Generi.values()[faker.number().numberBetween(0, Generi.values().length)]
            );

            Libri libro2 = new Libri(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(100, 800),
                    faker.book().author(),
                    Generi.values()[faker.number().numberBetween(0, Generi.values().length)]
            );

            Libri libro3 = new Libri(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(100, 800),
                    faker.book().author(),
                    Generi.values()[faker.number().numberBetween(0, Generi.values().length)]
            );

            Libri libro4 = new Libri(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(100, 800),
                    faker.book().author(),
                    Generi.values()[faker.number().numberBetween(0, Generi.values().length)]
            );

            Riviste rivista1 = new Riviste(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(30, 300),
                    Periodicita.values()[faker.number().numberBetween(0, Periodicita.values().length)]
            );

            Riviste rivista2 = new Riviste(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(30, 300),
                    Periodicita.values()[faker.number().numberBetween(0, Periodicita.values().length)]
            );

            Riviste rivista3 = new Riviste(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(30, 300),
                    Periodicita.MENSILE
            );

            Riviste rivista4 = new Riviste(
                    faker.book().title(),
                    faker.number().numberBetween(1900, 2024),
                    faker.number().numberBetween(30, 300),
                    Periodicita.SEMESTRALE
            );

            Prestito prestito1 = new Prestito(
                    utente1,
                    libro1,
                    LocalDate.now(),
                    LocalDate.now().plusDays(30),
                    LocalDate.now().minusDays(5)
            );

            Prestito prestito2 = new Prestito(
                    utente2,
                    libro3,
                    LocalDate.now().minusDays(50),
                    LocalDate.now().plusDays(30),
                    null

            );

            Prestito prestito3 = new Prestito(
                    utente4,
                    rivista3,
                    LocalDate.now().minusDays(20),
                    LocalDate.now().minusDays(10),
                    null
            );

            //---------------------------------------------save------------------------------------------
            /*utenteDAO.salvaUtente(utente1);
            utenteDAO.salvaUtente(utente2);
            utenteDAO.salvaUtente(utente3);
            utenteDAO.salvaUtente(utente4);
            lettureDAO.aggiungi(libro1);
            lettureDAO.aggiungi(libro2);
            lettureDAO.aggiungi(libro3);
            lettureDAO.aggiungi(libro4);
            lettureDAO.aggiungi(rivista1);
            lettureDAO.aggiungi(rivista2);
            lettureDAO.aggiungi(rivista3);
            lettureDAO.aggiungi(rivista4);
            //lettureDAO.rimuoviPerISBN(2);
            lettureDAO.ricercaPerISBN(3);
            lettureDAO.ricercaPerAnno(36);
            lettureDAO.ricercaPerAutore("f");
            lettureDAO.ricercaPerTitolo("f");
            prestitoDAO.aggiungi(prestito1);
            prestitoDAO.aggiungi(prestito2);
            prestitoDAO.aggiungi(prestito3);
            prestitoDAO.prestitiAttivi(1002);
            prestitoDAO.prestitiScaduti();*/


        }catch (ElementoNonTrovatoException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
            emf.close();
        }

    }
}
