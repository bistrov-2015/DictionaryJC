/*
 * класс реализует методы ввода/вывода:
 * public void showDictionary() - метод выводит в консоль выбранный пользователем словарь;
 * public File defineDictionaryType(String dictionaryType) - метод определят с каким файлом необходимо работать, взависимости от того какой словарь выбрал пользователь;
 * public Path definePathtoFile(String numDict) - метод возвращает путь до выбранного файла;
 * public void  findEntryInDictionary() - метод поиска в словаре по ключу и по значению;
 * public void  makeEntryInDictionary() - метод реализующий запись в словарь;
 * public boolean chekRowExistensBeforeDeleting(String searchString, File fileType) - метод проверяющий существование записи перед её удалением;
 * public void  deleteEntryInDictionary() - метод реализует удаление записи из словаря;
 * */
package main.Classes;

import main.Interfaces.DictionaryInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class SimpleConsoleApplicationIOMethods implements DictionaryInterface {
    CheckFunctions checkFunctions;
    RequestFunctions requestFunctions;
    CommunicationWithTheUser communicationWithTheUser;

    public SimpleConsoleApplicationIOMethods(CheckFunctions checkFunctions, RequestFunctions requestFunctions, CommunicationWithTheUser communicationWithTheUser) {
        this.checkFunctions = checkFunctions;
        this.requestFunctions = requestFunctions;
        this.communicationWithTheUser = communicationWithTheUser;
    }

    public void showDictionary(){
        BufferedReader br = null;
        String dictionariType = requestFunctions.promptDictionaryType();
        try {
            br = new BufferedReader(new FileReader(defineDictionaryType(dictionariType)));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            communicationWithTheUser.fileReadError();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public File defineDictionaryType(String dictionaryType){// переменнjq fileType присваивается значение взависимости от того каой словарь выбран
        File fileType = checkFunctions.file1;
        if("1".equals(dictionaryType)){
            return fileType = checkFunctions.file1;
        } else if("2".equals(dictionaryType)){
            return fileType = checkFunctions.file2;
        }
        return fileType;// возможно создать дефолтный вайл
    }

    public Path definePathtoFile(String numDict){// переменной path присваивается значение взависимости от того каой словарь выбран
        Path path = checkFunctions.path1;
        if("1".equals(numDict)){
            return path = checkFunctions.path1;
        } else if("2".equals(numDict)){
            return path = checkFunctions.path2;
        }
        return path;// возможно создать путь к дефолтному вайлу
    }

    public void  findEntryInDictionary(){
        String dictionariType = requestFunctions.promptDictionaryType();
        File fileType = defineDictionaryType(dictionariType);
        BufferedReader br = null;
        String searchString = communicationWithTheUser.promptLine();
        String searchStringResult = null;

        try {
            br = new BufferedReader(new FileReader(fileType));
            String line;
            while ((line = br.readLine()) != null ) {
                if( line.contains(searchString)){
                    searchStringResult = line; break;
                }
            } br.close();
            if(searchStringResult != null){
                System.out.println(searchStringResult);
            } else communicationWithTheUser.stringNotFound();
        } catch (IOException e) {
            communicationWithTheUser.fileReadError();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void  makeEntryInDictionary(){
        RequestFunctions requestFunctions = new RequestFunctions(communicationWithTheUser, checkFunctions);
        String numDict = requestFunctions.promptDictionaryType();
        Path pathToFile = definePathtoFile(numDict);
        String expression = requestFunctions.requestExpressiont(numDict);
        communicationWithTheUser.promptValue();
        String expressionValue = requestFunctions.requestExpressionValue(numDict);
        String checkedString = expression + "\t" + expressionValue;
        try {
            Files.writeString(pathToFile, "\n" + checkedString, StandardOpenOption.APPEND);
        } catch (IOException e) {
            communicationWithTheUser.fileWritingError();
        }
    }

    public boolean chekRowExistensBeforeDeleting(String searchString, File fileType) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileType));
            String line;
            while ((line = br.readLine()) != null ) {
                if (line.startsWith(searchString) == true) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            communicationWithTheUser.fileReadError();
        }
        return false;
    }

    public void  deleteEntryInDictionary(){
        String dictionaryType = requestFunctions.promptDictionaryType();
        File fileType = defineDictionaryType(dictionaryType);
        Path path = definePathtoFile(dictionaryType);
        File temporaryFile = new File("C:" + checkFunctions.getSeparator() + "temp.txt");
        BufferedReader br = null;
        //communicationWithTheUser.promptLine();
        String searchString = requestFunctions.requestExpressiont(dictionaryType);

        if(chekRowExistensBeforeDeleting(searchString,fileType) == true) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(temporaryFile));
                br = new BufferedReader(new FileReader(fileType));
                String line;

                while ((line = br.readLine()) != null) {
                    if (!line.contains(searchString)) {
                        bw.write(line);
                        bw.newLine();
                    }
                }
                br.close();
                bw.close();
                if (Files.deleteIfExists(path)) {
                    communicationWithTheUser.deleteOKMessage();//System.out.println("delete");
                } else communicationWithTheUser.deleteFailedMessage();//System.out.println("not delete");
                if (temporaryFile.renameTo(fileType)) {
                    communicationWithTheUser.renameOKMessage();//System.out.println("successfully");
                } else communicationWithTheUser.renameFailedMessage();//System.out.println("not rename");


            } catch (IOException e) {
                communicationWithTheUser.fileReadError();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else System.out.println("нет такой строки");
    }
}