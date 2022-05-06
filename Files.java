/*
 * Данное перечесление содержит константы с именами файлов в которых находятся словари
 * и константу с именем директории - "С:" (согласно заданию словари долны храниться на диске С).
 * */
package main.Constants;


public enum Files {
    LANG_FILE("LanguageDictionary.txt"),
    NUM_FILE("NumericDictionary.txt"),
    DIRECTORY("C:");
    String FileName;

    Files(String FileName) {
        this.FileName = FileName;
    }
    public String getFilesInfo(){
        return FileName;
    }

}
