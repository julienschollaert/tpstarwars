package com.julientp.jee;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.security.SecureRandom;
import java.util.Base64;
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

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    public Utilisateur UserWithId(Integer Id) {
        TypedQuery<Utilisateur> req = entityManager.createQuery("select us FROM utilisateur us WHERE sw.id = :id", Utilisateur.class);
        try {
            Utilisateur UtilisateurFromReq = req.setParameter("id", Id).getSingleResult();
            if (UtilisateurFromReq == null) {
                return null;
            } else {
                return UtilisateurFromReq;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public boolean createToken(Integer id, Utilisateur utilisateurs)
    {
        try
        {
            Utilisateur userVerif = UserWithId(id);
            if (userVerif == null){
                return false;
            }
            else {
                if(utilisateurs.getToken() != null){
                    userVerif.setToken(generateNewToken());
                }
                userTransaction.begin();
                entityManager.merge(userVerif);
                userTransaction.commit();
                return true;
            }
        }
        catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }

    }

    public boolean removeToken(Integer id, Utilisateur utilisateurs)
    {
        try
        {
            Utilisateur userVerif = UserWithId(id);
            if (userVerif == null){
                return false;
            }
            else {
                if(utilisateurs.getToken() != null){
                    userVerif.setToken(null);
                }
                userTransaction.begin();
                entityManager.merge(userVerif);
                userTransaction.commit();
                return true;
            }
        }
        catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "JPA error" + e.getMessage());
            return false;
        }

    }




}
