package pack4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test44JikwonMain {
	ArrayList<Test44JikwonDto> list = new ArrayList<Test44JikwonDto>();
	public void inputData(String[] args) {
		for (int i = 0;  i < args.length; i++) {
			Test44JikwonDto jikwon = new Test44JikwonDto();
			StringTokenizer tokenizer = new StringTokenizer(args[i], ",");
			jikwon.setSabun(tokenizer.nextToken());
			jikwon.setIrum(tokenizer.nextToken());
			jikwon.setGibon(Integer.parseInt(tokenizer.nextToken()));
			jikwon.setIbsa(tokenizer.nextToken());
			list.add(jikwon);
		} 
	}
	public void printData() {
		// System.out.println(list.size());
		System.out.println("사번\t이름\t기본급\t근무년수\t근속수당\t공재액\t수령액");
		
		for(Test44JikwonDto jik:list) {
		// 근무년수
		LocalDate now = LocalDate.now(); // now는 static이기 때문에 바로 부를 수 있음
		int year = now.getYear();
		// System.out.println(year); // 2023
		int geunmu = year - Integer.parseInt(jik.getIbsa());
		
		// 근속수당
		int geunsok = 0;
		if(geunmu >=0 && geunmu <= 3) {
			geunsok = 150000;
		}else if(geunmu >=4 && geunmu <= 8) {
			geunsok = 450000;
		} else {
			geunsok = 1000000;
		}
		
		// 공제액
		int gongje = 0;
		if(jik.getGibon()+geunsok > 3000000)
			gongje = (int)((jik.getGibon()+geunsok)*0.005);
		else if(jik.getGibon()+geunsok > 2000000)
			gongje = (int)((jik.getGibon()+geunsok)*0.003);
		else 
			gongje = (int)((jik.getGibon()+geunsok)*0.0015);
		
		// 수령액
		int suryeong = (jik.getGibon()+geunsok)-gongje;
	
		System.out.println(jik.getSabun() + "\t" + jik.getIrum() + "\t" + jik.getGibon() + "\t" + geunmu + "\t" +geunsok + "\t" + gongje + "\t" + suryeong);
		
		
			}
		}
		
	public static void main(String[] args) { // run as -> run configuration -> argument에 자료 입력
		if(args.length == 0) {
			System.out.println("입력 자료가 없어요");
			System.exit(0);
		}
	
	
		
		Test44JikwonMain main = new Test44JikwonMain();
		main.inputData(args);
		main.printData();

	}

}
