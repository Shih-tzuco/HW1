package step.learning;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilesIo
{
    public void run()
    {
        try(BufferedReader br = new BufferedReader(new FileReader("json.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        Scanner scanner = new Scanner(System.in);
        //mylistFiles();
        List<ContactsList> catalog = new ArrayList<>();

        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter surname");
        String surname = scanner.nextLine();

        System.out.println("Enter fathername");
        String fathername = scanner.nextLine();

        System.out.println("Enter phonenumber");
        Integer phonenumber = scanner.nextInt(); //  I am not sure that Integer was a good idea, maybe better choose String

        try(FileWriter fw = new FileWriter("json.txt", true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            catalog.add(new ContactsList(name, surname, fathername, phonenumber));
            out.println(name + " " + surname + " " + fathername + " " + phonenumber);
           //catalog.add(new ContactsList("Taras", "Shevchenko", "Grygorovych", 380670000)); // it was check
        }
        catch (Exception ex)
        {
            System.out.println("You can't add this account! Try again!");
        }
        for(ContactsList contactsList : catalog)
        {
            System.out.println(contactsList.getContactsList());
        }



    }
    private void mylistFiles()
    {
        String filename = "." + File.separator;
        File f = new File(filename);
        File filesList[] = f.listFiles();
        SimpleDateFormat timeInfo = new SimpleDateFormat("MM.dd.yyyy    HH:mm:ss   ");


        System.out.println("-- Modife ---------- Data ------ Time ------ Size ---- Name --");

        for (File name : filesList)
        {
            if (name.canRead())
            {
                System.out.println( "canRead           " +timeInfo.format(name.lastModified())+name.length()+" byte   "+name.getName());

            }
            if (name.canWrite())
            {
                System.out.println("canWrite          "+timeInfo.format(name.lastModified())+name.length()+" byte   "+name.getName());
            }
            if (name.isHidden())
            {
                System.out.println("isHidden          " +timeInfo.format(name.lastModified())+name.length()+" byte   "+name.getName());
            }
            if (name.canExecute())
            {
                System.out.println("isExecute         " +timeInfo.format(name.lastModified())+name.length()+" byte   "+name.getName());
            }
            if (name.isDirectory())
            {
                System.out.println("isDirectory       " +timeInfo.format(name.lastModified())+name.length()+" byte   "+name.getName());
            }
        }
    }
}
