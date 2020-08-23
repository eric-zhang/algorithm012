学习笔记
# two-ended bfs code template

```java

void towEndBfs(graph,start)
Queue queue1;
Queue queue2;

queue1.push(start);
queue2.push(start);
visited.add(start);

while(!queue1.notEmpyt && !queue2.notEmpyt) {
    // exchange tow queues if 
    if(queue1.size > queue2.size) {
        Queue temp = queue1;
         queue1 = queue2;
         queue2 = temp;
    }
    Queue tempQueue = Empty;
    while queue1:
        node = queue1.pop();
        if(queue2.contains(node)) {
            return ;
        }
         process(node)   
        if(!visited.contains(node)) {
           visited.add(node)
           nodes = generate_nodes(node)
           tempQueue.push(nodes)
        }   
    queue1 = tempQueue;    
}


```