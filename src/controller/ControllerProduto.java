/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoProduto;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author AurelioTEC
 */
public class ControllerProduto {
    private DaoProduto daoP=new DaoProduto();

    
    /**
     * Salvar Controller Produto
     * @param Mprodutos
     * @return 
     */
   public int cadastrarControllerProdutos(ModelProduto Mprodutos){
       return this.daoP.CadastrarProduto(Mprodutos); 
   }
   
   /**
    * Eliminar Controller Produto
    * @param idproduto
    * @return 
    */
   public boolean eliminarControllerProduto(int idproduto){
       return this.daoP.eliminarProduto(idproduto);
   }   
   
   /**
    * Alterar Controller Produto
    * @param Mprodutos
    * @return 
    */
   public boolean alterarControllerProduto(ModelProduto Mprodutos){
       return this.daoP.alterarproduto(Mprodutos);
       
   }
   
   /**
    * Listar Controller Produto por Id
    * @param idProduto
    * @return 
    */
   public ModelProduto listarProduto(int idProduto){
       return this.daoP.mostrarProdutos(idProduto);
   }
   
   /**
    * Listar Controller Produto por Id
    * @param produtoNome
    * @return 
    */
   public ModelProduto listarProdutoNome(String produtoNome){
       return this.daoP.mostrarProdutoNome(produtoNome);
   }
   
   public ArrayList<ModelProduto> listaProdutoControllerProduto(String l){
       return this.daoP.listaProdutos(l);
   }

    public boolean alterarEstoqueProdutoController(ArrayList<ModelProduto> listaProduto) {
        return daoP.alterarEstoqueProdutoDao(listaProduto);
    }
}
