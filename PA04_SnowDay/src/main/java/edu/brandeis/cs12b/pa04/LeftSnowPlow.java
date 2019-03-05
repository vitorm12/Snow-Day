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
public class LeftSnowPlow extends SnowPlow {

	protected String name = "LeftSnowPlow";
	@Override
	public boolean place(City city, Point location, String facing) {
		boolean check = super.place(city, location, facing);
		if(check) {
			return true;
		}else {
			reportPlaceError();
			return false;
		}
	}
	
	@Override
	public boolean move() {
		if(!city.isOffRoad(location.translate(facing))){
			return super.move();
		}else {
			super.turnLeft();
			if(city.isOffRoad(location.translate(facing))){
				reportMoveError();
				return false;
			}
			return super.move();
		}
	}
	
	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.LEFTSNOWPLOW_MOVE_ERROR);
	}
	
	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.LEFTSNOWPLOW_PLACEMENT_ERROR);
	}
	
	/**
	 * This has been implemented for you.
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
