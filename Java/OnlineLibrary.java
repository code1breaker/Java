import java.util.*;

class Library{
    String [] book=new String[10];
    String [] issueBook=new String[10];
    int idx=0;
    int issidx=0;

    public void addBook(String b){
        if(idx!=10){
            book[idx]=b;
            idx++;
            System.out.println(b+" book is added");
        }
        else{
            System.out.println("No more book is added");
        }    
    }

    public void showAvailableBook(){
        if(idx==0)
        System.out.println("No Available Books");
        else{
            System.out.println("Availble Books: ");
            for(int i=0;i!=idx;i++){
                if(book[i]==null)
                continue;
            System.out.println(book[i]);  
            }
        }
    }

    public void issueBook(String iss){
        int flag=0;
        for(int i=0;i!=idx;i++){
            if(iss.equals(book[i])){
                issueBook[issidx]=book[i];
                issidx++;
                System.out.println(iss+ " book is issued");
                book[i]=null;
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println(iss+", book is not available");
        }
    }

    public void showIssuedBook(){
        if(issidx==0)
        System.out.println("No book is issued");
        else{
            System.out.println("Issued Books: ");
            for(int i=0;i!=issidx;i++){
                if(issueBook[i]==null)
                continue;
            System.out.println(issueBook[i]);  
            }
        }
    }

    public void returnBook(String b){
        int flag=0;
        for(int i=0;i!=issidx;i++){
            if(b.equals(issueBook[i])){
                if(idx!=10){
                    book[idx]=issueBook[i];
                    System.out.println(b+" book is returned");
                    idx++;
                    issueBook[i]=null;
                  
                }
                else{
                    for(int j=0;j!=idx;j++){
                        if(book[j]==null){
                            book[j]=issueBook[i];
                            issueBook[i]=null;
                            System.out.println(b+" book is returned");
                            break;
                        }
                    }
                }
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println("Book is never issued");
    }
}

public class OnlineLibrary {
    public static void main(String[] args) {
        Library lib=new Library();
        Scanner sc=new Scanner(System.in);

        while(true){
            System.out.println("Enter 00: Exit 1: Add Book 2: Show Availble Book 3: Issue Book 4: Return Book 5: Show Issued Book");
            int input=sc.nextInt();
            if(input==00){
                System.out.println("Exit...");
                break;
            }
            else if(input==1){
                System.out.print("Enter Your Book: ");
                String addBook=sc.next();
                lib.addBook(addBook);
            }
            else if(input==2){
                lib.showAvailableBook();
            }
            else if(input==3){
                System.out.print("Enter Your Issue Book: ");
                String issueBook=sc.next();
                lib.issueBook(issueBook);
            }
            else if(input==4){
                System.out.println("Enter Your Return Book: ");
                String returnBook=sc.next();
                lib.returnBook(returnBook);
            }
            else if(input==5){
                lib.showIssuedBook();
            }
            else{
                System.out.println("Wrong Input");
            }
        }
    }
}