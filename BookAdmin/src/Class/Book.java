package Class;

public class Book {
	// - 멤버 변수 :: ISBN(isbn), 책 이름(name), 저자(author), 페이지 수(page), 출판사(pub)
	public String isbn;
	public String name;
	public String author;
	public int page;
	public String pub;
	
	public Book(String i, String n, String a, int p, String pb) {
		this.isbn = i;
		this.name = n;
		this.author = a;
		this.page = p;
		this.pub = pb;
	}
}
