package zhc.jvm.part2;


/**
 * java 栈是否能发生OOM
 *
 */
public class JavaVMStackOOM {
    private static int stackLength = 0;

    public static void test() {
        long unused0,
                unused1,
                unused2,
                unused3,
                unused4,
                unused5,
                unused6,
                unused7,
                unused8,
                unused9,
                unused10,
                unused11,
                unused12,
                unused13,
                unused14,
                unused15,
                unused16,
                unused17,
                unused18,
                unused19,
                unused20,
                unused21,
                unused22,
                unused23,
                unused24,
                unused25,
                unused26,
                unused27,
                unused28,
                unused29,
                unused30,
                unused31,
                unused32,
                unused33,
                unused34,
                unused35,
                unused36,
                unused37,
                unused38,
                unused39,
                unused40,
                unused41,
                unused42,
                unused43,
                unused44,
                unused45,
                unused46,
                unused47,
                unused48,
                unused49,
                unused50,
                unused51,
                unused52,
                unused53,
                unused54,
                unused55,
                unused56,
                unused57,
                unused58,
                unused59,
                unused60,
                unused61,
                unused62,
                unused63,
                unused64,
                unused65,
                unused66,
                unused67,
                unused68,
                unused69,
                unused70,
                unused71,
                unused72,
                unused73,
                unused74,
                unused75,
                unused76,
                unused77,
                unused78,
                unused79,
                unused80,
                unused81,
                unused82,
                unused83,
                unused84,
                unused85,
                unused86,
                unused87,
                unused88,
                unused89,
                unused90,
                unused91,
                unused92,
                unused93,
                unused94,
                unused95,
                unused96,
                unused97,
                unused98,
                unused99;

        stackLength++;
        test();
        unused0 = 0;
        unused1 = 0;
        unused2 = 0;
        unused3 = 0;
        unused4 = 0;
        unused5 = 0;
        unused6 = 0;
        unused7 = 0;
        unused8 = 0;
        unused9 = 0;
        unused10 = 0;
        unused11 = 0;
        unused12 = 0;
        unused13 = 0;
        unused14 = 0;
        unused15 = 0;
        unused16 = 0;
        unused17 = 0;
        unused18 = 0;
        unused19 = 0;
        unused20 = 0;
        unused21 = 0;
        unused22 = 0;
        unused23 = 0;
        unused24 = 0;
        unused25 = 0;
        unused26 = 0;
        unused27 = 0;
        unused28 = 0;
        unused29 = 0;
        unused30 = 0;
        unused31 = 0;
        unused32 = 0;
        unused33 = 0;
        unused34 = 0;
        unused35 = 0;
        unused36 = 0;
        unused37 = 0;
        unused38 = 0;
        unused39 = 0;
        unused40 = 0;
        unused41 = 0;
        unused42 = 0;
        unused43 = 0;
        unused44 = 0;
        unused45 = 0;
        unused46 = 0;
        unused47 = 0;
        unused48 = 0;
        unused49 = 0;
        unused50 = 0;
        unused51 = 0;
        unused52 = 0;
        unused53 = 0;
        unused54 = 0;
        unused55 = 0;
        unused56 = 0;
        unused57 = 0;
        unused58 = 0;
        unused59 = 0;
        unused60 = 0;
        unused61 = 0;
        unused62 = 0;
        unused63 = 0;
        unused64 = 0;
        unused65 = 0;
        unused66 = 0;
        unused67 = 0;
        unused68 = 0;
        unused69 = 0;
        unused70 = 0;
        unused71 = 0;
        unused72 = 0;
        unused73 = 0;
        unused74 = 0;
        unused75 = 0;
        unused76 = 0;
        unused77 = 0;
        unused78 = 0;
        unused79 = 0;
        unused80 = 0;
        unused81 = 0;
        unused82 = 0;
        unused83 = 0;
        unused84 = 0;
        unused85 = 0;
        unused86 = 0;
        unused87 = 0;
        unused88 = 0;
        unused89 = 0;
        unused90 = 0;
        unused91 = 0;
        unused92 = 0;
        unused93 = 0;
        unused94 = 0;
        unused95 = 0;
        unused96 = 0;
        unused97 = 0;
        unused98 = 0;
        unused99 = 0;
    }

    public static void main(String[] args) {

        try {
            test();
        } catch (Error error) {
            System.out.println("stack length :" + stackLength);
            throw error;
        }

    }

}
