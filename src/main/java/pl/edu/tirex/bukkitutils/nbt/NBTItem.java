package pl.edu.tirex.bukkitutils.nbt;

import org.bukkit.inventory.ItemStack;

public class NBTItem
{
    private ItemStack bukkitItem;

    public NBTItem(ItemStack item)
    {
        this.bukkitItem = item.clone();
    }

    public ItemStack getItem()
    {
        return this.bukkitItem;
    }

    public NBTTag getTag()
    {
        Object nmsItemStack = NBTReflectionUtil.asNMSCopyMethod.invoke(null, this.bukkitItem);
        if (nmsItemStack == null)
        {
            return null;
        }
        Object nbtTag = NBTReflectionUtil.getTagMethod.invoke(nmsItemStack);
        if (nbtTag == null)
        {
            nbtTag = NBTReflectionUtil.nbtTagCompoundConstructor.invoke();
        }
        return new NBTTag(nbtTag);
    }

    public void setTag(NBTTag tag)
    {
        Object nmsItemStack = NBTReflectionUtil.asNMSCopyMethod.invoke(null, this.bukkitItem);
        if (nmsItemStack == null)
        {
            return;
        }
        NBTReflectionUtil.setTagMethod.invoke(nmsItemStack, tag.getNMS());
        this.bukkitItem = (ItemStack) NBTReflectionUtil.asBukkitCopyMethod.invoke(null, nmsItemStack);
    }
}
