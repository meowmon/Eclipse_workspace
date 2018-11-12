package game.controller;
import game.model.*;
import game.view.*;



public class Gameplay {
	Node[] node;
	Player[] player;
	int fullNode, players;
	View view = new View();
	public Gameplay(int n) {
		fullNode=n*6;
		players = n;
		node = new Node[fullNode];
		player = new Player[players];
		for (int i = 0; i < fullNode; i++) {
			node[i] = new Node();
			if(i%6==0) {
				node[i].setValue(0);
				node[i].setMaster(true);
				node[i].setMasterNode(true);
				player[i/6] = new Player();
				player[i/6].setPlayerZone(i/6);
			}
		}
	view.showGame(node,players,player);
	}
	public void moveControl(int pickedNode, int player, boolean move) {
		if(move) 
			moveLeft(player*6 + pickedNode, player);
		else
			moveRight(player*6 + pickedNode, player);
		view.showGame(node,players,this.player);
		fillBlankPlayZone();
	}
	public void moveLeft(int node, int player) {
		int processNode = node-1;
		while(this.node[node].getValue()>0) {
			this.node[processNode].setValue(this.node[processNode].getValue()+1);
			this.node[node].setValue(this.node[node].getValue()-1);
			processNode -= 1 ;
			if(processNode<0)
				processNode = this.fullNode-1;
		}
		if(this.node[processNode].isMasterNode()){}
		else if(this.node[processNode].getValue()!=0)
			moveLeft(processNode, player);
		else if(this.node[processNode].getValue()==0) {
			getScoreLeft(processNode,player);
		}
		
	}
	public void moveRight(int node,int player) {
		int processNode = node+1;
		while(this.node[node].getValue()>0) {
			this.node[processNode].setValue(this.node[processNode].getValue()+1);
			this.node[node].setValue(this.node[node].getValue()-1);
			processNode += 1;
			if(processNode == this.fullNode)
				processNode = 0;
		}
		if(this.node[processNode].isMasterNode()) {}
		else if(this.node[processNode].getValue()!=0)
			moveRight(processNode, player);
		else if(this.node[processNode].getValue()==0) {
			getScoreRight(processNode,player);
		}
	}
	public boolean checkWin() {
		for(int i = 0; i < this.fullNode; i += 6) {
			if(node[i].haveMaster())
				return false;
		} 
		for(int i = 0; i< this.players; i ++)
			if(player[i].getScore()<0)
				return true;
		return true;
	}
	private void getScoreLeft(int node,int player) {
		this.player[player].setScore(this.player[player].getScore()+this.node[node-1].getValue());
		if(this.node[node-1].haveMaster()) {
			this.node[node-1].setMaster(false);
			this.player[player].setMaster();
		}
		this.node[node-1].setValue(0);
		int nextNode = node - 2;
		if(nextNode < 0)
			nextNode = this.fullNode -1 ;
		if(this.node[nextNode].isMasterNode() || this.node[nextNode].getValue()!=0) {}
		else {
			getScoreLeft(nextNode,player);
		}
	}
	private void getScoreRight(int node,int player) {
		this.player[player].setScore(this.player[player].getScore()+this.node[node+1].getValue());
		if(this.node[node+1].haveMaster()) {
			this.node[node+1].setMaster(false);
			this.player[player].setMaster();
		}
		this.node[node+1].setValue(0);
		int nextNode = node + 2;
		if(nextNode == this.fullNode)
			nextNode = 0;
		if(this.node[nextNode].isMasterNode() || this.node[nextNode].getValue()!=0) {}
		else {
			getScoreRight(nextNode,player);
		}
	}
	private void fillBlankPlayZone() {
		for (int i=0 ; i< players; i++) {
			if(this.node[i*6+1].getValue()==0 && this.node[i*6+2].getValue()==0 && this.node[i*6+3].getValue()==0 && this.node[i*6+4].getValue()==0 && this.node[i*6+5].getValue()==0) {
				this.node[i*6+1].setValue(1);
				this.node[i*6+2].setValue(1);
				this.node[i*6+3].setValue(1);
				this.node[i*6+4].setValue(1);
				this.node[i*6+5].setValue(1);
				this.player[i].setScore(this.player[i].getScore()-5);
			}
		}
	}
	public int findWinner() {
		int winner =0;
		for(int i =0; i < players;i++) {
			if(this.player[i].getFinalScore()>this.player[winner].getFinalScore())
				winner = i;
		}
		return winner+1;
	}
	
}
