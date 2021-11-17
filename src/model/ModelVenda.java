package model;
/**
*
* @author AurelioTEC
*/
public class ModelVenda {

    private int idvenda;
    private int idcliente;
    private String datavenda;
    private double valor;
    private double valortotal;
    private double desconto;

    /**
    * Construtor
    */
    public ModelVenda(){}

    /**
    * seta o valor de idvenda
    * @param pIdvenda
    */
    public void setIdvenda(int pIdvenda){
        this.idvenda = pIdvenda;
    }
    /**
    * @return pk_idvenda
    */
    public int getIdvenda(){
        return this.idvenda;
    }

    /**
    * seta o valor de idcliente
    * @param pIdcliente
    */
    public void setIdcliente(int pIdcliente){
        this.idcliente = pIdcliente;
    }
    /**
    * @return fk_idcliente
    */
    public int getIdcliente(){
        return this.idcliente;
    }

    /**
    * seta o valor de datavenda
    * @param pDatavenda
    */
    public void setDatavenda(String pDatavenda){
        this.datavenda = pDatavenda;
    }
    /**
    * @return datavenda
    */
    public String getDatavenda(){
        return this.datavenda;
    }

    /**
    * seta o valor de valor
    * @param pValor
    */
    public void setValor(double pValor){
        this.valor = pValor;
    }
    /**
    * @return valor
    */
    public double getValor(){
        return this.valor;
    }

    /**
    * seta o valor de valortotal
    * @param pValortotal
    */
    public void setValortotal(double pValortotal){
        this.valortotal = pValortotal;
    }
    /**
    * @return valortotal
    */
    public double getValortotal(){
        return this.valortotal;
    }

    /**
    * seta o valor de desconto
    * @param pDesconto
    */
    public void setDesconto(double pDesconto){
        this.desconto = pDesconto;
    }
    /**
    * @return desconto
    */
    public double getDesconto(){
        return this.desconto;
    }

    @Override
    public String toString(){
        return "Modelvendas {" + "::idvenda = " + this.idvenda + "::idcliente = " + this.idcliente + "::datavenda = " + this.datavenda + "::valor = " + this.valor + "::valortotal = " + this.valortotal + "::desconto = " + this.desconto +  "}";
    }
}