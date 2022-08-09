# 📌 Java Study

## 🔸 2022-08-09 화요일

## [배열과 ArrayList]

### 1. 코딩 문제 풀기(ArrayList를 활용한 응용 프로그램)

- 어느 학교에 학생이 3명 있습니다. 각 학생마다 읽은 책을 기록하고 있습니다. Student 클래스를 만들고 각 학생마다 읽은 책을 Student 클래스내에 ArrayList를 생성하여 관리하도록 합니다. 다음과 같이 출력 되도록 Student, Book, StudentTest 클래스를 만들어 실행하세요.

```
    Heo 학생이 읽은 책은 : 태백산맥1 태백산맥2 입니다.
    Kim 학생이 읽은 책은 : 토지1 토지2 토지3 입니다.
    Cho 학생이 읽은 책은 : 해리포터1 해리포터2 해리포터3 해리포터4 해리포터5 해리포터 6 입니다.
```

<br>

1. Book 클래스

```java
    public class Book {

	private String bookName;
	private String author;

	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
```

- Book 클래스 생성 후 private로 bookName과 author을 String 선언

- Book 메서드로 인스턴스 bookName과 author을 받도록 함

- 이후 source에서 getter, setter 추가

<br>

2. Student 클래스

```java
    import java.util.ArrayList;

    public class Student {

	int studentID;
	String studentName;
	ArrayList<Book> bookList;

	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;

		bookList = new ArrayList<Book>();
	}

	public void addBook(String bookName, String author) {
		Book book = new Book(bookName, author);

		bookList.add(book);
	}

	public void showStudentInfo() {

		System.out.print(studentName + " 학생이 읽은 책은 : ");

		for(Book book : bookList) {
			System.out.print(book.getBookName() + " ");
		}

		System.out.println("입니다.");
	}
```

- ArrayList를 사용하기 위해 import 추가

- studentID, studentName 선언하고, `ArrayList<Book> bookList` 사용

- 책을 추가하는 addBook 메서드에 bookName과 author을 받도록 함

- addbook 메서드를 사용하면 책 추가

- showStudentInfo 메서드는 출력 구문을 수행

- for 문에서 bookList에 존재하는 개수만큼 수행

<br>

3. StudentTest 클래스

```java
    public static void main(String[] args) {
		Student studentHeo = new Student(1001, "Heo");

		studentHeo.addBook("태백산맥1", "조정래");
		studentHeo.addBook("태백산맥2", "조정래");

		Student studentKim = new Student(1001, "Kim");

		studentKim.addBook("토지1", "박경리");
		studentKim.addBook("토지2", "박경리");
		studentKim.addBook("토지3", "박경리");

		Student studentCho = new Student(1001, "Cho");

		studentCho.addBook("해리포터1", "조앤 롤링");
		studentCho.addBook("해리포터2", "조앤 롤링");
		studentCho.addBook("해리포터3", "조앤 롤링");
		studentCho.addBook("해리포터4", "조앤 롤링");
		studentCho.addBook("해리포터5", "조앤 롤링");
		studentCho.addBook("해리포터6", "조앤 롤링");

		studentHeo.showStudentInfo();
		studentKim.showStudentInfo();
		studentCho.showStudentInfo();
	}
```

- 각 학생이 읽은 책의 리스트(bookName, author) 입력

- showStudentInfo() 메서드로 출력

<br>

## 🔖 Eclipse 실습

![day14](https://user-images.githubusercontent.com/79084294/183700424-37e16c4a-16ea-46de-af9f-28ed901a9adf.png)

<br>

## 🔖 Eclipse 출력 Console

![day14_console1](https://user-images.githubusercontent.com/79084294/183700438-aec218f5-c106-4db4-bccd-e4c3bd817497.png)
