package com.julientp.jee;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class filmDao
{
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<film> getFilm()
    {
        return entityManager.createQuery("select sw FROM film sw", film.class).getResultList();
    }

    public boolean FilmWithId(Integer Id)
    {
        return entityManager.createQuery("select sw FROM film sw", film.class).getResultList();
    }

    public boolean addFilms(film films){
        try{
            userTransaction.begin();
            entityManager.persist(films);
            userTransaction.commit();
            return true;
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean deleteFilms(Integer id)
    {
        try{
            userTransaction.begin();
            entityManager.remove(id);
            userTransaction.commit();
            return true;
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }

    public boolean updateFilms(film films)
    {
        try{
            userTransaction.begin();
            entityManager.merge(films);
            userTransaction.commit();
            return true;
        }catch (Exception e){
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }


}
