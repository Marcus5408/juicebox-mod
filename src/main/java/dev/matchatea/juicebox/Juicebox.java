package dev.matchatea.juicebox;

import dev.matchatea.juicebox.entity.ModEntities;
import dev.matchatea.juicebox.entity.custom.JuiceboxEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.matchatea.juicebox.entity.ModEntities.registerModEntities;

public class Juicebox implements ModInitializer {
    public static final String MOD_ID = "juicebox";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Juicebox mod...");

        registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.JUICEBOX, JuiceboxEntity.createJuiceboxAttributes());

        // Register spawn in a different way that works better on servers
        registerMobSpawning();

        Item JUICEBOX_SPAWN_EGG = new SpawnEggItem(
                ModEntities.JUICEBOX,
                0xB7763F, // base color
                0xFFFFFF, // spot color
                new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "juicebox_spawn_egg"), JUICEBOX_SPAWN_EGG);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register(entries -> entries.add(JUICEBOX_SPAWN_EGG));

        LOGGER.info("Juicebox mod initialization complete!");
    }

    private void registerMobSpawning() {
        SpawnRestriction.register(ModEntities.JUICEBOX, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, JuiceboxEntity::canSpawn);

        BiomeModifications.addSpawn(
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                SpawnGroup.CREATURE,
                ModEntities.JUICEBOX,
                20, // weight
                1, // min group size
                4 // max group size
        );

        LOGGER.info("Registered Juicebox mob spawning for all overworld biomes with spawn restrictions");
    }
}
