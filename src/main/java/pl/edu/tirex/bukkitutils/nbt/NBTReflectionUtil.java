package pl.edu.tirex.bukkitutils.nbt;

import org.bukkit.inventory.ItemStack;
import pl.edu.tirex.bukkitutils.utils.Reflection;
import pl.edu.tirex.bukkitutils.utils.Reflection.ConstructorInvoker;
import pl.edu.tirex.bukkitutils.utils.Reflection.MethodInvoker;

public class NBTReflectionUtil
{
    private static final Class<?> nbtBaseClass = Reflection.getClass("{nms}.NBTBase");

    public static final Class<?> nbtTagCompoundClass = Reflection.getClass("{nms}.NBTTagCompound");
    public static final ConstructorInvoker nbtTagCompoundConstructor = Reflection.getConstructor(nbtTagCompoundClass);
    public static final MethodInvoker setMethod = Reflection.getMethod(nbtTagCompoundClass, "set", String.class, nbtBaseClass);
    public static final MethodInvoker setByteMethod = Reflection.getMethod(nbtTagCompoundClass, "setByte", String.class, byte.class);
    public static final MethodInvoker setShortMethod = Reflection.getMethod(nbtTagCompoundClass, "setShort", String.class, short.class);
    public static final MethodInvoker setIntMethod = Reflection.getMethod(nbtTagCompoundClass, "setInt", String.class, int.class);
    public static final MethodInvoker setLongMethod = Reflection.getMethod(nbtTagCompoundClass, "setLong", String.class, long.class);
    public static final MethodInvoker setFloatMethod = Reflection.getMethod(nbtTagCompoundClass, "setFloat", String.class, float.class);
    public static final MethodInvoker setDoubleMethod = Reflection.getMethod(nbtTagCompoundClass, "setDouble", String.class, double.class);
    public static final MethodInvoker setStringMethod = Reflection.getMethod(nbtTagCompoundClass, "setString", String.class, String.class);
    public static final MethodInvoker setByteArrayMethod = Reflection.getMethod(nbtTagCompoundClass, "setByteArray", String.class, byte[].class);
    public static final MethodInvoker setIntArrayMethod = Reflection.getMethod(nbtTagCompoundClass, "setIntArray", String.class, int[].class);
    public static final MethodInvoker setBooleanMethod = Reflection.getMethod(nbtTagCompoundClass, "setBoolean", String.class, boolean.class);
    public static final MethodInvoker getMethod = Reflection.getMethod(nbtTagCompoundClass, "get", String.class);
    public static final MethodInvoker getByteMethod = Reflection.getMethod(nbtTagCompoundClass, "getByte", String.class);
    public static final MethodInvoker getShortMethod = Reflection.getMethod(nbtTagCompoundClass, "getShort", String.class);
    public static final MethodInvoker getIntMethod = Reflection.getMethod(nbtTagCompoundClass, "getInt", String.class);
    public static final MethodInvoker getLongMethod = Reflection.getMethod(nbtTagCompoundClass, "getLong", String.class);
    public static final MethodInvoker getFloatMethod = Reflection.getMethod(nbtTagCompoundClass, "getFloat", String.class);
    public static final MethodInvoker getDoubleMethod = Reflection.getMethod(nbtTagCompoundClass, "getDouble", String.class);
    public static final MethodInvoker getStringMethod = Reflection.getMethod(nbtTagCompoundClass, "getString", String.class);
    public static final MethodInvoker getByteArrayMethod = Reflection.getMethod(nbtTagCompoundClass, "getByteArray", String.class);
    public static final MethodInvoker getIntArrayMethod = Reflection.getMethod(nbtTagCompoundClass, "getIntArray", String.class);
    public static final MethodInvoker getBooleanMethod = Reflection.getMethod(nbtTagCompoundClass, "getBoolean", String.class);
    public static final MethodInvoker getCompoundMethod = Reflection.getMethod(nbtTagCompoundClass, "getCompound", String.class);

    public static final Class<?> nmsItemStackClass = Reflection.getClass("{nms}.ItemStack");
    public static final MethodInvoker getTagMethod = Reflection.getMethod(nmsItemStackClass, "getTag");
    public static final MethodInvoker setTagMethod = Reflection.getMethod(nmsItemStackClass, "setTag", nbtTagCompoundClass);

    public static final Class<?> craftItemStackClass = Reflection.getClass("{obc}.inventory.CraftItemStack");
    public static final MethodInvoker asNMSCopyMethod = Reflection.getMethod(craftItemStackClass, "asNMSCopy", ItemStack.class);
    public static final MethodInvoker asBukkitCopyMethod = Reflection.getMethod(craftItemStackClass, "asBukkitCopy", nmsItemStackClass);
}
