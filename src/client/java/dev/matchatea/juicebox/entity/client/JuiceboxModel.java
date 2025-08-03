package dev.matchatea.juicebox.entity.client;

import dev.matchatea.juicebox.entity.custom.JuiceboxEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class JuiceboxModel<T extends JuiceboxEntity> extends EntityModel<T> {
    private final ModelPart cardboard;
    private final ModelPart box;
    private final ModelPart front;
    private final ModelPart straw;
    private final ModelPart orpheus;
    private final ModelPart head;

    public JuiceboxModel(ModelPart part) {
        this.cardboard = part.getChild("cardboard");
        this.box = this.cardboard.getChild("box");
        this.front = this.box.getChild("front");
        this.straw = this.box.getChild("straw");
        this.orpheus = part.getChild("orpheus");
        this.head = this.orpheus.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData cardboard = modelPartData.addChild("cardboard", ModelPartBuilder.create(),
                ModelTransform.pivot(0.0F, 24.0F, -3.0F));

        ModelPartData table_r1 = cardboard.addChild("table_r1",
                ModelPartBuilder.create().uv(46, 42).cuboid(-4.0F, -32.0F, -1.0F, 6.0F, 1.0F, 18.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(-8.0F, 14.0F, -4.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData shade_r1 = cardboard.addChild("shade_r1",
                ModelPartBuilder.create().uv(46, 23).cuboid(-3.0F, -32.0F, -1.0F, 8.0F, 1.0F, 18.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(-8.0F, -1.0F, 15.0F, 1.5708F, 1.0472F, 1.5708F));

        ModelPartData box = cardboard.addChild("box", ModelPartBuilder.create().uv(0, 23).cuboid(-11.0F, -33.0F,
                12.0F, 22.0F, 33.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData top_r1 = box.addChild("top_r1",
                ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -33.0F, -3.0F, 14.0F, 1.0F, 22.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(-8.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData right_r1 = box.addChild("right_r1",
                ModelPartBuilder.create().uv(32, 61).cuboid(-5.0F, -33.0F, -2.0F, 15.0F, 33.0F, 1.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(-10.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData left_r1 = box.addChild("left_r1",
                ModelPartBuilder.create().uv(0, 57).cuboid(-5.0F, -33.0F, -1.0F, 15.0F, 33.0F, 1.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(12.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData front = box.addChild("front", ModelPartBuilder.create().uv(64, 79)
                        .cuboid(8.0F, -32.0F, -2.0F, 3.0F, 32.0F, 1.0F, new Dilation(0.0F))
                        .uv(64, 61).cuboid(-8.0F, -17.0F, -2.0F, 16.0F, 17.0F, 1.0F, new Dilation(0.0F))
                        .uv(72, 0).cuboid(-8.0F, -32.0F, -2.0F, 16.0F, 4.0F, 1.0F, new Dilation(0.0F))
                        .uv(72, 79).cuboid(-11.0F, -32.0F, -2.0F, 3.0F, 32.0F, 1.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData straw = box.addChild("straw", ModelPartBuilder.create(),
                ModelTransform.pivot(-10.0F, -51.0F, -28.0F));

        ModelPartData bottom_r1 = straw.addChild("bottom_r1", ModelPartBuilder.create().uv(72, 11)
                        .cuboid(-4.0F, -33.0F, 15.0F, 5.0F, 1.0F, 4.0F, new Dilation(0.0F))
                        .uv(72, 5).cuboid(-9.0F, -33.0F, 10.0F, 10.0F, 1.0F, 5.0F, new Dilation(0.0F)),
                ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -0.2618F));

        ModelPartData orpheus = modelPartData.addChild("orpheus", ModelPartBuilder.create().uv(0, 118)
                        .cuboid(1.0F, -8.0F, 0.0F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F))
                        .uv(22, 112).cuboid(-4.0F, -8.0F, 0.0F, 3.0F, 7.0F, 3.0F, new Dilation(0.0F))
                        .uv(0, 104).cuboid(-4.0F, -19.0F, 0.0F, 8.0F, 11.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 25.0F, 2.0F));

        ModelPartData tail_r1 = orpheus.addChild("tail_r1",
                ModelPartBuilder.create().uv(34, 112).cuboid(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(0.0F, -9.0F, 2.0F, -0.6109F, 0.0F, 0.0F));

        ModelPartData rightarm_r1 = orpheus.addChild("rightarm_r1",
                ModelPartBuilder.create().uv(0, 118).cuboid(1.0F, -7.0F, -1.0F, 3.0F, 7.0F, 3.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(-8.0F, -20.0F, -6.0F, -1.8414F, 0.2527F, -0.0692F));

        ModelPartData leftarm_r1 = orpheus.addChild("leftarm_r1",
                ModelPartBuilder.create().uv(0, 118).cuboid(1.0F, -7.0F, -1.0F, 3.0F, 7.0F, 3.0F,
                        new Dilation(0.0F)),
                ModelTransform.of(3.0F, -20.0F, -7.0F, -1.8414F, -0.2527F, 0.0692F));

        ModelPartData head = orpheus.addChild("head", ModelPartBuilder.create().uv(0, 93)
                        .cuboid(-3.0F, -22.0F, -4.0F, 6.0F, 3.0F, 8.0F, new Dilation(0.0F))
                        .uv(22, 104).cuboid(-3.0F, -25.0F, -1.0F, 6.0F, 3.0F, 5.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
                       float green, float blue, float alpha) {
        cardboard.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        orpheus.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}