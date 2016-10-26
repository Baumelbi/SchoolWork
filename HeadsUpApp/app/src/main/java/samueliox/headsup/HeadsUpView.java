package samueliox.headsup;

import java.util.*;

/**
 * Created by samuel on 4/14/2016.
 */
public class HeadsUpView implements Observer{
    private String currentWord, scoreboard;
    private HeadsUpModel model;

    public HeadsUpView(HeadsUpModel m){
        model = m;
        currentWord = model.getCurrentWord();
        model.addObserver(this);
    }

    /**
     * Method that sets the current word to be displayed
     */
    public void setCurrentWordDisplay(){
        currentWord = model.getCurrentWord();
    }

    /**
     * Returns the current word as a display
     * @return the string being disaypled in String form
     */
    public String getCurrentWordDisplay(){
        return currentWord;
    }

    /**
     * Method that sets the scoreboard
     */
    public void setScoreboardDisplay(){
        StringBuffer sb = new StringBuffer();
        //gets the queue of correct words and removes them all
        Queue<String> allCorrectWords = model.getAllCorrectWords();
        while(!allCorrectWords.isEmpty()){
            sb.append(allCorrectWords.remove() + "\n");
        }
        //would have to indicate which words were correct or skipped
        Queue<String> allWrongWords = model.getAllWrongWords();
        while(!allWrongWords.isEmpty()){
            sb.append(allWrongWords.remove() + "\n");
        }
        sb.append("Score: " + model.getScore());
        scoreboard = sb.toString();
    }

    @Override
    /**
     * Method that updates the current word
     */
    public void update(Observable observable, Object data) {
        setCurrentWordDisplay();
    }
}
