package river.vm;

import static river.vm.ByteCode.*;

/**
 * File : RiverVM.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:37
 */
public class RiverVM {

    public static final int DEFAULT_STACK_SIZE = 100;

    // Registers
    int ip; // Instruction pointer
    int sp = -1; // Stack pointers

    // Memories
    int[] code; // Code memory
    int[] globals; // Global variable memory
    int[] stack; // Stack memory
    Context ctx;

    public RiverVM(int[] code, int numberOfGlobals) {
        this.code = code;
        globals = new int[numberOfGlobals];
        stack = new int[DEFAULT_STACK_SIZE];
    }

    public void execute(int startip) {
        ip = startip;
        ctx = new Context(null, startip, new FuncMetaData(0, 0, startip));
        cpu();
    }

    protected void cpu() {
        int opcode = code[ip];
        int a, b, addr, reg;

        while (opcode != HALT && ip < code.length) {
            ip++;
            switch (opcode) {
                case IADD:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = a + b;
                    break;
                case ISUB:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = a - b;
                    break;
                case IMUL:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = a * b;
                    break;
                case IDIV:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = a / b;
                    break;
                case ILT:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = (a < b) ? TRUE : FALSE;
                    break;
                case ILE :
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = (a <= b) ? TRUE : FALSE;
                    break;
                case IGT:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = (a > b) ? TRUE : FALSE;
                    break;
                case IGE:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = (a >= b) ? TRUE : FALSE;
                    break;
                case IEQ:
                    b = stack[sp--];
                    a = stack[sp--];
                    stack[++sp] = (a == b) ? TRUE : FALSE;
                    break;
                case JMP:
                    ip = code[ip++];
                    break;
                case JMPT:
                    addr = code[ip++];
                    if (stack[sp--] == TRUE) ip = addr;
                    break;
                case JMPF:
                    addr = code[ip++];
                    if (stack[sp--] == FALSE) ip = addr;
                    break;
                case IPUSH:
                    stack[++sp] = code[ip++];
                    break;
                case LOAD:
                    reg = code[ip++];
                    stack[++sp] = ctx.getLocals()[reg];
                    break;
                case STORE:
                    reg = code[ip++];
                    ctx.getLocals()[reg] = stack[sp--];
                    break;
                case LOADG:
                    addr = code[ip++];
                    stack[++sp] = globals[addr];
                    break;
                case STOREG:
                    addr = code[ip++];
                    globals[addr] = stack[sp--];
                    break;
                case PRINT:
                    System.out.println(stack[sp--]);
                    break;
                case POP:
                    --sp;
                    break;
                case CALL:
                    int functionAddress = code[ip++];    // Function address
                    int numberOfArgs = code[ip++]; // Number of arguments
                    FuncMetaData f = new FuncMetaData(numberOfArgs, 0, functionAddress);
                    ctx = new Context(ctx, ip, f);
                    // Copy arguments into new context
                    for (int i = 0; i < numberOfArgs; i++) {
                        ctx.getLocals()[i] = stack[sp - i];
                    }
                    sp -= numberOfArgs;
                    ip = f.getAddress(); // Jump to function
                    break;
                case RET:
                    ip = ctx.getReturnip();
                    ctx = ctx.getParentContext();
                    break;
            }
            opcode = code[ip];
        }
    }

}
