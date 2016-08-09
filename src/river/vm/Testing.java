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
            IPUSH, 10, // 0
            CALL, 2, // 2
            PRINT, // 4
            HALT, // 5

            LOAD, 0, // 6
            LOAD, 1, // 8
            IADD, // 10
            RET, // 11

            LOAD, 0, // 12
            IPUSH, 2, // 14
            CALL, 1, // 16
            RET // 18
    };

    /*
        Test code :

        void main() {
            print(add2(10));
        }

        int add(int a, int b) {
            return a + b;
        }

        int add2(int a) {
            return add(a, 2);
        }
     */

    static FuncMetaData[] testMetaData = {
            new FuncMetaData("main", 0, 0, 0),
            new FuncMetaData("add", 2, 0, 6),
            new FuncMetaData("add2", 1, 0, 12)
    };

    public static void main(String args[]) {
        RiverVM vm = new RiverVM(test, 0 ,testMetaData);
        vm.execute(testMetaData[0].getAddress());
    }
}
