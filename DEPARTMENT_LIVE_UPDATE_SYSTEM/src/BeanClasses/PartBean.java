/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanClasses;

public class PartBean {
    
    private int batchId;
    private int part;
    private String partYear;
    private String remarks;
    
    public void setBatchId(int batchId){
        this.batchId=batchId;
    } 
    
    public void setPart(int part){
        this.part=part;
     }
    
    public void setPartYear(String partYear){
        this.partYear=partYear;
    }
    
    public void setRemarks(String remarks){
        this.remarks=remarks;
    }
    
    public int getBatchId(){
        return batchId;
    }
    
    public int getPart(){
      return part;
    }
    public String getPartYear(){
        return partYear;
    }
    public String getRemarks(){
      return remarks;
    }
    
    public String toString(){
	return ""+part;
    }
}
