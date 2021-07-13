package TestModule2;

import java.util.Scanner;

public class InputOutput {
    public static PhoneBook input() {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        System.out.print("Nhập nhóm: ");
        String group;
        do {
            group = scanner.nextLine();
            if (group.equals("")) {
                System.out.print("Nhập lại, không để trống ô nhập: ");
            }
        } while (group.equals(""));
        phoneBook.setGroup(group);
        System.out.print("Nhập họ tên: ");
        String fullName;
        do {
            fullName = scanner.nextLine();
            if (fullName.equals("")) {
                System.out.print("Nhập lại, không để trống ô nhập: ");
            }
        } while (fullName.equals(""));
        phoneBook.setFullName(fullName);
        System.out.print("Nhập giới tính: ");
        String gender;
        do {
            gender = scanner.nextLine();
            if (gender.equals("")) {
                System.out.print("Nhập lại, không để trống ô nhập: ");
            }
        } while (gender.equals(""));
        phoneBook.setGender(gender);
        System.out.print("Nhập địa chỉ: ");
        String address;
        do {
            address = scanner.nextLine();
            if (address.equals("")) {
                System.out.print("Nhập lại, không để trống ô nhập: ");
            }
        } while (address.equals(""));
        phoneBook.setAddress(address);
        System.out.print("Nhập ngày sinh: ");
        String dateOfBirth;
        do {
            dateOfBirth = scanner.nextLine();
            if (dateOfBirth.equals("")) {
                System.out.print("Nhập lại, không để trống ô nhập: ");
            }
        } while (dateOfBirth.equals(""));
        phoneBook.setDateOfBirth(dateOfBirth);
        System.out.print("Nhập email (VD: abc@gmail.com): ");
        boolean check;
        String email = scanner.nextLine();
        do {
            check = Validate.valid(email,Validate.EMAIL_REGEX);
            if (!check) {
                System.out.print(" sai định dạng, nhập lại (VD: abc@gmail.com):");
                email = scanner.nextLine();
            }
        } while (!check);
        phoneBook.setEmail(email);
        return phoneBook;
    }

    public static void output(PhoneBook phoneBook) {
        System.out.println("Số điện thoại: " + phoneBook.getPhone() + ", nhóm: " + phoneBook.getGroup() + ", họ tên: " +
                phoneBook.getFullName() + ", giới tính: " + phoneBook.getGender() + ", địa chỉ: " + phoneBook.getAddress());
    }
}
