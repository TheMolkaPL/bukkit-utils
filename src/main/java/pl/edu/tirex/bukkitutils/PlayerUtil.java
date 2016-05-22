package pl.edu.tirex.bukkitutils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import pl.edu.tirex.bukkitutils.utils.Reflection;
import pl.edu.tirex.bukkitutils.utils.Reflection.FieldAccessor;
import pl.edu.tirex.bukkitutils.utils.Reflection.MethodInvoker;

public class PlayerUtil
{
    private static final Class<?> entityPlayerClass = Reflection.getClass("{nms}.EntityPlayer");

    private static final Class<?> craftPlayerClass = Reflection.getClass("{obc}.entity.CraftPlayer");
    private static final MethodInvoker getHandleMethod = Reflection.getMethod(craftPlayerClass, "getHandle");

    private static final Class<?> entityClass = Reflection.getClass("{nms}.Entity");
    private static final MethodInvoker setLocationMethod = Reflection.getMethod(entityClass, "setLocation", double.class, double.class, double.class, float.class, float.class);

    private static final Class<?> craftWorldClass = Reflection.getClass("{obc}.CraftWorld");
    private static final MethodInvoker getHandleWorldMethod = Reflection.getMethod(craftWorldClass, "getHandle");

    private static final Class<?> craftServerClass = Reflection.getClass("{obc}.CraftServer");
    private static final MethodInvoker getHandleServerMethod = Reflection.getMethod(craftServerClass, "getHandle");
    private static final MethodInvoker moveToWorldMethod = Reflection.getMethod("{nms}.PlayerList", "moveToWorld", entityPlayerClass, int.class, boolean.class, Location.class, boolean.class);
    private static final FieldAccessor<Integer> dimensionField = Reflection.getField("{nms}.WorldServer", "dimension", int.class);

    public static void teleportFakePlayer(Player player, Location location)
    {
        Object entity = getHandleMethod.invoke(player);

        player.closeInventory();

        Location currentLocation = player.getLocation();
        if (location.getWorld().equals(currentLocation.getWorld()))
        {
            setLocationMethod.invoke(entity, location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
            return;
        }

        Object playerList = getHandleServerMethod.invoke(Bukkit.getServer());
        Object toWorld = getHandleWorldMethod.invoke(location.getWorld());

        moveToWorldMethod.invoke(playerList, entity, dimensionField.get(toWorld), true, location, true);
    }
}
