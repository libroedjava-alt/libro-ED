package com.example.libroed.capituloTres.ejemplos.ej3_2;

import java.io.*;

//Inicio de la clase DiscosPila
class DiscosPila{
    public static void main(String[ ] args)throws IOException
    {
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaPilaDiscos listaP = new ListaPilaDiscos();
        listaP.iniciar_pila();
        do{
            System.out.println("1.Almacenar un Disco en la Pila");
            System.out.println("2.Escuchar Disco ");
            System.out.println("3.Imprimir lista de Discos");
            System.out.println("4.Imprimir canciones de un grupo");
            System.out.println("5.Imprimir numero de Discos");
            System.out.println("6.Salir"); 

            System.out.println("digite la opcion");
            opc=Integer.parseInt(Teclado.readLine());
            switch(opc){
                case 1: listaP.insertar_NodoD_pila();
                        break;
                case 2: listaP.borrar_NodoD_pila();
                        break;
                case 3: listaP.imprimir_pila();
                        break;
                case 4: listaP.imprimir_canciones_grupo();
                        break;
                case 5: listaP.imprimir_cantidad_discos();
                        break;
            }
        }
        while (opc!=6); 
        listaP.destruir_pila( );        
    }
}
// fin de la clase DiscosPila
