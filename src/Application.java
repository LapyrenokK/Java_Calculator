import Readers.ConsoleReader;
import Readers.Reader;
import Registrations.RegistrationService;
import Registrations.Users;
import Writers.ConsoleWriter;
import Writers.Writer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private final Writer consoleWriter = new ConsoleWriter();
    private final Reader consoleReader = new ConsoleReader();

    private String password,username;

    private RegistrationService registrationService = new RegistrationService();


    public void start() {
        consoleWriter.write("Enter for: 1-REGISTRATION, 2-SIGN IN, 3-JUST USE");
        int choose = consoleReader.readInteger();
        if (choose == 1) {

            do {
                consoleWriter.write("Enter username...");
                username = consoleReader.readString();
                if (checkValidationUsername(username)) {
                    System.out.println("Username is valid.");
                    break;
                } else {
                    consoleWriter.write("Invalid Username. Please try again.\n"+
                            "Username: \nMust not contain a special character..\n" +
                            "Valid username length is 4 to 10 characters.\n");
                }
            }while (true);

            do {
                consoleWriter.write("Enter password...");
                password = consoleReader.readString();
                if (checkValidationPassword(password)) {
                    System.out.println("Password is valid.");
                    break;
                } else {
                    consoleWriter.write("Invalid password. Please try again\n."+
                            "Password: \nAt least one large letter.\n" +
                            "At least one small letter.\n" +
                            "At least one figure.\n" +
                            "At least one special character.\n" +
                            "Valid password length is 4 to 10 characters.");
                    System.out.println();
                }
            } while (true);

            Users users = new Users(username, password, choose);
            registrationService.registration(users);
        } else if (choose == 2) {
            consoleWriter.write("Enter username...");
            String username = consoleReader.readString();

            consoleWriter.write("Enter password...");
            String password = consoleReader.readString();

            Users users = new Users(username, password, choose);
            registrationService.registration(users);
        } else if (choose == 3) {
            Users justUse = new Users(choose);
            registrationService.registration(justUse);
        }else return;

    }

    private boolean checkValidationPassword(String password) {

        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{4,10}$";
        return Pattern.matches(regex, password);
    }

    private boolean checkValidationUsername(String username) {

        String regex = "^[a-zA-Z0-9]{4,10}$";
        return Pattern.matches(regex, username);
    }
}