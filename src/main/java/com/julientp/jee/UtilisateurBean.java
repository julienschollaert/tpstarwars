package com.julientp.jee;


import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UtilisateurBean {

    @Inject
    private UtilisateurDao utilisateursDao;

    public List<Utilisateur> getUtilisateur()
    {
        return utilisateursDao.getUtilisateur();
    }

    public boolean addUtilisateur(Utilisateur utilisateurs)
    {
        return utilisateursDao.addUtilisateur(utilisateurs);
    }

    public boolean updateFilm(Integer id, Utilisateur utilisateurs) {
        return utilisateursDao.createToken(id, utilisateurs);
    }




}
