package com.example.libroed.capituloDos.ejemplos.ej2_4;

// paquetes o librerías
import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

//inicio de la clase 
class ConcesionarioLSE{
    public static void main(String[] args) {

        String v[] = new String[100];
        final ListaSencillaEncadenadaVehiculo L = new ListaSencillaEncadenadaVehiculo();
        L.iniciar_lista();
        final Archivo A = new Archivo();
        L.iniciar_lista();
        L.trasladar();
        // creando el frame o ventana
        final JFrame frame = new JFrame("Información del Concesionario");
        //creacion de componentes
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimir;
        JButton botonSalir;
        JLabel labPlaca;
        JLabel labModelo;
        JLabel labColor;
        JLabel labMarca;
        JLabel labLista;
        JList listaImprimir;
        final JTextField textPlaca;
        final JTextField textModelo;
        final JTextField textColor;
        final JTextField textMarca;
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
        labPlaca = new JLabel("Placa");
        labModelo = new JLabel("Modelo");
        labColor= new JLabel("Color");
        labMarca = new JLabel("Marca");
        labLista = new JLabel("Lista de Vehiculos");
        textPlaca = new JTextField("",5);
        textModelo = new JTextField("",5);
        textColor = new JTextField("",5);
        textMarca = new JTextField("",5);
        lista=new JList(v);
        panelLis= new JScrollPane();
        //agregando componentes a los paneles
        panelTexto.add(labPlaca);
        panelTexto.add(textPlaca);
        panelTexto.add(labModelo);
        panelTexto.add(textModelo);
        panelTexto.add(labColor);
        panelTexto.add(textColor);
        panelTexto.add(labMarca);
        panelTexto.add(textMarca);
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
            L.destruir_lista( );        
            System.exit(0);
           }
        }); 

        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                String p=new String("");
                int m;
                String c=new String("");
                String ma=new String("");
                //obteniendo valores de las cajas de texto
                m = Integer.valueOf(textModelo.getText()).intValue();
                p=textPlaca.getText();
                c=textColor.getText();
                ma=textMarca.getText();
                resp = L.insertar_nodo_inicio(p,m,c,ma);
                if (resp == 1) // ya existe el vagon
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe la Placa");
            }
        });

        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                L.imprimir_lista();
                lista.setListData(L.datos); //actualizando lista con la información del vector
            }
        });

        botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (int i=0; i<10;i++)
                    L.aux[i]=" ";
                L.consultar_informacion_Color(textColor.getText());
                if (L.aux[0].equals("no")) // no existe el registro
                    JOptionPane.showMessageDialog(frame, "Error, No existe Carros de este Color");
                else{
                    //asignando valores a la lista segun la consulta
                    lista.setListData(L.aux); //actualizando lista
                }
            }
        });

        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_lista( );        
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}// fin de la clase ConcesionarioLSE
