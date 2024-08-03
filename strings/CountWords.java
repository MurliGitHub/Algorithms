package m2j.ds.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountWords {
	private static void countWordsBy8(String para) {
		Optional<String> paraOptional = Optional.ofNullable(para);
		
		if(!paraOptional.isPresent()) {
			throw new IllegalArgumentException("Provide atleast a string");
		}
		
		String[] words = para.split(",");
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0)+1));
		
		System.out.println(map);
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		//
		
		var freq = Arrays.stream(words)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		System.out.println(freq);
	}
	public static void main(String[] args) {
		String s = "House, House, House, Dog, Dog, Dog, Dog";
		s = s.replaceAll("\\s", "");
		countWordsBy8(s);
	}

}
