/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

public class StudentPartBean{
	
    private int  batchId;
	private int  part;
	private String  rollNo;
	private String status;
	private String remarks;
	



	public void setBatchId(int batchId){
		this.batchId=batchId;
	}
	
	public void setPart(int part){
		this.part=part;
	}

	public void setRollNo(String  rollNo){
		this.rollNo=rollNo;
	}

	public void setStatus(String  status){
		this.status=status;
	}

   public void setRemarks(String remarks){
   	this.remarks=remarks;
   }

	 public int  getBatchId(){
	 	return batchId;
	 }

	 public int  getPart(){
	 	return part;
	 } 

	 public String  getRollNo(){
	 	return rollNo;
	 }

	 public String  getStatus(){
	 	return status;
	 }

	 public String getRemarks(){
	 	return remarks; 
	 }

	public String toString(){
		return ""+rollNo;
	}






}