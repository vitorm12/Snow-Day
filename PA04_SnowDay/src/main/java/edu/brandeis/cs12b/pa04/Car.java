package edu.brandeis.cs12b.pa04;

import edu.brandeis.cs12b.pa04.provided.City;
import edu.brandeis.cs12b.pa04.provided.Point;
import edu.brandeis.cs12b.pa04.provided.VehicleError;

/**
 * @author Name: Vitor Mouzinho Due FEB 24,2018 
 * PA04: SnowDay COSI 12B - Pito Salas 
 * DESCRIPTION: This program is a snow day simulator it digs
 *  everyone out of the snow in a wonderful simulated city
 */
public class Car extends Vehicle {

	protected String name = "Car";

	@Override
	public boolean place(City city, Point location, String facing) {
		if (!city.isSnowed(location)) {
			return super.place(city, location, facing);
		} else {
			reportPlaceError();
			return false;
		}
	}

	@Override
	public boolean move() {
		Point movePostion = location.translate(facing);
		if (!city.isSnowed(movePostion) && !city.isOffRoad(movePostion)) {
			this.location = location.translate(facing);
			return true;
		}
		reportMoveError();
		return false;
	}

	@Override
	public void reportMoveError() {
		System.out.print(VehicleError.CAR_MOVE_ERROR + newLine);
	}

	@Override
	public void reportPlaceError() {
		System.out.print(VehicleError.CAR_PLACEMENT_ERROR + newLine);
	}

	@Override
	public String getName() {
		return this.name;
	}

}
