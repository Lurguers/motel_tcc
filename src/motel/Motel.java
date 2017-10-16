/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package motel;

import hibernate.Dao;
import java.util.List;
import objetos.Admin;
import objetos.Funcionario;

/**
 *
 * @author andre
 */
public class Motel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Dao d = new Dao();
        Funcionario f = new Funcionario("lucas", 1500f, "Lucas Dornelles Ferandes", "48996626070", "pio correia", "lurguers", "one1piece");
        d.inserir(f);
        Admin a = new Admin("andre", "crodu");
        d.inserir(a);
        System.exit(0);
        String usuario = "cripin";
        String Senha ="123";
        Dao d = new Dao();
        List<Funcionario> func = d.consultar(Funcionario.class, "username", usuario);
        List<Admin> admin = d.consultar(Admin.class, "username", usuario);
        if (func.size()==0 && admin.size()==0){
            System.out.println("Usuário Incorreto!");
        }else if(func.size()==1 && admin.size()==0){
            if (func.get(0).getSenha().trim().equals(Senha.trim())) {
                System.out.println("func");
            }else{
                System.out.println("Senha Incorreta!");
            }
        }else if (func.size()==0 && admin.size()==1) {
            if (admin.get(0).getSenha() ==Senha) {
                System.out.println("admin");
            }else{
                System.out.println("Senha Incorreta!");
            }   
        }else{
            System.out.println("Redundancia no Banco de Dados!");
        }*/
        System.exit(0);
    }
}
