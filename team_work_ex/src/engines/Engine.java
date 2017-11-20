package engines;

import core.CommandManager;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import utilities.InputParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.Constants.*;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CommandManager commandManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, CommandManager commandManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.commandManager = commandManager;
    }

    public void run() {
        List<String> listOfItems = new ArrayList<>(Arrays.asList(this.inputReader.readLine().split("\\s+")));
        this.outputWriter.writeLine(String.join(" ",listOfItems));
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                System.out.println(FINAL_OUTPUT);
                break;
            }
            
            List<String> commandParams = this.inputParser.parseInput(inputLine);
    
            String result = this.dispatchCommand(commandParams, listOfItems);
            if (result != null) {
                this.outputWriter.writeLine(result);
            }
        }
    }

    private String dispatchCommand(List<String> commandParams, List<String> listOfItems) {
        String command = commandParams.remove(0);
            switch (command) {
                case "append":
                    return this.commandManager.append(listOfItems, commandParams.get(0));
                case "prepend":
                    return this.commandManager.prepend(listOfItems, commandParams.get(0));
                case "roll":
                    if (commandParams.size() == 1) {
                        if (commandParams.get(0).equals("left")) {
                            return this.commandManager.rollLeft(listOfItems);
                        }
                        if  (commandParams.get(0).equals("right")) {
                            return this.commandManager.rollRight(listOfItems);
                        }
                    }
                    return ERROR_INVALID_COMMAND_PARAMETERS;
                case "reverse":
                    return this.commandManager.reverse(listOfItems);
                case "insert":
                    if (commandParams.size() != 2) {
                        return ERROR_INVALID_COMMAND_PARAMETERS;
                    }

                    int index;
                    try {
                        index = Integer.parseInt(commandParams.get(0));
                    } catch (NumberFormatException nfe) {
                        return ERROR_INVALID_COMMAND_PARAMETERS;
                    }

                    String element = commandParams.get(1);
                    return this.commandManager.insert(listOfItems, index, element);
                case "delete":
                    if (commandParams.size() != 1) {
                        return ERROR_INVALID_COMMAND_PARAMETERS;
                    }

                    int deleteElementAt;
                    try {
                        deleteElementAt = Integer.parseInt(commandParams.get(0));
                    } catch (NumberFormatException nfe) {
                        return ERROR_INVALID_COMMAND_PARAMETERS;
                    }

                    return this.commandManager.delete(listOfItems, deleteElementAt);
                case "count":
                    return this.commandManager.count(listOfItems, commandParams.get(0));
                case "sort" :
                    return this.commandManager.sort(listOfItems);
                default:
                    return ERROR_INVALID_COMMAND;
            }
    }
}