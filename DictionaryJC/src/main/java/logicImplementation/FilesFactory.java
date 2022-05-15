/***/
package main.java.logicImplementation;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesFactory {
    private String separator = File.separator;
    private Path pathToLangFile = Paths.get(getDirectory() + FilesInfo.LANG_FILE.getFilesInfo());
    private Path pathToNumFile = Paths.get(getDirectory() + FilesInfo.NUM_FILE.getFilesInfo());
    private File fileLangDict = new File(getDirectory() + FilesInfo.LANG_FILE.getFilesInfo());
    private File fileNumDict = new File(getDirectory() + FilesInfo.NUM_FILE.getFilesInfo());
    public Path getPathToLangFile(){return pathToLangFile;}
    public Path getPathToNumFile(){return pathToNumFile;}
    public File getFileLangDict(){return fileLangDict;}
    public File getFileNumDict(){return fileNumDict;}
    public String getSeparator(){
        return separator;
    }
    private String getDirectory(){
        return FilesInfo.DIRECTORY.getFilesInfo() + getSeparator();
    }
}
