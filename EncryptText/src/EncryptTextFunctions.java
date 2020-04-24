
public class EncryptTextFunctions {
	
	private static String[][] mappingTable=new String[26][2] ;
	
	private static boolean isPrime(int n)
	{
		for(int i=2;i<=Math.sqrt(n);i++)
		{
			if(n%i==0)
			{
				return false ;
			}
		}
		
		return true ;
	}
	
	private static String returnHexValue(int n)
	{
		String result="" ;
		
		while(n!=0)
		{
			int hexRemainder=n%16 ;
			n=n/16 ;
			
			if(hexRemainder<10)
			{
				result=hexRemainder+result ;
			}
			
			else if(hexRemainder==10)
			{
				result='A'+result ;
			}
			
			else if(hexRemainder==11)
			{
				result='B'+result ;
			}
			
			else if(hexRemainder==12)
			{
				result='C'+result ;
			}
			
			else if(hexRemainder==13)
			{
				result='D'+result ;
			}
			
			else if(hexRemainder==14)
			{
				result='E'+result ;
			}
			
			else
			{
				result='F'+result ;
			}
		}
		
		return result ;
	}
	
	private static void fillTable()
	{
		int currentAlphabetNumber=0 ;
		int currentNumber=1 ;
		
		while(currentAlphabetNumber<26)
		{
			if(isPrime(currentNumber))
			{
				mappingTable[currentAlphabetNumber][1]=returnHexValue(currentNumber) ;
				currentAlphabetNumber++ ;
			}
			
			currentNumber++ ;
		}
		
		for(int i=0;i<26;i++)
		{
			mappingTable[i][0]+=(char)(65+i) ;
		}
		
		return ;
	}
	
	public static String encrypt(String name)
	{
		fillTable() ;
		
		if(name.length()==0)
		{
			return "" ;
		}
		
		String result="" ;
		
		result+=mappingTable[name.charAt(0)-65][1] ;
		
		for(int i=1;i<name.length();i++)
		{
			result=result + ", " + mappingTable[name.charAt(i)-65][1] ;
		}
		
		return result ;
	}
}
