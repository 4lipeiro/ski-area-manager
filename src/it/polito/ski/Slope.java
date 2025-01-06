package it.polito.ski;

public class Slope {
	private String runName;
	private String difficulty;
	private String liftName;
	
	
	public Slope(String runName, String difficulty, String liftName) {
		super();
		this.runName = runName;
		this.difficulty = difficulty;
		this.liftName = liftName;
	}


	public String getRunName() {
		return runName;
	}


	public void setRunName(String runName) {
		this.runName = runName;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public String getLiftName() {
		return liftName;
	}


	public void setLiftName(String liftName) {
		this.liftName = liftName;
	}
	
	
	
}
