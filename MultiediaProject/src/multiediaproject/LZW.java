package multiediaproject;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Vector;
import static multiediaproject.Huffman.convertBinaryStringToString;

public class LZW {
	private String ResultString;
	private String originalString;
	private Vector<Integer> out;
	private int originalStringLength;
	private HashMap<String , Integer> Result;
	private HashMap<Character, Integer  > Count_Char;
	private HashMap<String , Integer>     Count1_Char;
	/*private HashMap<String , Integer>     Count1_Char;*/
	
	public LZW(String str) {
		originalString 		= str;
		originalStringLength    = str.length();
		Count_Char		= new HashMap<Character, Integer  >();
		Count1_Char		= new HashMap<String , Integer>();
		Result			= new HashMap<String , Integer>();
		out			= new Vector<Integer>();
		this.DictToString();
	}
	
	public void Count(){
		int o = 1;
		for (Character c : originalString.toCharArray()) {
			String c1 = Character.toString(c);
			if (!Count_Char.containsKey(c)){
				Count_Char.put(c, o);	
				Result.put(c1, o);
				o += 1;			
			}
		}	
	}
	
	public void Encode(){
		this.Count();
		int newCode = Count_Char.size() + 1;
		String S = Character.toString((originalString.charAt(0)));
		int i = 0;	
		while(i < originalStringLength - 1){
			String C = Character.toString((originalString.charAt(i + 1)));
			String tt = S + C;
			if(Result.containsKey(tt)){
				S += C;
				i += 1;
			}
			else{
				this.out.add(Result.get(S));
				Result.put(tt, newCode);
				newCode += 1;
				S = Character.toString((originalString.charAt(i + 1)));
				i += 1;
			}
		}
		this.out.add(Result.get(S));
	}
	
	public void DictToString(){
		this.Encode();
		String result = "";
		Iterator<Integer> itr = out.iterator();
		while(itr.hasNext()){
			result += " " + Integer.toString(itr.next());
		}
		
		result = result.substring(1,result.length());
		this.ResultString = result;
	}
        
        @Override
	public String toString(){
            String str = "L";
            for(String c : Result.keySet()){
                str += c;
                str += "-";
                str += String.valueOf(Result.get(c));
                str += "\n";
            }
            System.out.println(str + this.ResultString);
            str += this.ResultString;
            return str;
	}


	public String getCodeDecoded(){
		HashMap<Integer, String> buffer = new HashMap<Integer, String>();
		String str = "";
                for(String c : this.Result.keySet()){
            		buffer.put(this.Result.get(c) , c);
        	}
                
		for(String Split : ResultString.split(" ")){
                    str += buffer.get(Integer.parseInt(Split));
		}		
		return str;	
	}

}
