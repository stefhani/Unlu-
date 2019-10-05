package com.unlu.db2.tp2.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author stefhani cadillo
 */
@Entity
@Table(name="Cliente")
@NamedQueries({
        @NamedQuery(name="Clientetodos", query="select c from Cliente c"),
        @NamedQuery(name="Clienteporid", query="select c from Cliente c where c.id = :id")
       // @NamedQuery(name="ClienteXDescr", query="select c from Cliente c where c.descr LIKE :id ")
})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable=false)
    private Long id;
    @Column(name="descr", nullable=false)
    private String name;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }


    @Override
    public String toString() {
        return "entity.Cliente[ id=" + id + " nombre="+ name +"]\n";
    }

}
