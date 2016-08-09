package river.vm;

/**
 * File : Instruction.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:33
 */
public class Instruction {

    private String name;
    private int n;

    public Instruction(String name) {
        this(name, 0);
    }

    public Instruction(String name, int numberOfArgs) {
        this.name = name;
        n = numberOfArgs;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfArgs() {
        return n;
    }
}
