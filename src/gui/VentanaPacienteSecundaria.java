package gui;

import clases.Direccion;
import clases.Paciente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import listeners.GuardarBinarios;
import listeners.FuncionesAuxiliares;
import static listeners.FuncionesAuxiliares.mensajeVentana;
import listeners.LeerBinarios;

/**
 *
 * @author Jhon
 */
public class VentanaPacienteSecundaria extends javax.swing.JDialog {
    private java.awt.Frame ventana;
    private ArrayList <Paciente> pacientes= new ArrayList<>();
    /**
     * Crea una nueva forma de DialogMensaje
     * @param parent variable de tipo frame que hereda del padre
     * @param modal variable de tipo bool
     */
    public VentanaPacienteSecundaria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ventana=parent;
        setLocationRelativeTo(null);
    }
    
    /**
     *  Guarda los datos del paciente en el archivo paciente.dat
     */
    public void guardarPaciente(){
        
        if(verificarDatos()&&generarIdHistorial())
        {
            leerDatos();
            Direccion direccion = new Direccion();
            direccion.setCiudad(txtCiudad.getText());
            direccion.setCalle(txtCalle.getText());
            direccion.setNumero(txtNumero.getText());

            Paciente paciente=new Paciente();
            paciente.setNombre(txtNombre.getText());
            paciente.setApellidos(txtApellidos.getText());
            paciente.setCedula(txtCedula.getText());
            paciente.setTelefono(txtTelefono.getText());
            paciente.setDireccion(direccion);
            paciente.setIdHistorial(txtHistorial.getText());
            pacientes.add(paciente);
            GuardarBinarios.guardarPaciente(pacientes,ventana);
            mensajeVentana("INFORMACIÓN","Se añadio el paciente",ventana);
        }
    }
    
    /**
     * verifica que los campos contengan información retorna un bool
     * @return retrona un valor falso si encuenra un campo vacío
     */
    public boolean verificarDatos(){
        boolean verificar=true;
        String mensaje="";
        if(txtNombre.getText().equals("")){
            mensaje+="Llene el campo nombre\n";
            verificar=false;
        }
        if(txtApellidos.getText().equals("")){
            mensaje+="Llene el campo apellido\n";
            verificar=false;
        }
        if(txtCedula.getText().equals("")){
            mensaje+="Llene el campo cédula\n";
            verificar=false;
        }
        if(txtTelefono.getText().equals("")){
            mensaje+="Llene el campo teléfono\n";
            verificar=false;
        }
        if(txtCiudad.getText().equals("")){
            mensaje+="Llene el campo ciudad\n";
            verificar=false;
        }
        if(txtCalle.getText().equals("")){
            mensaje+="Llene el campo calle\n";
            verificar=false;
        }
        if(txtNumero.getText().equals("")){
            mensaje+="Llene el campo número\n";
            verificar=false;
        }
        if(!verificar){
            mensajeVentana("ATENCIÓN",mensaje,ventana);
        }
        
        return verificar;
    }
     
    /**
     * Obtiene los datos del archivo paciente.dat
     */
    public void leerDatos(){
           //Verifica si existe el archivo para proceder a leerlo
        File archivo =new File("paciente.med");
        if(archivo.canRead()){
            //recupera los datos del archivo paciente y los guarda en la variable
            pacientes= LeerBinarios.obtenerPacientes(ventana);
        }
        
    }
      
    /**
     * genera el código de idHistorial
     * @return retorna un valor verdadero si el código se genera con éxito
     */
    public boolean generarIdHistorial(){
        String cedula, nombre, apellido, idHistorial;
        boolean verificar;
        nombre= txtNombre.getText().toUpperCase();
        apellido=txtApellidos.getText().toUpperCase();
        cedula=txtCedula.getText();
        
        
        idHistorial=FuncionesAuxiliares.generaCodigoHistorial(cedula, nombre, apellido,ventana);
        if(idHistorial.length()==11){
            txtHistorial.setText(idHistorial);
            verificar=true;
        }else{
            verificar=false;
            mensajeVentana("ERROR","No se pudo generar el código del historial \n\n Revise todos los campos",ventana);
        }
        
        return verificar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMensaje = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        btnAceptar1 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        lblCalle = new javax.swing.JLabel();
        lblCiudad = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        lblNumero = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtHistorial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TItulo");
        setUndecorated(true);

        pnlMensaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAceptar1.setBackground(java.awt.Color.blue);
        btnAceptar1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnAceptar1.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar1.setText("Aceptar");
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Paciente");

        btnCancelar.setBackground(java.awt.Color.red);
        btnCancelar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Salir");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblNombre.setText("Nombres:");

        txtNombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtApellidos.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lblApellido.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblApellido.setText("Apellidos:");

        lblTelefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblTelefono.setText("Teléfono:");

        txtTelefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        lblCedula.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblCedula.setText("Cédula:");

        txtCedula.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        txtNumero.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lblCalle.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblCalle.setText("Calle:");

        lblCiudad.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblCiudad.setText("Ciudad:");

        txtCalle.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txtCiudad.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lblNumero.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblNumero.setText("Número:");

        lblId.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblId.setText("ID Historial:");

        txtHistorial.setEditable(false);
        txtHistorial.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre)
                                    .addComponent(lblApellido)
                                    .addComponent(lblTelefono)
                                    .addComponent(lblCedula)
                                    .addComponent(lblId)
                                    .addComponent(lblNumero)
                                    .addComponent(lblCiudad)
                                    .addComponent(lblCalle))
                                .addGap(33, 33, 33)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout pnlMensajeLayout = new javax.swing.GroupLayout(pnlMensaje);
        pnlMensaje.setLayout(pnlMensajeLayout);
        pnlMensajeLayout.setHorizontalGroup(
            pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMensajeLayout.setVerticalGroup(
            pnlMensajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        // TODO add your handling code here:
        guardarPaciente();
        btnAceptar1.setEnabled(false);

    }//GEN-LAST:event_btnAceptar1ActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        if ("0123456789".indexOf(evt.getKeyChar())<0)
        {
            if (evt.getKeyChar()!=(char)KeyEvent.VK_DELETE)
            {

                evt.consume();
            }
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        // TODO add your handling code here:
        if ("0123456789".indexOf(evt.getKeyChar())<0)
        {
            if (evt.getKeyChar()!=(char)KeyEvent.VK_DELETE)
            {

                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // Sale de la Forma
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCalle;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlMensaje;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtHistorial;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
