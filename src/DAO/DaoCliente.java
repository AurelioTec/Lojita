/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import model.ModelCliente;
import net.sf.jasperreports.engine.*;
/**
 *
 * @author AurelioTEC
 */
public class DaoCliente extends ConexaoMySql{
    
public int CadastrarCliente(ModelCliente MCliente){
        try {
            this.conectar();
                    return this.insertSQL("INSERT INTO tbcliente( clinome,cliendereco, clibairro,clicidade,clitelefone)VALUES('"+MCliente.getCliNome()+"','"+MCliente.getCliendereco()+"','"+MCliente.getCliBairro()+"','"+MCliente.getCliCidade()+"','"+MCliente.getCliTelefone()+"')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally{
            this.fecharConexao();
        }
    }

public boolean gerarRelClienteDao(){

    try {
        this.conectar();
        this.executarSQL("SELECT*FROM tbcliente");
        JRResultSetDataSource jrsdS= new JRResultSetDataSource(getResultSet());
        InputStream caminho= this.getClass().getClassLoader().getResourceAsStream("relatorios/RelCliente.jasper");
        JasperPrint jp = JasperFillManager.fillReport(caminho, new HashMap(),jrsdS);
        JasperExportManager.exportReportToPdfFile(jp,"C:/Users/AurelioTEC/Documents/NetBeansProjects/Lojita/relimpresso/relclientes.pdf");
        File file= new File("C:/Users/AurelioTEC/Documents/NetBeansProjects/Lojita/relimpresso/relclientes.pdf");
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
    } finally{
            this.fecharConexao();
        }
    
}  

public ModelCliente MostrarCliente(int idcliente){
   ModelCliente MCliente=new ModelCliente();
    try {
        this.conectar();
        this.executarSQL("SELECT idcliente,clinome,cliendereco,clibairro,clicidade,clitelefone FROM tbcliente WHERE idcliente='"+idcliente+"'");
        while(this.getResultSet().next()){
            MCliente.setIdCliente(this.getResultSet().getInt("idcliente"));
            MCliente.setCliNome(this.getResultSet().getString("clinome"));
            MCliente.setCliendereco(this.getResultSet().getString("cliendereco"));
            MCliente.setCliBairro(this.getResultSet().getString("clibairro"));
            MCliente.setCliCidade(this.getResultSet().getString("clicidade"));
            MCliente.setCliTelefone(this.getResultSet().getString("clitelefone"));
        }
    } catch (Exception e) {
         e.printStackTrace();
    } finally{
            this.fecharConexao();
        }
    return MCliente;
    
}  

public ModelCliente MostrarClienteNome(String nomeCliente){
   ModelCliente MCliente=new ModelCliente();
    try {
        this.conectar();
        this.executarSQL("SELECT idcliente,clinome,cliendereco,clibairro,clicidade,clitelefone FROM tbcliente WHERE clinome='"+nomeCliente+"'");
        while(this.getResultSet().next()){
            MCliente.setIdCliente(this.getResultSet().getInt("idcliente"));
            MCliente.setCliNome(this.getResultSet().getString("clinome"));
            MCliente.setCliendereco(this.getResultSet().getString("cliendereco"));
            MCliente.setCliBairro(this.getResultSet().getString("clibairro"));
            MCliente.setCliCidade(this.getResultSet().getString("clicidade"));
            MCliente.setCliTelefone(this.getResultSet().getString("clitelefone"));
        }
    } catch (Exception e) {
         e.printStackTrace();
    } finally{
            this.fecharConexao();
        }
    return MCliente;
    
}  
    

public ArrayList<ModelCliente> ListaCliente(String l){
    ArrayList<ModelCliente> lista=new ArrayList<>();
    ModelCliente mdc=new ModelCliente();        
      try {
        this.conectar();
        this.executarSQL("SELECT idcliente, clinome, cliendereco, clibairro, clicidade,clitelefone  FROM tbcliente WHERE clinome LIKE '%"+l+"%'");
        while(this.getResultSet().next()){
            mdc=new ModelCliente();
            mdc.setIdCliente(this.getResultSet().getInt("idcliente"));
            mdc.setCliNome(this.getResultSet().getString("clinome"));
            mdc.setCliendereco(this.getResultSet().getString("cliendereco"));
            mdc.setCliBairro(this.getResultSet().getString("clibairro"));
            mdc.setCliCidade(this.getResultSet().getString("clicidade"));
            mdc.setCliTelefone(this.getResultSet().getString("clitelefone"));
            lista.add(mdc);
        }
    } catch (Exception e) {
           e.printStackTrace();
    }finally{
            this.fecharConexao();
        }
    return lista;
    
}

public boolean EliminarCliente(int idCliente){
    try {
        this.conectar();
        return this.executarUpdateDeleteSQL("DELETE FROM tbcliente WHERE idcliente='"+idCliente+"' ");
    } catch (Exception e) {
         e.printStackTrace();
         return false;
    } finally{
            this.fecharConexao();
        }
    
}

public boolean AlterarCliente(ModelCliente MCliente){
    try {
        this.conectar();
        return this.executarUpdateDeleteSQL("UPDATE tbcliente SET clinome='"+MCliente.getCliNome()+"',cliendereco='"+MCliente.getCliendereco()+"', clibairro='"+MCliente.getCliBairro()+"',clicidade='"+MCliente.getCliCidade()+"',clitelefone='"+MCliente.getCliTelefone()+"' WHERE idcliente='"+MCliente.getIdCliente()+"'");
    } catch (Exception e) {
         e.printStackTrace();
         return false;
    } finally{
            this.fecharConexao();
        }
    
}

}
