
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class EmissionenDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Emissionen");

    private List<Emissionen> emissionsdaten = new ArrayList<Emissionen>();
     
    public List<Emissionen> findAll()
    {
        EntityManager entityManager = emf.createEntityManager();
        Query abfrage = entityManager.createQuery("select a from Artikel a");
        List<Emissionen> alleArtikel = abfrage.getResultList();
        entityManager.close();
        return alleArtikel;
    }
    
     void saveDaten(Emissionen artikel)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(artikel);
        //em.persist(artikel);
        t.commit();
    }
    
        
}
