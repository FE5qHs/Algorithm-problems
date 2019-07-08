/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        RandomListNode copyHead = null;
        if (null != pHead) {
            RandomListNode copy1 = new RandomListNode(pHead.label);
            copyHead = copy1;

            RandomListNode origin1 = pHead;
            origin1 = origin1.next;

            while (null != origin1) {
                RandomListNode copy2 = new RandomListNode(origin1.label);
                copy1.next = copy2;
                copy1 = copy2;
                origin1 = origin1.next;
            }
            //
            origin1 = pHead;
            copy1 = copyHead;

            int number = 0;
            RandomListNode origin2 = pHead;

            while (null != origin1) {
                if (null != origin1.random) {
                    while (origin2 != origin1.random) {
                        ++number;
                        origin2 = origin2.next;
                    }

                    RandomListNode copy2 = copyHead;
                    for (int i = 0; i < number; ++i) {
                        copy2 = copy2.next;
                    }
                    copy1.random = copy2;

                    number = 0;
                    origin2 = pHead;
                }
                copy1 = copy1.next;
                origin1 = origin1.next;
            }
        }
        return copyHead;
    }
}