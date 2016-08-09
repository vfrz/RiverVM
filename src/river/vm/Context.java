package river.vm;

/**
 * File : Context.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:41
 */
public class Context {

    private Context parentContext;
    private FuncMetaData metaData;
    private int returnip;
    private int[] locals;

    public Context(Context parentContext, int returnip, FuncMetaData metaData) {
        this.parentContext = parentContext;
        this.returnip = returnip;
        this.metaData = metaData;
        locals = new int[metaData.getNumberOfArgs() + metaData.getNumberOfLocals()];
    }

    public Context getParentContext() {
        return parentContext;
    }

    public FuncMetaData getMetaData() {
        return metaData;
    }

    public int getReturnip() {
        return returnip;
    }

    public int[] getLocals() {
        return locals;
    }
}
