/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AurelioTEC
 */
public class ModelProduto {
    private int idProduto;
    private String ProNome;
    private double proValor;
    private int proEstoque;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the ProNome
     */
    public String getProNome() {
        return ProNome;
    }

    /**
     * @param ProNome the ProNome to set
     */
    public void setProNome(String ProNome) {
        this.ProNome = ProNome;
    }

    /**
     * @return the proValor
     */
    public double getProValor() {
        return proValor;
    }

    /**
     * @param proValor the proValor to set
     */
    public void setProValor(double proValor) {
        this.proValor = proValor;
    }

    /**
     * @return the proEstoque
     */
    public int getProEstoque() {
        return proEstoque;
    }

    /**
     * @param proEstoque the proEstoque to set
     */
    public void setProEstoque(int proEstoque) {
        this.proEstoque = proEstoque;
    }
}
