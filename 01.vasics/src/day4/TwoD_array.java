package day4;

public class TwoD_array {
	public static void main(String[] args) {
		String[] names = { "Jeon", "Yuri","Cherry"};
		int[][] marks = {
				{100,78, 90, 84, 69},
				{87, 45 ,56, 49, 79},
				{97, 68, 89, 90, 100}
		};
		
		int row = marks.length;
		int col = marks[0].length;
		for(var r= 0; r < row; r++) {
			var total = 0;
			for(var c =0;c < col;c++) {
				total = total + marks[r][c];
			}
			System.out.println("Total marks obtained by student" + names[r]);
			System.out.println("Average mark: " + (float)total/5);
		}
	}
}
