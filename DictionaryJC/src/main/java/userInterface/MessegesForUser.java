/**
* Данное перечесление содержит константы со строками (сообщениями) для общения с пользователем.
* */
package main.java.userInterface;

public enum MessegesForUser {
    MAINMENU("Просмотреть словарь - нажмите 1; Найти запись - нажмите 2; Добавить запись - нажмите 3; Удалить запись - нажмите 4; Завершить работу программы - нажмите 5;"+ "\n"),
    REPORT_LANGUAGE_DICTIONARY_FILE_CREATION("Файл LanguageDictionary.txt не был найден на диске, создан новый файл."),
    REPORT_LANGUAGE_DICTIONARY_FILE_CREATION_FAILED("Не удалось создать файл LanguageDictionary.txtпо пути (MyApplication/public class CheckFunctions/checkFileExistence)"),
    REPORT_NUMERIC_DICTIONARY_FILE_CREATION("Файл NumericDictionary.txt не был найден, создан новый файл."),
    REPORT_NUMERIC_DICTIONARY_FILE_CREATION_FAILED("Не удалось создать файл NumericDictionary.txtпо пути (MyApplication/public class CheckFunctions/checkFileExistence)"),
    PROMPT_DICTIOARY_TYPE("Нажмите 1, чтобы выбрать Language Dictionary или 2, чтобы выбрать Numeric Dictionary " + "\n" + "<<"),
    SHOW_STRING_FORMAT_FOR_EXPRESSION_MESSEGE("Введидите слово из 4 букв на латинской раскладке, в нижнем регистре"),
    SHOW_NUMBER_FORMAT_FOR_EXPRESSION_MESSEGE("Введидите число из 5 цифр"),
    SHOW_STRING_FORMAT_FOR_VALUE_MESSEGE("Введидите слово на русском языке"),
    SHOW_NUMBER_FORMAT_FOR_VALUE_MESSEGE("Введидите число в двоичной или десятичной системе счисления"),
    KEY_REQUEST("Введидите слово<< "),
    REQUEST_VALUE("Введите значение"),
    REQUEST_ACTION("Выберите действие << "),
    STRING_NOT_FOUND("Поиск не дал результатов"),
    FILE_READ_ERROR("Ошибка чтения файла (MyApplication/public class SimpleConsoleApplicationIOMethods/ ) IOException"),
    FILE_WRITING_ERROR("Ошибка записи в файл (MyApplication/public class SimpleConsoleApplicationIOMethods/ ) IOException"),
    APPLICATION_LOGIC_EXEPTION("Ошибка запуска, возможно файл не существует class CheckFuntions checkFileExistence"),
    DELETE_OK("Delete successfully "),
    RENAME_OK("and save;\n"),
    DELETE_FAILED("Word wasn't deleted "),
    ERROR("Ошибка! "),
    RENAME_FAILED("temporary file wasnn't rename C:/temporaryFile.txt;\n");
    final String messege;

    MessegesForUser(String messege) {
        this.messege = messege;
    }

    public String getMessege() {
        return messege;
    }
}
