package 老马书城;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        while (true) {
            System.out.println("-----欢迎来到老马书城-----");
            System.out.println("1,展示书籍");
            System.out.println("2,上新书籍");
            System.out.println("3,下架书籍");
            System.out.println("4,退出应用");
            System.out.println("请输入你想要执行的功能序号：");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if(choice == 1) {
                System.out.println("老马书城》》》》1,展示书籍");
                File file = new File("C:\\Users\\i'bo'o'o'o'o\\Desktop\\Java\\Java01\\src\\main\\java\\test.txt");
                if(file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    ArrayList arrayList = (ArrayList) (objectInputStream.readObject());

                    for (int i = 0; i < arrayList.size(); i++) {
                        Book item = (Book)(arrayList.get(i));
                        System.out.println(item.getNo() + "---" + item.getName() + "---" + item.getAuthor());
                    }
                } else {
                    System.out.println("当前没有上新书籍。");
                }
            } else if (choice == 2) {
                System.out.println("老马书城》》》》2,上新书籍");

                System.out.println("请输入书籍编号：");
                int no = scanner.nextInt();

                System.out.println("请输入书籍的名字：");
                String name = scanner.next();

                System.out.println("请输入书籍的作者：");
                String author = scanner.next();

                Book book = new Book();
                book.setNo(no);
                book.setName(name);
                book.setAuthor(author);

                File file = new File("C:\\Users\\i'bo'o'o'o'o\\Desktop\\Java\\Java01\\src\\main\\java\\test.txt");
                if(file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    ArrayList arrayList = (ArrayList) (objectInputStream.readObject());

                    arrayList.add(book);

                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(arrayList);
                    objectOutputStream.close();
                } else {
                    ArrayList arrayList = new ArrayList<Book>();
                    arrayList.add(book);

                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(arrayList);
                    objectOutputStream.close();
                }


            } else if (choice == 3) {
                System.out.println("老马书城》》》》3,下架书籍");
                System.out.println("请输入你要下架书籍的编号：");
                int no = scanner.nextInt();
                File file = new File("C:\\Users\\i'bo'o'o'o'o\\Desktop\\Java\\Java01\\src\\main\\java\\test.txt");

                if(file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    ArrayList arrayList = (ArrayList) (objectInputStream.readObject());
                    for (int i = 0; i < arrayList.size(); i++) {
                        Book book = (Book) (arrayList.get(i));
                        if(book.getNo() == no) {
                            arrayList.remove(book);

                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                            objectOutputStream.writeObject(arrayList);
                            objectOutputStream.close();
                            System.out.println("书籍下架成功");
                            break;
                        }

                    }
                } else {
                    System.out.println("没有上新书籍");
                }

            } else if (choice ==4) {
                System.out.println("老马书城》》》》4,退出应用");
                break;
            }
        }


    }
}

