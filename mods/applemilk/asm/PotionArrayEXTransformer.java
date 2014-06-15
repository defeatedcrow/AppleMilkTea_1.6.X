package mods.applemilk.asm;


import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

/**
* Original code was created by A.K.
*/
public class PotionArrayEXTransformer implements IClassTransformer, Opcodes{
    private static final String TARGET_CLASS_NAME = "net.minecraft.potion.Potion";
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (!transformedName.equals(TARGET_CLASS_NAME)) {return basicClass;}
        try {
            AppleMilkCorePlugin.logger.info("Start transforming Potion Class");
            basicClass = extendPotionArray(name, basicClass);
            AppleMilkCorePlugin.logger.info("Finish transforming Potion Class");
            return basicClass;
        } catch (Exception e) {
            throw new RuntimeException("failed : PotionArrayEXTransformer loading", e);
        }
    }

    private byte[] extendPotionArray(String target, byte[] bytes) {
        ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(bytes);
        classReader.accept(classNode, 0);
        String targetMethodName = "<clinit>";//static init method
        MethodNode mnode = null;
        for (MethodNode curMnode : classNode.methods) {
            if (targetMethodName.equals(curMnode.name)) {
                mnode = curMnode;
                break;
            }
        }
        if (mnode != null) {
            AbstractInsnNode oldInsnNode = mnode.instructions.get(2);
            AbstractInsnNode newInsnNode = new VarInsnNode(Opcodes.BIPUSH, Byte.MAX_VALUE);
            mnode.instructions.set(oldInsnNode, newInsnNode);
            ClassWriter cw = new ClassWriter((ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS));
            classNode.accept(cw);
            bytes = cw.toByteArray();
        }
        return bytes;
    }
}
