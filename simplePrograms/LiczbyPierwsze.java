import java.util.Scanner;
public class LiczbyPierwsze {
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Podaj ilość liczb pierwszych: ");
		int amount=input.nextInt();
		
		int liczbyPierwsze[]=new int [amount];
		int licznikPol=0;
	
		
		for(int i=1;licznikPol<amount;i++)
		{
		boolean veryfied=true;
			if(i!=1 && i%2==0)
				{
				veryfied=false;
				}
			if(i>=9)
			{
			
				for(int j=2;j<=9;j++)
				{
					if(i%j!=0)
						veryfied=true;
						
					else{
						veryfied=false;
						break;}
				}
				
				
			}
			if (i==2 ||i==1 || veryfied==true)
			{
				liczbyPierwsze[licznikPol]=i;
				licznikPol++;
			}
		}	
		for(int k=0;k<liczbyPierwsze.length;k++)
		{
	System.out.print(liczbyPierwsze[k]+ " ");
		}
	}	
}
/*import java.util.Scanner;
public class LiczbyPierwsze 
{
	public static void main(String[] args) 
	{
        Scanner wprowadzone = new Scanner(System.in);
        System.out.println("Ile liczb pierwszych wy�wietli�? ");
        int ilosc = wprowadzone.nextInt();
        int[] liczbyPierwsze = new int[ilosc];
        boolean ok = true;
        int znalezioneLiczby = 0;
        for (int i=2; znalezioneLiczby<ilosc; i++)
        {
        	for (int j=2; j<((i/2)+1); j++)
        	{
        		if(i%j==0)
        		{
        			ok = false;
        		}
        	}
        	if(ok)
        	{
        		liczbyPierwsze[znalezioneLiczby] = i; 
        		znalezioneLiczby++;
        	}
        	ok = true;
        }
        for (int liczbaPierwsza : liczbyPierwsze)
        {
        	System.out.print(liczbaPierwsza + " ");
        }
    }
}*/

