package fr.em.mailapi.dao;

import fr.em.mailapi.security.User;
import fr.em.mediathequeapi.metier.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO extends DAO<User, User> {

    protected UserDAO(Connection connexion) {
        super(connexion);
    }

    
    public User getById(long ean13) {
        return null;
    }

    public ArrayList<User> getById(User user){
        String query = "SELECT * FROM UTILISATEUR WHERE NUM_ADHERENT = ?";
        ArrayList<User> liste = new ArrayList<>();
        ResultSet rs;
        try(PreparedStatement stmt = connexion.prepareStatement(query)){
            stmt.setInt(1, compte.getNumAdherent());
            stmt.execute();
            rs = stmt.getResultSet();
            while(rs.next()){
                User user = new User();
                user.setIdUtilisateur(rs.getInt(1));
                user.setNom(rs.getString(2));
                user.setIdCompte(rs.getInt(3));
                liste.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return liste;
    }

    
    public ArrayList<User> getAll() {
        return null;
    }

    
    public ArrayList<User> getLike(User objet) {
        return null;
    }

    
    public boolean insert(User utilisateur) throws SQLException {
        String query = "INSERT INTO USER(NOM_UTILISATEUR, NUM_ADHERENT) VALUES (?,?)";
        try(PreparedStatement stmt = connexion.prepareStatement(query)){
            stmt.setString(1, user.getNom());
            stmt.setInt(2, user.getIdCompte());
            stmt.execute();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean update(User object) {
        return false;
    }

    
    public boolean delete(User object) {
        return false;
    }
}
