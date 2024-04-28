package BeanClasses;
public class StudentsBean{

    private int  batchId;
    private int  studId;
	private String studName;
	private String fName;
	private String surName;
	private String rollNo;
        private String cellNo;
        private String remarks;
        private String email;
        

	public void setBatchId(int batchId){
		this.batchId=batchId;
	}

	public void setStudId(int studId){
		this.studId=studId;
	}

	public void setStudName(String studName){
		this.studName=studName;
	}

	public void setFname(String fName){
		this.fName=fName;
	}

	public void setSurName(String surName){
                this.surName=surName;
                
	}
        public void setRollNo(String rollNo){
   	this.rollNo=rollNo;
        }
        
        public void setCellNo(String cellNo){
            this.cellNo=cellNo;
        }
        public void setRemarks(String remarks){
            this.remarks=remarks;
        }
        
        public void setEmail(String email){
            this.email=email;
        }
        
        public int  getBatchId(){
            return batchId;
        }

       public int getStudId(){
		return studId;
	}

      public String getStudName(){
		return studName;
	}


	public String getFname(){
		return fName;
	}

	public String getSurName(){
         return surName;
	}

   public String getRollNo(){
   	 return rollNo;
   }
   
   public String getCellNo(){
       return cellNo;
   }
   
  public String getRemarks(){
  	return remarks;
  }
  
  public String getEmail(){
  	return email;
  }
  


public String toString(){
	return rollNo;
}




}