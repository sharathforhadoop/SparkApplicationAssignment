import java.util.LinkedList;
import java.util.Scanner;

public class Operations {
	public static void main(String[] args) throws Exception {

		Operations op = new Operations();
		Scanner keyboard =  new Scanner(System.in);
		System.out.println("Enter Arthimetic operation with +,-,*");
		String input = keyboard.nextLine();		
		System.out.println("Enter operator Precedence");
		String OperatorPrecedence = keyboard.nextLine();
		keyboard.close();
		String num = "";
		LinkedList<String> parsedInput = new LinkedList<String>();
		LinkedList<String> operators = new LinkedList<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");

		int temp=0;
		for(int m=0;m<input.length();m++)
		{
			if(operators.contains(Character.toString(input.charAt(m))))
			{	
				parsedInput.add(temp,Character.toString(input.charAt(m)));
				temp++;
				num="";
			}

			else
			{
				int l=m;
				num="";
				while(!operators.contains(Character.toString(input.charAt(l))))
				{
					num=num+Character.toString(input.charAt(m));		
					if(l+1>=input.length())
					{
						break;
					}
					if(!operators.contains(Character.toString(input.charAt(l+1))))
					{
						m++;
					}
					l++;
				}
				parsedInput.add(temp,num);
				temp++;	
			}			
		}

		LinkedList<String> Result = op.CalculateResult(parsedInput, OperatorPrecedence);	
		System.out.println("Calculated output : "+Result.toString());


	}

	public LinkedList<String> findLeftRight(String operator,LinkedList<String> input)
	{
		CalculatorOperationImplementation operation = new CalculatorOperationImplementation();
		int i=0;
		double result = 0;
		while(i<input.size())
		{
			if(operator.equals(input.get(i)))
			{
				switch(operator)
				{
				case "*": result=operation.multiplication(Double.parseDouble(input.get(i-1)), Double.parseDouble(input.get(i+1)));
				break;
				case "+": result=operation.add(Double.parseDouble(input.get(i-1)), Double.parseDouble(input.get(i+1)));
				break;
				case "-": result=operation.substraction(Double.parseDouble(input.get(i-1)), Double.parseDouble(input.get(i+1)));
				break;	
				default : break;
				}
				input.remove(i);
				input.add(i,Double.toString(result));
				input.remove(i-1);
				input.remove(i);
				break;
			}
			i++;	
		}
		return input;
	}


	public LinkedList<String> CalculateResult(LinkedList<String> parsedInput,String OperatorPrecedence)
	{
		Operations op = new Operations();
		LinkedList<String> x = new LinkedList<String>();
		int i=0;
		while(i<OperatorPrecedence.length())
		{
			while((op.findLeftRight(Character.toString(OperatorPrecedence.charAt(i)), parsedInput)).contains(Character.toString(OperatorPrecedence.charAt(i))))
			{
				x=op.findLeftRight(Character.toString(OperatorPrecedence.charAt(i)), parsedInput);
			}
			i++;
		}
		return parsedInput;
	}
}
