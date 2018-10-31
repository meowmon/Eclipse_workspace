import java.util.*;
import java.io.*;
public class Sudoku {
	static int mat[][] = new int[9][9],input_x,input_y,value;
	static boolean replace[][] = new boolean[9][9];
	static Scanner in = new Scanner(System.in);
	Sudoku() {
		for(int i = 0;i<9;i++) 
			for(int j = 0; j<9;j++){
				mat[i][j]=0;
				replace[i][j]= true;
			}
	}
	public static void main(String[] args) throws IOException {
		loadInput();
		do {
			print();
			int choice = in.nextInt();
			if(choice == 1)
				input();
			if(choice == 2)
				deleteUnit();
		}while (!checkWin());
		print();
	}
	public static void loadInput() throws IOException {
		File file = new File("input.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		Scanner fin = new Scanner(file);
		do {
			input_x = fin.nextInt();
			if(input_x==0)
				break;
			input_y = fin.nextInt();
			value =  fin.nextInt();
			mat[input_x-1][input_y-1] = value;
			replace[input_x-1][input_y-1] = false;
		} while (input_x!=0);
		fin.close();
	}
	public static void deleteUnit() {
		System.out.print("Nhap hang: ");
		input_x = in.nextInt();
		System.out.print("Nhap cot: ");
		input_y = in.nextInt();
		if(replace[input_x][input_y])
			System.out.print("Ban khong the xoa gia tri o nay!!!");
		else
			mat[input_x-1][input_y-1] = 0;
	}
	public static boolean checkWin() {
			for(int i=0;i<9;i++)
				for(int j=0;j<9;j++)
					if(mat[i][j]==0)
						return false;
		return true;
	}
	public static void input() {
		System.out.print("Nhap hang: ");
		input_x = in.nextInt();
		System.out.print("Nhap cot: ");
		input_y = in.nextInt();
		System.out.print("Nhap gia tri: ");
		value = in.nextInt();
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		if(!(value >= 1 && value <=9))
			System.out.println("Ban phai nhap gia tri tu 0 -> 9!!!");
		else if(replace[input_x][input_y])
			System.out.println("Ban khong the thay doi gia tri o nay!!!");
		else if(checkRow())
			System.out.println("Gia tri ban nhap da ton tai trong hang!!!");
		else if(checkColumn())
			System.out.println("Gia tri ban nhap da ton tai trong cot!!!");
		else if(checkZone())
			System.out.println("Gia tri ban nhap da ton tai trong zone!!!");
		else
			mat[input_x-1][input_y-1]=value;
	}
	public static boolean checkRow() {
		for(int k=0;k<9;k++)
			if(mat[input_x-1][k]==value)
				return true;
		return false;
	}
	public static boolean checkColumn() {
		for(int k=0;k<9;k++)
			if(mat[k][input_y-1]==value)
				return true;
		return false;
	}
	public static boolean checkZone() {
		int x=input_x/3,y=input_y/3;
		for (int a = x*3; a < x*3 + 3; a++)
			for (int b = y*3; b < y*3 + 3 ; b++) 
				if(mat[a][b]==value)
					return true;
		return false;
	}
	public static void print() {
		System.out.println("   1 2 3   4 5 6   7 8 9 ");
		for(int i =0;i<9;i++) {
			if(i%3==0)
				System.out.println("  -----------------------");
			System.out.print(i+1);
			for(int j = 0; j<9;j++)
			{
				if(j%3==0)
					System.out.print("| ");
				if(mat[i][j]==0)
					System.out.print("  ");
				else 
					System.out.print(mat[i][j]+" ");
				if(j==8)
					System.out.print("|\n");
			}
			
		}
		System.out.println("  -----------------------");
		System.out.println("Ban muon lam gi:\n1.Dien o\n2.Xoa o");
	}
}
