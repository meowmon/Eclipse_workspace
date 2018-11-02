import java.util.*;

import sudoku.controller.GameExecute;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input_x,input_y,value;
		GameExecute newgame = new GameExecute();
		do {
		newgame.show();
		System.out.print("Nhap hang: ");
		input_x = in.nextInt();
		System.out.print("Nhap cot: ");
		input_y = in.nextInt();
		System.out.print("Nhap gia tri: ");
		value = in.nextInt();
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		if(newgame.setInput(input_x, input_y, value))
			System.out.print(" ");
		else
			System.out.println("Khong the them gia tri ban nhap vao node nay");
		}while(!newgame.checkWin());
		System.out.print("YOU WIN!!!");
	}

}
