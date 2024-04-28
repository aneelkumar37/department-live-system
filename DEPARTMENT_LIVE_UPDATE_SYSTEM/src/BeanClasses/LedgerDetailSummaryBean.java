/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Dell
 */
public class LedgerDetailSummaryBean {

         private int seatListId;
	 private String rollNo;
         private String qpa;
         private int marksObt;
         private int totalMarks;
         private String result;
         private String percentage;
         private String individaulDateOfAnn;   
         private String remarks;
         
         
          public void setSeatListId(int seatListId){
		this.seatListId=seatListId;
	}
        
          public void setRollNo(String rollNo){
		this.rollNo=rollNo;
	}
          
          public void setMarksObt(int marksObt){
		this.marksObt=marksObt;
	}
           public void setTotalMarks(int  totalMarks){
		this.totalMarks=totalMarks;
	}
          
          public void setGPA(String qpa){
		this.qpa=qpa;
                   
	} 
           public void setResult(String result){
		this.result=result;
                   
	} 
           
           
             public void setPercentage(String percentage){
		this.percentage=percentage;
                   
	} 
             
               public void setIndividaulDateOfAnn(String individaulDateOfAnn){
		this.individaulDateOfAnn=individaulDateOfAnn;
                   
	} 
             
             
         public void setRemarks(String remarks){
		this.remarks=remarks;
                   
	} 
         
        
  
          public int getSeatListId(){
		return seatListId;
	}
          public String  getRollNo(){
		return rollNo;
	}
          
          public int getMarksObt(){
		return marksObt;
	}
           public int getTotalMarks(){
		return totalMarks;
	}
          
          public String getGPA(){
		return qpa;
                   
	} 
           public String getResult(){
		return result;
                   
	}
           public String getPercentage(){
		return percentage;        
	}  
               public String getIndividaulDateOfAnn(){
		return individaulDateOfAnn;
                   
	} 
             
             
         public String getRemarks(){
		return remarks;
                   
	} 
         
         public String toString(){
		return rollNo;
	}
    
    
}
