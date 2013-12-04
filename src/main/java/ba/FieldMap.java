package ba;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tlapinskas
 */
public class FieldMap {

    // By default is empty field
    private char field[][] =
   {
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
        { ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol(), ActionSymbols.SEA.getSymbol()},
    };

    public static char[][] safeCopymap(char[][] m) {
		char[][] nm = new char[10][];
		for (int i=0; i < m.length; i++) {
			nm[i] = Arrays.copyOf(m[i], m[i].length);
		}
		return nm;
	}
    public void clearMap()
    {
        for (int i=0; i<10; i++)
        {
            for (int j=0; j<10; j++)
                field[i][j] = ActionSymbols.SEA.getSymbol();
        }
    }

    // Getters and setters
    /*
    Returns entire char array
    */
    public char[][] getField() {
        return safeCopymap(field);
    }

    public String[][] getFieldString() {
        return ShipPositions.getShips(1);
    }

    /*
    Set a new grid
    */
    public void setField(char[][] field) {
        //this.field = field;
        // Copying field
        for (int i=0; i<10; i++)
            for (int j=0; j<10; j++)
                this.field[i][j] = field[i][j];
    }

    // Utility functions
    public boolean isMapValid()
    {
        if ( field.length != 10 ) return false;
        for (int i=0; i<10; i++)
        {
            if ( field[i].length != 10)
                return false;
        }
        return true;
    }

    /**
    Checks if map has at least one field in which was not shot
    @return  true if at least one field is free
    */
    public boolean containsFree( )
    {
       for (int i=0; i<10; i++)
        {
            for (int j=0; j<10; j++)
                if ( field[i][j] == ActionSymbols.SEA.getSymbol() )
                    return true;
        }

       return false;
    }


    public boolean containsMoved( )
    {
       for (int i=0; i<10; i++)
        {
            for (int j=0; j<10; j++)
                if ( field[i][j] == ActionSymbols.MOVED.getSymbol() )
                    return true;
        }

       return false;
    }

    /**
    Returns if passed coordinate are within the grid
    @param column - column which is char a - j
    @param row - row which is integer
    @return  true if passed coordinates are within the grid
    */
    public boolean isValid (char column, int row)
    {
        // At first convert to string to use regular expressions for easy validation
        String pos = "" + column + row;

        return  isValid(pos);
    }


    /**
    Checks if String representation of given coords is a valid
    @param coords String of a coords
    @return  True if valid
    */
    public boolean isValid (String coords) {
       // Analyse empty or null string
        if (coords == null || coords.isEmpty()) return false;
        String regexp = "^[a-j]([1-9]|10)$";

        return  coords.matches(regexp);
    }

    /**
    Returns the symbol from grid which is at the asked position
    @param column character defining position
    @param row row of the grid
    @return Character from grid, '|' otherwise
    */
    public char getSymbolAt( char column, int row )
    {
        // First symbol is column and encoded by char
        if (!isValid(column, row)) return '|';

        // Calculate column based on letter
        int column_number = column - 'a';

        // Calcuate row based on number
        int row_number = row - 1;

        return field[row_number][column_number];
    }

    public char getSymbolAt(Coordinate c)
    {
    	return getSymbolAt(c.getX(), c.getY());
    }

    /**
    Gets a symbol from grid via String coords
    @param coords Position in Grid
    @return  Symbol from the grid
    */
    public char getSymbolAt( String coords ) {
        // First symbol is column and encoded by char
        if (!isValid(coords)) return '|';

        // Calculate column based on letter
        int column = coords.charAt(0) - 'a';

        // Calcuate row based on number
        int row;
        if (coords.length() == 3)
            row = 9; // 10 was given so last row
        else
            row = coords.charAt(1) - '1';

        return field[row][column];
    }

    /**
    This function in map sets a symbol to specified
    @param column WHich column
    @param row At which Row
    @param newSymbol  Which symbol to add
    */

    public void changeSymbolTo( char column, int row, char newSymbol ) {

       // First symbol is column and encoded by char
        if (!isValid(column, row)) return ;

        // Calculate column based on letter
        int column_numb = column - 'a';

        // Calcuate row based on number
        int row_number = row - 1;

        field[row_number] [column_numb] = newSymbol;

    }

    public void changeSymbolTo( String coords, char newSymbol ) {

       // First symbol is column and encoded by char
        if (!isValid(coords)) return ;

        // Calculate column based on letter
        int column = coords.charAt(0) - 'a';

        // Calcuate row based on number
        int row;
        if (coords.length() == 3)
            row = 9; // 10 was given so last row
        else
            row = coords.charAt(1) - '1';

        field[row] [column] = newSymbol;

    }

    /**
    Finds the first occurance of free symbol passed as param
    @param symbol which symbol to check
    @return
    */
    public String findFirstFree( )
    {

        String row_array = "abcdefghij";
        for (int row = 0; row < 10; row++)
        {
            for (int column = 0; column < 10; column++)
            {
                if ( (char)(field[row][column]) == ActionSymbols.SEA.getSymbol())
                {
                    // Find needed symbol, need to convert to String and return
                    char col_symb = row_array.charAt(column);
                    String coords = "" + col_symb + (row + 1);

                    return coords;

                }

            }
        }

        return "NONE";
    }


    public String findFirstMoved( )
    {

        String row_array = "abcdefghij";
        for (int row = 0; row < 10; row++)
        {
            for (int column = 0; column < 10; column++)
            {
                if ( (char)(field[row][column]) == ActionSymbols.MOVED.getSymbol())
                {
                    // Find needed symbol, need to convert to String and return
                    char col_symb = row_array.charAt(column);
                    String coords = "" + col_symb + (row + 1);

                    return coords;

                }

            }
        }

        return "NONE";
    }


    public void print()
    {
       for (int row = 0; row < 10; row++)
        {
            for (int column = 0; column < 10; column++)
            {
                   System.out.print(field[row][column]) ;
            }
                System.out.println();
        }
    }

}
