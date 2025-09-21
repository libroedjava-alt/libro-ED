package com.example.libroed.capituloOcho.ejemplos.ej8_2;

import java.io.*;

//inicio de la clase Grafos
class Grafos{
	
	//atributos;
	private static int matriz_distancia[][]; 
	NodoVertice cabv, movilv;
	NodoArista caba, movila;

	//metodos
	Grafos(){}

	public void inicializar_grafo(){
		cabv=null; // inicializando lista de vértices
		caba=null; // inicializando lista de aristas
	}

	public static void inicializar_matriz_de_adyacencia_distancias(){
		matriz_distancia=new int[6][6];

		// origen Popayan
		matriz_distancia[0][0]=0;   // Popayan
		matriz_distancia[0][1]=105; // Cali
		matriz_distancia[0][2]=175; // Pereira
		matriz_distancia[0][3]=195; // Armenia
		matriz_distancia[0][4]=275; // Ibague
		matriz_distancia[0][5]=345; // Bogota

		// origen Cali
		matriz_distancia[1][0]=105; // Popayan
		matriz_distancia[1][1]=0;   // Cali
		matriz_distancia[1][2]=70;  // Pereira
		matriz_distancia[1][3]=90;  // Armenia
		matriz_distancia[1][4]=170; // Ibague
		matriz_distancia[1][5]=240; // Bogota

		// origen Pereira
		matriz_distancia[2][0]=175; // Popayan
		matriz_distancia[2][1]=70;  // Cali
		matriz_distancia[2][2]=0;   // Pereira
		matriz_distancia[2][3]=35;  // Armenia
		matriz_distancia[2][4]=115; // Ibague
		matriz_distancia[2][5]=185; // Bogota

		// origen Armenia
		matriz_distancia[3][0]=195; // Popayan
		matriz_distancia[3][1]=90;  // Cali
		matriz_distancia[3][2]=35;  // Pereira
		matriz_distancia[3][3]=0;   // Armenia
		matriz_distancia[3][4]=80;  // Ibague
		matriz_distancia[3][5]=150; // Bogota

		// origen Ibague
		matriz_distancia[4][0]=275; // Popayan
		matriz_distancia[4][1]=170; // Cali
		matriz_distancia[4][2]=115; // Pereira
		matriz_distancia[4][3]=80;  // Armenia
		matriz_distancia[4][4]=0;   // Ibague
		matriz_distancia[4][5]=70;  // Bogota

		// origen Bogota
		matriz_distancia[5][0]=345; // Popayan
		matriz_distancia[5][1]=240; // Cali
		matriz_distancia[5][2]=185; // Pereira
		matriz_distancia[5][3]=150; // Armenia
		matriz_distancia[5][4]=70;  // Ibague
		matriz_distancia[5][5]=0;   // Bogota
	}

	public void ingresar_vertice(){
		// Se inserta al inicio (cabeza) como en el enunciado
		NodoVertice nuevo;
		nuevo = new NodoVertice(); nuevo.nombrev = new String("Popayan"); nuevo.siga=null; nuevo.sigv=cabv; cabv=nuevo;
		nuevo = new NodoVertice(); nuevo.nombrev = new String("Cali");    nuevo.siga=null; nuevo.sigv=cabv; cabv=nuevo;
		nuevo = new NodoVertice(); nuevo.nombrev = new String("Pereira"); nuevo.siga=null; nuevo.sigv=cabv; cabv=nuevo;
		nuevo = new NodoVertice(); nuevo.nombrev = new String("Armenia"); nuevo.siga=null; nuevo.sigv=cabv; cabv=nuevo;
		nuevo = new NodoVertice(); nuevo.nombrev = new String("Ibague");  nuevo.siga=null; nuevo.sigv=cabv; cabv=nuevo;
		nuevo = new NodoVertice(); nuevo.nombrev = new String("Bogota");  nuevo.siga=null; nuevo.sigv=cabv; cabv=nuevo;
	}

	private NodoVertice buscarVerticePorNombre(String nombre){
		movilv = cabv;
		while (movilv != null){
			if (movilv.nombrev.equals(nombre)) return movilv;
			movilv = movilv.sigv;
		}
		return null;
	}

	public  void ingresar_arista_vertice(){
		String[] nombres = {"Popayan","Cali","Pereira","Armenia","Ibague","Bogota"};
		for (int i = 0; i < 6; i++){
			caba = null; // nueva lista de aristas para el vértice i
			for (int j = 0; j < 6; j++){
				if (matriz_distancia[i][j] != 0){
					NodoArista nuevo = new NodoArista();
					nuevo.distancia = matriz_distancia[i][j];
					nuevo.sigv = buscarVerticePorNombre(nombres[j]);
					nuevo.siga = caba;
					caba = nuevo; // insertar al inicio
				}
			}
			// enlazar al vértice correspondiente
			NodoVertice v = buscarVerticePorNombre(nombres[i]);
			if (v != null) v.siga = caba;
		}
	}

	public  void imprimir_vertices(){
		movilv=cabv;
		while(movilv!=null){
			System.out.println(movilv.nombrev);
			movilv=movilv.sigv;
		}
	}
	
	public  void imprimir_aristas_vertice()throws IOException{
		int ban=0;
		BufferedReader Teclado;
		Teclado=new BufferedReader(new InputStreamReader(System.in));
		String Vertice=new String("");
		System.out.println("Digite el nombre del vertice");
		Vertice=Teclado.readLine();
		movilv=cabv;
		while((ban==0)&&(movilv!=null)){
			if(movilv.nombrev.equals(Vertice)){
				ban=1;
				movila=movilv.siga;
				while (movila!=null){
					System.out.println("A " + movila.sigv.nombrev + " distancia = " + movila.distancia);
					movila=movila.siga;
				}
			}
			movilv=movilv.sigv;
		}
	}
	
	public void consultar_distancia_origen_destino()throws IOException{
		int ban=0;
		BufferedReader Teclado;
		Teclado=new BufferedReader(new InputStreamReader(System.in));
		String VerticeOrigen=new String("");
		String VerticeDestino=new String("");
		System.out.println("Digite el nombre del vertice de Origen");
		VerticeOrigen=Teclado.readLine();
		System.out.println("Digite el nombre del vertice de Destino");
		VerticeDestino=Teclado.readLine();
		movilv=cabv;
		while((ban==0)&&(movilv!=null)){
			if(movilv.nombrev.equals(VerticeOrigen)){
				ban=1;
				movila=movilv.siga;
				while (movila!=null){
					if (VerticeDestino.equals(movila.sigv.nombrev))
						System.out.println("De " + movilv.nombrev + " A " + movila.sigv.nombrev + " distancia = " + movila.distancia);
					movila=movila.siga;
				}
			}
			movilv=movilv.sigv;
		}
	}

	public  void destruir_grafo(){
		NodoVertice borrav;
		NodoArista borraa;
		borrav = cabv;
		movilv = cabv;
		while(movilv != null){
			movilv = movilv.sigv;
			borraa = borrav.siga;
			movila = borrav.siga;
			while(movila != null){
				movila = movila.siga;
				borraa = null;
				borraa = movila;
			}
			borrav = null;
			borrav = movilv;
		}
	}
}// //fin de la clase Grafos
