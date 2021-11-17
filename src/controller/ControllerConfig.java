/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoConfig;
import java.util.ArrayList;


/**
 *
 * @author AurelioTEC
 */
public class ControllerConfig {
    private DaoConfig daoConfig=new DaoConfig();
    
    public ArrayList<String> mostrarTabelaController(){
        return this.daoConfig.mostrarTabelaDao();
    }
    
}
