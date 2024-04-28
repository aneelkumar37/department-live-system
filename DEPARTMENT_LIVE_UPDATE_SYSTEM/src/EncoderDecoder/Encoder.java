/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EncoderDecoder;

/**
 *
 * @author Farhan Hyder
 */
public class Encoder {
    
    public static String shiftEncode(String shift){
        switch(shift){
            case "MORNING" : return "M";
            case "EVENING" : return "E";
        }
        return shift;
    }
    public static String groupEncode(String group ){
        
        switch(group){
            
            case "MEDICAL": return "M";
            case"ENGINEERING": return "E";
            case"COMMERCE": return "C";
            case"GENERAL": return "G";
        }
        return group;
    }   
}