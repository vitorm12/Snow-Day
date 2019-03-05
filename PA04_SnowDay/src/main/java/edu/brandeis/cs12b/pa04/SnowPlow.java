package edu.brandeis.cs12b.pa04;

import edu.brandeis.cs12b.pa04.provided.City;
import edu.brandeis.cs12b.pa04.provided.Point;
import edu.brandeis.cs12b.pa04.provided.VehicleError;
/**
 * @author Name: Vitor Mouzinho 
 * Due FEB 24,2018 
 * PA04: SnowDay COSI 12B - Pito Salas 
 * DESCRIPTION: 
 * This program is a snow day simulator
 * it digs everyone out of the snow in a wonderful simulated city
 */
public class SnowPlow extends Vehicle {
	
	protected String name = "SnowPlow";
	protected String wayToTurn = "";

	@Override
	public boolean place(City city, Point location, String facing) {
		if(location.x < 0 || location.y < 0 || location.x > city.maxX || location.y > city.maxY) {
			return false;
		}
		if(city == null||location == null||facing == null) {
			return false;
		}
		city.clearSnow(location);
		return super.place(city, location, facing);
	}
	
	@Override
	public boolean move() {
		city.clearSnow(location);
		boolean x = super.move();
		city.clearSnow(location);
		return x;
	}

	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.SNOWPLOW_MOVE_ERROR);
	}

	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.SNOWPLOW_PLACEMENT_ERROR);	
	}

	/**
	 * This has been implemented for you.
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
