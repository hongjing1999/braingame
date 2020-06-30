/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braingame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.QuadCurve2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 *
 * @author Yeoh Hong Jing
 */
public class InGameUI extends javax.swing.JPanel {
    
        private FlatteningPathIterator iter;
        private ArrayList<Point> points;
        private int index=0;
        private boolean animate=false;
        
    
    ArrayList<QuadCurve2D.Double> curves=new ArrayList<>();
    JLabel[] labels;
    private Rectangle[] bounds=new Rectangle[NumberOfNeuron.numNeurone];
    private ArrayList<JLabel> sy=new ArrayList<>();
    //initialize all the graphic content (Drawing neuron and buttons and textfield)
    public InGameUI() {
        
        setLayout(null);
        setBounds(0, 0 , 1018, 608);
        Random r=new Random();
        jButton1 = new JButton();
        jButton2=new JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2=new javax.swing.JLabel();
            jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 0, 0));
            jLabel2.setText("Origin and Destinition must be positive number");
            add(jLabel2);
            jLabel2.setBounds(200, 510, 800, 80);
            jLabel2.setVisible(false);
            
            jButton1.setText("Time");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed1(evt);
            }
             });
            
        
            add(jButton1);
            jButton1.setBounds(10, 520, 80, 32);
            
            jButton2.setText("Distance");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            add(jButton2);
            jButton2.setBounds(100, 520, 80, 32);
            
           jTextField1.setText("");
            add(jTextField1);
            jTextField1.setBounds(60, 430, 73, 24);

            jTextField2.setText("");
            add(jTextField2);
            jTextField2.setBounds(60, 480, 73, 24);

             jLabel3.setForeground(new java.awt.Color(255, 255, 255));
            jLabel3.setText("Origin");
            add(jLabel3);
            jLabel3.setBounds(80, 400, 34, 16);

            jLabel4.setForeground(new java.awt.Color(255, 255, 255));
            jLabel4.setText("Destination");
            add(jLabel4);
            jLabel4.setBounds(70, 460, 80, 16);

        labels=new JLabel[NumberOfNeuron.numNeurone];
        Rectangle total=new Rectangle();
        for (int i = 0; i < NumberOfNeuron.numNeurone; i++) {
            JLabel id=new JLabel();
            labels[i]=new JLabel();
            labels[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/braingame/neuron.png"))); // NOI18N
            add(labels[i]);
            Rectangle rec=new Rectangle(100,32,900,200);
            if(i>0){
               rec=new Rectangle(r.nextInt(800-43)+200, r.nextInt(461-43)+100, 43, 43);
            }
            else{
               rec=new Rectangle(r.nextInt(800-43)+200, r.nextInt(461-43)+100, 43, 43);
            }
            while(isOverlap(rec,i) || isOverlap (rec,jTextField2.getBounds()) || isOverlap (rec,jTextField1.getBounds()) || isOverlap (rec,jButton1.getBounds()) || isOverlap (rec,jLabel3.getBounds()) || isOverlap (rec,jLabel4.getBounds()) || isOverlap(rec, jButton2.getBounds())){
                if(i>0){
               rec=new Rectangle(r.nextInt(800-43)+200, r.nextInt(461-43)+100, 43, 43);
            }
            else{
               rec=new Rectangle(r.nextInt(800-43)+200, r.nextInt(461-43)+100, 43, 43);
            }
            }

            
            labels[i].setBounds(rec);
            bounds[i]=labels[i].getBounds();
            id.setText(Integer.toString(BrainSimulation.neuron[i].id));
            id.setForeground(Color.white);
            add(id);
            id.setBounds(rec.x+21,rec.y+50,10,10);
            timer.start();
        }


    }
    // loop through the synapse array list and draw line
    public void setSyn(Graphics g){
        Neuron[] neuron=BrainSimulation.neuron;
        int destiIndex=-1;       
        for (int i = 0; i < neuron.length ; i++) {
            for (int j = 0; j < neuron[i].synapse.size(); j++) {
                for (int k = 0; k < neuron.length; k++) {
                if(neuron[i].synapse.get(j).destination.id==neuron[k].id){
                    destiIndex=k;
                }
                
            }
                setLine(i, destiIndex,g,neuron[i].synapse.get(j));               
            }
            
        }
    }
    /**Draw line for the synapse
    * @param i the index of origin neuron
    * @param j the index of destination neuron
    * @param synapse synapse to be drawn
    */
    public void setLine(int i, int j, Graphics g, Synapse synapse){
        Graphics2D g2d=(Graphics2D)g.create();
        g2d.setColor(Color.white);

        QuadCurve2D.Double curve=null;
        curve=new QuadCurve2D.Double(bounds[i].x+21.5, bounds[i].y+21.5,(bounds[i].x+21.5+bounds[j].x+21.5)/2,(bounds[i].y+21.5+bounds[j].y+21.5)/2, bounds[j].x+21.5, bounds[j].y+21.5);

        boolean intersects=false;
        int intersectIndex=-1;
        for (int k = 0; k < BrainSimulation.neuron.length; k++) {
            if(curve.intersects(bounds[k]) && k!=j && k!=i){
                intersects=true;
                intersectIndex=k;
            }
        }
        if(intersects){
        Double x=new Double(bounds[intersectIndex].x);
        Double y=new Double(bounds[intersectIndex].y);
        Double x1=new Double(bounds[intersectIndex].x);
        Double y1=new Double(bounds[intersectIndex].y);

        while(intersects && x<=1000 && y<=561 && x>=0 && y >=0 && x1<=1000 && y1<=561 && x1>=0 && y1 >=0){
            intersects=false;
            
            if(bounds[j].x>bounds[i].x ){
                if(bounds[j].y> bounds[i].y){
                    x-=10;
                    y-=10;
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5),new Double(bounds[i].y+21.5),x,y,new Double(bounds[j].x+21.5),new Double(bounds[j].y+21.5));
                }
                else if(bounds[j].y<bounds[i].y){
                    x-=10;
                    y+=10;
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5),new Double(bounds[i].y+21.5),x,y, new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                }
                else if(bounds[j].y==bounds[i].y){
                    y+=10;
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5),new Double(bounds[i].y+21.5), x,y,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                }
            }
            else if(bounds[j].x<bounds[i].x){
                if(bounds[j].y> bounds[i].y){
                    x-=10;
                    y-=10;
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5),x,y, new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                }
                else if(bounds[j].y<bounds[i].y){
                    x-=10;
                    y+=10;
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5), x,y,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                }
                else if(bounds[j].y==bounds[i].y){
                    y+=10;
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5),x,y, new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                }
            }
            else{
                x-=10;
                if(bounds[j].y> bounds[i].y)
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5), x,y,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                else if(bounds[j].y<bounds[i].y)
                    curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5),x,y,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
            }

            for (int k = 0; k < BrainSimulation.neuron.length; k++) {
                if(curve.intersects(bounds[k]) && k!=j && k!=i){
                    intersects=true;
                }
            }
            if(intersects){
                intersects=false;

                if(bounds[j].x>bounds[i].x ){

                    if(bounds[j].y> bounds[i].y){
                        x1+=10;
                        y1+=10;
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5),new Double(bounds[i].y+21.5),x1,y1,new Double(bounds[j].x+21.5),new Double(bounds[j].y+21.5));
                    }
                    else if(bounds[j].y<bounds[i].y){
                        x1+=10;
                        y1-=10;
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5),new Double(bounds[i].y+21.5),x1,y1, new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                    }
                    else if(bounds[j].y==bounds[i].y){
                        y1-=10;
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5),new Double(bounds[i].y+21.5), x1,y1,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                    }
                }
                else if(bounds[j].x<bounds[i].x){
                    if(bounds[j].y> bounds[i].y){
                        x1+=10;
                        y1+=10;
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5),x1,y1, new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                    }
                    else if(bounds[j].y<bounds[i].y){
                        x1+=10;
                        y1-=10;
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5), x1,y1,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                    }
                    else if(bounds[j].y==bounds[i].y){
                        y1-=10;
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5),x1,y1, new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                    }
                }
                else{
                     x1+=10;
                    if(bounds[j].y> bounds[i].y)
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5), x1,y1,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                    else if(bounds[j].y<bounds[i].y)
                        curve=new QuadCurve2D.Double(new Double(bounds[i].x+21.5), new Double(bounds[i].y+21.5),x1,y1,new Double(bounds[j].x+21.5), new Double(bounds[j].y+21.5));
                }
            }

                for (int k = 0; k < BrainSimulation.neuron.length; k++) {
                    if(curve.intersects(bounds[k]) && k!=j && k!=i){
                        intersects=true;
                    }
                }
            }
        }
        JLabel dt=new JLabel();
        dt.setText("d:"+synapse.d+" t:"+synapse.t+" life time:"+synapse.lifeTime);
        dt.setForeground(Color.white);
        int x=(int)Math.floor(curve.getCtrlX());
        int y=(int)Math.floor(curve.getCtrlY());
        dt.setBounds(x+5,y+5,100,10);
        //add(dt);
        g2d.setStroke(new BasicStroke(2));
        g2d.draw(curve);
        curves.add(curve);
    }
    


    /**Check if the rectangle is intersect with bounds
     * @param r rectangle to check if it intersects with bounds array
     * @param i index of bounds array
     * @return 
     */
    public boolean isOverlap(Rectangle r, int i){
        boolean overlap=false;
        for (int j = 0; j < i; j++) {
                if (r.intersects(bounds[j])){
                    overlap=true;
                }             
        }
        return overlap;
    }
    /**Check if the rectangle r intersect with rectangle re
     * 
     * @param r First rectangle 
     * @param re Second rectangle
     * @return 
     */
    public boolean isOverlap(Rectangle r, Rectangle re){
        return r.intersects(re);
    }
    /**Drawing all the graphics content
     * 
     * @param g Graphics
     */
    public void paintComponent(Graphics g) {
        //drawing the background
         ImageIcon icon=new ImageIcon(getClass().getResource("/braingame/background.png"));
         icon.paintIcon(this, g, 0, 0);
         //drawing the synapse line
         setSyn(g);
         //Writing things on screen
         String total="Time: "+totalTime+" Distance: "+totalDistance;
         g.setColor(Color.white);
         Font font=new Font("Dialog",0,18);
         g.setFont(font);
         g.drawString(total,20,32);
         g.drawString("Path Used: ",20, 60);
         int x=90;
         int x1 = 105;
         //displaying the best path used
         for (int i = 0; i < pathUsed.size(); i++) {
            String neuron=pathUsed.get(i).toString();
            g.drawString(neuron, x+=30, 60);
            if(i<pathUsed.size()-1)
                g.drawString("-",x1+=30, 60);
            
        }
         //Animate an orange dot
         if(animate){
          g.setColor(Color.orange);
          Point p=points.get(index);
          g.fillOval(p.x, p.y, 10,10);  
          jButton1.setEnabled(false);
          jButton2.setEnabled(false);
         }
         else{
          jButton1.setEnabled(true);
          jButton2.setEnabled(true);
         }
         
  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setText("Time");
        jButton1.setMargin(new java.awt.Insets(2, 0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(10, 520, 80, 32);

        jTextField1.setText("jTextField1");
        add(jTextField1);
        jTextField1.setBounds(60, 430, 73, 24);

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        add(jTextField2);
        jTextField2.setBounds(60, 480, 73, 24);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Origin");
        add(jLabel3);
        jLabel3.setBounds(80, 400, 34, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Destination");
        add(jLabel4);
        jLabel4.setBounds(70, 460, 80, 16);

        jButton2.setText("Distance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(100, 520, 80, 32);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(200, 510, 800, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/braingame/background.png"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 561);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Loop through the line and store all the point into an array
     * @param curve the line of points to be stored
     */
    private void iterate(QuadCurve2D.Double curve){
            iter=new FlatteningPathIterator(curve.getPathIterator(new AffineTransform()),0);
            points=new ArrayList<Point>();
            float[] coords=new float[6];
            while (!iter.isDone()) {
                iter.currentSegment(coords);
                int x=(int)coords[0];
                int y=(int)coords[1];
                points.add(new Point(x,y));
                iter.next();
            }
    }
    int index1=-1;
    //The timer for the animation
    Timer timer=new Timer(0, new ActionListener() {          
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(points==null){
                    if(index1<curveIndex.size()-1){
                        index1++;
                        iterate(curves.get(curveIndex.get(index1)));
                    }
                    else{
                        index1=-1;
                        curveIndex.clear();
                    }
                    }
                        
                    if(points!=null){
                     animate=true;                 
                     index++;
                     
                     repaint();
                    if (index>=points.size()) {
                        index=0;

                        animate=false;    
                        points=null;                        
   //                     timer.removeActionListener(this);                  

                     }
                    
                 }                                                                                                                     
             
                 }
                
            });           
    
    //useless shit and i don't know how to remove this
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed
    int totalTime=0;
    int totalDistance=0;
   
    ArrayList<Neuron>pathUsed=new ArrayList<>();
    ArrayList <Integer> curveIndex=new ArrayList<>();
    //Processes after time button is clicked
     private void jButton1ActionPerformed1(java.awt.event.ActionEvent evt) {    
          jLabel2.setVisible(false);
         try{
             Integer.parseInt(jTextField1.getText());
             Integer.parseInt(jTextField2.getText());
         }catch(NumberFormatException e){
             jLabel2.setVisible(true);
             return;
         }
        curveIndex=new ArrayList<>();
        int origin=Integer.parseInt(jTextField1.getText());
        int destination=Integer.parseInt(jTextField2.getText());
        BrainSimulation.findPath(origin, destination);
        ArrayList<ArrayList<Synapse>> pathCollection=new ArrayList<>();
        ArrayList<ArrayList> path=new ArrayList<>();
        pathCollection=new ArrayList<>(BrainSimulation.pathCollection);
            BrainSimulation.pathCollection.clear();
            path.add(pathCollection); 
            if(pathCollection.size()>0){
                ArrayList<Synapse> bestPath=BrainSimulation.bestPath(pathCollection);
                BrainSimulation.lifeTime(bestPath);
                int originIndex=-1;
                int destiIndex=-1;
                for (int i = 0; i < bestPath.size(); i++) {

                    for (int j = 0; j < BrainSimulation.neuron.length; j++) {
                        if(bestPath.get(i).origin.id==BrainSimulation.neuron[j].id)
                            originIndex=j;
                        if(bestPath.get(i).destination.id==BrainSimulation.neuron[j].id)
                            destiIndex=j;                         
                    }
                    for (int j = 0; j < curves.size(); j++) {
                        if(curves.get(j).x1==bounds[originIndex].x+21.5 && curves.get(j).y1==bounds[originIndex].y+21.5 && curves.get(j).x2==bounds[destiIndex].x+21.5 && curves.get(j).y2==bounds[destiIndex].y+21.5 && bestPath.get(i).lifeTime>=0){
                                curveIndex.add(j);
                                break;
                        }
                       
                    }                   
                
                }
                totalTime=BrainSimulation.totalTime(bestPath);
                totalDistance=BrainSimulation.totalDistance(bestPath);
                pathUsed=BrainSimulation.pathUsed(bestPath);
            }
            
    }                                  
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            
    }//GEN-LAST:event_jButton1ActionPerformed
    //Processes after distance button is clicked
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        curveIndex=new ArrayList<>();
        int origin=Integer.parseInt(jTextField1.getText());
        int destination=Integer.parseInt(jTextField2.getText());
        BrainSimulation.findPath(origin, destination);
        ArrayList<ArrayList<Synapse>> pathCollection=new ArrayList<>();
        ArrayList<ArrayList> path=new ArrayList<>();
        pathCollection=new ArrayList<>(BrainSimulation.pathCollection);
            BrainSimulation.pathCollection.clear();
            path.add(pathCollection); 
            if(pathCollection.size()>0){
                ArrayList<Synapse> bestPath=BrainSimulation.bestPathDistance(pathCollection);
                BrainSimulation.lifeTime(bestPath);
                int originIndex=-1;
                int destiIndex=-1;
                for (int i = 0; i < bestPath.size(); i++) {

                    for (int j = 0; j < BrainSimulation.neuron.length; j++) {
                        if(bestPath.get(i).origin.id==BrainSimulation.neuron[j].id)
                            originIndex=j;
                        if(bestPath.get(i).destination.id==BrainSimulation.neuron[j].id)
                            destiIndex=j;                         
                    }
                    for (int j = 0; j < curves.size(); j++) {
                        if(curves.get(j).x1==bounds[originIndex].x+21.5 && curves.get(j).y1==bounds[originIndex].y+21.5 && curves.get(j).x2==bounds[destiIndex].x+21.5 && curves.get(j).y2==bounds[destiIndex].y+21.5 && bestPath.get(i).lifeTime>=0){
                                curveIndex.add(j);
                                break;
                        }
                       
                    }                   
                
                }
                totalTime=BrainSimulation.totalTime(bestPath);
                totalDistance=BrainSimulation.totalDistance(bestPath);
                pathUsed=BrainSimulation.pathUsed(bestPath);
            }
            
    }//GEN-LAST:event_jButton2ActionPerformed
public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Draw Line");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBackground(Color.white);
    frame.setSize(1000, 561);
 
     InGameUI panel = new  InGameUI();
 
    frame.add(panel);
 
    frame.setVisible(true);
  }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
