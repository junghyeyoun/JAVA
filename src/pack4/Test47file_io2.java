package pack4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Test47file_io2 {

	// file i/o 연습
	// 2 byte 단위로 데이터 입출력 : 문자 처리에 효과적
	public void writeFile(File file, ArrayList<String> strList) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file)); // 버퍼는 완충장치
			
			for(String s:strList) {
				writer.write(s, 0, s.length());
				writer.newLine(); // line skip
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("writeFile err : "+e.getMessage());
		}
	}
	
	public void readFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String oneLine;
			
			
			
			String ss = null;
			StringBuffer sbuffer = new StringBuffer(); // 문자열 더하기를 대신해 주는 클래스
			while((oneLine = reader.readLine()) !=null) {
				// ss = ss + oneLine; // 자바는 문자열 더하기를 연속적으로 하는 것을 비권장
				sbuffer.append(oneLine+"\n"); 
			}
			reader.close();
			System.out.println(sbuffer.toString()); // StringBuffer의 내용 출력
			
		} catch (Exception e) {
			System.out.println("readFile err : "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("자바 만세");
		list.add("nice");
		list.add("good");
		File file = new File("c:/work/iotest3.txt");
		
		Test47file_io2 tf = new Test47file_io2();
		tf.writeFile(file, list); // list에 기억된 데이터를 파일로 저장하기
		tf.readFile(file); // 보조 기억장치에 저장된 파일을 주기억장치로 읽기
				
		
	}

}
