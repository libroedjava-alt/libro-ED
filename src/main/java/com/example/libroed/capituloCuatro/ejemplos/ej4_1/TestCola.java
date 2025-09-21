package com.example.libroed.capituloCuatro.ejemplos.ej4_1;

import java.io.*; // libreria para manejo de archivos

//Inicio de la clase TestCola
class TestCola{

    public static void main(String[ ] args)throws IOException
    {
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaCola listaC = new ListaCola();
        listaC.iniciar_cola();
        do{
            System.out.println("1.Almacenar un Numero en la cola");
            System.out.println("2.Borrar un Numero de la cola ");
            System.out.println("3.Imprimir cola");
            System.out.println("4.Salir"); 
            System.out.println("digite la opcion");
            opc=Integer.parseInt(Teclado.readLine());
            switch(opc){
                case 1: listaC.insertar_nodo_cola();
                        break;
                case 2: listaC.borrar_nodo_cola();
                        break;
                case 3: listaC.imprimir_cola();
                        break;
            }
        }
        while (opc!=4); 
        listaC.destruir_cola( );        
    }
}
// fin de la clase TestCola
