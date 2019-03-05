package edu.brandeis.cs12b.pa04;

import edu.brandeis.cs12b.pa04.provided.City;
import edu.brandeis.cs12b.pa04.provided.Point;
import edu.brandeis.cs12b.pa04.provided.VehicleError;

public class RightSnowPlow extends SnowPlow {

	protected String name = "RightSnowPlow";
	
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
			super.turnRight();
			if(city.isOffRoad(location.translate(facing))) {
				reportMoveError();
				return false;
			}
			return super.move();
		}
	}
	
	@Override
	public void reportMoveError() {
		System.out.println(VehicleError.RIGHTSNOWPLOW_MOVE_ERROR);
	}
	
	@Override
	public void reportPlaceError() {
		System.out.println(VehicleError.RIGHTSNOWPLOW_PLACEMENT_ERROR);
	}
	
	/**
	 * This has been implemented for you.
	 */
	@Override
	public String getName() {
		return this.name;
	}
}
