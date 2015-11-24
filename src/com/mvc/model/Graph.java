package com.mvc.model;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Stack;

public class Graph {
    
    public Hashtable nodes;
    
    public Graph( Hashtable n ) {
        nodes = n;
    }
    
    public Node getNode( String label ) {
        return (Node) nodes.get( label );
    }
    
    private Node getNextNode() {
        // choose the node with the shortest distance from the start node
        // that hasn't been visited

        Node next = null;
        int d = Integer.MAX_VALUE;
        Enumeration <Node> en = nodes.elements(); 
        while ( en.hasMoreElements() ) { 
            Node n = en.nextElement();
            if ( n.visited )
                continue;
            if ( n.distance < d ) {
                d = n.distance;
                next = n;
            }
	}
	return next;
    }

    public Stack <Edge> findShortestPath(Node n1, Node n2) {
        
	// To work out the shortest path from n1 to n2, we use Dijkstra's algorithm, as 
	// described in Weiss, M. (2007) Data Structures and Algorithm Analysis in Java, 
	// Pearson Education, p. 337
        
        Enumeration <Node> en = nodes.elements(); 
        while ( en.hasMoreElements() ) { 
            Node n = en.nextElement();
            n.step = null;
            n.distance = Integer.MAX_VALUE;
            n.visited = false;
	}

	n1.distance = 0;
	for ( ;; ) {
            Node r = getNextNode(); 
            if ( r == null ) 
		break;
            r.visited = true;

            ArrayList <Edge> ale = r.edges;
            for ( Edge e : ale ) {
		Node s = (Node) nodes.get( e.to );
		if (!s.visited) {
                    if ( r.distance + e.distance < s.distance ) {
			s.distance = r.distance + e.distance;
			s.step = e;
                    }
		}
            }
	}

	//The path to n2 is stored in the step fields. 
	Stack <Edge> path = new Stack <Edge> ();
	Node t = n2;
	while ( t.step != null ) {
            path.push( t.step );
            t = (Node) nodes.get( t.step.from );
	}
	return path;
    }
	
    public int distance( Node n1, Node n2 ) {
	Stack <Edge> sp = findShortestPath( n1, n2 );
	return sp.size();
    }    
}
