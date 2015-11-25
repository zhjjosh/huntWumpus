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

    static String[] nodes = {

        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "10",
        "11",
        "12",
        "13",
        "14",
        "15",
        "16",
        "17",
        "18",
        "19",
        "20",       
    };

	// Edge format is <from, to, distance>
	// Because we are using an array, the types of all elements must be the same.
	// Hence distance is a string, not an int.
	static String [][] edges = {
            { "1",	"11",   "1"	},
            { "1",	"10",   "1"	},            
            { "1",	"2",    "1"     },                     
            { "2",	"12",   "1"	}, 
            { "2",	"1",    "1"	}, 
            { "2",	"3",    "1"	}, 
            { "3",	"13",   "1"	},
            { "3",	"2",    "1"	},                
            { "3",	"4",    "1"	},   
            { "4",	"14",   "1"	},
            { "4",	"13",   "1"	},
            { "4",	"5",    "1"	},      
            { "5",	"15",   "1"     }, 
            { "5",	"4",    "1"	}, 
            { "5",	"6",    "1"	},                                    
            { "6",	"16",   "1"	},
            { "6",	"5",    "1"	},
            { "6",	"7",    "1"	},                                                                    
            { "7",	"17",   "1"	}, 
            { "7",	"6",    "1"	},                                  
            { "7",	"8",    "1"	},
            { "8",	"18",   "1"	},
            { "8",	"7",    "1"	},
            { "8",	"9",    "1"	},                                   
            { "9",	"19",   "1"	},
            { "9",	"8",    "1"	},
            { "9",	"10",   "1"	},                                  
            { "10",	"20",   "1"	},
            { "10",	"9",    "1"	},
            { "10",	"1",    "1"	},
            { "11",	"1",    "1"	},
            { "11",	"19",   "1"	},            
            { "11",	"13",   "1"     },                     
            { "12",	"2",    "1"	}, 
            { "12",	"20",   "1"	}, 
            { "12",	"14",   "1"	}, 
            { "13",	"3",    "1"	},
            { "13",	"11",   "1"	},                
            { "13",	"15",   "1"	},   
            { "14",	"4",    "1"	},
            { "14",	"12",   "1"	},
            { "14",	"16",   "1"	},      
            { "15",	"5",    "1"     }, 
            { "15",	"13",   "1"	}, 
            { "15",	"17",   "1"	},                                    
            { "16",	"6",    "1"	},
            { "16",	"14",   "1"	},
            { "16",	"18",   "1"	},                                                                    
            { "17",	"7",    "1"	}, 
            { "17",	"15",   "1"	},                                  
            { "17",	"19",   "1"	},
            { "18",	"8",    "1"	},
            { "18",	"16",   "1"	},
            { "18",	"20",   "1"	},                                   
            { "19",	"9",    "1"	},
            { "19",	"17",   "1"	},
            { "19",	"11",   "1"	},                                  
            { "20",	"10",   "1"	},
            { "20",	"18",    "1"	},
            { "20",	"12",   "1"	},
	};
        
    private Hashtable rooms;

    public Layout() {       
        // Create and populate the rooms table
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
        
        while (playerLabel.equals(wumpusLabel) || playerLabel.equals(flyingBirdLabel) || playerLabel.equals(monsterlabel)){
            playerLabel = generateRandom();
        }
	return (Room) rooms.get( playerLabel);
    }
    
    public Room getWumpusLocation() {
        wumpusLabel = generateRandom();
	return  (Room) rooms.get( wumpusLabel );
    }
    
    public Room getFlyingBirdLocation() {
        String flyingBirdLabel2 = generateRandom();
        while (flyingBirdLabel2.equals(wumpusLabel) || flyingBirdLabel2.equals(monsterlabel) || flyingBirdLabel2.equals(flyingBirdLabel)){
            flyingBirdLabel2 = generateRandom();
        }
        flyingBirdLabel = flyingBirdLabel2;
	return (Room) rooms.get( flyingBirdLabel);
    }
    
    public Room getMonsterLocation() {
	while (monsterlabel.equals(wumpusLabel)){
            monsterlabel = generateRandom();
        }
	return (Room) rooms.get( monsterlabel);
    }
    
    public Room getPlayerCurrentLocation(String s) {
        playerLabel = s;
	return  (Room) rooms.get(s);
    }
    
    public String generateRandom(){
         Random randomGenerator = new Random();
         int randomInt = randomGenerator.nextInt(20);
         randomInt++; 
         return randomInt+"";
    }
 
      
}
