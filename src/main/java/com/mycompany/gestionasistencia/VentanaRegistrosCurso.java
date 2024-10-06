package com.mycompany.gestionasistencia;
import javax.swing.*;

public class VentanaRegistrosCurso extends javax.swing.JFrame {
    private Curso curso;

    public VentanaRegistrosCurso(Curso cursoActual) {
        initComponents();
        this.curso = cursoActual;
        setTitle("Registros "+curso.getNombreCurso());
        tituloCurso.setText("Registros "+curso.getNombreCurso());
        listadoAlumnos = curso.mostrarRegistroAlumno(listadoAlumnos);
        datosProfesor = curso.mostrarDatosProfe(datosProfesor, jLabel3);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listadoAlumnos = new javax.swing.JTable();
        tituloCurso = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        datosProfesor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listadoAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "RUT", "Correo", "Cel. Apoderado", "Asistencias", "Faltas", "Atrasos", "Retiros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listadoAlumnos);
        if (listadoAlumnos.getColumnModel().getColumnCount() > 0) {
            listadoAlumnos.getColumnModel().getColumn(0).setPreferredWidth(100);
            listadoAlumnos.getColumnModel().getColumn(1).setPreferredWidth(50);
            listadoAlumnos.getColumnModel().getColumn(2).setPreferredWidth(150);
            listadoAlumnos.getColumnModel().getColumn(3).setPreferredWidth(60);
            listadoAlumnos.getColumnModel().getColumn(4).setPreferredWidth(20);
            listadoAlumnos.getColumnModel().getColumn(5).setPreferredWidth(20);
            listadoAlumnos.getColumnModel().getColumn(6).setPreferredWidth(20);
            listadoAlumnos.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        tituloCurso.setFont(new java.awt.Font("Times New Roman", 0, 30)); // NOI18N
        tituloCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCurso.setText("Registros del Curso");
        tituloCurso.setToolTipText("");
        tituloCurso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        datosProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "RUT", "Correo", "Especialidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(datosProfesor);
        if (datosProfesor.getColumnModel().getColumnCount() > 0) {
            datosProfesor.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel3.setText("Profesor a cargo");

        jLabel4.setText("Alumnos del curso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addComponent(jScrollPane3))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(tituloCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datosProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable listadoAlumnos;
    private javax.swing.JLabel tituloCurso;
    // End of variables declaration//GEN-END:variables
}
