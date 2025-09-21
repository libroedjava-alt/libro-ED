package com.example.libroed.capituloTres.ejemplos.ej3_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase que representa la Pila de camisas
class ListaPilaCamisas
{
    Nodo cab;
    Nodo movil;
    int cc = 0;
    String datos[] = new String[80];// 100 registro máximos a guardar
    String aux[] = new String[2];// vector que se usa para el método de consultar
    
    public ListaPilaCamisas( ){} //constructor de la clase

    public void iniciar_pila( )
    {
        cab = null; 
    }

    public int insertar_nodo_pila(int cod, String col){
        //validando que no esté repetido
        movil = cab;
        while ((movil != null))
        {
            if (cod == movil.codigo)
                return 1;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        if (cc <= 80){ // valida que no sean más de 80 camisas
            nuevo.codigo=cod;
            nuevo.color=col;
            nuevo.sig = cab;
            cab = nuevo; 
            cc++;
            return 0;
        }
        else
            return 2;
    }

    public  int borrar_nodo_pila( )
    {
        Nodo borra;
        movil = cab;
        if (cab == null){
            datos[0] = " ";
            return 1;
        }
        if (movil != null){
            borra = cab;
            cab = movil.sig;
            borra= null;// borra nodo
            cc--;
            if (cab == null)
                datos[0] = " ";
            return 0;
        } 
        return 0;
    } 

    public void imprimir_pila( )
    {
        int i = 0;
        movil= cab;
        if (movil == null)
            return;
        while (movil!=null){
            datos[i] = "Camisa: " + movil.codigo + " de color:  " + movil.color;
            i++;
            movil= movil.sig;
        }
    }

    public  void consultar_camisa(int cod){ 
    // consultar información de la camisa por el código
    // ban = 0 no se ha encontrado el registro
        int ban=0, cn=0;
        movil = cab;
        while ((movil != null)&&(ban==0))
        {
            if (cod == movil.codigo){
                aux[0] = movil.codigo + " ";
                aux[1] = movil.color + " ";
                ban = 1;
            }
            movil = movil.sig;
        }
        if (ban == 0)
            aux[0] = "no";
    }

    public  void destruir_pila( )
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
} //Fin de la Clase ListaPilaCamisas 
