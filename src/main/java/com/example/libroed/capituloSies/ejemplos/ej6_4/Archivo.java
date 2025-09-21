package com.example.libroed.capituloSies.ejemplos.ej6_4;

import java.io.*;

//inicio de la clase Archivos
class Archivo{
    
    Archivo(){}

    public static void guardar_archivo(ListaCircular L){
        // Guarda la información de la lista en el archivo en c:\\Prueba
        int i = 0;
        Nodo movil1;
        DataOutputStream archivo = null;
        //recuerde que un archivo es un conjunto de registros
        Registro R=new Registro();// creando un objeto tipo registro
        movil1 = L.cab; 
        while(i < L.cn){
            try{
                //* Creando y grabando a un archivo */
                archivo = new DataOutputStream( new FileOutputStream("c\\Prueba\\carrusel.txt",true));
                //grabando al archivo
                archivo.writeUTF(movil1.nombre);
                archivo.writeInt(movil1.posicion);
                archivo.close();
            }
            catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
            catch (IOException ioe) { /* Error al escribir */ }
            finally {
                if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
            }
            movil1 = movil1.sig;
            i++;
        }
    }
    
    public void eliminar_archivo(){
         File fichero=new File("c\\Prueba\\carrusel.txt");
         fichero.delete();
    }
}// fin de la clase Archivo
