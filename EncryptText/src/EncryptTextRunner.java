import java.util.Scanner;

public class EncryptTextRunner {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in) ;
		System.out.print("Enter the text you want to encrypt: ") ;
		String name=s.next() ;
		s.close();
		
		name=name.toUpperCase() ;
		
		String result=EncryptTextFunctions.encrypt(name) ;
		
		System.out.println(result) ;

	}

}
