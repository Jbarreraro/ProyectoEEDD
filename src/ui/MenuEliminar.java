package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.Main;

public class MenuEliminar extends JFrame {

    public MenuEliminar() {

        // Propiedades del JFrame
        this.setTitle("Menu de Eliminar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(600, 350);
        this.getContentPane().setBackground(new Color(0xffffff));

        // Adds icon in the top left of the frame
        ImageIcon imageFrame = new ImageIcon("res/vetanimal.png");
        this.setIconImage(imageFrame.getImage());

        // Create JLabels
        JLabel jlTitle = new JLabel();
        jlTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
        jlTitle.setText("VetAnimalData");
        jlTitle.setBounds(20, 30, 550, 35);
        jlTitle.setForeground(new Color(0x92c5fc));
        jlTitle.setBackground(new Color(0x15588c));
        jlTitle.setOpaque(true);
        jlTitle.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlIndication = new JLabel("Por favor digite el nombre del animalito: ");
        jlIndication.setFont(new Font("MV Boli", Font.PLAIN, 18));
        jlIndication.setBounds(20, 80, 380, 20);

        JLabel jlNombre = new JLabel("Nombre");
        jlNombre.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlNombre.setBounds(20, 120, 150, 30);
        jlNombre.setBackground(new Color(0x92c5fc));
        jlNombre.setForeground(new Color(0x15588c));
        jlNombre.setOpaque(true);
        jlNombre.setHorizontalAlignment(JLabel.CENTER);

        //Create JtextFields
        JTextField jtNombre = new JTextField();
        jtNombre.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtNombre.setForeground(new Color(0x15588c));
        jtNombre.setBackground(new Color(0xe7fcff));
        jtNombre.setCaretColor(Color.white);
        jtNombre.setBounds(180, 120, 150, 30);
        jtNombre.setCaretColor(new Color(0x15588c));

        // Create JButtons
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnEliminar.setForeground(new Color(0x92c5fc)); //Set text color
        btnEliminar.setBackground(new Color(0x15588c));
        btnEliminar.setBounds(420, 230, 150, 50);
        //Acciones al presionar el boton de eliminar
        btnEliminar.addActionListener(
                e -> {
                    String name = jtNombre.getText();
                    if (Main.verificarExistenciaHv(name)) {
                        Main.deleteHojaDevida(name);
                        JOptionPane.showMessageDialog(null, "Se elimino la hoja de vida de " + name);
                        this.dispose();
                        new MenuPrincipal();
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un animalito llamado " + name);
                    }

                });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFocusable(false);
        btnRegresar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnRegresar.setForeground(new Color(0x92c5fc)); //Set text color
        btnRegresar.setBackground(new Color(0x15588c));
        btnRegresar.setBounds(20, 230, 150, 50);
        // Acciones cuando se oprime el boton de regresar
        btnRegresar.addActionListener(
                e
                -> {
            this.dispose();
            new MenuPrincipal();
        });

        // Adds components to the JFrame
        this.add(jlIndication);
        this.add(jlTitle);
        this.add(btnRegresar);
        this.add(btnEliminar);
        this.add(jlNombre);
        this.add(jtNombre);

        // Put the Frame in the center of the screen a make this visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
