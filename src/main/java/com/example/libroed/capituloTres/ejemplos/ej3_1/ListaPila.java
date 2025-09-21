package com.example.libroed.capituloTres.ejemplos.ej3_1;

import java.io.*;

//Inicio de la clase Pila
class ListaPila
{
    Nodo cab;
    Nodo movil;
    
    public ListaPila( ){} //constructor de la clase

    public void iniciar_pila( )
    {
        cab = null; 
    }

    public void insertar_nodo_pila()throws IOException{
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        Nodo nuevo = new Nodo();
        System.out.println("Digite el numero: ");
        nuevo.dato=Integer.parseInt(Teclado.readLine());
        nuevo.sig = cab;
        cab = nuevo; 
    }

    public  void borrar_nodo_pila( )
    {
        Nodo borra;
        movil = cab;
        if (cab == null){
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        if (movil != null){
            borra = cab;
            cab = movil.sig;
            borra= null;// borra nodo
        } 
    } 

    public void imprimir_pila( )
    {
        movil = cab;
        while(movil != null){
            System.out.println(movil.dato + " ");
            movil = movil.sig;
        }
    }

    public  void destruir_pila( )
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
} //Fin de la Clase ListaPila 
