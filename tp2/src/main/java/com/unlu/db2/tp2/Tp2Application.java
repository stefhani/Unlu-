package com.unlu.db2.tp2;

import com.unlu.db2.tp2.controller.Tp2Controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Tp2Application {


    public static void main(String[] args) {
		SpringApplication.run(Tp2Application.class, args);
        Tp2Controller control= new Tp2Controller();
        System.out.println("Inicio de Programa\n");
        System.out.println("1: Crear nuevos clientes:\n");
        System.out.println("2: Listar clientes:\n");
        System.out.println("3: Crear nuevas facturas:\n");
        System.out.println("4: Listar Facturas:\n");
        System.out.println("5: Consultar por ID Cliente:\n");
        System.out.println("6: Consultar por Nro Factura:\n");
        System.out.println("7: Consultar facturas menores al importe:\n");
        System.out.println("8: Consultar por Descripcion del Cliente(no fuciona):\n");
        System.out.println("9: Eliminar una Factura:\n");
        System.out.println("10: Eliminar un Cliente:\n");
        System.out.println("11: Modificar un Cliente:\n");
        System.out.println("Ingrese cualquier caracter para salir: 0");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        int ingresar = Integer.parseInt(input);
        while(ingresar!=0) {
            switch (ingresar) {
                case 1:
                    System.out.println("Ingresar descripcion:\n");
                    String desc = myObj.nextLine();
                    control.createCliente(desc);
                    break;
                case 2:
                    System.out.println("Listado Cliente:\n");
                    System.out.println(control.listAllClient());
                    break;
                case 3:
                    System.out.println("Ingresar Nro de Factura:\n");
                    String nro = myObj.nextLine();
                    System.out.println("Ingresar importe de Factura:\n");
                    String impo = myObj.nextLine();
                    control.createFactura(Integer.parseInt(nro), Double.parseDouble(impo));
                    break;
                case 4:
                    System.out.println("Listado Factura:\n");
                    System.out.println(control.listAllFactura());
                    break;
                case 5:
                    System.out.println("Ingresar Id de Cliente:\n");
                    String idcc = myObj.nextLine();
                    System.out.println("hace algo"+ control.listClientePorId(Integer.parseInt(idcc)));
                    break;
                case 6:
                    System.out.println("Ingresar Nro de Factura:\n");
                    String nrof=myObj.nextLine();
                    System.out.println(control.listFacturaXId(Integer.parseInt(nrof)));
                    break;
                case 7:
                    System.out.println("ingresar el importe:\n");
                    String impoFC = myObj.nextLine();
                    System.out.println(control.listFacturaXImporte(Double.parseDouble(impoFC)));
                    break;
                case 8:
                    System.out.println("ingresar descripcion:\n");
                    String descrC = myObj.nextLine();
                    System.out.println(control.listClienteXDescr(descrC));
                    break;
                case 9:
                    System.out.println("Ingresar Nro de Factura:\n");
                    String nroff=myObj.nextLine();
                    control.deleteFacturaXNro(Long.parseLong(nroff));
                    break;
                case 10:
                    System.out.println("Ingresar Id de Cliente:\n");
                    String idccc = myObj.nextLine();
                    control.deleteClienteXId(Long.parseLong(idccc));
                    break;
                case 11:
                    System.out.println("Ingresar id del cliente a modificar:");
                    String idc1= myObj.nextLine();;
                    System.out.println("Ingresar nueva descripcion Cliente:\n");
                    String descrip = myObj.nextLine();
                    control.updateClienteXId(Long.parseLong(idc1),descrip);
                    break;
                default:
                    break;
            }
            input = myObj.nextLine();
            ingresar = Integer.parseInt(input);
       }

	}

}
