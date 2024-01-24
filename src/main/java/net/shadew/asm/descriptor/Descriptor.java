package net.shadew.asm.descriptor;

import net.shadew.util.contract.Validate;

public abstract class Descriptor {
    Descriptor() {
    }

    public boolean isMethod() {
        return false;
    }

    public boolean isType() {
        return false;
    }

    public boolean isReference() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public boolean isPrimitive() {
        return false;
    }

    public boolean isVoid() {
        return this == PrimitiveDescriptor.VOID;
    }

    public TypeDescriptor asType() {
        return (TypeDescriptor) this;
    }

    public MethodDescriptor asMethod() {
        return (MethodDescriptor) this;
    }

    public ReferenceDescriptor asReference() {
        return (ReferenceDescriptor) this;
    }

    public ArrayDescriptor asArray() {
        return (ArrayDescriptor) this;
    }

    public PrimitiveDescriptor asPrimitive() {
        return (PrimitiveDescriptor) this;
    }

    public abstract String toString();
    public abstract String toCode();
    public abstract String toCode(String memberName);

    public abstract Descriptor remap(Mapper mapper);

    public void accept(DescriptorVisitor visitor) {
        visitor.visit(this);
    }

    public static Descriptor parse(String desc) {
        Validate.notNull(desc, "desc");
        return DescriptorParser.descriptor(desc);
    }

}
