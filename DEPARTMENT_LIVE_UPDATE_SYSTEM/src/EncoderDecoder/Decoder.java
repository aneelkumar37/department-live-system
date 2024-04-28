/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EncoderDecoder;

/**
 *
 * @author Farhan Hyder
 */
public class Decoder {
    
    public static String shiftDecode(String shift){
        
        switch(shift){
            case "M":return"MORNING";
            case "E":return"EVENING";
        }
        
        return shift;
    }
    
    public static String groupDecode(String group){
        
        switch(group){
            
            
            case "M":return"MEDICAL";
            case "E":return"ENGINEERING";
            case "C":return"COMMERCE";
            case "G":return"GENERAL";
        }
        return group;
    }
     public static String decodeDate(java.util.Date date){
        
        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("dd/MM/yyyy");
        String dateStr=f.format(date);
        return dateStr;
    }
    
}
