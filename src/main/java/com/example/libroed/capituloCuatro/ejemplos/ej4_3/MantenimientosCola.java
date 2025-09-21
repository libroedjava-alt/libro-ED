package com.example.libroed.capituloCuatro.ejemplos.ej4_3;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//Inicio de la clase MantenimientosCola
class MantenimientosCola{

    public static void main(String[ ] args)
    {
        String v[] = new String[2];
        final ListaColaMantenimientos ListaC = new ListaColaMantenimientos();
        ListaC.iniciar_Cola();
        final JFrame frame = new JFrame("Cola de Mantenimientos");//creando el frame o ventana
        //creacion de componentes
        frame.setLocation(30,100);//posicion de la ventana 
        frame.setForeground(Color.green);// //caracteristicas de primer plano
        frame.setBackground(Color.red);//caracteristicas de fondo
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimir;
        JButton botonBorrar;
        JButton botonSalir;
        JLabel labCodigo;
        JLabel labCaracteristicas;
        JLabel labDueno;
        JLabel labProblema;
        JLabel labMantenimientos;
        JList listaImprimir;
        final JTextField textCodigo;
        final JTextField textCaracteristicas;
        final JTextField textDueno;
        final JTextField textProblema;
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
        labCaracteristicas = new JLabel("Caracteristicas");
        labDueno = new JLabel("Dueno");
        labProblema = new JLabel("Problemas");
        labMantenimientos = new JLabel("Cola de Mantenimientos");
        textCodigo = new JTextField("",5);
        textCaracteristicas = new JTextField("",25);
        textDueno = new JTextField("",10);
        textProblema = new JTextField("",25);
        lista=new JList(v);
        panelLis= new JScrollPane();
        //agregando componentes a los paneles
        panelTexto.add(labCodigo);
        panelTexto.add(textCodigo);
        panelTexto.add(labCaracteristicas);
        panelTexto.add(textCaracteristicas);
        panelTexto.add(labDueno);
        panelTexto.add(textDueno);
        panelTexto.add(labProblema);
        panelTexto.add(textProblema);
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
        frame.getContentPane().add(labMantenimientos,BorderLayout.WEST);
        frame.getContentPane().add(panelLis,BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
        //manejo de evento del boton cerrar de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
        
            public void windowClosing(WindowEvent e){
                ListaC.destruir_Cola( );        
                System.exit(0);
               }
        }); 

        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                int cod;
                String car = new String("");
                String due = new String("");
                String pro = new String("");
                //obteniendo valores de las cajas de texto
                cod = Integer.valueOf(textCodigo.getText()).intValue();
                car = textCaracteristicas.getText();
                due = textDueno.getText();
                pro = textProblema.getText();
                resp = ListaC.insertar_nodo_Cola(cod, car, due, pro);
                if (resp == 1) // ya existe el codigo del computador
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe el Código del Computador");
            }
        });
        
        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ListaC.imprimir_Cola();
                lista.setListData(ListaC.datos); //actualizando lista 
                // con la información del vector
            }
        });

        botonBorrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                resp = ListaC.borrar_nodo_Cola();
                for (int i = 0; i<10; i++)
                    ListaC.datos[i] = " ";
                ListaC.imprimir_Cola();
                lista.setListData(ListaC.datos); //actualizando lista 
                // con la información del vector
                if (resp == 1){ 
                    lista.setListData(ListaC.datos); //actualizando lista con la informacion del vector
                    JOptionPane.showMessageDialog(frame, "Error, NO hay elementos en la Lista");
                }
            }
        });
        
        botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ListaC.consultar_computador(Integer.parseInt(textCodigo.getText()));
                if (ListaC.aux[0].equals("no")) // no existe el registro
                    JOptionPane.showMessageDialog(frame, "Error, No existe el Código del Computador");
                else{
                    //asignar valores a cajas de texto según código
                    textCodigo.setText(ListaC.aux[0]);
                    textCaracteristicas.setText(ListaC.aux[1]);
                    textDueno.setText(ListaC.aux[2]);
                    textProblema.setText(ListaC.aux[3]);
                }
            }
        });

        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ListaC.destruir_Cola( );        
                System.exit(0); 
            }
        });
        
        frame.pack();
        frame.setVisible(true);
    }
}
// fin de la clase MantenimientosCola
