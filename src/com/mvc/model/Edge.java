
package com.mvc.model;

public class Edge {
    
    public String from;
    public String to;
    public int distance;
    
    public Edge(String n1, String n2, int d) {
	from = n1;
	to = n2;
	distance = d;
    }  
}
