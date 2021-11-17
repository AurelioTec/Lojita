/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

/**
 *
 * @author AurelioTEC
 */
public class Utilitario {
    
    public double virgulaParaPonto(String valor){
        String retorno= new String();
        int tamanho= valor.length();
        for (int i = 0; i < tamanho; i++) {
            if (valor.charAt(i)==',') {
                retorno+='.';
            }else{
                retorno+=valor.charAt(i);
            }
            
        }
        return Double.parseDouble(retorno);
    }
    
}
