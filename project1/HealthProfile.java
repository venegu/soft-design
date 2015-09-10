package healthprofile;

/**
 * To compile in the terminal run the following command outside of the package
 * directory: javac -cp . healthprofile/HealthProfile.java
 * To run this in the same directory: java -cp . healthprofile/HealthProfile
 *
 * @author Lisa Maldonado
 * CSC 221
 * Professor Akira Kawaguchi
 */

import java.text.SimpleDateFormat;
import java.util.Date;
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
      if (gender.equals("Male")||gender.equals("male")||gender.equals("m")||gender.equals("M")||gender.equals("female")||gender.equals("Female")||gender.equals("f")||gender.equals("F")){
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

   /* Static Methods */
   public static Boolean validateName(String name){
     if (name.trim().isEmpty()){
         return false;
      }
      else{
         return true;
      }
   }

   public static Boolean validateGender(String gender){
      return gender.equals("Male")||gender.equals("male")||gender.equals("m")||gender.equals("M")||gender.equals("female")||gender.equals("Female")||gender.equals("f")||gender.equals("F");
   }

   public static Boolean validateDob(String input){

      if(input.trim().isEmpty()){
         return false;
      }

      String str[] = input.split("/");
      int year = Integer.parseInt(str[2]);
      int month = Integer.parseInt(str[1]);
      int day = Integer.parseInt(str[0]);

      if((year>year())||((year()==year)&&(month>month()))||((year == year())&&(month==month())&&(day>day()))){
         return false;
      }
      else if(input.matches("^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{4})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{4})$")){
         return true;
      }

      else{
         return false;
      }
   }

   public static Boolean validateHeight(double height){
      if(height <= 0){
         return false;
      }
      else if(height >107){ /* The tallest human alive was 8ft 11 inches */
         return false;       /* That is 107 inches */
      }
      else
         return true;
   }

   public static Boolean validateWeight(double weight){
      if(weight <= 0){
         return false;
      }
      else if(weight > 1346){ /* The heaviest human alive is 1,346 lbs  */
         return false;
      }
      else {
         return true;
      }
   }

   public static String currentDate(){
      String pattern = "dd/MM/yyyy";
      SimpleDateFormat format = new SimpleDateFormat(pattern);
      return format.format(new Date());
   }

   public static int month(){
      String str[] = currentDate().split("/");
      int month = Integer.parseInt(str[1]);
      return month;
   }

   public static int day(){
      String str[] = currentDate().split("/");
      int day = Integer.parseInt(str[0]);
      return day;
   }

   public static int year(){
      String str[] = currentDate().split("/");
      int year = Integer.parseInt(str[2]);
      return year;
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

   public int monthBirth(){
      String str[] = getDob().split("/");
      int month = Integer.parseInt(str[1]);
      return month;
   }

   public int dayBirth(){
      String str[] = getDob().split("/");
      int day = Integer.parseInt(str[0]);
      return day;
   }

   public int age(int currentYear, int currentMonth, int currentDay, int year, int month, int day){
      int age = year()-year;
      if((month()-month<0)||(day()-day<0)){
         return age-1;
      }
      else
         return age;
   }

   public double bmi(){
      double w = getWeight();
      double h = getHeight();
      double bmi = (w/(h*h))*703; /* BMI = [weight in lbs/((height in inches)^2)]*703 */
      return bmi;
   }

   public int maxHeartRate(int age){
      return 220-age;
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
   public static void main(String[] args){
      // create Scanner to obtain input from command window
      Scanner input = new Scanner(System.in);

      /* Beginning of inputs */

      /* First name */
      System.out.println("What is your first name?");
      String firstName = input.nextLine();

      /* Validating first name */
      Boolean firstValid = validateName(firstName);
      while(firstValid == false){
         System.out.println("I am a simple machine, I didn't understand that. Please re-enter your first name and make sure there aren't any extra spaces.");
         String f = input.nextLine();
         firstValid = validateName(f);
         firstName = f;
      }

      /* Last name */
      System.out.println("What is your last name?");
      String lastName = input.nextLine();

      /* Validating last name */
      Boolean lastValid = validateName(lastName);

      while(lastValid == false){
         System.out.println("I am a simple machine, I didn't understand that. Please re-enter your last name and make sure there aren't any extra spaces.");
         String l = input.nextLine();
         lastValid = validateName(l);
         lastName = l;
      }

      /* Gender */
      System.out.println("What is your gender?");
      String gender = input.nextLine();

      /* To prevent extra spaces from effecting input */
      String trimGender = gender.trim();

      /* Validating gender */
      Boolean genValid = validateGender(trimGender);

      while(genValid == false){
         System.out.println("I am a simple machine, I didn't understand that. Please re-enter your gender, make sure you enter either 'Male' or 'Female' and that there aren't any extra spaces.");
         String g = input.nextLine();
         String trimG = g.trim();
         genValid = validateGender(trimG);
         trimGender = trimG;
      }

      /* Date of Birth */
      System.out.println("What is your Date of Birth (dd/MM/yyyy)?");
      String dob = input.nextLine();
      String trimDob = dob.trim();

      /* Validating Date of Birth */

      Boolean dateValid = validateDob(trimDob);

      while(dateValid == false){
         System.out.println("I didn't understand that. Please input your DOB in this format: date/month/year.");
         String d = input.nextLine();
         String trimD = d.trim();
         dateValid = validateDob(trimD);
         trimDob = trimD;
      }

     /* Attempt at Error handling & Validating DOB*/
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
     /* try {
         GregorianCalendar gc = new GregorianCalendar();
         gc.setLenient(false);  // important*/

         /* Splitting input into an array based on the '/' */
       /*  String str[] = trimDob.split("/");
         int day = Integer.parseInt(str[0]);
         int month = Integer.parseInt(str[1]);
         int year = Integer.parseInt(str[2]);
         gc.set(GregorianCalendar.YEAR, year);
         gc.set(GregorianCalendar.MONTH, month);
         gc.set(GregorianCalendar.DATE, day);

         gc.getTime();
      }
      catch (Exception e) {
         System.out.println("I didn't understand that. Please input DOB in this format: dd/mm/yyyy");
         String c = input.nextLine();
         d = c;
      }
      */

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
         System.out.println("Please re-enter your height (inches) and make sure it's bigger than 0, but less than 108 inches.");
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

      /* Validating weight */
      Boolean weightValid = validateWeight(weight);

      while(weightValid == false){
         System.out.println("Please re-enter your weight and make sure it's bigger than 0, but does not exceed 1,345.");
         double w = input.nextDouble();
         weightValid = validateWeight(w);
         weight = w;
      }

      /* Instantiating the object */
      HealthProfile profile = new HealthProfile(firstName, lastName, trimGender, trimDob, height, weight);

      /* Getting paramaters to find age */
      int birthYear = profile.yearBirth();
      int birthMonth = profile.monthBirth();
      int birthDay = profile.dayBirth();

      /* Determining user's age */
      int age = profile.age(year(), month(), day(), birthYear, birthMonth, birthDay);

      /* Calculating BMI */
      double bmi = profile.bmi();

      /* Determining max heart rate based on age */
      int maxHeart = profile.maxHeartRate(age);

      /* Finding the range of target heart rate for the user */
      String targetHeart = profile.targetHeartRate(maxHeart);

      /* Printing out users Health Data along with previous functions */
      String name = profile.personalInfo();
      System.out.println(name+'\n'+"Approximate Age: "+age+'\n'+"BMI: "+bmi+'\n'+"Maximum Heart Rate: "+maxHeart+'\n'+"Target Heart Rate Range: "+targetHeart);

   }

}
