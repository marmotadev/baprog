/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ba;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tlapinskas
 */
public class BasicShootingStrategy implements IShootingStrategy {

	public static Map<String, Integer> m = new HashMap<>();
	
    private String [] shots = 
    { "a1", "c1", "e1", "g1", "i1", "j1",
      "a10", "c10", "e10", "g10", "i10", "j10",
      "b2", "d2", "f2", "h2", "j2",
      "b9", "d9", "f9", "h9", "j9",
      "a3", "c3", "e3", "g3", "i3",
      "a8", "c8", "e8", "g8", "i8",
      "b4", "d4", "f4", "h4", "j4",
      "b7", "d7", "f7", "h7", "j7",
      "a5", "c5", "e5", "g5", "i5",
      "a6", "b6", "d6", "f6", "h6", "i6", "j6",
    };

    private int current = 0;

    private String myLastShot = "";
    private boolean huntingMode = false;
    private String myLastHit = "";

    public String hunt(FieldMap map)
    {

      String column_array = "abcdefghij";
       // Converting my last hit into the numeric presentation
       int column = myLastHit.charAt(0) - 'a';

       int row;
        if (myLastHit.length() == 3)
            row = 9; // 10 was given so last row
        else 
            row = myLastHit.charAt(1) - '1';

        // See if I found already hit fragment
        // Looking for possible target
        if ( map.getSymbolAt(column_array.charAt(column - 1), row + 1) == ActionSymbols.SEA.getSymbol())
            return "" + column_array.charAt(column - 1) + (row + 1); 
        if ( map.getSymbolAt(column_array.charAt(column + 1), row + 1) == ActionSymbols.SEA.getSymbol())
            return "" + column_array.charAt(column + 1) + (row + 1); 
        if ( map.getSymbolAt(column_array.charAt(column ), row ) == ActionSymbols.SEA.getSymbol())
            return "" + column_array.charAt(column ) + (row ); 
        if ( map.getSymbolAt(column_array.charAt(column - 1), row + 2) == ActionSymbols.SEA.getSymbol())
            return "" + column_array.charAt(column - 1) + (row + 2); 


        // Can't figure out next part - too hard
        return null;

        /*
        // Haven't found free symbol nearby, so that means big ship and need to look from hit parts

        if ( map.getSymbolAt(column_array.charAt(column - 1), row + 1) == ActionSymbols.WOUNDED.getSymbol())
        {
            // Found wounded part in west so need to move to east
            char symbol;
            int inc = 1;
            do {
                symbol = map.getSymbolAt(column_array.charAt(column + inc), row + 1);
                if (symbol == ActionSymbols.WOUNDED.getSymbol()) inc++;
            }
            while (symbol != ActionSymbols.BORDER.getSymbol());
            
            return "" + column_array.charAt(column + inc) + (row + 1); 
        }

        
        if ( map.getSymbolAt(column_array.charAt(column + 1), row + 1) == ActionSymbols.WOUNDED.getSymbol())
            {
            // Found wounded part in west so need to move to east
            char symbol;
            int inc = 1;
            do {
                symbol = map.getSymbolAt(column_array.charAt(column - inc), row + 1);
                if (symbol == ActionSymbols.WOUNDED.getSymbol()) inc++;
            }
            while (symbol != ActionSymbols.BORDER.getSymbol());
            
            return "" + column_array.charAt(column - inc) + (row + 1); 
        }

        if ( map.getSymbolAt(column_array.charAt(column ), row ) == ActionSymbols.WOUNDED.getSymbol())
            return "" + column_array.charAt(column ) + (row ); 
        if ( map.getSymbolAt(column_array.charAt(column - 1), row + 2) == ActionSymbols.SEA.getSymbol())
            return "" + column_array.charAt(column - 1) + (row + 2); 
        

        return "none";
        */
    }
    
    public char getColumn(int Column) {
    	String column_array = "abcdefghij";
    	if (Column < 0 ||  Column >= 10)
    		return 'k';
    	
    	else return column_array.charAt(Column);
    }

