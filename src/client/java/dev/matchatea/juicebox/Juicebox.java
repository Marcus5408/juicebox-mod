package dev.matchatea.juicebox;

import dev.matchatea.juicebox.entity.ModEntities;
import dev.matchatea.juicebox.entity.custom.JuiceboxEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
// ...existing code...
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
    }
}
