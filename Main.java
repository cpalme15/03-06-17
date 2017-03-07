import java.io.*;
import java.util.*;

public class Main  {

	public static void main(String[] args) 
	{
		FileInputStream fis=null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		PrintWriter pw=null;
		Scanner keyb=null;
		Employee[]e=new Employee[3];
		
		try 
		{
			fis=new FileInputStream("infile.txt");
			fos=new FileOutputStream("outfile.txt");
			keyb=new Scanner(fis);
			pw=new PrintWriter(fos);
			oos=new ObjectOutputStream(new FileOutputStream("inobject.dat"));
			ois=new ObjectInputStream(new FileInputStream("inobject.dat"));
			
			String word=keyb.next();
			int num=keyb.nextInt();
		pw.println(word +" "+num);
			pw.close();
			fos.close();
			fis.close();
		} catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			oos.writeUTF("EMU");
			oos.writeInt(2017);
			oos.close();
			System.out.println(ois.readUTF());
			System.out.println(ois.readInt());
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally/* if you can do the first try then it 
		will do the finally as well
		best place to close all you output and input streams
		*/
		{
			try
			{
				ois.close();
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
	
keyb.close();
	}
	

}
