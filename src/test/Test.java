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


			for (int i = 0; i < commands.length(); i++) {

				char command = commands.charAt(i);
				if (command == 'G' || command == 'D')
					direction = turn(directions, direction, command);

				else {
					// go forward
					if (direction == 'N' && y < yLimit)
						y++;
					if (direction == 'E' && x <xLimit)
						x++;
					if (direction == 'S' && y >0)
						y--;
					if (direction == 'W' && x >0)
						x--;
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
