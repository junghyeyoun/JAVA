package pack4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test45File_io {

	public static void main(String[] args) {
	// public static void main(String[] args) throws Exception // 예외처리
		// \표준 장치 또는 file 단위의 단위의 입출력
		// 자바에서는 Strea을 파일 단위의 자료 입출력을 효과적으로 진행할 수 있도록 도와준다.
		/* System.out.println("시스템을 이용한 표준 입출력 ------");
		// InputStreamReader 개체를 이용한 표준 입력장치를 사용하는 방법이 있으나 최근에는 Scanner 사용
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름은");
		String ir = scanner.nextLine();
		System.out.println("나이는");
		int nai = scanner.nextInt();
		System.out.println("몸무게는");
		double mugae = scanner.nextDouble();
		System.err.println(ir+ "님의 나이는 " + nai + "그럼 뭄무게는 "+mugae);
		*/
		
		System.out.println("파일 단위의 읽기 ------"); 
		try {
			File f = new File("c:/work/iotest.txt"); 
			FileReader fr = new FileReader(f);	// 파일을 읽기 위해 내부적으로 장치를 open 함
			BufferedReader br1 = new BufferedReader(fr);
			// System.out.println(br1.readLine()); // 한줄만 출력
			while(true) { // 파일의 끝을 만날 때까지 계속 읽기
				String str = br1.readLine();
				if(str == null) break;
				System.out.println(str);
			}
			br1.close(); // 작업이 끝난 후 장치를 닫음
			fr.close();
			
		} catch (Exception e) {
			System.out.println("파일 처리 오류 : "+e.getMessage());
		}
		
		System.out.println("-------------");
		System.out.println("data.go.kr 사이트의 csv 파일 다운로드 후 파일 단위의 읽기 ------");
		try {
			File f = new File("c:/work/전국도서관.csv");
			FileReader fileReader = new FileReader(f);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int count = 0;
			String ss = bufferedReader.readLine();
			// System.out.println(ss);
			while(true) {
				count++;
				ss = bufferedReader.readLine(); // 제목은 빼기
				if(ss == null || count >= 20) break;
				StringTokenizer tok = new StringTokenizer(ss, ",");
				String s1 = tok.nextToken(); 
				String s2 = tok.nextToken();
				String s3 = tok.nextToken(); // 3행만 읽기
				System.out.println(s1 + "\t" + s2 + "\t" + s3);
			}
			bufferedReader.close();
			fileReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
				
		

	}

}
