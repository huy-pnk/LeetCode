package org.hard;

import java.util.*;

/**
 * 3116. Kth Smallest Amount With Single Denomination Combination
 * https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination/
 */
public class FindKthSmallest {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        long lo = 1, hi = (long) k * minCoin(coins); // cận trên an toàn

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countUpTo(mid, coins) >= k) {
                hi = mid;   // mid đã đủ, thử thu hẹp xuống nhỏ hơn
            } else {
                lo = mid + 1; // mid chưa đủ, tăng lên
            }
        }
        return lo;
    }

    // Đếm số lượng amount hợp lệ (bội số của ít nhất 1 coin) trong [1, x]
    private long countUpTo(long x, int[] coins) {
        int n = coins.length;
        long count = 0;

        // Duyệt tất cả subset không rỗng bằng bitmask: 1 -> (1<<n)-1
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = Integer.bitCount(mask);

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) break; // LCM đã vượt x, floor(x/lcm)=0, khỏi tính tiếp
                }
            }

            if (lcm > x) continue; // subset này không đóng góp gì cho count(x)

            // Quy tắc dấu: số coin trong subset lẻ -> cộng, chẵn -> trừ
            if (bits % 2 == 1) {
                count += x / lcm;
            } else {
                count -= x / lcm;
            }
        }
        return count;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        long g = gcd(a, b);
        // Chia trước khi nhân để tránh tràn số (overflow)
        long result = (a / g) * b;
        // Chặn trên để tránh overflow khi lcm quá lớn so với x có thể xét
        return result > (long) 2e15 ? (long) 2e15 : result;
    }

    private int minCoin(int[] coins) {
        int m = coins[0];
        for (int c : coins) m = Math.min(m, c);
        return m;
    }
}
