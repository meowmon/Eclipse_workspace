import java.io.IOException;
import java.util.*;
import sudoku.view.*;

import sudoku.controller.GameExecute;

public class Main {

	public static void main(String[] args) throws IOException {
		GameView newgame = new GameView();
		newgame.gameplay();
		System.out.print("YOU WIN!!!");
	}

}
