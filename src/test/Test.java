package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("src/test/input.txt");
		String directions = "NESW";

		Scanner in = new Scanner(f);
		int xLimit = in.nextInt();
		int yLimit = in.nextInt();
		while (in.hasNext()) {
			int x = in.nextInt();
			int y = in.nextInt();
			char direction = in.next().charAt(0);
			String commands = in.next();

			if (direction == 'N')
				y++;

			for (int i = 0; i < commands.length(); i++) {

				char command = commands.charAt(i);
				if (command == 'G' || command == 'D')
					direction = turn(directions, direction, command);

				else {
					// go forward
					if (direction == 'N' && x > 1)
						x--;
					if (direction == 'E' && y < yLimit)
						y++;
					if (direction == 'S' && x < xLimit)
						x++;
					if (direction == 'W' && y > 1)
						y--;
				}
			}
			System.out.println(x + " " + y + " " + direction);
		}
	}

	private static char turn(String directions, char direction, char command) {
		if (command == 'D')
			direction = directions.charAt((directions.indexOf(direction + "") + 1) % directions.length());
		else
			direction = directions
					.charAt((directions.indexOf(direction + "") - 1 + directions.length()) % directions.length());
		return direction;
	}
}
