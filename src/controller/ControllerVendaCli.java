/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoVendaCliente;
import java.util.ArrayList;
import model.ModelvendaCli;

/**
 *
 * @author AurelioTEC
 */
public class ControllerVendaCli {
    private DaoVendaCliente dvc= new DaoVendaCliente();
    
    public ArrayList<ModelvendaCli> getListavendaClieController(){
        return dvc.getListavendaClieDAO();
    }
    
    
    
}
