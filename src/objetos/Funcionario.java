/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author andre
 */
public class Funcionario extends User{
    
    private String nome;
    private float salário;
    private String email;
    private String telefone;
    private String endereco;

    public Funcionario(String nome, float salário, String email, String telefone, String endereco, String username, String senha, char status) {
        super(username, senha, status);
        this.nome = nome;
        this.salário = salário;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
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
