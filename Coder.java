import java.util.*;

public class Coder
{
	public static void main(String args[])
	{
		String str = "DVYCNZVJIHNVMNBDFTRRSNNXPIRMFMZZOYUFXGBEHKEVDDFVMTURWDAXMDGKMZBIOJZFOZLZOHLGVMFVBIQEPOUZOBCRSOVTVGNIUJVEUZEVTOZVPIFYPMRZUCBLHCGZXJHCENNZMVOFVONCJOGCFVAUTZRKIZJRUZEPQVEKPAGYFRBIMYVKJNNNBTVYBQRFGYEZWDAXPASKIZFGMZREBIQIFBHCBOVEHOUVDDETVGNKJJANIZAVWZEZGDAUNTFVMATIPRVEHBEZNVOFVOGYFHBLUCJYFIRMFMVKJNNUBHCUSDMQMTAFWZZSFMVENTFFVGJYFIRMFMVWJIQDZNRCGDAMPGHEUVEZMTCRVNVEHWRWPMRTPASZORNIFCBLTZFROYOIJITZOBHGUCRIFVEFGZIVSTSLOZERMDZVFONEEZFGFXVRMGLNIZAVWZEDZCLGPNTVUNHTIVALQKRIIVAUPAZVUCNKJOEVRPVIFNNJUMBEHHBIBGCIJIPZQGRKPKEVWZAKNZSIPHQVMDOVSVGVMTFKFKCZOBVEUJGYFNGIFZGROYZVUCBUJXNCMTXEPXXZOBCVPKYVTCNKTJSWUCREJVPTPPAKJOUZHCGZNZGFHZGKPNRRBNFFPINJJXNEUCVJJNZPTPOJUDGLUZSFSKVJUJYROYORMGJZUCNGIDYFTJCYJXNCGGBLSDFYDVGFUCEFXNUZNNRCGPCFOCVJTRBIEDDLJZGCZONBFOBKIZFYJKGYFMRZTIBKIDAXTPEGSDFZOBVEUCVJJAGYFTOLUFAVXDGRMHBJUVYCNZAZOOUVJMQVHMRVTJZVUDZVPMBKIZETIZEZTCIVSTAVBMYPUCRJBHRWFZYZOBFKPRNIENGYFJPVBIJZUCZVUCRIFIBNJNLFVMVETPYRSXVKZJSKIZZROCNKUJRJCZYKFYEFVIQSZRURSQRJBNVEEDNEJNYVTWLTPMNCSZRWTXBDNZETFNHISJHEENVKXDGYIZEJVMSIJBUKBIQCFAGKIZFKSZRKTONBFTBLXVGVSRNIEDGJFSGIFHRUPRAKPRAZTOUVCVGKFMLNIZEVUCNKOJOCFHBCFDFNBNUVEWLNBQRJBIQTPJYVEWLSSZRQFNJYJXURGZJYPPEJQMRMJJHJXZEVPPGFGNVXIOBWMVAUMJBBBOGYFXEFXYFFGRNKFMTRAZEJUCRIF";

		str = setup(str);

		System.out.println(findKeyLength(str));

		String b = encode("abcdefg", "ab");

		System.out.println(b);
	}

	static 	int[] map = {4,19,0,14,8,13,18,7,17,3,11,2,20,12,22,5,6,24,15,1,21,10,9,23,16,25};

	public static String setup (String str)
	{
		String result = "";
		String temp = str.toLowerCase();

		for(int i=0; i< temp.length(); i++)
		{
			if((int)temp.charAt(i)-97<26 && (int) temp.charAt(i)-97>=0)
			{
				result+= temp.substring(i,i+1);
			}
		}
		return result;
	}


	public static int findMax(int[][] a, int start)
	{
		int i =start;
		
		for (int j=start; j<a.length;j++)
		{
			if (a[i][1]<a[j][1])
			i=j;
		}
		return i;
	}

	public static int[][] analyze(String test)
	{
		int temp = 0;
		int[][] list = new int[26][2];
		int length= test.length();

		test=test.toLowerCase();

		for (int x=0; x<26; x++)
		{
			list[x][0]=x;
		}

		for (int x=length-1; x>=0;x--)
		{
			temp = (int) test.charAt(x) - 97;
			if (0<= temp && temp<26)
				list[temp][1]++;
		}

		for(int x=0;x<26;x++)
		{
			int a = findMax(list,x);

			int[] t = list[x];
			list[x] = list[a];
			list[a]	= t;		 
		}

		return list;
   	 }

	public static int divergence (int[][] arr)
	{
		int result = 0;
		for(int i=0; i<26;i++)
		{
			result = result + Math.abs((arr[i][0]- map[i]));
		}

		return result;
	}

	public static void shift (int[][] arr)
	{
		for (int i=0;i<26;i++)
		{
			arr[i][0]= (arr[i][0]+1)%26;
		}
	}

	public static int[] allDivergence (int[][] arr)
	{
		int[] result = new int[26];

		for(int i=0;i<26;i++)
		{
			result[i] = divergence(arr);

			shift(arr);
		}
	
		return result;
	}

	public static int findMin (int[] arr)
	{
		int index=0;
		for(int i=0;i<arr.length;i++)
		{
			if (arr[i]<arr[index])
			{
				index = i;
			}
		}
		return index;
	}

	public static String findKeyLetter(String str)
	{
		char x = (char) (findMin(allDivergence(analyze(str)))+97);
		return String.valueOf(x);
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

	public static String processLine(String a, String b)
	{
		String result = "";

		for (int i=0; i<a.length() && i<b.length(); i++)
		{
			result += processLetter(a.substring(i,i+1), b.substring(i,i+1));
		}

		return result;
	}

	public static String generateKey(String target, String key)
	{
		int reps = target.length()/key.length();
		String result="";

		for(int x=0;x<=reps;x++)
		{
			result+=key;
		}
		return result;
	}

	public static String encode(String target, String key)
	{
		String temp = generateKey(target, key);

		return processLine(target, temp);
	}

	public static ArrayList findRepeats(String str)
	{
		ArrayList result = new ArrayList();
		boolean tracker;
		for (int i=0; i<str.length()-3; i++)
		{
			tracker=true;
			String temp = str.substring(i,i+4);
			for (int j=i+3; j<str.length()-3;j++)
			{
				String comp = str.substring(j,j+4);
				if (temp.equals(comp) && tracker)
				{
					result.add(j-i);
					tracker = false;
				}
			}
		}
		return result;
	}

	public static int findGCD (int a, int b)
	{
		int temp;
		if (a < b)
		{
			temp = b;
			b = a;
			a = temp;
		}
		while (b!=0)
		{
			a = a % b;

			temp = b;
			b = a;
			a = temp;
		}
		
		return a;
	}

	public static int findGCD (ArrayList arr)
	{
		int result = (int) arr.get(0);

		for (int i=0;i<arr.size();i++)
		{
			result = findGCD(result, (int) arr.get(i));
		}

		return result;
	}

	public static int findKeyLength(String str)
	{
		return findGCD(findRepeats(str));
	}
}



















