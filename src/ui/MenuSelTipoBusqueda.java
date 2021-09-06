package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuSelTipoBusqueda extends JFrame {

    public MenuSelTipoBusqueda() {

        this.setTitle("Menu Seleccionar Tipo de busqueda");
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
        bluePanel.setBounds(140, 160, 310, 200);
        bluePanel.setLayout(new GridLayout(2, 1, 0, 20));
        bluePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //Create JLabel
        JLabel jlTitle = new JLabel();
        jlTitle.setFont(new Font("MV Boli", Font.BOLD, 40));
        jlTitle.setText("VetAnimalData");
        jlTitle.setBounds(20, 30, 550, 35);
        jlTitle.setForeground(new Color(0x92c5fc));
        jlTitle.setBackground(new Color(0x15588c));
        jlTitle.setOpaque(true);
        jlTitle.setHorizontalAlignment(JLabel.CENTER);

        JLabel jlIndicacion = new JLabel();
        jlIndicacion.setFont(new Font("MV Boli", Font.BOLD, 28));
        jlIndicacion.setText("Seleccione el tipo de busqueda: ");
        jlIndicacion.setBounds(20, 90, 550, 35);
        jlIndicacion.setHorizontalAlignment(JLabel.CENTER);

        //Create JButtons
        JButton btnMenuBusquedaPorNombre = new JButton("Por nombre");
        btnMenuBusquedaPorNombre.setFocusable(false);
        btnMenuBusquedaPorNombre.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnMenuBusquedaPorNombre.setForeground(new Color(0xffffff)); //Set text color
        btnMenuBusquedaPorNombre.setBackground(new Color(0x15588c));
        // Accion al oprimir el boton de hojas de vida
        btnMenuBusquedaPorNombre.addActionListener(
                e
                -> {
                    this.dispose();
                    new MenuBusquedaPorNombre();
        });

        JButton btnMenuBusquedaFiltro = new JButton("Con Filtros");
        btnMenuBusquedaFiltro.setFocusable(false);
        btnMenuBusquedaFiltro.setFont(new Font("MV Boli", Font.BOLD, 28));
        btnMenuBusquedaFiltro.setForeground(new Color(0xffffff)); //Set text color
        btnMenuBusquedaFiltro.setBackground(new Color(0x15588c));
        // Accion al oprimir el boton de agregar
        btnMenuBusquedaFiltro.addActionListener(
                e
                -> {
                    this.dispose();
                    new MenuBusquedaFiltros();
        });
        
        
        //Adds Jbuttons to The Jpanel blue
        bluePanel.add(btnMenuBusquedaPorNombre);
        bluePanel.add(btnMenuBusquedaFiltro);
        
        //Adds components to the JFrame
        this.add(bluePanel);
        this.add(jlTitle);
        this.add(jlIndicacion);

        // Put the Frame in the center of the screen a make this visible
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
