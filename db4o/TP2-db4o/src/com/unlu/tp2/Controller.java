package com.unlu.tp2;

/**
 * @author stefhani cadillo
 * 
 */
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

public class Controller {

     ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"tp2.db");
	
/////////////////////////////////         CRUD         /////////////////////////////	
     
	public Factura crearFactura(int nro, Cliente cli, double importe ) {
		Factura f = new Factura(nro,cli,importe);
		db.store(f);
		db.commit();
		return f;
	}
	 public Cliente createCliente(int id, String descr){
		Cliente c = new Cliente(id,descr);
		 db.store(c);//Crear o Guardar
		 db.commit();
		 return c;
	 }

		 
////////////////////////////// Consultas Base de datos ///////////////// 
	 
	 public void listAllCliente() {
		 ObjectSet<Cliente> cli = db.queryByExample(new Cliente(0, null));
         while (cli.hasNext())
             System.out.println(cli.next());
	 }
	 
	 public void listAllFactura() {
		 ObjectSet<Factura> fact = db.queryByExample(new Factura(0, null));
         while (fact.hasNext()) {
        	 System.out.println(fact.next());
         }
         
	 }
	 

/////////////////// Consultas sobre la DB : Busqueda/////////////////////////////////// 
	 public Cliente buscarClienteXId(int id) {
		 Cliente clien=null;
		 ObjectSet<Cliente> cli = db.queryByExample(new Cliente(id, null));
         while (cli.hasNext()) {
        	 System.out.println(cli.next());
        	 clien=cli.next();
         }
             
        return clien;      
	 }
	 
	 public void buscarClienteXDescr(String  desc) {
		 ObjectSet<Cliente> cli = db.queryByExample(new Cliente(0, desc));
         while (cli.hasNext())
             System.out.println(cli.next());
              
	 }
	 
	 public void buscarFacturaXNro(int nro) {
		 ObjectSet<Cliente> cli = db.queryByExample(new Factura(nro, null,0));
         while (cli.hasNext())
             System.out.println(cli.next());
	 }
	 
	 public void buscarFacturaXImporte(double importe) {
		 ObjectSet<Cliente> cli = db.queryByExample(new Factura(0, null,importe));
         while (cli.hasNext())
             System.out.println(cli.next());
	 }
	 
	 
	 public void consultaxValorImporte(double valor){
		 Query q = db.query();
		 q.constrain(Factura.class);
		 q.descend("importe").constrain(new Double(valor)).greater();
		 ObjectSet result = q.execute();
		 System.out.println(result.toString());
	 }
	
	////////////////////////////// Cierre de DB /////////////////////////////////// 
	
	 public void cierreDB() {
		 db.close();
	} 
	 
	 
	
}
