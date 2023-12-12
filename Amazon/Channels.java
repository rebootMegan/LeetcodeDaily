package Amazon;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Channels {

    /**
     * def maxQuality(nums: List[int], k: int) -> int:
     * nums.sort(reverse=True)
     * total_quality = sum(nums[:k - 1])  # Sum of largest packets for k-1 channels
     * <p>
     * # For the last channel, calculate the median
     * remaining_packets = nums[k - 1:]
     * if len(remaining_packets) % 2 == 0:
     * # If even number of packets, take the average of middle two and round up
     * median = (remaining_packets[len(remaining_packets) // 2 - 1] + remaining_packets[len(remaining_packets) // 2] + 1) // 2
     * else:
     * # If odd number of packets, take the middle one
     * median = remaining_packets[len(remaining_packets) // 2]
     * <p>
     * total_quality += median
     * return total_quality
     * <p>
     * # Test the function with the provided example
     * maxQuality(nums, k)
     */
    public static int maxQuality(int[] nums, int k) {
        Arrays.sort(nums);
        int totalQuality = 0;

        // Sum of largest packets for k-1 channels
        for (int i = 0; i < k - 1; i++) {
            totalQuality += nums[nums.length - 1 - i];
        }

        // Calculate the median for the remaining packets in the last channel
        int[] remainingPackets = Arrays.copyOfRange(nums, 0, nums.length - (k - 1));
        int median;
        if (remainingPackets.length % 2 == 0) {
            // Even number of packets, take average of middle two, round up
            int midIndex = remainingPackets.length / 2;
            median = (remainingPackets[midIndex - 1] + remainingPackets[midIndex] + 1) / 2;
        } else {
            // Odd number of packets, take the middle one
            median = remainingPackets[remainingPackets.length / 2];
        }

        totalQuality += median;
        return totalQuality;

    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 5, 3};
        int k = 2;
        System.out.println("Max Quality: " + maxQuality(nums, k));
    }
}