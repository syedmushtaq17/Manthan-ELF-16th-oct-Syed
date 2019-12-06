import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {

		int ch;
		String bill="";
		int sum=200;
	File f = new File("D:\\HotellBill\\Bill.txt");
	
		FileReader fr = new FileReader(f);
		while((ch=fr.read())!=-1) {
			bill=bill+ch;
			//System.out.println(bill);
			
		}
		FileWriter fw  = new FileWriter(f);
		
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line!=null) {
			System.out.println(line);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line);
	sum=sum+Integer.parseInt(bill);
		fw.write(sum);
		System.out.println(sum);

	
	}

}
