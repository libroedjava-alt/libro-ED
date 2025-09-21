package com.example.libroed.capituloDos.ejemplos.ej2_4;

import java.io.*;

/// inicio de la clase ListaSencillaEncadenadaVehiculo
public class ListaSencillaEncadenadaVehiculo{

    Nodo cab;
    Nodo movil;
    String datos[] = new String[100]; // 100 registro maximos a guardar
    String aux[] = new String[100]; // vector que se usa para el método consultar

    public ListaSencillaEncadenadaVehiculo(){} //constructor

    public void iniciar_lista() {
        cab = null;
    }

    public void consultar_informacion_Color(String col){
        int i = 0;
        int ban = 0;
        movil = cab;
        while ((movil != null))
        {
            if (col.equals(movil.color))
            {
                aux[i] = movil.placa+", "+movil.modelo+", "+movil.marca;
                i++;
                ban = 1;
            }
            movil = movil.sig;
        }
        if (ban == 0)
            aux[0] = "no";
    }

    public int insertar_nodo_inicio(String p, int m, String c, String ma)
    {
        // validando que el nodo no exista ya
        movil = cab;
        while ((movil != null))
        {
            if (p.equals(movil.placa))
                return 1;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        nuevo.placa= p;
        nuevo.modelo=m;
        nuevo.color=c;
        nuevo.marca=ma;
        nuevo.sig = cab;
        cab = nuevo;
        return 0;
    }

    public void imprimir_lista()
    {
        int i = 0;
        movil= cab;
        if (movil == null)
            return;
        while (movil!=null){
            datos[i] = "p = " + movil.placa + ", m = " + movil.modelo + ", c = " + movil.color + ", ma = " + movil.marca;
            i++;
            movil= movil.sig;
        }
    }

    public void destruir_lista(){
        Nodo borra;
        borra = cab;
        movil = cab;
        while(movil != null){
            movil = movil.sig;
            borra = null;
            borra = movil;
        }
    }

    public void trasladar(){ // método que pasa la información del archivo a la lista
        DataInputStream archivo = null;
        Nodo nuevo;
        Registro R=new Registro();
        try{
            // abriendo archivo para lectura
            archivo = new DataInputStream( new FileInputStream("c\\Prueba\\concesionario.txt") );
            // leyendo archivo
            while (true) {
                // leyendo registro
                nuevo = new Nodo();
                nuevo.placa= archivo.readUTF();
                nuevo.modelo=archivo.readInt();
                nuevo.color=archivo.readUTF();
                nuevo.marca=archivo.readUTF();
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
}
// fin de la clase ListaSencillaEncadenadaVehiculo
