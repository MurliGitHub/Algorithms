package m2j.ds.hr.trie;

public class ContactList {

	TrieNodeContact trieNode = new TrieNodeContact();

	public void add(String contactName) {
		TrieNodeContact curr = trieNode;
		for (char ch : contactName.toCharArray()) {
			curr.setChildren(ch);
			curr = curr.getChildren(ch);
			curr.size++;
		}
	}

	public int find(String prefix) {
		TrieNodeContact curr = trieNode;
		for (char key : prefix.toCharArray()) {
			curr = curr.getChildren(key);
			if (curr == null) {
				return 0;
			}
		}
		return curr.size;
	}

}
