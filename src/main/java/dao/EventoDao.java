package dao;

import enteties.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {
    private EntityManager em;

    public EventoDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Evento evento){
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(int id){
        return em.find(Evento.class, id);
    }

    public void delete(int id){
        Evento ev = getById(id);
        if (ev != null) {
            em.getTransaction().begin();
            em.remove(ev);
            em.getTransaction().commit();
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }
    }

}
