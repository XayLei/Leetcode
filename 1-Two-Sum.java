publlic class solution{
    public int[] twoSum(int[] nums, int target){
       //通过创建散列表来实现一次遍历即可找出答案
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0; i<nums.length; i++){
           int complement = target - nums[i];
           if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
           }
           map.put(nums[i],i);
       }
       
       throw new IllegalArgumentException("no two sum solution");
    }
}
