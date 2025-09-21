package com.example.libroed.capituloSies.ejemplos.ej6_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase ListaCircular
class ListaCircular
{
    Nodo cab;
    Nodo movil;
    Nodo fin;
    int cn;// contador de nodos 
    String datos[] = new String[80];// 100 registros máximo a guardar
    String aux[] = new String[2];// vector que se usa para el método de consultar
    
    public ListaCircular( ){} //constructor de la clase
    
    public void iniciar_lista_circular( )
    {
        cab = null; 
        fin = null;
        cn = 0;
    }
    
    public int insertar_nodo_inicio(int cod, String col){
        //validando que no este repetido
        int nodos = 0;
        movil = cab;
        while ((nodos != cn))
        {
            if (cod == movil.codigo)
                return 1;
            nodos++;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        nuevo.codigo=cod;
        nuevo.color=col;
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
        return 0;
    }

    public void imprimir_lista_circular( )
    {
        int i = 0;
        int nodos = 0;
        movil= cab;
        if (cn == 0)
            return;
        while (nodos != cn){
            datos[i] = "Niño: " + movil.codigo + " de color:  " + movil.color;
            i++;
            nodos++;
            movil= movil.sig;
        }
    }
    
    public  void consultar_color(int cod){ 
    // consultar informacion del color por el codigo
        // ban = 0 no se ha encontrado el registro
        int ban=0;
        int nodos = 0;
        movil = cab;
        while ((nodos != cn)&&(ban==0))
        {
            if (cod == movil.codigo){
                aux[0] = movil.codigo + " ";
                aux[1] = movil.color + " ";
                ban = 1;
            }
            nodos++;
            movil = movil.sig;
        }
        if (ban == 0)
            aux[0] = "no";
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
} //Fin de la Clase ListaCircular 
