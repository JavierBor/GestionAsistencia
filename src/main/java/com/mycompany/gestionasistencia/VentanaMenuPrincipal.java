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
        setTitle("Gestión Colegio Jinetes del Bien");
        this.cursos = cursos;
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        botonPasarAsistencia = new javax.swing.JButton();
        botonModificarAsistencia = new javax.swing.JButton();
        botonMostrarRegistrosBoton = new javax.swing.JButton();
        botonMostrarArchivo = new javax.swing.JButton();
        botonModificarCurso = new javax.swing.JButton();
        botonSalirDelPrograma = new javax.swing.JButton();
        tituloCurso = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonPasarAsistencia.setText("Pasar Asistencia");
        botonPasarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPasarAsistenciaActionPerformed(evt);
            }
        });

        botonModificarAsistencia.setText("Modificar Asistencia");
        botonModificarAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarAsistenciaActionPerformed(evt);
            }
        });

        botonMostrarRegistrosBoton.setText("Mostrar Registros");
        botonMostrarRegistrosBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarRegistrosBotonActionPerformed(evt);
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
                            .addComponent(botonPasarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonModificarAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(botonMostrarRegistrosBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(30, 30, 30)
                .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonPasarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonModificarAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonMostrarRegistrosBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonModificarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonMostrarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(botonSalirDelPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón para pasar asistencia por curso
    private void botonPasarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPasarAsistenciaActionPerformed
        // Solicitar el nombre del alumno
        String nombreCurso = JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):");
        
        // Verificar si el nombre es válido
        if (nombreCurso != null && cursos.containsKey(nombreCurso.toLowerCase())) {
            nombreCurso = nombreCurso.toLowerCase();
            cursoActual = (Curso) cursos.get(nombreCurso);
            try {
                cursoActual.modAsistencia();
            } 
            catch (IOException ex) {
                Logger.getLogger(VentanaMenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (nombreCurso != null && !cursos.containsKey(nombreCurso)){
            JOptionPane.showMessageDialog(this, "Curso no válido.", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonPasarAsistenciaActionPerformed

    //Botón para modificar la asistencia de un alumno
    private void botonModificarAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarAsistenciaActionPerformed
        String nombreCurso = JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):");

        //En caso de cancelar
        if (nombreCurso == null) {
            return;
        }

        //Curso invalido
        if (!cursos.containsKey(nombreCurso) || nombreCurso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Curso no válido.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        nombreCurso = nombreCurso.toLowerCase(); //Pasamos a minúscula
        Curso cursoActual = cursos.get(nombreCurso); // Obtener el curso del mapa
        String rut = JOptionPane.showInputDialog("Ingrese el RUT del Alumno");
        
        //En caso de cancelar
        if (rut == null) {
            return;
        }

        Alumno alumno = cursoActual.getAlumno(rut); // Verifica si el alumno existe en el curso
        
        if (alumno != null) {
            //Preguntaremos la fecha
            String fecha = JOptionPane.showInputDialog("Ingrese la fecha a modificar (dd/mm/aaaa):");

            //En caso de cancelar
            if (fecha == null){
                return;
            }
                       
            // Verifica si la fecha no está registrada
            if ((alumno.getAsistencia().yaRegistrada(fecha))) {
                // Solicita el nuevo estado de asistencia
                String estado = JOptionPane.showInputDialog("Ingrese el nuevo estado (Presente/Ausente/Atrasado/Retirado):");

                //En caso de cancelar
                if (estado == null){
                    return;
                }

                //Condicional para cumplir con el estándar
                if ((estado.equalsIgnoreCase("Presente") ||
                     estado.equalsIgnoreCase("Ausente")  ||
                     estado.equalsIgnoreCase("Atrasado") ||
                     estado.equalsIgnoreCase("Retirado"))){

                    // Registra el nuevo estado
                    alumno.registrar(fecha, estado);
                    JOptionPane.showMessageDialog(null, "Asistencia modificada exitosamente.");
                } 
                else{ //Estado invalido
                    JOptionPane.showMessageDialog(null, "Estado no válido. Solo se permite: Presente, Ausente, Atrasado o Retirado.", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{ //Fecha invalida
                JOptionPane.showMessageDialog(null, "Fecha no registrada o invalida.", "Error!", JOptionPane.ERROR_MESSAGE);                    
            }
        } 
        else{ //RUT invalido
            JOptionPane.showMessageDialog(null, "RUT no encontrado o invalido.", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_botonModificarAsistenciaActionPerformed

    //Botón para mostrar los registros, ya sea por curso, por alumno (rut) o alumnos en riesgo (Asistencia < 70%)
    private void botonMostrarRegistrosBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarRegistrosBotonActionPerformed
        //Primero preguntamos por el curso
        nombreCurso = (JOptionPane.showInputDialog("Ingrese el curso a mostrar (Ej: Primero Medio):"));
        if (nombreCurso != null && cursos.containsKey(nombreCurso.toLowerCase())){
            nombreCurso = nombreCurso.toLowerCase();
            cursoActual = (Curso) cursos.get(nombreCurso);
        }
        else if(nombreCurso == null){ //Botón de cancelar
            return;
        }
        else{ //En caso de no ser valido, mostraremos este mensaje
            JOptionPane.showMessageDialog(this, "Curso no válido.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Creamos la ventana principal de selección
        JFrame frame = new JFrame("Registros de "+nombreCurso);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        
        //Creamos el panel con las opciones
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("¿Qué opción desea?", SwingConstants.CENTER), BorderLayout.NORTH);

        //Creamos los botones para el panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        String[] opciones = {"Alumnos del Curso", "Buscar por RUT", "Alumnos en Riesgo"};

        //Switch para manipular cada opción por separado
        for (String opcion : opciones) {
            JButton button = new JButton(opcion);
            button.addActionListener(e -> {
                switch (opcion) {
                    case "Alumnos del Curso":
                        //Mostraremos la ventana de registros del curso
                        VentanaRegistrosCurso listado = new VentanaRegistrosCurso(cursoActual);
                        listado.setVisible(true);
                        break;
                        
                    case "Buscar por RUT":                    
                        //Verificar que el curso existe                       
                        String rutAlumno = (JOptionPane.showInputDialog("Ingrese el RUT del Alumno (Ej: 11222333-4):"));
                        if (rutAlumno == null) return;
                        cursoActual.mostrarRegistroAlumno(rutAlumno);                                          
                        break;
                        
                    case "Alumnos en Riesgo":
                        //Mostraremos la ventana de alumnos en riesgo
                        VentanaAlumnosEnRiesgo listadoRiesgo = new VentanaAlumnosEnRiesgo(cursoActual);
                        listadoRiesgo.setVisible(true);
                        break;
                }
            });
            buttonPanel.add(button);
        }
        //Agregaremos los botones al panel y al frame
        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);   
    }//GEN-LAST:event_botonMostrarRegistrosBotonActionPerformed

    private void botonMostrarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarArchivoActionPerformed
        String nombreCurso = JOptionPane.showInputDialog("Ingrese el curso (Ej: Primero Medio):").toLowerCase();

        // Verificar si el nombre es válido
        if (nombreCurso != null && cursos.containsKey(nombreCurso)) {
            cursoActual = (Curso) cursos.get(nombreCurso);

            try {
                // Abrimos el archivo (sin eliminarlo)           
                cursoActual.escribirArchivoAlumnos();
                cursoActual.abrirArchivo();
                cursoActual.eliminarArchivo("src\\main\\java\\com\\mycompany\\gestionasistencia\\listaAlumnos.txt");

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al manejar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Curso no valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
    }//GEN-LAST:event_botonModificarCursoActionPerformed

    private void botonSalirDelProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirDelProgramaActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirDelProgramaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificarAsistencia;
    private javax.swing.JButton botonModificarCurso;
    private javax.swing.JButton botonMostrarArchivo;
    private javax.swing.JButton botonMostrarRegistrosBoton;
    private javax.swing.JButton botonPasarAsistencia;
    private javax.swing.JButton botonSalirDelPrograma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel tituloCurso;
    // End of variables declaration//GEN-END:variables
}
