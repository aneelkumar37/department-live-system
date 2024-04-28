/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Farhan Hyder
 */
public class SchemeBean {
    
    private int progId;
    private int schemeId;
    private int schemeYear;
    private String groupDes;
    private int miniMarks;
    private String remarks;
    
    public void setProgId(int progId){
 	this.progId=progId;
    }
    
    public void setSchemeId(int schemeId){
        this.schemeId=schemeId;
    }
    
    public void setSchemeYear(int schemeYear){
        this.schemeYear=schemeYear;
    }
    
    public void setGroupDes(String groupDes){
        this.groupDes=groupDes;
    }
    
    public void setMiniMarks(int miniMarks){
        this.miniMarks=miniMarks;
    }
    
    public void setRemarks(String remarks){
	this.remarks=remarks;
    }
    
    public int  getProgId(){
	return progId;
    }
    
    public int getSchemeId(){
        return schemeId;
    }
    
    public int getSchemeYear(){
        return schemeYear;
    }
    
    public String getGroupDes(){
        return groupDes;
    }
    
    public int getMiniMarks(){
        return miniMarks;
    }
    public String getRemaks(){
        return remarks;
    }
    
    /**
     *
     * @return
     */
    @Override
        public String toString(){
	return ""+schemeYear;
    }
    
}
