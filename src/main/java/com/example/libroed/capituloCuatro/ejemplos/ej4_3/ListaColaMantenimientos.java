package com.example.libroed.capituloCuatro.ejemplos.ej4_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase Cola
class ListaColaMantenimientos
{
    Nodo cab;
    Nodo movil;
    int cc = 0;
    String datos[] = new String[80];// 100 registro máximo a guardar
    String aux[] = new String[4];// vector que usado para el método de consultar
    
    public ListaColaMantenimientos( ){} //constructor de la clase
    public void iniciar_Cola( )
    {
        cab = null; 
    }

    public int insertar_nodo_Cola(int cod, String car, String due, String pro){
        //validando que no este repetido
        movil = cab;
        while ((movil != null))
        {
            if (cod == movil.codigo)
                return 1;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        nuevo.codigo=cod;
        nuevo.caracteristicas=car;
        nuevo.dueno=due;
        nuevo.problema=pro;
        nuevo.sig = cab;
        cab = nuevo; 
        cc++;
        return 0;
    }
    
    public  int borrar_nodo_Cola( )
    {
        Nodo borra;
        movil = cab;
        if (cab == null){
            datos[0] = " ";
            return 1;
        }
        // si solo se tiene un elemento en la cola
        if (movil.sig == null){
            borra = cab;
            cab = movil.sig;
            datos[0] = " ";
            borra= null;// borra nodo
            return 0;
        }
        // si hay más de un nodo en la cola, hay que posicionarse en el 
        // penúltimo elemento de la cola
        while(movil.sig.sig != null)
            movil = movil.sig;
        //redireccionado punteros
        borra = movil.sig;
        movil.sig = borra.sig;
        borra = null;// borra nodo
        cc--;
        return 0;
    } 
    
    public void imprimir_Cola( )
    {
        int i = 0;
        movil= cab;
        if (movil == null)
            return;
        while (movil!=null){
            datos[i] = "Computador: " + movil.codigo + " de caracteristicas:  " + movil.caracteristicas +  " del dueno: " + movil.dueno + " con problemas: " + movil.problema;
            i++;
            movil= movil.sig;
        }
    }

    public  void consultar_computador(int cod){ 
    // consultar informacion del computador por el codigo
        // ban = 0 no se ha encontrado el registro
        int ban=0, cn=0;
        movil = cab;
        while ((movil != null)&&(ban==0))
        {
            if (cod == movil.codigo){
                aux[0] = movil.codigo + " ";
                aux[1] = movil.caracteristicas + " ";
                aux[2] = movil.dueno + " ";
                aux[3] = movil.problema + " ";
                ban = 1;
            }
            movil = movil.sig;
        }
        if (ban == 0)
            aux[0] = "no";
    }
    
    public  void destruir_Cola( )
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
} //Fin de la Clase ListaColaMantenimientos 
