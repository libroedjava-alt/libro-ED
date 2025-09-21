package com.example.libroed.capituloTres.ejemplos.ej3_4;

//inicio de la clase Servicios Pila
class ServiciosPila{
    public static void main(String[] args) {
        String v[] = new String[100];
        final ListaPila L = new ListaPila();
        final Archivo A = new Archivo();
        L.iniciar_pila();
        L.trasladar();
        final javax.swing.JFrame frame = new javax.swing.JFrame("Información de los Servicios Publicos"); // creando el frame o ventana
        // creacion de componentes
        javax.swing.JButton botonGuardar;
        javax.swing.JButton botonConsultar;
        javax.swing.JButton botonImprimir;
        javax.swing.JButton botonSalir;
        javax.swing.JButton botonBorrar;
        javax.swing.JLabel labservicio;
        javax.swing.JLabel labnumfactura;
        javax.swing.JLabel labvalor;
        javax.swing.JLabel labLista;
        javax.swing.JList listaImprimir;
        final javax.swing.JTextField textservicio;
        final javax.swing.JTextField textnumfactura;
        final javax.swing.JTextField textvalor;
        final javax.swing.JList lista;
        javax.swing.JPanel panelTexto;
        javax.swing.JPanel panelBot;
        javax.swing.JPanel panelLista;
        javax.swing.JScrollPane panelLis; 
        panelTexto= new javax.swing.JPanel();
        panelBot= new javax.swing.JPanel();
        panelLista= new javax.swing.JPanel();
        botonGuardar = new javax.swing.JButton("Guardar");
        botonConsultar = new javax.swing.JButton("Consultar");
        botonImprimir = new javax.swing.JButton("Imprimir");
        botonBorrar = new javax.swing.JButton("borrar");
        botonSalir = new javax.swing.JButton("Salir");
        labservicio = new javax.swing.JLabel("Servicio Publico");
        labnumfactura = new javax.swing.JLabel("Numero de Factura");
        labvalor= new javax.swing.JLabel("Valor $");
        labLista = new javax.swing.JLabel("Pila de Recibos");
        textservicio = new javax.swing.JTextField("",5);
        textnumfactura = new javax.swing.JTextField("",5);
        textvalor = new javax.swing.JTextField("",5);
        lista=new javax.swing.JList(v);
        panelLis= new javax.swing.JScrollPane();
        // agregando componentes a los paneles
        panelTexto.add(labservicio);
        panelTexto.add(textservicio);
        panelTexto.add(labnumfactura);
        panelTexto.add(textnumfactura);
        panelTexto.add(labvalor);
        panelTexto.add(textvalor);
        panelBot.add(botonGuardar);
        panelBot.add(botonConsultar);
        panelBot.add(botonImprimir);
        panelBot.add(botonBorrar);
        panelBot.add(botonSalir);
        panelLis.setViewportView(lista); 
        //configurando layout del contenedor
        frame.getContentPane().setLayout(new java.awt.BorderLayout());
        //agrengando paneles al contenedor
        frame.getContentPane().add(panelTexto,java.awt.BorderLayout.NORTH);
        frame.getContentPane().add(labLista,java.awt.BorderLayout.WEST);
        frame.getContentPane().add(panelLis,java.awt.BorderLayout.CENTER);
        frame.getContentPane().add(panelBot,java.awt.BorderLayout.SOUTH);
        //manejo de evento del botón cerrar de la ventana
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter(){
           public void windowClosing(java.awt.event.WindowEvent e){
            A.eliminar_archivo();
            A.guardar_archivo(L);
            L.destruir_pila( );        
            System.exit(0);
           }
        }); 

        botonGuardar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                int resp = 0;
                String s=new String("");
                int nf;
                long v;
                //obteniendo valores de las cajas de texto
                nf = Integer.valueOf(textnumfactura.getText()).intValue();
                s=textservicio.getText();
                v=Long.valueOf(textvalor.getText()).longValue();
                resp = L.insertar_nodo_pila(nf,s,v);
                if (resp == 1) // ya existe la factura
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error, Ya existe la factura");
            }
        });

        botonImprimir.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                L.imprimir_pila();
                lista.setListData(L.datos); //actualiza lista 
            }
        });

        botonBorrar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                int resp = 0;
                resp = L.borrar_nodo_pila();
                for (int i=0; i<10; i++)
                    L.datos[i] = " ";
                L.imprimir_pila();
                //actualizando lista con la informacion del vector
                lista.setListData(L.datos); 
                if (resp == 1){ 
                    lista.setListData(L.datos); 
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error, No hay elementos en la Lista");
                }
            }
        });

        botonConsultar.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                for (int i=0; i<10;i++)
                    L.aux[i]=" ";
                L.consultar_informacion_servicio(textservicio.getText());
                if (L.aux[0].equals("no")) // no existe el registro
                    javax.swing.JOptionPane.showMessageDialog(frame, "Error, No existe Facturas de este Servicio");
                else{
                    //asignando valores a la lista según la consulta
                    lista.setListData(L.aux); }
                }
            }
        );

        botonSalir.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e){
                A.eliminar_archivo();
                A.guardar_archivo(L);
                L.destruir_pila( );        
                System.exit(0); 
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}// fin de la clase ServiciosPila
