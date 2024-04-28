/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;


public class SchemeDetailBean {

        private int schemeId;
	private int  schemePart;
        private int  semester;
        private String courseTitle;
        private String courseNo;
        private int maxMarks;
        private int creditHours;
	private String subType;
        private String remarks;
        
         public void setSchemeId(int schemeId){
		this.schemeId=schemeId;
	} 
	public void setSchemePart(int schemePart){
		this.schemePart=schemePart;
	}
	
	public void setSemester(int semester){
		this.semester=semester;
	}

	public void setCourseNo(String courseNo){
		this.courseNo=courseNo;
	}
        
        public void setCourseTtile(String courseTitle){
		this.courseTitle=courseTitle;
	}
        
         public void setMaxMarks(int maxMarks){
                this.maxMarks=maxMarks;
       }

          public void setcreditHours(int creditHours){
                this.creditHours=creditHours;
       }
          
          public void setSubType(String subType){
                this.subType=subType;
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
	
	public int getSemester(){
		return semester;
	}
        
        public String getCrouseTitle(){
		return courseTitle;
	}

	public String getCourseNo(){
		return courseNo;
	}
        
         public int getMaxMarks(){
                return maxMarks;
       }

          public int getCreditHours(){
                return creditHours;
       }
          
          public String getSubType(){
                return subType;
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
                return courseNo;
            }
}
