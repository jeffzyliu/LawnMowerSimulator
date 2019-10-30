import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *  The class that handles gameflow and mechanics. Maintains an array of characters to represent the field,
 *  and takes in inputs from its GameWindow to manipulate it.
 *
 *  @author  Jeff Liu, Stanley Wang
 *  @version May 25, 2018
 *  @author  Period: 5
 *  @author  Assignment: LMS
 *
 *  @author  Sources: None
 */
public class MowerGame
{
    /**
     * level number to be displayed
     */
    private int level;
    
    /**
     * reference to the current LawnMap to access its data
     */
    private LawnMap current;
    
    /**
     * character array copied from LawnMap "current" to manipulate
     */
    private char[][] map;
    
    /**
     * Amount of grass mowed
     */
    private int grassMowed = 0;
    private int score = 0;
    private int numMoves = 0;
    private int x,y; //current coordinates of mower
    private GameWindow gw;
    
    /**
     * No args constructor uses the default lawn map; calls the regular constructor
     * using level 0 and the no args lawn map.
     */
    public MowerGame()
    {
        this(0, new LawnMap());
    }
    
    /**
     * Sets the current map and level number, and copies the array into variable map.
     * Sets beginning locations, and opens a GameWindow to display the game.
     * @param l is the level number
     * @param lm is the lawn map
     */
    public MowerGame(int l, LawnMap lm)
    {
        current = lm;
        level = l;
        gw = new GameWindow(level, current, this);
        map = current.getLawn().clone();
        x = current.getStartX();
        y = current.getStartY();
    }
    
    
    /**
     * Moves the power by (v,h). Checks boundaries and moves the mower, replacing old path of the Mower with dirt or the flag.
     * Handles game ending if end conditions are met. Calls several update methods in GameWindow to update graphics.
     * @param v is number of steps in vertical direction
     * @param h is number of steps in the horizontal direction
     */
    public void move(int v, int h )
    {
        if (x + v < map.length && x + v >= 0 && y + h < map[0].length 
                && y + h >= 0 && map[x + v][y + h] != 'B')
        {
            if (x == current.getEndX() && y == current.getEndY())
            {
                map[x][y] = 'F';    //when moving off the end cell
            }
            else
            {
                map[x][y] = 'O';    //else replace it with dirt
            }
            if (map[x + v][y + h] == 'G')
            {
                score++;        //increment score and grass mowed when mowing grass
                grassMowed++;
            }
            else if (map[x + v][y + h] != 'F')
            {
                score--;        //else wasting oil, decrease score
            }
            map[x + v][y + h] = 'M';
            gw.update(x, y, map[x][y]);
            gw.update(x + v, y + h, map[x + v][y + h]);
            x += v;
            y += h;
            //when game is over
            if (x == current.getEndX() && y == current.getEndY() && grassMowed == current.getNumGrass())
            {
                gw.stopGame(((double) score) / numMoves);
            }
            numMoves++;
            gw.updateNumMove(numMoves);
            gw.updateScore(score);
        }
    }
    
    /**
     * Getter method for testing
     * @return the 2D map
     */
    public char[][] getMap()
    {
        return map;
    }
    
    /**
     * Getter method for testing
     * @return level
     */
    public int getLevel()
    {
    	return level;
    }
    
    /**
     * Getter method for testing
     * @return current
     */
    public LawnMap getCurrent()
    {
    	return current;
    }
    
    /**
     * Getter method for grassMowed
     * @return grassMowed
     */
	public int getGrassMowed() {
		return grassMowed;
	}
    /**
     * Getter method for score
     * @return score
     */
	public int getScore() {
		return score;
	}

	/**
	 * Getter method for testing
	 * @return the numMoves
	 */
	public int getNumMoves() {
		return numMoves;
	}

	/**
	 * Getter method for testing
	 * @return the game window
	 */
	public GameWindow getGw() {
		return gw;
	}
	
	/**
	 * Getter method for testing
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter method for testing
	 * @return the y
	 */
	public int getY() {
		return y;
	}

}

