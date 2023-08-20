package Registrations;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRegistrationUsers implements RegistrationUsers{

    private File file = new File("res/UsersList/Userss.txt");


    @Override
    public void save(Users users) {
        try (FileWriter wf = new FileWriter(file,true)){
            wf.write(users.getUserName()
            +" "+users.getPassword()
            +"\n");
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    @Override
    public boolean check(Users users){
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()){
                String[]listUsers = sc.nextLine().split(" ");
                if (listUsers[0].equalsIgnoreCase(users.getUserName())&&listUsers[1].equalsIgnoreCase(users.getPassword())){
                    System.out.println("Username and Password is OK ");
                    return true;
                }
            }
            System.out.println("Enter Username or Password is wrong ");
            return false;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
}
