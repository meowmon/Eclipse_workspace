package game.controller;
import java.util.*;
import game.model.*;
import game.view.*;



public class Gameplay {
	Node[] node;
	Player[] player;
	int fullNode;
	public Gameplay(int n) {
		fullNode=n*6;
		node = new Node[fullNode];
		player = new Player[n];
		for (int i = 0; i < fullNode; i++) {
			node[i] = new Node();
			if(i/6==0) {
				node[i].setValue(0);
				node[i].setMaster(true);
				node[i].setMasterNode(true);
				player[i/6] = new Player();
				player[i/6].setPlayerZone(i/6);
			}
		}
	}
	private void pickNode(int node, boolean move,int player) {
		if(move) {
			moveLeft(node,player);
		}
		else {
			moveRight(node,player);
		}
	}
	private void moveLeft(int node, int player) {
		int processNode = node-1;
		while(this.node[node].getValue()>0) {
			this.node[processNode].setValue(this.node[processNode].getValue()+1);
			this.node[node].setValue(this.node[node].getValue()-1);
			processNode -= 1 ;
			if(processNode<0)
				processNode = this.fullNode;
		}
		if(this.node[processNode].isMasterNode()) {}
		else if(this.node[processNode].getValue()!=0)
			pickNode(processNode,true,player);
		else if(this.node[processNode].getValue()==0) {
			getScoreLeft(processNode,player);
		}
		
	}
	
	private void moveRight(int node,int player) {
		int processNode = node+1;
		while(this.node[node].getValue()>0) {
			this.node[processNode].setValue(this.node[processNode].getValue()+1);
			this.node[node].setValue(this.node[node].getValue()-1);
			processNode += 1;
			if(processNode>this.fullNode)
				processNode = 0;
		}	
	}
	private boolean checkWin() {
		for(int i = 0; i < this.fullNode; i += 6) {
			if(node[i].haveMaster())
				return false;
		}
		return true;
	}
	private void getScoreLeft(int node,int player) {
		// TODO Auto-generated method stub
		
	}
	private void getScoreRight(int node,int player) {
		// TODO Auto-generated method stub
		
	}
}
