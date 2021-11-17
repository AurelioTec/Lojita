/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoFormaPagamento;
import java.util.ArrayList;
import model.ModelFormaPagamento;

/**
 *
 * @author AurelioTEC
 */
public class ControllerFormaPagamento {
    private DaoFormaPagamento daoFormPag=new DaoFormaPagamento();

    
    /**
     * Salvar Controller Forma de Pagamento 
     * @param MFormPag
     * @return 
     */
   public int cadastrarControllerFormaPagamento(ModelFormaPagamento MFormPag){
       return this.daoFormPag.CadastrarFormPagamentoDao(MFormPag); 
   }
   
   /**
    * Eliminar Controller Forma de Pagamento
     * @param idMFormPag
    * @return 
    */
   public boolean eliminarControllerFormaPagamento(int idMFormPag){
       return this.daoFormPag.eliminarFormaPagamentoDao(idMFormPag);
   }   
   
   /**
    * Alterar Controller Forma de Pagamento
     * @param MFormPag
    * @return 
    */
   public boolean alterarControllerFormaPagamento(ModelFormaPagamento MFormPag){
       return this.daoFormPag.alterarFormaPagamentoDao(MFormPag);
       
   }
   
   /**
    * Mostrar Controller Forma de Pagamento por Id
     * @param idMFormPag
    * @return 
    */
   public ModelFormaPagamento mostrarControllerFormaPagamentoId (int idMFormPag){
       return this.daoFormPag.mostrarFormaPagamentoDao(idMFormPag);
   }
   
   /**
    * Mostrar Controller Forma de Pagamento por Id
     * @param MFormPag
    * @return 
    */
   public ModelFormaPagamento mostrarControllerFormaPagamentoNome (String MFormPag){
       return this.daoFormPag.mostrarFormaPagamentoDao(MFormPag);
   }
   
   public ArrayList<ModelFormaPagamento> listaControllerFormaPagamento(String l){
       return this.daoFormPag.listaFormaPagamentoDao(l);
   }
/*
    public boolean alterarEstoqueProdutoController(ArrayList<ModelProduto> listaProduto) {
        return daoP.alterarEstoqueProdutoDao(listaProduto);
    }
*/ 
}
