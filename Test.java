import java.util.*;

public class Test
{
	public static void main(String args[])
	{
		String str = "123456789";

		str = sub(str, 4, 0);

		System.out.println(str);
	}

	public static String sub(String str, int key, int shift)
	{
		String result= "";
		char temp;

		for(int i=shift; i<str.length(); i+= key)
		{
			temp = str.charAt(i);
			result += String.valueOf(temp);
		}

		return result;
	}
}













