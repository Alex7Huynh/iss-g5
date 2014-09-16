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
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;

public class FileUtils {

	private static FileUtils fileUtils;
	public static String  APPLICATION_FOLDER_NAME = "DemoMobileSecuity";
	public static String PASSWORD;
	
	public static FileUtils getFileUtils(Context context) {
		if (fileUtils == null) {
			fileUtils = new FileUtils(context);
		}
		return fileUtils;
	}
	
	private Context mContext;
	public List<FileItem> hideFileItems;
	public FileItem currentFileItem;
	public String currentPathFile;
	public FileUtils(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
		hideFileItems = getHiddenFileItems();
		
	}
	
	public boolean checkPassword(String password) {
		PASSWORD = this.getValueData(ConstantValues.USER_PASSWORD);
		if (PASSWORD == null)
			PASSWORD = "Demo123";
		return password.equalsIgnoreCase(PASSWORD);
	}
	
	public boolean updatePassword() {
		this.setValueData(ConstantValues.USER_PASSWORD, PASSWORD);
		return true;
	}

	
	public List<FileItem> getHiddenFileItems() {
		List<FileItem> listFileItems = new ArrayList<FileItem>();
		String size = this.getValueData(ConstantValues.FILE_SIZE);
		size = size != null ? size :"0";
		int fileSize = Integer.valueOf(size);
		for (int index = 0; index < fileSize; index++) {
			String fileName = this.getValueData(ConstantValues.getFileOrder(index));
			FileItem fi = new FileItem();
			fi.FileName = fileName;
			listFileItems.add(fi);
		}
		hideFileItems = listFileItems;
		return listFileItems;
	}
	
	public void saveHiddenFileItems() {
		List<FileItem> listFileItems = hideFileItems;
		SharedPreferences sharedPref = this.mContext.getSharedPreferences(ConstantValues.PREFERENCE_NAME, Context.MODE_PRIVATE);
		sharedPref.edit().clear().commit();
		
		this.setValueData(ConstantValues.USER_PASSWORD, PASSWORD);
		this.setValueData(ConstantValues.FILE_SIZE, String.valueOf(listFileItems.size()));

		for (int index = 0; index < listFileItems.size(); index++) {
			this.setValueData(ConstantValues.getFileOrder(index), listFileItems.get(index).FileName);
		}
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
			this.saveHiddenFileItems();
		//}
	}
	
	public void restoreFileItem(FileItem fileItem, int position) {
		this.restoreFile(fileItem.PathFile, fileItem.FileName);
		this.hideFileItems.remove(fileItem);
		this.saveHiddenFileItems();
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
	       
	        //new File(inputFile).delete();  
	       mContext.deleteFile(inputFile);


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
	
	private void setValueData(String key, String val) {
		SharedPreferences sharedPref = this.mContext.getSharedPreferences(ConstantValues.PREFERENCE_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(key, val);
		editor.commit();
	}
	
	
	private String getValueData (String key) {
		SharedPreferences sharedPref = this.mContext.getSharedPreferences(ConstantValues.PREFERENCE_NAME, Context.MODE_PRIVATE);
		return sharedPref.getString(key, null);
	}
}
