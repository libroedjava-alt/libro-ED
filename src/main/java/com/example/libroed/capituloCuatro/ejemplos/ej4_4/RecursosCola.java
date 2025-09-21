package com.example.libroed.capituloCuatro.ejemplos.ej4_4;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//inicio de la clase RecursosCola
class RecursosCola{

    public static void main(String[] args) {

        String v[] = new String[100];
        final ListaCola L = new ListaCola();
        final Archivo A = new Archivo();
        L.iniciar_Cola();
        L.trasladar();
        final JFrame frame = new JFrame("Informacion de los Recursos");
        //creacion de componentes
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimir;
        JButton botonSalir;
        JButton botonBorrar;
        JLabel labRecurso;
        JLabel labNumrecurso;
        JLabel labUsuario;
        JLabel labLista;
        JList listaImprimir;
        final JTextField textRecurso;
        final JTextField textNumrecurso;
        final JTextField textUsuario;
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
        botonBorrar = new JButton("borrar");
        botonSalir = new JButton("Salir");
        labRecurso = new JLabel("Recurso");
        labNumrecurso = new JLabel("Numero del Recurso");
        labUsuario= new JLabel("Usuario");
        labLista = new JLabel("Cola de Recursos");
        textRecurso = new JTextField("",5);
        textNumrecurso = new JTextField("",5);
        textUsuario = new JTextField("",5);
        lista=new JList(v);
        panelLis= new JScrollPane();
        //agregando componentes a los paneles
        panelTexto.add(labNumrecurso);
        panelTexto.add(textNumrecurso);
        panelTexto.add(labRecurso);
        panelTexto.add(textRecurso);
        panelTexto.add(labUsuario);
        panelTexto.add(textUsuario);
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
        frame.getContentPane().add(labLista,BorderLayout.WEST);
        frame.getContentPane().add(panelLis,BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
        //manejo de evento del boton cerrar de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
          
            public void windowClosing(WindowEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_Cola( );        
                System.exit(0);
               }
        }); 

        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                String r=new String("");
                int nr;
                String u=new String("");
                //obteniendo usuarioes de las cajas de texto
                nr = Integer.valueOf(textNumrecurso.getText()).intValue();
                r = textRecurso.getText();
                u = textUsuario.getText();
                resp = L.insertar_nodo_Cola(nr,r,u);
                if (resp == 1) // ya existe el codigo del recurso
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe el Código del Recurso");
            }
        });
        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                L.imprimir_Cola();
                lista.setListData(L.datos); //actualizando lista con la 
                // información del vector
            }
        });

        botonBorrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                resp = L.borrar_nodo_Cola();
                for (int i=0; i<10; i++)
                    L.datos[i] = " ";
                L.imprimir_Cola();
                lista.setListData(L.datos); // actualizando lista con la 
                // información del vector
                if (resp == 1){ 
                    lista.setListData(L.datos); 
                    JOptionPane.showMessageDialog(frame, "Error, NO hay elementos en la Lista");
                }
            }
        });

        botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i=0; i<10;i++)
                    L.aux[i]=" ";
                L.consultar_informacion_recurso(textRecurso.getText());
                if (L.aux[0].equals("no")) // no existe el registro
                    JOptionPane.showMessageDialog(frame, "Error, No existe este Recurso");
                else{
                    //asignando usuarios a la lista según la consulta
                    lista.setListData(L.aux); //actualizando lista 
                // con información del vector 
                }
            }
        });
        botonSalir.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_Cola( );        
                System.exit(0); 
            }
        });
    frame.pack();
    frame.setVisible(true);
    }
}// fin de la clase RecursosCola
