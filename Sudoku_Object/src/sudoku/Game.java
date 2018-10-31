package sudoku;
import sudoku.Node;

public class Game {
	private static Node node[][]=new Node[9][9];
	public Game() {
		for(int i = 0;i<9;i++) 
			for(int j = 0; j<9;j++){
				node[i][j].setRow(i);
				node[i][j].setColumn(j);
				node[i][j].setValue(0);
				node[i][j].setZone((i/3)*3+j/3);
			}
	}
	public void setInput(int row,int column,int value) {
	}
	public void setNode(int row,int column,int value) {
		node[row][column].setValue(value);
	}
	private static boolean checkRow(int row,int value) {
		for(int k=0;k<9;k++)
			if(node[row-1][k].getValue() == value)
				return true;
		return false;
	}
	private static boolean checkColumn(int column,int value) {
		for(int k=0;k<9;k++)
			if(node[k][column-1].getValue() == value)
				return true;
		return false;
	}
	private boolean checkWin() {
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(node[i][j].getValue()==0)
					return false;
		return true;
	}
	public static void show() {
		System.out.println("   1 2 3   4 5 6   7 8 9 ");
		for(int i =0;i<9;i++) {
			if(i%3==0)
				System.out.println("  -----------------------");
			System.out.print(i+1);
			for(int j = 0; j<9;j++)
			{
				if(j%3==0)
					System.out.print("| ");
				if(node[i][j].getValue()==0)
					System.out.print("  ");
				else 
					System.out.print(node[i][j].getValue()+" ");
				if(j==8)
					System.out.print("|\n");
			}
			
		}
		System.out.println("  -----------------------");
	}
}
