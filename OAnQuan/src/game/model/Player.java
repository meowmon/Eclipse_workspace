package game.model;

public class Player {
	int score;
	int masterGot;
	int playerZone;
	public Player() {
		this.score = 0;
		this.masterGot = 0;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setMaster() {
		this.masterGot++;
	}
	public void setPlayerZone(int zone) {
		this.playerZone = zone;
	}
	public int getScore() {
		return score;
	}
	public int getFinalScore() {
		return score + masterGot*10;
	}
	public int getZone() {
		return playerZone;
	}
}
