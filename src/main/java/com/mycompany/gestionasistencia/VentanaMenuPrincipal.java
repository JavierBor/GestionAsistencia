package com.mycompany.gestionasistencia;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;


public class VentanaMenuPrincipal extends javax.swing.JFrame {
    Curso cursoActual;
    String nombreCurso;
    private Map<String, Curso> cursos = new HashMap<String, Curso>();
    
    public VentanaMenuPrincipal(Map<String, Curso> cursos) {
        initComponents();    
        this.cursos = cursos;
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        pasarAsistencia = new javax.swing.JButton();
        botonModificarAsistencia = new javax.swing.JButton();
        mostrarRegistrosBoton = new javax.swing.JButton();
        botonMostrarArchivo = new javax.swing.JButton();
        botonModificarCurso = new javax.swing.JButton();
        botonSalirDelPrograma = new javax.swing.JButton();
        tituloCurso = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pasarAsistencia.setText("Pasar Asistencia");
        pasarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarAsistenciaActionPerformed(evt);
            }
        });

        botonModificarAsistencia.setText("Modificar Asistencia");
        botonModificarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarAsistenciaActionPerformed(evt);
            }
        });

        mostrarRegistrosBoton.setText("Mostrar Registros");
        mostrarRegistrosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarRegistrosBotonActionPerformed(evt);
            }
        });

        botonMostrarArchivo.setText("Mostrar Archivo");
        botonMostrarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarArchivoActionPerformed(evt);
            }
        });

        botonModificarCurso.setText("Modificar Curso");
        botonModificarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarCursoActionPerformed(evt);
            }
        });

        botonSalirDelPrograma.setText("Salir del Programa");
        botonSalirDelPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirDelProgramaActionPerformed(evt);
            }
        });

        tituloCurso.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        tituloCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCurso.setText("Colegio Jinetes del Bien");
        tituloCurso.setToolTipText("");
        tituloCurso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pasarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonModificarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(mostrarRegistrosBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonModificarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonMostrarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonSalirDelPrograma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pasarAsistencia)
                .addGap(12, 12, 12)
                .addComponent(botonModificarAsistencia)
                .addGap(12, 12, 12)
                .addComponent(mostrarRegistrosBoton)
                .addGap(12, 12, 12)
                .addComponent(botonModificarCurso)
                .addGap(12, 12, 12)
                .addComponent(botonMostrarArchivo)
                .addGap(12, 12, 12)
                .addComponent(botonSalirDelPrograma)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonModificarAsistencia, botonModificarCurso, botonMostrarArchivo, botonSalirDelPrograma, mostrarRegistrosBoton, pasarAsistencia});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón para pasar asistencia por curso
    private void pasarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarAsistenciaActionPerformed
        // Solicitar el nombre del alumno
        String nombreCurso = JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):");
        
        // Verificar si el nombre es válido
        if (nombreCurso != null && cursos.containsKey(nombreCurso)) {
            cursoActual = (Curso) cursos.get(nombreCurso);
            try {
                cursoActual.modAsistencia();
            } catch (IOException ex) {
                Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (nombreCurso != null && !cursos.containsKey(nombreCurso)){
            JOptionPane.showMessageDialog(this, "Curso no válido.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pasarAsistenciaActionPerformed

    //Botón para modificar la asistencia de un alumno
    private void botonModificarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonModificarAsistenciaActionPerformed

    //Botón para mostrar los registros, ya sea por curso, por alumno (rut) o alumnos en riesgo (Asistencia < 70%)
    private void mostrarRegistrosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarRegistrosBotonActionPerformed
        // Crear la ventana principal
        JFrame frame = new JFrame("Panel de Opciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLocationRelativeTo(null); // Centrar ventana
        
        // Crear el panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("¿Qué opción desea?", SwingConstants.CENTER), BorderLayout.NORTH);

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        String[] opciones = {"Curso", "Alumno", "Alumnos Riesgo"};

        //Switch para manipular cada opción por separado
        for (String opcion : opciones) {
            JButton button = new JButton(opcion);
            button.addActionListener(e -> {
                switch (opcion) {
                    case "Curso":
                        nombreCurso = (JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):")).toLowerCase();
                        //Verificar que el curso existe
                        if (nombreCurso != null && cursos.containsKey(nombreCurso)) {
                            cursoActual = (Curso) cursos.get(nombreCurso);
                            VentanaRegistrosCurso listado = new VentanaRegistrosCurso(cursoActual);
                            listado.setVisible(true);
                        }
                        else if (nombreCurso != null && !cursos.containsKey(nombreCurso)){
                            JOptionPane.showMessageDialog(this, "Curso no existe!.", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                        
                    case "Alumno":                    
                        nombreCurso = (JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):")).toLowerCase();
                        //Verificar que el curso existe
                        if (nombreCurso != null && cursos.containsKey(nombreCurso)) {
                            cursoActual = (Curso) cursos.get(nombreCurso);
                            String rutAlumno = (JOptionPane.showInputDialog("Ingrese el RUT del Alumno (Ej: 11222333-4):")).toLowerCase();
                            cursoActual.mostrarRegistroAlumno(rutAlumno);                                          
                        }
                        else if (nombreCurso != null && !cursos.containsKey(nombreCurso)){
                            JOptionPane.showMessageDialog(this, "Curso no existe!.", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                        
                    case "Alumnos Riesgo":
                        nombreCurso = (JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):")).toLowerCase();
                        if (nombreCurso != null && cursos.containsKey(nombreCurso)) {
                            cursoActual = (Curso) cursos.get(nombreCurso);
                            VentanaAlumnosEnRiesgo listadoRiesgo = new VentanaAlumnosEnRiesgo(cursoActual);
                            listadoRiesgo.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Curso no existe!.", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
            });
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);   
    }//GEN-LAST:event_mostrarRegistrosBotonActionPerformed

    private void botonMostrarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonMostrarArchivoActionPerformed

    private void botonModificarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarCursoActionPerformed
        // TODO add your handling code here:
        // Solicitar el nombre del alumno
        String nombreCurso = JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):").toLowerCase();
        VentanaModificarDatos ventana;
        // Verificar si el nombre es válido
        if (nombreCurso != null && cursos.containsKey(nombreCurso)) {
            cursoActual = (Curso) cursos.get(nombreCurso);
            ventana = new VentanaModificarDatos(cursoActual);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
        }
        else if (nombreCurso != null && !cursos.containsKey(nombreCurso)){
            JOptionPane.showMessageDialog(this, "Curso no válido.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        ventana = null;
    }//GEN-LAST:event_botonModificarCursoActionPerformed

    private void botonSalirDelProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirDelProgramaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirDelProgramaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificarAsistencia;
    private javax.swing.JButton botonModificarCurso;
    private javax.swing.JButton botonMostrarArchivo;
    private javax.swing.JButton botonSalirDelPrograma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton mostrarRegistrosBoton;
    private javax.swing.JButton pasarAsistencia;
    private javax.swing.JLabel tituloCurso;
    // End of variables declaration//GEN-END:variables
}
