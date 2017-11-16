
import core.CommandManager;
import engines.Engine;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        CommandManager commandManager = new CommandManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, commandManager);

        engine.run();
    }
}
