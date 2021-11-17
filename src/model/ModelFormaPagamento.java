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
public class ModelFormaPagamento {

    /**
     * @return the idforpag
     */
    public int getIdforpag() {
        return idforpag;
    }

    /**
     * @param idforpag the idforpag to set
     */
    public void setIdforpag(int idforpag) {
        this.idforpag = idforpag;
    }

    /**
     * @return the descripag
     */
    public String getDescripag() {
        return descripag;
    }

    /**
     * @param descripag the descripag to set
     */
    public void setDescripag(String descripag) {
        this.descripag = descripag;
    }

    /**
     * @return the descontopag
     */
    public double getDescontopag() {
        return descontopag;
    }

    /**
     * @param descontopag the descontopag to set
     */
    public void setDescontopag(double descontopag) {
        this.descontopag = descontopag;
    }

    /**
     * @return the parcelapag
     */
    public int getParcelapag() {
        return parcelapag;
    }

    /**
     * @param parcelapag the parcelapag to set
     */
    public void setParcelapag(int parcelapag) {
        this.parcelapag = parcelapag;
    }

    /**
     * @return the situacao
     */
    public int getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }
    private int idforpag;
    private String descripag;
    private double descontopag;
    private int parcelapag;
    private int situacao;
}
