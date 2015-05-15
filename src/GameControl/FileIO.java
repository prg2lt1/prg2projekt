//Still buggy as Hell
package GameControl;

import GameModel.Box;
import GameModel.Dot;
import GameModel.Line;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Lorenz
 */
public class FileIO {

    private FileIO() {
    }

    /**
     * schreibt im file fileName eine Liste als Klartext (Objekt für Objekt).
     *
     * @param list
     * @param fileName
     */
    
    public static void writeList(List list, String fileName) {
/**
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
            String line, part;
            int x1, y1, x2, y2, r;

            Iterator listItr = list.iterator();

            while (listItr.hasNext()) {
            
                if (listItr.next().getClass().equals(Box) {
                    Box box = (Box) listItr;
                    x1 = box.getX1();
                    y1 = box.getY1();
                    x2 = box.getX2();
                    y2 = box.getY2();
                    line = String.format("B %s %s %s %s", x1, y1, x2, y2);
                } else if (listItr.getClass().equals(Line)) {
                    Line obj = (Line) listItr;
                    x1 = obj.getX1();
                    y1 = obj.getY1();
                    x2 = obj.getX2();
                    y2 = obj.getY2();
                    line = String.format("L %s %s %s %s", x1, y1, x2, y2);
                } else if (listItr.getClass().equals(Dot)) {
                   // Dot dot = listItr;
                    //x1 = obj.getX();
                    //y1 = obj.getY();
                    //r = obj.getRadius();
                    line = String.format("D %s %s", x1, y1);
                } else {
                    System.out.println("Tried writing List with undefined Object-Type to file" + list.get(i));
                    break;
                }
                writer.write(line);
                listItr.next();
            }

        } catch (IOException ex) {
            System.out.println("Couldn't write list " + ex);
        }
        **/
    }
    

    /**
     * liest aus dem file fileName eine Liste (Objekt für Objekt).
     *
     * @param fileName
     * @return List
     */
    public static List readList(String fileName) {

        List list = new ArrayList<>();
        int number = 1;
        String line;
        int x1, y1, x2, y2, r;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                switch (tokens[0]) {
                    case "B":
                        x1 = Integer.parseInt(tokens[1]);
                        y1 = Integer.parseInt(tokens[2]);
                        x2 = Integer.parseInt(tokens[3]);
                        y2 = Integer.parseInt(tokens[4]);
                        System.out.println("Box " + line);
                        //list.add(new Box(number, x1, y1, x2, y2));
                        break;

                    case "L":
                        x1 = Integer.parseInt(tokens[1]);
                        y1 = Integer.parseInt(tokens[2]);
                        x2 = Integer.parseInt(tokens[3]);
                        y2 = Integer.parseInt(tokens[4]);
                        System.out.println("Line " + line);
                       // list.add(new Line(number, x1, y1, x2, y2));
                        break;

                    case "D":
                        x1 = Integer.parseInt(tokens[1]);
                        y1 = Integer.parseInt(tokens[2]);
                        r = Integer.parseInt(tokens[3]);
                        System.out.println("Dot " + line);
                       // list.add(new Dot(number, x1, y1, r));
                        break;
                }
                number++;
            }
        } catch (IOException ex) {
            System.out.println("Couln't write list " + ex);
        }
        list.add(new Box(number));
        
        return list;
    }
   /** 
    public static void main(String[] args){
        readList(".\\src\\ch\\hslu\\prg2\\Training\\savedGame.txt");
        System.out.println("Done ");
    }
    * 
    */
}