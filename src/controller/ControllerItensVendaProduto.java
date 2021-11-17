/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoItensVendaProduto;
import java.util.ArrayList;
import model.ModelItensVendaProduto;

/**
 *
 * @author AurelioTEC
 */
public class ControllerItensVendaProduto {
     private DaoItensVendaProduto dIVP= new DaoItensVendaProduto();
     
     public ArrayList<ModelItensVendaProduto> getListaItensvendaProdutoDao(int codigoVenda){
         return this.dIVP.getListaItensvendaProdutoDao(codigoVenda);
     }
}
