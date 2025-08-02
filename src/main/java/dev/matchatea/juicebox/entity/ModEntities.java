package dev.matchatea.juicebox.entity;

import dev.matchatea.juicebox.Juicebox;
import dev.matchatea.juicebox.entity.custom.JuiceboxEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<JuiceboxEntity> JUICEBOX = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Juicebox.MOD_ID, "juicebox"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, JuiceboxEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 2f)).build());

    public static void registerModEntities() {
        Juicebox.LOGGER.info("Registering Entities for " + Juicebox.MOD_ID);
    }
}
