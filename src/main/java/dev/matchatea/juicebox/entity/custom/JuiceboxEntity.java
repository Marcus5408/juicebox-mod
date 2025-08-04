package dev.matchatea.juicebox.entity.custom;

import dev.matchatea.juicebox.entity.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class JuiceboxEntity extends TameableEntity {
    public JuiceboxEntity(EntityType<? extends JuiceboxEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1));
        this.goalSelector.add(2, new TemptGoal(this, 0.6F, Ingredient.ofItems(
                Items.ENCHANTED_GOLDEN_APPLE,
                Items.GOLDEN_APPLE,
                Items.GOLDEN_CARROT,
                Items.APPLE,
                Items.BEETROOT,
                Items.CARROT,
                Items.CHORUS_FRUIT,
                Items.GLOW_BERRIES,
                Items.HONEY_BOTTLE,
                Items.MELON_SLICE,
                Items.SWEET_BERRIES), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 0.6F));
        this.goalSelector.add(4, new FollowOwnerGoal(this, 0.75F, 4.0F, 1.0F, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createJuiceboxAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5F)
                .add(EntityAttributes.GENERIC_ARMOR, 10F);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.ENCHANTED_GOLDEN_APPLE)
                || stack.isOf(Items.GOLDEN_APPLE)
                || stack.isOf(Items.GOLDEN_CARROT);
    }

    @Override
    public net.minecraft.util.ActionResult interactMob(PlayerEntity player, net.minecraft.util.Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        // Taming items: apple, beetroot, carrot, chorus fruit, glow berries, honey
        // bottle, melon slice, sweet berries
        boolean isTamingItem = itemStack.isOf(Items.APPLE)
                || itemStack.isOf(Items.BEETROOT)
                || itemStack.isOf(Items.CARROT)
                || itemStack.isOf(Items.CHORUS_FRUIT)
                || itemStack.isOf(Items.GLOW_BERRIES)
                || itemStack.isOf(Items.HONEY_BOTTLE)
                || itemStack.isOf(Items.MELON_SLICE)
                || itemStack.isOf(Items.SWEET_BERRIES);
        if (this.getWorld().isClient) {
            boolean canTame = !this.isTamed() && isTamingItem;
            return canTame ? net.minecraft.util.ActionResult.CONSUME : net.minecraft.util.ActionResult.PASS;
        } else {
            if (!this.isTamed() && isTamingItem) {
                if (!player.getAbilities().creativeMode) {
                    itemStack.decrement(1);
                }
                if (this.random.nextInt(3) == 0) {
                    this.setOwner(player);
                    this.setTamed(true);
                    this.navigation.stop();
                    this.setTarget(null);
                    this.getWorld().sendEntityStatus(this, (byte) 7); // hearts
                } else {
                    this.getWorld().sendEntityStatus(this, (byte) 6); // smoke
                }
                return net.minecraft.util.ActionResult.SUCCESS;
            }
            return super.interactMob(player, hand);
        }
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.JUICEBOX.create(world);
    }

    @Override
    public net.minecraft.world.EntityView method_48926() {
        return this.getWorld();
    }

    @Override
    public @Nullable LivingEntity getOwner() {
        return super.getOwner();
    }

    @Override
    public void onDeath(DamageSource source) {
        if (!this.getWorld().isClient && this.isTamed()) {
            LivingEntity owner = this.getOwner();
            if (owner instanceof PlayerEntity player) {
                player.sendMessage(
                    Text.literal("Your Juicebox has died :("), false
                );
            }
        }
        super.onDeath(source);
    }
}
