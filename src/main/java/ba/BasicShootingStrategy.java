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

    // Temporary map;
    public FieldMap helper = new FieldMap();

    private int current = 0;

    private String myLastShot = "";
    private boolean huntingMode = false;

    
    @Override
    public String shoot( HitStatus lastHit )
    {
        // My first hit, so setting all values to default
        if ( lastHit == HitStatus.FIRST ) {
            huntingMode = false;
            myLastShot = "";
            current = 0;
        }

        // At first checking my predefined shot
        while ( current < shots.length)
        {
            if ( helper.getSymbolAt(shots[current]) == ActionSymbols.SEA.getSymbol() )
            {
                myLastShot = shots[current++] ;
                return myLastShot;
            }
            else
                current++;
        }

        // I have no more predefined shots, thus now firing at the empty spaces
        if ( helper.containsFree()) {
            myLastShot = helper.findFirstFree();
            return myLastShot;
        }

        if ( helper.containsMoved()) {
            myLastShot = helper.findFirstMoved();
            return myLastShot; 
        }

        return "NONE";
    }

    
}
