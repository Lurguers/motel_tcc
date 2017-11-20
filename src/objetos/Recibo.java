/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author andre
 */
@Entity
public class Recibo {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nomeFuncionario;
    @Column
    private String produtosConsumidos;
    @Column
    private Date dataEntrada;
    @Column
    private Date dataSiada;
    @Column
    private int quarto;
    @Column
    private float valorTotal;
    @Column
    private boolean emAndamento;
    @Column
    private boolean confirmado;

    public Recibo() {
    }

    public Recibo(String nomeFuncionario, Date dataEntrada, Date dataSiada, int quarto, float valorTotal, String produtosConsumidos) {
        this.nomeFuncionario = nomeFuncionario;
        this.dataEntrada = dataEntrada;
        this.dataSiada = dataSiada;
        this.quarto = quarto;
        this.valorTotal = valorTotal;
        this.produtosConsumidos = produtosConsumidos;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getProdutosConsumidos() {
        return produtosConsumidos;
    }

    public void setProdutosConsumidos(String produtosConsumidos) {
        this.produtosConsumidos = produtosConsumidos;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSiada() {
        return dataSiada;
    }

    public void setDataSiada(Date dataSiada) {
        this.dataSiada = dataSiada;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void setEmAndamento(boolean emAndamento) {
        this.emAndamento = emAndamento;
    }
    
}
