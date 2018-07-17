package system.pack.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {
	
	public ExcelHelper (){}	
	
	public void createFile(MultipartFile file, String fileName) throws IOException{
		InputStream in = file.getInputStream();
	    FileOutputStream f = new FileOutputStream(new Constants().FILE_SAVING_ROUTE + fileName + ".xlsx");
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();
	}
	
}
