package dev.matchatea.juicebox.entity.client;

import dev.matchatea.juicebox.Juicebox;
import dev.matchatea.juicebox.entity.custom.JuiceboxEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class JuiceboxRenderer extends MobEntityRenderer<JuiceboxEntity, JuiceboxModel<JuiceboxEntity>> {
    private static final Identifier TEXTURE = new Identifier(Juicebox.MOD_ID, "textures/entity/juicebox.png");
    public JuiceboxRenderer(EntityRendererFactory.Context context) {
        super(context, new JuiceboxModel<>(context.getPart(ModModelLayers.JUICEBOX)), 0.6f);
    }

    @Override
    public Identifier getTexture(JuiceboxEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(JuiceboxEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity instanceof JuiceboxEntity) {
            matrixStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            matrixStack.scale(0.6F, 1F, 1F);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
