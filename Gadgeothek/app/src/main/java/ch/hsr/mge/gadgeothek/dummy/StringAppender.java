package ch.hsr.mge.gadgeothek.dummy;

public class StringAppender {

    private String prefix = "";

    public StringAppender(String s) {
        prefix = s;
    }

    public void init(String s){

        prefix = s;
    }

    public String append(String suffix){
        return prefix + suffix;
    }
}
