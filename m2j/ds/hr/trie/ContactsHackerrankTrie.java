package m2j.ds.hr.trie;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import m2j.utility.CommonUtil;

/**
 * @author M2j
 * @see https://www.hackerrank.com/challenges/contacts/problem
 * 
 *
 */
public class ContactsHackerrankTrie {

	public static void main(String[] args) {
//		add hack
//		add hackerrank
//		find hac
//		find hak
		String[][] queries = { { "add", "hack" }, { "add", "hackerrank" }, { "find", "hac" }, { "find", "hak" } };
		int[] contacts = contacts(queries);
		CommonUtil.print(contacts);
	}

	/*
	 * Complete the contacts function below.
	 */
	static int[] contacts(String[][] queries) {
		
		class TrieNodeContact {

			public Map<Character, TrieNodeContact> children = new LinkedHashMap<Character, TrieNodeContact>();
			public int size = 0;

			public TrieNodeContact getChildren(char key) {
				return children.get(key);
			}

			public void setChildren(char key) {
				children.putIfAbsent(key, new TrieNodeContact());
			}

		}
		
		class ContactList {

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

		ContactList contactList = new ContactList();
		List<Integer> list = new LinkedList<Integer>();

		for (String[] strings : queries) {

			String string = strings[0];
			String string2 = strings[1];

			if ("add".equals(string)) {
				contactList.add(string2);
			} else if ("find".equals(string)) {
				int find = contactList.find(string2);
				list.add(find);
			}
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

}
