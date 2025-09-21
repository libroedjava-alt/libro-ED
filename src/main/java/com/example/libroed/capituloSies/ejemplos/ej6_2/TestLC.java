package com.example.libroed.capituloSies.ejemplos.ej6_2;

import java.io.*; // librería para manejo de archivos

//inicio de clase RuletaLC
class TestLC{
public static void main(String[ ] args)throws IOException{
    BufferedReader Teclado;
    Teclado=new BufferedReader(new InputStreamReader(System.in));
    int opc;
    ListaCircular listaC = new ListaCircular();
    listaC.iniciar_lista_circular();
    do{
        System.out.println("1.Almacenar un Numero en la Ruleta (Jugador 1)");
        System.out.println("2.Jugar (Jugador 2)");
        System.out.println("3.Imprimir Numeros en la Ruleta");
        System.out.println("4.Imprimir Puntaje");
        System.out.println("5.Salir"); 
        System.out.println("digite la opcion");
        opc=Integer.parseInt(Teclado.readLine());
        switch(opc){
            case 1: listaC.insertar_NodoR_inicio();
                    break;
            case 2: listaC.jugar();
                    break;
            case 3: listaC.imprimir_lista_circular();
                    break;
            case 4: listaC.imprimir_puntaje();
                    break;
        }
    }
      while (opc!=5); 
    listaC.destruir_lista_circular( );        
}
}// fin de la clase RuletaLC
