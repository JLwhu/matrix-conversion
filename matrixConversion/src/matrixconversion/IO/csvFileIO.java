/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixconversion.IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jingliu5
 */
public class csvFileIO {

    public List readHeader(String filename) throws FileNotFoundException {
        ArrayList<String> headers = new ArrayList<String>();
        Scanner lineScan;
        lineScan = new Scanner(new File(filename));
        Scanner s = new Scanner(lineScan.nextLine());
        s.useDelimiter(",");
        int i = 0;
        while (s.hasNext()) {
            String character = s.next();
            if (character != null && !character.equals("")) {
                headers.add(character);
            }

        }
        return headers;
    }

    public List readRow(String filename, int rowNum) throws FileNotFoundException {
        Scanner lineScan;
        lineScan = new Scanner(new File(filename));
        Scanner s;
        for (int i = 0; i < rowNum - 1; i++) {
            lineScan.nextLine();
        }
        s = new Scanner(lineScan.nextLine());
        s.useDelimiter(",");
        ArrayList<String> row = new ArrayList<String>();
        while (s.hasNext()) {
            String character = s.next();
            if (character != null && !character.equals("")) {
                row.add(character);
            }

        }
        return row;
    }

    public List readAll(String filename) throws FileNotFoundException {
        Scanner lineScan;
        lineScan = new Scanner(new File(filename));
        Scanner s;
        List all = new ArrayList();

        s = new Scanner(lineScan.nextLine());
        s.useDelimiter(",");
        ArrayList<String> headers = new ArrayList<String>();
        while (s.hasNext()) {
            String character = s.next();
            if (character != null && !character.equals("")) {
                headers.add(character);
                ArrayList<String> column = new ArrayList<String>();
                all.add(column);
            }
        }

        // Go through each line of the table and add each cell to the ArrayList
        while (lineScan.hasNextLine()) {
            s = new Scanner(lineScan.nextLine());
            s.useDelimiter(", *");
            for (int i = 0; i < all.size(); i++) {
                if (s.hasNext()) {
                    String item = s.next();
                    if (item != null && !item.equals("")) {
                        ArrayList<String> column = (ArrayList<String>) all.get(i);
                        if (!column.contains(item)) {
                            column.add(item);
                        }
                    }
                }
            }
        }
        return all;
    }
    

    
}
