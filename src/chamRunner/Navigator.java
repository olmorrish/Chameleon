package chamRunner;

import java.nio.file.Path;
//import java.util.ArrayList;

import chamCore.FilmNode.FileFormat;

/*
 * Abstract utility class to assist in navigating file systems
 * 
 * Navigator is to be used by the Chameleon program to allow the addition of multiple film files of varying formats to 
 * 	the database. 
 */
public abstract class Navigator {
	
	public FileFormat fileExtensionOf(Path path){
		String pathStr = path.toString();
		int i = (pathStr).lastIndexOf('.');
		String ext = pathStr.substring(i+1); //TODO: ensure extensions like tar.gz are unused here
		ext = ext.toUpperCase();
		
		switch (ext) {
		case "AVI": return FileFormat.AVI;
		case "FLV": return FileFormat.FLV;
		case "MOV": return FileFormat.MOV;
		case "MP4": return FileFormat.MP4;
		case "WMV": return FileFormat.WMV;
		default: return FileFormat.NOFORMAT;
		
		}
	}
	
//	
//	public ArrayList<Path> fetchVideosWithinFile(){
//		
//	}


}
