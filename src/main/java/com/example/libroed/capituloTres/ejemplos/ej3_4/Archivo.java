package com.example.libroed.capituloTres.ejemplos.ej3_4;

import java.io.*;

//inicio de la clase Archivos
class Archivo{
    
    Archivo(){} // Constructor

    public static void guardar_archivo(ListaPila L){
        // método que guarda la lista en el archivo en C:\\Prueba
        Nodo movil1;
        DataOutputStream archivo = null;
        // Se deben grabar y leer los datos campo a campo
        // recuerde que un archivo es un conjunto de registros
        Registro R=new Registro();// creando un objeto tipo registro
        movil1 = L.cab; 
        while(movil1!=null){
            try{
                // Creando y grabando a un archivo
                archivo = new DataOutputStream( new FileOutputStream("c\\Prueba\\servicios.txt",true));
                // grabando en el archivo
                archivo.writeUTF(movil1.servicio);
                archivo.writeInt(movil1.numfactura);
                archivo.writeLong(movil1.valor);
                archivo.close();
            }
            catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
            catch (IOException ioe) { /* Error al escribir */ }
            finally {
                if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
            }
            movil1 = movil1.sig;
        }
    }

    public void eliminar_archivo(){
         File fichero=new File("c\\Prueba\\servicios.txt");
         fichero.delete();
    }
}// fin de la clase Archivo
