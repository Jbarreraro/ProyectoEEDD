package ui;

import javax.swing.*;
import data.*;
import logic.*;
import java.io.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

public class FormularioLinkedList extends javax.swing.JFrame {

    ListaEnlazada<Object> LAnimales = new ListaEnlazada<>();

    public FormularioLinkedList() {
        initComponents();
        Crear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tidentificacion = new javax.swing.JTextField();
        Tnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Tanimal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Tgenero = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TeIngreso = new javax.swing.JTextField();
        TfIngreso = new javax.swing.JTextField();
        Bagregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Bmostrar = new javax.swing.JButton();
        Beditar = new javax.swing.JButton();
        Beliminar = new javax.swing.JButton();
        Tbuscar = new javax.swing.JTextField();
        Bbuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TfSalida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Tadoptable = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Historias clinicas fundación");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("ID: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("NOMBRE");

        Tidentificacion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Tidentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TidentificacionActionPerformed(evt);
            }
        });

        Tnombre.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("TIPO ANIMAL");

        Tanimal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Tanimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TanimalActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("GENERO: ");

        Tgenero.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("ESTADO INGRESO");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("FECHA INGRESO");

        TeIngreso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TeIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeIngresoActionPerformed(evt);
            }
        });

        TfIngreso.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        Bagregar.setText("AGREGAR");
        Bagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BagregarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Bmostrar.setText("MOSTRAR");
        Bmostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmostrarActionPerformed(evt);
            }
        });

        Beditar.setText("EDITAR");
        Beditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeditarMouseClicked(evt);
            }
        });

        Beliminar.setText("ELIMINAR CONTACTO");
        Beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliminarActionPerformed(evt);
            }
        });

        Bbuscar.setText("BUSCAR CONTACTO");
        Bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BbuscarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("IDENTIFICACIÓN ANIMAL");

        TfSalida.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("ADOPTABLE");

        Tadoptable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("FECHA DE SALIDA");

        jButton1.setText("VACIAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Exportar/ Importar ");

        jMenuItem1.setText("Exportar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Importar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tanimal))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Tgenero))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TfIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TfSalida))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                            .addComponent(Tadoptable, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Beditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bmostrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bagregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 47, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(256, 256, 256))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bbuscar)
                        .addGap(102, 102, 102)
                        .addComponent(Beliminar)
                        .addGap(186, 186, 186))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(403, 403, 403))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(Tidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Tanimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(Tgenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TfIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(TeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(TfSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Tadoptable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(Bmostrar)
                .addGap(28, 28, 28)
                .addComponent(Beditar)
                .addGap(27, 27, 27)
                .addComponent(Bagregar)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 99, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bbuscar)
                            .addComponent(Beliminar))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BagregarMouseClicked
        String idText = Tidentificacion.getText();
        String nombre = Tnombre.getText();
        String animal = Tanimal.getText();
        String genero = Tgenero.getText();
        String fechaIngresoText = TfIngreso.getText();
        String adoptableText = Tadoptable.getText();
        String fechaSalidaText = TfSalida.getText();
        String estadoIngreso = TeIngreso.getText();

        if (!nombre.isEmpty()) {
            if (!animal.isEmpty()) {
                if (!idText.isEmpty()) {
                    if (!genero.isEmpty()) {
                        if (!fechaIngresoText.isEmpty()) {
                            if (!estadoIngreso.isEmpty()) {
                                if (!fechaSalidaText.isEmpty()) {
                                    if (!adoptableText.isEmpty()) {

                                        long id = Long.parseLong(idText);
                                        //Traer fecha de ingreso
                                        String[] fechaArr = fechaIngresoText.split("-");
                                        int año = Integer.parseInt(fechaArr[0]);
                                        int mes = Integer.parseInt(fechaArr[1]);
                                        int dia = Integer.parseInt(fechaArr[2]);
                                        LocalDate fechaIngreso = LocalDate.of(año, mes, dia);
                                        boolean adoptable = Integer.parseInt(adoptableText) == 1;
                                        fechaArr = fechaSalidaText.split("-");
                                        año = Integer.parseInt(fechaArr[0]);
                                        mes = Integer.parseInt(fechaArr[1]);
                                        dia = Integer.parseInt(fechaArr[2]);
                                        LocalDate fechaSalida = LocalDate.of(año, mes, dia);

                                        Animal HojadeVida = new Animal(id, nombre, animal, genero, fechaIngreso, fechaSalida, adoptable, estadoIngreso);
                                        JOptionPane.showMessageDialog(null, "La historia clinica se ha guardado");
                                        Tidentificacion.setText("");
                                        Tnombre.setText("");
                                        Tanimal.setText("");
                                        Tgenero.setText("");
                                        TfIngreso.setText("");
                                        TeIngreso.setText("");
                                        TfSalida.setText("");
                                        Tadoptable.setText("");

                                        //Agrega la hoja de vida del animal 
                                        LAnimales.pushBack(HojadeVida);

                                    } else {
                                        JOptionPane.showMessageDialog(null, "El espacio Adoptable esta vacio");

                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "El espacio Fecha de salida esta vacio");

                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "El espacio Estado de ingreso esta vacio");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "El espacio Fecha de ingreso esta vacio");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "El espacio Genero esta vacio");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El espacio identificacion esta vacio");
                }

            } else {
                JOptionPane.showMessageDialog(null, "El espacio Animal  esta vacio");
            }

        } else {
            JOptionPane.showMessageDialog(null, "El espacio Nombre  esta vacio");
        }
    }//GEN-LAST:event_BagregarMouseClicked

    private void BmostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmostrarActionPerformed
        Object o[] = null;
        if (!LAnimales.isEmpty() /*&& model.getRowCount() < LAnimales.getNumeroElementos()*/) {
            for (int i = 0; i < LAnimales.getNumeroElementos(); i++) {
                Animal L1 = (Animal) LAnimales.get(i);
                model.addRow(o);
                model.setValueAt(L1.getId(), i, 0);
                model.setValueAt(L1.getNombre(), i, 1);
                model.setValueAt(L1.getAnimal(), i, 2);
                model.setValueAt(L1.getGenero(), i, 3);
                model.setValueAt(L1.getFechaIngreso(), i, 4);
                model.setValueAt(L1.getEstadoIngreso(), i, 5);
                model.setValueAt(L1.getFechaSalida(), i, 6);
                model.setValueAt(L1.isAdoptable(), i, 7);

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay mas historias clinicas de animales");
        }
    }//GEN-LAST:event_BmostrarActionPerformed

    private void BbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BbuscarActionPerformed
        boolean encontrar = false;
        if (LAnimales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay historias clinicas para buscar ");
        } else {
            try {
                String b = Tbuscar.getText();
                int IDbuscar = Integer.valueOf(b);

                for (int i = 0; i < LAnimales.getNumeroElementos() && !encontrar; i++) {
                    Animal L2 = (Animal) LAnimales.get(i);
                    if (IDbuscar == L2.getId()) {
                        JOptionPane.showMessageDialog(null, "La informacion es " + "\n" + "Identificación: " + L2.getId() + "Nombre: " + L2.getNombre() + "\n " + "Tipo animal: " + L2.getAnimal() + "\n " + "Genero: " + L2.getGenero() + "\n " + "Fecha de ingreso: " + L2.getFechaIngreso() + "\n " + "Estado ingreso: " + L2.getEstadoIngreso() + "\n " + "Adoptabilidad: " + L2.isAdoptable());
                        encontrar = true;
                    }
                }
                if (encontrar == false) {
                    JOptionPane.showMessageDialog(null, "La historia clinica no esta ");
                    Tbuscar.setText(" ");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingresa la identificación de la historia clinica , debe ser un número.", "Errors", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BbuscarActionPerformed

    private void BeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliminarActionPerformed
        boolean eliminar = false;
        if (LAnimales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay historias clinicas para eliminar ");
        } else {
            try {
                String elm = Tbuscar.getText();
                int IDeliminar = Integer.parseInt(elm);

                for (int i = 0; i < LAnimales.getNumeroElementos() && !eliminar; i++) {
                    Animal L3 = (Animal) LAnimales.get(i);
                    if (/*!Lcontacto.isEmpty() &&*/IDeliminar == L3.getId()) {
                        JOptionPane.showMessageDialog(null, "La siguiente informacion fue eliminada " + "\n" + "Identificación: " + L3.getId() + "Nombre: " + L3.getNombre() + "\n " + "Tipo animal: " + L3.getAnimal() + "\n " + "Genero: " + L3.getGenero() + "\n " + "Fecha de ingreso: " + L3.getFechaIngreso() + "\n " + "Estado ingreso: " + L3.getEstadoIngreso() + "\n " + "Adoptabilidad: " + L3.isAdoptable());
                        LAnimales.remove(new Animal(IDeliminar));
                        eliminar = true;
                        Crear();
                        Tbuscar.setText("");
                    }

                }
                if (eliminar == false) {
                    JOptionPane.showMessageDialog(null, "La historia clinica no esta  ");
                    Tbuscar.setText(" ");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, " Ingresa la identificación del animal, debe ser un número.", "Errors", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BeliminarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int seleccion = jTable1.getSelectedRow();
        Tidentificacion.setText(String.valueOf(jTable1.getValueAt(seleccion, 0)));
        Tnombre.setText(String.valueOf(jTable1.getValueAt(seleccion, 1)));
        Tanimal.setText(String.valueOf(jTable1.getValueAt(seleccion, 2)));
        Tgenero.setText(String.valueOf(jTable1.getValueAt(seleccion, 3)));
        TfIngreso.setText(String.valueOf(jTable1.getValueAt(seleccion, 4)));
        TeIngreso.setText(String.valueOf(jTable1.getValueAt(seleccion, 5)));
        TfSalida.setText(String.valueOf(jTable1.getValueAt(seleccion, 6)));
        Tadoptable.setText(String.valueOf(jTable1.getValueAt(seleccion, 7)));

    }//GEN-LAST:event_jTable1MouseClicked

    private void BeditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeditarMouseClicked
        int seleccion = jTable1.getSelectedRow();
        Animal L4 = (Animal) LAnimales.get(seleccion);
        if (!LAnimales.isEmpty() && seleccion >= 0) {
            L4.setIdAnimal(Long.parseLong(Tidentificacion.getText()));
            L4.setNombre(Tnombre.getText());
            L4.setAnimal(Tanimal.getText());
            L4.setGenero(Tgenero.getText());
            String[] fechaArr = TfIngreso.getText().split("-");
            int año = Integer.parseInt(fechaArr[0]);
            int mes = Integer.parseInt(fechaArr[1]);
            int dia = Integer.parseInt(fechaArr[2]);
            L4.setFechaIngreso(LocalDate.of(año, mes, dia));
            L4.setEstadoIngreso(TeIngreso.getText());
            if (!"null".equals(TfSalida.getText())){
            fechaArr = TfSalida.getText().split("-");
            año = Integer.parseInt(fechaArr[0]);
            mes = Integer.parseInt(fechaArr[1]);
            dia = Integer.parseInt(fechaArr[2]);
            L4.setFechaSalida(LocalDate.of(año, mes, dia));
            }else{
                L4.setFechaSalida(null);
            }
            L4.setAdoptable(Boolean.parseBoolean(Tadoptable.getText()));
            JOptionPane.showMessageDialog(null, "La informacion de la historia clinica fue editada ");
            Crear();
            Tidentificacion.setText("");
            Tnombre.setText("");
            Tanimal.setText("");
            Tgenero.setText("");
            TfIngreso.setText("");
            TeIngreso.setText("");
            TfSalida.setText("");
            Tadoptable.setText("");
        }

    }//GEN-LAST:event_BeditarMouseClicked
    //Exportar
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(
                    new FileOutputStream("data\\" + "HistoriasClinicas" + ".dat"));
            for (int i = 0; i < LAnimales.getNumeroElementos(); i++) {

                Animal o = (Animal) LAnimales.get(i);
                escribiendoFichero.writeObject(o);

            }
            escribiendoFichero.writeObject(null);
            escribiendoFichero.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha ocuriddo un error exportando el archivo"
                    + e.getMessage());
        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed
    //importar
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            ObjectInputStream leyendoFichero = new ObjectInputStream(
                    new FileInputStream("data\\" + "HistoriasClinicas" + ".dat"));

            //Se lee el primer objeto
            Object aux = leyendoFichero.readObject();
            //Mientras haya objetos
            while (aux != null) {
                if (aux instanceof Object) {
                    LAnimales.pushBack(aux);
                }

                aux = leyendoFichero.readObject();

            }
            leyendoFichero.close();
            JOptionPane.showMessageDialog(null, "Se ha importado correctamente las hojas de vida");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error obteniendo los datos");
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void TidentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TidentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TidentificacionActionPerformed

    private void TanimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TanimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TanimalActionPerformed

    private void TeIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TeIngresoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Crear();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioLinkedList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioLinkedList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioLinkedList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioLinkedList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioLinkedList().setVisible(true);
            }
        });
    }
    DefaultTableModel model;

    private void Crear() {
        try {
            model = (new DefaultTableModel(
                    null, new String[]{
                        "Identificacion", "Nombre", "Animal", "Genero", "Fecha ingreso", "Estado ingreso", "Fecha salida", "Adoptable"}) {
            });
            jTable1.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bagregar;
    private javax.swing.JButton Bbuscar;
    private javax.swing.JButton Beditar;
    private javax.swing.JButton Beliminar;
    private javax.swing.JButton Bmostrar;
    private javax.swing.JTextField Tadoptable;
    private javax.swing.JTextField Tanimal;
    private javax.swing.JTextField Tbuscar;
    private javax.swing.JTextField TeIngreso;
    private javax.swing.JTextField TfIngreso;
    private javax.swing.JTextField TfSalida;
    private javax.swing.JTextField Tgenero;
    private javax.swing.JTextField Tidentificacion;
    private javax.swing.JTextField Tnombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
