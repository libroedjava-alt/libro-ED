package com.example.libroed.capituloSiete.ejemplos.ej7_6;

import javax.swing.*; // Librería Swing
import java.awt.*; // Librería Grafica de Java
import java.awt.event.*; // Librería de eventos

//inicio de la clase GUIAB
class GUIAB{
    public static void main(String[] args) {
        String v[] = new String[100];
        final ArbolBinario AB= new ArbolBinario();
        final Archivo A = new Archivo();
        AB.inicializar_arbol();
        AB.trasladar();
        final JFrame frame = new JFrame("Informacion del AB");
        //creacion de componentes
        JButton botonGuardar;
        JButton botonConsultar;
        JButton botonImprimirPre;
        JButton botonImprimirIno;
        JButton botonImprimirPos;
        JButton botonContar;
        JButton botonSalir;
        JButton botonBorrar;
        JLabel labdato;
        JLabel labrecorrido;
        final JTextField textdato;
        final JTextField textrecorrido;
        JPanel panelTexto;
        JPanel panelBot;
        panelTexto= new JPanel();
        panelBot= new JPanel();
        botonGuardar = new JButton("Guardar");
        botonConsultar = new JButton("Consultar");
        botonImprimirPre = new JButton("Recorrido en Preorden");
        botonImprimirIno = new JButton("Recorrido en Inorden");
        botonImprimirPos = new JButton("Recorrido en Postorden");
        botonContar = new JButton("Contar");
        botonBorrar = new JButton("Borrar");
        botonSalir = new JButton("Salir");
        labdato = new JLabel("Numero");
        labrecorrido = new JLabel("Recorrido");
        textdato = new JTextField("",5);
        textrecorrido = new JTextField("",30);
        //agregando componentes a los paneles
        panelTexto.add(labdato);
        panelTexto.add(textdato);
        panelBot.add(botonGuardar);
        panelBot.add(botonConsultar);
        panelBot.add(botonImprimirPre);
        panelBot.add(botonImprimirIno);
        panelBot.add(botonImprimirPos);
        panelBot.add(botonContar);
        panelBot.add(botonBorrar);
        panelBot.add(botonSalir);
        //configurando layout del contenedor
        frame.getContentPane().setLayout(new BorderLayout());
        //agrengando paneles al contenedor
        frame.getContentPane().add(panelTexto,BorderLayout.NORTH);
        frame.getContentPane().add(labrecorrido,BorderLayout.WEST);
        frame.getContentPane().add(textrecorrido,BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,BorderLayout.SOUTH);
        //manejo de evento del boton cerrar de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
           public void windowClosing(java.awt.event.WindowEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(AB);
                System.exit(0);
           }
        }); 

        botonGuardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = 0;
                int d;
                try {
                    d = Integer.parseInt(textdato.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número válido");
                    return;
                }
                resp = AB.insertar_nodo(d);
                if (resp == 1)
                    JOptionPane.showMessageDialog(frame, "Error, Ya existe el Número");
            }
        });

        botonImprimirPre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AB.datos = "";
                AB.imprimir_arbol_preorden(AB.raiz);
                textrecorrido.setText(AB.datos);
            }
        });

        botonImprimirIno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AB.datos = "";
                AB.imprimir_arbol_inorden(AB.raiz);
                textrecorrido.setText(AB.datos); 
            }
        });

        botonImprimirPos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AB.datos = "";
                AB.imprimir_arbol_postorden(AB.raiz);
                textrecorrido.setText(AB.datos); 
            }
        });

        botonBorrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int d;
                try {
                    d = Integer.parseInt(textdato.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número válido");
                    return;
                }
                int resp = AB.borrar(AB.raiz, d);
                AB.datos = "";
                AB.imprimir_arbol_preorden(AB.raiz);
                textrecorrido.setText(AB.datos);
                if (resp == 1){ 
                    JOptionPane.showMessageDialog(frame, "Error, NO hay elementos o no se encontró el número");
                }
            }
        });

        botonConsultar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int d;
                try {
                    d = Integer.parseInt(textdato.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Ingrese un número válido");
                    return;
                }
                int resp = AB.buscar(AB.raiz, d);
                if (resp == 0)
                    JOptionPane.showMessageDialog(frame, "Error, NO se encontró el número en el AB");
                else
                    JOptionPane.showMessageDialog(frame, "Sí se encontró el número en el AB");
            }
        });

        botonContar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int resp = AB.contar(AB.raiz);
                JOptionPane.showMessageDialog(frame, "Número de Nodos = " + resp);
            }
        });
        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(AB);
                System.exit(0); 
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}// fin de la clase GUIAB
