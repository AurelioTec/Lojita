/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoItensVenda;
import java.util.ArrayList;
import model.ModelItensVenda;

/**
 *
 * @author AurelioTEC
 */
public class ControllerItensVenda {

    DaoItensVenda daoIV = new DaoItensVenda();

    /**
     * Salvar Itens da Venda
     *
     * @param modelIV
     * @return
     */
    public int salvarItensVendaController(ModelItensVenda modelIV) {
        return this.daoIV.CadastrarItensvenda(modelIV);

    }

    /**
     * Mostrar Itens da Venda
     *
     * @param idItensVenda
     * @return
     */
    public ModelItensVenda mostrarItensVendaController(int idItensVenda) {
        return this.daoIV.mostrarItensvenda(idItensVenda);
    }

    /**
     * Pegar Lista de Itens da Venda
     *
     * @return
     */
    public ArrayList<ModelItensVenda> listaItensVendaController() {
        return this.daoIV.listaItensvenda();
    }

    /**
     * Alterar Itens da venda
     *
     * @param modelIV
     * @return
     */
    public boolean alterarItensVendaController(ModelItensVenda modelIV) {
        return this.daoIV.alterarItensVenda(modelIV);
    }

    /**
     * Eliminar Itens da Venda
     *
     * @param codvenda
     * @return
     */
    public boolean eliminarItensVendaController(int codvenda) {
        return this.daoIV.eliminaritensVenda(codvenda);
    }

    public boolean salvarItensVendaController(ArrayList<ModelItensVenda> listaIV) {
        return this.daoIV.CadastrarItensvenda(listaIV);
    }
}
