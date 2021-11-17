/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelUsuario;

/**
 *
 * @author AurelioTEC
 */
public class DaoUsuario extends ConexaoMySql{
    
public int CadastrarUsuario(ModelUsuario MUsuario){
        try {
            this.conectar();
                    return this.insertSQL("INSERT INTO tbusuario( nomeusu,login, senha)VALUES('"+MUsuario.getNomeusu()+"','"+MUsuario.getLogin()+"','"+MUsuario.getSenha()+"')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally{
            this.fecharConexao();
        }
    }

public ModelUsuario MostrarUsuarioCodigo(int idusuario){
   ModelUsuario MUsuario=new ModelUsuario();
    try {
        this.conectar();
        this.executarSQL("SELECT idusuario,nomeusu,login,senha FROM tbusuario WHERE idusuario='"+idusuario+"'");
        while(this.getResultSet().next()){
            MUsuario.setIdusario(this.getResultSet().getInt("idusuario"));
            MUsuario.setNomeusu(this.getResultSet().getString("nomeusu"));
            MUsuario.setLogin(this.getResultSet().getString("login"));
            MUsuario.setSenha(this.getResultSet().getString("senha"));
}
    } catch (Exception e) {
         e.printStackTrace();
    } finally{
            this.fecharConexao();
        }
    return MUsuario;
    
}  

public ModelUsuario MostrarUsuarioNome(String nomeUsua){
   ModelUsuario MUsuario=new ModelUsuario();
    try {
        this.conectar();
        this.executarSQL("SELECT idusuario,nomeusu,login,senha FROM tbusuario WHERE login='"+nomeUsua+"'");
        while(this.getResultSet().next()){
            MUsuario.setIdusario(this.getResultSet().getInt("idusuario"));
            MUsuario.setNomeusu(this.getResultSet().getString("nomeusu"));
            MUsuario.setLogin(this.getResultSet().getString("login"));
            MUsuario.setSenha(this.getResultSet().getString("senha"));
        }
    } catch (Exception e) {
         e.printStackTrace();
    } finally{
            this.fecharConexao();
        }
    return MUsuario;
    
}  
    

public ArrayList<ModelUsuario> ListaUsuario(){
    ArrayList<ModelUsuario> lista=new ArrayList<>();
    ModelUsuario MUsuario=new ModelUsuario();        
      try {
        this.conectar();
        this.executarSQL("SELECT idusuario,nomeusu,login,senha FROM tbusuario ");
        while(this.getResultSet().next()){
            MUsuario =new ModelUsuario();
            MUsuario.setIdusario(this.getResultSet().getInt("idusuario"));
            MUsuario.setNomeusu(this.getResultSet().getString("nomeusu"));
            MUsuario.setLogin(this.getResultSet().getString("login"));
            MUsuario.setSenha(this.getResultSet().getString("senha"));
            lista.add(MUsuario);
        }
    } catch (Exception e) {
           e.printStackTrace();
    }finally{
            this.fecharConexao();
        }
    return lista;
    
}

public boolean EliminarUsuario(int idusuario){
    try {
        this.conectar();
        return this.executarUpdateDeleteSQL("DELETE FROM tbusuario WHERE idusuario='"+idusuario+"' ");
    } catch (Exception e) {
         e.printStackTrace();
         return false;
    } finally{
            this.fecharConexao();
        }
    
}

public boolean AlterarUsuario(ModelUsuario Musuario){
    try {
        this.conectar();
        return this.executarUpdateDeleteSQL("UPDATE tbusuario SET nomeusu='"+Musuario.getNomeusu()+"',login='"+Musuario.getLogin()+"', senha='"+Musuario.getSenha()+"' WHERE idusuario='"+Musuario.getIdusario()+"'");
        
    } catch (Exception e) {
         e.printStackTrace();
         return false;
    } finally{
            this.fecharConexao();
        }
    
}
public boolean validarLoginDao(ModelUsuario MUsuario){
    try {
        this.conectar();
        this.executarSQL("SELECT idusuario,nomeusu,login,senha FROM tbusuario WHERE login='"+MUsuario.getLogin()+"'AND senha='"+MUsuario.getSenha()+"'");
        if (getResultSet().next()) {
            return true;
        } else {
            return false;
        }
    } catch (Exception e) {
         e.printStackTrace();
         return false;
    } finally{
            this.fecharConexao();
        }

}

}
