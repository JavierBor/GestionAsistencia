package com.mycompany.gestionasistencia;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaModificarAlumno extends javax.swing.JFrame {
    private Alumno alumno;
    public VentanaModificarAlumno(Alumno alumno) {
        initComponents();
        this.alumno = alumno;
        nombreAlumno.setText(alumno.getNombre());
        rutAlumno.setText(alumno.getRut());
        correoAlumno.setText(alumno.getCorreo());
        numTutorAlumno.setText(String.valueOf(alumno.getNumTutor()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonModificarNombre = new javax.swing.JButton();
        botonModificarCorreo = new javax.swing.JButton();
        botonModificarTelefono = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreAlumno = new javax.swing.JLabel();
        rutAlumno = new javax.swing.JLabel();
        correoAlumno = new javax.swing.JLabel();
        numTutorAlumno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonModificarNombre.setText("Modificar nombre");
        botonModificarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarNombreActionPerformed(evt);
            }
        });

        botonModificarCorreo.setText("Modificar correo");
        botonModificarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarCorreoActionPerformed(evt);
            }
        });

        botonModificarTelefono.setText("Modificar teléfono tutor");
        botonModificarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarTelefonoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar  datos de alumno");

        nombreAlumno.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        nombreAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreAlumno.setText("nombre alumno");

        rutAlumno.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        rutAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rutAlumno.setText("rut alumno");

        correoAlumno.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        correoAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correoAlumno.setText("correo alumno");

        numTutorAlumno.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        numTutorAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numTutorAlumno.setText("numT alumno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(correoAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rutAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numTutorAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(botonModificarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonModificarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonModificarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(nombreAlumno)
                .addGap(0, 0, 0)
                .addComponent(rutAlumno)
                .addGap(0, 0, 0)
                .addComponent(correoAlumno)
                .addGap(0, 0, 0)
                .addComponent(numTutorAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonModificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonModificarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonModificarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarNombreActionPerformed
        String nombreNuevo = JOptionPane.showInputDialog("Ingrese nuevo nombre:");
        if (nombreNuevo == null) return;
        if (!nombreNuevo.isEmpty()){
            alumno.setNombre(nombreNuevo);
            nombreAlumno.setText(alumno.getNombre()); //Se llamará a al método setter del alumno
            JOptionPane.showMessageDialog(null, "Nombre registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        else{ //En caso de nombre invalido
            JOptionPane.showMessageDialog(null, "Nombre no valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botonModificarNombreActionPerformed

    private void botonModificarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarCorreoActionPerformed
        String correoNuevo = JOptionPane.showInputDialog("Ingrese nuevo correo:");
        if (correoNuevo == null) return;
        if (!correoNuevo.isEmpty()){ 
            alumno.setCorreo(correoNuevo); //Se llamará a al método setter del alumno
            JOptionPane.showMessageDialog(null, "Correo registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        else{ //En caso de correo invalido
            JOptionPane.showMessageDialog(null, "Correo no valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarCorreoActionPerformed

    private void botonModificarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarTelefonoActionPerformed
        String numTutorString = JOptionPane.showInputDialog("Ingrese el teléfono del apoderado:").trim();
        numTutorString = numTutorString.replaceAll("\\s+", "");
        if (numTutorString == null) return;
        if (numTutorString.length() == 9){
            try { //Try-Catch para manejar los casos invalidos
                int numNuevo = Integer.parseInt(numTutorString);
                alumno.setNumTutor(numNuevo); //Se llamará a al método setter del alumno
                JOptionPane.showMessageDialog(null, "Número registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número no válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El número debe tener 9 dígitos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarTelefonoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificarCorreo;
    private javax.swing.JButton botonModificarNombre;
    private javax.swing.JButton botonModificarTelefono;
    private javax.swing.JLabel correoAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreAlumno;
    private javax.swing.JLabel numTutorAlumno;
    private javax.swing.JLabel rutAlumno;
    // End of variables declaration//GEN-END:variables
}
