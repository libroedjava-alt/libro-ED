package com.example.libroed.capituloTres.ejemplos.ej3_2;

import java.io.*;

//Inicio de la clase PilaDiscos
class ListaPilaDiscos
{
    NodoD cab;
    NodoD movil;
    
    public ListaPilaDiscos( ){} //constructor de la clase
    public void iniciar_pila( )
    {
        cab = null; 
    }

    public void insertar_NodoD_pila()throws IOException{
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        NodoD nuevo = new NodoD();
        System.out.println("Digite el nombre de la cancion: ");
        nuevo.cancion=(Teclado.readLine());
        System.out.println("Digite el nombre del grupo: ");
        nuevo.grupo=(Teclado.readLine());
        nuevo.sig = cab;
        cab = nuevo; 
    }

    public  void borrar_NodoD_pila( )
    {
        NodoD borra;
        movil = cab;
        if (cab == null){
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        if (movil != null){
            borra = cab;
            cab = movil.sig;
            System.out.println("Cancion a escuchar: " + borra.cancion + " del grupo: " + borra.grupo);
            borra= null;// borra NodoD
        } 
    } 

    public void imprimir_pila( )
    {
        movil = cab;
        while(movil != null){
            System.out.println("cancion: " + movil.cancion + " del grupo: " + movil.grupo);
            movil = movil.sig;
        }
    }

    public void imprimir_canciones_grupo( )throws IOException
    {
        String grup = new String("");
        BufferedReader Teclado;
        Teclado=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite el nombre del grupo: ");
        grup=(Teclado.readLine());
        movil = cab;
        while(movil != null){
            if (grup.equals(movil.grupo))
                System.out.println("cancion: " + movil.cancion);
            movil = movil.sig;
        }
    }

    public void imprimir_cantidad_discos( )
    {
        int cd = 0;
        movil = cab;
        while(movil != null){
            cd++;
            movil = movil.sig;
        }
        System.out.println("Numero de Discos: " + cd);
    }

    public  void destruir_pila( )
    {
        NodoD borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
    }
} //Fin de la Clase ListaPilaDiscos 
