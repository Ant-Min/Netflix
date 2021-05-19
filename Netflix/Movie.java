/** Movie is a class that holds info of a movie's title, director, and year of release
    @author Anthony Minunni
    @date 4/18/2019 */
public class Movie implements Comparable<Movie>{
    /** movieCount - int that holds number of movies made */
    static int movieCount=0;
    /** title - String that holds movie title */
    private String title;
    /** directorLName - String that holds director's last name */
    private String directorLName;
    /** year - private String that holds movie's year of release */
    private String year;
  /** Default Constructor */      
  public Movie(){
      title = "";
      directorLName = "";
      year = "0000";
      movieCount++;
  }
  /** Fully qualified constructor
      @param t is String for title
      @param d is String for director
      @param y is String for year */
  public Movie(String t, String d, String y){
      title = t;
      directorLName = d;
      year = y;
      movieCount++;
  }
  /** Copy Constructor */
  public Movie(Movie other){
      title = other.title;
      directorLName = other.directorLName;
      year = other.year;
      movieCount++;
  }
  /** setTitle - method that renames a movie's title
      @param t is String that the title changes to */
  public void setTitle(String t){
      title = t;
  }
  /** getTitle - method that returns a movie's title
      @return title of movie */
  public String getTitle(){
      return title;
  }
  /** setDirector - method that renames a movie's director
      @param d is String that the director changes to */
  public void setDirector(String d){
      directorLName = d;
  }
  /** getDirector - method that returns a movie's director
      @return director of movie */
  public String getDirector(){
      return directorLName;
  }
  /** setYear - method that updates year of movie's release
      @param y is String that the year changes into */
  public void setYear(String y){
      year = y;
  }
  /** getYear - method that returns a movie's year
      @return year of movie */
  public String getYear(){
      return year;
  }
  /** setMovieCount - method that sets the number of movies counted
      @param c is the updated int of movie count */
  public static void setMovieCount(int c){
      movieCount = c;
  }
  /** getMovieCount - method that returns the movie count
      @return count of movies made */
  public static int getMovieCount(){
     return movieCount;
  }
  /** toString - String that displays information of a movie constructor
      @return String with movie title, director, and year info */
  public String toString(){
      return "Title: " + title + " Director: " + directorLName + " Year: " + year;
  }
  /** compareTo - method that compares two movie classes with each other
      @return 1 or -1 based on which class is first */
  public int compareTo(Movie other){
      if(!(this.getTitle().equals(other.getTitle()))){
          return this.getTitle().compareTo(other.getTitle());
      }
      else if(!(this.getDirector().equals(other.getDirector()))){
          return this.getDirector().compareTo(other.getDirector());
      }
      else
          return this.getYear().compareTo(other.getYear());
  }
  /** equals - method that tests if two movie classes are identical
      @return boolean true if the titles, directors, and years are the same; boolean false if not all three are true */
  public boolean equals(Movie other){
      if(this.getTitle().equals(other.getTitle())&&this.getDirector().equals(other.getDirector())&&this.getYear().equals(other.getYear())){
          return true;
      }
      else
          return false;
  }
}