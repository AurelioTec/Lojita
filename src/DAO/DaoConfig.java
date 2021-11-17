/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author AurelioTEC
 */
public class DaoConfig extends ConexaoMySql {

    public ArrayList<String> mostrarTabelaDao() {
        ArrayList<String> lista = new ArrayList<>();
        String tabelas;
        try {
            this.conectar();
            this.executarSQL("SHOW DATABASES");
            while (this.getResultSet().next()) {
                tabelas = this.getResultSet().getString(1);
                lista.add(tabelas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }

        return lista;
    }

}
