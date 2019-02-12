package seedu.addressbook.commands;

import java.util.Scanner;

/**
 * Clears the address book.
 */
public class ClearCommand extends Command {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_USAGE = "Clears address book permanently.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";
    public static final String MESSAGE_CONFIRMATION = "Are you sure you want to clear all contacts? Y/N";
    public static final String MESSAGE_CANCELLED = "Cancelled, address book has not been cleared.";
    public static final String MESSAGE_INVALID = "Invalid input, address book has not been cleared.";

    @Override
    public CommandResult execute() {
        System.out.println(MESSAGE_CONFIRMATION);
        Scanner scan = new Scanner(System.in);
        String confirmClear = scan.nextLine();

        if (confirmClear == "Y" || confirmClear == "y") {
            addressBook.clear();
            return new CommandResult(MESSAGE_SUCCESS);
        } else {
            if (confirmClear == "N" || confirmClear == "n") {
                return new CommandResult(MESSAGE_CANCELLED);
            }
        }

        System.out.println(MESSAGE_INVALID);
        return execute();
    }
}
