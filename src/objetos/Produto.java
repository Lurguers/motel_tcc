/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lurguers
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String codigo;
    @Column
    private String nome;
    @Column
    private int qtdEstoque;
    @Column
    private float valorCompra;
    @Column
    private float valorVenda;
    @Column
    private String descricao;
    @Column
    private String unidade;

    public Produto(String codigo, String nome, int qtdEstoque, float valorCompra, float valorVenda, String descricao, String unidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.descricao = descricao;
        this.unidade = unidade;
    }
    public Produto(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(float valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
    
}
