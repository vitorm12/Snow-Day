package edu.brandeis.cs12b.pa04;

import edu.brandeis.cs12b.pa04.provided.City;
import edu.brandeis.cs12b.pa04.provided.Point;
/**
 * @author Name: Vitor Mouzinho 
 * Due FEB 24,2018 
 * PA04: SnowDay COSI 12B - Pito Salas 
 * DESCRIPTION: 
 * This program is a snow day simulator
 * it digs everyone out of the snow in a wonderful simulated city
 */
public abstract class Vehicle {

	protected Point location;
	protected City city;
	protected String facing;
	protected static final String newLine = System.getProperty("line.separator");
	
	/**
	 * This places your vehicle into a city. If invalid, ensure that 
	 * somewhere in your code the proper VehicleError is printed.
	 * 
	 * @param city the city to be placed into
	 * @param location the location in the city to be placed
	 * @param facing this direction
	 * @return true if this happens successfully, false if not
	 */
	public boolean place(City city, Point location, String facing){
		if(location == null||location.x < 0 || location.y < 0 || location.x > city.maxX || location.y > city.maxY) {
			return false;
		}
		if(city == null||facing == null||city.isOffRoad(location)){
			return false;
		}
		this.city = city;
		this.location = location;
		this.facing = facing;
		return true;
	}

	/**
	 * This method should move your vehicle one cell in the direction it was facing.
	 * If your vehicle can't move because there's a wall in the way, it should stay in
	 * same place and call the reportError(), then return false so it can be taken
	 * off the list of active vehicles
	 * @return true if the move was successfully made, false if not
	 */
	public boolean move(){
		Point newP = location.translate(facing);
		if(newP.x < 0 || newP.y < 0 || newP.x > city.maxX || newP.y > city.maxY) {
			return false;
		}
		if(!city.isOffRoad(location)) {
			this.location = newP;
			return true;
		}
		reportMoveError();
		return false;
	}

	/**
	 * This method reports if a vehicle can't move. This should be different for each vehicle.
	 * Use the static fields in the VehicleError class to get the text to print.
	 */
	public abstract void reportMoveError();
	
	/**
	 * Likewise for placing a vehicle.
	 */
	public abstract void reportPlaceError();
	
	/**
	 * This method turns the vehicle in question to the right. Not all vehicles
	 * have this capability, however. So make sure only certain of your vehicles
	 * can turn right.
	 */
	protected void turnRight() {
		switch(facing){
			case "SOUTH": facing = "WEST"; break;
			case "NORTH": facing = "EAST"; break;
			case "WEST": facing = "NORTH"; break;
			case "EAST": facing = "SOUTH"; break;
		}
	}
	
	/**
	 * This method turns the vehicle in question to the left. Not all vehicles
	 * have this capability, however. So make sure only certain of your vehicles
	 * can turn left.
	 */
	protected void turnLeft(){
		switch(facing){
			case "SOUTH": facing = "EAST"; break;
			case "NORTH": facing = "WEST"; break;
			case "WEST": facing = "SOUTH"; break;
			case "EAST": facing = "NORTH"; break;
		}
	}

	/**
	 * Methods for getting the name of the vehicle and converting to a string have been implemented
	 * for you. However, you should study how this mechanism works to get a sense of how you might
	 * implement inheritance among the various vehicles.
	 */
	public abstract String getName();

	public String toString(){
		return this.getName() + " " + this.location.toString();
	}
}
