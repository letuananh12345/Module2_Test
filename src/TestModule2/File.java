package TestModule2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    public static void writeToFile(String path, List<PhoneBook> phoneBookList) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String str = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email\n";
            for (PhoneBook phoneBook : phoneBookList) {
                str += phoneBook.getPhone() + "," + phoneBook.getGroup() + "," + phoneBook.getFullName() + "," + phoneBook.getGender() +
                        "," + phoneBook.getAddress() + "," + phoneBook.getDateOfBirth() + "," + phoneBook.getEmail() + "\n";
            }
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file: " + e.getMessage());
        }
    }

    public static List<PhoneBook> readToFile(String path) {
        List<PhoneBook> phoneBookList = null;
        try {
            phoneBookList = new ArrayList<>();
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                phoneBookList.add(new PhoneBook(str[0], str[1], str[2], str[3], str[4], str[5], str[6]));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Không tìm thấy file");
        }
        return phoneBookList;
    }

}

