import java.util.ArrayList;

class Library{
  //Instance variable
  private ArrayList<Book> listOfBooks;

  //Constructor 
  public Library(){
    listOfBooks = new ArrayList<Book>();
  }
  //Option 1:
  //Method adds user-created Book object into listOfBooks
  public void addBook(Book newBook){
    listOfBooks.add(newBook);
    System.out.println("The book, " + newBook + ", was added to the library");
  }
  //Option 2:
  //Method to display the entire list of Books(listOfBooks)
  public void listAllBooks(){
    for(int i = 0; i < listOfBooks.size(); i++){ //for loop goes through list
      System.out.println(i + ". " + listOfBooks.get(i));
    }
  }
  //Option 3:
  //Method recieves title the user typed, then searches and displays the first Book 
  //object and position in list whose title matches user input
  public void findBookByTitle(String searchedTitle){
    for(int i = 0; i < listOfBooks.size(); i++){
      //the if compares parameter, with i Book 
      //object in list, that is calling Book method to get the title
      if(searchedTitle.equals((listOfBooks.get(i)).getTitle())){ //Book with title found
        System.out.println(i + ". \"" + listOfBooks.get(i) + "\"") ;
        return;
      }
    }//In the case no Book objects have title typed by user
    System.out.println("There are currently no books with the title: \"" + searchedTitle + "\"");
  }
  //Option 4:
  //Method recieves author typed by user, then searches and lists every Book object in the list
  //and the position with authors that matches user input
  public void findAllBooksByAuthor(String searchedAuthor){
    boolean found = false;
    for(int i = 0; i < listOfBooks.size(); i++){
      //the if compares parameter, with i Book 
      //object in list, that is calling Book method to get the author
      if(searchedAuthor.equals((listOfBooks.get(i)).getAuthor())){ //Book with that author
        found = true;
        System.out.println(i + ". \"" + listOfBooks.get(i) + "\"");
      }
    }
    if(!found){ //In the case no Book obect has author typed by user
      System.out.println("There are currently no books with the author: \"" + searchedAuthor + "\"");
    }
  }
}