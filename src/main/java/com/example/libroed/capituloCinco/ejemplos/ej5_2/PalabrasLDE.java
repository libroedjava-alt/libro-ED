package com.example.libroed.capituloCinco.ejemplos.ej5_2;

import java.io.*; // librería para manejo de archivos

// inicio de la clase TestLDE
class PalabrasLDE{
public static void main(String[ ] args)throws IOException{
    BufferedReader Teclado;
    Teclado= new BufferedReader(new InputStreamReader(System.in));
    int opc;
    ListaDobleEncadenadaPalabras lista = new ListaDobleEncadenadaPalabras();
    lista.iniciar_lista_doble_encadenada();
    do{
        System.out.println("1.Almacenar una Palabra");
        System.out.println("2.Borrar una Palabra de la oracion mediante la Posicion");
        System.out.println("3.Imprimir la oracion en orden normal al ingreso");
        System.out.println("4.Imprimir la oracion en orden inverso al ingreso");
        System.out.println("5.Imprimir palabra anterior y siguiente");
        System.out.println("6.Salir"); 
        System.out.println("digite la opcion");
        opc=Integer.parseInt(Teclado.readLine());
        switch(opc){
            case 1: lista.insertar_Nodo_inicio();
                    break;
            case 2: lista.borrar_Nodo_posicion();
                    break;
            case 3: lista.imprimir_lista_cab();
                    break;
            case 4: lista.imprimir_lista_fin();
                    break;
            case 5: lista.imprimir_palabra_ant_sig();
                    break;
        }
    }while (opc!=6); 
            lista.destruir_lista_doble_encadenada( );        
}
}// fin de la clase PalabrasLDE
