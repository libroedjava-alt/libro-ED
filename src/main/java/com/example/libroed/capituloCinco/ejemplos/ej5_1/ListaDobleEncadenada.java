package com.example.libroed.capituloCinco.ejemplos.ej5_1;

import java.io.*; // librería para manejo de archivos

// inicio de la clase ListaDobleEncadenada
class ListaDobleEncadenada{

    Nodo cab;
    Nodo movil;
    Nodo fin;

    public ListaDobleEncadenada( ){} //constructor
    
    public void iniciar_lista_doble_encadenada(  )
    {
        cab = null; 
        fin = null;
    }

    public void insertar_nodo_inicio()throws IOException
    {
        BufferedReader Teclado;
        Teclado= new BufferedReader(new InputStreamReader(System.in));
        Nodo nuevo = new Nodo();
        System.out.println("Digite el numero: ");
        nuevo.dato=Integer.parseInt(Teclado.readLine());
        if (fin == null)
        {
            cab = fin =nuevo;
            nuevo.ant = nuevo.sig = null;
        }
        else
        {   
            movil = cab;
            nuevo.sig = movil;
            movil.ant = nuevo;
            cab = nuevo;
            nuevo.ant = null;
        }
    }
    
    public  void borrar_nodo_posicion( )throws IOException{
        int cn, pos;
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        cn = 1;
        Nodo borra;
        if (cab == null){
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        System.out.println("Digite la posicion: ");
        pos = Integer.parseInt(Teclado.readLine());
        movil = cab;
        if (cab != null)
        {
             if ((pos == 1)&&(movil.sig == null))
             {
                borra = movil;
                cab = null;
                fin = null;
                borra = null;
             }
        else
            if ((pos == 1)&&(movil.sig != null))
            {
                borra = movil;
                movil = movil.sig;
                cab = movil;
                movil.ant = null;
                borra = null;
            }
            else
                while (movil != null)
                {
                    if (cn + 1 == pos)
                    {
                        borra = movil.sig;
                        movil.sig = borra.sig;
                        if (fin == borra)
                            fin = movil;
                        if (movil.sig != null)
                        {
                            movil = movil.sig;
                            movil.ant = borra.ant;
                        }
                        borra = null;
                    }
                    movil= movil.sig;
                    cn++;
                }
        }
        else
            System.out.println("NO hay nodos");
    } 

    public void imprimir_lista_cab(  )
    {
        movil = cab;
        while(movil != null){
            System.out.println(movil.dato + " ");
            movil = movil.sig;
        }
    }

    public void imprimir_lista_fin(  )
    {
        movil = fin;
        while(movil != null){
            System.out.println(movil.dato + " ");
            movil = movil.ant;
        }
    }
    
    public  void destruir_lista_doble_encadenada( ){
        Nodo borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
    }
} // fin de la clase ListaDobleEncadenada
