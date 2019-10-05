package com.unlu.db2.tp2.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author stefhani
 */
@Entity
@Table(name="Factura")
@NamedQueries({
        @NamedQuery(name="Facturatodos", query="select f from Factura f "),
        @NamedQuery(name="Facturaimporte", query="select f from Factura f where f.importe <= :importe"),
        @NamedQuery(name="Facturaxnro", query="select f from Factura f where f.nro = :nro")
})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nro", nullable=false)
    private Long nro;
    @Column(name="id", nullable=false)
    private int id;
    @Column(name="importe", nullable=false)
    private Double importe;



    public double getImporte(){
        return importe;
    }

    public void setImporte(Double importe){
        this.importe=importe;
    }
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public Long getNro() {
        return nro;
    }

    public void setNro(Long nro) {
        this.nro = nro;
    }



    @Override
    public String toString() {
        return "entity.Factura[ nro=" + nro + " id="+ id + " importe="+ importe + " ]\n";
    }



}
