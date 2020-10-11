package LinkedList;
import java.util.PriorityQueue;

/**
 * LeetCode 23: Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        //This is Min-Heap, so will sort in ascending order.
        //Since we are comparing value of Node, we have to specify in Comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a,b) -> a.val - b.val);
        ListNode merged = new ListNode(0);
        ListNode dummy = merged;
        for(ListNode n : lists) {
            if(n != null) {
                pq.add(n);
            }
        }
        while(!pq.isEmpty()) {
            merged.next = pq.poll();
            merged = merged.next;
            //We have to add next elements of used Node into Min-Heap
            if(merged.next != null) {
                pq.add(merged.next);
            }
        }
        return dummy.next;
    }
}
