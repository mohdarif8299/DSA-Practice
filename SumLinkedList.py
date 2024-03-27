# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    tailEnd = None
    head = None
    headStart = None
    def insert_end(self, data):
        node = ListNode(data)
        if self.head is None:
            node.next = None
            self.head = node
        else:
            self.tailEnd.next = node

        self.tailEnd = node
        return self.tailEnd

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        while l1 is not None or l2 is not None:
            sum = 0
            if l1 is not None:
                sum += l1.val
                l1 = l1.next
            if l2 is not None:
                sum += l2.val
                l2 = l2.next
            sum += carry
            if sum >= 10:
                head = self.insert_end(sum%10)
                carry = 1
            else:
                head = self.insert_end(sum)
                carry = 0
        
        if carry == 1:
            head = self.insert_end(carry)
        return self.head
