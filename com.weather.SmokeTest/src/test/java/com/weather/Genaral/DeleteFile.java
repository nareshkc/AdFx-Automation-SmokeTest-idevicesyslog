package com.weather.Genaral;
import java.io.File;  
  
public  class DeleteFile {  
  
 public void deleteFile() {  
  try {  
   File fileToDelete = new File("/Users/aparna/Documents/syslog.log"); 

  
   if (fileToDelete.delete()) {  
    System.out.println("File deleted successfully !");  
   } else {  
    System.out.println("File delete operation failed !");  
   }  
  
  } catch (Exception e) {  
   e.printStackTrace();  
  }  
 }  
}  