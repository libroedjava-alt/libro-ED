package com.example.libroed.capituloCinco.ejemplos.ej5_2;

import java.io.*; // librería para manejo de archivos

// inicio de la clase ListaDobleEncadenadaPalabras
class ListaDobleEncadenadaPalabras{

    NodoP cab;
    NodoP movil;
    NodoP fin;

    public ListaDobleEncadenadaPalabras( ){} //constructor
    
    public void iniciar_lista_doble_encadenada(  )
    {
        cab = null; 
        fin = null;
    }

    public void insertar_Nodo_inicio()throws IOException
    {
        BufferedReader Teclado;
        Teclado= new BufferedReader(new InputStreamReader(System.in));
        NodoP nuevo = new NodoP();
        System.out.println("Digite la palabra: ");
        nuevo.palabra = (Teclado.readLine());
        nuevo.longitud=nuevo.palabra.length();// halla longitud de la palabra
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
    
    public  void borrar_Nodo_posicion( )throws IOException{
        int cn, pos;
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        cn = 1;
        NodoP borra;
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
                     {
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
        }
        else
            System.out.println("NO hay NodoPs");
    } 
    
    public void imprimir_lista_cab(  )
    {
        movil = cab;
        while(movil != null){
            System.out.println("palabra: " + movil.palabra + " " + " longitud: " + movil.longitud );
            movil = movil.sig;
        }
    }

    public void imprimir_lista_fin(  )
    {
        movil = fin;
        while(movil != null){
            System.out.println("palabra: " + movil.palabra + " " + " longitud: " + movil.longitud );
            movil = movil.ant;
        }
    }
    
    public void imprimir_palabra_ant_sig(  )throws IOException
    {
        String pal = new String(""); 
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite la palabra: ");
        pal = (Teclado.readLine());
        movil = cab;
        while(movil != null){
            if (pal.equals(movil.palabra)){
                if (movil.sig!=null)
                    System.out.println("palabra anterior: " + movil.sig.palabra + " " + " longitud: " + movil.sig.longitud );
                else
                    System.out.println("No hay palabra anterior"  );
                if (movil.ant!=null)
                System.out.println("palabra siguiente: " + movil.ant.palabra + " " + " longitud: " + movil.ant.longitud );
                else
                    System.out.println("No hay palabra siguiente"  );
            }     
            movil = movil.sig;
        }
    }

    public  void destruir_lista_doble_encadenada( ){
        NodoP borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
    }
} //fin de la clase ListaDobleEncadenada
