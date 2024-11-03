package JavaTest;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
	public String[] colours;
	public String[] shapes;

	public static class Art {
		public String colour;
		public String shape;

		public Art(String colour, String shape) {
			this.colour = colour;
			this.shape = shape;
		}
	}

//	public Drawing(String[] strings, String[] strings2) {
//		// TODO Auto-generated constructor stub
//	}

	public void IceCreamMachine(String[] colours, String[] shapes) { 
		this.colours = colours; this.shapes = shapes; 
		}

	public List<Art> mix() {
		ArrayList<Art> combiList = new ArrayList<Art>();
		for (String colour : this.colours) {
			for (String shape : this.shapes) {
				Art myArt = new Art(colour, shape);
				combiList.add(myArt);
			}
		}
		return combiList;
	}

	public static void main(String[] args) {
		Drawing draw = new Drawing();
		draw.IceCreamMachine(new String[] { "red", "blue" }, new String[] { "circle" });
		List<Art> mixes = draw.mix();
		/* * Should print: * red, circle * blue, circle */ for (Art art : mixes) {
			System.out.println(art.colour + ", " + art.shape);
		}
	}
}