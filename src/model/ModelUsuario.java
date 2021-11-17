/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AurelioTEC
 */
public class ModelUsuario {
    private int idusario;
    private String nomeusu;
    private String login;
    private String senha;

    /**
     * @return the idusario
     */
    public int getIdusario() {
        return idusario;
    }

    /**
     * @param idusario the idusario to set
     */
    public void setIdusario(int idusario) {
        this.idusario = idusario;
    }

    /**
     * @return the nomeusu
     */
    public String getNomeusu() {
        return nomeusu;
    }

    /**
     * @param nomeusu the nomeusu to set
     */
    public void setNomeusu(String nomeusu) {
        this.nomeusu = nomeusu;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
