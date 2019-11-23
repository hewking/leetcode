package leetcode

/**
 * 406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * Created by test
 * Date 2019/11/23 12:12
 * Description
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

object QueueReconstructionByHeight {

    class Solution {
        /**
         * 思路：
         * https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gui-yue-hou-shi-yong-tan-xin-suan-fa-qiu-jie-ton-2/#comment
         * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
            排序后
            [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
            重新排队
            [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

         先排序，再插入，因为插入到已排好的队列，每个人都要比要排的人要高
         所以就只需要排下一个人看有多少人比他高，然后就插入到相应位置
         */

        fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
            people.sortWith(Comparator{ o1, o2 ->
                if (o1[0] == o2[0]) o1[1] - o2[1] else o2[0] - o1[0]
            })
            val ansList = arrayListOf<IntArray>()
            people.forEach {
                ansList.add(it[1],it)
            }
            return ansList.toTypedArray()
        }
    }

}