package pack3;

// 내부 클래스 : 클래스의 멤버로 클래스를 가질 수 있다.
// 특정 클래스 안에서만 사용할 클래스를 선언하고 이를 내부 클래스(inner class)라고 한다.

public class Test35Outer {
	private int a;
	
	public Test35Outer() {
		a = 10;
	}
	
	public void aa() {
		System.out.println("Outer의 멤버 aa 메소드");
		bb();
	}
	
	private void bb() {
		System.out.println("Outer 소속 bb 메소드");
	}
	
	
	
	
	
	public static void main(String[] args) {
		Test35Outer outer = new Test35Outer();
		outer.aa();

	}

}
