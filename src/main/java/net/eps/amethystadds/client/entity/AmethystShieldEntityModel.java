package net.eps.amethystadds.client.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class AmethystShieldEntityModel extends ShieldEntityModel {
    private final ModelPart root;
    private final ModelPart amethyst_0;
    private final ModelPart amethyst_1;
    private final ModelPart amethyst_2;
    private final ModelPart amethyst_3;
    private final ModelPart amethyst_4;
    private final ModelPart amethyst_5;
    private final ModelPart amethyst_6;
    private final ModelPart amethyst_7;
    private final ModelPart amethyst_base_0;
    private final ModelPart amethyst_base_1;
    private final ModelPart amethyst_base_2;
    private final ModelPart amethyst_base_3;
    private final ModelPart amethyst_base_4;
    private final ModelPart amethyst_base_5;
    private final ModelPart amethyst_base_6;
    private final ModelPart amethyst_base_7;

    public AmethystShieldEntityModel(ModelPart root) {
        super(root);
        this.root = root;

        this.amethyst_0 = root.getChild("amethyst_0.1");
        this.amethyst_1 = root.getChild("amethyst_1.1");

        this.amethyst_2 = root.getChild("amethyst_2.1");
        this.amethyst_3 = root.getChild("amethyst_3.1");

        this.amethyst_4 = root.getChild("amethyst_4.1");
        this.amethyst_5 = root.getChild("amethyst_5.1");

        this.amethyst_6 = root.getChild("amethyst_6.1");
        this.amethyst_7 = root.getChild("amethyst_7.1");

        this.amethyst_base_0 = root.getChild("amethyst_base_0");
        this.amethyst_base_1 = root.getChild("amethyst_base_1");
        this.amethyst_base_2 = root.getChild("amethyst_base_2");
        this.amethyst_base_3 = root.getChild("amethyst_base_3");
        this.amethyst_base_4 = root.getChild("amethyst_base_4");
        this.amethyst_base_5 = root.getChild("amethyst_base_5");
        this.amethyst_base_6 = root.getChild("amethyst_base_6");
        this.amethyst_base_7 = root.getChild("amethyst_base_7");
    }

    public static TexturedModelData getShardTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();


        modelPartData.addChild("plate", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -11.0F, -2.0F, 12.0F, 22.0F, 1.0F), ModelTransform.NONE);
        modelPartData.addChild("handle", ModelPartBuilder.create().uv(26, 0).cuboid(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 6.0F), ModelTransform.NONE);

        modelPartData.addChild("amethyst_0.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(-2, -7, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_0.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_1.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(5, -7, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_1.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_2.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(-2, -2, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_2.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_3.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(5, -2, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_3.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_4.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(-2, 3, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_4.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_5.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(5, 3, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_5.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_6.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(-2, 8, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_6.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_7.1", ModelPartBuilder.create().uv(1, 0).cuboid(0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F), ModelTransform.of(5, 8, -2, -0.5F, 0, 3.11F))
                     .addChild("amethyst_7.2", ModelPartBuilder.create().uv(1, 5).cuboid(0.0F, 5.0F, 0.0F, 1.0F, 1.0F, 0.0F), ModelTransform.NONE);

        modelPartData.addChild("amethyst_base_0", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_1", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -8.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_2", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -3.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_3", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, -3.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_4", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 2.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_5", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, 2.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_6", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, 7.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);
        modelPartData.addChild("amethyst_base_7", ModelPartBuilder.create().uv(0, 0).cuboid(3.0F, 7.0F, -2.00049F, 2.0F, 2.0F, 0.0F), ModelTransform.NONE);

        return TexturedModelData.of(modelData, 16, 16);
    }

    public ModelPart getShard_0() {
        return this.amethyst_0;
    }
    public ModelPart getShard_1() {
        return this.amethyst_1;
    }

    public ModelPart getShard_2() {
        return this.amethyst_2;
    }
    public ModelPart getShard_3() {
        return this.amethyst_3;
    }

    public ModelPart getShard_4() {
        return this.amethyst_4;
    }
    public ModelPart getShard_5() {
        return this.amethyst_5;
    }

    public ModelPart getShard_6() {
        return this.amethyst_6;
    }
    public ModelPart getShard_7() {
        return this.amethyst_7;
    }

    public ModelPart getShardBase_0() {
        return this.amethyst_base_0;
    }
    public ModelPart getShardBase_1() {
        return this.amethyst_base_1;
    }
    public ModelPart getShardBase_2() {
        return this.amethyst_base_2;
    }
    public ModelPart getShardBase_3() {
        return this.amethyst_base_3;
    }
    public ModelPart getShardBase_4() {
        return this.amethyst_base_4;
    }
    public ModelPart getShardBase_5() {
        return this.amethyst_base_5;
    }
    public ModelPart getShardBase_6() {
        return this.amethyst_base_6;
    }
    public ModelPart getShardBase_7() {
        return this.amethyst_base_7;
    }

    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.root.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}