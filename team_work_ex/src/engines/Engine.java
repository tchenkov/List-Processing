package engines;

import core.CommandManager;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import utilities.InputParser;

import java.util.Arrays;
import java.util.List;

import static utilities.Constants.INPUT_TERMINATING_COMMAND;

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
        List<String> listOfItems = Arrays.asList(this.inputReader.readLine().split("\\s+"));
        this.outputWriter.writeLine(String.join(" ",listOfItems));
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            String result = this.dispatchCommand(commandParams, listOfItems);
            if (result != null) {
                this.outputWriter.writeLine(result);
            }
            if (inputLine.equals(INPUT_TERMINATING_COMMAND)) {
                break;
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
                if (commandParams.get(0).equals("left")) {
                    return this.commandManager.rollLeft(listOfItems);
                } else {
                    return this.commandManager.rollRight(listOfItems);
                }
            default:
                return null;
        }
    }
}