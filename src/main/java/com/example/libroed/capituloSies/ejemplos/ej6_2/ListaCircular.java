package com.example.libroed.capituloSies.ejemplos.ej6_2;

import java.io.*; // librería para manejo de archivos

//inicio de la clase ListaCircular 
class ListaCircular{

    NodoR cab;
    NodoR movil;
    NodoR fin;
    int cn;// contador de NodoRs
    int puntaje;
    
    public ListaCircular(){} //constructor
    
    public void iniciar_lista_circular( )
    {
        cab = null; 
        fin = null;
        cn = 0;
        puntaje = 0;
    }
    
    public void insertar_NodoR_inicio()throws IOException
    {
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        NodoR nuevo = new NodoR();
        System.out.println("Digite el numero: ");
        nuevo.dato=Integer.parseInt(Teclado.readLine());
        //redireccionando
        if (cab == null){
            cab = nuevo;
            nuevo.sig = nuevo; 
            fin = nuevo;
        }
        else{
            nuevo.sig = cab;
            cab = nuevo; 
            fin.sig = cab; 
        }
        cn++;
    }
    
    public void imprimir_lista_circular( )
    {
        int NodoRs = 0;
        movil = cab;
        while(NodoRs != cn){ 
            System.out.println(movil.dato + " ");
            movil = movil.sig;
            NodoRs++;
        }
    }
    
    public void jugar( )throws IOException
    {
        int pos = 0, num = 0, NodoRs = 1;
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite un numero de posiciones a moverse en la ruleta: ");
        pos=Integer.parseInt(Teclado.readLine());
        movil = cab;
        while(NodoRs < pos){ 
            movil = movil.sig;
            NodoRs++;
        }
        System.out.println("Digite el numero adivinar: ");
        num=Integer.parseInt(Teclado.readLine());
        
        if (movil.dato == num){
            System.out.println("Gano...");
            puntaje++;
        }
        else{
            System.out.println("Perdio...");
            puntaje--;
        }
    }

    public void imprimir_puntaje( )
    {
        System.out.println("Puntaje = " + puntaje);
    }

    public  void destruir_lista_circular( ){
        NodoR borra;
        borra = cab;
        movil = cab;
        while(cn > 0){
            movil = movil.sig;
            borra = null;
            borra = movil;
            cn--;
        }
    }
} 
// fin de la clase ListaCircular 
