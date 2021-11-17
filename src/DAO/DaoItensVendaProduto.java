/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelItensVenda;
import model.ModelItensVendaProduto;
import model.ModelProduto;

/**
 *
 * @author AurelioTEC
 */
public class DaoItensVendaProduto extends ConexaoMySql{
    
  public ArrayList<ModelItensVendaProduto> getListaItensvendaProdutoDao(int codigoVenda){
     ArrayList<ModelItensVendaProduto> lista=new ArrayList<>();
     ModelItensVendaProduto mIVP = new ModelItensVendaProduto();
     ModelProduto mp= new ModelProduto();
     ModelItensVenda mIV= new ModelItensVenda();
     try {
            this.conectar();
            this.executarSQL("SELECT tbproduto.idproduto, tbproduto.pronome, tbproduto.provalor, tbproduto.proestoque, tbitensvenda.iditensvenda, tbitensvenda.codproduto,tbitensvenda.codvenda, tbitensvenda.itensvalor, tbitensvenda.itensqtd FROM  tbitensvenda INNER JOIN tbproduto ON tbitensvenda.codproduto=tbproduto.idproduto WHERE tbitensvenda.codvenda='"+codigoVenda+"'");
            while (this.getResultSet().next()) {
                 mIVP = new ModelItensVendaProduto();
                 mp= new ModelProduto();
                 mIV= new ModelItensVenda();
                 
                 mp.setIdProduto(this.getResultSet().getInt("idproduto"));
                 mp.setProNome(this.getResultSet().getString("pronome"));
                 mp.setProValor(this.getResultSet().getDouble("provalor"));
                 mp.setProEstoque(this.getResultSet().getInt("proestoque"));
                 
                 mIV.setIditensvenda(this.getResultSet().getInt("iditensvenda"));
                 mIV.setCodproduto(this.getResultSet().getInt("codproduto"));
                 mIV.setCodvenda(this.getResultSet().getInt("codvenda"));
                 mIV.setItensvalor(this.getResultSet().getDouble("itensvalor"));
                 mIV.setIntensqtd(this.getResultSet().getInt("itensqtd"));
                 
                 mIVP.setMprodutos(mp);
                 mIVP.setmItensVenda(mIV);
                 lista.add(mIVP);

                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;
     
    }
    
}
