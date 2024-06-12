import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String [] optionList = {"Add a book", 
                            "List all books",
                            "Find book (by title)",
                            "Find all books (by author)", 
                            "Quit"};
    int choice = 0; //Recieves user input in while loop from calling method(2)
    boolean done = false; //Condition for while loop
    
    Scanner sc = new Scanner(System.in);
    Library library = new Library(); 
    
    //Program starts
    while (!done){
      promptForInput(optionList);  //Calls method(1) to display menu 
      choice = userChoice(optionList, sc); //Calls method(2) to allow user input 
      switch(choice){
        case 1:
          //Creates new book object, sends it to ArrayList in Library
          //Calls method(3) in main, then calls library method
          library.addBook(createBook()); 
          break;
        case 2: 
          library.listAllBooks(); //Call method in libraray and lists all books
          break;
        case 3:
          //Recieves title input, searches for the first book with that title
          //Calls method(4) in main, then calls library method
          library.findBookByTitle(inputTitle());
          break;
        case 4:
          //Recives author input, lists all books by that author
          //Calls method(5) in main, then calls library method
          library.findAllBooksByAuthor(inputAuthor()); 
          break;
        case 5:
          //Exit/ends while loop
          done = true;
          break;
      }
    }//End of while loop
    System.out.println("Goodbye");
  } //End of Program

  //Method(1) displays menu within while loop
  public static void promptForInput(String [] optionList){
    System.out.println("Menu:");
    //for loop goes through list of prompts for to display the menu
    for(int i = 0; i < optionList.length; i++){ 
      System.out.println( i + 1 + ". " + optionList[i]);
    }
  }
  //Method(2) validates and recieves user input for the menu
  public static int userChoice(String [] optionsList, Scanner sc){
    if(!sc.hasNextInt()){ //If user types anything but an integer, invalid
      String invalid = sc.nextLine();
      System.out.println(invalid + " is not a valid input. Try again.");
    } else {
      int isNumber = sc.nextInt();
      sc.nextLine();
      if(isNumber < 1 || isNumber > 5){ //If user types anything not within 1-5, invalid
        System.out.println(isNumber + " is not a valid input. Try again.");
      } else {
        return isNumber;
      }
    }
    return 0; //No option will be chosen, return 0 for invalid input
  }
  //Method(3) creates a book object based on user input, passes to library in while loop (Option 1)
  public static Book createBook(){
    Book newBook;
    String newTitle;
    String newAuthor;
    int newYear = 0;
    boolean isNum = false; //Is a number
    Scanner sc = new Scanner(System.in);

    //Lines 77-81: User can type in whatever for the title and author
    System.out.println("Input the title of the book: "); //Prompt
    newTitle = sc.nextLine();
    System.out.println("Input the author's name: "); //Prompt
    newAuthor = sc.nextLine();
    //While loop to ensure that the user types in a number for the year
    while(!isNum){
      System.out.println("Input the year of publication: "); //Prompt
      if(!sc.hasNextInt()){ //If user types anything but an integer, invalid
        String notNum = sc.nextLine();
        System.out.println(notNum + " is not a valid year. Please type in an integer");
      } else {
        newYear = sc.nextInt();
        sc.nextLine();  //Prevents bug
        isNum  = true;
      }
    }//Calls Book class to create new object with inputs as parameters
    newBook = new Book(newAuthor, newTitle, newYear); 
    return newBook;
  }
  //Method(4) recives user input for the title they want to find (Option 3)
  public static String inputTitle(){
    String inpTitle;
    Scanner sc = new Scanner(System.in);
    //Displays prompt, user can type in whatever they want
    System.out.println("What is the title of the book you are looking for: ");
    inpTitle = sc.nextLine();
    return inpTitle;
  }
  //Method(5) recieves user input for finding the books for some author(Option 4)
  public static String inputAuthor(){
    String inpAuthor;
    Scanner sc = new Scanner(System.in);
    //Displays prompt, user can type in whatever they want
    System.out.println("What is the name of the author whose books you are looking for: ");
    inpAuthor = sc.nextLine();
    return inpAuthor;
  }
} //End