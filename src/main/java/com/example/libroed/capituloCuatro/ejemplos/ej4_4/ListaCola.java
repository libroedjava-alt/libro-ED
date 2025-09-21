package com.example.libroed.capituloCuatro.ejemplos.ej4_4;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

/// inicio de la clase ListaCola
class ListaCola{

    Nodo cab;
    Nodo movil;
    String datos[] = new String[100];// 100 registro máximos a guardar
    String aux[] = new String[100];// vector usado para el método de consultar
    
    public ListaCola(){} //constructor
    
    public void iniciar_Cola( )
    {
        cab = null; 
    }
    
    public  void consultar_informacion_recurso(String s){
        int i = 0;
        int ban = 0;
        movil = cab;
        while ((movil != null))
        {
            if (s.equals(movil.recurso))
            {
                aux[i] = movil.recurso + ", " + movil.numrecurso + ", " + movil.usuario;
                i++;
                ban = 1;
            }
            movil = movil.sig;
        }
        if (ban == 0)
            aux[0] = "no";

    }

    public int insertar_nodo_Cola(int nr, String r, String u)
    {
        //validando que no este repetido
        movil = cab;
        while ((movil != null))
        {
            if (nr == movil.numrecurso)
                return 1;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        nuevo.recurso= r;
        nuevo.numrecurso=nr;
        nuevo.usuario=u;
        nuevo.sig = cab;
        cab = nuevo; 
        return 0;
    }
    
    public void imprimir_Cola( )
    {
        int i = 0;
        movil= cab;
        if (movil == null)
            return;
        while (movil!=null){
            datos[i] = "Numero = " + movil.numrecurso + ", Recurso = " + movil.recurso + ", Usuario = " + movil.usuario;
            i++;
            movil= movil.sig;
        }
    }

    public  void destruir_Cola( ){
        Nodo borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
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
        while (movil.sig.sig != null)
            movil = movil.sig;
        // redireccionado punteros
        borra = movil.sig;
        movil.sig = borra.sig;
        borra = null;// borra nodo
        return 0;
    } 

    public void trasladar( ){ // método que pasa la información del archivo a la lista
        DataInputStream archivo = null;
        Nodo nuevo;
        Registro R=new Registro();
        try{
            //* abriendo archivo para lectura */
            archivo = new DataInputStream( new FileInputStream("c\\Prueba\\recursos.txt") );
            //leyendo archivo 
            while (true) {
                //leyendo registro
                nuevo = new Nodo();
                nuevo.numrecurso=archivo.readInt();
                nuevo.recurso= archivo.readUTF();
                nuevo.usuario=archivo.readUTF();
                nuevo.sig = cab;
                cab = nuevo; 
             }
        } 
        catch(FileNotFoundException fnfe) { /*Archivo no encontrado*/ }
        catch (IOException ioe) { /* Error al escribir */ }
        finally {
            if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
        }
    }
} // fin de la clase ListaCola
