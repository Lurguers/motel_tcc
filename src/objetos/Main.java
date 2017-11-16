/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import hibernate.Dao;

/**
 *
 * @author Lurguers
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* TODO code application logic here*/
        Dao d = new Dao();
        Funcionario f = new Funcionario("a", 1f, "a", "a", "a", "a", "a", "a", "a a", "a", "a", "a",0 ,8,"a a a");
        d.inserir(f);
        System.out.println(f.getLogado());
        System.exit(0);
    }
    
}
