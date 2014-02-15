package com.matt.mod.kernelcraft.blocks;

import net.minecraft.block.BlockChest;
import net.minecraft.world.World;
import net.minecraft.util.Icon;
import net.minecraft.util.EnumFacing;
import net.minecraft.client.renderer.texture.IconRegister;

import com.matt.lib.Ref;
import com.matt.mod.kernelcraft.tileentities.TileEntityKernelChest;

public class BlockKernelChest extends BlockChest {
	protected Icon top;
	protected Icon front;
	protected Icon side;
	protected Icon bottom;
	//0=normal,1=left,2=back,3=right

	public BlockKernelChest(int par1) {
		super(par1, 0);
		setUnlocalizedName("Kernel Chest");
		setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
	}
	
	@Override
	public void registerIcons(IconRegister r) {
		top=r.registerIcon(Ref.NAME.toLowerCase() + ":kernelChestTop");
		front=r.registerIcon(Ref.NAME.toLowerCase() + ":kernelChestFront");
		side=r.registerIcon(Ref.NAME.toLowerCase() + ":kernelChestSide");
		bottom=r.registerIcon(Ref.NAME.toLowerCase() + ":kernelChestBottom");
	}
	
	@Override
	public Icon getIcon(int side,int meta) {
		if(side==0) {
			return bottom;
		}
		if(side==1) {
			return top;
		}
		if((side==2&&meta==0)||(side==3&&meta==2)||(side==4&&meta==1)||(side==5&&meta==3)) {
			return front;
		}
		return this.side;
	}
	
	@Override
	public TileEntityKernelChest createNewTileEntity(World w) {
		return new TileEntityKernelChest();
	}
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return true;
	}
	
	@Override
	public int getRenderType() {
		return 0;
	}
	
	
}
