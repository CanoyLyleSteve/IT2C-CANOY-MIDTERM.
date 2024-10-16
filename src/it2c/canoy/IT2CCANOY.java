package it2c.canoy;

import java.util.Scanner;

public class IT2CCANOY {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
      
        
        Project project = new Project();
        
        while (true) {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. BACK");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    project.addRecord();
                    break;
                case 2:
                    project.viewRecord();
                    break;
                case 3:
                    project.viewRecord();
                    project.updateRecord();
                    break;
                case 4:
                    project.viewRecord();
                    project.deleteRecord();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageLibrary(Scanner sc) {
        Library library = new Library();

        while (true) {
            System.out.println("1. ADD BOOK");
            System.out.println("2. VIEW BOOKS");
            System.out.println("3. UPDATE BOOK");
            System.out.println("4. DELETE BOOK");
            System.out.println("5. BACK");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();

            switch (action) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    library.updateBook();
                    break;
                case 4:
                    library.deleteBook();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static class Project {

        public Project() {
        }

        private void addRecord() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void viewRecord() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void updateRecord() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void deleteRecord() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}



class Library {
    public void addBook() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();

        System.out.print("Enter Book Title: ");
        String title = sc.next();
        System.out.print("Enter Author: ");
        String author = sc.next();
        System.out.print("Enter ISBN: ");
        String isbn = sc.next();
        System.out.print("Enter Availability (true/false): ");
        boolean availability = sc.nextBoolean();
        System.out.print("Enter Published Year: ");
        int publishedYear = sc.nextInt();

        String sql = "INSERT INTO Library (book_title, author, isbn, availability, published_year) VALUES (?, ?, ?, ?, ?)";
        conf.addRecord(sql, title, author, isbn, availability, publishedYear);
    }

    public void viewBooks() {
        String qry = "SELECT * FROM Library";
        String[] hdrs = {"Book Title", "Author", "ISBN", "Availability", "Published Year"};
        String[] clmns = {"book_title", "author", "isbn", "availability", "published_year"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clmns);
    }

    public void updateBook() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Book ID to Update: ");
        int id = sc.nextInt();
        System.out.print("Enter New Book Title: ");
        String title = sc.next();
        System.out.print("Enter New Author: ");
        String author = sc.next();
        System.out.print("Enter New ISBN: ");
        String isbn = sc.next();
        System.out.print("Enter New Availability (true/false): ");
        boolean availability = sc.nextBoolean();
        System.out.print("Enter New Published Year: ");
        int publishedYear = sc.nextInt();

        String qry = "UPDATE Library SET book_title = ?, author = ?, isbn = ?, availability = ?, published_year = ? WHERE library_id = ?";
        config conf = new config();
        conf.updateRecord(qry, title, author, isbn, availability, publishedYear, id);
    }

    public void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM Library WHERE library_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
    }
}

