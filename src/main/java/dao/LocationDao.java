package dao;

import enteties.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {
    private EntityManager em;

    public LocationDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    // Salva o aggiorna una Location
    public void save(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    // Recupera una Location per ID
    public Location getById(int id) {
        return em.find(Location.class, id);
    }

    // Elimina una Location per ID
    public void delete(int id) {
        Location l = getById(id);
        if (l != null) {
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } else {
            System.out.println("Location con id " + id + " non trovata");
        }
    }
}
