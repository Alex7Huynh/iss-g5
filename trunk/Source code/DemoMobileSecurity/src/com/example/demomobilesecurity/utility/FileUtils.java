package com.example.demomobilesecurity.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.demomobilesecurity.entity.FileItem;

import android.content.Context;
import android.util.Log;
import android.webkit.MimeTypeMap;

public class FileUtils {

	private static FileUtils fileUtils;
	
	public static FileUtils getFileUtils(Context context) {
		if (fileUtils == null) {
			fileUtils = new FileUtils(context);
		}
		return fileUtils;
	}
	
	private Context mContext;
	public List<FileItem> selectedFileItems;
	public FileUtils(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	
	public ArrayList<FileItem> getListFileItems(String path) {
		File sd = new File(path);
		ArrayList<FileItem> listFileItems = new ArrayList<FileItem>();
		File[] listFiles = sd.listFiles();
		
		for (int i = 0; i < listFiles.length; i++) {
			File f = listFiles[i];
			if (f.isHidden())
				continue;
			FileItem fileItem = new FileItem();
			fileItem.FileName = f.getName();
			fileItem.PathFile = f.getAbsolutePath();
			fileItem.IsFolder = f.isDirectory();
			
			fileItem.FileType = fileItem.IsFolder ? "Folder" : MimeTypeMap.getFileExtensionFromUrl(f.getAbsolutePath());
			listFileItems.add(fileItem);
		}
		return listFileItems;
	}
	
	public void moveFile(String inputPath, String inputFile, String outputPath) {

	    InputStream in = null;
	    OutputStream out = null;
	    try {

	        //create output directory if it doesn't exist
	        File dir = new File (outputPath); 
	        if (!dir.exists())
	        {
	            dir.mkdirs();
	        }


	        in = new FileInputStream(inputPath + inputFile);        
	        out = new FileOutputStream(outputPath + inputFile);

	        byte[] buffer = new byte[1024];
	        int read;
	        while ((read = in.read(buffer)) != -1) {
	            out.write(buffer, 0, read);
	        }
	        in.close();
	        in = null;

	            // write the output file
	            out.flush();
	        out.close();
	        out = null;

	        // delete the original file
	        new File(inputPath + inputFile).delete();  


	    } 

	         catch (FileNotFoundException fnfe1) {
	        Log.e("tag", fnfe1.getMessage());
	    }
	          catch (Exception e) {
	        Log.e("tag", e.getMessage());
	    }

	}
	
	
	private void deleteFile(String inputPath, String inputFile) {
	    try {
	        // delete the original file
	        new File(inputPath + inputFile).delete();  


	    }
	   
	    catch (Exception e) {
	        Log.e("tag", e.getMessage());
	    }
	}
}
