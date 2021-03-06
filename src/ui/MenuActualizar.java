package ui;

import data.Animal;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.Main;

public class MenuActualizar extends JFrame {

    public MenuActualizar() {

        // Propiedades del JFrame
        this.setTitle("Menu de Actualizar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(600, 600);
        this.getContentPane().setBackground(new Color(0xffffff));

        // Create JLabels
        JLabel jlTitle = new JLabel();
        jlTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
        jlTitle.setText("VetAnimalData");
        jlTitle.setBounds(20, 30, 550, 35);
        jlTitle.setForeground(new Color(0x92c5fc));
        jlTitle.setBackground(new Color(0x15588c));
        jlTitle.setOpaque(true);
        jlTitle.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlIndication = new JLabel("Por favor llene los siguientes campos:");
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
        jlAnimal.setBounds(20, 170, 150, 30);
        jlAnimal.setBackground(new Color(0x92c5fc));
        jlAnimal.setForeground(new Color(0x15588c));
        jlAnimal.setOpaque(true);
        jlAnimal.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlGenero = new JLabel("Genero");
        jlGenero.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlGenero.setBounds(20, 220, 150, 30);
        jlGenero.setBackground(new Color(0x92c5fc));
        jlGenero.setForeground(new Color(0x15588c));
        jlGenero.setOpaque(true);
        jlGenero.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlFechaIngreso = new JLabel("Fecha ingreso");
        jlFechaIngreso.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlFechaIngreso.setBounds(20, 270, 150, 30);
        jlFechaIngreso.setBackground(new Color(0x92c5fc));
        jlFechaIngreso.setForeground(new Color(0x15588c));
        jlFechaIngreso.setOpaque(true);
        jlFechaIngreso.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlFechaSalida = new JLabel("Fecha Salida");
        jlFechaSalida.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlFechaSalida.setBounds(20, 320, 150, 30);
        jlFechaSalida.setBackground(new Color(0x92c5fc));
        jlFechaSalida.setForeground(new Color(0x15588c));
        jlFechaSalida.setOpaque(true);
        jlFechaSalida.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlEstadoIngreso = new JLabel("Estado Ingreso");
        jlEstadoIngreso.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlEstadoIngreso.setBounds(20, 370, 150, 30);
        jlEstadoIngreso.setBackground(new Color(0x92c5fc));
        jlEstadoIngreso.setForeground(new Color(0x15588c));
        jlEstadoIngreso.setOpaque(true);
        jlEstadoIngreso.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlAdoptable = new JLabel("Adoptable");
        jlAdoptable.setFont(new Font("MV Boli", Font.BOLD, 20));
        jlAdoptable.setBounds(20, 420, 150, 30);
        jlAdoptable.setBackground(new Color(0x92c5fc));
        jlAdoptable.setForeground(new Color(0x15588c));
        jlAdoptable.setOpaque(true);
        jlAdoptable.setHorizontalAlignment(JLabel.CENTER);

        // Adds icon in the top left of the frame
        ImageIcon imageFrame = new ImageIcon("res/vetanimal.png");
        this.setIconImage(imageFrame.getImage());

        // Create JtextFields
        JTextField jtNombre = new JTextField();
        jtNombre.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtNombre.setForeground(new Color(0x15588c));
        jtNombre.setBackground(new Color(0xe7fcff));
        jtNombre.setCaretColor(Color.white);
        jtNombre.setBounds(180, 120, 150, 30);
        jtNombre.setCaretColor(new Color(0x15588c));

        JTextField jtFechaIngreso = new JTextField();
        jtFechaIngreso.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtFechaIngreso.setForeground(new Color(0x15588c));
        jtFechaIngreso.setBackground(new Color(0xe7fcff));
        jtFechaIngreso.setCaretColor(Color.white);
        jtFechaIngreso.setBounds(180, 270, 150, 30);
        jtFechaIngreso.setCaretColor(new Color(0x15588c));
        jtFechaIngreso.setText("AAAA/MM/DD");
        jtFechaIngreso.setEnabled(false);

        JTextField jtFechaSalida = new JTextField();
        jtFechaSalida.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jtFechaSalida.setForeground(new Color(0x15588c));
        jtFechaSalida.setBackground(new Color(0xe7fcff));
        jtFechaSalida.setCaretColor(Color.white);
        jtFechaSalida.setBounds(180, 320, 150, 30);
        jtFechaSalida.setCaretColor(new Color(0x15588c));
        jtFechaSalida.setText("AAAA/MM/DD");
        jtFechaSalida.setEnabled(false);

        // Create JComboBoxes
        String[] animals = {"PERRO", "GATO"};
        JComboBox jcAnimal = new JComboBox(animals);
        jcAnimal.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jcAnimal.setForeground(new Color(0x15588c));
        jcAnimal.setBackground(new Color(0xe7fcff));
        jcAnimal.setBounds(180, 170, 150, 30);
        jcAnimal.setEnabled(false);

        String[] generos = {"MASCULINO", "FEMENINO"};
        JComboBox jcGenero = new JComboBox(generos);
        jcGenero.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jcGenero.setForeground(new Color(0x15588c));
        jcGenero.setBackground(new Color(0xe7fcff));
        jcGenero.setBounds(180, 220, 150, 30);
        jcGenero.setEnabled(false);

        String[] estados = {"MUY MAL", "MAL", "BUENO", "MUY BUENO"};
        JComboBox jcEstado = new JComboBox(estados);
        jcEstado.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jcEstado.setForeground(new Color(0x15588c));
        jcEstado.setBackground(new Color(0xe7fcff));
        jcEstado.setBounds(180, 370, 150, 30);
        jcEstado.setEnabled(false);

        String[] adoptabilidad = {"SI", "NO"};
        JComboBox jcAdoptable = new JComboBox(adoptabilidad);
        jcAdoptable.setFont(new Font("MV Boli", Font.PLAIN, 20));
        jcAdoptable.setForeground(new Color(0x15588c));
        jcAdoptable.setBackground(new Color(0xe7fcff));
        jcAdoptable.setBounds(180, 420, 150, 30);
        jcAdoptable.setEnabled(false);

        // Create JButtons
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnActualizar.setForeground(new Color(0x92c5fc)); // Set text color
        btnActualizar.setBackground(new Color(0x15588c));
        btnActualizar.setBounds(380, 500, 180, 50);
        btnActualizar.setEnabled(false);
        // Acciones para cuando se oprima el boton actualizar
        btnActualizar.addActionListener(
                e
                -> {

            // Guardar la hoja de vida actualizada del animal
            String nombre = jtNombre.getText();
            String animal = (String) jcAnimal.getSelectedItem();
            String genero = (String) jcGenero.getSelectedItem();
            String[] fechaIng = jtFechaIngreso.getText().split("/");
            int year = Integer.parseInt(fechaIng[0]);
            int month = Integer.parseInt(fechaIng[1]);
            int day = Integer.parseInt(fechaIng[2]);
            LocalDate fechaIngreso = LocalDate.of(year, month, day);
            String[] fechaSal = jtFechaSalida.getText().split("/");
            year = Integer.parseInt(fechaSal[0]);
            month = Integer.parseInt(fechaSal[1]);
            day = Integer.parseInt(fechaSal[2]);
            LocalDate fechaSalida = LocalDate.of(year, month, day);
            String estadoIngreso = (String) jcEstado.getSelectedItem();
            boolean adoptable = (String) jcAdoptable.getSelectedItem() == "SI";
            Main.addAnimal(nombre, new Animal(nombre, animal, genero,
                    fechaIngreso, fechaSalida, adoptable, estadoIngreso));
            JOptionPane.showMessageDialog(null, "Se ha actualizado la hoja de vida de " + nombre);
            this.dispose();
            new MenuPrincipal();

        });

        JButton btnVerificar = new JButton("Verificar");
        btnVerificar.setFocusable(false);
        btnVerificar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnVerificar.setForeground(new Color(0x92c5fc)); // Set text color
        btnVerificar.setBackground(new Color(0x15588c));
        btnVerificar.setBounds(350, 120, 150, 30);
        btnVerificar.addActionListener(
                e
                -> {
            String nombre = jtNombre.getText();
            if (Main.verificarExistenciaHv(nombre)) {
                // Traer los datos del animal
                Animal animal = Main.getAnimal(nombre);

                // Actualizar con los valores del animal a los componentes
                jcAnimal.setSelectedItem(animal.getAnimal());
                jcGenero.setSelectedItem(animal.getGenero());
                String[] fechaIngreso = (String.valueOf(animal.getFechaIngreso())).split("-");
                jtFechaIngreso.setText(fechaIngreso[0] + "/" + fechaIngreso[1] + "/" + fechaIngreso[2]);
                String[] fechaSalida = (String.valueOf(animal.getFechaSalida())).split("-");
                jtFechaSalida.setText(fechaSalida[0] + "/" + fechaSalida[1] + "/" + fechaSalida[2]);
                jcEstado.setSelectedItem(animal.getEstadoIngreso());
                jcAdoptable.setSelectedItem(animal.isAdoptable() ? "SI" : "NO");

                // Habilitar los componentes para dar nuevos valores (setEnabled -> true)
                jcAnimal.setEnabled(true);
                jcGenero.setEnabled(true);
                jtFechaIngreso.setEnabled(true);
                jtFechaSalida.setEnabled(true);
                jcEstado.setEnabled(true);
                jcAdoptable.setEnabled(true);

                // Deshablilitar el componente JTextField de nombre para no agregar un nuevo animal
                jtNombre.setEnabled(false);

                // Habilitar el boton de actualizar para proceder con la acttalizacion
                btnActualizar.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "NO existe un animalito llamado " + nombre);
            }

        });

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFocusable(false);
        btnRegresar.setFont(new Font("MV Boli", Font.BOLD, 25));
        btnRegresar.setForeground(new Color(0x92c5fc)); // Set text color
        btnRegresar.setBackground(new Color(0x15588c));
        btnRegresar.setBounds(20, 500, 150, 50);
        // Acciones cuando se oprime el boton de regresar
        btnRegresar.addActionListener(e -> {
            this.dispose();
            new MenuPrincipal();
        });

        // Adds components to the JFrame
        this.add(jlIndication);
        this.add(jlTitle);
        this.add(jlNombre);
        this.add(jlAnimal);
        this.add(jlGenero);
        this.add(jlFechaIngreso);
        this.add(jlFechaSalida);
        this.add(jlEstadoIngreso);
        this.add(jlAdoptable);
        this.add(btnActualizar);
        this.add(jtNombre);
        this.add(jcAnimal);
        this.add(jcGenero);
        this.add(jcAdoptable);
        this.add(jtFechaIngreso);
        this.add(jtFechaSalida);
        this.add(jcEstado);
        this.add(btnRegresar);
        this.add(btnVerificar);

        // Put the Frame in the center of the screen a make this visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
