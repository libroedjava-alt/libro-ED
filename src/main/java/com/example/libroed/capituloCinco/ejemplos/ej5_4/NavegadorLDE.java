package com.example.libroed.capituloCinco.ejemplos.ej5_4;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//inicio de la clase NavegadorLDE
class NavegadorLDE{
    public static void main(String[] args) {

        String v[] = new String[100];
        final ListaLDE L = new ListaLDE();
        final Archivo A = new Archivo();
        L.iniciar_lista_doble_encadenada();
        L.trasladar();
        final JFrame frame = new JFrame("Información de las páginas webs"); //creando el frame o ventana
        //creacion de componentes
        JButton botonGuardar;
        JButton botonCerrarNav;
        JButton botonImprimir;
        JButton botonAtras;
        JButton botonSiguiente;
        JButton botonSalir;
        JLabel labPaginaWeb;
        JLabel labNumPagweb;
        JLabel labLista;
        JList listaImprimir;
        final JTextField textPaginaWeb;
        final JTextField textNumPagweb;
        final JList lista;
        JPanel panelTexto;
        JPanel panelBot;
        JPanel panelLista;
        JScrollPane panelLis; 
        panelTexto= new JPanel();
        panelBot= new JPanel();
        panelLista= new JPanel();
        botonGuardar = new JButton("Guardar");
        botonCerrarNav = new JButton("Cerrar Navegador");
        botonImprimir = new JButton("Imprimir");
        botonSalir = new JButton("Salir");
        botonAtras = new JButton("Anterior");
        botonSiguiente = new JButton("Siguiente");
        labPaginaWeb = new JLabel("Paginas Web");
        labNumPagweb = new JLabel("Numero de la Pagina Web");
        labLista = new JLabel("Lista de paginas web");
        textPaginaWeb = new JTextField("",25);
        textNumPagweb = new JTextField("",5);
        lista=new JList(v);
        panelLis= new JScrollPane();
        //agregando componentes a los paneles
        panelTexto.add(labNumPagweb);
        panelTexto.add(textNumPagweb);
        panelTexto.add(labPaginaWeb);
        panelTexto.add(textPaginaWeb);
        panelBot.add(botonGuardar);
        panelBot.add(botonAtras);
        panelBot.add(botonSiguiente);
        panelBot.add(botonImprimir);
        panelBot.add(botonCerrarNav);
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
            L.destruir_LDE( );        
            System.exit(0);
           }
        }); 
        
        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                String pw =new String("");
                int npw;
                //obteniendo datos de las cajas de texto
                npw = Integer.valueOf(textNumPagweb.getText()).intValue();
                pw = textPaginaWeb.getText();
                resp = L.insertar_nodo_LDE(npw,pw);
                if (resp == 1) // ya existe el codigo del paginaweb
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe el Codigo de la Pagina web");
            }
        });

        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                L.imprimir_lista_fin();
                lista.setListData(L.datos); 
            }
        });

        botonAtras.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                resp = L.anterior_pagina();
                lista.setListData(L.datos); 
                if (resp == 1){ 
                    lista.setListData(L.datos); //actualizando lista 
                    // con la información del vector
                    JOptionPane.showMessageDialog(frame, "Error, NO hay pagina web atras");
                }
            }
        });

        botonSiguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                resp = L.siguiente_pagina();
                lista.setListData(L.datos); 
                if (resp == 1){ 
                    lista.setListData(L.datos); 
                    JOptionPane.showMessageDialog(frame, "Error, NO hay pagina web siguiente");
                }
            }
        });
    
        botonCerrarNav.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                L.destruir_LDE();
                for (int i = 0; i<10 ; i++)
                    L.datos[i] = " ";
                lista.setListData(L.datos); 
            }
        });
        
        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_LDE( );        
                System.exit(0); 
            }
        });
        
    frame.pack();
    frame.setVisible(true);
    }
}// fin de la clase NavegadorLDE
