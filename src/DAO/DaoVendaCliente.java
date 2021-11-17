/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVenda;
import model.ModelvendaCli;

/**
 *
 * @author AurelioTEC
 */
public class DaoVendaCliente extends ConexaoMySql {

    public ArrayList<ModelvendaCli> getListavendaClieDAO() {
        ArrayList<ModelvendaCli> lista = new ArrayList();
        ModelVenda modelvenda = new ModelVenda();
        ModelCliente Mcli = new ModelCliente();
        ModelvendaCli mvcli = new ModelvendaCli();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT tbvenda.idvenda,tbvenda.idcliente,tbvenda.datavenda,tbvenda.valor,tbvenda.valortotal,tbvenda.desconto, tbcliente.idcliente,tbcliente.clinome,tbcliente.cliendereco,tbcliente.clibairro,tbcliente.clicidade,tbcliente.clitelefone FROM tbvenda INNER JOIN tbcliente ON tbcliente.idcliente=tbvenda.idcliente");
            while (this.getResultSet().next()) {
                modelvenda = new ModelVenda();
                mvcli = new ModelvendaCli();
                Mcli = new ModelCliente();
                modelvenda.setIdvenda(this.getResultSet().getInt("idvenda"));
                modelvenda.setIdcliente(this.getResultSet().getInt("idcliente"));
                modelvenda.setDatavenda(this.getResultSet().getString("datavenda"));
                modelvenda.setValor(this.getResultSet().getDouble("valor"));
                modelvenda.setValortotal(this.getResultSet().getDouble("valortotal"));
                modelvenda.setDesconto(this.getResultSet().getDouble("desconto"));
                //
                Mcli.setIdCliente(this.getResultSet().getInt("idcliente"));
                Mcli.setCliNome(this.getResultSet().getString("clinome"));
                Mcli.setCliendereco(this.getResultSet().getString("cliendereco"));
                Mcli.setCliBairro(this.getResultSet().getString("clibairro"));
                Mcli.setCliCidade(this.getResultSet().getString("clicidade"));
                Mcli.setCliTelefone(this.getResultSet().getString("clitelefone"));
                //
                mvcli.setModelVenda(modelvenda);
                mvcli.setModelCli(Mcli);
                lista.add(mvcli);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return lista;
    }

    
}
