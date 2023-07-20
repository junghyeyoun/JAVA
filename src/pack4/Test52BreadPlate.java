package pack4;

public class Test52BreadPlate {
	private int breadCount = 0; // 스레드 간 공유 대상
		
		public Test52BreadPlate() {
			// TODO Auto-generated constructor stub
		}
		
		public synchronized void makeBread() {
			if(breadCount >= 10) {
				System.out.println("빵 생산 초과");
				 try {
					 wait(); // 스레드의 비활성화
				} catch (Exception e) {
				
				}
			}
			breadCount++; // 빵 생산
			notify(); // 스레드를 활성화 / wait(), notify()는 한쌍
			System.out.println("빵 생산 후 개수 : "+breadCount+"개");
		}
		
		public synchronized void eatBread() {
			if(breadCount < 1) {
				System.out.println("빵 없음 대기중...");
				 try {
					 wait(); // 스레드의 비활성화
				} catch (Exception e) {
				
				}
			}
			breadCount--; // 빵 소비
			this.notify();
			System.out.println("빵 소비 후 개수 : "+breadCount+"개");
		}
}
