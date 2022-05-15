/**
 * класс реализует методы ввода/вывода:
 * public void showDictionary() - метод выводит в консоль выбранный пользователем словарь;
 * public File defineDictionaryType(String dictionaryType) - метод определят с каким файлом необходимо работать, взависимости от того какой словарь выбрал пользователь;
 * public Path definePathtoFile(String numDict) - метод возвращает путь до выбранного файла;
 * public void  findEntryInDictionary() - метод поиска в словаре по ключу и по значению;
 * public void  makeEntryInDictionary() - метод реализующий запись в словарь;
 * public boolean chekRowExistensBeforeDeleting(String searchString, File fileType) - метод проверяющий существование записи перед её удалением;
 * public void  deleteEntryInDictionary() - метод реализует удаление записи из словаря;
 * */
package main.java.logicImplementation;

import main.java.userInterface.MessegesForUser;
import main.java.userInterface.CommunicationWithTheUser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class SimpleConsoleApplicationIOMethods implements DictionaryInterface {
    private CheckFunctions checkFunctions;
    private RequestFunctions requestFunctions;
    private CommunicationWithTheUser communicationWithTheUser;
    private FilesFactory filesFactory;

    public SimpleConsoleApplicationIOMethods(CheckFunctions checkFunctions,
                                             RequestFunctions requestFunctions,
                                             CommunicationWithTheUser communicationWithTheUser,
                                             FilesFactory filesFactory) {
        this.checkFunctions = checkFunctions;
        this.requestFunctions = requestFunctions;
        this.communicationWithTheUser = communicationWithTheUser;
        this.filesFactory = filesFactory;
    }

    public void showDictionary(){
        String dictionariType = requestFunctions.promptDictionaryType();
        try(BufferedReader br = new BufferedReader(new FileReader(defineDictionaryType(dictionariType)))){
            String line;
            while ((line = br.readLine()) != null) {
                communicationWithTheUser.showMessege(line);
            }
        }catch (IOException e){
            communicationWithTheUser.showExeptionMessege(MessegesForUser.FILE_READ_ERROR.getMessege(), e);
        }
    }

    public File defineDictionaryType(String dictionaryType){// переменнjq fileType присваивается значение взависимости от того какой словарь выбран
        if("1".equals(dictionaryType)){
            return filesFactory.getFileLangDict();
        } else return filesFactory.getFileNumDict();
    }

    private Path definePathToFile(String numDict){// переменной path присваивается значение взависимости от того каой словарь выбран
        if("1".equals(numDict)){
            return filesFactory.getPathToLangFile();
        } else return filesFactory.getPathToNumFile();
    }

    public void  findEntryInDictionary(){
        String dictionaryType = requestFunctions.promptDictionaryType();
        File fileType = defineDictionaryType(dictionaryType);
        String searchString = communicationWithTheUser.promptLine();
        String searchStringResult = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fileType))){
            String line;
            while ((line = br.readLine()) != null ) {
                if( line.contains(searchString)){
                    searchStringResult = line; break;
                }
            }
            if(searchStringResult != null){
                communicationWithTheUser.showMessege(searchStringResult);
            } else communicationWithTheUser.showMessege(MessegesForUser.STRING_NOT_FOUND.getMessege());
        }catch (IOException e){
            communicationWithTheUser.showExeptionMessege(MessegesForUser.FILE_READ_ERROR.getMessege(), e);
        }
    }


    public void  makeEntryInDictionary(){
        RequestFunctions requestFunctions = new RequestFunctions(communicationWithTheUser, checkFunctions);
        String numDict = requestFunctions.promptDictionaryType();
        Path pathToFile = definePathToFile(numDict);
        String expression = requestFunctions.requestExpressiont(numDict);
        communicationWithTheUser.showMessege(MessegesForUser.REQUEST_VALUE.getMessege());
        String expressionValue = requestFunctions.requestExpressionValue(numDict);
        String checkedString = expression + "\t" + expressionValue;
        try {
            Files.writeString(pathToFile, "\n" + checkedString, StandardOpenOption.APPEND);
        } catch (IOException e) {
            communicationWithTheUser.showExeptionMessege(MessegesForUser.FILE_WRITING_ERROR.getMessege(),e);
        }
    }

    private boolean chekRowExistensBeforeDeleting(String searchString, File fileType) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(fileType))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(searchString)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void  deleteEntryInDictionary(){
        String dictionaryType = requestFunctions.promptDictionaryType();
        File fileType = defineDictionaryType(dictionaryType);
        Path path = definePathToFile(dictionaryType);
        File temporaryFile = new File(FilesInfo.DIRECTORY.getFilesInfo() + filesFactory.getSeparator() + FilesInfo.TEMP_FILE.getFilesInfo());
        String searchString = requestFunctions.requestExpressiont(dictionaryType);
        try{
            if(chekRowExistensBeforeDeleting(searchString,fileType)){
                try ( BufferedWriter bw = new BufferedWriter(new FileWriter(temporaryFile));
                      BufferedReader br = new BufferedReader(new FileReader(fileType))){
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (!line.contains(searchString)) {
                                bw.write(line);
                                bw.newLine();
                            }
                        }
                    }
                    if (Files.deleteIfExists(path)) {
                        communicationWithTheUser.showMessege(MessegesForUser.DELETE_OK.getMessege());
                    } else communicationWithTheUser.showErrorMessege(MessegesForUser.DELETE_FAILED.getMessege());
                    if (temporaryFile.renameTo(fileType)) {
                        communicationWithTheUser.showMessege(MessegesForUser.RENAME_OK.getMessege());
                    } else communicationWithTheUser.showErrorMessege(MessegesForUser.RENAME_FAILED.getMessege());
                } else communicationWithTheUser.showErrorMessege(MessegesForUser.STRING_NOT_FOUND.getMessege());

            }catch (IOException e){
            communicationWithTheUser.showExeptionMessege(MessegesForUser.FILE_READ_ERROR.getMessege(), e);
        }
    }
}