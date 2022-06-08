package com.julientp.jee;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FilmBean {

    @Inject
    private filmDao filmsDao;

    public List<film> getFilm() {
        return filmsDao.getFilm();
    }

    public boolean addFilms(film films) {
        return filmsDao.addFilms(films);
    }

    /*public boolean updateFilm(){
        return filmsDao.
    }*/

    public boolean deleteFilms(Integer id){
        return filmsDao.deleteFilms(id);
    }
}