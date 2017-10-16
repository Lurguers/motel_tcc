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
public class Admin extends User{
    @Column
    private boolean adm;
    public Admin(String username, String senha) {
        super(username, senha);
        this.adm = true;
    }

    public Admin() {
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    } 
}
