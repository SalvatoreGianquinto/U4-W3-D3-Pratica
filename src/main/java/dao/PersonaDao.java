package dao;

import enteties.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDao {
    private EntityManager em;

    public PersonaDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    // Salva o aggiorna una Persona
    public void save(Persona persona) {
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    // Recupera una Persona tramite ID
    public Persona getById(int id) {
        return em.find(Persona.class, id);
    }

    // Elimina una Persona tramite ID
    public void delete(int id) {
        Persona p = getById(id);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } else {
            System.out.println("Persona con id " + id + " non trovata");
        }
    }
}
