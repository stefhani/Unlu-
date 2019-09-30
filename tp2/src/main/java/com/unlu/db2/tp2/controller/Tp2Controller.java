package com.unlu.db2.tp2.controller;

import com.unlu.db2.tp2.entity.Cliente;
import com.unlu.db2.tp2.entity.Factura;
import com.unlu.db2.tp2.persistir.Dao;

import java.util.List;

public class Tp2Controller {

    Dao persis= new Dao();

    //Create nuevo cliente
    public void createCliente(String descrip){
        Cliente cli = new Cliente();
        cli.setName(descrip);
        persis.persist(cli);
    }

    //Create nueva factura
    public void createFactura( int id,double importe){
        Factura fac = new Factura();
        fac.setId(id);
        fac.setImporte(importe);
        persis.persist(fac);
    }

    public List<Cliente> listAllClient(){
        Dao per = new Dao();
       return  per.listarClientes();
    }

    public List<Factura> listAllFactura(){
        Dao per = new Dao();
        return  per.listarFacturas();
    }
}
