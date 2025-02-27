package org.bukkit.craftbukkit.v1_20_R3.entity;

import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.entity.ComplexEntityPart;
import org.bukkit.entity.ComplexLivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;

public class CraftComplexPart extends CraftEntity implements ComplexEntityPart {
    public CraftComplexPart(CraftServer server, EnderDragonPart entity) {
        super(server, entity);
    }

    @Override
    public ComplexLivingEntity getParent() {
        return (ComplexLivingEntity) ((EnderDragon) getHandle().parentMob).getBukkitEntity();
    }

    @Override
    public void setLastDamageCause(EntityDamageEvent cause) {
        getParent().setLastDamageCause(cause);
    }

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return getParent().getLastDamageCause();
    }

    @Override
    public boolean isValid() {
        return getParent().isValid();
    }

    @Override
    public EnderDragonPart getHandle() {
        return (EnderDragonPart) entity;
    }

    @Override
    public String toString() {
        return "CraftComplexPart";
    }
}
