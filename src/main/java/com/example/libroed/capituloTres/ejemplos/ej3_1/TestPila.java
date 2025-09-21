package com.example.libroed.capituloTres.ejemplos.ej3_1;

import java.io.*;

//Inicio de la clase TestPila
class TestPila{
    public static void main(String[ ] args)throws IOException
    {
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaPila listaP = new ListaPila();
        listaP.iniciar_pila();
        do{
            System.out.println("1.Almacenar un Numero en la Pila");
            System.out.println("2.Borrar un Numero de la Pila ");
            System.out.println("3.Imprimir Pila");
            System.out.println("4.Salir");    

            System.out.println("digite la opcion");
            opc=Integer.parseInt(Teclado.readLine());
            switch(opc){
                case 1: listaP.insertar_nodo_pila();
                        break;
                case 2: listaP.borrar_nodo_pila();
                        break;
                case 3: listaP.imprimir_pila();
                        break;
            }
        }
        while (opc!=4); 
        listaP.destruir_pila( );        
    }
}
// fin de la clase TestPila
