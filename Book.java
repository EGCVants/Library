public class Book{
  //Instance variables
  private String author;
  private String title;
  private int year;

  //Constuctor
  public Book(String theAuthor, String theTitle, int theYear){
    author = theAuthor;
    title = theTitle;
    year = theYear;
  }
  //Displays Book object
  public String toString(){
    return author + ", \"" + title + "\" (" + year + ")";
  }
  //Option 3:
  //Method returns the title of Book object
  public String getTitle(){
    return title;
  }
  //Option 4:
  //Method returns the author of Book object
  public String getAuthor(){
    return author;
  }
}