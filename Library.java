import java.util.InputMismatchException;
public class Library
{
DataBase library = new DataBase();
public void run()
{ library.displayFirstMenu();
  exit:
  while (library.number2 != 0)
  { if (library.number2 == 1 && library.BookList.size() > 0)
       { library.displayBookList();
         library.number2 = 7;
       }
       if (library.number2 == 1 && library.BookList.size() == 0)
          { System.out.println("<ERROR> Library is empty! Please add a book first!");
          library.number2 = 7;
          }
            if (library.number2 == 2)
            { library.addBook();
            library.displaySecondMenu();
            }
            if (library.number2 == 3)
            { if (library.BookList.size() > 0)
            { library.addUser();
            library.borrowBook();
            library.displaySecondMenu();
            }
            }
            if ( library.number2 == 4)
            { library.returnBook();
            library.displaySecondMenu();
            }
            if (library.number2 == 5)
            { library.removeBook();
            if (library.BookList.size()>0) 
            { library.displaySecondMenu();
            }
            else 
            {System.out.println("<ERROR> The array is empty! Please add a book first");
            library.displayFirstMenu();
            }
            }
            if (library.number2 == 6)
            { library.emptyLibrary();
            }
            if (library.number2 == 7)
            {
            if (library.BookList.size()>0)
            {library.displaySecondMenu();
            }
            else if (library.BookList.size() == 0)
            { library.displayFirstMenu();
            }
            }
            if (library.number2 == 8)
            {
            library.addStudent();
            library.displaySecondMenu();
            }
            if (library.number2 == 9 && library.ReaderList.size()>0)
            { library.displayStudentList();
            library.number2 = 7;
            }
            if ( library.number2 == 9 && library.ReaderList.size() == 0)
            { System.out.println("<ERROR> Library is empty! Please add another book! ");
            library.number2 = 7;
            }
            if (library.number2 == 0)
            { break exit;
            }
            }
            System.out.println();
            System.out.println("You are out of the library");
            }
            public static void main (String[] args)
            {
            System.out.println(">Welcome to the library");
            Library newBook = new Library();
            newBook.run();
    }
}