class No665 {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] - nums[i] < 0) {
                count ++;
                index = i;
            }
            if (count > 1) {
                return false;
            }
        }

        if (index == 0 || (nums[index+1] > nums[index-1]) || (nums[index+2] > nums[index])) {
            return true;
        }
        return false;
    }
}