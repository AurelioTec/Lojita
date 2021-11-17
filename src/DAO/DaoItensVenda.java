/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelItensVenda;
import model.ModelProduto;

/**
 *
 * @author AurelioTEC
 */
public class DaoItensVenda extends ConexaoMySql {

    public int CadastrarItensvenda(ModelItensVenda mItensVenda) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbitensvenda( codproduto,codvenda, itensvalor, itensqtd)VALUES('" + mItensVenda.getCodproduto() + "','" + mItensVenda.getCodvenda() + "','" + mItensVenda.getItensvalor() + "','" + mItensVenda.getIntensqtd() + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelItensVenda mostrarItensvenda(int idItensVenda) {
        ModelItensVenda MdIVenda = new ModelItensVenda();
        try {
            this.conectar();
            this.executarSQL("SELECT iditensvenda, codproduto,codvenda, itensvalor, itensqtd FROM tbproduto WHERE iditensvenda='" + idItensVenda + "'");
            while (this.getResultSet().next()) {
                MdIVenda.setIditensvenda(this.getResultSet().getInt("iditensvenda"));
                MdIVenda.setCodproduto(this.getResultSet().getInt("codproduto"));
                MdIVenda.setCodvenda(this.getResultSet().getInt("codvenda"));
                MdIVenda.setItensvalor(this.getResultSet().getDouble("proestoque"));
                MdIVenda.setIntensqtd(this.getResultSet().getInt("itensqtd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return MdIVenda;

    }

    /**
     * public ModelItensVenda mostrarItensvendaNome(String produtoNome){
     * ModelItensVenda MdIVenda=new ModelItensVenda(); try { this.conectar();
     * this.executarSQL("SELECT iditensvenda, codproduto,codvenda, itensvalor,
     * itensqtd FROM tbproduto WHERE iditensvenda='"+idItensVenda+"'");
     * while(this.getResultSet().next()){
     * MdIVenda.setIditensvenda(this.getResultSet().getInt("iditensvenda"));
     * MdIVenda.setCodproduto(this.getResultSet().getInt("codproduto"));
     * MdIVenda.setCodvenda(this.getResultSet().getInt("codvenda"));
     * MdIVenda.setItensvalor(this.getResultSet().getDouble("proestoque"));
     * MdIVenda.setIntensqtd(this.getResultSet().getInt("itensqtd")); } } catch
     * (Exception e) { e.printStackTrace(); } finally{ this.fecharConexao(); }
     * return Mdprodutos;
     *
     * }
     *
     * @param l
     * @return
     */
    public ArrayList< ModelItensVenda> listaItensvenda() {
        ArrayList< ModelItensVenda> lista = new ArrayList<>();
        ModelItensVenda MdIVenda = new ModelItensVenda();
        try {
            this.conectar();
            this.executarSQL("SELECT iditensvenda, codproduto,codvenda, itensvalor, itensqtd FROM tbitensvenda");
            while (this.getResultSet().next()) {
                MdIVenda.setIditensvenda(this.getResultSet().getInt("iditensvenda"));
                MdIVenda.setCodproduto(this.getResultSet().getInt("codproduto"));
                MdIVenda.setCodvenda(this.getResultSet().getInt("codvenda"));
                MdIVenda.setItensvalor(this.getResultSet().getDouble("proestoque"));
                MdIVenda.setIntensqtd(this.getResultSet().getInt("itensqtd"));
                lista.add(MdIVenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;

    }

    public boolean eliminaritensVenda(int codvenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbitensvenda WHERE codvenda='" + codvenda+ "' ");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    public boolean alterarItensVenda(ModelItensVenda MdIVenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbitensvenda  SET codproduto='" + MdIVenda.getCodproduto() + "',codvenda='" + MdIVenda.getCodvenda() + "', itensvalor='" + MdIVenda.getItensvalor() + "', itensqtd='" + MdIVenda.getIntensqtd() + "' WHERE iditensvenda='" + MdIVenda.getIditensvenda() + "'");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    public boolean CadastrarItensvenda(ArrayList<ModelItensVenda> listaIV) {
        try {
            this.conectar();
            int cont = listaIV.size();
            for (int i = 0; i < cont; i++) {
            this.insertSQL("INSERT INTO tbitensvenda( codproduto,codvenda, itensvalor, itensqtd)VALUES('" + listaIV.get(i).getCodproduto() + "','" + listaIV.get(i).getCodvenda() + "','" + listaIV.get(i).getItensvalor() + "','" + listaIV.get(i).getIntensqtd() + "')");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

}
