package com.julientp.jee;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class filmDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<film> getFilm() {
        return entityManager.createQuery("select sw FROM film sw", film.class).getResultList();
    }

    public film FilmWithId(Integer Id) {
        TypedQuery<film> req = entityManager.createQuery("select sw FROM film sw WHERE sw.id = :id", film.class);
        try {
            film StarWarsFromReq = req.setParameter("id", Id).getSingleResult();
            if (StarWarsFromReq == null) {
                return null;
            } else {
                return StarWarsFromReq;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public boolean addFilms(film films) {
        try {
            userTransaction.begin();
            entityManager.persist(films);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean deleteFilms(Integer id) {
        try {
            userTransaction.begin();
            entityManager.remove(FilmWithId(id));
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean updateFilms(Integer id, film films) {
        try {
            film filmVerif = FilmWithId(id);
            if (filmVerif == null) {
                return false;
            } else {
                if (films.getLibelle() != null) {
                    filmVerif.setLibelle(films.getLibelle());
                }
                if (films.getDescription() != null) {
                    filmVerif.setDescription(films.getDescription());
                }

                userTransaction.begin();
                entityManager.merge(filmVerif);
                userTransaction.commit();
                return true;
            }
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

}
