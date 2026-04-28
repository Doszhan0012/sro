import java.io.*;
import java.util.Scanner;

public class sro {

    // негізгі файл
    static String mainFile = "data.txt";

    // backup файл
    static String backupFile = "backup.txt";

    // ===== BACKUP FUNCTION =====
    public static void backup() {

        try (
                FileInputStream in = new FileInputStream(mainFile);
                FileOutputStream out = new FileOutputStream(backupFile)
        ) {
            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

            System.out.println("Backup created successfully!");

        } catch (IOException e) {
            System.out.println("Backup error!");
        }
    }

    // ===== RESTORE FUNCTION =====
    public static void restore() {

        try (
                FileInputStream in = new FileInputStream(backupFile);
                FileOutputStream out = new FileOutputStream(mainFile)
        ) {
            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

            System.out.println("Data restored successfully!");

        } catch (IOException e) {
            System.out.println("Restore error!");
        }
    }

    // ===== WRITE DATA =====
    public static void writeData(String text) {

        try (FileWriter writer = new FileWriter(mainFile,true)) {
            writer.write(text + "\n");
        } catch(IOException e){
            System.out.println("Write error!");
        }
    }

    // ===== MENU =====
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n1 - Add Data");
            System.out.println("2 - Backup");
            System.out.println("3 - Restore");
            System.out.println("4 - Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    System.out.print("Enter data: ");
                    String text = sc.nextLine();
                    writeData(text);
                    break;

                case 2:
                    backup();
                    break;

                case 3:
                    restore();
                    break;

                case 4:
                    System.out.println("Program finished");
                    return;

                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}