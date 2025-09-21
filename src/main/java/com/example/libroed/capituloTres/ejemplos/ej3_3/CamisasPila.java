package com.example.libroed.capituloTres.ejemplos.ej3_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase CamisasPila
class CamisasPila{
	public static void main(String[ ] args)
	{
		String v[] = new String[2];
		final ListaPilaCamisas listaP = new ListaPilaCamisas();
		listaP.iniciar_pila();
		final JFrame frame = new JFrame("Pila de Discos"); // creando el frame 
		//creacion de componentes
		frame.setLocation(300,100);//posicion de la ventana	
		frame.setForeground(Color.green);// //color de primer plano
		frame.setBackground(Color.red);//color de fondo
		JButton botonGuardar;
		JButton botonConsultar;
		JButton botonImprimir;
		JButton botonBorrar;
		JButton botonSalir;
		JLabel labCodigo;
		JLabel labColor;
		JLabel labDiscos;
		JList listaImprimir;
		final JTextField textCodigo;
		final JTextField textColor;
		final JList lista;
		JPanel panelTexto;
		JPanel panelBot;
		JPanel panelLista;
		JScrollPane panelLis; 
		panelTexto= new JPanel();
		panelBot= new JPanel();
		panelLista= new JPanel();
		botonGuardar = new JButton("Guardar");
		botonConsultar = new JButton("Consultar");
		botonImprimir = new JButton("Imprimir");
		botonSalir = new JButton("Salir");
		botonBorrar = new JButton("Borrar");
		labCodigo = new JLabel("Codigo");
		labColor = new JLabel("Color");
		labDiscos = new JLabel("Pila de Discos");
		textCodigo = new JTextField("",5);
		textColor = new JTextField("",5);
		lista=new JList(v);
		panelLis= new JScrollPane();
		//agregando componentes a los paneles
		panelTexto.add(labCodigo);
		panelTexto.add(textCodigo);
		panelTexto.add(labColor);
		panelTexto.add(textColor);
		panelBot.add(botonGuardar);
		panelBot.add(botonConsultar);
		panelBot.add(botonImprimir);
		panelBot.add(botonBorrar);
		panelBot.add(botonSalir);
		panelLis.setViewportView(lista); 
		//configurando layout del contenedor
		frame.getContentPane().setLayout(new BorderLayout());
		//agrengando paneles al contenedor
		frame.getContentPane().add(panelTexto,BorderLayout.NORTH);
		frame.getContentPane().add(labDiscos,BorderLayout.WEST);
		frame.getContentPane().add(panelLis,BorderLayout.CENTER);
		frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
		//manejo de evento del boton cerrar de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter(){
		public void windowClosing(WindowEvent e){
			listaP.destruir_pila( );        
			System.exit(0);
		   }
		}); 

		botonGuardar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				int resp = 0;
				int cod;
				String col = new String("");
				//obteniendo valores de las cajas de texto
				cod = Integer.valueOf(textCodigo.getText()).intValue();
				col = textColor.getText();
				resp = listaP.insertar_nodo_pila(cod, col);
				if (resp == 1) // ya existe la camisa
					JOptionPane.showMessageDialog(frame, "Error, Ya existe el Codigo de la Camisa");
				if (resp == 2) 
					JOptionPane.showMessageDialog(frame, "Error, NO hay cupo para mas Camisas");
			}
		});

		botonImprimir.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
				listaP.imprimir_pila();
				lista.setListData(listaP.datos); //actualiza lista 
			}
		});

		botonBorrar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	int resp = 0;
				resp = listaP.borrar_nodo_pila();
				listaP.imprimir_pila();
				lista.setListData(listaP.datos); //actualiza lista 
				if (resp == 1){ 
					lista.setListData(listaP.datos); //actualizando lista con la informacion del vector
					JOptionPane.showMessageDialog(frame, "Error, NO hay elementos en la Lista");
				}
			}
		});
        
		botonConsultar.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			listaP.consultar_camisa(Integer.parseInt(textCodigo.getText()));
				if (listaP.aux[0].equals("no")) // no existe el registro
					JOptionPane.showMessageDialog(frame, "Error, No existe la camisa");
				else{
					//asigna valores a cajas de texto según el código
					textCodigo.setText(listaP.aux[0]);
					textColor.setText(listaP.aux[1]);
				}
			}
		});

		botonSalir.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		    	listaP.destruir_pila( );        
				System.exit(0); 
			}
		});
        
		frame.pack();
		frame.setVisible(true);
	}
}
// fin de la clase CamisasPila
