package net.shadew.asm.descriptor;

import net.shadew.util.contract.Validate;


public class PrimitiveDescriptor extends TypeDescriptor {
    public static final PrimitiveDescriptor BYTE = new PrimitiveDescriptor('B', 1, "byte");
    public static final PrimitiveDescriptor SHORT = new PrimitiveDescriptor('S', 1, "short");
    public static final PrimitiveDescriptor INT = new PrimitiveDescriptor('I', 1, "int");
    public static final PrimitiveDescriptor LONG = new PrimitiveDescriptor('J', 2, "long");
    public static final PrimitiveDescriptor FLOAT = new PrimitiveDescriptor('F', 1, "float");
    public static final PrimitiveDescriptor DOUBLE = new PrimitiveDescriptor('D', 2, "double");
    public static final PrimitiveDescriptor BOOLEAN = new PrimitiveDescriptor('Z', 1, "boolean");
    public static final PrimitiveDescriptor CHAR = new PrimitiveDescriptor('C', 1, "char");
    public static final PrimitiveDescriptor VOID = new PrimitiveDescriptor('V', 0, "void");

    private final char prefix;
    private final int size;
    private final String code;

    private PrimitiveDescriptor(char desc, int size, String code) {
        this.prefix = desc;
        this.size = size;
        this.code = code;
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public char prefix() {
        return prefix;
    }

    @Override
    public void accept(DescriptorVisitor visitor) {
        visitor.visitPrimitive(this);
    }

    @Override
    public PrimitiveDescriptor remap(Mapper mapper) {
        return this;
    }

    @Override
    public String toString() {
        return prefix + "";
    }

    @Override
    public String toCode() {
        return code;
    }

    public static PrimitiveDescriptor parse(String desc) {
        Validate.notNull(desc, "desc");
        return DescriptorParser.primitive(desc);
    }
}
