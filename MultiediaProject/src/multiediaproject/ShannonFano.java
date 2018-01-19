/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author nhan-kute
 */
class ShannonFano {
    private static final int ASCII_LENGTH = 7;

	private String originalString;
	private int originalStringLength;
	private HashMap<Character, String> compressedResult;
	private HashMap<Character, Double> characterFrequency;
	private boolean probabilityIsGiven;
        private byte[] Result;

	public ShannonFano(String str) {
		originalString = str;
		originalStringLength = str.length();
		characterFrequency = new HashMap<Character, Double>();
		compressedResult = new HashMap<Character, String>();
		probabilityIsGiven = false;

		this.calculateFrequency();
		this.compressString();
	}
        
        public HashMap<Character, String> getMapResult(){
            return this.compressedResult;
        }
        
        public String getCodeResult(){
            String result = "";
            for (Character c : originalString.toCharArray()) {
                result += this.compressedResult.get(c);
            }
            return result;
        }

	private void compressString() {
		List<Character> charList = new ArrayList<Character>();

		Iterator<Entry<Character, Double>> entries = characterFrequency.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<Character, Double> entry = entries.next();
			charList.add(entry.getKey());
		}

		appendBit(compressedResult, charList, true);
	}

	private void appendBit(HashMap<Character, String> result, List<Character> charList, boolean up) {
		String bit = "";
		if (!result.isEmpty()) {
			bit = (up) ? "0" : "1";
		}

		for (Character c : charList) {
			String s = (result.get(c) == null) ? "" : result.get(c);
			result.put(c, s + bit);
		}

		if (charList.size() >= 2) {
			int separator = (int) Math.floor((float) charList.size() / 2.0);

			List<Character> upList = charList.subList(0, separator);
			appendBit(result, upList, true);
			List<Character> downList = charList.subList(separator, charList.size());
			appendBit(result, downList, false);
		}
	}

	private void calculateFrequency() {
		for (Character c : originalString.toCharArray()) {
			if (characterFrequency.containsKey(c)) {
				characterFrequency.put(c, new Double(characterFrequency.get(c) + 1.0));
			} else {
				characterFrequency.put(c, 1.0);
			}
		}
	}
        
        @Override
	public String toString() {
            String str = "S";
            int count = 0;
            for (Character c : compressedResult.keySet()) {
                str += c;
                str += "-" + compressedResult.get(c) + "\n";
            }
            System.out.print(str);
            String result = "";
            for (Character c : originalString.toCharArray()) {
                result += this.compressedResult.get(c);
            }
            while (result.length() % 8 != 0){
                count++;
                result = "0" + result;
            }
            System.out.println(String.valueOf(count) + result);
            result = convertBinaryStringToString(result);
            str += String.valueOf(count) + result;
            return str;
        }

        public static String convertBinaryStringToString(String string){
            StringBuilder sb = new StringBuilder();
            char[] chars = string.replaceAll("\\s", "").toCharArray();
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
}
