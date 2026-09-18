# Find Duplicate Number - Floyd's Cycle Detection

## Problem

Given an array of `n + 1` integers where each integer is in `[1, n]`, find the one repeated number.
Constraints: O(1) extra space, no modifying the array.

## Why the Array Can Be Treated as a Linked List

Since values are in `[1, n]` and the array has `n+1` elements, every value is a valid index. So `nums[i]` acts like a "next pointer":

```
Index: 0  1  2  3  4
Value: 1  3  4  2  2
```

Following the chain starting from index 0:

```
index 0 -> value 1 -> value 3 -> value 2 -> value 4 -> value 2 -> value 4 -> ...
                                          ^-----------cycle-----------^
```

The duplicate number (`2`) is where the cycle begins, because two different indices (3 and 4) both point to it.

## Phase 1: Find the Meeting Point (lines 9-12)

```java
do {
    slow = nums[slow];        // move 1 step
    fast = nums[nums[fast]];  // move 2 steps
} while (slow != fast);
```

- **slow** follows one link at a time
- **fast** follows two links at a time
- Since a cycle exists, fast will eventually "lap" slow and they meet **somewhere inside the cycle**

Walkthrough with `[1,3,4,2,2]`:

```
Start:  slow=1, fast=1
Step 1: slow=nums[1]=3, fast=nums[nums[1]]=nums[3]=2
Step 2: slow=nums[3]=2, fast=nums[nums[2]]=nums[4]=2
Meet at: 2
```

## Phase 2: Find the Cycle Entrance (lines 15-19)

```java
slow = nums[0];
while (slow != fast) {
    slow = nums[slow];  // 1 step
    fast = nums[fast];  // 1 step (also!)
}
```

This works because of a mathematical property: the distance from the **start** to the cycle entrance equals the distance from the **meeting point** to the cycle entrance (going around the cycle). So moving both pointers at the same speed, one from start and one from the meeting point, they converge exactly at the entrance -- which is the duplicate number.

```
slow from start:          0 -> 1 -> 3 -> [2]
fast from meeting point:                 [2] -> 4 -> [2]
Meet at: 2 (the duplicate!)
```

## Mathematical Proof of Phase 2

Let:
- `F` = distance from start to cycle entrance
- `C` = cycle length
- `a` = distance from cycle entrance to meeting point

When slow and fast meet:
- slow traveled: `F + a`
- fast traveled: `F + a + nC` (for some integer n, fast looped around the cycle n times)
- Since fast moves twice as fast: `2(F + a) = F + a + nC` -> `F + a = nC` -> `F = nC - a`

This means: moving `F` steps from the meeting point lands exactly at the cycle entrance. Moving `F` steps from the start also lands at the cycle entrance. So both pointers meet at the entrance.

## Complexity

| Metric | Value | Reason |
|--------|-------|--------|
| Time   | O(n)  | Each pointer traverses at most O(n) steps in both phases |
| Space  | O(1)  | Only two integer variables (`slow`, `fast`) |

No array modification -- we only **read** values with `nums[index]`.
