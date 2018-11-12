package game.view;
import java.util.*;
import game.model.*;
import game.controller.*;
public class View {
	Gameplay newgame;
	int pickedNode,players;
	boolean move;
	Scanner input = new Scanner(System.in);
	public void showGame(Node[] node, int player, Player[] players) {
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		String b;
		for(int i = 1; i <= player ; i++) {
			if(node[(i-1)*6].haveMaster())
				b = "@";
			else 
				b = " ";
			System.out.print(
			         "             Player "+i+" Score: " +players[i-1].getFinalScore()+"         \n"
			+        " _____  1    2    3    4    5   \n"
			+        "|     |----.----.----.----.----.\n"
			+        "| "+b+" "+node[(i-1)*6].getValue()+" | "+node[(i-1)*6+1].getValue()+"  | "+node[(i-1)*6+2].getValue()+"  | "+node[(i-1)*6+3].getValue()+"  | "+node[(i-1)*6+4].getValue()+"  | "+node[(i-1)*6+5].getValue()+"  |\n"
			+        "|_____|----'----'----'----'----'\n");
		}
	}
	public void getInput(int player) {
		System.out.println("Luot di cua nguoi choi: "+ (player+1));
		System.out.print("Chon o muon di: ");
		pickedNode = input.nextInt();
		System.out.print("Chon huong di(0.Trai   1.Phai):");
		int a = input.nextInt();
		try{ 
			if(a == 0)
			move = true;
			else if (a == 1)
			move = false;
		}
		catch(Exception b) {}
		//can them exception
		newgame.moveControl(pickedNode,player,move);
	}
	public void gamePlay() {
		System.out.print("Nhap so nguoi choi:");
		this.players = input.nextInt();
		int player = 0;
		newgame = new Gameplay(players);
		do {
			getInput(player);
			player++;
			if(player == this.players) 
				player = 0;
		} while(!newgame.checkWin());
		System.out.print("Nguoi choi "+ newgame.findWinner()+ " da chien thang!!!");
	}
}
