package supercoder79.supertech112.api.nbt;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTUtils {
    //copied from GTWW, TODO: fix this up to not be like shit
    public static boolean NBTGetBoolean(ItemStack stack, String name){
        NBTTagCompound nbt;
        if (stack.hasTagCompound()){ // check if the stack has nbt attatched
            nbt = stack.getTagCompound();
        } else { // if it doesn't, then create a new tag compound
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }

        if (nbt.hasKey(name)) { //check if the key exists
            return nbt.getBoolean(name); //if the key does exist, simply return
        } else {
            nbt.setInteger(name, 0); //if the key doesnt exist, initalize the key to 0
            return false;
        }
    }
}
