package controller;

import model.ModelVenda;
import DAO.DaoVenda;
import java.util.ArrayList;

/**
*
* @author AurelioTEC
*/
public class ControllerVenda {

    private DaoVenda daovenda = new DaoVenda();

    /**
    * grava vendas
    * @param pModelvendas
    * @return int
    */
    public int salvarvendaController(ModelVenda pModelvendas){
        return this.daovenda.salvarvendaDAO(pModelvendas);
    }

    /**
    * recupera vendas
    * @param pIdvenda
    * @return ModelVenda
    */
    public ModelVenda getvendaController(int pIdvenda){
        return this.daovenda.getvendaDAO(pIdvenda);
    }
    
    
    public ModelVenda getUltimaVendaController(){
        return this.daovenda.getUltimaVendaDAO();
    }


    /**
    * recupera uma lista devendas
    * @param pIdvenda
    * @return ArrayList
    */
    public ArrayList<ModelVenda> getListavendaController(){
        return this.daovenda.getListavendaDAO();
    }

    /**
    * atualiza vendas
    * @param pModelvendas
    * @return boolean
    */
    public boolean atualizarvendaController(ModelVenda pModelvendas){
        return this.daovenda.atualizarvendaDAO(pModelvendas);
    }

    /**
    * exclui vendas
    * @param pIdvenda
    * @return boolean
    */
    public boolean excluirvendaController(int pIdvenda){
        return this.daovenda.excluirvendaDAO(pIdvenda);
    }

    public boolean imprimirRelvendasControoller(int Codvenda) {
     return this.daovenda.imprimirRelvendasDAO(Codvenda);
    }
}