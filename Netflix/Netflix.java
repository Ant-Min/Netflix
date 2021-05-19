/** Netflix is a class that holds a database with JButtons for adding, removing, and sorting the database,
     along with clearing JFields and uses the Movie class.
    @author Anthony Minunni
    @date 4/18/2019 */

import java.util.ArrayList;
import java.util.Collections;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Netflix extends JFrame implements ActionListener{
    /** add - private JButton that adds to ArrayList */
    private JButton add;
    /** clear - private JButton that clears editable JFields */
    private JButton clear;
    /** sort - private JButton that organizes values in ArrayList */
    private JButton sort;
    /** remove - private JButton that removes from ArrayList */
    private JButton remove;
    /** title - private JLabel that indicates the title that the user should type */
    private JLabel title;
    /** director - private JLabel that indicates the director the user should type */
    private JLabel director;
    /** year - private JLabel that indicates the year the user should type */
    private JLabel year;
    /** directorInput - private JTextField where the user types the director */
    private JTextField directorInput;
    /** titleInput - private JTextField where the user types the title */
    private JTextField titleInput;
    /** yearInput - private JTextField where the user types the year */
    private JTextField yearInput;
    /** library - ArrayList that uses Movie class to hold movies */
    static ArrayList<Movie> library = new ArrayList<Movie>();
    
  public Netflix(){
      //sets size of window  
      GridBagConstraints layoutConst=null;
      setSize(1000,1000); 
    
      setTitle("Netflix");
      //all below creates buttons and text fields, sets up the GUI      
      add = new JButton("Add");
       add.addActionListener(this);
       
      clear = new JButton("Clear");
       clear.addActionListener(this);
       
      sort = new JButton("Sort");
       sort.addActionListener(this);
       
      remove = new JButton("Remove");
       remove.addActionListener(this);
       
      title = new JLabel();
       title.setText("Title");
      
      director = new JLabel();
       director.setText("Director");
      
      year = new JLabel();
       year.setText("Year");
       
      directorInput = new JTextField("", 10);
       directorInput.setEditable(true);
       
      titleInput = new JTextField("", 10);
       titleInput.setEditable(true);
      
      yearInput = new JTextField("", 10);
       yearInput.setEditable(true);
       
      setLayout(new GridBagLayout());
      layoutConst = new GridBagConstraints();
            
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      add(title, layoutConst);
      
      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(titleInput, layoutConst);
      
      layoutConst.gridx=0;
      layoutConst.gridy=1;
      add(director, layoutConst);
      
      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(directorInput, layoutConst);
      
      layoutConst.gridx=0;
      layoutConst.gridy=2;
      add(year, layoutConst);
      
      layoutConst.gridx = 1;
      layoutConst.gridy = 2;
      layoutConst.insets = new Insets(10, 10, 10, 10);
      add(yearInput, layoutConst);
      
      layoutConst.gridx=0;
      layoutConst.gridy=3;
      add(add, layoutConst);
      
      layoutConst.gridx=1;
      layoutConst.gridy=3;
      add(remove, layoutConst);
      
      layoutConst.gridx=0;
      layoutConst.gridy=4;
      add(clear, layoutConst);
      
      layoutConst.gridx=1;
      layoutConst.gridy=4;
      add(sort, layoutConst);
  }
  /** addMovie - method that adds a movie to the library
      @param t - String that holds movie title
      @param d - String that holds director
      @param y - String that holds year */
  public static void addMovie(String t, String d, String y){
      
      library.add(new Movie(t,d,y));
      System.out.println("Movie added. Number of movies in library: " + Movie.getMovieCount());
  }
  /** removeMovie - method that removes a movie from the library
      @param t - String that holds movie title
      @param d - String that holds director title
      @param y - String that holds year */
  public static void removeMovie(String t, String d, String y){      
      
      Movie movieTest = new Movie(t,d,y);
      Movie.setMovieCount(Movie.getMovieCount()-1);
      boolean test = true;
      for(int i = 0; i<library.size();i++){
          if((library.get(i)).equals(movieTest)){
              test = false;
              library.remove(i);
              Movie.setMovieCount(library.size());
              System.out.println("Movie removed. Number of movies in library: " + Movie.getMovieCount());
          }
      }
      if(test){
              System.out.println("Movie not found.");
      }
  }
  /** actionPerformed - method that runs when a JButton is pressed
      @param e - JButton that is pressed */
  public void actionPerformed(ActionEvent e){
  
      String newTitle = titleInput.getText();
      String newDirector = directorInput.getText();
      String newYear = yearInput.getText();
      
      if(e.getSource()==clear){
          titleInput.setText("");
          directorInput.setText("");
          yearInput.setText("");
      }
      
      if(e.getSource()==add){
          addMovie(newTitle,newDirector,newYear);
          titleInput.setText("");
          directorInput.setText("");
          yearInput.setText("");
      }
      
      if(e.getSource()==remove){
          removeMovie(newTitle, newDirector, newYear);
          titleInput.setText("");
          directorInput.setText("");
          yearInput.setText("");
      }
      
      if(e.getSource()==sort){
          Collections.sort(library);
          if(library.size()==0){
              System.out.println("No movies in library.");
          }
          else{
              for(int i=0;i<library.size();i++){
                  System.out.println(library.get(i).toString());
              }
              System.out.println("Total number of movies: " + Movie.getMovieCount());
          }
      }
  }
  
  public static void main(String [] args){
      //makes the GUI
      Netflix myFrame = new Netflix();
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
      
      library.add(new Movie("Transformers","Bay","2007"));
      library.add(new Movie("Back to the Future","Zemeckis","1985"));
      library.add(new Movie("Avengers: Infinity War","Russo","2018"));
      library.add(new Movie("The Iron Giant","Bird","1998"));
      library.add(new Movie("Toy Story 2","Brannon","1999"));
  }
}