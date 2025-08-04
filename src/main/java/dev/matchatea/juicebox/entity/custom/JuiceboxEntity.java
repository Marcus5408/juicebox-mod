package dev.matchatea.juicebox.entity.custom;

import dev.matchatea.juicebox.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class JuiceboxEntity extends AnimalEntity {
    public JuiceboxEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1));
        this.goalSelector.add(2, new TemptGoal(this, 0.4F, Ingredient.ofItems(
                Items.APPLE,
                Items.BEETROOT,
                Items.CARROT,
                Items.CHORUS_FRUIT,
                Items.ENCHANTED_GOLDEN_APPLE,
                Items.GOLDEN_APPLE,
                Items.GLOW_BERRIES,
                Items.GOLDEN_CARROT,
                Items.HONEY_BOTTLE,
                Items.MELON_SLICE,
                Items.SWEET_BERRIES), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.4F)); // reduced speed
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createJuiceboxAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F) // reduced speed
                .add(EntityAttributes.GENERIC_ARMOR, 2F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0F);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.ENCHANTED_GOLDEN_APPLE)
                || stack.isOf(Items.GOLDEN_APPLE)
                || stack.isOf(Items.GOLDEN_CARROT);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.JUICEBOX.create(world);
    }
}
