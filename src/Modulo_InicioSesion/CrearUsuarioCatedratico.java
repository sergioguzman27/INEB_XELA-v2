/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_InicioSesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wilson Xicará y SERGIO MALDONADO
 */
public class CrearUsuarioCatedratico extends javax.swing.JFrame {
    private Connection conexion;
    private JFrame ventanaPadre;
    private boolean hacerVisible;
    private ArrayList<Integer> listaIDCatedraticos;
    private int indexCat;
    /**
     * Creates new form CrearCat
     */
    
    public CrearUsuarioCatedratico() {
        initComponents();
    }
    public CrearUsuarioCatedratico(Connection conexion, JFrame ventanaPadre){
        initComponents();
        this.conexion = conexion;
        this.ventanaPadre = ventanaPadre;
        hacerVisible = true;
        
        // Obtengo el listado de todos los Catedráticos que no tienen una cuenta de usuario
        try {
            Statement sentencia = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            ResultSet cCatedraticos = sentencia.executeQuery("SELECT C.Id, C.DPI, C.Nombres, C.Apellidos FROM catedratico C "
                    + "LEFT JOIN usuarios U ON C.Id = U.Catedratico_Id "
                    + "WHERE U.Id IS NULL");
            DefaultTableModel modelCatedraticos = (DefaultTableModel)tabla_catedraticos.getModel();
            listaIDCatedraticos = new ArrayList<>();
            int contador = 0;
            while(cCatedraticos.next()) {
                listaIDCatedraticos.add(cCatedraticos.getInt("Id"));
                modelCatedraticos.addRow(new String[]{
                    ""+(++contador),
                    cCatedraticos.getString("DPI"),
                    cCatedraticos.getString("Nombres"),
                    cCatedraticos.getString("Apellidos")
                });
            }   // Hasta aquí se garantiza la obtención de todos los Catedráticos sin cuenta de usuario
            // Otras configuraciones importantes
            this.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se puede obtener el listado de Catedráticos sin Cuenta de usuario.\n\nDescripción:\n"+ex.getMessage(), "Error en conexión", JOptionPane.ERROR_MESSAGE);
            hacerVisible = false;
            Logger.getLogger(CrearUsuarioCatedratico.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventanaPadre.setEnabled(!hacerVisible); // Si no se mostrará esta ventana, habilito ventanaPadre para evitar que quede inhabilitada
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
        regresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombre_completo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dpi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nombre_usuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        confirmacion = new javax.swing.JPasswordField();
        crear_usuario = new javax.swing.JButton();
        elegir_catedratico = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_catedraticos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuarios para Catedráticos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creacion de Usuarios para Catedraticos");

        regresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras(25x26).PNG"))); // NOI18N
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuenta de Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nombre completo:");

        nombre_completo.setEditable(false);
        nombre_completo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("DPI:");

        dpi.setEditable(false);
        dpi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Usuario:");

        nombre_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Contraseña:");

        contraseña.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Confirmar Contraseña:");

        confirmacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        crear_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        crear_usuario.setText("Crear Usuario");
        crear_usuario.setEnabled(false);
        crear_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_usuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(confirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(crear_usuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dpi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombre_completo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        elegir_catedratico.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        elegir_catedratico.setText(">");
        elegir_catedratico.setEnabled(false);
        elegir_catedratico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elegir_catedraticoActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Catedráticos disponibles (sin cuenta de usuario):", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tabla_catedraticos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_catedraticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "DPI", "Nombres", "Apellidos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_catedraticos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla_catedraticos.setRowHeight(25);
        tabla_catedraticos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla_catedraticos.getTableHeader().setReorderingAllowed(false);
        tabla_catedraticos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_catedraticosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_catedraticos);
        if (tabla_catedraticos.getColumnModel().getColumnCount() > 0) {
            tabla_catedraticos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabla_catedraticos.getColumnModel().getColumn(1).setPreferredWidth(125);
            tabla_catedraticos.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabla_catedraticos.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elegir_catedratico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(regresar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regresar)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 51, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(elegir_catedratico)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaPadre.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        ventanaPadre.setEnabled(true);
        this.dispose();        
    }//GEN-LAST:event_regresarActionPerformed

    private void tabla_catedraticosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_catedraticosMousePressed
        if (!elegir_catedratico.isEnabled())
            elegir_catedratico.setEnabled(true);
    }//GEN-LAST:event_tabla_catedraticosMousePressed

    private void elegir_catedraticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elegir_catedraticoActionPerformed
        // La tabla tiene la propiedad de que sólo se puede seleccionar una fila
        indexCat = tabla_catedraticos.getSelectedRow();
        // Cargo los datos del catedrático seleccionado
        nombre_completo.setText(tabla_catedraticos.getValueAt(tabla_catedraticos.getSelectedRow(), 2).toString()+" "+tabla_catedraticos.getValueAt(tabla_catedraticos.getSelectedRow(), 3).toString());
        dpi.setText(tabla_catedraticos.getValueAt(tabla_catedraticos.getSelectedRow(), 1).toString());
        contraseña.setText("");
        confirmacion.setText("");
        if (!crear_usuario.isEnabled())
            crear_usuario.setEnabled(true);
        // Al seleccionar un registro, se cargan sus datos y se borran los datos de la selección anterior
    }//GEN-LAST:event_elegir_catedraticoActionPerformed

    private void crear_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_usuarioActionPerformed
        // Condiciones para validar que la cuenta de usuario no tenga campos vacíos
        if (nombre_usuario.getText().length() == 0)
            JOptionPane.showMessageDialog(this, "El nombre de usuario no puede ser nulo", "Error en datos", JOptionPane.ERROR_MESSAGE);
        else if (!comparar_contraseñas(contraseña.getPassword(), confirmacion.getPassword()))
            JOptionPane.showMessageDialog(this, "La contrseña y su confirmación no coinciden", "Error en datos", JOptionPane.ERROR_MESSAGE);
        else {
            // Llamo a la función dentro de la Base de Datos que crea el Usuario.
            // Retorna 1 si el usuario es creado, o -1 si el nombre de usuario ya existe.
            // Debido a que al seleccionar un nuevo catedrático se inicia todo nuevamente, la fila seleccionada es al que se le creará un usuario
            try {
                conexion.prepareStatement("START TRANSACTION");
                ResultSet cUsuarios = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)
                        .executeQuery("SELECT nuevoUsuario('"+nombre_usuario.getText()+"', '"+String.valueOf(contraseña.getPassword())+"', 3, "+listaIDCatedraticos.get(indexCat)+", 0)");
                cUsuarios.next();
                if (cUsuarios.getInt(1) == 1) {
                    JOptionPane.showMessageDialog(this, "Se ha creado el usuario '"+nombre_usuario.getText()+"' exitosamente.", "Usuario creado", JOptionPane.INFORMATION_MESSAGE);
                    // Limpieza de los campos
                    nombre_completo.setText("");
                    dpi.setText("");
                    nombre_usuario.setText("");
                    contraseña.setText("");
                    confirmacion.setText("");
                    crear_usuario.setEnabled(false);
                    // Eliminación del registro de la tabla
                    int contFil = tabla_catedraticos.getRowCount(), contCol = tabla_catedraticos.getColumnCount(), fil, col;
                    for (fil=indexCat+1; fil<contFil; fil++)
                        for(col=1; col<contCol; col++)
                            tabla_catedraticos.setValueAt((String)tabla_catedraticos.getValueAt(fil, col), fil-1, col);
                    ((DefaultTableModel)tabla_catedraticos.getModel()).setRowCount(contFil-1);  // Elimino la última fila
                    elegir_catedratico.setEnabled(false);   // Se habilitará hasta seleccionar otro catedrático
                    conexion.prepareStatement("COMMIT;");
                } else  // Se repite el nombre de usuario
                    JOptionPane.showMessageDialog(this, "El usuario "+nombre_usuario.getText()+" ya existe.", "Datos repetidos", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                try {
                    conexion.prepareStatement("ROLLBACK;");
                    JOptionPane.showMessageDialog(this, "No se puede crear la nueva Cuenta de Usuario.\n\nDescripción:\n"+ex.getMessage(), "Error en conexión", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(CrearUsuarioCatedratico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex1) {
                    Logger.getLogger(CrearUsuarioCatedratico.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        }
    }//GEN-LAST:event_crear_usuarioActionPerformed
    /**
     * Función que compara si la contraseña y su confirmación son iguales. El componente JPasswordField oculta el texto que
     * es la contraseña y la devuelve como un arreglo de tipo char.
     * @param contraseña arreglo de caracteres que es la contraseña.
     * @param confirmacion arreglo de caracteres que representa la repetición de la contraseña.
     * @return 'true' si la contraseña y su confirmación son iguales; 'false' en caso contrario.
     */
    private boolean comparar_contraseñas(char[] contraseña, char[] confirmacion) {
        if (contraseña.length != confirmacion.length)
            return false;
        int cont = contraseña.length;
        for(int i=0; i<cont; i++) {
            if (contraseña[i] != confirmacion[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean getHacerVisible() { return hacerVisible; }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuarioCatedratico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuarioCatedratico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmacion;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton crear_usuario;
    private javax.swing.JTextField dpi;
    private javax.swing.JButton elegir_catedratico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre_completo;
    private javax.swing.JTextField nombre_usuario;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tabla_catedraticos;
    // End of variables declaration//GEN-END:variables
}
