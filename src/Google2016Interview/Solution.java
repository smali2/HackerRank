//Bismillah Hirrahman Nirrahim
// With The Name of Allah, The Most Gracious, The Most Merciful
// Praise be to Allah, and peace and blessings be upon Rasulullah, his Family, his Companions, and his Followers. Ameen.

package Google2016Interview;

import java.util.*;




//( + ( + 1 ( + 1 1 ) ) 2 )


interface Command {

	public void exec(Stack<String> stack);
	
}

class AddCommand implements Command {

	public void exec(Stack<String> stack) {
		int a = Integer.parseInt(stack.pop());
		int b = Integer.parseInt(stack.pop());
		stack.pop(); // pop the "(" opening bracket
		stack.push(Integer.toString(a+b));
	}
}

class SubtractCommand implements Command {

	public void exec(Stack<String> stack) {
		int a = Integer.parseInt(stack.pop());
		int b = Integer.parseInt(stack.pop());
		stack.pop(); // pop the "(" opening bracket
		stack.push(Integer.toString(a-b));
	}
}


class MultiplyCommand implements Command {

	public void exec(Stack<String> stack) {
		int a = Integer.parseInt(stack.pop());
		int b = Integer.parseInt(stack.pop());
		stack.pop(); // pop the "(" opening bracket
		stack.push(Integer.toString(a*b));
	}
}


public class Solution {

	public static int calculator(String s) {
		String[] command = s.split(" ");
		
		ArrayList<String> operations = new ArrayList<>();
		operations.add("+");
		operations.add("-");
		operations.add("*");
		
		HashMap<String, Command> executors = new HashMap<>();
		executors.put("+", new AddCommand());
		executors.put("-", new SubtractCommand());
		executors.put("*", new MultiplyCommand());
		
		Stack<String> numbersAndBrackets = new Stack<>();
		Stack<String> operands = new Stack<>();
		
		for (int i = 0; i<command.length; i++) {
			if (command[i].equals(")")) {
				//System.out.println("Test: "+command[i]);
				executors.get(operands.pop()).exec(numbersAndBrackets);		
				continue;
			}
			
			if (operations.contains(command[i])) {
				operands.push(command[i]);
				continue;
			} else {
				numbersAndBrackets.push(command[i]);
			}	
		}
		
		//System.out.println(numbersAndBrackets.pop());
		//System.out.println(numbersAndBrackets.pop());
		//return -1;
		return Integer.parseInt(numbersAndBrackets.pop());
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ans = calculator(in.nextLine());
		System.out.println(ans);
	
	}

}
