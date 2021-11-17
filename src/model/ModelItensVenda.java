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
public class ModelItensVenda {
    private int iditensvenda;
    private int codproduto;
    private int codvenda;
    private double itensvalor;
    private int intensqtd;

    /**
     * @return the iditensvenda
     */
    public int getIditensvenda() {
        return iditensvenda;
    }

    /**
     * @param iditensvenda the iditensvenda to set
     */
    public void setIditensvenda(int iditensvenda) {
        this.iditensvenda = iditensvenda;
    }

    /**
     * @return the codproduto
     */
    public int getCodproduto() {
        return codproduto;
    }

    /**
     * @param codproduto the codproduto to set
     */
    public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }

    /**
     * @return the codvenda
     */
    public int getCodvenda() {
        return codvenda;
    }

    /**
     * @param codvenda the codvenda to set
     */
    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }

    /**
     * @return the itensvalor
     */
    public double getItensvalor() {
        return itensvalor;
    }

    /**
     * @param itensvalor the itensvalor to set
     */
    public void setItensvalor(double itensvalor) {
        this.itensvalor = itensvalor;
    }

    /**
     * @return the intensqtd
     */
    public int getIntensqtd() {
        return intensqtd;
    }

    /**
     * @param intensqtd the intensqtd to set
     */
    public void setIntensqtd(int intensqtd) {
        this.intensqtd = intensqtd;
    }
}
