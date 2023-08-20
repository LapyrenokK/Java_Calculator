package Registrations;

public class Users {
    private String userName;
    private String password;

    private int choose;


    public Users(String userName, String password, int choose) {
        this.userName = userName;
        this.password = password;
        this.choose = choose;
    }

    public Users() {
    }

    public Users(int choose) {
        this.choose = choose;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
