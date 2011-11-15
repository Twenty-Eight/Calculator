package main;

/*
 * What to handle:
 * - priority (clamps and point before line calculating)
 *  
 */

public class Term {
	private int first;
	private int second;
	private char operator;
	private boolean newTerm = false;
	private Term t;
	
	public Term( int i ) {
		first = i;
	}
	
	public int eval() {
		switch (operator) {
		case '+':
			first+= second;
			second = 0;
			break;
		case '-':
			first-= second;
			second = 0;
			break;
		case '*':
			first*= second;
			second = 0;
			break;
		case '/':
			first/= second;
			second = 0;
			break;
		}
		return first;
	}
	
	public void add(char o) {
		switch (o) {
		case '+':
			eval();
			operator = o;
			break;
		case '-':
			eval();
			operator = o;
			break;
		case '*':
			//Punktrechnung beachten
			if (operator == '+' || operator == '-') {
				//Neuer Term mit second (First vom neuen Term)
				
				t = new Term(second);
				t.add(o);
				newTerm = true;
			} else {
				operator = '*';
			}
			break;
			
		case '/':
			//Punktrechnung beachten
			if (operator == '+' || operator == '-') {
				//Neuer Term mit second (First vom neuen Term)
				
				t = new Term(second);
				t.add(o);
				newTerm = true;
			} else {
				operator = '/';
			}
			break;
			
		default: eval();
		break;
		}
	}

	public void add(int i) {
		if( newTerm == false) {
			second = i;
		} else {
			t.add(i);
			second = t.eval();
			newTerm = false;
		}
	}
	
	public int getnum() {
		return first;
	}
}
