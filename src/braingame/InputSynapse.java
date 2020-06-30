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
 * @author Yeoh Hong Jing
 */
public class InputSynapse extends javax.swing.JFrame {

    /**
     * Creates new form InputSynapse
     */
    private static int numConnection;
    private static int id;
    public InputSynapse(int id,int numConnection) {
        this.setTitle("Brain Game");
        this.setIconImage(new ImageIcon(getClass().getResource("/braingame/neuron.png")).getImage());
        initComponents();
        jLabel1.setVisible(false);
        String neurons="Neurons: ";
        for (int i = 0; i < NumberOfNeuron.count; i++) {
            neurons+="   "+BrainSimulation.neuron[i].toString();
        }
        jLabel7.setText(neurons);
        jLabel7.setVisible(true);
        setBounds(0, 0 , 1018, 608);
        setLocationRelativeTo(null);
        this.numConnection=numConnection;
        this.id=id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(430, 480, 100, 40);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Distance:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 280, 210, 60);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Life Time:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(630, 290, 210, 60);

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(610, 160, 200, 50);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Connected Neuron ID:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 90, 400, 60);

        jTextField5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(620, 360, 200, 50);

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(140, 150, 200, 50);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Time:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(640, 90, 210, 60);

        jTextField4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(120, 350, 200, 50);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Neuron:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 10, 960, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 420, 980, 70);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/braingame/mainpage2.gif"))); // NOI18N
        jLabel2.setText("hoho");
        jLabel2.setDoubleBuffered(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1000, 562);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Integer.parseInt(jTextField3.getText());
            Integer.parseInt(jTextField4.getText());
            Integer.parseInt(jTextField2.getText());
            Integer.parseInt(jTextField5.getText());
        }catch(NumberFormatException e){
            jLabel1.setText("Id, d, t and Life Time must be Integer. ");
            jLabel1.setVisible(true);
            return;
        }
        //set variables for synapse
        int id = Integer.parseInt(jTextField3.getText());
        int d = Integer.parseInt(jTextField4.getText());
        int t = Integer.parseInt(jTextField2.getText());
        int lifeTime=Integer.parseInt(jTextField5.getText());

        Neuron neuron=null;
        boolean exist=false;
        boolean isInRange=false;
        //To prevent the number of neuron created is more than the number of neuron input by the user
        if(NumberOfNeuron.count>NumberOfNeuron.numNeurone-1){
            for (int i = 0; i < NumberOfNeuron.count; i++) {
                if(BrainSimulation.neuron[i].id==id){
                    isInRange=true;
                }     
            }
        }
        else
            isInRange=true;
        boolean synapseExist=false;
        //Only one synapse can exist between 2 neuron. This is to check if the synapse of same origin and destination exist
        for (int i = 0; i < BrainSimulation.neuron[NumberOfNeuron.index].synapse.size(); i++) {
            if(BrainSimulation.neuron[NumberOfNeuron.index].synapse.get(i).destination.id==id){
                synapseExist=true;
            }     
        }
        //If it is bidirectional create a synapse of opposite direction  
        if(UniOrBi.unibi==2){
        for (int i = 0; i < NumberOfNeuron.count; i++) {
                if(BrainSimulation.neuron[i].id==id){
                    for (int j = 0; j < BrainSimulation.neuron[i].synapse.size(); j++) {
                        if(BrainSimulation.neuron[i].synapse.get(j).destination.id==BrainSimulation.neuron[NumberOfNeuron.index].id)
                            synapseExist=true;                       
                }
            }    
        }
        }
        //If input is invalid let user reinput
        if(synapseExist || id==BrainSimulation.neuron[NumberOfNeuron.index].id || id<0 || d<0 || t<0 || lifeTime<1 || !isInRange){
            String errorMsg="";
            if(synapseExist)
                jLabel1.setText(errorMsg+="This neuron is already connected. ");
            if(id==BrainSimulation.neuron[NumberOfNeuron.index].id)
                jLabel1.setText(errorMsg+="A neuron cannot connect to itself. ");
            if(id<0){
                jLabel1.setText(errorMsg+="Id cannot be negative number. ");
            }
            if(d<0)
                jLabel1.setText(errorMsg+="Distance cannot be negative number. ");
            if(t<0)
                jLabel1.setText(errorMsg+="Time cannot be negative number. ");
            if(lifeTime<1){
                jLabel1.setText(errorMsg+="Life Time must be at least 1. ");
            }
            if(!isInRange)
                jLabel1.setText(errorMsg+="Invalid Neuron. ");
            jLabel1.setForeground(Color.red);
            jLabel1.setVisible(true);
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField2.setText("");
            jTextField5.setText("");
            return;
        }
        //loop through the neuron array to check if the neuron is already exist
        for (int i = 0; i < NumberOfNeuron.count; i++) {
            if(BrainSimulation.neuron[i].id==id){
                neuron=BrainSimulation.neuron[i];
                exist=true;
            }            
        }
        //if neuron is not exist in the array, create a Neuron Object
        if(!exist ){
            neuron=new Neuron(id);
            BrainSimulation.neuron[NumberOfNeuron.count]=neuron;
            NumberOfNeuron.count++;
        }
        //create a synapse Object
        Synapse sy=new Synapse(BrainSimulation.neuron[NumberOfNeuron.index],neuron,d,t,lifeTime);
        //add the synapse into the origin neuron
        BrainSimulation.neuron[NumberOfNeuron.index].synapse.add(sy);
        //if it is bidirectional add synapse of opposite direction into the destination neuron
        if(UniOrBi.unibi==2){
            BrainSimulation.bidirectional();
        }
        //keep looping inputSynapse if the number of synapse is not reached
        if(NumberOfNeuron.index<=NumberOfNeuron.numNeurone-1 && NeuronInitialize.index<numConnection-1){

                NeuronInitialize.index++; 
                InputSynapse iS = new InputSynapse(id,numConnection);
                dispose();
                iS.setVisible(true);


        }
        //if number of synapse is reached, create another neuron Object
        else if(NumberOfNeuron.index<NumberOfNeuron.numNeurone-1 && NeuronInitialize.index==numConnection-1)            {
            NeuronInitialize.index=0;
            NumberOfNeuron.index++;
            dispose();       
            NeuronInitialize c = new NeuronInitialize();
            c.setVisible(true);
            }
        //if number of synapse is reached and number of neuron is also reached, start the game
        else if(NumberOfNeuron.index==NumberOfNeuron.numNeurone-1 && NeuronInitialize.index==numConnection-1){
            dispose();
            GameContent g=new GameContent();
            g.setVisible(rootPaneCheckingEnabled);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

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
            java.util.logging.Logger.getLogger(InputSynapse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputSynapse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputSynapse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputSynapse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputSynapse(id,numConnection).setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
