package game.controller;
import java.util.*;
import game.model.*;
import game.view.*;



public class Gameplay {
	Node[] node;
	Player[] player;
	public Gameplay(int n) {
		node = new Node[n*6];
		player = new Player[n];
		for (int i = 0; i < n*6; i++) {
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
			moveLeft(player*6 + node);
		}
		else {
			moveRight(player*6 + node);
		}
	}
	private void moveLeft(int node) {
		int processNode = node-1;
		while(this.node[node].getValue()>0) {
			this.node[processNode].setvalue(this.node[processNode].getValue()+1);
		}
		
	}
	private void moveRight(int node) {
		
		
	}
	

}
