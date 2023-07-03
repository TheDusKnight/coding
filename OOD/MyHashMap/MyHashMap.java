package OOD.MyHashMap;

// 1. key -> hash() -> index
// 2. index -> bucket
// 3. conflict/collision : one by one check
// if val exists -> put/get/remove

// 核心问题：如何让Bucket中的k，v个数是O(1)?
// 1. Bucket的个数是否足够？Java load factor = 0.75，大于0.75使用rehashing
// 2. hash() 均匀的index分布. 使用好的hash function
public class MyHashMap {
    
}
