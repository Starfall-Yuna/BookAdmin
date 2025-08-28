package MainClass;

import java.util.HashMap;
import java.util.Scanner;

import Class.Book;

public class MainFunc {
	public static Scanner sc = new Scanner(System.in);
	public static HashMap<String, Book> data = new HashMap<>();
	
	// * 도서 정보 등록 (REQ01)
	public static void AddBook() {
		// - 도서 정보 등록에 필요한 값 입력
		System.out.println("도서 등록에 필요한 정보를 순차적으로 입력해주세요.");
		System.out.print("책 번호(ISBN): ");
		String input_i = sc.next();
		System.out.print("책 이름: ");
		String input_n = sc.next();
		System.out.print("저자: ");
		String input_a = sc.next();
		System.out.print("페이지 수: ");
		int input_p = sc.nextInt();
		System.out.print("출판사명: ");
		String input_pub = sc.next();
		
		// - 입력값을 기반으로, 해시맵(data)에 추가할 도서 정보(bk) 구성
		Book bk = new Book(input_i, input_n, input_a, input_p, input_pub);
		
		// - data[input_i] 공간에 bk값 삽입
		data.put(input_i, bk);
		System.out.println("*** 도서 등록이 완료되었습니다!!! ***");
		System.out.println();
		
		// - 인트로로 이동
		Main.PrintIntro();
	}

	// * 도서 정보 조회 (REQ02) -> 특정 도서 정보 조회
	public static void ReadBook() {
		// - 도서 정보 조회에 활용할 책번호(search) 입력
		System.out.print("검색할 도서의 ISBN값을 입력하시오. ");
		String search = sc.next();
		System.out.println();
		
		// - search값을 기반으로, 해시맵(data) 값 조회 -> result에 저장
		Book result = data.get(search);
		
		// - result==null이면, 검색 결과 없음을 의미
		if(result == null) {
			System.out.println("*** 검색에 실패하였습니다. 다시 시도해주세요. ***");
			
		}
		// - result!=null이면, 검색 결과가 있음을 의미
		// 		조회한 정보의 멤버값을 순차 출력
		else {			
			System.out.println("*** 아래는 검색 결과입니다. ***");
			System.out.println("책 번호(ISBN): " + result.isbn);
			System.out.println("책 이름: " + result.name);
			System.out.println("저자: " + result.author);
			System.out.println("페이지 수: " + result.page + "쪽");
			System.out.println("출판사명: " + result.pub);
		}
		System.out.println();
		
		// - 인트로로 이동
		Main.PrintIntro();
	}
	
	// * 도서 정보 삭제 (REQ03)
	public static void DeleteBook() {
		// - 도서 정보 삭제에 활용할 책번호(search) 입력
		System.out.print("삭제할 도서의 ISBN값을 입력하시오. ");
		String search = sc.next();
		
		// - search값을 기반으로, 해시맵(data)에 존재하는지 확인 (null값이면 검색 결과 없음을 의미)
		Book result = data.get(search);
		if(result == null) {
			System.out.println();
			System.out.println("*** 삭제할 도서가 없습니다. 다시 시도해주시길 바랍니다. ***");
			DeleteBook();	// 도서 삭제 재실행
		}
		
		// - 여기까지 왔다면, 해시맵(data)에 데이터가 존재함을 의미
		// 		remove()로 삭제 진행 및 안내 메시지 출력
		data.remove(search);
		
		System.out.println();
		System.out.println("*** 도서 삭제를 수행하였습니다. ***");
		
		// - 인트로로 이동
		Main.PrintIntro();
	}
	
	// * 도서 정보 수정 (REQ04)
	public static void EditBook() {
		// - 도서 정보 수정에 활용할 책번호(search) 입력
		System.out.print("수정할 도서의 ISBN값을 입력하시오. ");
		String search = sc.next();
		
		// - search값을 기반으로, 해시맵(data)의 데이터 불러오기 -> result에 저장
		Book result = data.get(search);
		// - result == null이면, 검색 결과 없음을 의미
		if(result == null) {
			System.out.println();
			System.out.println("*** 검색 결과가 없습니다. 다시 시도해주십시오. ***");
			EditBook();		// 수정 기능 재실행
		}
		
		// - 여기까지 왔다면, 해시맵(data)에 데이터가 존재함을 의미
		// - 수정할 멤버 이름(category) 입력받기 (책이름, 저자, 페이지수, 출판사명 중 하나)
		System.out.print("수정할 카테고리를 입력하시오. ");
		String category = sc.next();
		
		// - category의 멤버에 대해 수정할 값(edit) 입력받기
		System.out.print("해당 카테고리를 수정할 값을 입력하시오. ");
		String edit = sc.next();
		
		// - 2)에서 불러온 데이터의 선택된 멤버 값을 수정하기
		// 		(result :: 검색한 도서 정보 전체를 갖고 있음)
		if(category.equals("책이름") == true) {
			result.name = edit;
			System.out.println("*** <책이름> 수정이 완료되었습니다. ***");
		}
		else if(category.equals("저자") == true) {
			result.author = edit;
			System.out.println("*** <저자> 수정이 완료되었습니다. ***");
		}
		else if(category.equals("페이지수") == true) {
			result.page = Integer.parseInt(edit);	// String형 -> int형으로 변환
			System.out.println("*** <페이지수> 수정이 완료되었습니다. ***");
		}
		else if(category.equals("출판사명") == true) {
			result.pub = edit;
			System.out.println("*** <출판사명> 수정이 완료되었습니다. ***");
		}
		else {		// 없는 멤버의 이름인 경우, 에러 메시지 출력
			System.out.println();
			System.out.println("*** 입력이 올바르지 않습니다. 다시 시도해주세요. ***");
		}
		
		// - 인트로로 이동
		System.out.println();
		Main.PrintIntro();
	}
}
