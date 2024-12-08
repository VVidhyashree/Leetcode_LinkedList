1.ARRAY : TWO SUM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        
        return null;
    }
}

2. Add two numbers : Linked List
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode d=new ListNode(0);---->Dummy node for results
        ListNode ans=d;----->
        int c=0;
        while(l1!=null || l2!=null || c!=0)------> traverse LL
        {
           
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum=c+x+y;
            c=sum/10;
            ans.next=new ListNode(sum % 10);-------->store ans /add ans to next node
            ans=ans.next;
            if(l1!=null)
            {
                l1=l1.next;
            }
             if(l2!=null)
            {
                l2=l2.next;
            }
        }
        return d.next;
    }
}


4.Merge Two sorted List


class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d=new ListNode(1);------->dummy list and storing
        ListNode m=d;
        while(list1 != null && list2!=null)-------check for nulll
        {
            if(list1.val <= list2.val)------->logic for ascending order
            {
                m.next=list1;
                list1=list1.next;
       
            }
           
            else
            {
              m.next=list2;
              list2=list2.next;
            }
            m=m.next;
       
        }
   
    if(m.next==list1 && list1==null)----------------> next element when u fetch is null 
    {
        m.next=list2;


    }
    else
    {
        m.next=list1;
       
    }
     return d.next;--------->basic logic
       
    }
   
}




3.Reverse a LL

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev =null;---------------> Basic logic
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;---------------->


        }
       
    }
Or simplify by 
if (head == null || head.next == null) {
    return head; // Base case
}
ListNode reversedList = reverseList(head.next); // Reverse the rest
head.next.next = head; // Adjust the pointer
head.next = null;      // Break the original forward link
return reversedList;   // Return the new head


3. LL Cycle
public class Solution {
    public boolean hasCycle(ListNode head) {
        // If the list is empty or has only one node, no cycle can exist
        if (head == null) {--------->basic head operation
            return false;
        }


        // Initialize the slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;


        // Traverse the list with two pointers
        while (fast != null && fast.next != null) {------basic condition for traversing in two pointers
            slow = slow.next;          // Move slow pointer one step
            fast = fast.next.next;     // Move fast pointer two steps


            // If the slow and fast pointers meet, there's a cycle
            if (slow == fast) {--------->cycle condition
                return true;
            }
        }


        // No cycle detected
        return false;
    }
}




5.Remove the Nth Node from the LL


—--->Two Pointer approach is used


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Initialize slow and fast pointers
        ListNode slow = dummy;
        ListNode fast = dummy;


        // Move fast pointer n steps ahead—-------------two pointer
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }


        // Move both slow and fast pointers until fast reaches the end
        while (fast != null) {----------------------->two pointer
            slow = slow.next;
            fast = fast.next;
        }


        // Remove the nth node from the end
        slow.next = slow.next.next;


        // Return the head (which might have changed)
        return dummy.next;
    }
}


6.Merge k Sorted Lists→using Priority queue Min heap(pre defined datastructure
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();-----syntax
        for(ListNode list:lists)----------------------->syntax for iterating and adding elements inside the minheap
        {
            while(list!=null)
            {
                minHeap.add(list.val);
                list=list.next;
            }
        }
        ListNode dummy=new ListNode(1);------------>taking out elements from min heap and placing into the merge list
        ListNode merge=dummy;
        while(!minHeap.isEmpty())
        {
            merge.next=new ListNode(minHeap.remove());
            merge=merge.next;


        }
        return dummy.next;-------------->syntax
    }
}
7. Reorder List
class Solution {
    public void reorderList(ListNode head) {
        if(head==null)--------------------------->base condition for head problems
        {
            return;
        }
        ListNode slow=head,fast=head;------------------>syntax to find middle of elements(two pointers)
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null,curr=slow,temp;------------------>syntax for reversing LL
        while(curr!=null)
        {
            temp=curr.next;
            curr.next=prev;-------->reversing the link
            prev=curr;
            curr=temp;
        }
        ListNode first = head;   // Pointer to the head of the first half
        ListNode second = prev;  // Pointer to the head of the reversed second half


        while (second.next != null) {
        temp = first.next;     // Step 1: Save the next node in the first half
        first.next = second;   // Step 2: Link the first node to the current node in the second half
        first = temp;          // Step 3: Move 'first' to the next node


        temp = second.next;    // Step 4: Save the next node in the second half
        second.next = first;   // Step 5: Link the second node to the next node in the first half
        second = temp;         // Step 6: Move 'second' to the next node


}


        
       
    }
}
8.Middle of the LL (refer previous problem)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode s=head,f=head;
        while(f!=null && f.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        return s;


    }
}




8.Delete the Middle of the LL


class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode s=head,f=head;
        while(f!=null && f.next!=null)
        {
            prev=s;
            s=s.next;
            f=f.next.next;
        }
        prev.next=s.next
        return head;


        
       
    }
}


9.Flatten Binary Tree to Linked list (pre order traversal)
class Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;


        while (current != null) {
            // If there is a left subtree
            if (current.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode rightmost = current.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }


                // Attach the original right subtree to the rightmost node
                rightmost.right = current.right;


                // Move the left subtree to the right
                current.right = current.left;
                current.left = null; // Set the left pointer to null
            }


            // Move to the next node
            current = current.right;
        }
    }
}
10.Reverse Nodes in the k group in Linked List
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;


        // Dummy node to simplify handling the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode prevGroupEnd = dummy;
        ListNode curr = head;


        while (true) {
            // Check if there are at least k nodes to reverse
            ListNode groupStart = curr;
            int count = 0;


            while (curr != null && count < k) {
                curr = curr.next;
                count++;
            }


            if (count == k) {
                // Reverse the k nodes
                ListNode reversedHead = reverse(groupStart, k);


                // Connect the previous group's end to the reversed group
                prevGroupEnd.next = reversedHead;


                // Move prevGroupEnd to the end of the reversed group
                prevGroupEnd = groupStart;
            } else {
                // If less than k nodes remain, leave them as is
                prevGroupEnd.next = groupStart;
                break;
            }
        }


        return dummy.next;
    }


    // Helper function to reverse k nodes
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;


        while (k > 0) {
            ListNode next = curr.next;  // Save the next node
            curr.next = prev;          // Reverse the pointer
            prev = curr;               // Move prev forward
            curr = next;               // Move curr forward
            k--;
        }


        return prev; // New head of the reversed group
    }
}






























