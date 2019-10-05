package com.unlu.tp2;

/**
 * @author stefhani cadillo
 * 
 */
import java.util.Scanner;
import com.db4o.*;
import com.db4o.cs.*;
import com.db4o.query.*;


public class Main {
	static Controller control = new Controller();
	 public static void main(String[] args) {
	        System.out.println("Inicio de Programa\n");
	        System.out.println("1: Crear nuevos clientes:\n");
	        System.out.println("2: Buscar por id cliente:\n");
	        System.out.println("3: Buscar por descripcions cliente:\n");
	        System.out.println("4: Crear nuevas facturas:\n");
	        System.out.println("5: Busqueda facturas:\n");
	        System.out.println("6: Listado de clientes persistido:\n");
	        System.out.println("7: Listado de facturas persistido:\n");
	        System.out.println("8: Consultar importe de factura mayores al valor indicado:\n");
	        System.out.println("Ingrese cualquier caracter para salir: 0");
	        Scanner myObj = new Scanner(System.in);
	        String input = myObj.nextLine();
	        int ingresar = Integer.parseInt(input);
	        while(ingresar!=0) {
	            switch (ingresar) {
	                case 1:
	                	System.out.println("Ingrese id identificacion:\n");
	                	int id = Integer.parseInt(myObj.nextLine());
	                	System.out.println("Ingrese descripcion:\n");
	                    String desc = myObj.nextLine();
	                    System.out.println(control.createCliente(id, desc).toString());
	                    break;
	                case 2:
	                    System.out.println("buscar Cliente:\n");
	                    System.out.println("ingresar id Cliente:\n");
	                    String idc = myObj.nextLine();
	                    control.buscarClienteXId(Integer.parseInt(idc));
	                    break;
	                case 3:
	                    System.out.println("buscar Cliente:\n");
	                    System.out.println("ingresar descripcion Cliente:\n");
	                    String descrC = myObj.nextLine();
	                    control.buscarClienteXDescr(descrC);
	                    break;     
	                case 4:
	                	System.out.println("Ingrese nro de factura:\n");
	                	String nro = myObj.nextLine();
	                	System.out.println("Ingrese id identificacion:\n");
	                    String idf = myObj.nextLine();
	                    System.out.println("Ingrese descripcion:\n");
	                    String descrF = myObj.nextLine();
	                    System.out.println("Ingrese importe:\n");
	                    String impo= myObj.nextLine();
	                    //buscar el cliente elegido:
	                    Cliente buscarCli= new Cliente(Integer.parseInt(idf),descrF);
	                    Factura fac =control.crearFactura(Integer.parseInt(nro),buscarCli, Double.parseDouble(impo));
	                    System.out.println(fac.toString());
	                    break;
	                case 5:
	                    System.out.println("Busqueda de factura:\n");
	                    String nro1 = myObj.nextLine();
	                    Factura f = new Factura(Integer.parseInt(nro1),null,0);
	                   
	                    break;
	                case 6:
	                    System.out.println("Listado de Clientes:\n");
	                    control.listAllCliente();
	                    break;   
	                case 7:
	                    System.out.println("Listado de Clientes:\n");
	                    control.listAllFactura();
	                    break;    
	                case 8:
	                    System.out.println("Consulta de importe mayores a :\n");
	                    System.out.println("Ingrese importe a consultar:\n");
	                    String impot = myObj.nextLine();
	                    control.consultaxValorImporte(Double.parseDouble(impot));
	                    break;        
	                default:
	                	System.out.println("Cierre de bd db4o1");
	                	 control.cierreDB();
	                    break;
	            }
	            input = myObj.nextLine();
	            ingresar = Integer.parseInt(input);
	       }

		}
}
