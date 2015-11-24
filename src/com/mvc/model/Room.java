
package com.mvc.model;
import java.util.ArrayList;

public class Room extends Node {
    
    
    public Room(String label ) {
        super( label, null, 0, false );
    }
		
    public String describe() {
	return "You are in room " + getLabel() + ".";
    }
    
}
