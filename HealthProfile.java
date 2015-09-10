package healthprofile;

/**
 *
 * @author Lisa Maldonado
 * CSC 221
 * Professor Akira Kawaguchi
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class HealthProfile {

   private String firstName;
   private String lastName;
   private String gender;
   private String dateOfBirth;
   private double height;
   private double weight;

   /* Basic Constructor */
   public HealthProfile(){
      this(null, null, null, null, 0, 0);
   }

   /* Constructor with all the input data */
   public HealthProfile(String firstName, String lastName, String gender, String dateOfBirth, double height, double weight){
      setData(firstName, lastName, gender, dateOfBirth, height, weight);
   }

   /* Set Methods */
   public void setData(String firstName, String lastName, String gender, String dateOfBirth, double height, double weight){
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

   public void setHeight(double height){
      if (height <= 0){
         height = 0;
      }
      else {
         this.height = height;
      }
   }

   public void setWeight(double weight){
      if (weight <= 0){
         weight = 0;
      }
      else {
         this.weight = weight;
      }
   }

   /* Get methods */
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

   public double getHeight(){
      return height;
   }

   public double getWeight(){
      return weight;
   }

   public static Boolean validateFirstName(String firstName){
     //Scanner input = new Scanner(System.in);
     if (firstName.trim().isEmpty()){
         return false;
      }
      else{
         return true;
      }
   }

   public static Boolean validateLastName(String lastName){
      //Scanner input = new Scanner(System.in);
      if (lastName.trim().isEmpty()){
         return false;
      }
      else{
         return true;
      }
   }

   public static Boolean validateGender(String gender){
      //Scanner input = new Scanner(System.in);
      if (gender.equals("Male")||gender.equals("male")||gender.equals("female")||gender.equals("Female")){
         return true;
      }
      else {
         return false;
      }
   }

   public static Boolean validateHeight(double height){
      if(height <= 0){
         return false;
      }
      else {
         return true;
      }
   }

   public static Boolean validateWeight(double weight){
      if(weight <= 0){
         return false;
      }
      else {
         return true;
      }
   }

   /* Methods for this class */
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
      double w = getWeight();
      double h = getHeight();
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
    * @throws java.text.ParseException
    */
   public static void main(String[] args) throws ParseException {
      // create Scanner to obtain input from command window
      Scanner input = new Scanner(System.in);

      /* Beginning of inputs */

      /* First name */
      System.out.println("What is your first name?");
      String firstName = input.nextLine();

      /* Validating first name */
      Boolean firstValid = validateFirstName(firstName);
      while(firstValid == false){
         System.out.println("I am a simple machine, I didn't understand that. Please re-enter your first name and make sure there aren't any extra spaces.");
         String f = input.nextLine();
         firstValid = validateLastName(f);
         firstName = f;
      }

      /* Last name */
      System.out.println("What is your last name?");
      String lastName = input.nextLine();

      /* Validating last name */
      Boolean lastValid = validateLastName(lastName);

      while(lastValid == false){
         System.out.println("I am a simple machine, I didn't understand that. Please re-enter your last name and make sure there aren't any extra spaces.");
         String l = input.nextLine();
         lastValid = validateLastName(l);
         lastName = l;
      }

      System.out.println("What is your gender?");
      String gender = input.nextLine();

      /* Validating gender */
      Boolean genValid = validateGender(gender);

      while(genValid == false){
         System.out.println("I am a simple machine, I didn't understand that. Please re-enter your gender, make sure you enter either 'Male' or 'Female' and that there aren't any extra spaces.");
         String g = input.nextLine();
         genValid = validateGender(g);
         gender = g;
      }

      // DOB
      System.out.print("Enter Date of Birth (mm/dd/yyyy): ");
      String d = input.nextLine();

      /* Attempt at Error handling & Validating DOB */
     /* try{
      Calendar cal = Calendar.getInstance();
      DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());*/
      /* The following line makes Date into a String */
    //  cal.setTime(sdf.parse(d));

      /* } catch (ParseException e) {
         System.out.println("Please input DOB in this format: MM/dd/yyyy");
         String c = input.nextLine();
         DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
         d=c ;
      }*/

      /* Error handling & Validating DOB */
      try {
         GregorianCalendar gc = new GregorianCalendar();
         gc.setLenient(false);  // important

         /* Splitting input into an array based on the '/' */
         String str[] = d.split("/");
         int day = Integer.parseInt(str[0]);
         int month = Integer.parseInt(str[1]);
         int year = Integer.parseInt(str[2]);
         gc.set(GregorianCalendar.YEAR, year);
         gc.set(GregorianCalendar.MONTH, month);
         gc.set(GregorianCalendar.DATE, day);

         gc.getTime();
      }
      catch (Exception e) {
         System.out.println("I didn't understand that. Please input DOB in this format: mm/dd/yyyy");
         String c = input.nextLine();
         d = c;
      }


      /* Getting today's date */
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Date today = Calendar.getInstance().getTime();
      String dateToday = df.format(today);
      String todaySub = dateToday.substring(dateToday.lastIndexOf('/')+1);

      /* To make string int (previous method would not work) */
      Integer intToday = Integer.valueOf(todaySub);


      /* Height */
      System.out.println("What is your height (inches)?");
      /* Validating input is a double */
      while(!input.hasNextDouble()){
         System.out.println("Please only put in numbers in this field.");
         input.next();
      }
      double height = input.nextInt();

      /* Validating height*/
      Boolean heightValid = validateHeight(height);

      while(heightValid == false){
         System.out.println("Please re-enter your height and make sure it's bigger than 0.");
         int h = input.nextInt();
         heightValid = validateHeight(h);
         height = h;
      }

      /* Weight */
      System.out.println("What is your weight (lbs)?");
      /* Validating input is a double */
      while(!input.hasNextDouble()){
         System.out.println("Please only put in numbers in this field.");
         input.next();
      }
      double weight = input.nextDouble();

      Boolean weightValid = validateWeight(weight);

      /* Validating weight */
      while(weightValid == false){
         System.out.println("Please re-enter your weight and make sure it's bigger than 0.");
         double w = input.nextDouble();
         weightValid = validateWeight(w);
         weight = w;
      }

      /* Instantiating the object */
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
