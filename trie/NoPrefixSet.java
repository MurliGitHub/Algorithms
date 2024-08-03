package m2j.ds.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoPrefixSet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Trie root = new Trie();
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			if (!root.noPrefixInsert(line)) {
				System.out.println("BAD SET");
				System.out.println(line);
				sc.close();
				return;
			}
		}
		System.out.println("GOOD SET");
	}
}

class Trie {
	Map<Character, Trie> children = new HashMap<Character, Trie>();
	boolean isCompleted = false;

	public boolean noPrefixInsert(String word) {
		return add(word, 0);
	}

	private boolean add(String word, int i) {
		if (isCompleted)
			return false;
		if (i == word.length()) {
			isCompleted = true;
			return true;
		}

		char ch = word.charAt(i);
		Trie curr = children.get(ch);
		if (curr == null) {
			curr = new Trie();
			children.put(ch, curr);
		} else if (i + 1 == word.length()) {
			return false;
		}

		return curr.add(word, i + 1);
	}
}
