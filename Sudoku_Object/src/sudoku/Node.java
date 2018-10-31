package sudoku;
public class Node {
	private static int row;
	private static int column;
	private static int zone;
	private static int value;
	private static boolean reverse;
	Node(){
		value = 0;
		reverse = true;
	}
	public static void setRow(int in) {
		row = in;
	}
	public static void setValue(int in) {
		value = in;
	}
	public static void setColumn(int in) {
		column = in;
	}
	public static void setZone(int in) {
		zone = in;
	}
	public static void setReverse(boolean in) {
		reverse = in;
	}
	public static int getRow() {
		return row;
	}
	public static int getValue() {
		return value;
	}
	public static int getColumn() {
		return column;
	}
	public static int getZone() {
		return zone;
	}
	public static boolean getReverse() {
		return reverse;
	}
	}
