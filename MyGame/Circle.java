;import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Circle here.
 * 
 * Jason Liu 
 * Saturday,April 6 2019
 */
public class Circle extends Actor
{

    /**
     * Act - do whatever the Circle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        followTheMouse();
        removeSquare();
    }   

    private void followTheMouse()
    {
        // Get info about the mouse
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null)
        {
            turnTowards(mouse.getX(), mouse.getY());
            move(10);
        }

    }

    public void removeSquare()
    {
        if (isTouching(Squares.class))
        {
            removeTouching(Squares.class);
            Reflexes reflexes = (Reflexes)getWorld();
            reflexes.decreaseLives();
            reflexes.showLives();

        }    

    }
}