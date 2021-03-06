package game;

import boundaryToMatador.GUI;

public class Player {
	private String name;
	private int status;
	private int position;
	private int account;
	private int assets;
	private int fleets;
	private int breweries;
	private int rollSum;
	
	public Player(String name, int account) {
		this.name = name;
		this.account = account;
		this.assets = account;
		this.position = 1;
		this.fleets = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getStatus() {
		return this.status;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void setPosition(int position) {
		this.position = position; 
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void alterAccount(int amount) {
		if ((this.account + amount) >= 0) {

			this.account += amount;
		}

		else {
			this.account = 0;
			setStatus(-1);
			
			// TODO - Fix GUI knowledge
			GUI.removeAllCars(this.name);
			GUI.showMessage(this.name + ", you went bankrupt - all your properties has been sold to the bank.");
		}
		
		// TODO - Fix GUI knowledge
		GUI.setBalance(this.name, account);
	}
	
	public int getAccount() {
		return this.account;
	}
	
	public void setAssets(int amount) {
		alterAccount(-amount);
		assets += amount;
	}
	
	public int getAssets() {
		return assets;
	}

	public int payRent(int rent, Player leaser) {
		int amount;
		
		if (rent > this.account) {
			amount = this.account;
			setStatus(-1);
		}
		else {
			amount = rent;
			alterAccount(-amount);
		}
		
		leaser.alterAccount(amount);
		
		return this.status;
	}

	public void setFleet() {
		this.fleets += 1;
	}
	
	public int getFleet() {
		return this.fleets;
	}
	
	public void setBrewery() {
		this.breweries += 1;
	}
	
	public int getBreweries() {
		return this.breweries;
	}

	public int getRollSum() {
		return this.rollSum;
	}
	
	public void setRollSum(int rollSum) {
		this.rollSum = rollSum;
	}
}
