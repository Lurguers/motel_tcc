/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import hibernate.Dao;
import java.util.Date;
import java.util.List;
import javaFx.telas.principal.principalController;

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
        Funcionario f = new Funcionario("sal", 1f, "a", "a", "a", "a", "a", "a", "a a", "a", "a", "a",2 ,8,"a a a");
        d.inserir(f);
        System.out.println(f.getLogado());
        System.exit(0);
        /*Quarto um = new Quarto();
        d.inserir(um);
        Quarto dois = new Quarto();
        d.inserir(dois);
        System.exit(0);
        Dao d = new Dao();
        Quarto q = new Quarto();
        q.setStatusPortaQuarto(false);
        q.setStatusGaragem(false);
        q.setStatusLuz(false);
        q.setStatusPortaServico(false);
        q.setStatusQuarto(1);
        d.inserir(q);
        
        System.exit(0);
        //Dao d = new Dao();
        //List<Produto> p = d.consultar(Produto.class, "id", 1);
        //Date da = new Date();
        //Recibo re = new Recibo("lurguers", p, da, da, 10,100);
        //d.inserir(re);
        
        //List<Recibo> r = d.consultar(Recibo.class, "id", 2);
        //System.out.println(r.get(0).getProdutosConsumidos());
        //System.out.println(r.get(0).getNomeFuncionario());
        System.exit(0);*/
    }
    
}
