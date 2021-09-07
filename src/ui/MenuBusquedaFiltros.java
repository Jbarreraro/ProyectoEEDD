package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import logic.Main;

public class MenuBusquedaFiltros extends JFrame {

  

    public static void main(String[] args) {
        new MenuBusquedaFiltros();
    }

    public MenuBusquedaFiltros() {

        //Propiedades del JFrame
        this.setTitle("Menu de Busqueda Por Filtro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(1200, 800);
        this.getContentPane().setBackground(new Color(0xffffff));

        // Adds icon in the top left of the frame
        ImageIcon imageFrame = new ImageIcon("res/vetanimal.png");
        this.setIconImage(imageFrame.getImage());

        // Create JLabels
        JLabel jlTitle = new JLabel();
        jlTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
        jlTitle.setText("VetAnimalData");
        jlTitle.setBounds(20, 30, 1150, 35);
        jlTitle.setForeground(new Color(0x92c5fc));
        jlTitle.setBackground(new Color(0x15588c));
        jlTitle.setOpaque(true);
        jlTitle.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlIndication = new JLabel("Seleccione el Filtro de busqueda:");
        jlIndication.setFont(new Font("MV Boli", Font.PLAIN, 18));
        jlIndication.setHorizontalAlignment(JLabel.LEFT);
        jlIndication.setBounds(20, 80, 1150, 20);

        //Create JPane
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0x92c5fc));
        bluePanel.setBounds(20, 190, 1150, 500);
        bluePanel.setLayout(new BorderLayout());
        bluePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        bluePanel.setVisible(true);

        //Create JTable
        DefaultTableModel model = new MyModel();
        JTable jtable = new JTable(model);
        jtable.setFont(new Font("MV Boli", Font.PLAIN, 14));
        

        //Create JScrollPane an add to panel with the JTable
        bluePanel.add(new JScrollPane(jtable), BorderLayout.CENTER);

        //Create JComboBoxes
        String[] options = {"Visualizar HV´s, por fecha de ingreso ascendentemente",
            "Visualizar HV´s, por fecha de salida ascendentemente"};
        JComboBox jcFiltro = new JComboBox(options);
        jcFiltro.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jcFiltro.setForeground(new Color(0x15588c));
        jcFiltro.setBackground(new Color(0xe7fcff));
        jcFiltro.setBounds(20, 120, 630, 30);

        //Create JButtons
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnBuscar.setForeground(new Color(0x92c5fc)); //Set text color
        btnBuscar.setBackground(new Color(0x15588c));
        btnBuscar.setBounds(1020, 700, 150, 50);
        btnBuscar.addActionListener(
                e -> {

                    // Limpiamos las filas mostradas previamente
                    model.setRowCount(0);
                    
                            
                    //Obtener data de la funcion main dependiendo de la seleccion del comboBox
                    String[][] datos;
                    // Fecha Ingreso ascendente
                    if (jcFiltro.getSelectedIndex() == 0) {
                        datos = Main.getDataOrderedByFechaIngreso();
                    // Fecha Salida ascendente
                    } else {
                        datos = Main.getDataOrderedByFechaSalida();
                    }
                    
  
                    
                    if (datos.length > 0) {

                        // SE RECIBEN DATOS 
                        for (String[] fila : datos) {
                            model.addRow(fila);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "No hay hojas de vida agregadas");
                    }
                    

                });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFocusable(false);
        btnRegresar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnRegresar.setForeground(new Color(0x92c5fc)); //Set text color
        btnRegresar.setBackground(new Color(0x15588c));
        btnRegresar.setBounds(20, 700, 150, 50);
        // Acciones cuando se oprime el boton de regresar
        btnRegresar.addActionListener(
                e
                -> {
            this.dispose();
            new MenuPrincipal();
        });

        //Adds components to the JFrame
        this.add(jlTitle);
        this.add(jlIndication);
        this.add(btnBuscar);
        this.add(btnRegresar);
        this.add(jcFiltro);
        this.add(bluePanel);

        // Put the Frame in the center of the screen a make this visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    

}
