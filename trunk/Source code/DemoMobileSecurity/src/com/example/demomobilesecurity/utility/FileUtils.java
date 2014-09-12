package com.example.demomobilesecurity.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.demomobilesecurity.entity.FileItem;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;

public class FileUtils {

	private static FileUtils fileUtils;
	public static String  APPLICATION_FOLDER_NAME = "DemoMobileSecuity";
	
	public static FileUtils getFileUtils(Context context) {
		if (fileUtils == null) {
			fileUtils = new FileUtils(context);
		}
		return fileUtils;
	}
	
	private Context mContext;
	public List<FileItem> hideFileItems;
	public FileUtils(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
		hideFileItems = new ArrayList<FileItem>();
		
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
	
	
	public void hideFiles(FileItem fileItem) {
		//for (FileItem fileItem : fileItems) {
			moveFile(fileItem.PathFile, fileItem.FileName);
			this.hideFileItems.add(fileItem);
		//}
	}
	
	public void restoreFileItem(FileItem fileItem, int position) {
		this.restoreFile(fileItem.PathFile, fileItem.FileName);
		this.hideFileItems.remove(position);
	}
	
	private void restoreFile(String inputPath, String inputFile) {
		InputStream in = null;
	    FileOutputStream out = null;
	    try {

	        in = mContext.openFileInput(inputFile);        
	        out = new FileOutputStream(inputPath);

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
	        new File(inputPath).delete();  


	    } 

	         catch (FileNotFoundException fnfe1) {
	        Log.e("tag", fnfe1.getMessage());
	    }
	          catch (Exception e) {
	        Log.e("tag", e.getMessage());
	    }

	}
	
	public void moveFile(String inputPath, String inputFile) {

	    InputStream in = null;
	    FileOutputStream out = null;
	    try {

	        in = new FileInputStream(inputPath);        
	        out = mContext.openFileOutput(inputFile, Context.MODE_PRIVATE);

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
	        new File(inputPath).delete();  


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
