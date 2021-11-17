/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoUsuario;
import java.util.ArrayList;
import model.ModelUsuario;

/**
 *
 * @author AurelioTEC
 */
public class ControllerUsuario {

    private DaoUsuario daoUsu = new DaoUsuario();

    /**
     * Cadastrar Controller usuario
     *
     * @param Musuario
     * @return
     */
    public int cadastrarControllerUsuario(ModelUsuario Musuario) {
        return this.daoUsu.CadastrarUsuario(Musuario);
    }

    /**
     * Eliminar Controller Usuario
     *
     * @param idUsuario
     * @return
     */
    public boolean eliminarControllerUsuario(int idUsuario) {
        return this.daoUsu.EliminarUsuario(idUsuario);
    }

    /**
     * Alterar Controller Usuario
     *
     * @param Musuario
     * @return
     */
    public boolean alterarControllerUsuario(ModelUsuario Musuario) {
        return this.daoUsu.AlterarUsuario(Musuario);

    }

    /**
     * Mostrar Controller Usuario por id
     *
     * @param idUsuario
     * @return
     */
    public ModelUsuario listarUsuarioCodigo(int idUsuario) {
        return this.daoUsu.MostrarUsuarioCodigo(idUsuario);
    }

    /**
     * Mostrar Controller usuario por Nome
     * @param nomeUsuario
     * @return
     */
    public ModelUsuario listarUsuarioeNome(String nomeUsuario) {
        return this.daoUsu.MostrarUsuarioNome(nomeUsuario);
    }

    public ArrayList<ModelUsuario> listaUsuarioControllerUsuario() {
        return this.daoUsu.ListaUsuario();
    }

    public boolean validarLoginController(ModelUsuario mUsuario) {
        return this.daoUsu.validarLoginDao(mUsuario);
    }
}
