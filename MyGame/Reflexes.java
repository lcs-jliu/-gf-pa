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
    public int lives;

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
        lives = 3;
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
            lookToAddTarget();
        }
    }

    /**
     * Show instruction about how to play.
     */
    private void showInstruction()
    {
        showText("Welcome to Hiding!", 500, 150);
        showText("Avoid touching with the squares", 500, 250);
        showText("Try to stay alive as long as you can.", 500, 300);
        showText("Press SPACE to begin.", 500, 400);
    }

    /**
     * Hide the instruction
     */
    private void hideInstruction()
    {
        showText("", 500, 150);
        showText("", 500, 250);
        showText("", 500, 300);
        showText("", 500, 400);
    }

    /**
     * Start the game if the user wants to.
     */
    private void lookForGameStart()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            showingInstruction = false;
            hideInstruction();
            startGame();
        }
    }
    
    private void startGame()
    {
        gameOn = true;
        frames = 0;
        timeSurvived = 0;
        showTimeSurvived();
        showLives();
        addCircle();
    }
    
    private void showTimeSurvived()
    {
        showText("Time Survived:" + timeSurvived,100,50);
    }
    
    private void showLives()
    {
         showText("Lives:" + lives,100,100);
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
        
        if(lives == 0)
        {
            gameOn = false;
            showText("Game Over",500,250);
            showText("Time Survived:" + timeSurvived,500,300);
            showText("",100,50);
            showText("",100,100);
        }
    }
    
        private void lookToAddTarget()
    {
        // Add a new target roughly every half second
        if (frames % 120 == 0)
        {
            addSquare();
        }
    }
    
    private void addSquare()
    {
        // Pick a random x position within the width of this world
        int x = Greenfoot.getRandomNumber(this.getWidth());

        // Pick a random y position within the height of this world
        int y = Greenfoot.getRandomNumber(this.getHeight());

        // Select the type of target (70% of time will be moving square)
        if (Greenfoot.getRandomNumber(10) + 1 <= 7)
        {
            MovingSquare square = new MovingSquare();
            addObject(square, x, y);
        }
        else
        {
            TrackingSquare square = new TrackingSquare();
            addObject(square, x, y);
        }

    }
    
    private void addCircle()
    {
        Circle circle = new Circle();
        addObject(circle, 500,500);
    }
    
}