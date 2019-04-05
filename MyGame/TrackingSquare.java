import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrackingSquare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrackingSquare extends Squares
{
    /**
     * Act - do whatever the TrackingSquare wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        followTheCircle();
    }    
    public void followTheCircle()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
            if (mouse != null)
        {
            turnTowards(mouse.getX(), mouse.getY());
            move(3);
        }
    }
}

