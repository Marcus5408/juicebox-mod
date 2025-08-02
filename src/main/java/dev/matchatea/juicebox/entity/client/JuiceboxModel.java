package dev.matchatea.juicebox.entity.client;

import dev.matchatea.juicebox.Juicebox;
import dev.matchatea.juicebox.entity.custom.JuiceboxEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class JuiceboxModel<T extends JuiceboxEntity> extends EntityModel<T> {
	private final ModelPart box;
	private final ModelPart front;
	private final ModelPart straw;
	private final ModelPart bb_main;
	public JuiceboxModel(ModelPart root) {
		this.box = root.getChild("box");
		this.front = this.box.getChild("front");
		this.straw = this.box.getChild("straw");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData box = modelPartData.addChild("box", ModelPartBuilder.create().uv(0, 0).cuboid(-11.0F, -32.0F, 11.0F, 22.0F, 28.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData top_r1 = box.addChild("top_r1", ModelPartBuilder.create().uv(-22, 0).cuboid(-3.0F, -32.0F, -3.0F, 12.0F, 0.0F, 22.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData right_r1 = box.addChild("right_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -32.0F, -1.0F, 12.0F, 28.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-10.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData left_r1 = box.addChild("left_r1", ModelPartBuilder.create().uv(40, 0).cuboid(-3.0F, -32.0F, -1.0F, 12.0F, 28.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, 0.0F, 8.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData front = box.addChild("front", ModelPartBuilder.create().uv(0, 0).cuboid(8.0F, -32.0F, -1.0F, 3.0F, 28.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-8.0F, -18.0F, -1.0F, 16.0F, 14.0F, 0.0F, new Dilation(0.0F))
		.uv(32, 0).cuboid(-8.0F, -32.0F, -1.0F, 16.0F, 4.0F, 0.0F, new Dilation(0.0F))
		.uv(58, 0).cuboid(-11.0F, -32.0F, -1.0F, 3.0F, 28.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData straw = box.addChild("straw", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, -51.0F, -28.0F));

		ModelPartData bottom_r1 = straw.addChild("bottom_r1", ModelPartBuilder.create().uv(20, 17).cuboid(-4.0F, -32.0F, 15.0F, 5.0F, 0.0F, 5.0F, new Dilation(0.0F))
		.uv(17, 23).cuboid(-9.0F, -32.0F, 10.0F, 10.0F, 0.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, -0.2618F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData shade_r1 = bb_main.addChild("shade_r1", ModelPartBuilder.create().uv(-18, 28).cuboid(-3.0F, -32.0F, -1.0F, 8.0F, 0.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -1.0F, 15.0F, 1.5708F, 1.0472F, 1.5708F));

		ModelPartData table_r1 = bb_main.addChild("table_r1", ModelPartBuilder.create().uv(-2, 28).cuboid(-4.0F, -32.0F, -1.0F, 5.0F, 0.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, 14.0F, -4.0F, 0.0F, 1.5708F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		box.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}