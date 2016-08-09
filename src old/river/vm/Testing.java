package river.vm;

import static river.vm.ByteCode.*;

/**
 * File : Testing.java
 * Description : None
 * Author : FRITZ Valentin
 * Website : https://github.com/vfrz/RiverVM
 * Date : 09/08/2016 15:53
 */
public class Testing {

    static int[] test = {
            IPUSH, 5,
            IPUSH, 10,
            CALL, 1,
            PRINT,
            HALT,

            LOAD, 1,
            LOAD, 0,
            IMUL,
            RET
    };

    /*
        Test code :

        void main() {
            print(mul(5, 10));
        }

        void mul(int a, int b) {
            return a * b;
        }

        Result should be :
     */

    /*

        FuncMetaData(name, nargs, nlocal, address)

     */


    static FuncMetaData[] testMetaData = {
            new FuncMetaData("main", 0, 0, 0),
            new FuncMetaData("mul", 2, 0, 8)
    };

    public static void main(String args[]) {
        RiverVM vm = new RiverVM(test, 0, testMetaData);
        vm.execute(testMetaData[0].getAddress());
    }
}
