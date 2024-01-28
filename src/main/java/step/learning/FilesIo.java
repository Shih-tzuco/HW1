package step.learning;

import java.io.File;
import java.text.SimpleDateFormat;

public class FilesIo
{
    public void run()
    {
        mylistFiles();
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
