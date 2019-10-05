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

    public List<Factura> listFacturaXImporte(double importe){
        Dao per = new Dao();
        return  per.listarFacturasXImporte(importe);
    }

    public List<Cliente> listClienteXDescr(String descr){
        Dao per = new Dao();
        return  per.listarClienteXDescr(descr);
    }

    public List<Cliente> listClientePorId(int id){
        Dao per = new Dao();
        return  per.listarClientePorId(id);
    }

    public List<Factura> listFacturaXId(int nro){
        Dao per = new Dao();
        return  per.listarFacturasXId(nro);
    }

    public void deleteFacturaXNro(Long nro){
        Dao per = new Dao();
        per.deleteFacturaXNro(nro);
    }

    public void deleteClienteXId(Long id){
        Dao per = new Dao();
        per.deleteClienteXId(id);
    }

    public void updateClienteXId(Long id,String descr){
        Dao per = new Dao();
        per.updateClienteXId(id,descr);
    }

}
