package LibraryManagementSystem;

public class BorrowingServiceImpl implements BorrowingService {
    private Library library;

    public BorrowingServiceImpl(Library library) {
        this.library = library;
    }

    @Override
    public void borrowBook(String memberId, String bookId) {
        Member member = library.findMemberById(memberId);
        Book book = library.findBookById(bookId);

        if (member != null && book != null && !book.isBorrowed()) {
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Cannot borrow book.");
        }
    }

    @Override
    public void returnBook(String memberId, String bookId) {
        Member member = library.findMemberById(memberId);
        Book book = library.findBookById(bookId);

        if (member != null && book != null && book.isBorrowed()) {
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("Cannot return book.");
        }
    }
}
