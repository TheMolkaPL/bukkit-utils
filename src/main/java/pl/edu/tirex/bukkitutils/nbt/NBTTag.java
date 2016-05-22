package pl.edu.tirex.bukkitutils.nbt;

public class NBTTag
{
    private Object nbtTag;

    public NBTTag(Object nbtTag)
    {
        this.nbtTag = nbtTag;
    }

    public NBTTag()
    {
        this(NBTReflectionUtil.nbtTagCompoundConstructor.invoke());
    }

    public Object getNMS()
    {
        return this.nbtTag;
    }


    public void setByte(String key, byte value)
    {
        NBTReflectionUtil.setByteMethod.invoke(this.nbtTag, key, value);
    }

    public byte getByte(String key)
    {
        return (byte) NBTReflectionUtil.getByteMethod.invoke(this.nbtTag, key);
    }


    public void setShort(String key, short value)
    {
        NBTReflectionUtil.setShortMethod.invoke(this.nbtTag, key, value);
    }

    public short getShort(String key)
    {
        return (short) NBTReflectionUtil.getShortMethod.invoke(this.nbtTag, key);
    }


    public void setInt(String key, int value)
    {
        NBTReflectionUtil.setIntMethod.invoke(this.nbtTag, key, value);
    }

    public int getInt(String key)
    {
        return (int) NBTReflectionUtil.getIntMethod.invoke(this.nbtTag, key);
    }


    public void setLong(String key, long value)
    {
        NBTReflectionUtil.setLongMethod.invoke(this.nbtTag, key, value);
    }

    public long getLong(String key)
    {
        return (long) NBTReflectionUtil.getLongMethod.invoke(this.nbtTag, key);
    }


    public void setFloat(String key, float value)
    {
        NBTReflectionUtil.setFloatMethod.invoke(this.nbtTag, key, value);
    }

    public float getFloat(String key)
    {
        return (float) NBTReflectionUtil.getFloatMethod.invoke(this.nbtTag, key);
    }


    public void setDouble(String key, double value)
    {
        NBTReflectionUtil.setDoubleMethod.invoke(this.nbtTag, key, value);
    }

    public double getDouble(String key)
    {
        return (double) NBTReflectionUtil.getDoubleMethod.invoke(this.nbtTag, key);
    }


    public void setByteArray(String key, byte[] value)
    {
        NBTReflectionUtil.setByteArrayMethod.invoke(this.nbtTag, key, value);
    }

    public byte[] getByteArray(String key)
    {
        return (byte[]) NBTReflectionUtil.getByteArrayMethod.invoke(this.nbtTag, key);
    }


    public void setIntArray(String key, int[] value)
    {
        NBTReflectionUtil.setIntArrayMethod.invoke(this.nbtTag, key, value);
    }

    public int[] getIntArray(String key)
    {
        return (int[]) NBTReflectionUtil.getIntArrayMethod.invoke(this.nbtTag, key);
    }


    public void setBoolean(String key, boolean value)
    {
        NBTReflectionUtil.setBooleanMethod.invoke(this.nbtTag, key, value);
    }

    public boolean getBoolean(String key)
    {
        return (boolean) NBTReflectionUtil.getBooleanMethod.invoke(this.nbtTag, key);
    }


    public void setString(String key, String value)
    {
        NBTReflectionUtil.setStringMethod.invoke(this.nbtTag, key, value);
    }

    public String getString(String key)
    {
        return (String) NBTReflectionUtil.getStringMethod.invoke(this.nbtTag, key);
    }


    public NBTTag getCompound(String key)
    {
        Object compound = NBTReflectionUtil.getCompoundMethod.invoke(this.nbtTag, key);
        if (compound == null)
        {
            return null;
        }
        return new NBTTag(compound);
    }

    public void setCompound(String key, NBTTag value)
    {
        NBTReflectionUtil.setMethod.invoke(this.nbtTag, key, value.nbtTag);
    }
}
