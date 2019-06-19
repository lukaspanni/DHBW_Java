package dhbw.exercise.java8.soccer;

public class Player {
	private int number;
	private String name;
	private String position;
	private String birthday;
	private String club;
	private int games;
	private int goals;

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getClub() {
		return club;
	}

	public int getGames() {
		return games;
	}

	public int getGoals() {
		return goals;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public Player(int number, String name, String position, String birthday, String club, int games, int goals) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.birthday = birthday;
		this.club = club;
		this.games = games;
		this.goals = goals;
	}

	@Override
	public String toString() {
		return "Player [number=" + number + ", name=" + name + ", position=" + position + ", birthday=" + birthday
				+ ", club=" + club + ", games=" + games + ", goals=" + goals + "]";
	}

	public static Player parse(String str) {
		return null;
	}

}
