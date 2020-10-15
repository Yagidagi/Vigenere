import java.util.*;

public class Coder
{
	public static void main(String args[])
	{
		String str = "abcdjfdjabc";

		str.toLowerCase();

		ArrayList arr = findRepeats(str);
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
	}

	public static int stringToInt (String str)
	{
		return (int) (str.charAt(0)) - 97;
	}

	public static String intToString (int num)
	{
		return String.valueOf((char) (97+(num%26)));
	}

	public static String processLetter(String a, String b)
	{
		return intToString(stringToInt(a)+stringToInt(b));
	}

	public static ArrayList findRepeats(String str)
	{
		ArrayList result = new ArrayList();
		for (int i=0; i<str.length()-3; i++)
		{
			String temp = str.substring(i,i+4);
			for (int j=i+3; j<str.length()-3;j++)
			{
				String comp = str.substring(j,j+4);
				if (temp.equals(comp))
				{
					result.add(j-i);
				}
			}
		}
		return result;
	}
}