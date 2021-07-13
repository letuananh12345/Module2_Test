package TestModule2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerPhoneBook {

        private List<PhoneBook> phoneBookList;

        public ManagerPhoneBook() {
            phoneBookList = new ArrayList<>();

        }

        public void setPhoneBookList(List<PhoneBook> phoneBookList) {
            this.phoneBookList = phoneBookList;
        }

        public void add(PhoneBook phoneBook) {
            this.phoneBookList.add(phoneBook);
        }

        public List<PhoneBook> findAll() {
            return this.phoneBookList;
        }

        public void display() {
            for (PhoneBook phoneBook : this.phoneBookList) {
                InputOutput.output(phoneBook);
            }
        }

        public void update(String phone) {
            int index = searchByPhone(phone);
            if (index != -1) {
                PhoneBook phoneBook = InputOutput.input();
                phoneBook.setPhone(phone);
                this.phoneBookList.set(index, phoneBook);
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            }
        }

        public void delete(String phone) {
            Scanner scanner = new Scanner(System.in);
            int index = searchByPhone(phone);
            if (index == -1) {
                System.out.println("Không tìm được danh bạ với số điện thoại trên.");
            } else {
                InputOutput.output(this.phoneBookList.get(index));
                System.out.print("Bạn có muốn xóa danh bạ này?");
                String answer = scanner.nextLine();
                if (answer.equals("Y")) {
                    phoneBookList.remove(index);
                    System.out.println("Xóa thành công");
                } else {
                    System.out.println("Xóa thất bại");
                }
            }
        }

        public int searchByPhone(String phone) {
            for (int i = 0; i < this.phoneBookList.size(); i++) {
                if (this.phoneBookList.get(i).getPhone().equals(phone)) {
                    return i;
                }
            }
            return -1;
        }
    void menu() {
        System.out.println("........<!.Quản Lý Danh Bạ.!>..............");
        System.out.println("1.Xem Danh Sách : ");
        System.out.println("2.Thêm Mới : ");
        System.out.println("3.Cập Nhật : ");
        System.out.println("4. Xóa : ");
        System.out.println("5. Tìm Kiếm : ");
        System.out.println("6.Đọc Từ File : ");
        System.out.println("7.Ghi Vào File : ");
        System.out.println("8. Thoát : ");
    }

     void searchMenu() {
        System.out.println("----Tìm kiếm-----");
        System.out.println("1. Theo số điện thoại");
        System.out.println("2. Theo tên");
        System.out.print("Chọn chức năng: ");
    }


        }



