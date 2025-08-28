package backtracking;

public class CombinationTemplate {
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        selected = new int[3];
        visited = new boolean[nums.length];

        backTracking(0, 0, 3, nums);
    }

    public static void backTracking(int pick, int start, int count, int[] nums) {
        if (pick == count) {
            for (int i = 0; i < selected.length; i++) {
                System.out.print(nums[selected[i]] + " ");
            }

            System.out.println();

            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[pick] = i;
                backTracking(pick + 1, i + 1, count, nums);
                visited[i] = false;
            }
        }

    }
}