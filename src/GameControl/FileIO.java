package GameControl;

import GameModel.Board;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Lorenz
 */
public interface FileIO {
    
    static final String fileBoard = ".\\src\\GameControl\\savedGame.bin";

    /**
     * Speichert ein Board als .bin-File im GameControl ab.
     * @param item 
     */
    static void saveBoard(Board item) {
        
        File file = new File(fileBoard);
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(file));) {
            oStream.writeObject(item);
        } catch (IOException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
    }
    
    /**
     * Liest das gespeicherte .bin-File ein und gibt ein Board zurück.
     * @return Board
     */
    static Board loadBoard() {
        Board item = null;
        File file = new File(fileBoard);
        
        try (ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(file));) {
            Object object = iStream.readObject();
            if (object instanceof Board) {
                item = (Board) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
        return item;
    }
}
