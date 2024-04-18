class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    static void dfs(int[] numbers, int target, int level, int value){
        if (level == numbers.length && value == target){
            answer++;            
            return;
        }
        if (level == numbers.length){
            return;
        }
        dfs(numbers, target, level + 1, value + numbers[level]);
        dfs(numbers, target, level + 1, value - numbers[level]);
    }
}