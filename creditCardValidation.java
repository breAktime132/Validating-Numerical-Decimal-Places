import java.util.Scanner;                                                                                                    // Allows for user input.
public class creditCardValidation{                                                                                           // Content of file creditCardValidation.
   public static void main (String [] args){                                                                                 // Main method.
      Scanner input = new Scanner(System.in);                                                                                // Creates a scanner that will get user input for this function only.
      long userNumber = 0;                                                                                                   // Creates a long variable that will hold the user input (credit card number).
      int count = 0;                                                                                                         // Creates an integer variable that stores the length of userNumber.
      long sumOfDoubledNumbers = 0;                                                                                          // Creates a long variable that will store the sum of every second integer doubled (if result is less than two digits) or doubled and the resulting two digits are added together.
      long sumOfOddNumbers = 0;                                                                                              // Creates a long variable that will store the sum of every odd integer.
      long creditCardValidationNumber = 0;                                                                                   // Creates a long variable that will be used to store the sum of both long variables, sumOfDoubledNumbers and sumOfOddNumbers.
      System.out.println("Please enter your 13-16 digit credit card number, with no spaces or any key other than a number"); // Asks for user input between 13 and 16 digits.
      userNumber = input.nextLong();                                                                                         // The long variable userNumber stores the credit card number entered by the user.                                         
      count = findLength(userNumber);                                                                                        // The integer variable calls the function findLength and stores the integer return value of the length of userNumber.
      if(count <= 16 && count >= 13){                                                                                        // If the credit card number has a length between 13 and 16 integers...
         System.out.println("The number of digits is: " + count + " digits. Loading...");                                    // Tells the user the number of digits they typed.
         sumOfDoubledNumbers = doubleInteger(userNumber, count);                                                             // Stores the sum of every second number of the credit card number right to left (or, if the result of doubling is a two-digit number, those two numbers are added together).        
         sumOfOddNumbers = addInteger(userNumber);                                                                           // Stores the sum of every odd number right to left.
         creditCardValidationNumber = sumOfDoubledNumbers + sumOfOddNumbers;                                                 // Stores the sum of the long variables sumOfDoubledNumbers and sumOfOddNumbers.
         if(creditCardValidationNumber % 10 == 0){                                                                           // If that number is divisble by 10...
            System.out.println("The number is valid");                                                                       // The console displays that the number is valid.
         }else{                                                                                                              // Otherwise, if the number is not divisible by 10...
            System.out.println("The number is invalid");                                                                     // The console displays that the number is invalid.
         }
         nameCreditCard(userNumber, count);                                                                                  // Passes the credit card number and its length as an integer to find the credit card length.
      }else{                                                                                                                 // Otherwise, if the credit card number does not have a length between 13 and 16 integers...
         System.out.println("That number is not between 13 and 16 integers.");                                               // The console will simply display to the user that they have entered an invalid length.
      }
   }
   public static int findLength(long userNumber){                                                                            // Creates the function, findLength, to find the length of the credit card number.
      int count = 0;                                                                                                         // Stores the number of times the credit card number is divided by 10 to erase all digits, which would be the length.
      while(userNumber != 0){                                                                                                // While the credit card number is not yet equal to zero...
         userNumber = userNumber / 10;                                                                                       // It is divided by 10, and this removes one number right to left as there are no decimals in the integer type used for userNumber. This continues until userNumber is zero.
         count ++;                                                                                                           // Every time userNumber is divided by 10, the variable count will increase by 1, thereby counting the number of digits in userNumber.
      }
      return count;                                                                                                          // Returns the length of userNumber to the main method.
   }
   public static long doubleInteger(long userNumber, int count){                                                             // Creates a function that will double every second integer right to left, or add the two digits together if the doubled result is a two-digit number.
      long doubleInteger = 0;                                                                                                // Will hold the value of every second digit and when it is doubled.                                              
      long doubleInteger1 = 0;                                                                                               // Will hold the value of every second digit that, when doubled, will be a double-digit number.
      long doubleIntegerReference = 0;                                                                                       // Only for reference, and not used in the main, validating algorithm: will hold the value of a doubled number, and then an if statement checks to see if it is a two-digit number.
      long sum = 0;                                                                                                          // Will hold the value of the sum of the two digits of a doubled number if that number is two digits in length.
      long sum1 = 0;                                                                                                         // Will hold the value of the sum of both every second digit that has been doubled, and later also the sum of every second digit whose two-digit product was added together.
      long firstNumber = 0;                                                                                                  // If the digit, when doubled, becomes a two-digit number, the first number is stored in firstNumber.
      long secondNumber = 0;                                                                                                 // If the digit, when doubled, becomes a two-digit number, the second number is stored in secondNumber.
      long temp = 0;                                                                                                         // Used to temporarily store a digit from doubleInteger1 in order to double it.
      while(userNumber != 0){                                                                                                // While userNumber is not yet zero (divides by 100 to get the next group of digits)...
         doubleInteger = userNumber % 100;                                                                                   // The variable doubleInteger stores the last two digits of userNumber, regardless of whether it has been shortened after going through the while loop.
         doubleIntegerReference = userNumber % 100;                                                                          // The variable doubleIntegerReference also stores the last two digits of userNumber, regardless of userNumber's length.
         doubleIntegerReference = doubleInteger / 10;                                                                        // The variable doubleIntegerReference stores the first of the two digits, or the second digit right to left.
         if(doubleIntegerReference * 2 >= 10){                                                                               // If doubleIntegerReference, when multiplied by 2, will be a two-digit number, then...
            doubleInteger1 = userNumber % 100;                                                                               // A seperate variable, doubleInteger1, stores the last two digits of userNumber.
            doubleInteger1 = doubleInteger1 / 10;                                                                            // The first of the two digits (second digit right to left) is stored in doubleInteger1.
            doubleInteger1 = doubleInteger1 * 2;                                                                             // The first digit is then doubled.
            firstNumber = doubleInteger1 / 10;                                                                               // From that value, the first digit of the two-digit product is stored in firstNumber.
            secondNumber = doubleInteger1 % 10;                                                                              // From that value, the second digit of the two-digit product is stored in secondNumber.
            sum1 = firstNumber + secondNumber + sum1;                                                                        // The variable sum1 stores the sum of firstNumber and secondNumber, as well as itself to add previous totals when the while loop runs more than once.
         }else{                                                                                                              // If doubleIntegerReference, when multiplied by 2, will not be a two-digit number...
            doubleInteger = doubleInteger / 10;                                                                              // The last two digits of userNumber, stored in doubleInteger, are divided by 10. This gets the first of the two digits and this value replaces the previous value in doubleInteger.
            doubleInteger = doubleInteger * 2;                                                                               // The first digit, now found in doubleInteger, is multiplied by 2.
            sum = sum + doubleInteger;                                                                                       // The variable doubleInteger is added to sum, which is the total of all doubled digits (including previous loops) that are not true according to the condition in the if statement.
         }
         userNumber = userNumber / 100;                                                                                      // Every time the while loop runs, userNumber is shortened by two digits, since a long integer does not allow for decimals when dividing by 10, so that the next group of digits can be compared.
      }
      sum = sum + sum1;                                                                                                      // The variable sum stores both the sum of all doubled digits and the sum of all two-digit, doubled numbers in which their two digits were then added together.
      return sum;                                                                                                            // Returns the entire total back to the main method.
   }
   public static long addInteger(long userNumber){                                                                           // Creates the function addInteger, which will add every odd digit of the long variable passed, userNumber (credit card number), from right to lef
      long oddInteger = 0;                                                                                                   // Creates the long variable oddInteger that will store every odd digit of userNumber, right to left.
      long total = 0;                                                                                                        // Takes the sum of all odd digits until userNumber is zero.
      while(userNumber != 0){                                                                                                // While userNumber is not equal to zero...
         oddInteger = userNumber % 100;                                                                                      // The variable oddInteger will store the last two digits of userNumber.
         oddInteger = oddInteger % 10;                                                                                       // From these two digits, the first digit (which is odd) from right to left is stored in oddInteger.
         total = total + oddInteger;                                                                                         // Every time the while loop runs, a new odd digit is added to the variable total.
         userNumber = userNumber / 100;                                                                                      // The credit card number passed is shortened by two digits to compare the next odd and even digit.
      }
      return total;                                                                                                          // Returns the total of all odd digits of the credit card number added together
   }
   public static void nameCreditCard(long userNumber, int count){                                                            // Creates a method that will recieve arguments for the credit card number (long variable userNumber) and its length (variable count), and name the type according to the first digit.
      int LCV = 0;                                                                                                           // Loop Control Variable that will set the conditions for the loops in this method.
      long userNumber2 = userNumber;                                                                                         // Another long variable is created and will hold the same value as userNumber, but it is used seperately.
      for(LCV = 0; LCV < count - 1; LCV++){                                                                                  // Divides by 10 right to left until the first number (one number from the entire length, or count).
         userNumber = userNumber / 10;                                                                                       // Removes one digit from right to left.
      }
      if(userNumber == 4){                                                                                                   // If the first number is 4...
         System.out.println("Visa card");                                                                                    // The console will display to the user that the credit card number entered is that of a visa card.
      }else if(userNumber == 5){                                                                                             // If the first number is 5...
         System.out.println("Master card");                                                                                  // The console will display that the card number entered is that of a Master card.
      }else if(userNumber == 6){                                                                                             // If the first number is six...
         System.out.println("Discover card");                                                                                // The console will display that the card number entered is that of a Discover card...
      }else if(userNumber == 3){                                                                                             // If the first number is 3...
         for(LCV = 0; LCV < count - 2; LCV++){                                                                               // The variable userNumber2 will divide by 10 until the second to last number.
            userNumber2 = userNumber2 / 10;                                                                                  // Removes one digit right to left every time the loop runs and stores it in userNumber2.
         }
         userNumber2 = userNumber2 % 10;                                                                                     // Takes the last of the two numbers stored in userNumber2 to get the second digit.
         if(userNumber2 == 7){                                                                                               // If the second digit is a 7 (in addition to the first digit being a 3)...
            System.out.println("American Express card");                                                                     // The console will display that the credit card number is that of an American Express card.
         }
      }
   }
}