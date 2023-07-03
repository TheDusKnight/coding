package OOD.StaticFactoryPattern;

// Chinese -> English
// English -> Germen
// XToEnglish(String X), EnglishToX(String Y)

enum LanguageType {
    English,
    Chinese,
    Germen
}

abstract class Language {
    LanguageType languageType;

    public Language(LanguageType type) {
        this.languageType = type;
    }

    public abstract String XToEnglish(String s);

    public abstract String EnglishToX(String s);
}

class Chinese extends Language {
    public Chinese() {
        super(LanguageType.Chinese);
    }

    @Override
    public String XToEnglish(String s) {
        return "Chinese to English";
    }

    @Override
    public String EnglishToX(String s) {
        return "English to Chinese";
    }
}

class Germen extends Language {
    public Germen() {
        super(LanguageType.Germen);
    }

    @Override
    public String XToEnglish(String s) {
        return "Germen to English";
    }

    @Override
    public String EnglishToX(String s) {
        return "English to Germen";
    }
}

class English extends Language {
    public English() {
        super(LanguageType.English);
    }

    @Override
    public String XToEnglish(String s) {
        return "English to English";
    }

    @Override
    public String EnglishToX(String s) {
        return "English to English";
    }
}

class LanguageFactory {
    public static Language getInstance(LanguageType type) {
        switch (type) {
            case English:
                return new English();
            case Chinese:
                return new Chinese();
            case Germen:
                return new Germen();
            default:
                return null;
        }
    }
}

public class Translater {

    public static String translate(LanguageType from, LanguageType to, String s) {
        Language fromLanguage = LanguageFactory.getInstance(from);
        Language toLanguage = LanguageFactory.getInstance(to);
        String english = fromLanguage.XToEnglish(s);
        return toLanguage.EnglishToX(english);
    }

    public static void main(String[] args) {
        System.out.println(translate(LanguageType.Chinese, LanguageType.Germen, "null"));
    }
}
