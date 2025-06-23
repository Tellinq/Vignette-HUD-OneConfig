package org.polyfrost.example.client;

import org.polyfrost.oneconfig.api.commands.v1.CommandManager;

public class ExampleClient {

    public static final ExampleClient INSTANCE = new ExampleClient();

    public void initialize() {
        ExampleConfig.INSTANCE.preload();
        CommandManager.register(new ExampleCommand());
    }

}
