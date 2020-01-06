public class Book
{
   public String title;
   public String status;
   public String borrower;
   public String dateOfBorrowing;
   public String dateOfReturn;
   private String author;
   private String ID_of_the_book;
   public Book(String title1, String author1, String ID_of_the_book1)
   { title = title1;
      author = author1;
      ID_of_the_book = ID_of_the_book1;
      borrower = "none";
      dateOfBorrowing = "none";
      dateOfReturn = "none";
      status = "available";
   }
   public String showBook()
   {
      String book = "------------------------------" +
                    "Title - " + title +
                    " Author - " + author +
                    " ID of the book " + ID_of_the_book +
                    " Status - " + status +
                    " Borrower - " + borrower +
                    " Date of borrowing - " + dateOfBorrowing +
                    " Date of return - " + dateOfReturn + 
                    "\n -------------------------------------";
      return book;
   }
}