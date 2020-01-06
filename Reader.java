import java.util.Scanner;
public class Reader
{
   public String name;
   public String surname;
   public String school;
   public String year_of_birth;
   public String ID_of_the_reader;
   public Reader(String name1, String surname1, String school1, String year_of_birth1, String ID_of_the_reader1)
   { name = name1;
      surname = surname1;
      school = school1;
      year_of_birth = year_of_birth1;
      ID_of_the_reader = ID_of_the_reader1;
   }
   public String showReader()
   {
      String reader = "-----------------------"+ "Name - " + name +
                                              " Surname - "+surname +
                                              " School - " + school + 
                                              " Year of birth - "+ year_of_birth +
                                              " ID of the reader - " + ID_of_the_reader +
                                              "\n------------------------------------";
      return reader;
   }
   public String getName()
   { 
      return name;
   }
}