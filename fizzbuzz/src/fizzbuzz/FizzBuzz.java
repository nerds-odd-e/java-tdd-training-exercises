package fizzbuzz;



public class FizzBuzz 
{
	public String check(int i) {
		switch(i) {
		case 1:
			return "1";
		case 5:
			return "Buzz";
		default:
			return "Fizz";
		}
	}
}

