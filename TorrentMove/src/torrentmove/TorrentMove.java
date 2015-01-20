/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torrentmove;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author My Hoang
 */
public class TorrentMove {
    public static void main(String[] args) {
        
        String sourceFilePathString = args[0];
        String sourceFileName = sourceFilePathString.substring(sourceFilePathString.lastIndexOf("\\") + 1);
        System.out.println(sourceFileName);
        Path sourceFilePath = Paths.get(sourceFilePathString);
        
        String folderPathString = sourceFilePathString.substring(0, sourceFilePathString.lastIndexOf("."));
        Path folderPath = Paths.get(folderPathString);
        
        String destFilePathString = folderPathString.concat("\\\\").concat(sourceFileName);
        Path destFilePath = Paths.get(destFilePathString);
        
        File folder = new File (folderPathString);
        if ( !folder.exists() ) {
            folder.mkdir();
        }
        try {
            Files.move(sourceFilePath, destFilePath, REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(TorrentMove.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
