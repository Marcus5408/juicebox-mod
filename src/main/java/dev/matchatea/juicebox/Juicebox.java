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
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.matchatea.juicebox.entity.ModEntities.registerModEntities;

public class Juicebox implements ModInitializer {
    public static final String MOD_ID = "juicebox";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        registerModEntities();
        FabricDefaultAttributeRegistry.register(ModEntities.JUICEBOX, JuiceboxEntity.createJuiceboxAttributes());
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
            SpawnGroup.CREATURE,
            ModEntities.JUICEBOX,
            20,
            1,
            4);
        Item JUICEBOX_SPAWN_EGG = new SpawnEggItem(
                ModEntities.JUICEBOX,
                0xB7763F, // base color
                0xFFFFFF, // spot color
                new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "juicebox_spawn_egg"), JUICEBOX_SPAWN_EGG);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register(entries -> entries.add(JUICEBOX_SPAWN_EGG));
    }
}
