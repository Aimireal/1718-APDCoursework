
public class Baboon implements Runnable{
	//private variables
	private String name;
	private Bridge bridge;
	public Baboon(Bridge bridge){
		this.bridge = bridge; //assign value of parameter bridge to variable of same name
	}
	
	//method implemented when there is runnable interface
	public void run(){
		bridge.crossBridge(this);
	}
	//get method for baboon name
	public String getName(){
		return name;
	}
	//set method for baboon name
	public void setName(String name){
		this.name = name;
	}
}
