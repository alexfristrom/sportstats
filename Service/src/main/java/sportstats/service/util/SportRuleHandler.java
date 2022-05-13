/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author alexf
 */
public class SportRuleHandler {
            
    private Properties prop = new Properties();
    private String sport;
    
    public SportRuleHandler(String sportName){
        this.sport = sportName;
        
        try (InputStream input = SportRuleHandler.class.getClassLoader()
            .getResourceAsStream("rules.properties")){
            
            
            if (input == null) {
                System.out.println("Unable o find rules.properties");
            }
            
            prop.load(input);
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public int getPointsByRules(int ){
        
        return 0;
    }
    
}
