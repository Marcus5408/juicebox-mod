package dev.matchatea.juicebox;

import dev.matchatea.juicebox.entity.ModEntities;
import dev.matchatea.juicebox.entity.client.JuiceboxModel;
import dev.matchatea.juicebox.entity.client.JuiceboxRenderer;
import dev.matchatea.juicebox.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

public class JuiceboxModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.JUICEBOX, JuiceboxRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.JUICEBOX, JuiceboxModel::getTexturedModelData);
    }
}
