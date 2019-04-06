import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Squares here.
 * 
 * Jason Liu
 * Saturday,April 6 2019
 */
public class Squares extends Actor
{
    /**
     * Act - do whatever the Squares wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        removeSquare();
    }    
    
    public void removeSquare()
    {
        if (isTouching(Circle.class))
        {
            removeTouching(Squares.class);
        }    
        
    }
}
