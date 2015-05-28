package GameView;

import java.awt.Color;

/**
 * This class defines a line with starting and ending x-/y-positions, width
 * and height, tolerance for clicks on it and the (default-)color.
 * 
 * @author Frowin Imholz
 */
public class Line {

    private final int startX;
    private final int startY;
    private final int width;
    private final int height;
    private final int tolerance;
    private final Color defaultColor;
    private Color color;

    /**
     * This constructor initializes a line with the given parameters.
     * 
     * @param startX        starting x position
     * @param startY        starting y position
     * @param endX          ending x position
     * @param endY          ending y position
     * @param thickness     thickness of the line
     */
    public Line(int startX, int startY, int endX, int endY, int thickness) {
        if (startX == endX) {
            this.width = thickness;
            this.startX = startX - this.width / 2;
        } else {
            this.width = endX - startX;
            this.startX = startX;
        }
        if (startY == endY) {
            this.height = thickness;
            this.startY = startY - this.height / 2;
        } else {
            this.height = endY - startY;
            this.startY = startY;
        }

        this.tolerance = 10;
        this.defaultColor = Color.GRAY;
        this.color = defaultColor;
    }
    
    public int getStartX() {
        return this.startX;
    }
    
    public int getStartY() {
        return this.startY;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void setColor(Color color) {
        if (color != this.defaultColor){
            this.color = color;
        }
    }
    
    public Color getColor() {
        return this.color;
    }
    
    /**
     * This method compares the x-/y-parameters with the line (start, end,
     * thickness, tolerance).
     * 
     * @param x     x-position (i.e. a mouse click)
     * @param y     y-position (i.e. a mouse click)
     * @return      true, if the parameters matches this line
     */
    public boolean lineMatch(int x, int y) {
        if (this.startX - this.tolerance <= x && x <= this.startX + this.width + this.tolerance) {
            if (this.startY - this.tolerance <= y && y <= this.startY + this.height + this.tolerance) {
                return true;
            }
        }
        return false;
    }
}
