package dao;

import enteties.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDao {
    private EntityManager em;

    public PartecipazioneDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    // Salva o aggiorna una partecipazione
    public void save(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    // Recupera una partecipazione per ID
    public Partecipazione getById(int id) {
        return em.find(Partecipazione.class, id);
    }

    // Elimina una partecipazione per ID
    public void delete(int id) {
        Partecipazione p = getById(id);
        if (p != null) {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } else {
            System.out.println("Partecipazione con id " + id + " non trovata");
        }
    }
}

