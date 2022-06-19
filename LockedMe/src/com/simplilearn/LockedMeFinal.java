package com.simplilearn;
import java.io.File;
import java.util.Scanner;


public class LockedMeFinal {
	public static final String myPath = "E:\\New folder\\LockedMe";
	public static final String errorMsg = "Error occured: pls connect admin \badmin@simplilearn.com";
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		displayPage();
		String ss = sc.nextLine();
	}

	public static void displayPage() {
		System.out.println(
				"#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*# WELCOME TO LOCKEDME.COM #*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*");
		System.out.println("\t\t\t\t\tDeveloped by: \bBAGMITA BARUAH\b");
		System.out.println(
			          "#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*##*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#*#");
		System.out.println();
		System.out.println("Select any one option: ");
		System.out.println("\t\t 1.Show all files from root directory");
		System.out.println("\t\t 2.Add, Delete or search any file.");
		System.out.println("\t\t 3.EXIT from the application");
		int input = sc.nextInt();
//		int option=sc.nextInt();
		if (input == 1) {
			displayFiles();
			sc.nextLine();
		} else if (input == 2) {
			DisplayMenu();
		} else if (input == 3)
			System.exit(0);
		else {
			System.out.println("Pls Enter valid input.");
		}
	}

	public static void displayFiles() {
		try {

			File file = new File(myPath);
			File[] listOfFile = file.listFiles();
			if (listOfFile.length == 0) {
				System.out.println("No Files Present in the directory");
			} else {
				System.out.println("Below are the files present in the directory:");

				for (var i : listOfFile) {
					System.out.println("\t" + i.getName());
				}
			}
		} catch (Exception ex) {
			System.out.println(errorMsg);
		}

	}

	public static void DisplayMenu() {

		System.out.println("Select any one option from below menu: ");
		System.out.println("\t1.Add a user file");
		System.out.println("\t2.Delete a user file");
		System.out.println("\t3.Search a user file");
		System.out.println("\t4.Go to previous Menu");

		int input1 = sc.nextInt();
		if (input1 == 1) {
			addFile();
			sc.nextLine();
		} else if (input1 == 2) {
			deleteFile();
			sc.nextLine();
		} else if (input1 == 3) {
			searchFile();
			sc.nextLine();
		} else if (input1 == 4) {
			displayPage();
			sc.nextLine();
		} else
			System.out.println("Pls Enter valid Input");
		sc.nextLine();

	}

	public static void deleteFile() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter file name to be deleted");
			String fname = sc.nextLine();
			File file = new File(myPath + "//" + fname);
			if (file.exists()) {
				file.delete();
				System.out.println(fname + " deleted successfully");
			} else {
				System.out.println("File Name not found");
			}
		} catch (Exception ex) {
			System.out.println(errorMsg);
		}
	}

	public static void addFile() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter file name to be added");
			String fname = sc.nextLine();
			File file = new File(myPath + "//" + fname);

			file.createNewFile();
			System.out.println(fname + " Created successfully");

		} catch (Exception ex) {
			System.out.println(errorMsg);
		}
	}

	public static void searchFile() {
		Scanner sc = new Scanner(System.in);
		try {
			boolean isOk = false;
			System.out.println("Enter file name to be search");
			String fname = sc.nextLine();
			File file = new File(myPath);
			File[] listOfFile = file.listFiles();
			for (var i : listOfFile) {

				if (i.getName().equalsIgnoreCase(fname)) {
					isOk = true;
					System.out.println(i.getName() + " present in directory");
					break;
				}

			}
			if (isOk != true)
				System.out.println("File " + fname + " not found in the directory");
		} catch (Exception ex) {
			/* System.out.println(errorMsg); */
			ex.getStackTrace();
		}
	}
}
