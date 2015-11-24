
package com.mvc.model;

public class Command {
    
    public static final String [] names = {"enter","path","shoot","help","quit"};
    
    String target;

    public Command( String n ) {
	target = n;
    }
    
    public String perform( World w ){
        return null;
    }

    public static Command create(String s) {
        
        // split on whitespace
	String[] tokens = s.split( "\\s+" );
			
	if (tokens.length == 0 || tokens.length > 2)
            return new UnknownCommand( null );

	switch ( tokens.length ) {
            case 1:
		if ( tokens[0].equals( "help" ))
                    return new HelpCommand( null );
		if ( tokens[0].equals( "quit" ))
                    return new QuitCommand(  null );
		return new UnknownCommand( null  );
            case 2:
		if ( tokens[0].equals( "enter" ))
                    return new EnterCommand( tokens[1] );
		if (tokens[0].equals( "path" ))
                    return new PathCommand( tokens[1] );
		if (tokens[0].equals( "shoot" ))
                    return new ShootCommand( tokens[1] );
		return new UnknownCommand( null );
            default:
		return new UnknownCommand( null );
	}
    }

    public static String list() {
	String s = "";
	for (int i = 0; i < names.length; i++) {
            s += names[i];
            if ( i < names.length-1 )
		s += ",";
	}
	return s;
    } 
}

class UnknownCommand extends Command {
    
    UnknownCommand( String n ) {
        super( n );
     }
    
    @Override
    public String perform( World w ) {
        return "Invalid command";
    }
}

class HelpCommand extends Command {
    
    HelpCommand( String n ) {
        super( n );
     }
    
    @Override
    public String perform( World w ) {
        return "In this world, only the following commands are recognised:\n" + Command.list();
    }
}

class QuitCommand extends Command {
    
    QuitCommand( String n) {
        super(n);
     }
    
    @Override
    public String perform( World w ) {
        return null;
    }
}

class EnterCommand extends Command {
    
    EnterCommand( String n ) {
        super( n );
     }
    
    @Override
    public String perform( World w ) {
	Room r = w.getRoom( target );
	if ( r == null )
            return( "There is no room with a name of "+target );
	if (!w.enter( r ))
            return( target+" is not accessible from here" );
	return w.describe();
    }
}

class PathCommand extends Command {
    
    PathCommand( String n ) {
        super( n );
     }
    
    @Override
    public String perform( World w ) {
        Room r = w.getRoom( target );
	if ( r == null )
            return( "There is no room with a name of "+target );
        return( "The shortest path to "+target+" is:\n"+w.shortestPath( r ) );
    }
}

class ShootCommand extends Command {
    
    ShootCommand(String n) {
        super(n);
     }
    
    @Override
    public String perform( World w ) {
        Room n = w.getRoom( target );
	if ( n == null )
            return( "There is no room with a name of "+target );
	if ( w.shoot( n ) )
            return( "The wumpus is dead" );
	return( "The wumpus lives and is very stroppy" );
    }
}