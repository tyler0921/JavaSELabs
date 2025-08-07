package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        // a. ������ ��ü�� �����մϴ�.
        Library library = new Library("�߾� ������");

        // b. addSampleBooks()�� ȣ���Ͽ� ���� ������ �߰��մϴ�.
        addSampleBooks(library);

        // c. ������ ������ ����մϴ�.
        System.out.println("===== " + library.getName() + " =====");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
        
        // d. �� ��� �׽�Ʈ �޼��� ȣ��
        testFindBook(library);
        testCheckOut(library, "978-89-01-14077-4"); // '�ڹ��� ����' ISBN
        testReturn(library, "978-89-01-14077-4");

        // e. ���� ������ ���� ����� ����մϴ�.
        displayAvailableBooks(library);
    }

    private static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    private static void testFindBook(Library library) {
        System.out.println("===== ���� �˻� �׽�Ʈ =====");
        System.out.println("�������� �˻� ���:");
        System.out.println(library.findBookByTitle("�ڹ��� ����"));
        System.out.println();
        
        System.out.println("���ڷ� �˻� ���:");
        List<Book> foundByAuthor = library.findBooksByAuthor("Robert C. Martin");
        for (Book book : foundByAuthor) {
            System.out.println(book);
        }
        System.out.println();
    }
    
    private static void testCheckOut(Library library, String isbn) {
        System.out.println("===== ���� ���� �׽�Ʈ =====");
        if (library.checkOutBook(isbn)) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findBookByISBN(isbn));
        } else {
            System.out.println("���� ���� ����!");
        }
        
        System.out.println("\n������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }

    private static void testReturn(Library library, String isbn) {
        System.out.println("===== ���� �ݳ� �׽�Ʈ =====");
        if (library.returnBook(isbn)) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(library.findBookByISBN(isbn));
        } else {
            System.out.println("���� �ݳ� ����!");
        }

        System.out.println("\n������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }

    private static void displayAvailableBooks(Library library) {
        System.out.println("===== ���� ������ ���� ��� =====");
        List<Book> availableBooks = library.getAvailableBooks();
        for (Book book : availableBooks) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }
}
