package net.eps.amethystadds.client;

import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import net.eps.amethystadds.AmethystAdditions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// This class lovingly yoinked (& updated to 1.18) from
// https://github.com/VazkiiMods/Quark/blob/master/src/main/java/vazkii/quark/content/tools/client/GlintRenderType.java
// Published under the "CC BY-NC-SA 3.0" Creative Commons License
@Environment(EnvType.CLIENT)
public class ColoredGlintRenderLayer extends RenderLayer {

    public static List<RenderLayer> glintColor = newRenderList(ColoredGlintRenderLayer::buildGlintRenderLayer);
    public static List<RenderLayer> entityGlintColor = newRenderList(ColoredGlintRenderLayer::buildEntityGlintRenderLayer);
    public static List<RenderLayer> glintDirectColor = newRenderList(ColoredGlintRenderLayer::buildGlintDirectRenderLayer);
    public static List<RenderLayer> entityGlintDirectColor = newRenderList(ColoredGlintRenderLayer::buildEntityGlintDirectRenderLayer);

    public static List<RenderLayer> armorGlintColor = newRenderList(ColoredGlintRenderLayer::buildArmorGlintRenderLayer);
    public static List<RenderLayer> armorEntityGlintColor = newRenderList(ColoredGlintRenderLayer::buildArmorEntityGlintRenderLayer);

    public static List<RenderLayer> translucentGlintColor = newRenderList(ColoredGlintRenderLayer::buildTranslucentGlint);

    public static void addGlintTypes(Object2ObjectLinkedOpenHashMap<RenderLayer, BufferBuilder> map) {
        addGlintTypes(map, glintColor);
        addGlintTypes(map, entityGlintColor);
        addGlintTypes(map, glintDirectColor);
        addGlintTypes(map, entityGlintDirectColor);
        addGlintTypes(map, armorGlintColor);
        addGlintTypes(map, armorEntityGlintColor);
        addGlintTypes(map, translucentGlintColor);
    }

    public ColoredGlintRenderLayer(String name, VertexFormat vertexFormat, VertexFormat.DrawMode drawMode, int expectedBufferSize, boolean hasCrumbling, boolean translucent, Runnable startAction, Runnable endAction) {
        super(name, vertexFormat, drawMode, expectedBufferSize, hasCrumbling, translucent, startAction, endAction);
    }

    private static List<RenderLayer> newRenderList(Function<String, RenderLayer> func) {
        ArrayList<RenderLayer> list = new ArrayList<>(DyeColor.values().length);

        for (DyeColor color : DyeColor.values())
            list.add(func.apply(color.getName()));

        return list;
    }

    public static void addGlintTypes(Object2ObjectLinkedOpenHashMap<RenderLayer, BufferBuilder> map, List<RenderLayer> typeList) {
        for(RenderLayer renderType : typeList)
            if (!map.containsKey(renderType))
                map.put(renderType, new BufferBuilder(renderType.getExpectedBufferSize()));
    }

    private static RenderLayer buildGlintRenderLayer(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("glint_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, MultiPhaseParameters.builder()
                .program(ShaderProgram.GLINT_PROGRAM)
                //.shader(RenderPhase.GLINT_SHADER)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(GLINT_TEXTURING)
                .build(false));
    }

    private static RenderLayer buildEntityGlintRenderLayer(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("entity_glint_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, MultiPhaseParameters.builder()
                .program(ShaderProgram.ENTITY_GLINT_PROGRAM)
                //.shader(RenderPhase.ENTITY_GLINT_SHADER)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .target(ITEM_TARGET)
                .texturing(ENTITY_GLINT_TEXTURING)
                .build(false));
    }


    private static RenderLayer buildGlintDirectRenderLayer(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("glint_direct_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, MultiPhaseParameters.builder()
                .program(ShaderProgram.DIRECT_GLINT_PROGRAM)
                //.shader(RenderPhase.DIRECT_GLINT_SHADER)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(GLINT_TEXTURING)
                .build(false));
    }


    private static RenderLayer buildEntityGlintDirectRenderLayer(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("entity_glint_direct_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, MultiPhaseParameters.builder()
                .program(ShaderProgram.DIRECT_ENTITY_GLINT_PROGRAM)
                //.shader(RenderPhase.DIRECT_ENTITY_GLINT_SHADER)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(ENTITY_GLINT_TEXTURING)
                .build(false));
    }

    private static RenderLayer buildArmorGlintRenderLayer(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("armor_glint_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, MultiPhaseParameters.builder()
                .program(ShaderProgram.ARMOR_GLINT_PROGRAM)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(GLINT_TEXTURING)
                .layering(VIEW_OFFSET_Z_LAYERING)
                .build(false));
    }

    private static RenderLayer buildArmorEntityGlintRenderLayer(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("armor_entity_glint_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, MultiPhaseParameters.builder()
                .program(ShaderProgram.ARMOR_ENTITY_GLINT_PROGRAM)
                //.shader(RenderPhase.ARMOR_ENTITY_GLINT_SHADER)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(ENTITY_GLINT_TEXTURING)
                .layering(VIEW_OFFSET_Z_LAYERING)
                .build(false));
    }

    private static RenderLayer buildTranslucentGlint(String name) {
        final Identifier res = new Identifier(AmethystAdditions.MOD_ID, "textures/misc/glint_" + name + ".png");

        return RenderLayer.of("glint_translucent_" + name, VertexFormats.POSITION_TEXTURE, VertexFormat.DrawMode.QUADS, 256, RenderLayer.MultiPhaseParameters.builder()
                .program(ShaderProgram.TRANSLUCENT_GLINT_PROGRAM)
                //.shader(TRANSLUCENT_GLINT_SHADER)
                .texture(new Texture(res, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(EQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(GLINT_TEXTURING)
                .target(ITEM_TARGET)
                .build(false));
    }
}