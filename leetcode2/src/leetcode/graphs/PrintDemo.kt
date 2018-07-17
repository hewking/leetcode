package leetcode.graphs

object PrintDemo{

    @JvmStatic
    fun main(args : Array<String>) {
        for (i in 0..3) {
            for (j in 0.. 3-i) {
                print(" ")
            }

            for (k in 0..2 * i ) {
                print("*")
            }

            println()


        }

        for (i in 0 ..2) {
            for (m in 0..i + 1) {
                print(" ")
            }

            for ( n in 0 .. 2 * (2 - i) ) {
                print("*")
            }
            println()
        }


    }

}