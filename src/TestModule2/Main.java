package TestModule2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerPhoneBook managerPhoneBook = new ManagerPhoneBook();
        while (true) {
           managerPhoneBook.menu();
            int choice = -1;
            while (choice == -1) {
                try {
                    System.out.println("........!  Nhập lựa chọn : !.........: ");
                    choice = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println(" nhập vào số đi : " + ex.getMessage());
                } finally {
                    scanner.nextLine();
                }
            }
            switch (choice) {
                case 1:
                    managerPhoneBook.display();
                    break;
                case 2:
                    System.out.println("Thông tin của danh bạ:");
                    System.out.print("Nhập số điện thoại (VD:0987.654.321): ");
                    String phone = scanner.nextLine();
                    int index;
                    boolean check;
                    do {
                        index = managerPhoneBook.searchByPhone(phone);
                        check = Validate.valid(phone,Validate.PHONE_REGEX);
                        if (!check) {
                            System.out.print("Nhập sai định dạng, nhập lại (VD:0987.654.321): ");
                            phone = scanner.nextLine();
                        } else if (index != -1) {
                            System.out.print("Trùng số điện thoại, nhập lại: ");
                            phone = scanner.nextLine();
                        }
                    } while (!check || index != -1);
                    System.out.println("Nhập thông tin mới");
                    PhoneBook phoneBook = InputOutput.input();
                    phoneBook.setPhone(phone);
                    managerPhoneBook.add(phoneBook);
                    System.out.println("Thêm thành công");
                    break;
                case 3:
                    System.out.print("Nhập số điện thoại muốn sửa: ");
                    phone = scanner.nextLine();
                    System.out.println("Nhập thông tin cần sửa");
                    managerPhoneBook.update(phone);
                    break;
                case 4:
                    System.out.print("Nhập số điện thoại muốn xóa: ");
                    phone = scanner.nextLine();
                    managerPhoneBook.delete(phone);
                    break;
                case 5:
                   managerPhoneBook.searchMenu();
                    int option = -1;
                    while (option == -1) {
                        try {
                            option = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.err.print("Nhập sai kiểu dữ liệu, nhập lại: ");
                        } finally {
                            scanner.nextLine();
                        }
                    }
                    break;
                case 6:
                    System.out.println("Bạn có muốn cập nhật lại danh bạ trong bộ nhớ?");
                    System.out.println("(Thao tác này sẽ xóa toàn bộ danh bạ trong bộ nhớ)");
                    System.out.print("Nhập Y để đồng ý: ");
                    String answer = scanner.nextLine();
                    if (answer.equals("Y")) {
                        List<PhoneBook> phoneBookList = File.readToFile("data\\contacts.csv");
                        managerPhoneBook.setPhoneBookList(phoneBookList);
                    }
                    break;
                case 7:
                    System.out.println("Bạn có muốn cập nhật lại file danh bạ?");
                    System.out.print("Nhập Y để đồng ý: ");
                    answer = scanner.nextLine();
                    if (answer.equals("Y")) {
                        File.writeToFile("data\\contacts.csv", managerPhoneBook.findAll());
                    }
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Sai chức năng");
            }

        }
    }



}
