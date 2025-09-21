package com.example.libroed.capituloDos.ejemplos.ej2_4;

import java.io.*;

//inicio de la clase Archivos
class Archivo{
    
    Archivo(){}

    public static void guardar_archivo(ListaSencillaEncadenadaVehiculo L){
        // método que guarda la información de la lista en el archivo 
        // en la carpeta C:\Prueba
        Nodo movil1;
        DataOutputStream archivo = null;
        Registro R=new Registro();// creando un objeto tipo registro
        movil1 = L.cab;
        while(movil1!=null){
            try{
                // Creando y grabando a un archivo (append)
                archivo = new DataOutputStream( new FileOutputStream("c\\Prueba\\concesionario.txt", true));
                // grabando al archivo
                archivo.writeUTF(movil1.placa);
                archivo.writeInt(movil1.modelo);
                archivo.writeUTF(movil1.color);
                archivo.writeUTF(movil1.marca);
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
         File fichero=new File("c\\Prueba\\concesionario.txt");
         fichero.delete();
    }
}// fin de la clase Archivo
