import java.util.HashMap;
import java.util.Map;
/**
 * ����֮�ͣ�1��
 * ���α�������ϣ��˼�루��˼����
 * 
 * 
 * 
 * 
 * 
 * 
 * ���HashMap���Ƿ����target-��������key
 * @author j
 *
 */
public class TwoSum {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] in = {2,7,11,15};
		s.twoSum(in,9);
		System.out.print(s.twoSum(in, 9));

	}
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> ht = new HashMap<>();
        int b;
        //Build HashMap
        for(int i=0;i<nums.length;i++){
            ht.put(nums[i],i);
        }
        //search for complement
        for(int i=0;i<ht.size();i++) {
        	b = target-nums[i];
        	if(ht.containsKey(b) && ht.get(b) != i) {
        		return new int[] {i,ht.get(b)};
        	}
        }
        throw new IllegalArgumentException("No such two numbers!");
    }
}