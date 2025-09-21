package com.example.libroed.capituloSiete.ejemplos.ej7_5;

import java.io.*;

//inicio de la clase TestArbolBinario
class TestArbolBinario{
    public static void main(String arg[]) throws IOException{
        ArbolBinario AB= new ArbolBinario();
        BufferedReader Teclado; 
        int opc;
        int valor;
        Teclado= new BufferedReader(new InputStreamReader(System.in));
        AB.inicializar_arbol();
        do{
            System.out.println("1. Insertar Nodo");
            System.out.println("2. Insertar Nodo recursivo");
            System.out.println("3. Imprimir arbol en preorden");
            System.out.println("4. Imprimir arbol en inorden");
            System.out.println("5. Imprimir arbol en postorden");
            System.out.println("6. Borrar Nodo");
            System.out.println("7. Buscar");
            System.out.println("8. Contar");
            System.out.println("9. Salir");
            System.out.println("Digite la Opcion");
            opc=Integer.parseInt(Teclado.readLine());
            switch(opc){
                case 1:
                    AB.insertar_nodo();
                    break;
                case 2:
                    AB.movil=AB.raiz;
                    System.out.println("Digite el #");
                    valor=Integer.parseInt(Teclado.readLine());
                    AB.insertar_nodo_recursiva(AB.movil,valor);
                    break;
                case 3:
                    AB.imprimir_arbol_preorden(AB.raiz);
                    break;
                case 4:
                    AB.imprimir_arbol_inorden(AB.raiz);
                    break;
                case 5:
                    AB.imprimir_arbol_postorden(AB.raiz);
                    break;
                case 6:
                    System.out.println("Digite el numero a borrar: ");
                    valor =Integer.parseInt(Teclado.readLine());
                    AB.borrar(AB.raiz,valor);
                    break;
                case 7:
                    System.out.println("Digite el #");
                    valor=Integer.parseInt(Teclado.readLine());
                    int existe = AB.buscar(AB.raiz,valor);
                    if (existe ==0)
                        System.out.println("No se encontro"); 
                    else 
                        System.out.println("Si se encontro"); 
                    break;
                case 8:
                    System.out.println("Cantidad= " + AB.contar(AB.raiz));
                    break;
            }
        }while(opc!=9);
    }
}//fin de la clase TestArbolBinario
