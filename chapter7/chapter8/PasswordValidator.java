package chapter8;
/*
*Here's your optional exercise for this chapter. You'll need to verify the strength of a proposed password change.
*The password must be at least eight characters long, contain an uppercase letter, contain a special character,
*not contain the username and not be the same as the old password.
*/

import java.util.Scanner;
public class PasswordValidator {

    private static String userName;
    private static String oldPassword;
    private static String newPassword;
    private static boolean again = true;
    private static boolean samePassword;
    private static boolean includesUsername;

    public static void main(String arg[]){
        //notStrong = checkPassWordStrength(newPassword);

        //get the information
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your usernem:");
        String userName = scanner.next();

        System.out.println("Enter your old password:");
        String oldPassword = scanner.next();

        System.out.println("The password must be at least eight characters long, contain an uppercase letter, " +
                        "contain a special character, not contain the username and not be the same as the old password.");
        System.out.println("Enter your new password:");
        String newPassword = scanner.next();

        boolean includesUsername = newPassword.contains(userName);

        if (includesUsername) {
            do {
                System.out.println("The username is inside of that password, please try again:");
                newPassword = scanner.next();
                includesUsername = newPassword.contains(userName);
            } while (includesUsername);
        }

        boolean same = passwordMatch(oldPassword, newPassword);
        if (same) {
            do {
                System.out.println("New password cannot be the same as the old password. Please try again:");
                newPassword = scanner.next();
                same = passwordMatch(oldPassword, newPassword);
            } while (same);
        }

        boolean notStrong = checkPassWordStrength(newPassword);
        if (notStrong) {
            do {
                System.out.println("New password is not strong enough. Please try again:");
                newPassword = scanner.next();
                notStrong = checkPassWordStrength(newPassword);
                } while (notStrong);
        }


        System.out.println("Thank you for entering your new password.");

        scanner.close();
     }

    public static boolean passwordMatch(String password1, String password2){

        return password1.equals(password2);

    }

    //The password must be at least eight characters long, contain an uppercase letter, contain a special character,
    public static boolean checkPassWordStrength(String password){
        //boolean notStrong;
        boolean capInPassword;
        boolean specialCharacter;

        capInPassword = containsUpperCaseLetter(password);
        specialCharacter = containsSpecialCharacter(password);

        if (password.length()>=8 && capInPassword && specialCharacter)
            return false;
        else
            return true;
    }

    public static boolean containsUpperCaseLetter(String password){
        for(int i=0;i<password.length();i++){
            if(Character.isUpperCase(password.charAt(i))){
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacter(String password){
        String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
        boolean specialCharacter = false;

        for (int i=0; i < password.length() ; i++)
        {
            char ch = password.charAt(i);
            if(specialCharactersString.contains(Character.toString(ch))) {
                specialCharacter = true;
            }
            else if(i == password.length()-1)
                specialCharacter = false;
        }
        return specialCharacter;
    }
}
