package 老马书城数据库版;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while(true) {
            System.out.println("-----欢迎来到老马书城-----");
            System.out.println("1,查询书籍");
            System.out.println("2,查询所有书籍");
            System.out.println("3,删除书籍");
            System.out.println("4,退出应用");
            System.out.println("请输入你想要执行的功能序号：");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            if(choice == 1) {
                System.out.println("请写入书籍编号：");
                int no = scanner.nextInt();
                Book book = findBookByNo(no);
                if(book == null) {
                    System.out.println("查询的书籍不存在。");
                } else  {
                    System.out.println("查询到一本书，名字叫做 《" + book.getName() + "》");
                }
            }
            if(choice == 2) {
                ArrayList allBooks = findAllBooks();
                if(allBooks.size() == 0) {
                    System.out.println("没有一本书");
                } else {
                    for (int i = 0; i < allBooks.size(); i++) {
                        Book book = (Book) (allBooks.get(i));
                        System.out.println(book.getId() + "---" + book.getName() + "---" + book.getAuthor() + "---" + book.getPrice());
                    }
                }

            }
            if(choice == 3) {
                System.out.println("请写入书籍编号：");
                int no = scanner.nextInt();
                int i = deleteBookById(no);
                if(i > 0) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            }
            if(choice == 4) {
                System.out.println("退出系统应用。");
                break;
            }
        }
    }

    public static Book findBookByNo(int no) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/msb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowpublickeyretrieval=true";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM t_table where id = " + no);
        Book book = null;
        if(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            double price = resultSet.getDouble("price");

            book = new Book();
            book.setId(id);
            book.setName(name);
            book.setAuthor(author);
            book.setPrice(price);

        }
        statement.close();
        connection.close();
        return book;
    }

    public static ArrayList findAllBooks() throws ClassNotFoundException, SQLException {
        ArrayList arrayList = new ArrayList();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/msb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowpublickeyretrieval=true";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM t_table");

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            double price = resultSet.getDouble("price");

            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setAuthor(author);
            book.setPrice(price);
            arrayList.add(book);
        }
        statement.close();
        connection.close();
        return arrayList;
    }

    public static int deleteBookById(int no) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/msb?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowpublickeyretrieval=true";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate("delete from t_table where id = " + no);

        statement.close();
        connection.close();
        return i;
    }
}