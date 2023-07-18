package pack4;

public class Test42StudentDto {
	// 데이터 전달용 클래스 : Dto - 레코드 단위의 기억장소로 사용
	private String hakbun, irum;
	private int jumsu;
	
	public Test42StudentDto() {
		
	}
	
	public Test42StudentDto(String hakbun, String irum, int jumsu) {
		this.hakbun = hakbun;
		this.irum = irum;
		this.jumsu = jumsu;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
	
}
