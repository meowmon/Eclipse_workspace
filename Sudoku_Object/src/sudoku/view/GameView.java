package sudoku.view;
import java.io.IOException;
import java.util.Scanner;
import sudoku.model.Node;
import sudoku.controller.GameExecute;

public class GameView{
	Scanner in = new Scanner(System.in);
	GameExecute newgame = null;
	public GameView() {
		try {
			this.newgame = new GameExecute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public GameView(Node[][] node) {
		show(node);
	}
	public void gameplay() {
		while (!newgame.checkWin()) {
			getInput();
		}
	}
	public void show(Node[][] node) {
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
	public void getInput(){
		System.out.print("Nhap hang: ");
		int input_x = in.nextInt();
		System.out.print("Nhap cot: ");
		int input_y = in.nextInt();
		System.out.print("Nhap gia tri: ");
		int value = in.nextInt();
		System.out.print("\n\n\n\n\n\n\n\n\n\n");
		if(newgame.setInput(input_x, input_y, value))
			System.out.print(" ");
		else
			System.out.println("Khong the them gia tri ban nhap vao node nay");
			
		}
		
}
