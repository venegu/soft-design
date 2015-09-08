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

import java.util.Scanner;

public class HealthProfile {

   String firstName;
   String lastName;
   String gender;

   HealthProfile(String firstName, String lastName, String gender){
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
   }

   public String list(){
      return "\n"+firstName+" "+lastName;
   }
   //public String maxHeartRate(){
     // return max;
   //}
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // create Scanner to obtain input from command window
      Scanner input = new Scanner(System.in);

      System.out.println("What is your first name?");
      String firstName = input.nextLine();

      System.out.println("What is your last name?");
      String lastName = input.nextLine();

      System.out.println("What is your gender?");
      String gender = input.nextLine();

      System.out.println("Enter the month of your date of birth:");
      String month = input.nextLine();
      System.out.println("Enter the day of your date of birth:");
      int day = input.nextInt();
      System.out.println("Enter the year of your date of birth (Entire year please):");
      int year = input.nextInt();

      System.out.println("What is your height (ft)?");
      int height = input.nextInt();

      System.out.println("What is your weight (lbs)?");
      int weight = input.nextInt();

      System.out.println('\n'+firstName+" "+lastName+'\n'+gender+'\n'+month+" "+day+" "+year+'\n'+height+'\n'+weight);

      HealthProfile profile = new HealthProfile(firstName, lastName, gender);
      String name = profile.list();

      System.out.println(name);
   }

}