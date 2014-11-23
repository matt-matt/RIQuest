import java.util.*;
public class IslandCounter {

	static int lines;
	static int[][] grid;
	
	static int islands = 0;
	static int totalsize = 0;
	static int avgsize;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		lines = scan.nextInt();
		grid = new int[lines][lines];
		for(int i = 0; i < lines; i++)	{
			double line = scan.nextInt();
			for (int j = lines - 1; j >= 0; j--)	{
				grid[i][j] = (int)line % 2;
				line = line / 10;
			}
		}
		
		for (int i = 0; i < lines; i++)	{
			for (int j = 0; j < lines; j++)	{
				if (grid[i][j] == 1)	{
					islands++;
					totalsize += explore(i, j, 0);
				}
			}
		}
		
		avgsize = totalsize / islands;
		System.out.println(avgsize);
		
		scan.close();

	}


	static int explore(int y, int x, int size) {
		if (grid[y][x] == 1)	{
			grid[y][x] = 0;
			size++;
			if (y > 0)	{
				size = explore(y - 1, x, size);
			}
			if (x < lines - 1)	{
				size = explore(y, x + 1, size);
			}
			if (y < lines - 1)	{
				size = explore(y + 1, x, size);
			}
			if (x > 0)	{
				size = explore(y, x - 1, size);
			}
		}
			return size;
	}
}
