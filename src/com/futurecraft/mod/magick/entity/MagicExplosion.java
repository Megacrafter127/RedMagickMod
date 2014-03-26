package com.futurecraft.mod.magick.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MagicExplosion extends Entity {

	protected int field_77289_h=16;
	protected Entity cause;
	protected float explosionSize;
	protected Explosion resambleance;
    public List affectedBlockPositions = new ArrayList();
	private boolean isSmoking;
	private boolean isFlaming;
    private Random explosionRNG = new Random();


	public MagicExplosion(World par1World, Entity par2Entity, double par3,
			double par5, double par7, float par9) {
		super(par1World);
		posX=par3;
		posY=par5;
		posZ=par7;
		explosionSize=par9;
		cause=par2Entity;
		resambleance=new Explosion(par1World,par2Entity,par3,par5,par7,par9);
	}
	
	@Override
	public void onEntityUpdate() {

        float f = this.explosionSize;
        HashSet hashset = new HashSet();
        int i;
        int j;
        int k;
        double d0;
        double d1;
        double d2;

        for (i = 0; i < this.field_77289_h; ++i)
        {
            for (j = 0; j < this.field_77289_h; ++j)
            {
                for (k = 0; k < this.field_77289_h; ++k)
                {
                    if (i == 0 || i == this.field_77289_h - 1 || j == 0 || j == this.field_77289_h - 1 || k == 0 || k == this.field_77289_h - 1)
                    {
                        double d3 = (double)((float)i / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                        double d4 = (double)((float)j / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                        double d5 = (double)((float)k / ((float)this.field_77289_h - 1.0F) * 2.0F - 1.0F);
                        double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
                        d3 /= d6;
                        d4 /= d6;
                        d5 /= d6;
                        float f1 = this.explosionSize * (0.7F + this.worldObj.rand.nextFloat() * 0.6F);
                        d0 = this.posX;
                        d1 = this.posY;
                        d2 = this.posZ;

                        for (float f2 = 0.3F; f1 > 0.0F; f1 -= f2 * 0.75F)
                        {
                            int l = MathHelper.floor_double(d0);
                            int i1 = MathHelper.floor_double(d1);
                            int j1 = MathHelper.floor_double(d2);
                            int k1 = this.worldObj.getBlockId(l, i1, j1);

                            if (k1 > 0)
                            {
                                Block block = Block.blocksList[k1];
                                float f3 = this.cause != null ? this.cause.getBlockExplosionResistance(resambleance, this.worldObj, l, i1, j1, block) : block.getExplosionResistance(this.cause, worldObj, l, i1, j1, posX, posY, posZ);
                                f1 -= (f3 + 0.3F) * f2;
                            }

                            if (f1 > 0.0F && (this.cause == null || this.cause.shouldExplodeBlock(resambleance, this.worldObj, l, i1, j1, k1, f1)))
                            {
                                hashset.add(new ChunkPosition(l, i1, j1));
                            }

                            d0 += d3 * (double)f2;
                            d1 += d4 * (double)f2;
                            d2 += d5 * (double)f2;
                        }
                    }
                }
            }
        }

        this.affectedBlockPositions.addAll(hashset);
        this.explosionSize *= 2.0F;
        i = MathHelper.floor_double(this.posX - (double)this.explosionSize - 1.0D);
        j = MathHelper.floor_double(this.posX + (double)this.explosionSize + 1.0D);
        k = MathHelper.floor_double(this.posY - (double)this.explosionSize - 1.0D);
        int l1 = MathHelper.floor_double(this.posY + (double)this.explosionSize + 1.0D);
        int i2 = MathHelper.floor_double(this.posZ - (double)this.explosionSize - 1.0D);
        int j2 = MathHelper.floor_double(this.posZ + (double)this.explosionSize + 1.0D);
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.cause, AxisAlignedBB.getAABBPool().getAABB((double)i, (double)k, (double)i2, (double)j, (double)l1, (double)j2));
        Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);

        for (int k2 = 0; k2 < list.size(); ++k2)
        {
            Entity entity = (Entity)list.get(k2);
            double d7 = entity.getDistance(this.posX, this.posY, this.posZ) / (double)this.explosionSize;

            if (d7 <= 1.0D)
            {
                d0 = entity.posX - this.posX;
                d1 = entity.posY + (double)entity.getEyeHeight() - this.posY;
                d2 = entity.posZ - this.posZ;
                double d8 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);

                if (d8 != 0.0D)
                {
                    d0 /= d8;
                    d1 /= d8;
                    d2 /= d8;
                    double d9 = (double)this.worldObj.getBlockDensity(vec3, entity.boundingBox);
                    double d10 = (1.0D - d7) * d9;
                    entity.attackEntityFrom(DamageSource.setExplosionSource(resambleance).setMagicDamage(), (float)((int)((d10 * d10 + d10) / 2.0D * 8.0D * (double)this.explosionSize + 1.0D)));
                    double d11 = EnchantmentProtection.func_92092_a(entity, d10);
                    entity.motionX += d0 * d11;
                    entity.motionY += d1 * d11;
                    entity.motionZ += d2 * d11;

                    if (entity instanceof EntityPlayer)
                    {
                        this.resambleance.func_77277_b().put((EntityPlayer)entity, this.worldObj.getWorldVec3Pool().getVecFromPool(d0 * d10, d1 * d10, d2 * d10));
                    }
                }
            }
        }

        this.explosionSize = f;
        this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 4.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);

        if (this.explosionSize >= 2.0F && this.isSmoking)
        {
            this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
        }
        else
        {
            this.worldObj.spawnParticle("largeexplode", this.posX, this.posY, this.posZ, 1.0D, 0.0D, 0.0D);
        }

        Iterator iterator;
        ChunkPosition chunkposition;
        int l;
        boolean par1=true;

        if (this.isSmoking)
        {
            iterator = this.affectedBlockPositions.iterator();

            while (iterator.hasNext())
            {
                chunkposition = (ChunkPosition)iterator.next();
                i = chunkposition.x;
                j = chunkposition.y;
                k = chunkposition.z;
                l = this.worldObj.getBlockId(i, j, k);

                if (par1)
                {
                    d0 = (double)((float)i + this.worldObj.rand.nextFloat());
                    d1 = (double)((float)j + this.worldObj.rand.nextFloat());
                    d2 = (double)((float)k + this.worldObj.rand.nextFloat());
                    double d3 = d0 - this.posX;
                    double d4 = d1 - this.posY;
                    double d5 = d2 - this.posZ;
                    double d6 = (double)MathHelper.sqrt_double(d3 * d3 + d4 * d4 + d5 * d5);
                    d3 /= d6;
                    d4 /= d6;
                    d5 /= d6;
                    double d7 = 0.5D / (d6 / (double)this.explosionSize + 0.1D);
                    d7 *= (double)(this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3F);
                    d3 *= d7;
                    d4 *= d7;
                    d5 *= d7;
                    this.worldObj.spawnParticle("explode", (d0 + this.posX * 1.0D) / 2.0D, (d1 + this.posY * 1.0D) / 2.0D, (d2 + this.posZ * 1.0D) / 2.0D, d3, d4, d5);
                    this.worldObj.spawnParticle("smoke", d0, d1, d2, d3, d4, d5);
                }

                if (l > 0)
                {
                    Block block = Block.blocksList[l];

                    if (block.canDropFromExplosion(resambleance))
                    {
                        block.dropBlockAsItemWithChance(this.worldObj, i, j, k, this.worldObj.getBlockMetadata(i, j, k), 1.0F / this.explosionSize, 0);
                    }

                    block.onBlockExploded(this.worldObj, i, j, k, resambleance);
                }
            }
        }

        if (this.isFlaming)
        {
            iterator = this.affectedBlockPositions.iterator();

            while (iterator.hasNext())
            {
                chunkposition = (ChunkPosition)iterator.next();
                i = chunkposition.x;
                j = chunkposition.y;
                k = chunkposition.z;
                l = this.worldObj.getBlockId(i, j, k);
                int i1 = this.worldObj.getBlockId(i, j - 1, k);

                if (l == 0 && Block.opaqueCubeLookup[i1] && this.explosionRNG.nextInt(3) == 0)
                {
                    this.worldObj.setBlock(i, j, k, Block.fire.blockID);
                }
            }
        }
        setDead();
	}
	@Override
	public void onUpdate() {
		onEntityUpdate();
	}
	

	@Override
	protected void entityInit() {}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbt) {
		posX=nbt.getDouble("x");
		posY=nbt.getDouble("y");
		posZ=nbt.getDouble("z");
		explosionSize=nbt.getFloat("eS");
		field_77289_h=nbt.getInteger("f");
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbt) {
		nbt.setDouble("x", posX);
		nbt.setDouble("y", posY);
		nbt.setDouble("z", posZ);
		nbt.setFloat("eS", explosionSize);
		nbt.setInteger("f", field_77289_h);
	}
}
