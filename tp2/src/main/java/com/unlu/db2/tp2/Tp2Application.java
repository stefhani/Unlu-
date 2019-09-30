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
        System.out.println("1: Crear nuevos clientes\n");
        System.out.println("2: Listar clientes\n");
        System.out.println("3: Crear nuevas facturas\n");
        System.out.println("Ingrese cualquier caracter para salir: 0");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        int ingresar = Integer.parseInt(input);
        while(ingresar!=0) {
            switch (ingresar) {
                case 1:
                    String desc = myObj.nextLine();
                    control.createCliente(desc);
                    break;
                case 2:
                    System.out.println("Listado Cliente:\n");
                    System.out.println(control.listAllClient());
                    break;
                case 3:
                    String id = myObj.nextLine();
                    String impo = myObj.nextLine();
                    control.createFactura(Integer.parseInt(id), Double.parseDouble(impo));
                    break;
                case 4:
                    System.out.println("Listado Factura:\n");
                    System.out.println(control.listAllFactura());
                    break;
                default:
                    break;
            }
            input = myObj.nextLine();
            ingresar = Integer.parseInt(input);
       }

	}

}
