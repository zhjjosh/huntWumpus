/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.controller;

import com.mvc.model.Database;
import com.mvc.model.Layout;
import java.util.Hashtable;

/**
 *
 * @author Zhjjosh
 */
public class NewClass {
    
    public static void main(String args[]){
        //Layout ly = new Layout();
       // Hashtable a = ly.getRooms();
        Database db = new Database();
        String[] s = db.getNodes();
        String[][] ss = db.getEdges();
    }
}
