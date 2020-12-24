package kata7.application;

import kata7.control.*;
import kata7.model.Block;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends JFrame {
    private final Block block;
    private final Map<String, Command> commands;
    
    public static void main(String[] args) {
        new Main().execute();
    }
    
    public Main() {
        this.block = new Block();
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(718, 780);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolBar(), BorderLayout.SOUTH);
        this.commands = createCommands();
    }

    private void execute() {
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel panel = new BlockPanel();
        panel.display(block);
        this.block.register(panel);
        return panel;
    }

    private Map<String, Command> createCommands() {
        Map<String, Command> commands = new HashMap<>();
        commands.put("U", new UpCommand(block));
        commands.put("D", new DownCommand(block));
        commands.put("L", new LeftCommand(block));
        commands.put("R", new RightCommand(block));
        return commands;
    }

    private JMenuBar toolBar() {
        JMenuBar result = new JMenuBar();
        result.setLayout(new FlowLayout(FlowLayout.CENTER));
        result.add(button("D"));
        result.add(button("L"));
        result.add(button("R"));
        result.add(button("U"));
        return result;
    }

    private JButton button(String command) {
        JButton button = new JButton(command);
        button.addActionListener(event -> commands.get(command).execute());
        return button;
    }

}