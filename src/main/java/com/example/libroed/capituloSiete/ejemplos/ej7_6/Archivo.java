package com.example.libroed.capituloSiete.ejemplos.ej7_6;

import java.io.*;

//inicio de la clase Archivos
class Archivo{
    
    Archivo(){}

    public static void guardar_archivo(ArbolBinario AB){
        // método que guarda los datos del AB en el archivo en c:\\Prueba
        DataOutputStream archivo = null;
        try{
            archivo = new DataOutputStream(new FileOutputStream("c\\Prueba\\arbolbinario.txt", false));
            for (int idx = 0; idx < AB.i; idx++){
                archivo.writeInt(AB.nodos[idx]);
            }
        }
        catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }
        catch (IOException ioe) { /* Error al escribir */ }
        finally {
            if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
        }
    }

    public void eliminar_archivo(){
         File fichero=new File("c\\Prueba\\arbolbinario.txt");
         fichero.delete();
    }
}// fin de la clase Archivo
