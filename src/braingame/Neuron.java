/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package braingame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yeoh Hong Jing
 */
public class Neuron {
    public int numOfLinks=-1;
    public int id;
    public ArrayList<Synapse> synapse=new ArrayList<>();
    public Neuron(int id) {
        this.id=id;         
        }

    public Neuron(int id, int numOfLinks){
        Scanner s=new Scanner(System.in);
        this.id=id;
        this.numOfLinks=numOfLinks;
    }
    
    public boolean isEndNode(){
        if(numOfLinks==0)
            return true;
        else 
            return false;
    }

    public void setNumOfLinks(int numOfLinks) {
        this.numOfLinks = numOfLinks;
    }

    @Override
    public String toString() {
        return  Integer.toString(id);
    }
    
}