    void markShot( FieldMap map) {
        // Converting myLastShot as pair number

        String column_array = "abcdefghij";
       int column = myLastShot.charAt(0) - 'a';
       
       map.changeSymbolTo(myLastShot, ActionSymbols.DEAD.getSymbol());

       int row;
        if (myLastShot.length() == 3)
            row = 9; // 10 was given so last row
        else 
            row = myLastShot.charAt(1) - '1';

        // Adjusting row to contain a human readable coord
        row++;

        if ( map.getSymbolAt(getColumn(column - 1 ), row) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column - 1 ), row, ActionSymbols.SHOT.getSymbol());

        if ( map.getSymbolAt(getColumn(column + 1 ), row) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column + 1 ), row, ActionSymbols.SHOT.getSymbol());

        if ( map.getSymbolAt(getColumn(column ), row - 1) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column ), row - 1, ActionSymbols.SHOT.getSymbol());

        if ( map.getSymbolAt(getColumn(column ), row + 1) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column ), row + 1, ActionSymbols.SHOT.getSymbol());
        
        if ( map.getSymbolAt(getColumn(column - 1 ), row - 1) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column - 1 ), row - 1, ActionSymbols.SHOT.getSymbol());

        if ( map.getSymbolAt(getColumn(column - 1 ), row + 1) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column - 1 ), row + 1, ActionSymbols.SHOT.getSymbol());

        if ( map.getSymbolAt(getColumn(column + 1 ), row - 1) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column + 1 ), row - 1, ActionSymbols.SHOT.getSymbol());

        if ( map.getSymbolAt(getColumn(column + 1 ), row + 1 ) == ActionSymbols.SEA.getSymbol() )
           map.changeSymbolTo(getColumn(column + 1 ), row + 1, ActionSymbols.SHOT.getSymbol());

    }
    
    @Override
    public String shoot( CombatField helper, HitStatus lastHit )
    {
        // My first hit, so setting all values to default
        if ( lastHit == HitStatus.FIRST ) {
            huntingMode = false;
            myLastShot = "";
            current = 0;
        }

        if ( lastHit == HitStatus.MISSED ) {
           helper.getEnemyMap().changeSymbolTo(myLastShot, ActionSymbols.SHOT.getSymbol()); 
        }

        if (lastHit ==  HitStatus.HIT)
        {
            // Entering hunting mode
            huntingMode = true;

            helper.getEnemyMap().changeSymbolTo(myLastShot, ActionSymbols.WOUNDED.getSymbol());

            // Remembering where I hit last
            myLastHit = myLastShot;
        }

        if (lastHit == HitStatus.SINKED)
        {
            huntingMode = false;
            // Need to mark possible neighbours as shot if they are empty

            // Markingthis place as hitted
            helper.getEnemyMap().changeSymbolTo(myLastShot, ActionSymbols.WOUNDED.getSymbol());

            markShot(helper.getEnemyMap());
        }

        if (false && huntingMode) {
            // Hunting for a ship
            myLastShot = hunt(helper.getEnemyMap());

            // I was unable to find next target, I give up on this strategy for now
            if (myLastShot != null ) 
            {
                huntingMode = false;
                return myLastShot;
            }
        }


        // At first checking my predefined shot
        while ( current < shots.length)
        {
            if ( helper.getEnemyMap().getSymbolAt(shots[current]) == ActionSymbols.SEA.getSymbol() )
            {
                myLastShot = shots[current++] ;
                return myLastShot;
            }
            else
                current++;
        }

        // I have no more predefined shots, thus now firing at the empty spaces
        if ( helper.getEnemyMap().containsFree()) {
            myLastShot = helper.getEnemyMap().findFirstFree();
            return myLastShot;
        }

        if ( helper.getEnemyMap().containsMoved()) {
            myLastShot = helper.getEnemyMap().findFirstMoved();
            return myLastShot; 
        }

        return "NONE";
    }

    
}
