package com.example.libroed.capituloSies.ejemplos.ej6_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase RondaLC
class RondaLC{
    public static void main(String[ ] args)
    {
        String v[] = new String[2];
        final ListaCircular listaCi = new ListaCircular();
        listaCi.iniciar_lista_circular();
        final JFrame frame = new JFrame("Lista de Niños");// crea la ventana
        //creación de componentes
        frame.setLocation(300,100); // posición de la ventana 
        frame.setForeground(Color.green);// //color de primer plano
        frame.setBackground(Color.red);//color de fondo
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimir;
        JButton botonSalir;
        JLabel labCodigo;
        JLabel labColor;
        JLabel labNinos;
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
        labCodigo = new JLabel("Codigo");
        labColor = new JLabel("Color");
        labNinos = new JLabel("Lista de Niños");
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
        panelBot.add(botonSalir);
        panelLis.setViewportView(lista); 
        //configurando layout del contenedor
        frame.getContentPane().setLayout(new BorderLayout());
        //agrengando paneles al contenedor
        frame.getContentPane().add(panelTexto,BorderLayout.NORTH);
        frame.getContentPane().add(labNinos,BorderLayout.WEST);
        frame.getContentPane().add(panelLis,BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
        //manejo de evento del boton cerrar de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
      
          public void windowClosing(WindowEvent e){
                listaCi.destruir_lista_circular( );        
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
                resp = listaCi.insertar_nodo_inicio(cod, col);
                if (resp == 1) // ya existe el color
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe el Código del Niño");
                }
        });

    botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listaCi.imprimir_lista_circular();
                lista.setListData(listaCi.datos); //actualiza lista con 
// la informacion del vector
            }
        });
      
        botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listaCi.consultar_color(Integer.parseInt(textCodigo.getText()));
                if (listaCi.aux[0].equals("no")) // no existe el registro
                    JOptionPane.showMessageDialog(frame, "Error, No existe el Niño");
                else{
                    //asigna valores a cajas de texto según código
                    textCodigo.setText(listaCi.aux[0]);
                    textColor.setText(listaCi.aux[1]);
                }
            }
        });
    
        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listaCi.destruir_lista_circular( );        
                System.exit(0); 
            }
        });
        
        frame.pack();
        frame.setVisible(true);
    }
}
// fin de la clase RondaLC
