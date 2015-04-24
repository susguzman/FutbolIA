package gui;

import java.awt.Color;
import javax.swing.JOptionPane;
import logica.Control;

/**
 *
 * @author Jesus
 */
public class Tablero extends javax.swing.JFrame implements Control.EventosControl{

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bt_play_single = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        bt_multiplayer = new javax.swing.JToggleButton();
        tp_multiplayer = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_puerto_cliente = new javax.swing.JLabel();
        lb_ip_cliente = new javax.swing.JLabel();
        bt_play_multi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lb_puerto_server = new javax.swing.JLabel();
        p_estadisticas = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lb_equipo_a = new javax.swing.JLabel();
        lb_equipo_b = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lb_marcador_a = new javax.swing.JLabel();
        lb_marcador_b = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lb_tiempo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lb_parte = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lb_tipo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tx_ip_cliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tx_puerto_cliente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        tx_puerto_server = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de Pardio v0.23");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setText("Un jugador");

        bt_play_single.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt_play_single.setText("Jugar Ahora");
        bt_play_single.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_play_singleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_play_single, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_play_single, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel2.setText("Dos Jugadores");

        bt_multiplayer.setBackground(java.awt.Color.red);
        bt_multiplayer.setText("Offline");
        bt_multiplayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_multiplayerActionPerformed(evt);
            }
        });

        jLabel5.setText("IP Actual:");

        jLabel6.setText("Puerto Actual:");

        lb_puerto_cliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_puerto_cliente.setText("9000");

        lb_ip_cliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_ip_cliente.setText("127.0.0.1");

        bt_play_multi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bt_play_multi.setText("Jugar Ahora");
        bt_play_multi.setEnabled(false);
        bt_play_multi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_play_multiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt_play_multi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addComponent(lb_ip_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_puerto_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_ip_cliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lb_puerto_cliente))
                .addGap(18, 18, 18)
                .addComponent(bt_play_multi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp_multiplayer.addTab("Cliente", jPanel7);

        jLabel3.setText("Puerto Actual:");

        lb_puerto_server.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_puerto_server.setText("8000");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_puerto_server)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_puerto_server))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        tp_multiplayer.addTab("Servidor", jPanel8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_multiplayer))
            .addComponent(tp_multiplayer)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(bt_multiplayer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tp_multiplayer))
        );

        p_estadisticas.setBackground(new java.awt.Color(204, 255, 255));
        p_estadisticas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel9.setLayout(new java.awt.GridLayout(3, 2));

        lb_equipo_a.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_equipo_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_equipo_a.setText("YO");
        lb_equipo_a.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel9.add(lb_equipo_a);

        lb_equipo_b.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_equipo_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_equipo_b.setText("IA");
        lb_equipo_b.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel9.add(lb_equipo_b);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Equipo A");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel9.add(jLabel8);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Equipo A");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel9.add(jLabel24);

        lb_marcador_a.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_marcador_a.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_marcador_a.setText("0");
        jPanel9.add(lb_marcador_a);

        lb_marcador_b.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_marcador_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_marcador_b.setText("0");
        jPanel9.add(lb_marcador_b);

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new java.awt.GridLayout(3, 2));

        jLabel14.setText("Tiempo:");
        jPanel10.add(jLabel14);

        lb_tiempo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_tiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tiempo.setText("lb_tiempo");
        jPanel10.add(lb_tiempo);

        jLabel16.setText("Parte:");
        jPanel10.add(jLabel16);

        lb_parte.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_parte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_parte.setText("jLabel14");
        jPanel10.add(lb_parte);

        jLabel18.setText("Tipo:");
        jPanel10.add(jLabel18);

        lb_tipo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lb_tipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_tipo.setText("jLabel14");
        jPanel10.add(lb_tipo);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Detener");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_estadisticasLayout = new javax.swing.GroupLayout(p_estadisticas);
        p_estadisticas.setLayout(p_estadisticasLayout);
        p_estadisticasLayout.setHorizontalGroup(
            p_estadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_estadisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_estadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        p_estadisticasLayout.setVerticalGroup(
            p_estadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_estadisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(p_estadisticas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_estadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Control", jPanel3);

        jLabel9.setText("Nueva IP Cliente");

        jLabel10.setText("Puevo Puerto Cliente");

        jButton3.setText("Cambiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Nuevo Puerto Server");

        jButton2.setText("Cambiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tx_puerto_cliente)
                    .addComponent(tx_ip_cliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tx_puerto_server, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 137, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_ip_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_puerto_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(54, 54, 54)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tx_puerto_server, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(352, Short.MAX_VALUE))
        );

        jLabel10.getAccessibleContext().setAccessibleName("Nuevo Puerto Cliente");
        jLabel10.getAccessibleContext().setAccessibleDescription("");
        jLabel4.getAccessibleContext().setAccessibleName("Nuevo Puerto Servidor");

        jTabbedPane1.addTab("Editar Conexion", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentResized
        p_campo.setSize(jPanel2.getWidth() - 4, jPanel2.getHeight() - 4);
    }//GEN-LAST:event_jPanel2ComponentResized

    private void bt_multiplayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_multiplayerActionPerformed
        habilitarMultiplayer();
    }//GEN-LAST:event_bt_multiplayerActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cambiarPuertoServer();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cambiarDatosCliente();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void bt_play_multiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_play_multiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_play_multiActionPerformed

    private void bt_play_singleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_play_singleActionPerformed
        bt_play_single.setEnabled(false);
        new Thread(new Runnable() {

            @Override
            public void run() {
                control.startIA();
            }
        }).start();
        set_estadisticas(true);
    }//GEN-LAST:event_bt_play_singleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        set_estadisticas(false);
        if(control.tipo_juego == control.CONTRA_IA){            
            bt_play_single.setEnabled(true);
            set_estadisticas(false);
            control.stopIA();
        }else{
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void set_estadisticas(boolean value){
        p_estadisticas.setVisible(value);
        lb_equipo_a.setText(control.equipo_a);
        lb_equipo_b.setText(control.equipo_b);
        lb_marcador_a.setText(control.goles_a + "");
        lb_marcador_b.setText(control.goles_b + "");
        lb_parte.setText(control.parte);
        
        if(control.segundos < 10){
            lb_tiempo.setText("0" + control.minutos + ":0" + control.segundos);
        }else{
           lb_tiempo.setText("0" + control.minutos + ":" + control.segundos);
        }
        
        if(control.tipo_juego == Control.CONTRA_IA){
            lb_tipo.setText("Singleplayer");
        }else{
            lb_tipo.setText("Multiplayer");
        }
    }
    
    private void myInit() {
        //Configuracion epecial de componentes
        p_estadisticas.setVisible(false);
        
        //Control
        control = new Control(this);
        control.ip_cliente = "127.0.0.1";        
        control.puerto_cliente = 9000;
        control.puerto_servidor = 8000;

        //Dibujar campo
        p_campo = new PanelCampo(control);
        p_campo.setBounds(2, 2, jPanel2.getWidth() - 4, jPanel2.getHeight() - 4);
        p_campo.setOpaque(false);
        jPanel2.add(p_campo);

        jPanel2.updateUI();
    }

    private void habilitarMultiplayer() {
        if (bt_multiplayer.isSelected()) {
            bt_multiplayer.setText("Online");
            bt_multiplayer.setBackground(Color.GREEN);
            bt_play_multi.setEnabled(true);
            /*try {
                control.activarMultiplayer();
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } else {
            bt_multiplayer.setText("Offline");
            bt_multiplayer.setBackground(Color.red);
            bt_play_multi.setEnabled(false);
            /*try {
                control.desactivarMultiplayer();
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }

    private void cambiarPuertoServer() {
        if (!tx_puerto_server.getText().isEmpty()) {
            try {
                int nuevo = Integer.parseInt(tx_puerto_server.getText());
                lb_puerto_server.setText(String.valueOf(nuevo));
                control.puerto_servidor = nuevo;                
            } catch (NumberFormatException e) {

            }
            tx_puerto_server.setText("");
            JOptionPane.showMessageDialog(this, "Cambio realizado");
        }
    }

    private void cambiarDatosCliente() {
        if (!tx_ip_cliente.getText().isEmpty() && !tx_puerto_cliente.getText().isEmpty()) {
            try {
                int nuevo = Integer.parseInt(tx_puerto_cliente.getText());
                lb_puerto_cliente.setText(String.valueOf(nuevo));
                control.puerto_cliente = nuevo;
            } catch (NumberFormatException e) {

            }
            tx_puerto_cliente.setText("");
            lb_ip_cliente.setText(tx_ip_cliente.getText());
            tx_ip_cliente.setText("");
            control.ip_cliente = lb_ip_cliente.getText();
            JOptionPane.showMessageDialog(this, "Cambio realizado");
        }
    }

    //Mis Variables
    private PanelCampo p_campo;
    private Control control;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton bt_multiplayer;
    private javax.swing.JButton bt_play_multi;
    private javax.swing.JButton bt_play_single;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_equipo_a;
    private javax.swing.JLabel lb_equipo_b;
    private javax.swing.JLabel lb_ip_cliente;
    private javax.swing.JLabel lb_marcador_a;
    private javax.swing.JLabel lb_marcador_b;
    private javax.swing.JLabel lb_parte;
    private javax.swing.JLabel lb_puerto_cliente;
    private javax.swing.JLabel lb_puerto_server;
    private javax.swing.JLabel lb_tiempo;
    private javax.swing.JLabel lb_tipo;
    private javax.swing.JPanel p_estadisticas;
    private javax.swing.JTabbedPane tp_multiplayer;
    private javax.swing.JTextField tx_ip_cliente;
    private javax.swing.JTextField tx_puerto_cliente;
    private javax.swing.JTextField tx_puerto_server;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cambiarTiempo() {
        if(control.segundos < 10){
            lb_tiempo.setText("0" + control.minutos + ":0" + control.segundos);
        }else{
           lb_tiempo.setText("0" + control.minutos + ":" + control.segundos);
        }
        //System.out.println("Cambio de tiempo: " + control.minutos + ":" + control.segundos);
    }

    @Override
    public void cambiarMarcador() {
        lb_marcador_a.setText(control.goles_a + "");
        lb_marcador_b.setText(control.goles_b + "");
    }

    @Override
    public void actualizarUI() {
        jPanel2.updateUI();
        System.out.println("actualizado");
    }

    @Override
    public void terminarPartido() {
        control.jugando = false;
        control.espera = false;
        
        bt_play_single.setEnabled(true);
        set_estadisticas(false);
        JOptionPane.showMessageDialog(this, "Juego terminado");
    }

    @Override
    public void setEstadisticas() {
        set_estadisticas(true);
    }
}
