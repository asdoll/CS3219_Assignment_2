package CS3219;


import java.util.HashSet;

/**
 * Created by junchao on 8/23/2014.
 */
public class RequiredWords {
    private HashSet<String> _requiredwords;
    private static RequiredWords _instatnce;
    
    private RequiredWords() {
        this._requiredwords = new HashSet<String>();
    }

    public static RequiredWords getRequiredWords() {
        if (_instatnce == null) {
            _instatnce = new RequiredWords();
        }

        return _instatnce;
    }

    public void addRequiredWords(String word) {
        assert(word != null);
        this._requiredwords.add(word);
    }

    public void removeRequiredWords(String word) {
        assert(word != null);
        this._requiredwords.remove(word);
    }

    public boolean isRequiredWords(String word) {
        assert(word != null);
        return this._requiredwords.contains(word);
    }
    
}
