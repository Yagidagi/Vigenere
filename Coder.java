import java.util.*;

public class Coder
{
	public static void main(String args[])
	{
		String str = "DVYCNZVJIHNVMNBDFTRRSNNXPIRMFMZZOYUFXGBEHKEVDDFVMTURWDAXMDGKMZBIOJZFOZLZOHLGVMFVBIQEPOUZOBCRSOVTVGNIUJVEUZEVTOZVPIFYPMRZUCBLHCGZXJHCENNZMVOFVONCJOGCFVAUTZRKIZJRUZEPQVEKPAGYFRBIMYVKJNNNBTVYBQRFGYEZWDAXPASKIZFGMZREBIQIFBHCBOVEHOUVDDETVGNKJJANIZAVWZEZGDAUNTFVMATIPRVEHBEZNVOFVOGYFHBLUCJYFIRMFMVKJNNUBHCUSDMQMTAFWZZSFMVENTFFVGJYFIRMFMVWJIQDZNRCGDAMPGHEUVEZMTCRVNVEHWRWPMRTPASZORNIFCBLTZFROYOIJITZOBHGUCRIFVEFGZIVSTSLOZERMDZVFONEEZFGFXVRMGLNIZAVWZEDZCLGPNTVUNHTIVALQKRIIVAUPAZVUCNKJOEVRPVIFNNJUMBEHHBIBGCIJIPZQGRKPKEVWZAKNZSIPHQVMDOVSVGVMTFKFKCZOBVEUJGYFNGIFZGROYZVUCBUJXNCMTXEPXXZOBCVPKYVTCNKTJSWUCREJVPTPPAKJOUZHCGZNZGFHZGKPNRRBNFFPINJJXNEUCVJJNZPTPOJUDGLUZSFSKVJUJYROYORMGJZUCNGIDYFTJCYJXNCGGBLSDFYDVGFUCEFXNUZNNRCGPCFOCVJTRBIEDDLJZGCZONBFOBKIZFYJKGYFMRZTIBKIDAXTPEGSDFZOBVEUCVJJAGYFTOLUFAVXDGRMHBJUVYCNZAZOOUVJMQVHMRVTJZVUDZVPMBKIZETIZEZTCIVSTAVBMYPUCRJBHRWFZYZOBFKPRNIENGYFJPVBIJZUCZVUCRIFIBNJNLFVMVETPYRSXVKZJSKIZZROCNKUJRJCZYKFYEFVIQSZRURSQRJBNVEEDNEJNYVTWLTPMNCSZRWTXBDNZETFNHISJHEENVKXDGYIZEJVMSIJBUKBIQCFAGKIZFKSZRKTONBFTBLXVGVSRNIEDGJFSGIFHRUPRAKPRAZTOUVCVGKFMLNIZEVUCNKOJOCFHBCFDFNBNUVEWLNBQRJBIQTPJYVEWLSSZRQFNJYJXURGZJYPPEJQMRMJJHJXZEVPPGFGNVXIOBWMVAUMJBBBOGYFXEFXYFFGRNKFMTRAZEJUCRIF";

		str.toLowerCase();

		ArrayList arr = findRepeats(str);

		System.out.println(findGCD(arr));

		String b = encode("abcdefg", "ab");

		System.out.println(b);
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
}



















