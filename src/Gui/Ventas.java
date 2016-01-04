/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.FramesAux.DetalleVenta;
import Gui.FramesAux.RealizarAbonoVentaExistente;
import Obj.Empleado;
import Obj.Kardex;
import Obj.Venta;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dildo__Queen
 */
public class Ventas extends javax.swing.JPanel {

    private Kardex krdx;
    private MainFrame appRun;
    private Empleado empld;
    private SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

    /**
     *
     * @param kardex
     * @param empleado
     * @param app
     * @throws Exception
     */
    public Ventas(Kardex kardex, Empleado empleado, MainFrame app) throws Exception {
        this.krdx = kardex;
        this.empld = empleado;
        this.appRun = app;
        initComponents();
        init();
    }

    public void init() throws Exception {
        this.tblTodas.setModel(new AbstractTableModel() {

            String[] nmColumnas = {"Id", "Fecha", "Cliente", "Total", "Saldo"};

            @Override
            public String getColumnName(int column) {
                return nmColumnas[column];
            }

            @Override
            public int getRowCount() {
                try {
                    if (!krdx.getVentas().isEmpty()) {
                        return krdx.getVentas().size();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                return 0;
            }

            @Override
            public int getColumnCount() {
                return nmColumnas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Venta vtmp = null;
                try {
                    vtmp = (Venta) krdx.getVentas().get(rowIndex);
                } catch (Exception ex) {
                    Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (columnIndex == 0) {
                    return vtmp.getId();
                } else if (columnIndex == 1) {
                    return f.format(vtmp.getFecha());
                } else if (columnIndex == 2) {
                    return vtmp.getCliente();
                } else if (columnIndex == 3) {
                    return vtmp.getSubtotal();
                } else if (columnIndex == 4) {
                    return vtmp.getSaldoPorPagar();
                }
                return "";
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTodasLasVentas = new javax.swing.JPanel();
        btnDetalleVenta = new javax.swing.JButton();
        btnAbono = new javax.swing.JButton();
        scpTodasLasVentas = new javax.swing.JScrollPane();
        tblTodas = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(472, 600));

        pnlTodasLasVentas.setBorder(javax.swing.BorderFactory.createTitledBorder("Todas las ventas"));

        btnDetalleVenta.setText("Detalle venta");
        btnDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtDetalleVenta(evt);
            }
        });

        btnAbono.setText("Nuevo abono");
        btnAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtAddAbono(evt);
            }
        });

        tblTodas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scpTodasLasVentas.setViewportView(tblTodas);

        javax.swing.GroupLayout pnlTodasLasVentasLayout = new javax.swing.GroupLayout(pnlTodasLasVentas);
        pnlTodasLasVentas.setLayout(pnlTodasLasVentasLayout);
        pnlTodasLasVentasLayout.setHorizontalGroup(
            pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTodasLasVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTodasLasVentasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDetalleVenta)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbono)))
                .addContainerGap())
        );
        pnlTodasLasVentasLayout.setVerticalGroup(
            pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTodasLasVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTodasLasVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbono)
                    .addComponent(btnDetalleVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTodasLasVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EvtAddAbono(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtAddAbono
        try {
            Venta vtmp = (Venta) this.krdx.getVentas().get(this.tblTodas.getSelectedRow());
            if (vtmp.isActiva()) {
                new RealizarAbonoVentaExistente(appRun, vtmp, empld, krdx).setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Warning\n\n" + ex.getMessage(), this.krdx.getNombre() + " Warning", JOptionPane.WARNING_MESSAGE);
        }
        tblTodas.updateUI();
    }//GEN-LAST:event_EvtAddAbono

    private void EvtDetalleVenta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtDetalleVenta
        try {
            Venta vtmp = (Venta) this.krdx.getVentas().get(this.tblTodas.getSelectedRow());
            if (vtmp.isActiva()) {
                new DetalleVenta(appRun, vtmp, empld, krdx).setVisible(true);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Warning\n\n" + ex.getMessage(), this.krdx.getNombre() + " Warning", JOptionPane.WARNING_MESSAGE);
        }
        tblTodas.updateUI();
    }//GEN-LAST:event_EvtDetalleVenta


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbono;
    private javax.swing.JButton btnDetalleVenta;
    private javax.swing.JPanel pnlTodasLasVentas;
    private javax.swing.JScrollPane scpTodasLasVentas;
    public javax.swing.JTable tblTodas;
    // End of variables declaration//GEN-END:variables
}
