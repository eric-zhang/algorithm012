## 毕业总结

时间过得很快，坚持下来真的很不容易，特别是一边上班超负荷的工作，一边坚持练算法；越到后面越烧脑，越感到痛苦，两个月的时间跟着超哥学习学习的方法论，如五毒神掌、切题四件套、记算法模板、记经典代码等，更加深刻认识到要熟练，就要多练，从一开始对动态规划的恐惧，到最后排除这种恐惧感，全靠超哥讲的透彻，视频看了一遍又一遍，对模糊的点重复看，重复想，重复练，每次的感觉都不一样；虽然课程结束，但是学习一直在路上，以下就这两个月学习到的知识点做个总结归纳

#### 数据结构

- **一维**      
  - **基础**：数组 array，链表 linked list
  - **高级**：栈 stack， 队列 queue，双端队列 deque，集合 set，映射 map (hash) TreeMap、HashMap
- **二维**  
  - **基础**：树 tree，图 graph
  - **高级**：二叉搜索树 binary search tree(red-black tree,AVL)，堆 heap，并查集 disjoint set，字典树 trie
- **特殊**  
  - 位运算 Bitwise，布隆过滤器 BloomFilter
  - LRU Cache
  


#### 复杂度分析

| 数据结构           | Access  | Search  | Insertion | Deletion |
| ------------------ | ------- | ------- | --------- | -------- |
| Array              | O(1)    | O(n)    | O(n)      | O(n)     |
| Stack              | O(n)    | O(n)    | O(1)      | O(1)     |
| Queue              | O(n)    | O(n)    | O(1)      | O(1)     |
| Singly-Linked List | O(n)    | O(n)    | O(1)      | O(1)     |
| Doubly-Linked List | O(n)    | O(n)    | O(1)      | O(1)     |
| Skip List          | O(logN) | O(logN) | O(logN)   | O(logN)  |
| Hash Table         | N/A     | O(1)    | O(1)      | O(1)     |
| Binary Search Tree | O(logN) | O(logN) | O(logN)   | O(logN)  |
| Cartesian Tree     | N/A     | O(logN) | O(logN)   | O(logN)  |
| B-Tree             | O(logN) | O(logN) | O(logN)   | O(logN)  |
| Read-Black Tree    | O(logN) | O(logN) | O(logN)   | O(logN)  |


####  算法
• If-else, switch —> branch
• for, while loop —> Iteration
• 递归 Recursion (Divide & Conquer, Backtrace)
• 搜索 Search: 深度优先搜索 Depth first search, 广度优先搜索 Breadth first search, A*, etc
• 动态规划 Dynamic Programming
• 二分查找 Binary Search
• 贪心 Greedy
## 代码模板
**递归**
```java
    public void recur(int level, int param) { 
        // terminator 
        if (level > MAX_LEVEL) { 
        // process result 
            return; 
        } 
         
         // process current logic 
        process(level, param); 
         
         // drill down 
        recur( level: level + 1, newParam); 
         
        // restore current status 
     
    }
```

**分治**
```python
    def divide_conquer(problem, param1, param2, ...): 
        # recursion terminator 
        if problem is None: 
         print_result 
         return 
         
        # prepare data 
        data = prepare_data(problem) 
        subproblems = split_problem(problem, data) 
         
        # conquer subproblems 
        subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
        subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
        subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
        … 
        # process and generate the final result 
        result = process_result(subresult1, subresult2, subresult3, …) 
     
        # revert the current level states
```

**二叉树遍历**
```java
    // 中序(In-order)：左-根-右
     void _doInOrder(TreeNode treeNode, List<Integer> result) {
        if(treeNode == null){
            return;
        }
        _doInOrder(treeNode.left,result);
        result.add(treeNode.val);
        _doInOrder(treeNode.right,result);
    }
     //  前序(Pre-order)：根-左-右
     void _doPreOrder(TreeNode treeNode,List<Integer> result) {
        if(treeNode == null){
            return;
        }
        result.add(treeNode.val);
        _doPreOrder(treeNode.left,result);
        _doPreOrder(treeNode.right,result);
    }
    // 后序(Post-order)：左-右-根
     void _doPostOrder(TreeNode treeNode,List<Integer> result) {
        if(treeNode == null) {
            return;
        }
        _doPostOrder(treeNode.left,result);
        _doPostOrder(treeNode.right,result);
        result.add(treeNode.val);
    }
```

