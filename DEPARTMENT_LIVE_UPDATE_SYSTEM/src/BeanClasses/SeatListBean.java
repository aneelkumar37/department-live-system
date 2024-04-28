package BeanClasses;

public class SeatListBean{
	
    private int  batchId;
	private int  part;
	private int seatListId;
	private int seatListYear;
	private String type;
	private String remarks;
	

	public void setBatchId(int batchId){
		this.batchId=batchId;
	}
	
	public void setPart(int part){
		this.part=part;
	}

	public void setSeatListId(int seatLListId){
		this.seatListId=seatLListId;
	}

	public void setSeatListYear(int seatLListYear){
		this.seatListYear=seatLListYear;
	}

	public void setType(String  type){
		this.type=type;
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

	 public int  getSeatListId(){
	 	return seatListId;
	 }

	 public int  getSeatListYear(){
	 	return seatListYear;
	 }

	 public String  getType(){
	 	return type;
	 }

	 public String getRemarks(){
	 	return remarks; 
	 }

	public String toString(){
		return ""+seatListYear;
	}
	
}