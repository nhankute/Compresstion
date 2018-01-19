package multiediaproject;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Huffman {
        private String ResultString;
	private String originalString;
	private int originalStringLength;
	private HashMap<Character, String   > Result;
	private HashMap<Character, Integer  > Count_Char;
	private HashMap<String , Integer>     Count1_Char;
	/*private HashMap<Integer  , Character> Invert_Count_Char;*/
	
	public Huffman(String str) {
		originalString 		= str;
		originalStringLength    = str.length();
		Result     		= new HashMap<Character, String  >(); 
		Count_Char 		= new HashMap<Character, Integer >();
		Count1_Char		= new HashMap<String , Integer>();
		this.DictToString();
		/*Invert_Count_Char	= new HashMap<Integer  ,Character>();	*/
	}
	
	public void Count(){
		for (Character c : originalString.toCharArray()) {
			String c1 = Character.toString(c);
			if (Count_Char.containsKey(c)){
				Count_Char.put(c, new Integer(Count_Char.get(c) + 1));
				Count1_Char.put(c1, new Integer(Count1_Char.get(c1) + 1));
				/*Invert_Count_Char.put(Count_Char.get(c) + 1, c);*/
			}
			else{
				Count_Char.put(c, 1);
				Count1_Char.put(c1, 1);
				/*Invert_Count_Char.put(1, c);*/
			}
		}	
	}	
	public void Encode(){
		this.Count();
		while (Count1_Char.size() > 1){
			int value1 = 0;
			String key1 = Character.toString('c');
			for(String c : Count1_Char.keySet()){
            			key1   = c;
				value1 = Count1_Char.get(key1);
				break;
        		}
			/*find first min*/
			for(String c : Count1_Char.keySet()){
            			if(Count1_Char.get(c) < Count1_Char.get(key1)){
					key1  =  c;
					value1=  Count1_Char.get(key1);
				}
        		}
			Count1_Char.remove(key1);
		/*#############################################################*/
			int value2 = 0;
			String key2 = Character.toString('c');
			for(String c : Count1_Char.keySet()){
            			key2  = c;
				value2= Count1_Char.get(key2);
				break;
        		}
			/*find first min*/
			for(String c : Count1_Char.keySet()){
            			if(Count1_Char.get(c) < Count1_Char.get(key2)){
					key2 = c;
					value2= Count1_Char.get(key2);
				}
        		}
			Count1_Char.remove(key2);
		/*#################################################################*/
			Count1_Char.put(key1 + key2, value1 + value2);
			if(key1.length() == 1){
				Result.put( key1.charAt(0),  Character.toString('0') );
			}
			else{
				String re = "";
				for(Character c : key1.toCharArray()){
					re = "0" + Result.get(c);
					Result.put(c,re);
				} 
			}

			if(key2.length() == 1){
				Result.put( key2.charAt(0),  Character.toString('1') );
			}
			else{
				String ree = "";
				for(Character c : key2.toCharArray()){
					ree = "1" + Result.get(c);
					Result.put(c,ree);
				}
			}
		}
	}
	
	public void DictToString(){
		Encode();
		String str = "";
		for (Character c : originalString.toCharArray()) {
			str += this.Result.get(c);
		}
		ResultString = str;
	}

        @Override
	public String toString(){
            String str = "H";
            int count = 0;
            while (this.ResultString.length() % 8 != 0){
                count++;
                this.ResultString = "0" + this.ResultString;
            }
            if(count == 0){
                count = 8;
            }
            str += String.valueOf(count) + convertBinaryStringToString(this.ResultString);
            for(Character c : Result.keySet()){
                str += " ";
                str += c;
                str += "-";
                str += Result.get(c);
            }
            System.out.println(str);
            return str;
	}
        
        public static String convertBinaryStringToString(String string){
            StringBuilder sb = new StringBuilder();
            char[] chars = string.toCharArray();
            int [] mapping = {1,2,4,8,16,32,64,128};

            for (int j = 0; j < chars.length; j+=8) {
                int idx = 0;
                int sum = 0;
                for (int i = 7; i>= 0; i--) {
                    if (chars[i+j] == '1') {
                        sum += mapping[idx];
                    }
                    idx++;
                }
                sb.append(Character.toChars(sum));
            }
            //System.out.println(sb.toString() + "*****************************************");
            return sb.toString();
        }
        
        
        /*
        public String getCodeDecoded(String encode){
            String BinaryCode = encode.split(" ",2)[0];
            String TableCode = encode.split(" ",2)[1];
            if(TableCode.charAt(1)!='-'){
                BinaryCode += " " +TableCode.split(" ",2)[0];
                TableCode = TableCode.split(" ",2)[1];
            }
            String temp = "";
            int count = Integer.parseInt(BinaryCode.substring(0,1));
            if(count == 8)
                count = 0;
            BinaryCode = BinaryCode.substring(1);
            boolean Turn = true;
            HashMap<String , Character> buffer = new HashMap<String , Character>();
            
            for(int i = TableCode.length() - 1; i > 0; i--){
                    if(TableCode.charAt(i) != ' '){
                        if(TableCode.charAt(i) == '-')
                            Turn = false;
                        else{
                            if(Turn == true)
                                temp += TableCode.charAt(i);
                            else{
                                temp = new StringBuffer(temp).reverse().toString();
                                buffer.put(temp, TableCode.charAt(i));
                            }
                        }
                    }else{
                        if(TableCode.charAt(i-1) == ' '){
                                temp = new StringBuffer(temp).reverse().toString();
                                buffer.put(temp, TableCode.charAt(i));
                        }
                        else{
                            Turn = true;
                            //c[count] = temp;
                            temp = "";
                        }
                    }
                }
                temp = new StringBuffer(temp).reverse().toString();
                buffer.put(temp, TableCode.charAt(0));
            
            String Binary = convertStringToBinaryString(BinaryCode);
            
            Binary = Binary.substring(count);
		String str = "";
		String c1 = "";
		for(Character c : Binary.toCharArray()){
			c1 = c1 + Character.toString(c) ;
			if(buffer.containsKey(c1)){
				str += buffer.get(c1);
				c1 = "";	
			}		
		}
		return str;
	}*/
}
