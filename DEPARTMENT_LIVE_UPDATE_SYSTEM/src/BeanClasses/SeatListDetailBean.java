package BeanClasses;

public class SeatListDetailBean{
	
    private int  batchId;
	private int  part;
	private String  rollNo;
	private int seatListId;
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

	public void setSeatListId(int seatListId){
		this.seatListId=seatListId;
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

	 public int  getSeatListId(){
	 	return seatListId;
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