package ba;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tlapinskas
 */
public class Map {

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

    

    // Getters and setters
    /*
    Returns entire char array
    */
    public char[][] getField() {
        return field;
    }

    /*
    Set a new grid
    */
    public void setField(char[][] field) {
        this.field = field;
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

        // Analyse empty or null string
        if (pos == null || pos.isEmpty()) return false;
        String regexp = "^[a-j]([1-9]|10)$";

        return  pos.matches(regexp);
    }

    /**
    Returns the symbol from grid which is at the asked position
    @param column character defining position
    @param row row of the grid
    @return 
    */
    public char getSymbolAt( char column, int row )
    {
        // First symbol is column and encoded by char
        if (!isValid(column, row)) return '|';

        // Calculate column based on letter
        int column_numb = column - 'a';

        // Calcuate row based on number
        int row_number = row - 1;

        return field[row_number][column_numb];
    }
    
}
