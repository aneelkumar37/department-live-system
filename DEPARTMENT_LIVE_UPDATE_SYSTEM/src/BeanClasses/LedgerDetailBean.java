/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Dell
 */
public class LedgerDetailBean {
    
    private int sLId;
    private int schemeId;
    private int  schemePart;
    private int  semester;
    private String courseNO;
    private String rollNo;
    private int marksObt;
    private int qp;
    private String grade;
    private String result;
    private String remarks;
         
        public void setSeatListId(int sLId){
		this.sLId=sLId;
	} 
         
        public void setSchemeId(int schemeId){
		this.schemeId=schemeId;
	} 
	public void setSchemePart(int schemePart){
		this.schemePart=schemePart;
	}
	
	public void setSemester(int semester){
		this.semester=semester;
	}
        
        public void setCourseNO(String courseNO){
		this.courseNO=courseNO;
	}
        
          public void setRollNo(String rollNo){
		this.rollNo=rollNo;
	}
          
          public void setMarksObt(int marksObt){
		this.marksObt=marksObt;
	}
          
          public void setQP(int qp){
		this.qp=qp;
                   
	} 
           public void setResult(String result){
		this.result=result;
                   
	} 
           
           
             public void setGrade(String grade){
		this.grade=grade;
                   
	} 
             
         public void setRemarks(String remarks){
		this.remarks=remarks;
                   
	}
         
        public int  getSeatListId(){
		return sLId;
	} 
         
        public int  getSchemeId(){
		return schemeId;
	} 
	public int getSchemePart(){
		return schemePart;
	}
	
	public int  getSemester(){
		return semester;
	}
        
        public String getCourseNO(){
		return courseNO;
	}
        
          public String getRollNo(){
		return rollNo;
	}
          
          public int getMarksObt(){
		return marksObt;
	}
          
          public int getQP(){
            return qp;
                   
	} 
           public String getResult(){
		return result;
                   
	} 
           
           
             public String getGrade(){
		return grade;
                  
	} 
             
         public String getRemarks(){
		return remarks;      
	}
         
    /**
     *
     * @return
     */
    @Override
         public String toString(){
		return ""+rollNo;
	}
         
    }
