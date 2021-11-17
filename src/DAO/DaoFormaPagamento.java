/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelFormaPagamento;
import model.ModelProduto;

/**
 *
 * @author AurelioTEC
 */
public class DaoFormaPagamento extends ConexaoMySql {

    public int CadastrarFormPagamentoDao(ModelFormaPagamento Mformpag) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbformapagamento( descricaopag,descontopag, parcelaspag,situacao )VALUES('" + Mformpag.getDescripag() + "','" + Mformpag.getDescontopag() + "','" + Mformpag.getParcelapag() + "','" + Mformpag.getSituacao() + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelFormaPagamento mostrarFormaPagamentoDao(int Mformpag) {
        ModelFormaPagamento mFpag = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT idformpag, descricaopag,descontopag, parcelaspag,situacao FROM tbformapagamento WHERE idformpag='" + Mformpag + "'");
            while (this.getResultSet().next()) {
                mFpag.setIdforpag(this.getResultSet().getInt("idformpag"));
                mFpag.setDescripag(this.getResultSet().getString("descricaopag"));
                mFpag.setDescontopag(this.getResultSet().getDouble("descontopag"));
                mFpag.setParcelapag(this.getResultSet().getInt("parcelaspag"));
                mFpag.setSituacao(this.getResultSet().getInt("situacao"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return mFpag;

    }

    public ModelFormaPagamento mostrarFormaPagamentoDao(String formPagdescricao) {
        ModelFormaPagamento mFpag = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT idformpag, descricaopag,descontopag, parcelaspag,situacao FROM tbformapagamento WHERE descricaopag='" + formPagdescricao + "'");
            while (this.getResultSet().next()) {
                mFpag.setIdforpag(this.getResultSet().getInt("idformpag"));
                mFpag.setDescripag(this.getResultSet().getString("descricaopag"));
                mFpag.setDescontopag(this.getResultSet().getDouble("descontopag"));
                mFpag.setParcelapag(this.getResultSet().getInt("parcelaspag"));
                mFpag.setSituacao(this.getResultSet().getInt("situacao"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return mFpag;

    }

    public ArrayList<ModelFormaPagamento> listaFormaPagamentoDao(String l) {
        ArrayList<ModelFormaPagamento> lista = new ArrayList<>();
        ModelFormaPagamento mFpag = new ModelFormaPagamento();
        try {
            this.conectar();
            this.executarSQL("SELECT idformpag, descricaopag,descontopag, parcelaspag,situacao FROM tbformapagamento WHERE descricaopag LIKE '%" + l + "%'");
            while (this.getResultSet().next()) {
                mFpag = new ModelFormaPagamento();
                mFpag.setIdforpag(this.getResultSet().getInt("idformpag"));
                mFpag.setDescripag(this.getResultSet().getString("descricaopag"));
                mFpag.setDescontopag(this.getResultSet().getDouble("descontopag"));
                mFpag.setParcelapag(this.getResultSet().getInt("parcelaspag"));
                mFpag.setSituacao(this.getResultSet().getInt("situacao"));
                lista.add(mFpag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;

    }

    public boolean eliminarFormaPagamentoDao(int Mformpag) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbformapagamento WHERE idformpag='" + Mformpag + "' ");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    public boolean alterarFormaPagamentoDao(ModelFormaPagamento mFpag) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbformapagamento SET descricaopag ='" + mFpag.getDescripag()+ "',descontopag='" + mFpag.getDescontopag()+ "', parcelaspag='" + mFpag.getParcelapag()+ "', situacao='" + mFpag.getSituacao()+ "' WHERE idproduto='" + mFpag.getIdforpag()+ "'");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

  /**  public boolean alterarEstoqueProdutoDao(ArrayList<ModelProduto> listaProduto) {
        try {
            this.conectar();
            for (int i = 0; i < listaProduto.size(); i++) {
                this.executarUpdateDeleteSQL("UPDATE tbproduto SET  proestoque='" + listaProduto.get(i).getProEstoque() + "' WHERE idproduto='" + listaProduto.get(i).getIdProduto() + "'");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }**/

}
