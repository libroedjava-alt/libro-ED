package com.example.libroed.capituloTres.ejemplos.ej3_4;

import java.io.*;

/// inicio de la clase ListaPila
class ListaPila{

    Nodo cab;
    Nodo movil;
    String datos[] = new String[100];// 100 registro máximos a guardar
    String aux[] = new String[100];// vector que usado para el método de consultar
    
    public ListaPila(){} //constructor
    
    public void iniciar_pila( )
    {
        cab = null; 
    }
    
    public  void consultar_informacion_servicio(String s){
        int i = 0;
        int ban = 0;
        movil = cab;
        while ((movil != null))
        {
            if (s.equals(movil.servicio))
            {
                aux[i] = movil.servicio+", "+movil.numfactura+", "+movil.valor;
                i++;
                ban = 1;
            }
            movil = movil.sig;
        }
        if (ban == 0)
            aux[0] = "no";

    }

    public int insertar_nodo_pila(int nf, String s, long v)
    {
        //validando que no esté repetido
        movil = cab;
        while ((movil != null))
        {
            if (nf == movil.numfactura)
                return 1;
            movil = movil.sig;
          }
        Nodo nuevo = new Nodo();
        nuevo.servicio= s;
        nuevo.numfactura=nf;
        nuevo.valor=v;
        nuevo.sig = cab;
        cab = nuevo; 
        return 0;
    }

    public void imprimir_pila( )
    {
        int i = 0;
        movil= cab;
        if (movil == null)
            return;
        while (movil!=null){
            datos[i] = "numfactura = " + movil.numfactura + ", servicio = " + movil.servicio + ", valor = " + movil.valor;
            i++;
            movil= movil.sig;
        }
    }

    public  void destruir_pila( ){
        Nodo borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
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
            if (cab == null)
                datos[0] = " ";
            return 0;
        } 
        return 0;
    }
    
    public void trasladar( ){ // método que pasa datos del archivo a la lista
        DataInputStream archivo = null;
        Nodo nuevo;
        Registro R=new Registro();
        try{
            // abriendo archivo para lectura
            archivo = new DataInputStream( new FileInputStream("c\\Prueba\\servicios.txt") );
            //leyendo archivo 
            while (true) {
                //leyendo registro
                nuevo = new Nodo();
                nuevo.servicio= archivo.readUTF();
                nuevo.numfactura=archivo.readInt();
                nuevo.valor=archivo.readLong();
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
} // fin de la clase ListaPila
