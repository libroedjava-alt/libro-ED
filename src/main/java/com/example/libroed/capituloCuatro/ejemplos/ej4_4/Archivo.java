package com.example.libroed.capituloCuatro.ejemplos.ej4_4;

import java.io.*;

//inicio de la clase Archivos
class Archivo{
    
    Archivo(){} // Constructor

    public static void guardar_archivo(ListaCola L){
        // método que guarda la información de la lista en el archivo en la 
        // carpeta c:\\Prueba
        Nodo movil1;
        DataOutputStream archivo = null;
        // Se deben grabar y leer los datos solo campo a campo
        // recuerde que un archivo es un conjunto de registros
        Registro R=new Registro();// creando un objeto tipo registro
        movil1 = L.cab; 
        while(movil1!=null){
            try{
                //* Creando y grabando a un archivo*/
                archivo = new DataOutputStream( new FileOutputStream("c\\Prueba\\recursos.txt",true));
                //grabando al archivo
                archivo.writeInt(movil1.numrecurso);
                archivo.writeUTF(movil1.recurso);
                archivo.writeUTF(movil1.usuario);
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
         File fichero=new File("c\\Prueba\\recursos.txt");
         fichero.delete();
    }
}// fin de la clase Archivo
