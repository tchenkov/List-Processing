package core;

import java.util.List;

public class CommandManager {
    public String append(List<String> inputListItems, String toAppendString){
        return String.join(" ",inputListItems) +" "+toAppendString;
    }

    public String prepend(List<String> inputListItems, String toPrependString){
        return toPrependString+" "+String.join(" ",inputListItems);
    }
}
