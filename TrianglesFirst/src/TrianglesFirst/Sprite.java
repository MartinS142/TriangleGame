
package TrianglesFirst;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public class Sprite
{
    private final Node node;
    private double dx, dy;
    
    public Sprite(Node node)
    {
        this.node = node;
    }
    
    public Node getNode()
    {
        return node;
    }
    
    public void setVelocity(double dx, double dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public double getVelocityX()
    {
        return dx;
    }

    public void setVelocityX(double dx)
    {
        this.dx = dx;
    }

    public double getVelocityY()
    {
        return dy;
    }

    public void setVelocityY(double dy)
    {
        this.dy = dy;
    }
    
    public void update()
    {
        //add the velocity to the location
        this.node.setTranslateX(this.node.getTranslateX()+dx);
        this.node.setTranslateY(this.node.getTranslateY()+dy);
    }

    
    
}
