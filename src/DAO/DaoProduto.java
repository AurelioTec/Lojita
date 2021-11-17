/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelProduto;

/**
 *
 * @author AurelioTEC
 */
public class DaoProduto extends ConexaoMySql {

    public int CadastrarProduto(ModelProduto Mprodutos) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbproduto( pronome,provalor, proestoque)VALUES('" + Mprodutos.getProNome() + "','" + Mprodutos.getProValor() + "','" + Mprodutos.getProEstoque() + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ModelProduto mostrarProdutos(int idproduto) {
        ModelProduto Mdprodutos = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT idproduto, pronome, provalor, proestoque FROM tbproduto WHERE idproduto='" + idproduto + "'");
            while (this.getResultSet().next()) {
                Mdprodutos.setIdProduto(this.getResultSet().getInt("idproduto"));
                Mdprodutos.setProNome(this.getResultSet().getString("pronome"));
                Mdprodutos.setProValor(this.getResultSet().getDouble("provalor"));
                Mdprodutos.setProEstoque(this.getResultSet().getInt("proestoque"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return Mdprodutos;

    }

    public ModelProduto mostrarProdutoNome(String produtoNome) {
        ModelProduto Mdprodutos = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT idproduto, pronome, provalor, proestoque FROM tbproduto WHERE pronome ='" + produtoNome + "'");
            while (this.getResultSet().next()) {
                Mdprodutos.setIdProduto(this.getResultSet().getInt("idproduto"));
                Mdprodutos.setProNome(this.getResultSet().getString("pronome"));
                Mdprodutos.setProValor(this.getResultSet().getDouble("provalor"));
                Mdprodutos.setProEstoque(this.getResultSet().getInt("proestoque"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return Mdprodutos;

    }

    public ArrayList<ModelProduto> listaProdutos(String l) {
        ArrayList<ModelProduto> lista = new ArrayList<>();
        ModelProduto Mp = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL("SELECT idproduto, pronome, provalor, proestoque FROM tbproduto WHERE pronome LIKE '%" + l + "%'");
            while (this.getResultSet().next()) {
                Mp = new ModelProduto();
                Mp.setIdProduto(this.getResultSet().getInt("idproduto"));
                Mp.setProNome(this.getResultSet().getString("pronome"));
                Mp.setProValor(this.getResultSet().getDouble("provalor"));
                Mp.setProEstoque(this.getResultSet().getInt("proestoque"));
                lista.add(Mp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;

    }

    public boolean eliminarProduto(int idproduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbproduto WHERE idproduto='" + idproduto + "' ");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    public boolean alterarproduto(ModelProduto Mprodutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbproduto SET pronome ='" + Mprodutos.getProNome() + "',provalor='" + Mprodutos.getProValor() + "', proestoque='" + Mprodutos.getProEstoque() + "' WHERE idproduto='" + Mprodutos.getIdProduto() + "'");

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    public boolean alterarEstoqueProdutoDao(ArrayList<ModelProduto> listaProduto) {
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

    }

}
