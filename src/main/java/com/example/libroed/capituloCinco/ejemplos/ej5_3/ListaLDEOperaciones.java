package com.example.libroed.capituloCinco.ejemplos.ej5_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase LDE
class ListaLDEOperaciones
{
    Nodo cab, fin;
    Nodo movil;
    Nodo po; // puntero que va a referenciar la última operación ingresada
    int cc = 0;
    String datos[] = new String[80];// 100 registro maximos a guardar
    String aux[] = new String[2];// vector utilizado para el método de GuardarDoc
    
    public ListaLDEOperaciones( ){} //constructor de la clase
    
    public void iniciar_lista_doble_encadenada(  )
    {
        cab = null; 
        fin = null;
    }
    
    public int insertar_nodo_LDE(int cod, String ope){
        //validando que no esté repetido
        movil = cab;
        while ((movil != null))
        {
            if (cod == movil.codigo)
                return 1;
            movil = movil.sig;
         }
        Nodo nuevo = new Nodo();
        nuevo.codigo = cod;
        nuevo.operacion = ope;
        if (fin == null)
        {
            cab = fin =nuevo;
            nuevo.ant = nuevo.sig = null;
            po = nuevo;
        }
        else
        {   
            movil = cab;
            nuevo.sig = movil;
            movil.ant = nuevo;
            cab = nuevo;
            nuevo.ant = null;
            po = nuevo;
        }
        return 0;
    }
    
    public void imprimir_lista_fin( )
    {
        int i = 0;
        movil = fin;
        if (movil == null)
            return;
        while(movil != null){
            datos[i] = "Codigo: " + movil.codigo + " Operacion:  " + movil.operacion;
            i++;
            movil = movil.ant;
        }
    }

    public int deshacer_operacion( )
    {
        int i = 0;
        movil = po;
        if (movil.sig == null)
            return 1;
        else{
            movil = movil.sig;
            for (i = 0; i<10 ; i++)
                datos[i] = " ";
            datos[0] = "Codigo: " + movil.codigo + " Operacion Actual:  " + movil.operacion;
            po = movil;
            return 0;
        }
    }

    public int rehacer_operacion( )
    {
        int i = 0;
        movil = po;
        if (movil.ant == null)
            return 1;
        else{
            movil = movil.ant;
            for (i = 0; i<10 ; i++)
                datos[i] = " ";
            datos[0] = "Codigo: " + movil.codigo + " Operacion Actual:  " + movil.operacion;
            po = movil;
            return 0;
        }
    }
    
    public  void destruir_LDE( )
    {
        Nodo borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
        cab = fin = null;
    }
} //Fin de la Clase ListaLDEOperaciones 
