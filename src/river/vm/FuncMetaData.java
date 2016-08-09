package river.vm;

/**
 * File : FuncMetaData.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:43
 */
public class FuncMetaData {

    private String name;
    private int numberOfArgs;
    private int numberOfLocals;
    private int address;

    public FuncMetaData(String name, int numberOfArgs, int numberOfLocals, int address) {
        this.name = name;
        this.numberOfArgs = numberOfArgs;
        this.numberOfLocals = numberOfLocals;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfArgs() {
        return numberOfArgs;
    }

    public int getNumberOfLocals() {
        return numberOfLocals;
    }

    public int getAddress() {
        return address;
    }
}
