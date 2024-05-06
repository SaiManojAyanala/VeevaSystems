package org.assessment.utilities;

import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class FileUtilities {

    public void createFile(String fileName) throws Exception{
        try {
           File file =  new File(fileName);
           if(file.createNewFile()){
                log.info(fileName + " File is created");
           }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public void writeToTXTFile(String filepath, String text) throws Exception{
        try (BufferedWriter f_writer
                     = new BufferedWriter(new FileWriter(filepath))){
            f_writer.write(text);
        }catch (IOException e){
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    public void createDirectory(String folderPath) throws Exception{
        boolean created = false;
        File file = new File(folderPath);
        if(!file.exists()){
            try {
                created = file.mkdir();
            }catch (Exception e){
                log.error(e.getMessage());
                throw new Exception(e.getMessage());
            }
        }
        if(created){
            log.info("Folder is available under given path "+ folderPath);
        }
    }

    public void writeToCSV(String filePath, List<String[]> data) throws Exception{
        try{
            File file = new File(filePath);
            FileWriter outputFile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputFile);
            writer.writeAll(data);
            writer.close();
        }catch (Exception e){
            log.error(e.getMessage());
            throw new Exception(e.getMessage());
        }

    }

}
