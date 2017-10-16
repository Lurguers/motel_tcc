/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author andre
 */
@Entity
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="id")),  
    @AttributeOverride(name="username", column=@Column(name="username")),
    @AttributeOverride(name="senha", column = @Column(name="senha")),
    @AttributeOverride(name="status", column = @Column(name="status"))
})  
public class Funcionario extends User{
    @Column
    private String nome;
    @Column
    private float salário;
    @Column
    private String email;
    @Column
    private String telefone;
    @Column
    private String endereco;
    public Funcionario(String nome, float salário, String email, String telefone, String endereco, String username, String senha) {
        super(username, senha);
        this.nome = nome;
        this.salário = salário;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Funcionario() {
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalário() {
        return salário;
    }

    public void setSalário(float salário) {
        this.salário = salário;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
            
            
    
    
    
}
