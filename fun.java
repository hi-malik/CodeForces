// Given a list of [FileName, FileSize, [Collection]] - Collection is optional, i.e., a collection can have 1 or more files. Same file can be a part of more than 1 collection.
// How would you design a system

// To calculate total size of files processed.
// To calculate Top K collections based on size.

// Example:

// Input:
// file1.txt(size: 100)
// file2.txt(size: 200) in collection "collection1"
// file3.txt(size: 200) in collection "collection1"
// file4.txt(size: 300) in collection "collection2"
// file5.txt(size: 100)

// Output:
// Total size of files processed: 900
// Top 2 collections:
// - collection1 : 400
// - collection2 : 300

// My Approach

// 1. Use a unordered map where key will be collection name and value will be sum of it's size. map<string, int> collectionMap;
// 2. Along with this also take one more variable that will store total size of the file, that will answer 1st subproblem.
// 3. push all the key, value pair into a max priority queue and select top K element from it.
// 4. Return total size of files processed and top K collections.

import java.util.*;
import java.util.Map.Entry;
class fun{
    public static void main(String[] args){
        String[] fileNames = {"file1.txt", "file2.txt", "file3.txt", "file4.txt", "file5.txt"};
        int[] fileSizes = {100, 200, 200, 300, 100};
        String[] collections = {"collection1", "collection1", "collection2", "collection1", "collection2"};
        int k = 2;
        System.out.println(getTotalSize(fileNames, fileSizes, collections, k));
    }
    public static String getTotalSize(String[] fileNames, int[] fileSizes, String[] collections, int k){
        Map<String, Integer> collectionMap = new HashMap<>();
        int totalSize = 0;
        for(int i = 0; i < fileNames.length; i++){
            if(collectionMap.containsKey(collections[i])){
                collectionMap.put(collections[i], collectionMap.get(collections[i]) + fileSizes[i]);
            }else{
                collectionMap.put(collections[i], fileSizes[i]);
            }
            totalSize += fileSizes[i];
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<String, Integer> entry : collectionMap.entrySet()){
            pq.add(entry);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Total size of files processed: " + totalSize + "\n");
        sb.append("Top " + k + " collections:\n");
        for(int i = 0; i < k; i++){
            Map.Entry<String, Integer> entry = pq.poll();
            sb.append("- " + entry.getKey() + " : " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}