package net.minecraftforge.fml.relauncher;

/**
 * Shadows Forge's Side enum to remove the phantom BUKKIT constant that snapshot_20171003
 * MCP mappings expose. Without this, Side.values() returns 3 values (CLIENT, SERVER, BUKKIT)
 * but NetworkRegistry.channels only holds CLIENT and SERVER, causing a NPE at startup.
 * This file is excluded from the mod JAR (see build.gradle jar task).
 */
public enum Side {
    CLIENT,
    SERVER;

    public boolean isServer() {
        return !this.isClient();
    }

    public boolean isClient() {
        return this == CLIENT;
    }
}
