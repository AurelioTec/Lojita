package DAO;

import model.ModelVenda;
import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author AurelioTEC
 */
public class DaoVenda extends ConexaoMySql {

    /**
     * grava vendas
     *
     * @param pModelvendas
     * @return int
     */
    public int salvarvendaDAO(ModelVenda pModelvendas) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbvenda (idcliente,valor,valortotal,desconto) VALUES ('" + pModelvendas.getIdcliente() + "','" + pModelvendas.getValor() + "','" + pModelvendas.getValortotal() + "','" + pModelvendas.getDesconto() + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera vendas
     *
     * @param pIdvenda
     * @return ModelVenda
     */
    public ModelVenda getvendaDAO(int pIdvenda) {
        ModelVenda modelvenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL("SELECT idvenda,idcliente,datavenda,valor,valortotal,desconto FROM tbvenda WHERE idvenda = '" + pIdvenda + "'");
            while (this.getResultSet().next()) {
                modelvenda.setIdvenda(this.getResultSet().getInt("idvenda"));
                modelvenda.setIdcliente(this.getResultSet().getInt("idcliente"));
                modelvenda.setDatavenda(this.getResultSet().getString("datavenda"));
                modelvenda.setValor(this.getResultSet().getDouble("valor"));
                modelvenda.setValortotal(this.getResultSet().getDouble("valortotal"));
                modelvenda.setDesconto(this.getResultSet().getDouble("desconto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelvenda;
    }
    
    public ModelVenda getUltimaVendaDAO() {
        ModelVenda modelvenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL("SELECT idvenda,idcliente,datavenda,valor,valortotal,desconto FROM tbvenda where idvenda=(Select max(idvenda)FROM tbvenda)");
            while (this.getResultSet().next()) {
                modelvenda.setIdvenda(this.getResultSet().getInt("idvenda"));
                modelvenda.setIdcliente(this.getResultSet().getInt("idcliente"));
                modelvenda.setDatavenda(this.getResultSet().getString("datavenda"));
                modelvenda.setValor(this.getResultSet().getDouble("valor"));
                modelvenda.setValortotal(this.getResultSet().getDouble("valortotal"));
                modelvenda.setDesconto(this.getResultSet().getDouble("desconto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelvenda;
    }

    /**
     * recupera uma lista de vendas
     *
     * @return ArrayList
     */
    public ArrayList<ModelVenda> getListavendaDAO() {
        ArrayList<ModelVenda> listamodelvenda = new ArrayList();
        ModelVenda modelvenda = new ModelVenda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT idvenda,idcliente,datavenda,valor,valortotal,desconto FROM tbvenda");
            while (this.getResultSet().next()) {
                modelvenda = new ModelVenda();
                modelvenda.setIdvenda(this.getResultSet().getInt("idvenda"));
                modelvenda.setIdcliente(this.getResultSet().getInt("idcliente"));
                modelvenda.setDatavenda(this.getResultSet().getString("datavenda"));
                modelvenda.setValor(this.getResultSet().getDouble("valor"));
                modelvenda.setValortotal(this.getResultSet().getDouble("valortotal"));
                modelvenda.setDesconto(this.getResultSet().getDouble("desconto"));
                listamodelvenda.add(modelvenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelvenda;
    }

    /**
     * atualiza vendas
     *
     * @param pModelvendas
     * @return boolean
     */
    public boolean atualizarvendaDAO(ModelVenda pModelvendas) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbvenda SET idcliente = '" + pModelvendas.getIdcliente() + "',valor = '" + pModelvendas.getValor() + "',valortotal = '" + pModelvendas.getValortotal() + "',desconto = '" + pModelvendas.getDesconto() + "' WHERE idvenda = '" + pModelvendas.getIdvenda() + "'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui vendas
     *
     * @param pIdvenda
     * @return boolean
     */
    public boolean excluirvendaDAO(int pIdvenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbvenda WHERE idvenda = '" + pIdvenda + "'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean imprimirRelvendasDAO(int Codvenda) {
        try {
            this.conectar();
            this.executarSQL("SELECT tbvenda.idvenda,tbvenda.idcliente,tbvenda.datavenda,tbvenda.valor,tbvenda.valortotal,tbvenda.desconto,tbitensvenda.codproduto,tbitensvenda.itensvalor,tbitensvenda.itensqtd,tbproduto.idproduto,tbproduto.pronome,tbcliente.idcliente,tbcliente.clinome,tbcliente.cliendereco,tbcliente.clibairro,tbcliente.clicidade,tbcliente.clitelefone,tbitensvenda.codvenda,tbitensvenda.iditensvenda,tbproduto.provalor,tbproduto.proestoque FROM tbvenda "
                    + "INNER JOIN  tbitensvenda ON tbvenda.idvenda = tbitensvenda.codvenda "
                    + "INNER JOIN  tbproduto ON tbitensvenda.codproduto = tbproduto.idproduto "
                    + "INNER JOIN  tbcliente ON tbvenda.idcliente = tbcliente.idcliente "
                    + "WHERE tbvenda.idvenda='"+Codvenda+"'");
            JRResultSetDataSource jrsdS = new JRResultSetDataSource(getResultSet());
            InputStream caminho = this.getClass().getClassLoader().getResourceAsStream("relatorios/RelVendas.jasper");
            JasperPrint jp = JasperFillManager.fillReport(caminho, new HashMap(), jrsdS);
            JasperExportManager.exportReportToPdfFile(jp, "C:/Users/AurelioTEC/Documents/NetBeansProjects/Lojita/relimpresso/relvendas.pdf");
            File file = new File("C:/Users/AurelioTEC/Documents/NetBeansProjects/Lojita/relimpresso/relvendas.pdf");
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            file.deleteOnExit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
