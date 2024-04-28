/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BeanClasses;


public class TimeTableBean {
private int deptId;
private int time_table_id;
private String description;
private String remarks;


 public void setDeptId(int deptId){
 	this.deptId=deptId;
 }
 
 public void setTimeTableId(int time_table_id){
 	this.time_table_id=time_table_id;
 }
 
 public void setDescription(String  description){
 	this.description=description;
 }
 
 public void setRemarks(String  remarks){
 	this.remarks=remarks;
 }
 
 
 
 public int getDeptId(){
 	return deptId;
 }
 
 public int getTimeTableId(){
 	return time_table_id;
 }
 
 public String getDescription(){
 	return description;
 }
 
 public String getRemarks(){
 	return remarks;
 }
 
 public String toString(){
         return description;
 }
    
}
