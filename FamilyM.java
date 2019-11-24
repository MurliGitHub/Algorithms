

public class FamilyM implements Comparable<FamilyM>{
	private String memberName;
	private int age;
	private String em;
	
	
	
	public FamilyM(String memberName, int age, String em) {
		this.memberName = memberName;
		this.age = age;
		this.em = em;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEm() {
		return em;
	}
	public void setEm(String em) {
		this.em = em;
	}
	@Override
	public String toString() {
		return "FamilyM [memberName=" + memberName + ", age=" + age + ", em=" + em + "]";
	}
	@Override
	public int compareTo(FamilyM o) {
		if(this.getAge()>o.getAge()){
			return 1;
		}else if(this.getAge()<o.getAge()){
			return -1;
		}
		return 0;
	}
	
	
}
