/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Lurguers
 */
@Entity
public class Quarto {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String numQuarto;
    @Column
    private Time horaHoraComeco;
    @Column
    private boolean statusPortaQuarto;
    @Column
    private boolean statusPortaServico;
    @Column
    private boolean statusGaragem;
    @Column
    private boolean statusLuz;
    @Column
    private int statusQuarto;// 1 para livre, 2 para ocupado, 3 para em limpez e 4 para em manutenção
    
    public Quarto(){
        
    }

    public int getStatusQuarto() {
        return statusQuarto;
    }

    public void setStatusQuarto(int statusQuarto) {
        this.statusQuarto = statusQuarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(String numQuarto) {
        this.numQuarto = numQuarto;
    }

    public Time getHoraHoraComeco() {
        return horaHoraComeco;
    }

    public void setHoraHoraComeco(Time horaHoraComeco) {
        this.horaHoraComeco = horaHoraComeco;
    }

    public boolean isStatusPortaQuarto() {
        return statusPortaQuarto;
    }

    public void setStatusPortaQuarto(boolean statusPortaQuarto) {
        this.statusPortaQuarto = statusPortaQuarto;
    }

    public boolean isStatusPortaServico() {
        return statusPortaServico;
    }

    public void setStatusPortaServico(boolean statusPortaServico) {
        this.statusPortaServico = statusPortaServico;
    }

    public boolean isStatusGaragem() {
        return statusGaragem;
    }

    public void setStatusGaragem(boolean statusGaragem) {
        this.statusGaragem = statusGaragem;
    }

    public boolean isStatusLuz() {
        return statusLuz;
    }

    public void setStatusLuz(boolean statusLuz) {
        this.statusLuz = statusLuz;
    }
    
    
    
    
}
