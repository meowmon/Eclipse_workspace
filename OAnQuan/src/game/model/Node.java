package game.model;

public class Node {
	int value;
	boolean masterNode;
	boolean master;
	
	
	
	public Node() {
		this.value = 5;
		this.masterNode = false;
		this.master = false;
	}
	public void setValue(int value) {
		this.value=value;
	}
	public void setMasterNode(boolean masterNode) {
		this.masterNode = masterNode;
	}
	public void setMaster(boolean master ) {
		this.master= master;
	}
	public int getValue() {
		return value;
	}
	public boolean isMasterNode() {
		return masterNode;
	}
	public boolean isMaster() {
		return master;
	}
}