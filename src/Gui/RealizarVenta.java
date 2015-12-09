/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Obj.Cliente;
import Obj.Item;
import Obj.Kardex;
import Obj.Producto;
import Obj.Vendedor;
import Obj.Venta;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dildo__Queen
 */
public class RealizarVenta extends javax.swing.JPanel {

    private Kardex krdx = null;
    private Vendedor venddr = null;
    private Cliente clnt = null;
    private Venta ventTemp = null;
    public App appRun = null;
    private String cdnFind = "";

    /**
     *
     * @param kardex
     * @param vendedor
     * @param app
     */
    public RealizarVenta(Kardex kardex, Vendedor vendedor, App app) {
        this.krdx = kardex;
        this.venddr = vendedor;
        this.appRun = app;
        this.ventTemp = new Venta(this.krdx.getIdVenta() + "");
        initComponents();
        init();
    }

    public void init() {
        txtfIdVenta.setText(this.krdx.getIdVenta() + "");
        txtfVendedorId.setText(this.venddr.getIdentificacion());
        txtfVendedorNombre.setText(this.venddr.getNombre());
        cmbProducto.removeAllItems();
        for (Producto ptmp : this.krdx.getProductos()) {
            cmbProducto.addItem(ptmp);
        }
        tblVentas.setModel(new AbstractTableModel() {
            String[] nmColumnas = {"Codigo", "Nombre", "Cantidad", "Subtotal"};

            @Override
            public String getColumnName(int column) {
                return nmColumnas[column];
            }

            @Override
            public int getRowCount() {
                if (ventTemp.getItems().isEmpty()) {
                    return 0;
                }
                return ventTemp.getItems().size();
            }

            @Override
            public int getColumnCount() {
                return nmColumnas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Item itmp = ventTemp.getItems().get(rowIndex);
                if (columnIndex == 0) {
                    return itmp.getProducto().getCosto();
                } else if (columnIndex == 1) {
                    return itmp.getProducto().getNombre();
                } else if (columnIndex == 2) {
                    return itmp.getCantidad();
                } else if (columnIndex == 3) {
                    return itmp.getSubtotal();
                }
                return "";
            }
        }
        );
    }

    public void newVenta() {
        ventTemp = new Venta(this.krdx.getIdVenta() + "");
        tblVentas.updateUI();
        clnt = null;
        txtfClienteId.setText("");
        txtfClienteNombre.setText("");
        txtfTotal.setText("");
        txtfBuscarProducto.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdVenta = new javax.swing.JLabel();
        lblfVendedorId = new javax.swing.JLabel();
        lblVendedorNombre = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtfIdVenta = new javax.swing.JTextField();
        pnlCliente = new javax.swing.JPanel();
        lblClienteNombre = new javax.swing.JLabel();
        txtfClienteNombre = new javax.swing.JTextField();
        lblClienteId = new javax.swing.JLabel();
        txtfClienteId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAnonimo = new javax.swing.JButton();
        txtfVendedorId = new javax.swing.JTextField();
        txtfVendedorNombre = new javax.swing.JTextField();
        txtfBuscarProducto = new javax.swing.JTextField();
        cmbProducto = new javax.swing.JComboBox();
        spnCantidad = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        scpVentas = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnRemover = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtfTotal = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(472, 600));

        lblIdVenta.setText("idVenta:");

        lblfVendedorId.setText("Identificacion:");

        lblVendedorNombre.setText("Nombre:");

        lblCantidad.setText("Cantidad:");

        lblProducto.setText("Producto:");

        lblTotal.setText("Total:");

        txtfIdVenta.setEnabled(false);

        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        lblClienteNombre.setText("Nombre:");

        txtfClienteNombre.setEnabled(false);

        lblClienteId.setText("Identificacion:");

