
import java.util.LinkedList;

import javax.swing.JFrame;

/**
 *  The main class that runs the game.
 *  Holds a list of the premade maps
 *
 *  @author  Stanley Wang
 *  @version May 25, 2018
 *  @author  Period: 5
 *  @author  Assignment: LMS
 *
 *  @author  Sources: None
 */
public class MowerStart 
{
    /**
     * Linked List of LawnMaps as the campaign levels. Static and final to be continually accessible and unchangable.
     */
    public static final LinkedList<LawnMap> ll = new LinkedList<LawnMap>();
    /**
     * MenuWindow that is made.
     */
    private MenuWindow mw;
    /**
     * Level 1; 2D char array
     */
    private final char[][] m1 = {{'M', 'G', 'G'}, {'G', 'G', 'G'}, {'G', 'G', 'F'}};
    /**
     * Level 2; 2D char array
     */
    private final char[][] m2 = {{'B', 'F', 'G'}, {'G', 'G', 'G'}, {'G', 'M', 'B'}};
    /**
     * Level 3; 2D char array
     */
    private final char[][] m3 = {{'G', 'G', 'G', 'F', 'G', 'G', 'G'}, {'G', 'B', 'G', 'G', 'G', 'B', 'G'}, {'G', 'G', 'G', 'M', 'G', 'G', 'G'}};
    /**
     * Level 4; 2D char array
     */
    private final char[][] m4 = {{'G', 'G', 'B', 'G', 'G', 'F', 'G', 'G', 'G', 'G', 'G'},
                                 {'G', 'G', 'G', 'G', 'G', 'G', 'B', 'G', 'G', 'B', 'G'},
                                 {'G', 'B', 'G', 'G', 'B', 'G', 'G', 'G', 'G', 'G', 'G'},
                                 {'G', 'G', 'G', 'G', 'G', 'M', 'G', 'G', 'B', 'G', 'G'}};
    
    /**
     * Constructor; adds preloaded levels to the LinkedList of lawnMaps, and creates a MenuWindow.
     */
    public MowerStart()
    {
        ll.add(new LawnMap());
        ll.add(new LawnMap(m1, 0, 0, 2, 2, 7));
        ll.add(new LawnMap(m2, 2, 1, 0, 1, 5));
        ll.add(new LawnMap(m3, 2, 3, 0, 3, 17));
        ll.add(new LawnMap(m4, 3, 5, 0, 5, 36));
        
        mw = new MenuWindow();
        mw.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        mw.setBounds( 0, 0, 360, 140 );
        mw.setVisible( true );
    }
    

    /**
     * Main method to begin the game.
     * @param args string arguments
     */
    public static void main(String args[])
    {
        MowerStart thegame = new MowerStart();
    }

}
