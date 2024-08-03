package m2j.ds.hr.trie;

public class App {
	public static void main(String[] args) {
//		add hack
//		add hackerrank
//		find hac
//		find hak

		ContactList contactList = new ContactList();
		contactList.add("hack");
		contactList.add("hackrrank");

		int find = contactList.find("hac");
		System.out.println(find);
		int find2 = contactList.find("hak");
		System.out.println(find2);
	}

}
