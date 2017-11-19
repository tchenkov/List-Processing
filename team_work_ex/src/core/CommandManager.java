package core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static utilities.Constants.*;

public class CommandManager {
    public String append(List<String> inputListItems, String toAppendString){
        return String.join(" ",inputListItems) + " " + toAppendString;
    }

    public String prepend(List<String> inputListItems, String toPrependString){
        return toPrependString + " " +String.join(" ",inputListItems);
    }

    public String rollLeft(List<String> inputListItems) {
        // save element from first position
        String firstElement = inputListItems.get(0);
        // roll elements to the left
        for (int i = 0; i < inputListItems.size() - 1; i++) {
            // get value from the right position
            String nextValue = inputListItems.get(i + 1);
            // set value from the right position at current position
            inputListItems.set(i, nextValue);
        }
        // set first element at position size - 1;
        inputListItems.set(inputListItems.size() - 1, firstElement);
        return String.join(" ", inputListItems);
    }


    public String rollRight(List<String> inputListItems) {
        // save element from last position
        String lastElement = inputListItems.get(inputListItems.size() - 1);
        // roll elements to the right
        for (int i = inputListItems.size() - 1; i > 0; i--) {
            // get value from the left position
            String prevValue = inputListItems.get(i - 1);
            // set value from the left position at current position
            inputListItems.set(i, prevValue);
        }
        // set last element at position 0
        inputListItems.set(0, lastElement);
        return String.join(" ", inputListItems);
    }
    
    public <T> String reverse(List<T> list){
        Collections.reverse(list);
        return listToString(list);
    }
    
    public <T> String insert(List<T> list, int index, T element){
        try {
            list.add(index, element);
        } catch (IndexOutOfBoundsException iobe){
            return String.format(ERROR_INVALID_INDEX , index);
        }
        
        return listToString(list);
    }
    
    public <T> String delete(List<T> list, int index){
        try {
            list.remove(index);
        } catch (IndexOutOfBoundsException iobe){
            return String.format(ERROR_INVALID_INDEX , index);
        }
    
        return listToString(list);
    }
    
    private <T> String listToString(List<T> list){
        return (Arrays.toString(list.toArray())).replaceAll("[\\[\\],]", "");
    }
}
