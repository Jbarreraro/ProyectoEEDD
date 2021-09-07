package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import logic.Main;

public class MenuPrincipal extends JFrame {

    public static void main(String[] args) {
        new MenuPrincipal();
    }

    public MenuPrincipal() {

        //Propiedades del JFrame
        this.setTitle("Menu Principal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(600, 450);
        this.getContentPane().setBackground(new Color(0xffffff));

        // Adds icon in the top left of the frame
        ImageIcon imageFrame = new ImageIcon("res/vetanimal.png");
        this.setIconImage(imageFrame.getImage());

        //Create JPanel
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(new Color(0x92c5fc));
        bluePanel.setBounds(140, 100, 310, 300);
        bluePanel.setLayout(new GridLayout(4, 1, 0, 20));
        bluePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create the Jbuttons
        JButton btnHistoriasClinicas = new JButton("Historias Clinicas");
        btnHistoriasClinicas.setFocusable(false);
        btnHistoriasClinicas.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnHistoriasClinicas.setForeground(new Color(0xffffff)); //Set text color
        btnHistoriasClinicas.setBackground(new Color(0x15588c));
        // Accion al oprimir el boton de hojas de vida
        btnHistoriasClinicas.addActionListener(
                e
                -> {
            this.dispose();
            new MenuSelTipoBusqueda();
        });

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setFocusable(false);
        btnAgregar.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnAgregar.setForeground(new Color(0xffffff)); //Set text color
        btnAgregar.setBackground(new Color(0x15588c));
        // Accion al oprimir el boton de agregar
        btnAgregar.addActionListener(
                e
                -> {
            this.dispose();
            new MenuAgregar();
        });

        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnActualizar.setForeground(new Color(0xffffff)); //Set text color
        btnActualizar.setBackground(new Color(0x15588c));
        // Acciones que se realizan cuando se oprime el boton de actualizar
        btnActualizar.addActionListener(
                e
                -> {
            this.dispose();
            new MenuActualizar();
        });

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnEliminar.setForeground(new Color(0xffffff)); //Set text color
        btnEliminar.setBackground(new Color(0x15588c));
        // Accion al oprimir el boton de eliminar
        btnEliminar.addActionListener(
                e
                -> {
            this.dispose();
            new MenuEliminar();
        });

        JButton btnGuardar = new JButton(new ImageIcon("res/save.png"));
        btnGuardar.setFocusable(false);
        btnGuardar.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnGuardar.setForeground(new Color(0xffffff)); //Set text color
        btnGuardar.setBackground(new Color(0x15588c));
        btnGuardar.setBounds(460, 300, 100, 100);
        // Accion al oprimir el boton de eliminar
        btnGuardar.addActionListener(
                e
                -> {
            try {
                Main.saveInfo();
                JOptionPane.showMessageDialog(null, "Se ha guardado la informacion");
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error guardando la informacion");
            }

        });

        //Add buttons to the JPanel Blue
        bluePanel.add(btnHistoriasClinicas);
        bluePanel.add(btnAgregar);
        bluePanel.add(btnActualizar);
        bluePanel.add(btnEliminar);

        //Create JLabel
        JLabel jlTitle = new JLabel();
        jlTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
        jlTitle.setText("VetAnimalData");
        jlTitle.setBounds(20, 30, 550, 35);
        jlTitle.setForeground(new Color(0x92c5fc));
        jlTitle.setBackground(new Color(0x15588c));
        jlTitle.setOpaque(true);
        jlTitle.setHorizontalAlignment(JLabel.CENTER);

        //Adds components to the JFrame
        this.add(bluePanel);
        this.add(jlTitle);
        this.add(btnGuardar);

        // Put the Frame in the center of the screen a make this visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