        txtfClienteId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtBuscarCliente(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtBuscarCliente(evt);
            }
        });

        btnAnonimo.setText("Anonimo");
        btnAnonimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtAnonimo(evt);
            }
        });

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClienteLayout.createSequentialGroup()
                        .addComponent(lblClienteId)
                        .addGap(18, 18, 18)
                        .addComponent(txtfClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblClienteNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtfClienteNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClienteLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnonimo)))
                .addContainerGap())
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClienteId)
                    .addComponent(txtfClienteId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClienteNombre)
                    .addComponent(txtfClienteNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnonimo)
                    .addComponent(btnBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtfVendedorId.setEnabled(false);

        txtfVendedorNombre.setEnabled(false);

        txtfBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtFindProducto(evt);
            }
        });
        txtfBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EvtFindProductoEmpty(evt);
            }
        });

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtAddToCar(evt);
            }
        });

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scpVentas.setViewportView(tblVentas);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtRemoveToCar(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtAddVenta(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvtCancelarVenta(evt);
            }
        });

        txtfTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤########################,##0.--"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpVentas)
                    .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIdVenta)
                                .addGap(18, 18, 18)
                                .addComponent(txtfIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblfVendedorId)
                                .addGap(18, 18, 18)
                                .addComponent(txtfVendedorId)))
                        .addGap(18, 18, 18)
                        .addComponent(lblVendedorNombre)
                        .addGap(18, 18, 18)
                        .addComponent(txtfVendedorNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtfBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spnCantidad)
                            .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addGap(18, 18, 18)
                                .addComponent(txtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdVenta)
                    .addComponent(txtfIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblfVendedorId)
                    .addComponent(txtfVendedorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVendedorNombre)
                    .addComponent(txtfVendedorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(lblCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txtfBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scpVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnRemover)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void EvtAnonimo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtAnonimo
        txtfClienteId.setText("No id");
        txtfClienteNombre.setText("Anonimo");
        txtfClienteId.setEnabled(false);
        txtfClienteNombre.setEnabled(false);
        clnt = null;
    }//GEN-LAST:event_EvtAnonimo

    private void EvtBuscarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtBuscarCliente
        if (!txtfClienteId.getText().equals("".trim())) {
            try {
                clnt = (Cliente) this.krdx.findCliente(txtfClienteId.getText());
                txtfClienteNombre.setText(clnt.getNombre());

            } catch (Exception ex) {
                Logger.getLogger(RealizarVenta.class
                        .getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(
                        pnlCliente, "Warning\n\n" + ex.getMessage(), this.krdx.getNombre() + " Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_EvtBuscarCliente

    private void EvtAddToCar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtAddToCar
        try {
            int ctmp = Integer.parseInt(spnCantidad.getValue() + "");
            Item itmp = new Item(ctmp, (Producto) cmbProducto.getSelectedItem());
            ventTemp.add(itmp);
            spnCantidad.setValue(new Integer("1"));
        } catch (Exception ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtfTotal.setText(ventTemp.getSubtotal() + "");
        tblVentas.updateUI();
    }//GEN-LAST:event_EvtAddToCar

    private void EvtRemoveToCar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtRemoveToCar
        try {
            Item itmp = (Item) ventTemp.getItems().get(tblVentas.getSelectedRow());
            ventTemp.remove(itmp);
        } catch (Exception ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(pnlCliente, "La operacion no se puede realizar\n\n" + ex.getMessage(), krdx.getNombre() + "Warning", JOptionPane.WARNING_MESSAGE);
        }
        tblVentas.updateUI();
        txtfTotal.setText(ventTemp.getSubtotal() + "");
    }//GEN-LAST:event_EvtRemoveToCar

    private void EvtAddVenta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtAddVenta
        try {
            if (!ventTemp.getItems().isEmpty()) {
                ventTemp.setCliente(clnt);
                ventTemp.setVendedor(venddr);
                this.krdx.add(ventTemp);
                this.appRun.vents.tblTodasLasVentas.updateUI();
                this.krdx.siguienteIdVenta();
                txtfIdVenta.setText(this.krdx.getIdVenta() + "");
                newVenta();
            }
        } catch (Exception ex) {
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EvtAddVenta

    private void EvtCancelarVenta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtCancelarVenta
        newVenta();
    }//GEN-LAST:event_EvtCancelarVenta

    private void EvtFindProducto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvtFindProducto
        try {
            if (txtfBuscarProducto.getText().equals("".trim())) {
                cmbProducto.removeAllItems();
                for (Producto ptmp : this.krdx.getProductos()) {
                    cmbProducto.addItem(ptmp);
                }
            }
            Producto ptmp = (Producto) this.krdx.findProducto(txtfBuscarProducto.getText().toUpperCase());
            cmbProducto.removeAllItems();
            cmbProducto.addItem(ptmp);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pnlCliente, "Busqueda de producto\n" + ex.getMessage(), "Busqueda de producto", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(RealizarVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EvtFindProducto

    private void EvtFindProductoEmpty(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EvtFindProductoEmpty
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (txtfBuscarProducto.getText().equals("".trim())) {
                cmbProducto.removeAllItems();
                for (Producto ptmp : this.krdx.getProductos()) {
                    cmbProducto.addItem(ptmp);
                }
            }
        }
    }//GEN-LAST:event_EvtFindProductoEmpty

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAnonimo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    public javax.swing.JComboBox cmbProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClienteId;
    private javax.swing.JLabel lblClienteNombre;
    private javax.swing.JLabel lblIdVenta;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVendedorNombre;
    private javax.swing.JLabel lblfVendedorId;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JScrollPane scpVentas;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtfBuscarProducto;
    private javax.swing.JTextField txtfClienteId;
    private javax.swing.JTextField txtfClienteNombre;
    private javax.swing.JTextField txtfIdVenta;
    private javax.swing.JFormattedTextField txtfTotal;
    private javax.swing.JTextField txtfVendedorId;
    private javax.swing.JTextField txtfVendedorNombre;
    // End of variables declaration//GEN-END:variables
}
