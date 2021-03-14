import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
    private String FirstName;
    private String LastName;
    private String Address;
    private int Zip;
    private String City;
    private String State;
    private long PhoneNumber;
    private String Email;
    private HashMap contacts;

    public AddressBook(String FirstName, String LastName, String Address, String City, int Zip,
                           String State, long PhoneNumber, String Email) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.Zip = Zip;
        this.City = City;
        this.State = State;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
    }

    public AddressBook() {
    }

    private static void getContacts(AddressBook details) {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter you first name");
        details.FirstName = obj.next();
        System.out.println("Enter you last name");
        details.LastName = obj.next();
        obj.nextLine();
        System.out.println("Enter you Address name");
        details.Address = obj.nextLine();
        System.out.println("Enter you zip ");
        details.Zip = obj.nextInt();
        System.out.println("Enter you city name");
        details.City = obj.next();
        System.out.println("Enter you state name");
        details.State = obj.next();
        obj.nextLine();
        System.out.println("Enter you phone number");
        details.PhoneNumber = obj.nextLong();
        obj.nextLine();
        System.out.println("Enter you email name");
        details.Email = obj.nextLine();
    }

    public static void editContacts(HashMap contacts) {
        System.out.println(contacts);
        Scanner obj = new Scanner(System.in);
        System.out.println("enter your name");
        String name = obj.next();
        ArrayList option = (ArrayList) (contacts.get(name));
        boolean conditon = true;
        while (conditon) {
            System.out.println("enter number to edit 0-firstname 1-lastname 2-address 3-zip 4-city 5-state 6-phone number 7-email" +
                    " 9 to quit");
            int check = obj.nextInt();
            switch (check) {
                case 0:
                    System.out.println("Enter you first name");
                    option.set(0, obj.next());

                    break;
                case 1:
                    System.out.println("Enter you last name");
                    option.set(1, obj.next());
                    obj.nextLine();
                    break;
                case 2:
                    System.out.println("Enter you Address name");
                    option.set(2, obj.nextLine());
                    break;
                case 3:
                    System.out.println("Enter you zip ");
                    option.set(3, obj.nextInt());
                    break;
                case 4:
                    System.out.println("Enter you city name");
                    option.set(4, obj.next());
                    break;
                case 5:
                    System.out.println("Enter you state name");
                    option.set(5, obj.next());
                    obj.nextLine();
                    break;
                case 6:
                    System.out.println("Enter you phone number");
                    option.set(6, obj.nextLong());
                    obj.nextLine();
                    break;
                case 7:
                    System.out.println("Enter you email name");
                    option.set(7, obj.next());
                    break;
                case 9:
                    conditon = false;
                    break;
                default:
                    System.out.println("invalid input");
            }
            if (name != (contacts.get(name))) {
                Object newname = option.get(0);
                contacts.remove(name);
                contacts.put(newname, option);
            }
        }
    }

    public HashMap storeContacts(HashMap contacts) {
        ArrayList<String> entry = new ArrayList<String>();
        entry.add(FirstName);
        entry.add(LastName);
        entry.add(Address);
        entry.add(String.valueOf(Zip));
        entry.add(City);
        entry.add(State);
        entry.add(String.valueOf(PhoneNumber));
        entry.add(Email);
        contacts.put(FirstName, entry);
        System.out.println(entry);
        System.out.println(contacts);
        return contacts;
    }

    @Override
    public String toString() {
        return FirstName;
    }

    public static boolean makechoice(AddressBook contacts, HashMap contact) {
        Scanner obj = new Scanner(System.in);
        System.out.println("enter 1 to add contact 2 to edit or 0 to quit");
        int check = obj.nextInt();
        boolean conditon = true;
        switch (check) {
            case 1:
                getContacts(contacts);
                HashMap<String, ArrayList<String>> data = contacts.storeContacts(contact);
                contact = data;
                break;
            case 2:
                displayStore(contact);
                break;
            case 3:
                editContacts(contact);
                break;
            case 0:
                conditon = false;
                break;
            default:
                System.out.println("invalid input");
        }
        return conditon;
    }

    public static void displayStore(HashMap contacts) {
        System.out.println(contacts);
    }

    public static void main(String[] args) {
        AddressBook contacts = new AddressBook();
        HashMap<String, ArrayList<String>> contact = new HashMap<String, ArrayList<String>>();
        System.out.println(contact);
        boolean conditon = true;
        while (conditon) {
            boolean condition = makechoice(contacts, contact);
            if (condition == false)
                break;
        }
    }
}
