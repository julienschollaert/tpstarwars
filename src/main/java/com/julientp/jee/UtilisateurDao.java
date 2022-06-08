package com.julientp.jee;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilisateurDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    UserTransaction userTransaction;

    public List<Utilisateur> getUtilisateur()
    {
        return entityManager.createQuery("select us FROM utilisateur us",Utilisateur.class).getResultList();
    }

    public boolean addUtilisateur(Utilisateur utilisateurs)
    {
        try {
            userTransaction.begin();
            entityManager.persist(utilisateurs);
            userTransaction.commit();
            return true;
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }
    }
}
