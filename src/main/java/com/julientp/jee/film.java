package com.julientp.jee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class film implements Serializable {

    public film()
    {

    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private String description;
    private String duree;
    private Integer annee;
    private Integer boxoffice;
    private String realisateur;
    private String distributeur;

    public film(Integer id, String libelle, String description, String duree, Integer annee, Integer boxoffice, String realisateur, String distributeur) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.duree = duree;
        this.annee = annee;
        this.boxoffice = boxoffice;
        this.realisateur = realisateur;
        this.distributeur = distributeur;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree() {
        return this.duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Integer getAnnee() {
        return this.annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getBoxoffice() {
        return this.boxoffice;
    }

    public void setBoxoffice(Integer boxoffice) {
        this.boxoffice = boxoffice;
    }

    public String getRealisateur() {
        return this.realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDistributeur() {
        return this.distributeur;
    }

    public void setDistributeur(String distributeur) {
        this.distributeur = distributeur;
    }

}
