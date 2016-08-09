package river.vm;

/**
 * File : ByteCode.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:26
 */
public class ByteCode {

    public static final int FALSE = 0;
    public static final int TRUE = 1;

    // Different type of bytecode
    public static final byte IADD = 1;
    public static final byte ISUB = 2;
    public static final byte IMUL = 3;
    public static final byte IDIV = 4;
    public static final byte ILT = 5;
    public static final byte IEQ = 6;
    public static final byte JMP = 7;
    public static final byte JMPT = 8;
    public static final byte JMPF = 9;
    public static final byte IPUSH = 10;
    public static final byte LOAD = 11;
    public static final byte LOADG = 12;
    public static final byte STORE = 13;
    public static final byte STOREG = 14;
    public static final byte PRINT = 15;
    public static final byte POP = 16;
    public static final byte CALL = 17;
    public static final byte RET = 18;
    public static final byte HALT = 19;

    public static Instruction[] instructions = new Instruction[]{
            null,
            new Instruction("iadd"),
            new Instruction("isub"),
            new Instruction("imul"),
            new Instruction("idiv"),
            new Instruction("ilt"),
            new Instruction("ieq"),
            new Instruction("jmp", 1),
            new Instruction("jmpt", 1),
            new Instruction("jmpf", 1),
            new Instruction("ipush", 1),
            new Instruction("load", 1),
            new Instruction("loadg", 1),
            new Instruction("store", 1),
            new Instruction("storeg", 1),
            new Instruction("print"),
            new Instruction("pop"),
            new Instruction("call", 1),
            new Instruction("ret"),
            new Instruction("halt")
    };


}
