学习笔记
### 四步切题法：
1.理清题意，确定题目的要求
2.想尽可能多的解法，对比几总写法的时空复杂度，找到比较好的解法
3.尽可能多的写题
4.测试用例

### 如何训练：
五毒神掌：
1.第一遍，花5~10分钟阅读题目，-> 
  使用四步切题法，最多15分钟想不出来，编写不出来，直接看题解，抄
2.第二遍，抄完之后理解，立刻背诵写一遍，边写边读边练
3.第三遍，第二天再单独写一遍
4.第四遍，过一周再写一遍
5.经常练习

> 四步切题法跟五毒神掌是相辅相成的，在做题的时候，使用四步切题做题;在进行过遍数强化时，也是需要采用切题四步法；个人感觉在每次重新刷题时，重新审视题目，会有其他的思考的方式，也能同时对之前模糊的点有更进一步的理解


### 重温基础数据结构和复杂度的基础
线性结构的有：基本数据结构是数组、链表
高级的数据结构是队列，队列(queue)，栈(stach)，双端队列(dueue)
- 重点是学到了一种学习方法，跟超哥学到了一张新的思维方式，不再对算法的题目有莫名的恐惧；
>> 总结来说就是多思考，多写，多练习；对不熟悉的思路，思考方式、理解方式需要重复、反复的听；刻意练习薄弱的地方

第一周学的一个套路：
在做数组移动元素的题目时，在不允许额外的空间辅助时，一般采用双指针的解法就能解决问题，双指针有同方向的快慢指针，有相反方向的向中间夹逼法；



## 二叉树的前中后序遍历

```java
// 前序遍历
void search(node) {
    visited(node);
    search(node.left);
    search(node.right);
}
// 中序遍历
void search(node) {
    search(node.left);
    visited(node);
    search(node.right);
}
// 后序遍历
void search(node) {
    search(node.left);
    search(node.right);
    visited(node);
}
```

## 递归代码模板
思维要点
- 不要人肉递归
- 找到最近最简方法，将问题拆解成可以重复解决的问题（重复子问题，找重复性）
- 数学归纳法
```java
void recursion(level,param) {
    // terminator
    if(level > MAX) return;
    // process curr level

    // dirll down 
    recursion(level + 1,param);
    // resver curr state
}

```

## 深度优先搜索
```java
 void dfs(node) {
     if(node.children == null) {
         return;
     }
 }

```