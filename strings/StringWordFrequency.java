package m2j.ds.string;

import java.util.HashMap;
import java.util.Map;

public class StringWordFrequency {
	public static void main(String[] args) {
		frequency("google");
	}

	private static void frequency(String word) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : word.toCharArray()) {
			if(map.get(c)==null) {
				map.put(c, 1);
			}else {
				map.put(c, map.get(c)+1);
			}
		}
		
		System.out.println(map);
		StringBuilder sb = new StringBuilder();
		
		 map.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).
		forEach(record -> {
            Character key = record.getKey();
            int value = record.getValue();
//Append the character by the number of times it occurrs.
                  sb.append(key).append(" :").append(value).append("\n");
});
		System.out.println(sb.toString());
		
	}

}
