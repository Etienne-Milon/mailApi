package fr.em.mailapi.dao;

import java.sql.Connection;

public abstract class DAO<T,S> {

    protected Connection connexion;

    protected DAO(Connection connexion) {
        this.connexion = connexion;
    }

}
