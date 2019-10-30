
/**
 *  Basic design for the lawnmap, contains the 2D array along
 *  with start and end positions and number of grass
 *
 *  @author  Michael Mao
 *  @version May 25, 2018
 *  @author  Period: 5
 *  @author  Assignment: LMS
 *
 *  @author  Sources: None
 */
public class LawnMap {
    
    /**
     * Underlying character 2d array to store the lawn information
     */
    private char[][] lawn;
    /**
     * number of grass tiles
     */
    private int numGrass;       //there should be no grass on start pos
    /**
     * Starting x coordinate of Mower
     */
    private int startX;
    /**
     * Starting Y coordinate of Mower
     */
    private int startY;
    /**
     * Ending X coordinate of Mower
     */
    private int endX;
    /**
     * Ending Y coordinate of Mower
     */
    private int endY;
    
    /**
     * Default no args constructor; creates a 10 by 10 lawnMap with only grass with a nonexistent ending position
     */
    public LawnMap()
    {
        lawn = new char[10][10];
        startX = 0;
        startY = 0;
        //no ending position basically
        endX = 101;
        endY = 101;
        numGrass = 98;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                lawn[i][j] = 'G';
            }
        }
        
        lawn[0][0] = 'M';
    }
    
    /**
     * Regular constructor. Takes in a 2d character array and creates the lawnMap based on that.
     * @param l is 2D character grid
     * @param sX is start x coord
     * @param sY is start y coord
     * @param eX is end x coord
     * @param eY is end y coord
     * @param nGrass is number of grass patches
     */
    public LawnMap( char[][] l, int sX, int sY, int eX, int eY, int nGrass )
    {
        lawn = l;
        startX = sX;
        startY = sY;
        endX = eX;
        endY = eY;
        numGrass = nGrass;
    }
    
    /**
     * getter method
     */
    public char[][] getLawn()
    {
        return lawn;
    }
    
    /**
     * getter method
     */
    public int getStartX()
    {
        return startX;
    }
    
    /**
     * getter method
     */
    public int getStartY()
    {
        return startY;
    }
    
    /**
     * getter method
     */
    public int getEndX()
    {
        return endX;
    }
    
    /**
     * getter method
     */
    public int getEndY()
    {
        return endY;
    }
    
    /**
     * getter method
     */
    public int getRows()
    {
        return lawn.length;
    }
    
    /**
     * getter method
     */
    public int getCols()
    {
        return lawn[0].length;
    }
    
    /**
     * getter method
     */
    public int getNumGrass()
    {
        return numGrass;
    }

}
