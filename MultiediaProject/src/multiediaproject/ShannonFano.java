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
	private double entropy;
	private double averageLengthBefore;
	private double averageLengthAfter;
	private boolean probabilityIsGiven;
        private byte[] Result;

	public ShannonFano(String str) {
		super();
		originalString = str;
		originalStringLength = str.length();
		characterFrequency = new HashMap<Character, Double>();
		compressedResult = new HashMap<Character, String>();
		entropy = 0.0;
		averageLengthBefore = 0.0;
		averageLengthAfter = 0.0;
		probabilityIsGiven = false;

		this.calculateFrequency();
		this.compressString();
		//this.calculateEntropy();
		//this.calculateAverageLengthBeforeCompression();
		//this.calculateAverageLengthAfterCompression();
                
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

	private void calculateEntropy() {
		double probability = 0.0;
		for (Character c : originalString.toCharArray()) {
			probability = 1.0 * characterFrequency.get(c) / originalStringLength;
			entropy += probability * (Math.log(1.0 / probability) / Math.log(2));
		}
	}

	private void calculateAverageLengthBeforeCompression() {
		double probability = 0.0;
		for (Character c : originalString.toCharArray()) {
			probability = 1.0 * characterFrequency.get(c) / originalStringLength;
			averageLengthBefore += probability * ASCII_LENGTH;
		}
	}

	private void calculateAverageLengthAfterCompression() {
		double probability = 0.0;
		for (Character c : originalString.toCharArray()) {
			probability = 1.0 * characterFrequency.get(c) / originalStringLength;
			averageLengthAfter += probability * compressedResult.get(c).length();
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<Character, Double> getCharacterFrequency() {
		return (HashMap<Character, Double>) characterFrequency.clone();
	}

	@SuppressWarnings("unchecked")
	public HashMap<Character, String> getCompressedResult() {
		return (HashMap<Character, String>) compressedResult.clone();
	}

	@Override
	public String toString() {
            String str = "";
            
            for (Character c : compressedResult.keySet()) {
                if (c == '\n')
                    str += "\\n";
                else str += c;
                str += "-" + compressedResult.get(c) + "\n";
            }
            System.out.print(str);
            String result = "";
            for (Character c : originalString.toCharArray()) {
                result += this.compressedResult.get(c);
            }
            System.out.println(result);
            while (result.length() % 8 != 0){
                result = "0" + result;
            }
            result = convertBinaryStringToString(result);
            str += result;
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
