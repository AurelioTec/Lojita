/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author AurelioTEC
 */
public class ModelvendaCli {
    private ModelVenda modelVenda;
    private ModelCliente modelCli;
    private ArrayList<ModelvendaCli> listaVendaCli ;

    /**
     * @return the modelVenda
     */
    public ModelVenda getModelVenda() {
        return modelVenda;
    }

    /**
     * @param modelVenda the modelVenda to set
     */
    public void setModelVenda(ModelVenda modelVenda) {
        this.modelVenda = modelVenda;
    }

    /**
     * @return the modelCli
     */
    public ModelCliente getModelCli() {
        return modelCli;
    }

    /**
     * @param modelCli the modelCli to set
     */
    public void setModelCli(ModelCliente modelCli) {
        this.modelCli = modelCli;
    }

    /**
     * @return the listaVendaCli
     */
    public ArrayList<ModelvendaCli> getListaVendaCli() {
        return listaVendaCli;
    }

    /**
     * @param listaVendaCli the listaVendaCli to set
     */
    public void setListaVendaCli(ArrayList<ModelvendaCli> listaVendaCli) {
        this.listaVendaCli = listaVendaCli;
    }
    
}
