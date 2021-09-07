package ui;

import javax.swing.table.DefaultTableModel;

// Personalizacion del modelo asociado al Jtable 
// para no permitir que sea editable
public class MyModel extends DefaultTableModel {

    public MyModel() {
        this.addColumn("Nombre");
        this.addColumn("Animal");
        this.addColumn("Genero");
        this.addColumn("Fecha Ingreso");
        this.addColumn("Adoptable");
        this.addColumn("Fecha Salida");
        this.addColumn("Estado");
    }

    @Override
    public boolean isCellEditable(int row, int column) {

        return false;

    }

}
