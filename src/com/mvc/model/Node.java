package com.mvc.model;

import java.util.ArrayList;

public class Node {
    
    private String label;
    public Edge step;	
    public int distance;
    public boolean visited;
    public ArrayList <Edge> edges;
    
    public Node( String l, Edge s, int d, boolean v) {
        label = l;
        step = s;
        distance = d;
        visited = v;
        edges = new ArrayList <Edge> ();
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }
}
