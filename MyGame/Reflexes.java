import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reflexes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Reflexes extends World
{
    private boolean showingInstruction;
    private boolean gameOn;
    private int frames;
    private int timeSurvived;

    /**
     *
     * Set up the world
     */
    public Reflexes()
    {    
        super(1000, 600, 1); 
        // Game starts showing hint about how to play
        showingInstruction = true;
        gameOn = false;
    }

    /**
     * Setting up
     */
    public void act()
    {
        if (showingInstruction)
        {
            showInstruction();
            lookForGameStart();
        }
            else if (gameOn)
        {
            trackTime();
        }
    }

    /**
     * Show instruction about how to play.
     */
    private void showInstruction()
    {
        this.showText("Welcome to Hiding!", 500, 150);
        this.showText("Avoid touching with the squares", 500, 250);
        this.showText("Try to stay alive as long as you can.", 500, 300);
        this.showText("Press SPACE to begin.", 500, 400);
    }

    /**
     * Hide the instruction
     */
    private void hideInstruction()
    {
        this.showText("", 500, 150);
        this.showText("", 500, 250);
        this.showText("", 500, 300);
        this.showText("", 500, 400);
    }

    /**
     * Start the game if the user wants to.
     */
    private void lookForGameStart()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            this.showingInstruction = false;
            this.hideInstruction();
            this.startGame();
        }
    }
    
    private void startGame()
    {
        gameOn = true;
        frames = 0;
        timeSurvived = 0;
        showTimeSurvived();
    }
    
    private void showTimeSurvived()
    {
        this.showText("Time Survived:" + timeSurvived, 100,50);
    }
    
    private void trackTime()
    {
        // Track frames (fps is about 60)
        frames += 1;

        // Every second (roughly) reduce the time left
        if (frames % 60 == 0)
        {
            timeSurvived += 1;
            showTimeSurvived();
        }
    }
}