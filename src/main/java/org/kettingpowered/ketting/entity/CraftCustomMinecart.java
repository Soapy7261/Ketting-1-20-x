package org.kettingpowered.ketting.entity;

import net.minecraft.world.entity.vehicle.AbstractMinecart;
import org.bukkit.craftbukkit.v1_20_R2.CraftServer;
import org.bukkit.craftbukkit.v1_20_R2.entity.CraftMinecart;

public class CraftCustomMinecart extends CraftMinecart {

    public CraftCustomMinecart(CraftServer server, AbstractMinecart entity) {
        super(server, entity);
    }
}
