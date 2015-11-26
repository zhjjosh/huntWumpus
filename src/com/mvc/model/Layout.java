package com.mvc.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Layout {


    
    // Room layout is represented as a node list and an edge list.
    // Nodes (rooms) are labelled 1 to 20. Each node has 3 edges. 
    // As in the original game, the layout is isomorphic to the vertices
    // of dodecahedron.
    private String wumpusLabel, playerLabel, monsterlabel,flyingBirdLabel;

    private static String[] nodes = new String[20];

	// Edge format is <from, to, distance>
	// Because we are using an array, the types of all elements must be the same.
	// Hence distance is a string, not an int.
    private static String [][] edges = new String[60][3];
        
    private Hashtable rooms;

    public Layout() {       
        // Create and populate the rooms table
        Database db = new Database();
        nodes = db.getNodes();
        edges = db.getEdges();
        wumpusLabel = "0";
        playerLabel = "0";
        monsterlabel = "0";
        flyingBirdLabel = "0";
        rooms = new Hashtable ();
        // Process the nodes array
	for ( String n : nodes ) {
            Room r = new Room( n );
            rooms.put( n, r );
	}	
	// process the edges array
	for ( int i = 0; i < edges.length; i++ ) {
            String from = edges[i][0];
            String to = edges[i][1];
            int d = Integer.parseInt( edges[i][2] );
            Room r = (Room) rooms.get( from );
            r.edges.add( new Edge( from, to, d ));
	}
    }
        
    public Hashtable getRooms() {
        return rooms;
    }
        
    public Room getPlayerLocation() {
        setPlayerLabel(generateRandom());
        while (getPlayerLabel().equals(getWumpusLabel()) || getPlayerLabel().equals(getFlyingBirdLabel()) || getPlayerLabel().equals(getMonsterlabel())){
            setPlayerLabel(generateRandom());
        }
	return (Room) getRooms().get(getPlayerLabel());
    }
    
    public Room getWumpusLocation() {
        setWumpusLabel(generateRandom());
	return  (Room) getRooms().get(getWumpusLabel());
    }
    
    public Room getFlyingBirdLocation() {
        String flyingBirdLabel2 = generateRandom();
        while (flyingBirdLabel2.equals(getWumpusLabel()) || flyingBirdLabel2.equals(getMonsterlabel()) || flyingBirdLabel2.equals(getFlyingBirdLabel())){
            flyingBirdLabel2 = generateRandom();
        }
        setFlyingBirdLabel(flyingBirdLabel2);
	return (Room) getRooms().get(getFlyingBirdLabel());
    }
    
    public Room getMonsterLocation() {
        setMonsterlabel(generateRandom());
	while (getMonsterlabel().equals(getWumpusLabel())){
            setMonsterlabel(generateRandom());
        }
	return (Room) getRooms().get(getMonsterlabel());
    }
    
    public Room getPlayerCurrentLocation(String s) {
        setPlayerLabel(s);
	return  (Room) getRooms().get(s);
    }
    
    public String generateRandom(){
         Random randomGenerator = new Random();
         int randomInt = randomGenerator.nextInt(20);
         randomInt++; 
         return randomInt+"";
    }

    /**
     * @return the wumpusLabel
     */
    public String getWumpusLabel() {
        return wumpusLabel;
    }

    /**
     * @param wumpusLabel the wumpusLabel to set
     */
    public void setWumpusLabel(String wumpusLabel) {
        this.wumpusLabel = wumpusLabel;
    }

    /**
     * @return the playerLabel
     */
    public String getPlayerLabel() {
        return playerLabel;
    }

    /**
     * @param playerLabel the playerLabel to set
     */
    public void setPlayerLabel(String playerLabel) {
        this.playerLabel = playerLabel;
    }

    /**
     * @return the monsterlabel
     */
    public String getMonsterlabel() {
        return monsterlabel;
    }

    /**
     * @param monsterlabel the monsterlabel to set
     */
    public void setMonsterlabel(String monsterlabel) {
        this.monsterlabel = monsterlabel;
    }

    /**
     * @return the flyingBirdLabel
     */
    public String getFlyingBirdLabel() {
        return flyingBirdLabel;
    }

    /**
     * @param flyingBirdLabel the flyingBirdLabel to set
     */
    public void setFlyingBirdLabel(String flyingBirdLabel) {
        this.flyingBirdLabel = flyingBirdLabel;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(Hashtable rooms) {
        this.rooms = rooms;
    }
 
      
}
