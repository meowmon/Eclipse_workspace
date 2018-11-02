package sudoku.model;
public class Node {
	private int row;
	private int column;
	private int zone;
	private int value;
	private boolean reverse;
	public Node(){
		row = 10;
		column=10;
		value = 0;
		reverse = true;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public void setZone(int zone) {
		this.zone = zone;
	}
	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}
	public int getRow() {
		return row;
	}
	public int getValue() {
		return value;
	}
	public int getColumn() {
		return column;
	}
	public int getZone() {
		return zone;
	}
	public boolean getReverse() {
		return reverse;
	}
	}
