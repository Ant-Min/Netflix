public class MovieTest{
  public static void main(String [] args){
  
      Movie m1 = new Movie("Avatar","Cameron","2010");
      System.out.println(m1.toString());
     Movie m2 = new Movie();
     System.out.println(m2.toString()); 
     
     System.out.println(m1.getMovieCount());
  
  }
}