package com.example.libroed.capituloDos.ejemplos.ej2_3;

// paquetes o librerías
import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos
import java.io.*;

// inicio de la clase TestLSE
public class TrenLSE {

    public static void main(String[] args) {
        String v[] = new String[100];
        final ListaSencillaEncadenadaTren Tren1 = new ListaSencillaEncadenadaTren();
        // creacion del objeto tipo Lista
        Tren1.iniciar_lista();
        final JFrame frame = new JFrame("Información del Tren");
        // creando el frame o ventana
        // creacion de componentes
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimir;
        JButton botonSalir;
        JLabel labNumeroV;
        JLabel labNumeroB;
        JLabel labNumeroVe;
        JLabel labNumeroP;
        JLabel labCarga;
        JLabel labVagones;
        JList listaImprimir;
        final JTextField textV;
        final JTextField textB;
        final JTextField textVe;
        final JTextField textP;
        final JTextField textCarga;
        final JList lista;
        JPanel panelTexto;
        JPanel panelBot;
        JPanel panelLista;
        JScrollPane panelLis; // panel especial para que la lista tenga barras verticales de desplazamiento
        panelTexto= new JPanel();
        panelBot= new JPanel();
        panelLista= new JPanel();
        botonGuardar = new JButton("Guardar");
        botonConsultar = new JButton("Consultar");
        botonImprimir = new JButton("Imprimir");
        botonSalir = new JButton("Salir");
        labNumeroV = new JLabel("numero del vagon");
        labNumeroB = new JLabel("numero de Baños");
        labNumeroVe= new JLabel("numero de ventanas");
        labNumeroP = new JLabel("numero de puestos");
        labVagones = new JLabel("Lista de Vagones");
        labCarga= new JLabel("carga");
        textV = new JTextField("",5);
        textB = new JTextField("",5);
        textVe = new JTextField("",5);
        textP = new JTextField("",5);
        textCarga = new JTextField("",10);
        lista=new JList(v);
        panelLis= new JScrollPane();
        //agregando componentes a los paneles
        panelTexto.add(labNumeroV);
        panelTexto.add(textV);
        panelTexto.add(labNumeroB);
        panelTexto.add(textB);
        panelTexto.add(labNumeroVe);
        panelTexto.add(textVe);
        panelTexto.add(labNumeroP);
        panelTexto.add(textP);
        panelTexto.add(labCarga);
        panelTexto.add(textCarga);
        panelBot.add(botonGuardar);
        panelBot.add(botonConsultar);
        panelBot.add(botonImprimir);
        panelBot.add(botonSalir);
        panelLis.setViewportView(lista); // se muestre lista en el panel con barras de desplazamiento
        //configurando layout del contenedor
        frame.getContentPane().setLayout(new BorderLayout());
        //agrengando paneles al contenedor
        frame.getContentPane().add(panelTexto,BorderLayout.NORTH);
        frame.getContentPane().add(labVagones,BorderLayout.WEST);
        frame.getContentPane().add(panelLis,BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
        //manejo de evento del boton cerrar de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(WindowEvent e){
                Tren1.destruir_lista();
                System.exit(0);
            }
        }); 

        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                int nvag;
                int nban;
                int nven;
                int npue;
                String car=new String("");
                //obteniendo valores de las cajas de texto
                nvag = Integer.valueOf(textV.getText()).intValue();
                car=textCarga.getText();
                nban = Integer.valueOf(textB.getText()).intValue();
                npue = Integer.valueOf(textP.getText()).intValue();
                nven = Integer.valueOf(textVe.getText()).intValue();
                resp = Tren1.insertar_nodo_inicio(nvag, car, nban, npue, nven);
                if (resp == 1) // ya existe el vagon
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe el Vagón");
            }
        });

        botonImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Tren1.imprimir_lista();
                lista.setListData(Tren1.datos); //actualizando lista con la información del vector
            }
        });

        botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Tren1.consultar_nodo(Integer.parseInt(textV.getText()));
                if (Tren1.aux[4].equals("no")) // no existe el registro
                    JOptionPane.showMessageDialog(frame, "Error, No existe el Vagón");
                else{
                    //asignando valores a las cajas de texto según el número del vagón
                    textB.setText(Tren1.aux[1]);
                    textP.setText(Tren1.aux[2]);
                    textVe.setText(Tren1.aux[3]);
                    textCarga.setText(Tren1.aux[4]);
                }
            }
        });

        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Tren1.destruir_lista();
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}
// fin de la clase TrenLSE
