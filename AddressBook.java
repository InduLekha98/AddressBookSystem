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
    private int PhoneNumber;
    private String Email;
    private HashMap contact;

    public AddressBook(String FirstName, String LastName, String Address, String City, int Zip,
                           String State, int PhoneNumber, String Email) {
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
        contact.put(FirstName, entry);
        System.out.println(entry);
        System.out.println(contact);
        return contacts;
    }

    private static void getContact(AddressBook details) {
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
        details.PhoneNumber = obj.nextInt();
        obj.nextLine();
        System.out.println("Enter you email name");
        details.Email = obj.nextLine();
    }

    private void editContacts(HashMap contacts) {
        System.out.println(contacts);
        Scanner obj = new Scanner(System.in);
        System.out.println("enter your name");
        String name = obj.next();
        System.out.println(contact.get(name));
    }

    @Override
    public String toString() {
        return FirstName;
    }

    public static void main(String[] args) {
        AddressBook contacts = new AddressBook();
        HashMap<String, ArrayList<String>>  = new HashMap<String, ArrayList<String>>();
        getContact(contacts);
        HashMap<String, ArrayList<String>> data = contacts.storeContacts(contacts);
        contacts = data;
        System.out.println(contacts);
    }
}
