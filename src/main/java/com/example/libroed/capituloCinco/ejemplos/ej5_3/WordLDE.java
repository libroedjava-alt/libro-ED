package com.example.libroed.capituloCinco.ejemplos.ej5_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase WordLDE
class WordLDE{
	public static void main(String[ ] args)
	{
		String v[] = new String[2];
		final ListaLDEOperaciones listaDE = new ListaLDEOperaciones();
		listaDE.iniciar_lista_doble_encadenada();
		final JFrame frame = new JFrame("Lista de Operaciones en Word");//creando el frame o ventana
		//creacion de componentes
		frame.setLocation(300,100);//posicion de la ventana	
		frame.setForeground(Color.green);// //operacion de primer plano
		frame.setBackground(Color.blue);//operacion de fondo
		JButton botonGuardar;
		JButton botonGuardarDoc;
		JButton botonImprimir;
		JButton botonDeshacer;
		JButton botonRehacer;
		JButton botonSalir;
		JLabel labCodigo;
		JLabel labOperacion;
		JLabel labOperaciones;
		JList listaImprimir;
		final JTextField textCodigo;
		final JTextField textOperacion;
		final JList lista;
		JPanel panelTexto;
		JPanel panelBot;
		JPanel panelLista;
		JScrollPane panelLis; //panel especial para que la lista tenga barras verticales de desplazamiento
		panelTexto= new JPanel();
		panelBot= new JPanel();
		panelLista= new JPanel();
		botonGuardar = new JButton("Insertar");
		botonGuardarDoc = new JButton("Guardar Documento");
		botonImprimir = new JButton("Imprimir");
		botonSalir = new JButton("Salir");
		botonDeshacer = new JButton("Deshacer");
		botonRehacer = new JButton("Rehacer");
		labCodigo = new JLabel("Codigo");
		labOperacion = new JLabel("Operacion");
		labOperaciones = new JLabel("Operaciones");
		textCodigo = new JTextField("",5);
		textOperacion = new JTextField("",15);
		lista=new JList(v);
		panelLis= new JScrollPane();
		//agregando componentes a los paneles
		panelTexto.add(labCodigo);
		panelTexto.add(textCodigo);
		panelTexto.add(labOperacion);
		panelTexto.add(textOperacion);
		panelBot.add(botonGuardar);
		panelBot.add(botonGuardarDoc);
		panelBot.add(botonDeshacer);
		panelBot.add(botonRehacer);
		panelBot.add(botonImprimir);
		panelBot.add(botonSalir);
		panelLis.setViewportView(lista); 
		//configurando layout del contenedor
		frame.getContentPane().setLayout(new BorderLayout());
		//agrengando paneles al contenedor
		frame.getContentPane().add(panelTexto,BorderLayout.NORTH);
		frame.getContentPane().add(labOperaciones,BorderLayout.WEST);
		frame.getContentPane().add(panelLis,BorderLayout.CENTER);
		frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
		//manejo de evento del boton cerrar de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter(){
		public void windowClosing(WindowEvent e){
			listaDE.destruir_LDE( );        
			System.exit(0);
		   }
		}); 
	  
		botonGuardar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				int resp = 0;
				int cod;
				String ope = new String("");
				//obteniendo valores de las cajas de texto
				cod = Integer.valueOf(textCodigo.getText()).intValue();
				ope = textOperacion.getText();
				resp = listaDE.insertar_nodo_LDE(cod, ope);
				if (resp == 1) // ya existe el codigo
					JOptionPane.showMessageDialog(frame, "Error, Ya existe el Código de la operación");
			}
		});
		botonImprimir.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				listaDE.imprimir_lista_fin();
				lista.setListData(listaDE.datos); 
			}
		});

		botonDeshacer.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	int resp = 0;
				resp = listaDE.deshacer_operacion();
				lista.setListData(listaDE.datos); 
				if (resp == 1){ 
					lista.setListData(listaDE.datos); //actualizando lista con la informacion del vector
					JOptionPane.showMessageDialog(frame, "Error, NO se puede Deshacer la Operacion");
				}
			}
		});

		botonRehacer.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	int resp = 0;
				resp = listaDE.rehacer_operacion();
				lista.setListData(listaDE.datos); 
				if (resp == 1){ 
					lista.setListData(listaDE.datos); //actualizando lista con la informacion del vector
					JOptionPane.showMessageDialog(frame, "Error, NO se puede Rehacer la Operacion");
				}
			}
		});
        
		botonGuardarDoc.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				listaDE.destruir_LDE();
				for (int i = 0; i<10 ; i++)
					listaDE.datos[i] = " ";
				lista.setListData(listaDE.datos); 
			}
		});
	
		botonSalir.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	listaDE.destruir_LDE( );        
				System.exit(0); 
			}
		});
        
		frame.pack();
		frame.setVisible(true);
	}
}
// fin de la clase WordLDE
