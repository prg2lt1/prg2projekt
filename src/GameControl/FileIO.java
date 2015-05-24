package GameControl;

import GameModel.Board;
import GameModel.Box;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Lorenz
 */
public interface FileIO {
    
    static String fileName = ".\\src\\GameControl\\savedGame.bin";

    static void saveBoard(Board board) {
        
        File file = new File(fileName);
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(file));) {
            oStream.writeObject(board);
        } catch (IOException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
    }

    static Board loadBoard() {
        Board board = null;
        File file = new File(fileName);
        
        try (ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(file));) {
            Object object = iStream.readObject();
            if (object instanceof Board) {
                board = (Board) object;
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
        return board;
    }
}
