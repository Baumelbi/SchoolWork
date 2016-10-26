package samueliox.headsup;

import java.util.List;

/**
 * Created by samuel on 4/14/2016.
 */
public abstract class HeadsUpBase extends java.util.Observable {

    /**
     * Method that starts a new game, starts game timer
     * @param category the category to choose the library
     */
    public abstract void startGame(int category);

    /**
     * Method that goes to the next card in the list
     */
    public abstract void skipCurrentWord();

    /**
     * Method that gets the score
     */
    public abstract int getScore();

    /**
     * Method that adds +1 to the score
     */
    public abstract void addCorrectWord();

    /**
     * Method that gets a library of words under a category
     * @param category the category that was selected
     */
    public abstract String[] getLibrary(int category);

    /**
     * Method that resets the game state so another game can be played
     */
    public abstract void resetGame();

}


