class Stack:
    def __init__(self):
        self.s = []
        
    def push(self, num):
        self.s.append(num)
        
    def pop(self):
        if len(self.s) != 0:
            _num = self.s[-1]
            self.s = self.s[:-1]
            return _num
        else:
            return -1
    
    def size(self):
        return len(self.s)
    
    def empty(self):
        if self.size() == 0:
            return 1
        else:
            return 0
        
    def top(self):
        if self.empty() != 1:
            return self.s[-1]
        else:
            return -1 

import sys

N = int(input())
s = Stack()
for i in range(N):
    order = sys.stdin.readline().split()
    if order[0] == 'push':
        s.push(int(order[1]))
    elif order[0] == 'pop':
        print(s.pop())
    elif order[0] == 'size':
        print(s.size())
    elif order[0] == 'empty':
        print(s.empty())
    elif order[0] == 'top':
        print(s.top())