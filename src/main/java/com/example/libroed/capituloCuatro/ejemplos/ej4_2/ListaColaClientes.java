package com.example.libroed.capituloCuatro.ejemplos.ej4_2;

import java.io.*; // libreria para manejo de archivos

//Inicio de la clase ColaClientes
class ListaColaClientes
{
    NodoC cab;
    NodoC movil;
    
    public ListaColaClientes( ){} //constructor de la clase
    
    public void iniciar_cola( )
    {
        cab = null; 
    }

    public void insertar_NodoC_cola()throws IOException{
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        NodoC nuevo = new NodoC();
        System.out.println("Digite el codigo: ");
        nuevo.codigo=Integer.parseInt(Teclado.readLine());
        System.out.println("Digite la descripcion del pedido: ");
        nuevo.pedido=(Teclado.readLine());
        System.out.println("Digite el nombre del cliente: ");
        nuevo.cliente=(Teclado.readLine());
        nuevo.sig = cab;
        cab = nuevo; 
    }

    public  void borrar_NodoC_cola( )
    {
        NodoC borra;
        movil = cab;
        if (cab == null){
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        // si solo se tiene un elemento en la cola
        if (movil.sig == null){
            borra = cab;
            cab = movil.sig;
            System.out.println("Pedido atendido: " + borra.codigo + ", descripcion: " + borra.pedido +  ", cliente: " + borra.cliente);
            borra= null;// borra NodoC
            return;
        }
        // si hay más de un NodoC en la cola, hay que posicionarse en el 
        // penúltimo elemento de la cola
        while(movil.sig.sig != null)
            movil = movil.sig;
        //redireccionado punteros
        borra = movil.sig;
        movil.sig = borra.sig;
        System.out.println("Pedido atendido: " + borra.codigo + ", descripcion: " + borra.pedido +  ", cliente: " + borra.cliente);
        borra= null;// borra NodoC
            
    } 
    
    public void imprimir_cola( )
    {
        movil = cab;
        while(movil != null){
            System.out.println("Pedido: " + movil.codigo + ", descripcion: " + movil.pedido +  ", cliente: " + movil.cliente);
            movil = movil.sig;
        }
    }

    public void imprimir_cantidad_pedidos( )
    {
        int cp = 0;
        movil = cab;
        while(movil != null){
            cp++;
            movil = movil.sig;
        }
        System.out.println("Cantidad de pedidos= " + cp);
    }

    public void imprimir_cantidad_pedidos_cliente( )throws IOException
    {
        int cp = 0;
        String cli = new String("");
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite el cliente: ");
        cli=(Teclado.readLine());
        movil = cab;
        while(movil != null){
            if (cli.equals(movil.cliente))
                cp++;
            movil = movil.sig;
        }
        System.out.println("Cantidad de pedidos = " + cp + " del cliente: " + cli);
    }

    public  void destruir_cola( )
    {
        NodoC borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
    }
} //Fin de la Clase ListaColaClientes 
