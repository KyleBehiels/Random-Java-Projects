
public class player {
	String playerName, playerTeam, playerPosition;
	int playerJerseyNumber, kills = 0, continues = 0, tips = 0, blocks = 0;
	public player(String name, String team, String position, int jerseyNumber){
		playerName = name;
		playerTeam = team;
		playerPosition = position;
		playerJerseyNumber = jerseyNumber;	
	}
	public void addPoint(String attackType){
		switch(attackType){
		case "kill":
			this.kills++;
			break;
		case "continue":
			this.continues++;
			break;
		case "tip":
			this.tips++;
			break;
		case "block":
			this.blocks++;
			break;
		}	
	}
	public void subtractPoint(String attackType){
		switch(attackType){
		case "kill":
			this.kills--;
			break;
		case "continue":
			this.continues--;
			break;
		case "tip":
			this.tips--;
			break;
		case "block":
			this.blocks--;
			break;
		}	
	}
	public void printAllVals(){
		System.out.println(playerName + "\n" + playerTeam + "\n" + playerPosition + "\n" + playerJerseyNumber);
	}
}
