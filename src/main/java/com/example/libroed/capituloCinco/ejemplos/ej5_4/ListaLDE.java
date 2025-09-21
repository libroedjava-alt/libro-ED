package com.example.libroed.capituloCinco.ejemplos.ej5_4;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

/// inicio de la clase ListaLDE
class ListaLDE{

    Nodo cab;
    Nodo movil;
    Nodo fin;
    Nodo po; // puntero que va a referenciar la última página web visitada
    String datos[] = new String[100];// 100 registro máximos a guardar
    String aux[] = new String[100];// vector utilizado para el método de consultar
    
    public ListaLDE(){} //constructor
    public void iniciar_lista_doble_encadenada(  )
    {
        cab = null; 
        fin = null;
    }
    
    public int insertar_nodo_LDE(int numpw, String pw ){
        //validando que no este repetido
        movil = cab;
        while ((movil != null))
        {
            if (numpw == movil.numpagweb)
                return 1;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        nuevo.numpagweb = numpw;
        nuevo.paginaweb = pw;
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
    
    public void imprimir_lista_fin( )
    {
        int i = 0;
        movil = fin;
        if (movil == null)
            return;
        while(movil != null){
            datos[i] = "Numero: " + movil.numpagweb + " Pagina web:  " + movil.paginaweb;
            i++;
            movil = movil.ant;
        }
    }
    
    public int anterior_pagina( )
    {
        int i = 0;
        movil = po;
        if (movil.sig == null)
            return 1;
        else{
            movil = movil.sig;
            for (i = 0; i<10 ; i++)
                datos[i] = " ";
            datos[0] = "Numero: " + movil.numpagweb + " Pagina web Actual:  " + movil.paginaweb;
            po = movil;
            return 0;
        }
    }

    public int siguiente_pagina( )
    {
        int i = 0;
        movil = po;
        if (movil.ant == null)
            return 1;
        else{
            movil = movil.ant;
            for (i = 0; i<10 ; i++)
                datos[i] = " ";
            datos[0] = "Numero: " + movil.numpagweb + " Pagina web Actual:  " + movil.paginaweb;
            po = movil;
            return 0;
        }
    }

    public void trasladar( ){ // método que pasa la información del archivo a la lista
        DataInputStream archivo = null;
        Nodo nuevo;
        Registro R=new Registro();
        try{
            //* abriendo archivo para lectura */
            archivo = new DataInputStream( new FileInputStream("c\\Prueba\\paginawebs.txt") );
            //leyendo archivo 
            while (true) {
                //leyendo registro
                   nuevo = new Nodo();
                nuevo.numpagweb=archivo.readInt();
                nuevo.paginaweb= archivo.readUTF();
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
            }
        } 
        catch(FileNotFoundException fnfe) { /*Archivo no encontrado*/ }
        catch (IOException ioe) { /* Error al escribir */ }
        finally {
            if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
        }
    }
} // fin de la clase ListaLDE