**深度优先 DFS**
```java
    // Java 模板
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();// 结果集
        if (root==null) {
            return allResults;
        }
        travel(root, 0, allResults);// 0代表第0层
        return allResults;
    }

    private void travel(TreeNode root,int level,List<List<Integer>> results){
        // results代表每层结果集，集合大小和层数一样，开辟下一层空间
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        
        // 每一层的结果都是一个array，放到new array里
        results.get(level).add(root.val);
        
        if (root.left!=null) {
            travel(root.left, level+1, results);
        }
        if (root.right!=null) {
            travel(root.right,level+1,results);
        }
    }
```

**广度优先 BFS**
```java
    // Java 模板
    // 将每一层元素放到队列中，然后将队首出队，存入每层的结果，下一层再放到队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();// 队列元素不断增加，size保留初始大小
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
```

**二分查找**
```java
    // Java
    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;// 或者mid = (right + left) / 2
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
```



**字典树Trie**
```java
    public class Trie {
        class TireNode {
            private boolean isEnd;
            TireNode[] next;
    
            public TireNode() {
                isEnd = false;
                next = new TireNode[26];
            }
        }
    
        private TireNode root;
        public Trie() {
            root = new TireNode();
        }
    
        public void insert(String word) {
            TireNode node = root;
            char[] words = word.toCharArray();
            for (char c : word.toCharArray()) {
                if (node.next[c-'a'] == null) {
                    node.next[c-'a'] = new TireNode();
                }
                node = node.next[c-'a'];
            }
            node.isEnd = true;
        }
    
        public boolean search(String word) {
            TireNode node = root;
            for (char c : word.toCharArray()) {
                node = node.next[c-'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }
    }
```

**DP 模板**
```java
    function DP(): 
      Dp = [][] # 三维情况 
      For I = 0 .. M { 
       For j = 0 .. N { 
        Dp[i][j] = _Function(Dp[i’][j’]…) 
       } 
      } 
      Return Dp[M][N]
```

学递归、分治、回溯、动态规划的感触
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题 
3. 数学归纳法思维
解决问题的本质: 寻找重复性 —> 计算机指令集


#### 排序算法复杂度

| 排序方法 | 时间复杂度(平均) | 时间复杂度(最坏) | 时间复杂度(最好) | 空间复杂度 | 稳定性 |
| -------- | ---------------- | ---------------- | ---------------- | ---------- | ------ |
| 插入排序 | O(n^2)           | O(n^2)           | O(n)             | O(1)       | 稳定   |
| 希尔排序 | O(n^1.3)         | O(n^2)           | O(n)             | O(1)       | 不稳定 |
| 选择排序 | O(n^2)           | O(n^2)           | O(n^2)           | O(1)       | 不稳定 |
| 堆排序   | O(nlog2^n)       | O(nlog2^n)       | O(nlog2^n)       | O(1)       | 不稳定 |
| 冒泡排序 | O(n^2)           | O(n^2)           | O(n)             | O(1)       | 稳定   |
| 快速排序 | O(nlog2^n)       | O(n^2)           | O(nlog2^n)       | O(nlog2^n) | 不稳定 |
| 归并排序 | O(nlog2^n)       | O(nlog2^n)       | O(nlog2^n)       | O(n)       | 稳定   |
| 计数排序 | O(n+k)           | O(n+k)           | O(n+k)           | O(n+k)     | 稳定   |
| 桶排序   | O(n+k)           | O(n^2)           | O(n)             | O(n+k)     | 稳定   |
| 基数排序 | O(n*k)           | O(n*k)           | O(n*k)           | O(n+k)     | 稳定   |



