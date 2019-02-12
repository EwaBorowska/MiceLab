package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.model.Mouse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class MouseDao {

    @PersistenceContext
    private EntityManager entityManager;
    public void saveMouse(Mouse entity) {
        entityManager.persist(entity);
    }
    public Mouse findById(Long id) {
        return entityManager.find(Mouse.class, id);
    }
    public void update(Mouse entity) {
        entityManager.merge(entity);
    }
    public void delete(Mouse entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }

    public List<Mouse> getAllActive() {

        TypedQuery<Mouse> query = entityManager.createQuery("select m from Mouse m WHERE m.active = TRUE", Mouse.class);
        List<Mouse> allMice = query.getResultList();



        return allMice;
    }

    public List<Mouse> getAllAvailable() {

        TypedQuery<Mouse> query = entityManager.createQuery("select m from Mouse m WHERE m.available = TRUE", Mouse.class);
        List<Mouse> allAvailableMice = query.getResultList();



        return allAvailableMice;
    }
    public List<Mouse> getAll() {

        TypedQuery<Mouse> query = entityManager.createQuery("select m from Mouse m  ", Mouse.class);
        List<Mouse> allMiceInDB = query.getResultList();

        return allMiceInDB;

    }



}
