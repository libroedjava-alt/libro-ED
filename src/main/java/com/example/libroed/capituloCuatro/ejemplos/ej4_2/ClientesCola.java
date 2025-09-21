package com.example.libroed.capituloCuatro.ejemplos.ej4_2;

import java.io.*; // libreria para manejo de archivos

//Inicio de la clase ClientesCola
class ClientesCola{

    public static void main(String[ ] args)throws IOException
    {
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaColaClientes listaC = new ListaColaClientes();
        listaC.iniciar_cola();
        do{
            System.out.println("1.Almacenar un Pedido en la cola");
            System.out.println("2.Atender  un pedido de la cola ");
            System.out.println("3.Imprimir pedidos de la cola");
            System.out.println("4.Imprimir la cantidad de pedidos sin atender");
            System.out.println("5.Imprimir la cantidad de pedidos sin atender de un cliente");
            System.out.println("6.Salir"); 
            System.out.println("digite la opcion");
            opc=Integer.parseInt(Teclado.readLine());
            switch(opc){
                case 1: listaC.insertar_NodoC_cola();
                        break;
                case 2: listaC.borrar_NodoC_cola();
                        break;
                case 3: listaC.imprimir_cola();
                        break;
                case 4: listaC.imprimir_cantidad_pedidos();
                        break;
                case 5: listaC.imprimir_cantidad_pedidos_cliente();
                        break;
            }
        }
        while (opc!=6); 
        listaC.destruir_cola( );        
    }
}
// fin de la clase ClientesCola
