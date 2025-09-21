package com.example.libroed.capituloSies.ejemplos.ej6_4;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//inicio de la clase CarruselLC
class CarruselLC{
    public static void main(String[] args) {

        String v[] = new String[100];
        final ListaCircular L = new ListaCircular();
        final Archivo A = new Archivo();
        L.iniciar_lista_circular();
        L.trasladar();
        final JFrame frame = new JFrame("Informacion del Carrusel"); 
        //creacion de componentes
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimir;
        JButton botonSalir;
        JLabel labNombre;
        JLabel labPosicion;
        JLabel labLista;
        JList listaImprimir;
        final JTextField textNombre;
        final JTextField textPosicion;
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
        labNombre = new JLabel("Nombre");
        labPosicion = new JLabel("Posicion");
        labLista = new JLabel("Lista de Niños");
        textNombre = new JTextField("",5);
        textPosicion = new JTextField("",5);
        lista=new JList(v);
        panelLis= new JScrollPane();
        //agregando componentes a los paneles
        panelTexto.add(labNombre);
        panelTexto.add(textNombre);
        panelTexto.add(labPosicion);
        panelTexto.add(textPosicion);
        panelBot.add(botonGuardar);
        panelBot.add(botonConsultar);
        panelBot.add(botonImprimir);
        panelBot.add(botonSalir);
        panelLis.setViewportView(lista);
        //configurando layout del contenedor
        frame.getContentPane().setLayout(new BorderLayout());
        //agrengando paneles al contenedor
        frame.getContentPane().add(panelTexto,BorderLayout.NORTH);
        frame.getContentPane().add(labLista,BorderLayout.WEST);
        frame.getContentPane().add(panelLis,BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
        //manejo de evento del boton cerrar de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
         
          public void windowClosing(WindowEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_lista_circular( );        
                System.exit(0);
               }
        }); 
      
        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                String n=new String("");
                int p;
                
                //obteniendo valores de las cajas de texto
                p = Integer.valueOf(textPosicion.getText()).intValue();
                n=textNombre.getText();
                resp = L.insertar_nodo_inicio(p,n);
                if (resp == 1) // ya existe la factura
                    JOptionPane.showMessageDialog(frame, "Error, Ya está Ocupado el Caballito");
            }
        });
        
        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                L.imprimir_lista_circular();
                lista.setListData(L.datos); //actualiza lista 
            }
        });
     
       botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i=0; i<10;i++)
                    L.aux[i]=" ";
                L.consultar_informacion_nombre(textNombre.getText());
                if (L.aux[0].equals("no")) // no existe el registro
                    JOptionPane.showMessageDialog(frame, "Error, No existe este Nombre");
                else{
                    //asignando valores a la lista según la consulta
                    lista.setListData(L.aux); //actualizando lista          
                }
            }
        });
        
        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_lista_circular( );        
                System.exit(0); 
            }
        });
    frame.pack();
    frame.setVisible(true);
    }
}// fin de la clase CarruselLC
