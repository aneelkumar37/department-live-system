/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

public class NotificationClassBean {

        private int schemeId;
	private int  schemePart;
        private int  semester;
        private int notificationId;
        private String courseNo;
        private String data_Of_Class;
        private String time_Of_Class;
	private String notification_Send;
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
        
        public void setNotificationId(int notificationId){
		this.notificationId=notificationId;
	}
        
         public void setData_Of_Class(String data_Of_Class){
                this.data_Of_Class=data_Of_Class;
       }

          public void setTime_Of_Class(String time_Of_Class){
                this.time_Of_Class=time_Of_Class;
       }
          
          public void setNotification_Send(String notification_Send){
                this.notification_Send=notification_Send;
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

	public String getCourseNo(){
		return courseNo;
	}
        
        public int getNotificationId(){
		return notificationId;
	}
        
         public String getData_Of_Class(){
                return data_Of_Class;
       }

          public String getTime_Of_Class(){
                return time_Of_Class;
       }
          
          public String getNotification_Send(){
                return notification_Send;
       }
          
            public String getRemarks(){
                return remarks;
       }
            
            
    public String toString(){
        return data_Of_Class;
    }           
        
        
}
