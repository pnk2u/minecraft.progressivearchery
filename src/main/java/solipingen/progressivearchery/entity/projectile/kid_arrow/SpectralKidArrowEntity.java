package solipingen.progressivearchery.entity.projectile.kid_arrow;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import solipingen.progressivearchery.entity.ModEntityTypes;
import solipingen.progressivearchery.item.ModItems;


public class SpectralKidArrowEntity extends KidArrowEntity {
    private int duration = 200;
    private static final double DAMAGE_AMOUNT = 3.0;

    
    public SpectralKidArrowEntity(EntityType<? extends SpectralKidArrowEntity> entityType, World world) {
        super(entityType, DAMAGE_AMOUNT, world);
    }

    public SpectralKidArrowEntity(World world, double x, double y, double z) {
        super(ModEntityTypes.SPECTRAL_KID_ARROW_ENTITY, DAMAGE_AMOUNT, world, x, y, z);
    }

    public SpectralKidArrowEntity(World world, LivingEntity owner) {
        super(ModEntityTypes.SPECTRAL_KID_ARROW_ENTITY, DAMAGE_AMOUNT, world, owner);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient && !this.inGround) {
            this.world.addParticle(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.SPECTRAL_KID_ARROW);
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        StatusEffectInstance statusEffectInstance = new StatusEffectInstance(StatusEffects.GLOWING, this.duration, 0);
        target.addStatusEffect(statusEffectInstance, this.getEffectCause());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("Duration")) {
            this.duration = nbt.getInt("Duration");
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Duration", this.duration);
    }
}

