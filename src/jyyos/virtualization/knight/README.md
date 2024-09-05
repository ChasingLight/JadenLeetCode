**金山游侠**：通过操作系统赋予我们实现调试器的机制，我们可以窥探甚至修改任何进程的代码和数据。这个能力使我们可以绕过游戏为我们设置的 “人为障碍”，取得更多的金钱、经验，或是锁定生命值等。


将账户中金额，增加了4万，哈哈！
终端1：运行 目标程序
```
jaden@ubuntu:~/Desktop/os/knight$ ./balance 
Current Process Name: balance
Press Enter to view balance...

Balance: 16868
Press Enter to view balance...

Balance: 16868
Press Enter to view balance...

Balance: 56868
Press Enter to view balance...
```

终端2：运行 金山游侠
```
jaden@ubuntu:~/Desktop/os/knight$ sudo ./knight balance
[sudo] password for jaden:
Usage:
- s 100: search for value
- w 99999: overwrite value (for search matches)
- r: reset search

(balance 4613) s 16868
Scanning 55ebd5255000--55ebd5256000
Scanning 55ebd5da0000--55ebd5dc1000
Scanning 7f82e6d91000--7f82e6d93000
Scanning 7f82e6d93000--7f82e6d99000
Scanning 7f82e6dd8000--7f82e6dd9000
Scanning 7f82e6dd9000--7f82e6dda000
Scanning 7ffc33a3f000--7ffc33a60000
There are 2 match(es).
(balance 4613) w 56868
2 value(s) written.
```