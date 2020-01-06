import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class DataBase
{
   static ArrayList <Reader> ReaderList = new ArrayList <Reader>();
   static ArrayList <Book> BookList = new ArrayList <Book>();
   public int number1;
   public int number2;
   private String title;
   private String author;
   private String borrower;
   private String name;
   private String surname;
   private String school;
   private String ID_of_the_reader;
   private String year_of_birth;
   private String ID_of_the_book;
   private String status1 = "free";
   private String status2 = "borrowed";
   private Scanner object1 = new Scanner(System.in);
   private Scanner object2 = new Scanner(System.in);
   public void displayFirstMenu()
   {
      System.out.println("> Choose any of the options below while writing down the relevant number: \n" + "--------------------------------\n" +
         "2 - Add a book in the library \n" + "6 - Control the library \n" + "7 - Turn back to the main menu \n" + "8 - Add a reader to the library \n" +
         "0 - Exit");
      System.out.println();
      System.out.println("> Type your option here");
      String s = object2.nextLine(); //user inputs a number2 (integer)
      if (s.equals("2") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("0"))
      { number2 = new Integer(s).intValue();}
      else 
      {
         System.out.println("The number you typed, is not valid, please try again");
         System.out.println();
         this.displayFirstMenu();
      }
   }
   public void displaySecondMenu()
   {
      System.out.println("> Choose one of the options below while writing down the relevant number: \n" + "---------------------------------\n" +
         "1 - Control the list of the library \n" + "2 - Add a book in the library \n" + "3 - Borrow a book from the library \n" +
         "4 - Turn back the book in the library \n" + "5 - Delete a book from the library \n" + "6 - Delete everything from the library \n" +
         "7 - Turn back to the main menu \n" + "8 - Add a reader to the library \n" + "9 - Control the list of the readers \n" + "0 - Exit");
      System.out.println();
      System.out.println("> Please type any of the options above:");
      String s1 = object2.nextLine();
      if ( s1.equals("1") || s1.equals("2") || s1.equals("3") || s1.equals("4") || s1.equals("5") || s1.equals("6") || s1.equals("7") || 
      s1.equals("8") || s1.equals("9") || s1.equals("0"))
      { number2 = new Integer(s1).intValue() ;}
      else 
      {
         System.out.println("The number you typed is not valid, please try again");
         System.out.println();
         this.displaySecondMenu();
      }
   }
   public void addBook()
   { //creating new book with status "available"
      System.out.println(">Type the title of the book: ");
      title = object1.nextLine();
      System.out.println(">Type the name of the author: ");
      author = object1.nextLine();
      System.out.println(">Type the ID of the book: ");
      ID_of_the_book = object1.nextLine();
      Book newBook = new Book(title, author, ID_of_the_book);
      BookList.add(newBook); // add the book to the BookList ArrayList
      System.out.println("--------------------------------------------");
      System.out.println("> You added a book to the the library successfully! \n");
      System.out.println("--------------------------------------------");
   }
   public void displayBookList()
   {
      if (BookList.size() == 0) //if the library is empty, it goes back to the main menu and number2
      { System.out.println(">------------------------------------------");
         System.out.println("> The library is empty! Please add a book first \n");
         System.out.println(">------------------------------------------");
         displayFirstMenu(); // display to the main menu
         number2 = object2.nextInt(); // register new number2
      }
      else
      { 
         for (int i=0 ; i<BookList.size() ; i++)
         { System.out.printf("\n>Index of the book: [%s]\n",i+1);
            System.out.println(BookList.get(i).showBook());
            System.out.println("----------------------------------------");
         }
      }
   }
   public void addStudent()
   { //create new book object with status "available"
      System.out.println("> Type the name of the reader");
      name = object1.nextLine();
      System.out.println("> Type the surname of the reader");
      surname = object1.nextLine();
      System.out.println("> Type the school of the reader");
      school = object1.nextLine();
      System.out.println("> Type the yearof the birth of the reader");
      year_of_birth = object1.nextLine();
      System.out.println("> Type the number of ID of the reader");
      ID_of_the_reader = object1.nextLine();
      Reader newReader = new Reader(name,surname, school, year_of_birth, ID_of_the_book);
      ReaderList.add(newReader); // add the book to the Booklist ArrayList
      System.out.println("-------------------------------------------------");
      System.out.println("> You added a book successfully to the library! \n");
      System.out.println("-------------------------------------------------");
   }
   public void displayStudentList()
   { 
      if (ReaderList.size() == 0) //if the library is empty, it goes to the main menu and number2
      {  System.out.println(">-------------------------------------------------");
         System.out.println("> The library is empty! Please add a book first \n");
         System.out.println(">-------------------------------------------------");
         displayFirstMenu(); //display to the main menu
         number2 = object2.nextInt(); //register new number2
      }
      else
      {  
         for (int i=0 ; i<ReaderList.size() ; i++)
         { System.out.printf("\n>Index of the reader: [%s], i+1");
            System.out.println(ReaderList.get(i).showReader());
            System.out.println(">------------------------------------------------");
         }
      }
   }
   public void borrowBook()
   {
      System.out.println("---------------------------------------------------");
      System.out.println("> Here are all the books that are registred in the library: ");
      System.out.println("---------------------------------------------------");
      displayBookList();
      borrowLoop1: while (number2==3) 
      {System.out.println("\n\n> Choose an available book from the above list and type the number of the index below: ");
         number1 = object2.nextInt()-1; //register user's book number2
         if (number1>BookList.size())
         {System.out.println("> The number of the book you entered is not on the list");
            System.out.println();
            this.borrowBook();
         }
         else 
         { 
            break borrowLoop1; }
      }
      borrowLoop2: while (number2 == 3){
      //check if the book to be borrowed is available
         if(BookList.get(number1).status.equalsIgnoreCase(status1) && BookList.size() >= number1)
         {//print the borrowed book information and change the book status to borrowed
            BookList.get(number1).status = "Borrowed";
            System.out.println("\n> You choose the book below: %s\n" + BookList.get(number1).showBook());
         // add the user name to the book borrower variable: 
            BookList.get(number1).borrower = borrower;
            BookList.get(number1).dateOfBorrowing = "Today";
            BookList.get(number1).dateOfReturn = "Within three weeks";
            System.out.println("> You should return the book within three weeks!");
            number2 = 7;
            break borrowLoop2;
         }
         else if(BookList.get(number1).status.equalsIgnoreCase(status2) && BookList.size() >= number1)
         { System.out.println("> The book you want to borrow is not available");
            number2 = 7;
            break borrowLoop2;
         }
         else if(number1>BookList.size()-1)
         {System.out.println(">The number you typed is not on the list");
            number2 = 7;
            break borrowLoop2;
         }
      }
   }
   public void returnBook()
   {
      System.out.println("Type the title of the book you want to return: ");
      String returnBookTitle = object1.nextLine();
      int x = 0;
      while (x<BookList.size())
      { //search for the book by its title, if it exists change its status, its borrower and borrowDate
         if (BookList.get(x).title.equalsIgnoreCase(returnBookTitle))
         { BookList.get(x).status = "available";
            BookList.get(x).borrower = "none";
            BookList.get(x).dateOfBorrowing = "none";
            BookList.get(x).dateOfReturn = "none";
            System.out.println(">You have successfully returned the book to the library");
            break; //if a title is found, break out of the loop and display number2 in the menu
         }
         else 
         {
            System.out.println(">There are no books in the library with this title");
            System.out.println(">Be sure that you have written the name of the book correctly or try to add another book in the library from the main menu");
         }
         x=x+1;
      }
      displaySecondMenu();
   }
   public void removeBook()
   {
      int i=0;
      System.out.println("-------------------------------------------------");
      System.out.println(">Here are all the books that are registred in the library: ");
      System.out.println("-------------------------------------------------");
      displayBookList();
      System.out.println("\n\n Choose an available book from the above list and type the index of the book: ");
      int number1 = object2.nextInt()-1; //register user's book number2
      if (number1>=BookList.size())
      {System.out.println("<Error> Please type a number of the book from the list: ");
         this.removeBook();
      }
      else if (number1>=0 && number1<BookList.size() && BookList.get(number1).status.equalsIgnoreCase("available"))
      { // check if the book to be borrrowed is available, print the borrowed book information and change the book status to borrowed
         System.out.printf("\n> You have chosen to remove the next book:[ %s]\n", BookList.get(number1));
         BookList.remove(number1);
         System.out.println("\n> The book"+(number1 + 1)+"is deleted\n");
      }
      else if (number1 >= 0 && number1<BookList.size() && BookList.get(number1).status.equalsIgnoreCase("borrowed"))
      { System.out.printf("\n> Book %s is not removed, because is  not available"); }
   }
   public void emptyLibrary()
   { System.out.println("> WARNING < You have chosen to delete all the books from the library! ");
      System.out.println("> Are you sure? Type yes or no: ");
      String confirmation = object1.nextLine();
      try {
         if (confirmation.equalsIgnoreCase("yes"))
         {System.out.println("> The library is being deleted ...");
            BookList.clear();
            System.out.println(">The library is empty");
            number2 = 7;
         }
      }
      catch (InputMismatchException error) 
      { System.out.println("<Error> Secure to only write yes or no correctly");
         number2 = 6;
      }
   }
   public void addUser()
   { 
      System.out.println(">Type the name of the reader");
      borrower = object1.nextLine().trim();
      for (int i=0 ; i<ReaderList.size(); i++)
      { 
         if (ReaderList.get(i).name.equalsIgnoreCase(borrower)) {}
         else
         {
            System.out.println("<Error> There isn't registred a reader with this name in the library");
            this.addUser();
         }
      }
   }
}