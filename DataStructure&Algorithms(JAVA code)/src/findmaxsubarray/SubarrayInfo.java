package findmaxsubarray;

public class SubarrayInfo {

	private int front;
	private int end;
	private int sum;
	
	public SubarrayInfo(){};
	public SubarrayInfo(int front, int end, int sum){
		this.front = front;
		this.end = end;
		this.sum = sum;
	}
	
	public void setFront(int front){
		this.front = front;
	}
	public void setEnd(int end){
		this.end = end;
	}
	public void setSum(int sum){
		this.sum = sum;
	}
	public int getSum(){
		return sum;
	}
	public int getFront(){
		return front;
	}
	public int getEnd(){
		return end;
	}
}
