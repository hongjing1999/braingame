/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braingame;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author yijieee
 */
public class NeuronInitialize extends javax.swing.JFrame {
    static int index=0;
    /**
     * Creates new form Connection
     */

    public NeuronInitialize() {
        this.setTitle("Brain Game");
        this.setIconImage(new ImageIcon(getClass().getResource("/braingame/neuron.png")).getImage());
        initComponents();
        jLabel5.setVisible(false);
        if(NumberOfNeuron.count>NumberOfNeuron.numNeurone-1){
            String text="halo";
            for (int i = 0; i <NumberOfNeuron.numNeurone; i++) {
                if(BrainSimulation.neuron[i].numOfLinks==-1 ){
                   text=Integer.toString(BrainSimulation.neuron[i].id); 
                   break;
                }
            }
            jTextField2.setEditable(false);
            jTextField2.setText(text);      
        }
        String neurons="Neurons: ";
        for (int i = 0; i < NumberOfNeuron.count; i++) {
            neurons+="   "+BrainSimulation.neuron[i].toString();
        }
        jLabel4.setText(neurons);
        jLabel4.setVisible(rootPaneCheckingEnabled);
        setBounds(0, 0 , 1018, 608);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Neuron:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 10, 960, 30);

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(390, 330, 200, 50);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Number of connection to this neurone:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 270, 670, 60);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Neurone ID:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 120, 210, 60);

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(390, 180, 200, 50);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 410, 100, 40);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(280, 450, 500, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/braingame/mainpage2.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 562);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Integer.parseInt(jTextField2.getText());
            Integer.parseInt(jTextField1.getText());
        }catch(NumberFormatException e){
            jLabel5.setText("Id and Number of Connection must be Integer. ");
            jLabel5.setVisible(true);
            return;
        }
        int id= Integer.parseInt(jTextField2.getText());
        int numConnection=Integer.parseInt(jTextField1.getText());
        boolean repeat=false;
        //check if the neuron is already initialized
        for (int i = 0; i < NumberOfNeuron.count; i++) {
                if(BrainSimulation.neuron[i].id==id && BrainSimulation.neuron[i].numOfLinks!=-1 ){
                    
                    repeat=true;
                    
                }
            }
       int availableNum=NumberOfNeuron.numNeurone-1;
       
        if(UniOrBi.unibi==2){
            for (int i = 0; i <NumberOfNeuron.count; i++) {
                if(BrainSimulation.neuron[i].id==id){
                 availableNum=NumberOfNeuron.numNeurone-BrainSimulation.neuron[i].synapse.size()-1;
                    if(numConnection>availableNum){
                    }
                }
            }
        }

        //check invalid input and let user reinput
        if(repeat || id<0 || numConnection<0 || numConnection >availableNum){
            String errorMsg="";
            if(repeat){
                jLabel5.setText(errorMsg+="The neuron is already initialized. ");
            }
            if(id<0){
                jLabel5.setText(errorMsg+="Id cannot be negative. ");
            }
            if(numConnection<0)
                jLabel5.setText(errorMsg+="Number of connection cannot be negative. ");
            if(numConnection>availableNum)
                jLabel5.setText(errorMsg+="invalid number of Connection. ");
            jLabel5.setForeground(Color.red);
            jLabel5.setVisible(true);
            if(NumberOfNeuron.count>=NumberOfNeuron.numNeurone-1){
            String text="halo";
            for (int i = 0; i <NumberOfNeuron.numNeurone; i++) {
                if(BrainSimulation.neuron[i].numOfLinks==-1 ){
                   text=Integer.toString(BrainSimulation.neuron[i].id); 
                   break;
                }
            }
            jTextField2.setEditable(false);
            jTextField2.setText(text);
                    
        }
            else{
            jTextField2.setText("");          
            }
            jTextField1.setText("");
            return;
        }
        

        
        boolean exist=false;
        //check if the neuron is already exist
        for (int i = 0; i < NumberOfNeuron.count; i++) {
           if(BrainSimulation.neuron[i].id==id){
                BrainSimulation.neuron[i].setNumOfLinks(numConnection);
                exist=true;
            }                
        }
        //if neuron is not exist, create a new neuron Object
        if(!exist){
            BrainSimulation.neuron[NumberOfNeuron.count]=new Neuron(id, numConnection);
            NumberOfNeuron.count++;
        }
        
        //if there are links ,let user input data for synapse
        if(numConnection>0){
        
        InputSynapse iS = new InputSynapse(id,numConnection);
        dispose();
        iS.setVisible(true);
        }
        //if no link and all the neuron are initialize, start game
        else if(NumberOfNeuron.index==NumberOfNeuron.numNeurone-1){
            dispose();
            GameContent g=new GameContent();
            g.setVisible(rootPaneCheckingEnabled);
        }
        //if no link initialize another neuron
        else{
            NumberOfNeuron.index++;
            dispose();
            NeuronInitialize c = new NeuronInitialize();
            c.setVisible(true);
        }
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
            java.util.logging.Logger.getLogger(NeuronInitialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NeuronInitialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NeuronInitialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NeuronInitialize.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NeuronInitialize().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
