import java.util.Scanner;





public class SimpleCalculator {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String st=scan.nextLine();
		int a=0,b=0,result=0;
		String[] temp=null;
		char op=0;
		scan.close();
		if(st.contains("+")) {
			op='+';
			temp=st.split("\\+",2);
			try {
				a=Integer.parseInt(temp[0]);
				b=Integer.parseInt(temp[1]);
				if((a==0 || b == 0) && op=='+') {
					throw new AddZeroException("AddZeroException");
				}
			}
			catch(AddZeroException e) {
				System.out.println("AddZeroException");
				return;
			}
		}
		else if(st.contains("-")) {
			op='-';
			temp=st.split("-",2);
			try {
				a=Integer.parseInt(temp[0]);
				b=Integer.parseInt(temp[1]);
				if((a==0 || b == 0) && op=='-') {
					throw new SubtractZeroException("SubtractZeroException");
				}
			}
			catch(SubtractZeroException ex) {
				System.out.println("SubtractZeroException");
				return;
			}
		}
		else {
			System.out.println("error");
		}
		
		try {
			if(op=='+') result=a+b;
			else result=a-b;
			
			if(a>=1000||a<0||b>=1000||b<0||result<0||result>1000) {
				throw new OutOfRangeException("OutOfRangeException");
			}
		}
		catch(OutOfRangeException ex) {
			System.out.println("OutOfRangeException");
			return;
		}
		
		System.out.println(result);
		
		
	}

}

@SuppressWarnings("serial")
class OutOfRangeException extends Exception{
	OutOfRangeException (String message){
		super(message);
	}
}

@SuppressWarnings("serial")
class AddZeroException extends Exception{
	AddZeroException (String message){
		super(message);
	}
}

@SuppressWarnings("serial")
class SubtractZeroException extends Exception{
	SubtractZeroException (String message){
		super(message);
	}
}