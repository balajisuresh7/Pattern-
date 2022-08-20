package utils;

import java.util.Arrays;

public class stringsexamples {

	public static void main(String[] args) {
		
		//1.WAP to reverse a string
		String s1= new String("iNeuron");
		String s2= "";
		for (int i=s1.length()-1;i>=0;i--)
		{
			s2 = s2 + s1.charAt(i);
		}
		System.out.println("The reversed string is " + s2);
		
		//2.WAP to reverse a sentence while preserving the position.
		String s3= new String("Think Twice");
		String s5 = "";
		String [] s4 = s3.split(" ");
		for (int i=0;i<s4.length;i++)
		{
			for(int j=s4[i].length()-1;j>=0;j--)
			{
				s5 = s5 + s4[i].charAt(j);
			}
			s5 = s5 + " ";
		}
		System.out.println(s5);
		
		//3. java program to find if a string is anagram or not. 
		
				String str1 = "Keep";
				String str2 = "peek";
				
				  	str1 = str1.toLowerCase();
				    str2 = str2.toLowerCase();

				    if(str1.length() == str2.length()) {
				      char[] charArray1 = str1.toCharArray();
				      char[] charArray2 = str2.toCharArray();

				      Arrays.sort(charArray1);
				      Arrays.sort(charArray2);
				      boolean result = Arrays.equals(charArray1, charArray2);

				      if(result) {
				        System.out.println(str1 + " and " + str2 + " are anagram.");
				      }
				      else {
				        System.out.println(str1 + " and " + str2 + " are not anagram.");
				      }
				    }
				    else {
				      System.out.println(str1 + " and " + str2 + " are not anagram.");
				    }
		
		//4.WAP to check if the string is PANGRAM or not
		
		String s6 = "abcdefghijklmnopqrstuvwxyz";
		String s7 = new String("Pack my box with five dozen liquor jugs");
		s7 = s7.toLowerCase();
		char flag = 'n';
		char Alphabets[] = s6.toCharArray();
		for (int i =0;i<Alphabets.length;i++)
		{
			int count = 0;
			for(int j=0; j<=s7.length()-1;j++)
			{
				if (Alphabets[i] == s7.charAt(j))
					{
						count += 1;
					}
			}
			if (count == 0)
			{
				System.out.println("The string is not PANGRAM");
				flag = 'y';
				break;
			}
		}
		if (flag == 'n')
			System.out.println("The string is PANGRAM");
		
		
		//5.WAP to print repeatedly occurring characters in given string
		
		String s8 = "Apple is a fruit";
		s8 = s8.toLowerCase(); // considering the result does not care about case.
		char repeatstring[] = s8.toCharArray();
		int count = 0;
		for (int i =0;i< repeatstring.length;i++)
		{
			count =1;
			for(int j=i+1; j<=s8.length()-1;j++)
			{
				//count = 1;
				if (repeatstring[i] == repeatstring[j] && repeatstring[i] != ' ')
					{
						count ++;
						repeatstring[j] = '0';
					}
			}
			if (count > 1  && repeatstring[i] != '0') 
			{
				System.out.println("The repeated characters in string  is " + repeatstring[i]);
			}
			
		}
		
		//6. WAP to sort string alphabetically
		String str = "indiaismycountry";
		char []comp = str.toCharArray();
		char temp = ' ';
		String res = " ";
		for (int i =0;i<str.length();i++)
		{
			for (int j=i+1;j<str.length();j++)
			{
				if (comp[i] > comp[j])
				{
					temp = comp[i];
					comp[i] = comp[j];
					comp[j] = temp;
				}
			}
			
		}
		
		for(int i = 0;i<comp.length;i++)
		{
			res = res + comp[i] ;
		}
		System.out.println("The sorted string is : " + res);
		
		
		
		//7.WAP to count number of vowels and consonant values in a string
		
		String s10 = new String("Balai");
		s10 = s10.toLowerCase();
		String s11 = "aeiou";
		String s12 = "bcdfghjklmnpqrstvwxyz";
		int vowels = 0;
		int vowelsf = 0;
		int consonants = 0;
		for (int i = 0 ; i< s10.length();i++)
		{
			vowels = 0;
			for (int j=0 ; j< s11.length(); j++)
			{
				if (s10.charAt(i) == s11.charAt(j))
				{
					vowels += 1;
					vowelsf = vowelsf + vowels;
				}
			}
			if (vowels ==0) {
			for (int j= 0;j<s12.length(); j++)
			{
				if (s10.charAt(i) == s12.charAt(j))
				{
					consonants +=1 ;
				}
			}
			}
			
		}
		System.out.println("The total number of vowels are " + vowelsf);
		System.out.println("The total number of consonants are " + consonants);
		
		//8. WAP to count number of special characters 
		
		String s13 = "%$#bala";
		int special =0;
		for (int i = 0; i< s13.length(); i++)
		{
			//System.out.println((int)s13.charAt(i));
			if (((int)s13.charAt(i) > 32 && (int)s13.charAt(i) < 47) || ((int)s13.charAt(i) > 58 && (int)s13.charAt(i) < 64) || ((int)s13.charAt(i) > 91 && (int)s13.charAt(i) < 96) || ((int)s13.charAt(i) > 123 && (int)s13.charAt(i) < 126) )  
			{
				
				special += 1;
			}
		}
		System.out.println("The total number of special characters are " + special);
		
		
		
	}

}
