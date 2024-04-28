/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Farhan Hyder
 */
public class SchemePartBean {
    
    private int schemeId;
    private int schemePart;
    private String remarks;
    
    public void setSchemeId(int schemeId){
        this.schemeId=schemeId;
    }
    public void setSchemePart(int schemePart){
        this.schemePart=schemePart;
    }
    
    public void setRemarks(String remarks){
	this.remarks=remarks;
    }
    
    public int getSchemeId(){
        return schemeId;
    }
    
    public int getSchemePart(){
        return schemePart;
    }
    
    public String getRemarks(){
        return remarks;
    }
    
    public String toString(){
        return ""+ schemePart;
    }
    
}
