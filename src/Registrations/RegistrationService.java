package Registrations;

import Operations.Calculator;

public class RegistrationService {


    private final RegistrationUsers registrationUsers = new FileRegistrationUsers();

    private Calculator calculator = new Calculator();

    public Users registration(Users users) {
        switch (users.getChoose()) {
            case 1:
                registrationUsers.save(users);
                calculator.calculation(users);
                return users;
            case 2:
                boolean check = registrationUsers.check(users);
                if (check) {
                    calculator.calculation(users);
                    return users;
                }
                break;
            case 3:
                System.out.println("Demo version...");
                calculator.calculation(users);
        }
                return null;
    }
}
