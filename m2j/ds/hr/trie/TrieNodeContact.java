package m2j.ds.hr.trie;

import java.util.LinkedHashMap;
import java.util.Map;

public class TrieNodeContact {

	public Map<Character, TrieNodeContact> children = new LinkedHashMap<Character, TrieNodeContact>();
	public int size = 0;

	public TrieNodeContact getChildren(char key) {
		return children.get(key);
	}

	public void setChildren(char key) {
		children.putIfAbsent(key, new TrieNodeContact());
	}

}
