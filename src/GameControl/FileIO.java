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
    
    static final String fileBoard = ".\\src\\GameControl\\savedGame.bin";
        static final String fileFlow = ".\\src\\GameControl\\savedFlow.bin";

    static void saveBoard(Board item) {
        
        File file = new File(fileBoard);
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(file));) {
            oStream.writeObject(item);
        } catch (IOException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
    }
    
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
    
        static void saveFlow(Flow item) {
        
        File file = new File(fileFlow);
        try (ObjectOutputStream oStream = new ObjectOutputStream(new FileOutputStream(file));) {
            oStream.writeObject(item);
        } catch (IOException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
    }
    
    static Flow loadFlow() {
        Flow item = null;
        File file = new File(fileFlow);
        
        try (ObjectInputStream iStream = new ObjectInputStream(new FileInputStream(file));) {
            Object object = iStream.readObject();
            if (object instanceof Flow) {
                item = (Flow) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[info (FileIO)] Filename's wrong: " + e.getMessage());
        }
        return item;
    }
}
