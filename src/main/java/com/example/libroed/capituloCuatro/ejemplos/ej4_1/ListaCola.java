package com.example.libroed.capituloCuatro.ejemplos.ej4_1;

import java.io.*; // libreria para manejo de archivos

//Inicio de la clase Cola
class ListaCola
{
    Nodo cab;
    Nodo movil;
    
    public ListaCola( ){} //constructor de la clase
    public void iniciar_cola( )
    {
        cab = null; 
    }

    public void insertar_nodo_cola()throws IOException{
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        Nodo nuevo = new Nodo();
        System.out.println("Digite el numero: ");
        nuevo.dato=Integer.parseInt(Teclado.readLine());
        nuevo.sig = cab;
        cab = nuevo; 
    }
    
    public  void borrar_nodo_cola( )
    {
        Nodo borra;
        movil = cab;
        if (cab == null){
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        // si solo se tiene un elemento en la cola
        if (movil.sig == null){
            borra = cab;
            cab = movil.sig;
            borra= null;// borra nodo
            return;
        }
        // si hay más de un nodo en la cola, se tiene que posicionar en el penúltimo 
        // elemento de la cola
        while(movil.sig.sig != null)
            movil = movil.sig;
        //redireccionado punteros a los nodos
        borra = movil.sig;
        movil.sig = borra.sig;
        borra= null;// borra nodo
    } 

    public void imprimir_cola( )
    {
        movil = cab;
        while(movil != null){
            System.out.println(movil.dato + " ");
            movil = movil.sig;
        }
    }

    public  void destruir_cola( )
    {
        Nodo borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
    }
} //Fin de la Clase ListaCola 
