/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoCliente;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelProduto;

/**
 *
 * @author AurelioTEC
 */
public class ControllerCliente {
    private DaoCliente daoCli=new DaoCliente();

    
   /**
    * Cadastrar Controller Cliente
    * @param Mcliente
    * @return 
    */
   public int cadastrarControllerCliente(ModelCliente Mcliente){
       return this.daoCli.CadastrarCliente(Mcliente);
   }
   
/**
 * Eliminar Controller Cliente
 * @param idcliente
 * @return 
 */
   public boolean eliminarControllerCliente(int idcliente){
       return this.daoCli.EliminarCliente(idcliente);
   }   
   
/**
 * Alterar Controller Cliente
 * @param Mcliente
 * @return 
 */
   public boolean alterarControllerCliente(ModelCliente Mcliente){
       return this.daoCli.AlterarCliente(Mcliente);
       
   }
   
/**
 * Mostrar Controller Cliente por id
 * @param idCliente
 * @return 
 */
   public ModelCliente listarCliente(int idCliente){
       return this.daoCli.MostrarCliente(idCliente);
   }
/**
 * Mostrar Controller Cliente por Nome
 * @param nomeCliente
 * @return 
 */
   public ModelCliente listarClienteNome(String nomeCliente){
       return this.daoCli.MostrarClienteNome(nomeCliente);
   }
   
   public ArrayList<ModelCliente> listaClienteControllerCliente(String l){
       return this.daoCli.ListaCliente(l);
   }

    public boolean gerarRelClienteController() {
        return this.daoCli.gerarRelClienteDao();

    }
}
