package com.example.libroed.capituloCinco.ejemplos.ej5_4;

import java.io.*;

//inicio de la clase Archivos
class Archivo{
    
    Archivo(){}

    public static void guardar_archivo(ListaLDE L){
        // método que guarda la información de la lista 
        Nodo movil1;
        DataOutputStream archivo = null;
        Registro R=new Registro();// creando un objeto tipo registro
        movil1 = L.fin; 
        while(movil1!=null){
            try{
                //* Creando y grabando a un archivo */
                archivo = new DataOutputStream( new FileOutputStream("c\\Prueba\\paginawebs.txt",true));
                //grabando al archivo
                archivo.writeInt(movil1.numpagweb);
                archivo.writeUTF(movil1.paginaweb);
                archivo.close();
            }
            catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
            catch (IOException ioe) { /* Error al escribir */ }
            finally {
                if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
            }
            movil1 = movil1.ant;
        }
    }

    public void eliminar_archivo(){
         File fichero=new File("c\\Prueba\\paginawebs.txt");
         fichero.delete();
    }
}// fin de la clase Archivo
