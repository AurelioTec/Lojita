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
public class ModelItensVendaProduto {
    private ModelProduto mprodutos;
    private ModelItensVenda mItensVenda;

    /**
     * @return the mprodutos
     */
    public ModelProduto getMprodutos() {
        return mprodutos;
    }

    /**
     * @param mprodutos the mprodutos to set
     */
    public void setMprodutos(ModelProduto mprodutos) {
        this.mprodutos = mprodutos;
    }

    /**
     * @return the mItensVenda
     */
    public ModelItensVenda getmItensVenda() {
        return mItensVenda;
    }

    /**
     * @param mItensVenda the mItensVenda to set
     */
    public void setmItensVenda(ModelItensVenda mItensVenda) {
        this.mItensVenda = mItensVenda;
    }
    
    
}
