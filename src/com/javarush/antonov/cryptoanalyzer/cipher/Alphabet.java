package com.javarush.antonov.cryptoanalyzer.cipher;

public abstract class Alphabet {

    /**
     * В этом абстрактном классе будут перечисляться алфавиты. Вынес отдельно для других шифрований(если будут).
     */
    protected char[] rus = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
}
