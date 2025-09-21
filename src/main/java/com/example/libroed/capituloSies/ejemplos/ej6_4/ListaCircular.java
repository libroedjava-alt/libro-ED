package com.example.libroed.capituloSies.ejemplos.ej6_4;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

/// inicio de la clase ListaCircular
class ListaCircular{

    Nodo cab;
    Nodo movil;
    Nodo fin;
    int cn;// contador de nodos 
    String datos[] = new String[100];// 100 registros máximo a guardar
    String aux[] = new String[100];// vector usado para el método de consultar
    
    public ListaCircular(){} //constructor
    
    public void iniciar_lista_circular( )
    {
        cab = null; 
        fin = null;
        while (cn < 12){
            Nodo nuevo = new Nodo();
            nuevo.posicion= cn + 1;
            nuevo.nombre="vacio";
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
    }
    
    public  void consultar_informacion_nombre(String s){
        int i = 0;
        int ban = 0;
        movil = cab;
        while (i <= cn)
        {
            if (s.equals(movil.nombre))
            {
                aux[0] = movil.nombre + ", " + movil.posicion ;
                ban = 1;
            }
            movil = movil.sig;
            i++;
        }
        if (ban == 0)
            aux[0] = "no";
    }

    public int insertar_nodo_inicio(int p, String n)
    {
        int i = 0;
        //validando que no esté repetido
        movil = cab;
        while((i < 12)){
            if (movil.posicion == p)
                if (movil.nombre.equals("vacio")){
                    movil.nombre = n;
                    return 0;
                }
            movil = movil.sig;
            i++;
        }
        return 1;
    }
    
    public void imprimir_lista_circular( )
    {
        int i = 0;
        movil= cab;
        if (cn == 0)
            return;
        while (i < cn){
            datos[i] = "posicion = " + movil.posicion + ", nombre = " + movil.nombre;
            i++;
            movil= movil.sig;
        }
    }
    
    public  void destruir_lista_circular( )
    {
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
    
    public void trasladar( ){ // método que pasa la información del archivo a la lista
        DataInputStream archivo = null;
        Nodo nuevo;
        Registro R=new Registro();
        try{
            //* abriendo archivo para lectura */
            archivo = new DataInputStream( new FileInputStream("c\\Prueba\\carrusel.txt") );
            //leyendo archivo 
            while (true) {
                //leyendo registro
                nuevo = new Nodo();
                nuevo.nombre= archivo.readUTF();
                nuevo.posicion=archivo.readInt();
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
} // fin de la clase ListaCircular
