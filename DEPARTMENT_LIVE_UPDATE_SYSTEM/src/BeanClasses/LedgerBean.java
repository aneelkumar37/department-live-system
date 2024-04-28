/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

public class LedgerBean {
	
	private int schemeId;
	private int  slId;
        private String  tabulatorName;
	private String checkerName;
	private java.util.Date dateOfAnnouncement;
//        private String dateOfAnnouncement;
	private String remarks;
	
	public void setSchemeId(int schemeId){
		this.schemeId=schemeId;
	} 
	
	public void setSLId(int slId){
		this.slId=slId;
	}
	
	public void setTabulatorName(String tabulatorName){
		this.tabulatorName=tabulatorName;
	}

	public void setCheckerName(String checkerName){
		this.checkerName=checkerName;
	}
        
         public void setDateOfAnnouncement(java.util.Date dateOfAnnouncement){
                this.dateOfAnnouncement=dateOfAnnouncement;
       }
         
//         public void setDateOfAnnouncement(String dateOfAnnouncement){
//                this.dateOfAnnouncement=dateOfAnnouncement;
//       }

          public void setRemarks(String remarks){
                this.remarks=remarks;
       }

       public int  getSchemeId(){
		return schemeId;
	} 
	
	public int  getSLId(){
		return slId;
	}
	
	public String getTabulatorName(){
		return tabulatorName;
	}

	public String getCheckerName(){
		return checkerName;
	}
        
         public java.util.Date getDateOfAnnouncement(){
                return dateOfAnnouncement;
       }
         
//         public String getDateOfAnnouncement(){
//                return dateOfAnnouncement;
//       }

          public String getRemarks(){
                return remarks;
       }
                   
    /**
     *
     * @return
     */
    @Override
	public String toString(){
		return checkerName;
	}
}
