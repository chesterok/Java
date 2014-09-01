import java.util.HashMap;
import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TextHandler {
    private long quantity;
    private String fileName;
    private HashSet<Character> characters;
    private HashMap<Character, Integer> charactersStatistics;
    private HashSet<Character> numbers;
    private HashMap<Character, Integer> numbersStatistics;
    private HashSet<Character> specialSymbols;
    private HashMap<Character, Integer> specialSymbolsStatistics;
    private HashSet<String> words;
    private HashMap<String, Integer> wordsStatistics;

    public TextHandler(String fileName) throws IOException {
        this.quantity = 0;
        this.fileName = fileName;
        characters = new HashSet<Character>();
        charactersStatistics = new HashMap<Character, Integer>();
        numbers = new HashSet<Character>();
        numbersStatistics = new HashMap<Character, Integer>();
        specialSymbols = new HashSet<Character>();
        specialSymbolsStatistics = new HashMap<Character, Integer>();
        words = new HashSet<String>();
        wordsStatistics = new HashMap<String, Integer>();
    }

    public long getQuantity() {
        return quantity;
    }

    public HashSet<String> getWords() {
        return words;
    }

    public HashMap<String, Integer> getWordsStatistics() {
        return wordsStatistics;
    }

    public HashSet<Character> getCharacters() {
        return characters;
    }

    public HashMap<Character, Integer> getCharactersStatistics() {
        return charactersStatistics;
    }

    public HashSet<Character> getNumbers() {
        return numbers;
    }

    public HashMap<Character, Integer> getNumbersStatistics() {
        return numbersStatistics;
    }

    public HashSet<Character> getSpecialSymbols() {
        return specialSymbols;
    }
    
    public HashMap<Character, Integer> getSpecialSymbolsStatistics() {
        return specialSymbolsStatistics;
    }

    private void insert(char symbol, HashSet<Character> lst) {
        lst.add(symbol);
    }

    private void insert(char symbol, HashMap<Character, Integer> lst) {
        if ( lst.get(symbol) == null ) {
            lst.put(symbol, 1);
        } else {
            lst.put(symbol, lst.get(symbol) + 1);
        }
    }

    private void insert(String word, HashSet<String> lst) {
        lst.add(word);
    }

    private void insert(String word, HashMap<String, Integer> lst) {
        if ( lst.get(word) == null ) {
            lst.put(word, 1);
        } else {
            lst.put(word, lst.get(word) + 1);
        }
    }

    private boolean isNumber(char symbol) {
        return symbol >= '0' && symbol <= '9';
    }

    private boolean isLetter(char symbol) {
        return ( symbol >= 'A' && symbol <= 'Z' ) || ( symbol >= 'a' && symbol <= 'z' );
    }

    private boolean isSpecial(char symbol) {
        boolean special = false;

        if ( ( symbol > ' ' && symbol < '0' ) || ( symbol > '9' && symbol < 'A' ) ) {
            special = true;
        }
        if ( ( symbol > 'Z' && symbol < 'a' ) || ( symbol > 'z' && symbol <= '~' ) ) {
            special = true;
        }
        return special;
    }

    public void parseText() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        StringBuffer buffer = new StringBuffer();
        int diff = 'a' - 'A';
        char symbol;

        while ( reader.ready() ) {
            symbol = (char)reader.read();
            if ( isLetter(symbol) || symbol == '\'' ) {
                buffer.append(symbol);
            } else {
                if ( buffer.length() > 0 ) {
                    insert(buffer.toString(), words);
                    insert(buffer.toString(), wordsStatistics);
                    buffer.setLength(0);
                }
            }
            if ( isLetter(symbol) ) {
                if ( symbol < 'a' ) {
                    symbol += diff;
                }
                insert(symbol, characters);
                insert(symbol, charactersStatistics);
                quantity += 1;
            }
            if ( isNumber(symbol) ) {
                insert(symbol, numbers);
                insert(symbol, numbersStatistics);
                quantity += 1;
            }
            if ( isSpecial(symbol) ) {
                insert(symbol, specialSymbols);
                insert(symbol, specialSymbolsStatistics);
                quantity += 1;
            }
        }
    }

    public String toString() {
        StringBuffer out = new StringBuffer();

        out.append("Symbols found: " + quantity);
        out.append("\nLetters statistic:\n" + "Unique: " + characters + "\nMatches in text: " + charactersStatistics);
        out.append("\nNumbers statistic:\n" + "Unique: " + numbers + "\nMatches in text: " + numbersStatistics);
        out.append("\nSpecial symbols statistic:\n" + "Unique: " + specialSymbols
         + "\nMatches in text: " + specialSymbolsStatistics);
        out.append("\nWords statistic:\n" + "Unique: " + words + "\nMatches in text: " + wordsStatistics);

        return out.toString();
    }
}

