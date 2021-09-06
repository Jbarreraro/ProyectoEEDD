package ui;

import data.Animal;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import logic.Main;

public class MenuBusquedaPorNombre extends JFrame {

    public MenuBusquedaPorNombre() {

        // Propiedades del JFrame
        this.setTitle("Menu Hojas De Vida");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(600, 650);
        this.getContentPane().setBackground(new Color(0xffffff));

        // Adds icon in the top left of the frame
        ImageIcon imageFrame = new ImageIcon("res/vetanimal.png");
        this.setIconImage(imageFrame.getImage());

        //Create JLabels
        JLabel jlTitle = new JLabel();
        jlTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
        jlTitle.setText("VetAnimalData");
        jlTitle.setBounds(20, 30, 550, 35);
        jlTitle.setForeground(new Color(0x92c5fc));
        jlTitle.setBackground(new Color(0x15588c));
        jlTitle.setOpaque(true);
        jlTitle.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlIndication = new JLabel("Escriba el nombre del animal a buscar :");
        jlIndication.setFont(new Font("MV Boli", Font.PLAIN, 18));
        jlIndication.setBounds(20, 80, 380, 20);

        JLabel jlNombre = new JLabel("Nombre");
        jlNombre.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlNombre.setBounds(20, 120, 150, 30);
        jlNombre.setBackground(new Color(0x92c5fc));
        jlNombre.setForeground(new Color(0x15588c));
        jlNombre.setOpaque(true);
        jlNombre.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlAnimal = new JLabel("Animal");
        jlAnimal.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlAnimal.setBounds(20, 220, 150, 30);
        jlAnimal.setBackground(new Color(0x92c5fc));
        jlAnimal.setForeground(new Color(0x15588c));
        jlAnimal.setOpaque(true);
        jlAnimal.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlGenero = new JLabel("Genero");
        jlGenero.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlGenero.setBounds(20, 270, 150, 30);
        jlGenero.setBackground(new Color(0x92c5fc));
        jlGenero.setForeground(new Color(0x15588c));
        jlGenero.setOpaque(true);
        jlGenero.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlFechaIngreso = new JLabel("Fecha ingreso");
        jlFechaIngreso.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlFechaIngreso.setBounds(20, 320, 150, 30);
        jlFechaIngreso.setBackground(new Color(0x92c5fc));
        jlFechaIngreso.setForeground(new Color(0x15588c));
        jlFechaIngreso.setOpaque(true);
        jlFechaIngreso.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlFechaSalida = new JLabel("Fecha Salida");
        jlFechaSalida.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlFechaSalida.setBounds(20, 370, 150, 30);
        jlFechaSalida.setBackground(new Color(0x92c5fc));
        jlFechaSalida.setForeground(new Color(0x15588c));
        jlFechaSalida.setOpaque(true);
        jlFechaSalida.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlEstadoIngreso = new JLabel("Estado Ingreso");
        jlEstadoIngreso.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlEstadoIngreso.setBounds(20, 420, 150, 30);
        jlEstadoIngreso.setBackground(new Color(0x92c5fc));
        jlEstadoIngreso.setForeground(new Color(0x15588c));
        jlEstadoIngreso.setOpaque(true);
        jlEstadoIngreso.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlAdoptable = new JLabel("Adoptable");
        jlAdoptable.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlAdoptable.setBounds(20, 470, 150, 30);
        jlAdoptable.setBackground(new Color(0x92c5fc));
        jlAdoptable.setForeground(new Color(0x15588c));
        jlAdoptable.setOpaque(true);
        jlAdoptable.setHorizontalAlignment(JLabel.CENTER);

        //Create JtextFields
        JTextField jtNombre = new JTextField();
        jtNombre.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtNombre.setForeground(new Color(0x15588c));
        jtNombre.setBackground(new Color(0xe7fcff));
        jtNombre.setCaretColor(Color.white);
        jtNombre.setBounds(180, 120, 150, 30);
        jtNombre.setCaretColor(new Color(0x15588c));

        JTextField jtAnimal = new JTextField();
        jtAnimal.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtAnimal.setForeground(new Color(0x15588c));
        jtAnimal.setBackground(new Color(0xe7fcff));
        jtAnimal.setCaretColor(Color.white);
        jtAnimal.setBounds(180, 220, 150, 30);
        jtAnimal.setCaretColor(new Color(0x15588c));
        jtAnimal.setEditable(false);

        JTextField jtGenero = new JTextField();
        jtGenero.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtGenero.setForeground(new Color(0x15588c));
        jtGenero.setBackground(new Color(0xe7fcff));
        jtGenero.setCaretColor(Color.white);
        jtGenero.setBounds(180, 270, 150, 30);
        jtGenero.setCaretColor(new Color(0x15588c));
        jtGenero.setEditable(false);

        JTextField jtFechaIngreso = new JTextField();
        jtFechaIngreso.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtFechaIngreso.setForeground(new Color(0x15588c));
        jtFechaIngreso.setBackground(new Color(0xe7fcff));
        jtFechaIngreso.setCaretColor(Color.white);
        jtFechaIngreso.setBounds(180, 320, 150, 30);
        jtFechaIngreso.setCaretColor(new Color(0x15588c));
        jtFechaIngreso.setEditable(false);

        JTextField jtFechaSalida = new JTextField();
        jtFechaSalida.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtFechaSalida.setForeground(new Color(0x15588c));
        jtFechaSalida.setBackground(new Color(0xe7fcff));
        jtFechaSalida.setCaretColor(Color.white);
        jtFechaSalida.setBounds(180, 370, 150, 30);
        jtFechaSalida.setCaretColor(new Color(0x15588c));
        jtFechaSalida.setEditable(false);

        JTextField jtEstado = new JTextField();
        jtEstado.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtEstado.setForeground(new Color(0x15588c));
        jtEstado.setBackground(new Color(0xe7fcff));
        jtEstado.setCaretColor(Color.white);
        jtEstado.setBounds(180, 420, 150, 30);
        jtEstado.setCaretColor(new Color(0x15588c));
        jtEstado.setEditable(false);

        JTextField jtAdoptable = new JTextField();
        jtAdoptable.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtAdoptable.setForeground(new Color(0x15588c));
        jtAdoptable.setBackground(new Color(0xe7fcff));
        jtAdoptable.setCaretColor(Color.white);
        jtAdoptable.setBounds(180, 470, 150, 30);
        jtAdoptable.setCaretColor(new Color(0x15588c));
        jtAdoptable.setEditable(false);

        //Create Jbuttons
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnBuscar.setForeground(new Color(0x92c5fc)); //Set text color
        btnBuscar.setBackground(new Color(0x15588c));
        btnBuscar.setBounds(350, 120, 150, 30);
        // Acciones cuando se oprime el boton de buscar
        btnBuscar.addActionListener(
                e
                -> {
            String nombre = jtNombre.getText();
            Animal animal = Main.getAnimal(nombre);
            if (animal != null) {
                jtAnimal.setText(animal.getAnimal());
                jtGenero.setText(animal.getGenero());
                jtFechaIngreso.setText(String.valueOf(animal.getFechaIngreso()));
                jtFechaSalida.setText(String.valueOf(animal.getFechaSalida()));
                jtEstado.setText(animal.getEstadoIngreso());
                jtAdoptable.setText(animal.isAdoptable() ? "SI" : "NO");
            } else {
                JOptionPane.showMessageDialog(null, "No existe un animal con el nombre especificado");
            }

        });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFocusable(false);
        btnRegresar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnRegresar.setForeground(new Color(0x92c5fc)); //Set text color
        btnRegresar.setBackground(new Color(0x15588c));
        btnRegresar.setBounds(20, 550, 150, 50);
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
        this.add(jlNombre);
        this.add(jlAnimal);
        this.add(jlGenero);
        this.add(jlFechaIngreso);
        this.add(jlFechaSalida);
        this.add(jlEstadoIngreso);
        this.add(jlAdoptable);
        this.add(btnRegresar);
        this.add(btnBuscar);
        this.add(jtNombre);
        this.add(jtAnimal);
        this.add(jtGenero);
        this.add(jtFechaIngreso);
        this.add(jtFechaSalida);
        this.add(jtAdoptable);
        this.add(jtEstado);

        // Put the Frame in the center of the screen a make this visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
