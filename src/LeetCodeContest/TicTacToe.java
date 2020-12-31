// Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

// This contest was held on March 3 2018 at 9.30pm EST
// Question: 793

package LeetCodeContest;

public class TicTacToe {

	public char[][] convertToArray(String[] board) {
		int i = 0;
		char[][] out = new char[3][3];
		
		for (String s: board) {
			out[i][0] = s.charAt(0);
			out[i][1] = s.charAt(1);
			out[i][2] = s.charAt(2);
			i++;
		}
		
		return out;
	}
	
	public int countType(char[][] input, char comp) {
		int count = 0;
		for (int i = 0; i<input.length; i++) {
			for (int j = 0; j<input[0].length; j++) {
				if (comp==input[i][j])
					count++;
			}
		}
		return count;
	}
	
	public int countWins(char[][] input) {
		boolean flag = true;
		int count = 0;
		for (int i = 0; i<input.length; i++) {
			char c = input[i][0];
			if (c==' ') {
				flag = false;
				continue;
			} else {
				for (int j = 1; j<input[0].length; j++) {
					if (c!=input[i][j]) {
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
			}
			if (flag) count++;
			if (count==2) break; // we only need to know that there are at least two win lines
		}
		
		// count diagonals
		while (count<2) {
			if (input[0][0]!=' ') {
				if (input[0][0]==input[1][1] && input[0][0]==input[2][2]) {
					count++;
				} 
			} 
			if (input[0][2]!=' ') {
				if (input[0][2]==input[1][1] && input[0][2]==input[2][0]) {
					count++;
				} 
			}
			break;
		}
		
		return count;
	}
	
	public boolean validTicTacToe(String[] board) {
	        
    	char[][] arr = convertToArray(board);
    	
    	int numberOfX = countType(arr, 'X');
    	int numberOfO = countType(arr, 'O');
    	//int numberOfBlanks = countType(arr, ' ');
    	int winLines = countWins(arr);
    	
    	
    	// false cases::
    	// case 0: winlines > 1
	    // case 1: either X or O and O is more than X
    	
    	// true cases::
    	// case 0: winlines = 1
    	// case 1: either X or O and X >= O
	    
    	if (numberOfO > numberOfX) {
    		return false;
    	} else if ((numberOfO + 1 == numberOfX) && (winLines==1)) { 
    		// if it's O winning, then false, but if it's X winning then it's true
    		return false;
    	} else if ((numberOfO <= numberOfX) && (winLines>1)) {
    		return false;
    	} else if ((numberOfO == numberOfX) && (winLines>0)) {
    		return false;
    	} else if (numberOfX > numberOfO + 1) {
    		return false;
    	} else if (winLines>1) {
    		return false;
    	} else {
    		return true;
    	}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"O  ", "   ", "   "};
		String[] b = {"XOX", " X ", "   "};
		String[] c = {"XXX", "   ", "OOO"};
		String[] d = {"XOX", "O O", "XOX"};
		String[] e = {"   ", "   ", "   "};
		String[] f = {"XXX","XOO","OO "};
		String[] g = {"OXX","XOX","OXO"};
		
		TicTacToe s = new TicTacToe();
		System.out.println("A: "+s.validTicTacToe(a)); // false
		System.out.println("B: "+s.validTicTacToe(b)); // false
		System.out.println("C: "+s.validTicTacToe(c)); // false
		System.out.println("D: "+s.validTicTacToe(d)); // true
		System.out.println("E: "+s.validTicTacToe(e)); // true
		System.out.println("F: "+s.validTicTacToe(f)); // false
		System.out.println("G: "+s.validTicTacToe(g)); // false
	}

}
