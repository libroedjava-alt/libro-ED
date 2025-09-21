package com.example.libroed.capituloSies.ejemplos.ej6_1;

import java.io.*; // librería para manejo de archivos

//inicio de clase TestLC
class TestLC{
public static void main(String[ ] args)throws IOException{
    BufferedReader Teclado;
    Teclado=new BufferedReader(new InputStreamReader(System.in));
    int opc;
    ListaCircular listaC = new ListaCircular();
    listaC.iniciar_lista_circular();
    do{
        System.out.println("1.Almacenar un Numero en la Lista Circular");
        System.out.println("2.Borrar un Numero de la Lista Circular ");
        System.out.println("3.Imprimir Lista Circular");
        System.out.println("4.Salir"); 
        System.out.println("digite la opcion");
        opc=Integer.parseInt(Teclado.readLine());
        switch(opc){
            case 1: listaC.insertar_nodo_inicio();
                    break;
            case 2: listaC.borrar_nodo_lista_circular();
                    break;
            case 3: listaC.imprimir_lista_circular();
                    break;
        }
    }
        while (opc!=4); 
    listaC.destruir_lista_circular( );        
}
}// fin de la clase TestLC
