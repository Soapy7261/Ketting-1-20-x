package org.kettingpowered.ketting.simd;

import org.bukkit.Bukkit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PLogger extends Logger {
    public static final PLogger LOGGER = new PLogger();
    private PLogger() {
        super("Pufferfish", null);
        setParent(Bukkit.getLogger());
        setLevel(Level.ALL);
    }
}
