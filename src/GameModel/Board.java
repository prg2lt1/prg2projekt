/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameModel;

import GameControl.FileIO;
import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author tobias
 */
public class Board implements Serializable{

    private int size;
    private ArrayList<Dot> dotList;
    private ArrayList<Line> lineList;
    private ArrayList<Box> boxList;
    private int nrOfCompletedBoxes;

    /**
     *
     * @param size Seitenlänge in Anzahl Dots eines n x n Spielfelds.
     */
    public Board(int size) {

        this.size = size;

        dotList = createDots();
        lineList = createLines();
        boxList = createBoxes();
        assignBoxesToLines();

    }

    public int getSize() {
        return this.size;
    }

    /**
     * Erstellt Dot-List für das Spielfeld mit xy Koordinaten für jeden Dot,
     * Startpunkt bei 00, Ende bei size-1xsize-1
     *
     * @return
     */
    private ArrayList<Dot> createDots() {

        dotList = new ArrayList<>();

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                dotList.add(new Dot(x, y));
            }
        }

        return dotList;
    }

    private ArrayList<Line> createLines() {

        lineList = new ArrayList<>();
        Dot first;
        Dot second;

        //Horizontal Lines
        for (int index = 0; index < dotList.size() - 1; index++) {

            if (index % size == size - 1) {
                index++;
            }

            first = dotList.get(index);
            second = dotList.get(index + 1);
            lineList.add(new Line(first, second));
        }
        //Vertical Lines
        for (int index = 0; index < dotList.size() - size; index++) {
            first = dotList.get(index);
            second = dotList.get(index + size);
            lineList.add(new Line(first, second));
        }

        return lineList;
    }

    private ArrayList<Box> createBoxes() {

        boxList = new ArrayList<>();
        int totalBoxes = (size - 1) * (size - 1);
        Line top;
        Line bottom;
        Line left;
        Line right;

        int horizontalIndex = 0;
        int verticalIndex = size * (size - 1);

        for (int boxno = 0; boxno < totalBoxes; boxno++) {

            top = lineList.get(horizontalIndex);
            bottom = lineList.get(horizontalIndex + size - 1);

            if (verticalIndex % size == size - 1) {
                verticalIndex++;
            }
            left = lineList.get(verticalIndex);
            right = lineList.get(verticalIndex + 1);
            boxList.add(new Box(boxno, top, bottom, left, right));

            horizontalIndex++;
            verticalIndex++;

        }

        return boxList;
    }

    private void assignBoxesToLines() {
        Box box1;
        Box box2;
        for (Box b : getBoxes()) {
            
            Line bottom = b.getBottomLine();
            Line top = b.getTopLine();
            Line left = b.getLeftLine();
            Line right = b.getRightLine();

            if(bottom.getFirstTouchingBox() == null) {
                bottom.setFirstTouchingBox(b);
            }
            else {
                bottom.setSecondTouchingBox(b);
            }
            
            if(top.getFirstTouchingBox() == null) {
                top.setFirstTouchingBox(b);
            }
            else {
                top.setSecondTouchingBox(b);
            }
            
            if(left.getFirstTouchingBox() == null) {
                left.setFirstTouchingBox(b);
            }
            else {
                left.setSecondTouchingBox(b);
            }
            
            if(right.getFirstTouchingBox() == null) {
                right.setFirstTouchingBox(b);
            }
            else {
                right.setSecondTouchingBox(b);
            }
            
        }
    }
    
    public boolean allBoxesComplete() {
        
        nrOfCompletedBoxes = 0;
        boolean complete = false;
        
        for(Box b : getBoxes()) {
            if(b.isBoxComplete()) {
                nrOfCompletedBoxes++;
                }
        }
        
        if(nrOfCompletedBoxes == getBoxes().size()) {
            complete = true;
        }
        
        return complete;
    }

    public ArrayList<Box> getBoxes() {
        return boxList;
    }

    public ArrayList<Line> getLines() {
        return lineList;
    }

    public ArrayList<Dot> getDots() {
        return dotList;
    }

}
