package com.market.app.view;

import com.market.database.entity.Product;
import com.market.hibernate.util.DatabaseOperations;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Kemal
 */
//Kullanıcının ürün satışı yapmasını sağlayan frame.
public class UserFrame extends javax.swing.JFrame {

    ProductIdList pl = new ProductIdList();
    DatabaseOperations dOp = new DatabaseOperations();
    DefaultListModel productNameModel = new DefaultListModel();
    DefaultListModel productPriceModel = new DefaultListModel();
    float totalPrice = (float) 0.0;

    public UserFrame() {
        initComponents();
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productId_field = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        productId_label = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        exit_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_price = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        totalValue_label = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        product_list = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        newCustomer_button = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productId_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productId_fieldKeyPressed(evt);
            }
        });

        add_button.setText("Ekle");
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });

        delete_button.setText("Sil");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        productId_label.setText("Ürün Id");

        exit_button.setText("Çıkış");
        exit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_buttonActionPerformed(evt);
            }
        });

        product_price.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        product_price.setToolTipText("");
        jScrollPane1.setViewportView(product_price);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));

        totalValue_label.setBackground(new java.awt.Color(255, 255, 0));
        totalValue_label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalValue_label.setForeground(new java.awt.Color(255, 51, 51));
        totalValue_label.setText("0.0 TL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(totalValue_label)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(totalValue_label, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
        );

        product_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        product_list.setToolTipText("");
        jScrollPane2.setViewportView(product_list);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ürün");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Fiyatı");

        newCustomer_button.setText("Yeni Müşteri");
        newCustomer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCustomer_buttonActionPerformed(evt);
            }
        });

        jButton1.setText("Ürün Id Listesi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 27, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(41, 41, 41)
                                        .addComponent(delete_button, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(newCustomer_button)
                                        .addGap(18, 18, 18)
                                        .addComponent(exit_button))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(productId_label)
                                .addGap(18, 18, 18)
                                .addComponent(productId_field, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_button)
                        .addGap(124, 124, 124))))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productId_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productId_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_button)
                        .addGap(28, 28, 28)
                        .addComponent(errorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete_button)
                            .addComponent(exit_button)
                            .addComponent(newCustomer_button))
                        .addGap(29, 29, 29)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productId_fieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productId_fieldKeyPressed
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            productId_field.setEditable(true);
            errorLabel.setText("");
        } else if (evt.getKeyCode() == evt.VK_BACK_SPACE) {
            productId_field.setEditable(true);
        } else {
            productId_field.setEditable(false);
            errorLabel.setText("* Sadece sayı giriniz.");
        }
    }//GEN-LAST:event_productId_fieldKeyPressed

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        int productId = Integer.valueOf(productId_field.getText());
        boolean returnValue = dOp.updateProductCountById(productId, "azalt",0);
        Product prod = dOp.getProductById(productId);
        if (returnValue) {
            productNameModel.add(productNameModel.getSize(), prod.getProductName());
            productPriceModel.add(productPriceModel.getSize(), prod.getPrice());

            product_list.setModel(productNameModel);
            product_price.setModel(productPriceModel);

            totalPrice = totalPrice + prod.getPrice();
            totalValue_label.setText(String.valueOf(totalPrice) + " TL");

            pl.update();
        }

    }//GEN-LAST:event_add_buttonActionPerformed

    private void exit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_buttonActionPerformed
        LoginFrame lf = new LoginFrame();
        this.setVisible(false);
        pl.setVisible(false);
        lf.setVisible(true);
    }//GEN-LAST:event_exit_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        if (product_list.getSelectedValue() != null) {
            productPriceModel.removeElementAt(product_list.getSelectedIndex());
            dOp.updateProductCountById(dOp.getIdByProductName(product_list.getSelectedValue()), "arttır",0);
            totalPrice = totalPrice - dOp.getProductById(dOp.getIdByProductName(product_list.getSelectedValue())).getPrice();
            productNameModel.removeElement(product_list.getSelectedValue());
            totalValue_label.setText(String.valueOf(totalPrice) + " TL");
            pl.update();
        } else
            JOptionPane.showMessageDialog(this, "Seçili ürün yok! ");
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void newCustomer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCustomer_buttonActionPerformed
        totalPrice = 0;
        totalValue_label.setText(String.valueOf(totalPrice) + " TL");
        productPriceModel.removeAllElements();
        productNameModel.removeAllElements();
    }//GEN-LAST:event_newCustomer_buttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pl.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton exit_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newCustomer_button;
    private javax.swing.JTextField productId_field;
    private javax.swing.JLabel productId_label;
    private javax.swing.JList<String> product_list;
    private javax.swing.JList<String> product_price;
    private javax.swing.JLabel totalValue_label;
    // End of variables declaration//GEN-END:variables
}
