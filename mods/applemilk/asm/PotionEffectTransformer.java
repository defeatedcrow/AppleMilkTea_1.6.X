package mods.applemilk.asm;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.*;

/**
 * Created by A.K. on 14/07/07.
 */
public class PotionEffectTransformer implements IClassTransformer, Opcodes {

    private static final String TARGET_CLASS_NAME = "net.minecraft.potion.PotionEffect";
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (!FMLLaunchHandler.side().isClient() || !transformedName.equals(TARGET_CLASS_NAME)) {return basicClass;}
        try {
        	AppleMilkCorePlugin.logger.setParent(FMLLog.getLogger());
            AppleMilkCorePlugin.logger.info("Start transforming PotionEffect Class");
            ClassReader classReader = new ClassReader(basicClass);
            ClassWriter classWriter = new ClassWriter(1);
            classReader.accept(new CustomVisitor(name, classWriter), 8);
            AppleMilkCorePlugin.logger.info("Finish transforming PotionEffect Class");
            return classWriter.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("failed : PotionEffectTransformer loading", e);
        }
    }
    /*Custom ClassVisitor
    * visitMethodでメソッドを一から書き直すことが出来る。*/
    class CustomVisitor extends ClassVisitor {
        //難読化後のクラス名。FMLDeobfuscatingRemapper.INSTANCE.mapMethodNameを使う際に使用。
        String owner;
        public CustomVisitor(String owner ,ClassVisitor cv) {
            super(Opcodes.ASM4, cv);
            this.owner = owner;
        }
        static final String TARGET_METHOD_NAME1 = "func_76455_a";//onUpdate
        static final String TARGET_METHOD_NAME_DEBUG1 = "onUpdate";//開発環境で動かすとき用
        static final String TARGET_METHOD_DESC1 = "(Lnet/minecraft/entity/EntityLivingBase;)Z";//method description

        static final String TARGET_METHOD_NAME2 = "func_82722_b";//readCustomPotionEffectFromNBT
        static final String TARGET_METHOD_NAME_DEBUG2 = "readCustomPotionEffectFromNBT";//開発環境で動かすとき用
        static final String TARGET_METHOD_DESC2 = "(Lnet/minecraft/nbt/NBTTagCompound;)Lnet/minecraft/potion/PotionEffect;";//method description

        static final String TARGET_METHOD_NAME3 = "func_76456_a";//getPotionID
        static final String TARGET_METHOD_NAME_DEBUG3 = "getPotionID";//開発環境で動かすとき用
        static final String TARGET_METHOD_DESC3 = "()I";//method description

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            if (TARGET_METHOD_NAME1.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))
                    && TARGET_METHOD_DESC1.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(desc))) {
                AppleMilkCorePlugin.logger.info("Transforming onUpdate method");
                return new CustomMethodVisitor1(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }

            if (TARGET_METHOD_NAME2.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))
                    && TARGET_METHOD_DESC2.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(desc))) {
                AppleMilkCorePlugin.logger.info("Transforming readCustomPotionEffectFromNBT method");
                return new CustomMethodVisitor2(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }

            if (TARGET_METHOD_NAME3.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(owner, name, desc))
                    && TARGET_METHOD_DESC3.equals(FMLDeobfuscatingRemapper.INSTANCE.mapMethodDesc(desc))) {
                AppleMilkCorePlugin.logger.info("Transforming getPotionID method");
                return new CustomMethodVisitor3(this.api, super.visitMethod(access, name, desc, signature, exceptions));
            }
            return super.visitMethod(access, name, desc, signature, exceptions);
        }
    }

    /*Custom MethodVisitor
    * visit**Methodで、InsnNodeの入れ替えや、追加等出来る。*/
    class CustomMethodVisitor1 extends MethodVisitor {
        public CustomMethodVisitor1(int api, MethodVisitor mv) {
            super(api, mv);
        }

        static final int TARGET_LINE = 122;

        @Override
        public void visitLineNumber(int line, Label start) {
            super.visitLineNumber(line, start);
            if (line == TARGET_LINE) {
                AppleMilkCorePlugin.logger.info("change id in [0 - 255]");
                super.visitVarInsn(ALOAD, 0);
                super.visitVarInsn(ALOAD, 0);
                super.visitFieldInsn(GETFIELD, "net/minecraft/potion/PotionEffect", "potionID", "I");
                super.visitIntInsn(SIPUSH, 256);
                super.visitInsn(IADD);
                super.visitIntInsn(SIPUSH, 256);
                super.visitInsn(IREM);
                super.visitFieldInsn(PUTFIELD, "net/minecraft/potion/PotionEffect", "potionID", "I");
            }
        }
    }

    class CustomMethodVisitor2 extends MethodVisitor {
        public CustomMethodVisitor2(int api, MethodVisitor mv) {
            super(api, mv);
        }

        String fieldName = "";
        @Override
        public void visitLdcInsn(Object cst) {
            if (cst.equals("Id")) {
                fieldName = (String)cst;
            }
            super.visitLdcInsn(cst);
        }

        static final String TARGET_DESC = "(Ljava/lang/String;)B";
        @Override
        public void visitMethodInsn(int opcode, String owner, String name, String desc) {
            super.visitMethodInsn(opcode, owner, name, desc);
            if (opcode == INVOKEVIRTUAL && TARGET_DESC.equals(desc) && fieldName.equals("Id")) {
                fieldName = "";
                AppleMilkCorePlugin.logger.info("change id in [0 - 255]");
                super.visitIntInsn(SIPUSH, 256);
                super.visitInsn(IADD);
                super.visitIntInsn(SIPUSH, 256);
                super.visitInsn(IREM);
            }
        }
    }

    class CustomMethodVisitor3 extends MethodVisitor {
        public CustomMethodVisitor3(int api, MethodVisitor mv) {
            super(api, mv);
        }

        @Override
        public void visitFieldInsn(int opcode, String owner, String name, String desc) {
            super.visitFieldInsn(opcode, owner, name, desc);
            super.visitIntInsn(SIPUSH, 256);
            super.visitInsn(IADD);
            super.visitIntInsn(SIPUSH, 256);
            super.visitInsn(IREM);
        }
    }
}
