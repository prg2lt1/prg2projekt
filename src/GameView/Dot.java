package GameView;

import java.awt.Color;

/**
 * This class defines a Dot with starting and ending x-/y-positions, and radius.
 * 
 * @author Frowin Imholz
 */
public final class Dot {
    private final int x, y, radius;
    private final Color color;

    /**
     * This constructor creates a dot with x-/y-positions as input parameters.
     * The stored position is the middle of the point.
     * 
     * @param x     x position of the dot
     * @param y     y position of the dot
     */
    public Dot(int x, int y) {
        this.radius = 10;
        this.x = x - radius;
        this.y = y - radius;
        this.color = Color.GRAY;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getRadius(){
        return this.radius;
    }
    
    public Color getColor(){
        return this.color;
    }
}
