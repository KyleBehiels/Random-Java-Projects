// T00052042

package Lab_One_Tyler;

//Parent abstract class. Parent class: Automobile
public abstract class Automobile {

	protected String color;
	protected int doors;

	// Constructor assigns values for color and doors

	public Automobile(String colorValue, int doorsValue) {
		// TODO Auto-generated constructor stub
		color = colorValue;
		doors = doorsValue;
	}

	// GetColor String method. Returns color
	protected String getColor() {
		return color;
	}

	// setColor void method.
	protected void setColor(String colorValue) {
		color = colorValue;
	}

	// getDoors int method. Returns doors
	protected int getDoors() {
		return doors;
	}

	// setDoors void method.
	protected void setDoors(int doorsValue) {
		doors = doorsValue;
	}

	// toString method to return doors and color
	public String toString() {
		return "Doors = " + doors + ", Color = " + color;
	}
}
