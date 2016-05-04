package app.frames;

import app.Sistema.Sistema;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import app.frames.Cliente.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 
 * @author Vinicius Dutra Cerqueira Rocha - 315112918
 
 * @version 5.0
 * 
 */

public class UIServidor_v2 extends javax.swing.JFrame {


    String Data = new SimpleDateFormat("[dd_MM_yyyy-HHmmss]").format(new Date(System.currentTimeMillis()));
    File arquivo = new File("LogsCripto\\[Servidor]" + Data + ".logSc");
    JFileChooser seletor = new JFileChooser(arquivo);
    FileFilter filtro = new FileNameExtensionFilter("Arquivo de Log", ".logSc");
    Sistema sys = new Sistema();
    ClientInterface CI = new ClientInterface();
    
    
    public UIServidor_v2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LabelQtde = new javax.swing.JLabel();
        Relogio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        btSalvarLog = new javax.swing.JButton();
        btnLimpaTela = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        BTNChatAdmin = new javax.swing.JMenuItem();
        MenuSobre = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor Chat - v1.2.5");
        setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Status Servidor : ");

        jLabel2.setText(" OnLine");

        jLabel3.setText("Quantidade Usuários : ");

        LabelQtde.setText("0");

        Relogio.setText("00:00");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setText("IP do Servidor : ");

        ipLabel.setText("0.0.0.0");

        btSalvarLog.setText("Salvar Log");
        btSalvarLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarLogActionPerformed(evt);
            }
        });

        btnLimpaTela.setText("Limpar Tela");
        btnLimpaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaTelaActionPerformed(evt);
            }
        });

        jMenu1.setText("Opções");

        BTNChatAdmin.setText("Entrar no chat como Admin");
        BTNChatAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNChatAdminActionPerformed(evt);
            }
        });
        jMenu1.add(BTNChatAdmin);

        MenuSobre.setText("Sobre");
        MenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSobreActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSobre);

        MenuSair.setText("Sair");
        MenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(MenuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelQtde)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(ipLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(Relogio)
                                .addGap(21, 21, 21))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalvarLog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpaTela)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(Relogio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LabelQtde)
                    .addComponent(jLabel5)
                    .addComponent(ipLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvarLog)
                    .addComponent(btnLimpaTela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Thread tr = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (true) {
                    Date data = new Date();
                    String hora = new SimpleDateFormat("kk:mm:ss").format(data);
                    Relogio.setText(String.valueOf(hora));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {

                    }
                }
            }
        });
        tr.start();
        ipLabel.setText(say());
        
    }//GEN-LAST:event_formWindowOpened

    private void btSalvarLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarLogActionPerformed
        if(JOptionPane.showConfirmDialog(this,"Deseja salvar log de conexoes?","Deseja salvar log de conexoes?",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION){
            seletor.setDialogTitle("Digite o nome do arquivo a ser salvo:");   
            seletor.addChoosableFileFilter(filtro);
            seletor.setAcceptAllFileFilterUsed(false);
            seletor.setApproveButtonText("Salvar Log");
            int userSelection = seletor.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                arquivo = seletor.getSelectedFile();
                System.out.println("Save as file: " + arquivo.getAbsolutePath());
                sys.EscreveLog(jTextArea1.getText(),arquivo);
            }
        }
    }//GEN-LAST:event_btSalvarLogActionPerformed

    private void btnLimpaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaTelaActionPerformed
        jTextArea1.setText("");
    }//GEN-LAST:event_btnLimpaTelaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       File autolog = new File("LogsCripto\\autoLog_" + Data);
       
       sys.EscreveLog(jTextArea1.getText(), autolog);
    }//GEN-LAST:event_formWindowClosing

    private void MenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSobreActionPerformed
                JOptionPane.showMessageDialog(null, "    Desenvolvido por : \n Breno Lopes de Lima - 31312514\n" +
" Vinicius Dutra Cerqueira Rocha - 315112918\n" +
" Kepler Nicolai Alves Freitas  - 31222198"
                + "\nVersao 5.3" + "\nDezembro 2015 ", "Sobre a aplicacao", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_MenuSobreActionPerformed

    private void MenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MenuSairActionPerformed

    private void BTNChatAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNChatAdminActionPerformed
        CI.setVisible(true);
    }//GEN-LAST:event_BTNChatAdminActionPerformed


    public String say() {
        String ip = "0.0.0.0  ";
        try {
            java.net.InetAddress i = java.net.InetAddress.getLocalHost();
            ip = i.getHostAddress();
           // System.out.println(ip); // IP address only  
           
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return ip;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BTNChatAdmin;
    public javax.swing.JLabel LabelQtde;
    private javax.swing.JMenuItem MenuSair;
    private javax.swing.JMenuItem MenuSobre;
    private javax.swing.JLabel Relogio;
    private javax.swing.JButton btSalvarLog;
    private javax.swing.JButton btnLimpaTela;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
