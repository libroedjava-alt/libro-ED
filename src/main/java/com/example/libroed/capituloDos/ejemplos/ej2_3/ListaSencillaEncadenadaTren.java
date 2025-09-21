package com.example.libroed.capituloDos.ejemplos.ej2_3;

// inicio de la clase ListaSencillaEncadenadaTren
public class ListaSencillaEncadenadaTren{

    Nodo cab; // puntero al primer nodo de la lista
    Nodo movil; // puntero para moverse en la lista
    static int contadorn; // contador de nodos
    static String car=new String("");
    String datos[] = new String[100]; // 100 registros máximo a guardar
    String aux[] = new String[5]; // vector usado para consultar (5 campos por nodo)

    public ListaSencillaEncadenadaTren(){} // constructor

    public void iniciar_lista() {
        cab = null;
        contadorn = 0;
    }

    public void consultar_nodo(int nvag){
        // ban = 0 no se ha encontrado el registro
        int ban=0;
        movil = cab;
        while ((movil != null) && (ban==0))
        {
            if (nvag == movil.n_vagon){
                aux[0] = movil.n_vagon + " ";
                aux[1] = movil.n_ban + " ";
                aux[2] = movil.n_pue + " ";
                aux[3] = movil.n_ven + " ";
                aux[4] = movil.carga;
                ban = 1;
            }
            movil = movil.sig;
        }
        if (ban == 0)
            aux[4] = "no";
    }

    public void imprimir_lista(){
        int i = 0;
        movil= cab;
        if (movil == null)
            return;
        while (movil!=null){
            datos[i] = "nv = " + movil.n_vagon + ", nb = " + movil.n_ban + ", nv = " + movil.n_ven + ", np = " + movil.n_pue + ", ca = " + movil.carga;
            i++;
            movil= movil.sig;
        }
    }

    public int insertar_nodo_inicio(int nv,String c, int nb,int np, int nve)
    {
        // validando que no exista ya
        movil = cab;
        while (movil != null)
        {
            if (nv == movil.n_vagon)
                return 1;
            movil = movil.sig;
        }
        Nodo nuevo = new Nodo();
        nuevo.n_vagon=nv;
        nuevo.n_ban=nb;
        nuevo.carga=c;
        nuevo.n_pue=np;
        nuevo.n_ven=nve;
        nuevo.sig = cab;
        cab = nuevo;
        contadorn ++;
        return 0;
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
}
// fin de la clase ListaSencillaEncadenadaTren
