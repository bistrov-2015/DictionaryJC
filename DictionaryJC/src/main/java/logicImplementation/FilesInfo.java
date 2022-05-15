/**
 * Данное перечесление содержит константы с именами файлов в которых находятся словари и
 * и константу с именем директории - "С:" (согласно заданию словари долны храниться на диске С).
 * */
package main.java.logicImplementation;


public enum FilesInfo {
    LANG_FILE("LanguageDictionary.txt"),
    NUM_FILE("NumericDictionary.txt"),
    TEMP_FILE("temp.txt"),
    DIRECTORY("C:");
    final String FileName;

    FilesInfo(String FileName) {
        this.FileName = FileName;
    }
    public String getFilesInfo(){
        return FileName;
    }

}
