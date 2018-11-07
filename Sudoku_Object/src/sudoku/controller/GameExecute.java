package sudoku.controller;
import sudoku.model.*;
import sudoku.view.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GameExecute {
	static int sizeZone=3,fullSize=sizeZone*sizeZone;
	GameView view;
	private Node node[][] = new Node[fullSize][fullSize];
	public GameExecute() throws IOException {
		for(int i = 0;i<9;i++) 
			for(int j = 0; j<9;j++){
				node[i][j] = new Node();
				node[i][j].setRow(i);
				node[i][j].setColumn(j);
				node[i][j].setValue(0);
				node[i][j].setZone(i/3*3+j/3);
			}
		loadInput();
		view=new GameView(node);
	}
	public void loadInput() {
		File file = new File("input.txt");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		int input_x;
		Scanner fin = null;
		try {
			fin = new Scanner(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		do {
			input_x = fin.nextInt();
			if(input_x==0)
				break;
			int input_y = fin.nextInt();
			node[input_x-1][input_y-1].setValue(fin.nextInt());
			if (fin.nextInt()==0)
				node[input_x-1][input_y-1].setReverse(false);
		} while (input_x!=0);
		fin.close();
	}
	public boolean setInput(int row,int column,int value) {
		if(checkColumn(column,value) || checkRow(row,value) || !node[row-1][column-1].getReverse() || checkZone(row,column,value)) {
			view=new GameView(node);
			return false;
		}
		else {
			setNode(row,column,value);
			view=new GameView(node);
			}
		return true;
	}
	private void setNode(int row,int column,int value) {
		node[row-1][column-1].setValue(value);
	}
	private boolean checkRow(int row,int value) {
		for(int k=0;k<9;k++)
			if(node[row-1][k].getValue() == value)
				return true;
		return false;
	}
	private boolean checkColumn(int column,int value) {
		for(int k=0;k<9;k++)
			if(node[k][column-1].getValue() == value)
				return true;
		return false;
	}
	public boolean checkWin() {
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
				if(node[i][j].getValue()==0)
					return false;
		return true;
	}
	public boolean checkZone(int row, int column, int value) {
		for (int a = (row-1)/3*3; a < (row-1)/3*3 + 3; a++)
			for (int b = (column-1)/3*3; b < (column-1)/3*3 + 3 ; b++) 
				if(node[a][b].getValue()==value)
					return true;
		return false;
	}
	public void show() {
		System.out.println("   1 2 3   4 5 6   7 8 9 ");
		for(int i =0;i<9;i++) {
			if(i%3==0)
				System.out.println("  ------- ------- -------");
			System.out.print(i+1);
			for(int j = 0; j<9;j++){
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
		System.out.println("  ------- ------- -------");
	}
}
