package pack4;

// public class Test49thread {
// public class Test48thread implements Runnable { // 인터페이스도 사용가능
public class Test49thread extends Thread {
	public Test49thread () {
		
	}
	public Test49thread (String name) {
			super(name);
		}

	public void run() {
		for (int i = 1; i <= 50; i++) {
			System.out.print(getName() + ":" + i + " ");
			// Runnable 한 경우 에는 Thread.currentThread().getName 한다.
			try {
				Thread.sleep(500);	// 0.5초 간 스레드 비활성화		
			} catch (Exception e) {
				
			}
		}
	} // run이 끝나면 사용자 정의 스레드 종료

	public static void main(String[] args) throws Exception{ // 하나의 process가 하나의 thread(main thread)를 사용
		// Thread (추상)를 상속받아 처리
		/*
		Test49thread te1 = new Test49thread();
		Test49thread te2 = new Test49thread();
		te1.run(); // 순차적
		te2.run(); // 얘는 te1.run()이 끝나야 실행이 됨
		*/
		
		Test49thread te1 = new Test49thread("one");
		Test49thread te2 = new Test49thread("two");
		te1.start(); // start가 run을 호출 -> 사용자 정의 thread 활성화
		te2.start();
		
		te1.setPriority(MAX_PRIORITY); // te1의 우선순위를 먼저 요청  0 ~ 10 // 먼저 실행시킬 확률이 높아지는 것이지 무조건 먼저 실행되는 것이 아님
		
		te1.join(); // te1 작업이 끝날 때까지 main thread의 종료를 대기 
		te2.join(); // 따라서 응용프로그램 종료가 뒤에 나옴
		
		System.out.println("응용 프로그램 종료");
		
	}

}
