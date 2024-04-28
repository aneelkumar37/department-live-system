/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;

/**
 *
 * @author Dell
 */
public class SchemeSemesterBean {
    
    private int schemeId;
    private int  partScheme;
    private int  semester;
    private String remarks;
        
       public void setSchemeId(int schemeId){
           this.schemeId=schemeId;
	} 
	public void setPartScheme(int partScheme){
            this.partScheme=partScheme;
	}
        public void setSemester(int semester){
            this.semester=semester;
	}
        public void setRemarks(String remarks){
            this.remarks=remarks;
        }
        public int getSchemeId(){
            return schemeId;
        }
        public int getPartScheme(){
            return partScheme;
        }
        public int getSemester(){
            return semester;
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
	return ""+semester;
    }

        
}
