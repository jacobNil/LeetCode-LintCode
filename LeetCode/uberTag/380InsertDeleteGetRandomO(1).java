//380InsertDeleteGetRandom O(1)
// april 30, ubertage
 class RandomizedSet {
    private Map<Integer, Integer> location;
    
    private List<Integer> nums;
    
    private java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        location = new HashMap<>();
        nums = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(location.containsKey(val)) {
            return false;
        }
        location.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!location.containsKey(val)) {
            return false;
        }
        int index = location.get(val);
        if(index == nums.size() - 1) {
            nums.remove(index);
            location.remove(val);
            return true;
        }
        
        int lastNum = nums.get(nums.size() - 1);
        nums.set(index, lastNum);
        nums.remove(nums.size() - 1);

        location.put(lastNum, index);
        location.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randIndex = rand.nextInt(nums.size());
        return nums.get(randIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
