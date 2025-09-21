package com.example.libroed.capituloSies.ejemplos.ej6_1;

import java.io.*; // librería para manejo de archivos

//inicio de la clase ListaCircular 
class ListaCircular{

    Nodo cab;
    Nodo movil;
    Nodo fin;
    int cn;// contador de nodos
    
    public ListaCircular(){} //constructor

    public void iniciar_lista_circular( )
    {
        cab = null; 
        fin = null;
        cn = 0;
    }

    public void insertar_nodo_inicio()throws IOException
    {
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        Nodo nuevo = new Nodo();
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
    
    public  void borrar_nodo_lista_circular()throws IOException{
        Nodo borra;
        BufferedReader Teclado;
        int pos, c ;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        movil = cab;
        c = 2;
        if (cab == null){
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        if (cn > 0){
            System.out.println("Digite la posicion: ");
            pos=Integer.parseInt(Teclado.readLine());
            if (pos == 1){
                borra = movil;
                movil = movil.sig;
                cab = movil;
                fin.sig = cab;
                borra = null;
                cn--;
            }
            else
            if(cn == pos){
                borra = movil;
                borra = borra.sig;
                while(borra != fin){
                    movil = movil.sig;
                    borra = borra.sig; 
                } 
                movil.sig = borra.sig;
                borra = null;
                fin = movil;
                cn--;
            }
            else
            if ((pos > 1) && ( pos < cn)){
                borra = movil;
                borra = borra.sig;
                if (pos > 2) 
                while(pos != c) 
                {
                    movil = movil.sig;
                    borra = borra.sig; 
                    c++;
                } 
                movil.sig = borra.sig;
                borra = null;
                cn--;
            }
        } 
    } 
    public void imprimir_lista_circular( )
    {
        int nodos = 0;
        movil = cab;
        while(nodos != cn){ 
            System.out.println(movil.dato + " ");
            movil = movil.sig;
            nodos++;
        }
    }
    
    public  void destruir_lista_circular( ){
        Nodo borra;
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
