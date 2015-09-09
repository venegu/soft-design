/*
This assignment is adapted from a textbook excersise in which you need to design a HealthProfile class for a person. The class attributes should include the person’s first name, last name, gender, date of birth (consisting of separate attributes for the month, day and year of birth), height (in inches) and weight (in pounds). Your class should have a constructor that receives this data. For each attribute, provide set and get methods. The class also should include methods that calculate and return the user’s age in years, maximum heart rate, target-heart-rate range, and body mass index, BMI, as explained below.

Your mission is to write a Java application that prompts for the person’s information, instantiates an object of class HealthProfile for that person and prints the information from that object—including the person’s first name, last name, gender, date of birth, height and weight—then calculates and prints theperson’s age in years, BMI, maximum heart rate and target-heart-rate range. The output format is free.

Target-Heart-Rate: According to the American Heart Association (AHA), the formula for calculating your maximum heart rate in beats per minute is 220 minus your age in years. Your target heart rate is a range that is 50-85% of your maximum heart rate. Note: These formulas are estimates provided by the AHA. Maximum and target heart rates may vary based on the health, fitness and gender of the individual. Always consult a physician or qualified health care professional before beginning or modifying an exercise program.

Body Mass Index: Adolphe Quetelet devised this index as dividing weight (in pounds) by the square of height followed by multiplying a scale constant 703. The nomal range is between 19.5 and 24.9. Less than this range is considered underweight and 30 or greater is considered obese.

Realize your implementation that satisfies the following minimal requirements:

properly exhibits right implementation, i.e., readable and compilable coding
properly reads personal information from terminal
properly writes maximum and target heart rates as well as BMI to terminal
properly writes error message to terminal in response to incorrect input
Note that your implementation must validate all of your input. As a hint, explore the 3rd implementation of date validateion which is simplest for date validation. You may be tempted to realize dialog boxes for input interface (read textbook 3.6). Explore your own extensions!
 */
package healthprofile;

/**
 *
 * @author Lisa Maldonado
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HealthProfile {

   private String firstName;
   private String lastName;
   private String gender;
   private String dateOfBirth;
   private int height;
   private int weight;

   /* Basic Constructor */
   public HealthProfile(){
      this(null, null, null, null, 0, 0);
   }

   /* Constructor with all the input data */
   public HealthProfile(String firstName, String lastName, String gender, String dateOfBirth, int height, int weight){
      setData(firstName, lastName, gender, dateOfBirth, height, weight);
   }

   /* Setter Methods */
   public void setData(String firstName, String lastName, String gender, String dateOfBirth, int height, int weight){
      setFirstName(firstName);
      setLastName(lastName);
      setGender(gender);
      setDob(dateOfBirth);
      setHeight(height);
      setWeight(weight);
   }

   public void setFirstName(String firstName){
      if (firstName.trim().isEmpty()){
         firstName = null;
      }
      else {
         this.firstName=firstName;
      }
   }

   public void setLastName(String lastName){
      if (lastName.trim().isEmpty()){
         lastName = null;
      }
      else {
         this.lastName=lastName;
      }
   }

   public void setGender(String gender){
      if (gender.equals("Male")||gender.equals("male")||gender.equals("female")||gender.equals("Female")){
          this.gender=gender;
      }
      else {
         gender = null;
      }
   }

   public void setDob(String dateOfBirth){
      this.dateOfBirth=dateOfBirth;
   }

   public void setHeight(int height){
      if (height <= 0){
         height = 0;
      }
      else {
         this.height = height;
      }
   }

   public void setWeight(int weight){
      if (weight <= 0){
         weight = 0;
      }
      else {
         this.weight = weight;
      }
   }

   /* Getter methods */
   public String getFirstName(){
      return firstName;
   }

   public String getLastName(){
      return lastName;
   }

   public String getGender(){
      return gender;
   }

   public String getDob(){
      return dateOfBirth;
   }

   public int getHeight(){
      return height;
   }

   public int getWeight(){
      return weight;
   }

   public String personalInfo(){
      return '\n'+"Health Profile"+'\n'+'\n'+"Name: "+getFirstName()+" "+getLastName()+"\n"+"Gender: "+getGender()+"\n"+"Date of Birth: "+getDob()+'\n'+"Height: "+getHeight()+'\n'+"Weight: "+getWeight();
   }

   public int yearBirth(){
      /* Getting index after last '/'*/
      String substring = getDob().substring(getDob().lastIndexOf('/')+1);

      /* Making it into an it so it's easier to use for later methods */
      int year = Integer.parseInt(substring);
      return year;
   }

   public int age(int currentDate, int year){
      int age = currentDate - year;
      return age;
   }

   public double bmi(){
      double w = (double)getWeight();
      double h = (double)getHeight();
      double bmi = (w /(h*h))*207;
      return bmi;
   }

   public int maxHeartRate(int currentDate, int year){
      return 220-age(currentDate,year);
   }

   public String targetHeartRate(int maxHeartRate){
      double maxHeart = (double)maxHeartRate;
      double lower = maxHeartRate*.5;
      double higher = maxHeartRate*.85;
      String range = lower+" - "+higher;
      return range;
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) throws ParseException {
      // create Scanner to obtain input from command window
      Scanner input = new Scanner(System.in);

      // Name
      System.out.println("What is your first name?");
      String firstName = input.nextLine();

      System.out.println("What is your last name?");
      String lastName = input.nextLine();


      System.out.println("What is your gender?");
      String gender = input.nextLine();

      // DOB
      System.out.print("Enter Date of Birth (mm/dd/YYYY ): ");
      String d = input.nextLine();

      /* Error handling & Validating DOB */
      try{
      Calendar cal = Calendar.getInstance();
      DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
      /* The following line makes Date into a String */
      cal.setTime(sdf.parse(d));

      } catch (ParseException e) {
         System.out.println("Please input DOB in this format: MM/dd/yyyy");
         String c = input.nextLine();
         DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
         d=c ;
      }

      /* Getting today's date */
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Date today = Calendar.getInstance().getTime();
      String dateToday = df.format(today);
      //System.out.println(dateToday);
      String todaySub = dateToday.substring(dateToday.lastIndexOf('/')+1);
      //System.out.println(todaySub);
      /* To make string int (previous method would not work) */
      Integer intToday = Integer.valueOf(todaySub);
      //System.out.println(intToday-1);

      /* Height and weight for BMI */
      System.out.println("What is your height (inches)?");
      int height = input.nextInt();

      System.out.println("What is your weight (lbs)?");
      int weight = input.nextInt();

      /* Instantiating the variable */
      HealthProfile profile = new HealthProfile(firstName, lastName, gender, d, height, weight);

      /* Getting paramaters to find age */
      int year = profile.yearBirth();
      int currentDate = intToday;

      /* Age function is used here to determine user's age */
      int age = profile.age(currentDate, year);

      /* Calculating BMI */
      double bmi = profile.bmi();

      /* Determines max heart rate based on age */
      int maxHeart = profile.maxHeartRate(currentDate, year);

      /* Finding the range of target heart rate for the user */
      String targetHeart = profile.targetHeartRate(maxHeart);

      /* Printing out users Health Data along with previous functions */
      String name = profile.personalInfo();
      System.out.println(name+'\n'+"Approximate Age: "+age+'\n'+"BMI: "+bmi+'\n'+"Maximum Heart Rate: "+maxHeart+'\n'+"Target Heart Rate Range: "+targetHeart);

   }

}