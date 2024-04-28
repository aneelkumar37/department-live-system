/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;


public class AssignmentBean {
   
      private int teacherId;
        private int  assignmentId;
	private String assigTitle;
	private String startDate;
	private String lastDate;
	private String assignDesc;
        private String whoDoTheAssign;
        private String remarks;
    


        public void setTeacherId(int teacherId){
		this.teacherId=teacherId;
	}

        public void setAssginId(int assignmentId){
		this.assignmentId=assignmentId;
	}
      
        public void setAssigTitle(String assigTitle){
		this.assigTitle=assigTitle;
	}
           
        public void setStartDate(String startDate){
		this.startDate=startDate;
	}
        
        public void setLastDate(String lastDate){
		this.lastDate=lastDate;
	}
        
        public void setAssignDesc(String assignDesc){
		this.assignDesc=assignDesc;
	}
        
        public void setWhoDoTheAssign(String whoDoTheAssign){
		this.whoDoTheAssign=whoDoTheAssign;
	}
        
        public void setRemarks(String remarks){
		this.remarks=remarks;
	}
        
        
        
        public int getTeacherId(){
		return teacherId;
	}

        public int getAssginId(){
		return assignmentId;
	}
      
        public String  getAssigTitle(){
		return assigTitle;
	}
           
        public String getStartDate(){
		return startDate;
	}
        
        public String getLastDate(){
		return lastDate;
	}
        
        public String getAssignDesc(){
		return assignDesc;
	}
        
        public String getWhoDoTheAssign(){
		return whoDoTheAssign;
	}
        
        public String getRemarks(){
		return remarks;
	}
 

    public String toString(){
    
      return assigTitle;
    }

}
