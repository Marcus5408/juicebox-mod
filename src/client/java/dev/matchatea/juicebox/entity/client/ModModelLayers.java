package dev.matchatea.juicebox.entity.client;

import dev.matchatea.juicebox.Juicebox;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer JUICEBOX =
            new EntityModelLayer(new Identifier(Juicebox.MOD_ID, "juicebox"), "main");
}
