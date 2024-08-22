package LibraryManagementSystem;

public class LibraryMain {
	    public static void main(String[] args) {
	        Library library = new Library();
	        BorrowingService borrowingService = new BorrowingServiceImpl(library);

	        Book book1 = new Book("B001", "1984", "George Orwell");
	        Book book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee");

	        Member member1 = new Member("M001", "Rushank");
	        Member member2 = new Member("M002", "Mohit");

	        library.addBook(book1);
	        library.addBook(book2);
	        library.addMember(member1);
	        library.addMember(member2);

	        borrowingService.borrowBook("M001", "B001");
	        borrowingService.returnBook("M001", "B001");
	        
	        borrowingService.borrowBook("M002", "B002");
	        borrowingService.returnBook("M002", "B002");
	    }
	}

