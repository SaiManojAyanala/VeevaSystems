package org.assessment.utilities;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ReadProperties {

    FileInputStream fis;
    Properties prop;

    String path = System.getProperty("user.dir") +"/src/main/java/org/assessment/resources/EnvironmentVariables.properties";

    public ReadProperties(){
        prop = new Properties();
        try{
            File src = new File(path);
            fis = new FileInputStream(src);
            prop.load(fis);
            fis.close();
        }catch (FileNotFoundException e){
            log.error("Properties File ",e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getcoreProductUrl(){
        return prop.getProperty("core_product_url");
    }

    public String getdesiredProduct1Url(){
        return prop.getProperty("derived_product1_url");
    }

    public String getdesiredProduct2Url(){
        return prop.getProperty("derived_product2_url");
    }

    public String getCPMensProductTXTFilePath(){
        return prop.getProperty("cp_MensProductTXTFilePath");
    }

    public String getCPMensProductTXTFileName(){
        return prop.getProperty("cp_MensProductTXTFileName");
    }

    public String getDP2DuplicateHyperLinksFilePath(){
        return prop.getProperty("dp2DuplicateHyperLinksFilePath");
    }

    public String getDP2DuplicateHyperLinksFileName(){
        return prop.getProperty("dp2DuplicateHyperLinksFileName");
    }

}
