package core;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


import static utilities.Constants.*;

public class CommandManager {
    public <T> String append(List<T> inputListItems, T toAppendString){
        inputListItems.add(toAppendString);
        return listToString(inputListItems);
    }

    public <T> String prepend(List<T> inputListItems, T toPrependString){
        inputListItems.add(0, toPrependString);
        return listToString(inputListItems);
    }

    public <T> String count(List<T> inputListItems, T findString){
        Integer count = 0;

        for (T inputListItem : inputListItems) {
            if(inputListItem.equals(findString)){
                count++;
            }
        }

        return String.valueOf(count);
    }

    public <T> String rollLeft(List<T> list) {
        // save element from first position
        T firstElement = list.get(0);
        // roll elements to the left
        for (int i = 0; i < list.size() - 1; i++) {
            // get value from the right position
            T nextValue = list.get(i + 1);
            // set value from the right position at current position
            list.set(i, nextValue);
        }
        // set first element at position size - 1;
        list.set(list.size() - 1, firstElement);
        return listToString(list);
    }

    public <T> String rollRight(List<T> list) {
        // save element from last position
        T lastElement = list.get(list.size() - 1);
        // roll elements to the right
        for (int i = list.size() - 1; i > 0; i--) {
            // get value from the left position
            T prevValue = list.get(i - 1);
            // set value from the left position at current position
            list.set(i, prevValue);
        }
        // set last element at position 0
        list.set(0, lastElement);
        return listToString(list);
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

    public <T extends Comparable> String sort(List<T> list) {
        return listToString(sortListAlphabetically(list));
    }

    private <T extends Comparable> List<T> sortListAlphabetically(List<T> list) {
        Collections.sort(list);
        return list;
    }

    private <T> String listToString(List<T> list){
        return (Arrays.toString(list.toArray())).replaceAll("[\\[\\],]", "");
    }

}
