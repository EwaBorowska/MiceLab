package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Mated;
import pl.coderslab.model.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class MatedDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void save(Mated entity) {
        entityManager.persist(entity);
    }
    public Mated findById(Long id) {
        return entityManager.find(Mated.class, id);
    }
    public void update(Mated entity) {
        entityManager.merge(entity);
    }
    public void delete(Mated entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }

        public List<Mated> getAll() {

        TypedQuery<Mated> query = entityManager.createQuery("select m from Mated m ", Mated.class);
        List<Mated> allMatedMice = query.getResultList();

        return allMatedMice;
    }
}
