package com.mycompany.gestionasistencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class VentanaModificarDatos extends javax.swing.JFrame {
    private Curso curso;
    public VentanaModificarDatos(Curso curso) {
        initComponents();
        this.curso = curso; 
        subTituloCurso.setText(curso.getNombreCurso());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonAsignarProfesor = new javax.swing.JButton();
        botonModificarAlumno = new javax.swing.JButton();
        botonEliminarProfesor = new javax.swing.JButton();
        botonEliminarAlumno = new javax.swing.JButton();
        botonAgregarAlumno = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        subTituloCurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAsignarProfesor.setText("Asignar profesor");
        botonAsignarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarProfesorActionPerformed(evt);
            }
        });

        botonModificarAlumno.setText("Modificar datos de un alumno");
        botonModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarAlumnoActionPerformed(evt);
            }
        });

        botonEliminarProfesor.setText("Eliminar profesor");
        botonEliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProfesorActionPerformed(evt);
            }
        });

        botonEliminarAlumno.setText("Eliminar alumno");
        botonEliminarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarAlumnoActionPerformed(evt);
            }
        });

        botonAgregarAlumno.setText("Agregar alumno");
        botonAgregarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar curso");

        subTituloCurso.setFont(new java.awt.Font("Times New Roman", 0, 15)); // NOI18N
        subTituloCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTituloCurso.setText("nombre curso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(subTituloCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(botonModificarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminarProfesor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminarAlumno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAgregarAlumno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(botonAsignarProfesor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(subTituloCurso)
                .addGap(30, 30, 30)
                .addComponent(botonAsignarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonEliminarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonEliminarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonAgregarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonModificarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAsignarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarProfesorActionPerformed
        //Asignar profesor al curso
        curso.modificarCurso(1);
    }//GEN-LAST:event_botonAsignarProfesorActionPerformed

    private void botonEliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProfesorActionPerformed
        // Eliminar profe asignado del curso
        curso.modificarCurso(2);
    }//GEN-LAST:event_botonEliminarProfesorActionPerformed

    private void botonEliminarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarAlumnoActionPerformed
        // Elimina alumno del curso
        curso.modificarCurso(3);
    }//GEN-LAST:event_botonEliminarAlumnoActionPerformed

    private void botonAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAlumnoActionPerformed
        //Agrega un nuevo alumno al curso
        curso.modificarCurso(4);
    }//GEN-LAST:event_botonAgregarAlumnoActionPerformed

    private void botonModificarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarAlumnoActionPerformed
        // Modificar datos de un alumno
        String rutAlum = JOptionPane.showInputDialog("Ingrese el rut del alumno a modificar");
        if (rutAlum == null) return;
        Alumno alum = curso.getAlumno(rutAlum);
        if (alum != null){
            //Ventana para mostras las modificaciones disponibles
            VentanaModificarAlumno ventana = new VentanaModificarAlumno(alum);   
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null); 
        }
        else{
            JOptionPane.showMessageDialog(null, "RUT no valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonModificarAlumnoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarAlumno;
    private javax.swing.JButton botonAsignarProfesor;
    private javax.swing.JButton botonEliminarAlumno;
    private javax.swing.JButton botonEliminarProfesor;
    private javax.swing.JButton botonModificarAlumno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel subTituloCurso;
    // End of variables declaration//GEN-END:variables
}
