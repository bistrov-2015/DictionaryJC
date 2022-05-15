/**
* Данное перечисление содержит регулярные выражения,
* которые используютя для проверки корректности ввода в соответствии с требованиями в техническом задании.
* Перечисление используется в методах класса CheckFunctions.
* SELECTION_FORMAT - определяет возможные для выбора пункты главного меню, метод showMenu class CommunicationWhithTheTheUser.
* AVAILABLE_DICTIONARY_NUMBER_FORMAT - определяет доступные для выбора номера словарей, метод checkDictionaryTypeSelection class CheckFunctions.
* NUMERIC_EXPRESSION_FORMAT - определяет формат для ключа в словаре хранящем цифры, метод checkNumericString class CheckFunctions.
* LANGUAGE_EXPRESSION_FORMAT - определяет формат для ключа в словаре хранящем цифры, метод checkSymbolString class CheckFunctions.
* NUMERIC_VALUE_FORMAT - определяет формат для значения ключа в словаре хранящем цифры, метод checkNumericExpressionValue class CheckFunctions.
* SYMBOL_VALUE_FORMAT - определяет формат для значения ключа в словаре хранящем цифры, метод checkSymbolExpressionValue class CheckFunctions.
* */
package main.java.logicImplementation;

public enum Rejex {
    SELECTION_FORMAT("[12345]"),
    AVAILABLE_DICTIONARY_NUMBER_FORMAT("[12]"),
    NUMERIC_EXPRESSION_FORMAT("^[0-9]{5}+$"),
    LANGUAGE_EXPRESSION_FORMAT("^[a-z]{4}+$"),
    SYMBOL_VALUE_FORMAT("^[а-яА-Я]+$"),
    NUMERIC_VALUE_FORMAT("^[0-9]+$");
    final String rejexType;
    Rejex(String rejexType) { this.rejexType = rejexType;}

    public String getRejexType() {
        return rejexType;
    }
}
