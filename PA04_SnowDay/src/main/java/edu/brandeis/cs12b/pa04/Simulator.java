package edu.brandeis.cs12b.pa04;
import java.util.ArrayList;
import java.util.Iterator;
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
public class Simulator {

	protected ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	protected City city;

	/**
	 * Creates a new simulation for a city
	 * @param city to be simulated
	 */
	public Simulator(City city) {
		this.city = city;
	}

	/**
	 * You do not need to alter this constructor.
	 */
	protected Simulator() {}
	/**
	 * move each vehicle in the city the given number of steps on the
	 * city map in the appropriate String. If a vehicle makes an invalid move,
	 * ensure the correct error is printed and remove it from the state.
	 */
	public void step(int numberOfSteps) {
		for (int x = 0; x < numberOfSteps; x++) {
			Iterator<Vehicle> i = vehicles.iterator();
			while (i.hasNext()) {
				Vehicle l = i.next();
				if (!l.move()) {
					i.remove();
				}
			}
		}
	}

	/**
	 * Places a Vehicle in the city
	 * @param vehicle  to place in the city
	 * @param location to place the vehicle in the city
	 * @return true if vehicle is successfully placed, false if not
	 */
	public boolean placeVehicle(Vehicle vehicle, Point location, String facing) {
		if (vehicle.place(city, location, facing)) {
			vehicles.add(vehicle);
			return true;
		}
		return false;
	}

	/**
	 * Check to see if the Simulation's city is clear
	 * @return true if the city is clear, false if not
	 */
	public boolean isClear() {
		return this.city.isClear();
	}

	public String toString() {
		return this.city.toString();
	}
}
