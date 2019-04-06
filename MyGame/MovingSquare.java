import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingSquare here.
 * 
 * Jason Liu
 * Saturday,April 6 2019
 */
public class MovingSquare extends Squares
{
    /**
     * Act - do whatever the MovingSquare wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //CTRL-Space
        move(5);

        //Turn when at edge
        if (isAtEdge())
        {
            randomTurn();
        }

        //Turn when toughing any other objects
        if (isTouching(MovingSquare.class))
        {
            randomTurn();
        }

    }

    public void randomTurn() {
        turn(Greenfoot.getRandomNumber(359));
    }  
}
