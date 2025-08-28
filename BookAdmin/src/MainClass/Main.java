package MainClass;

import java.util.*;

import Class.Book;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	
	// * 로그인 기능 (ADD01)
	public static void DoLogin() {
		// - 사용자에게 ID, PW값 요청
		System.out.println("아이디와 비밀번호를 순차적으로 입력해주십시오.");
		System.out.print("아이디: ");
		String id = sc.next();
		System.out.print("비밀번호: ");
		String pw = sc.next();
		System.out.println();
		
		// - 관리자 계정 정보와 일치한지 확인 (로그인 성공 여부 확인)
		if(id.equals("admin") == true && pw.equals("0000") == true) {	// 로그인 성공
			System.out.println("*** 환영합니다, admin님!!! ***");
			PrintIntro();
		}
		else {	
			System.out.println("로그인 정보가 올바르지 않습니다. 다시 시도해주시길 바랍니다.");
			DoLogin();		// 로그인 기능 재실행
		}
	}
	
	// * 인트로 기능 (ADD02)
	public static void PrintIntro() {
		// - 사용자에게 선택지 제시 & 수행할 기능 번호 입력받기
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 조회");
		System.out.println("3. 도서 삭제");
		System.out.println("4. 도서 수정");
		System.out.print("수행할 기능 번호를 입력해주시오. ");
		int menu = sc.nextInt();
		System.out.println();
		
		// - 입력받은 기능 수행
		switch(menu) {
		case 1:
			System.out.println("*** <1. 도서 등록>을 수행합니다! ***");
			MainFunc.AddBook();
			break;
		case 2:
			System.out.println("*** <2. 도서 조회>를 수행합니다! ***");
			MainFunc.ReadBook();
			break;
		case 3:
			System.out.println("*** <3. 도서 삭제>를 수행합니다! ***");
			MainFunc.DeleteBook();
			break;
		case 4:
			System.out.println("*** <4. 도서 수정>을 수행합니다! ***");
			MainFunc.EditBook();
			break;
		default:
			System.out.println("올바르지 않은 입력입니다. 다시 수행해주세요.");
			PrintIntro();		// 인트로 기능 재실행
		}
	}
	
	public static void main(String args[]) {
		// - 로그인 시도부터 진행
		DoLogin();
	}
}









