package com.example.lib;


/*单链表操作*/
public class SingleLinkedList {
    private  DataNode head;

    public SingleLinkedList(int size) {
        DataNode head = new DataNode(0);
        DataNode cur = head;
        for (int i = 1; i < size; i++) {
            DataNode tmp = new DataNode(i);
            cur.setNext(tmp);
            cur = tmp;
        }
        this.head = head;
    }

    public DataNode getHead() {
        return head;
    }

    public void setHead(DataNode head) {
        this.head = head;
    }
    //打印
    public void printChain(DataNode head) {
        StringBuilder sb = new StringBuilder();
        DataNode cur = head;
        sb.append(cur.getData());
        while (null != cur.getNext()) {
            sb.append(" -> ");
            sb.append(cur.getNext().getData());
            cur = cur.getNext();
        }
        System.out.println(sb.toString());
    }

    //递归实现单链表反转
    public  DataNode reverse1(DataNode head){
        if(null==head || null== head.getNext()){
            return head;
        }
        DataNode revhead=this.reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revhead;
    }

    //遍历实现单链表反转
    public DataNode reverse2(DataNode head){
        if(head!=null){
            DataNode prevNode=head;//上一个结点
            DataNode currentNode=head.getNext();//当前结点
            DataNode tempNode;//临时结点
            while (currentNode!=null){
                tempNode=currentNode.getNext();
                currentNode.setNext(prevNode);
                //指向移动
                prevNode = currentNode;
                currentNode =tempNode;
            }
            head.setNext(null);
            return prevNode;
        }
        return null;
    }

    public static void main(String[] strings) {
        SingleLinkedList chain = new SingleLinkedList(5);

        chain.printChain(chain.getHead());
       // DataNode dataNode=chain.reverse1(chain.getHead());
       // chain.printChain(dataNode);
        chain.removeNthFromEnd(chain.getHead(),2);
        chain.printChain(chain.getHead());
    }


    public DataNode removeNthFromEnd(DataNode head, int n) {
        int count=1;
        DataNode cur=head;
        DataNode countNode=head;
        while(countNode.getNext()!=null){
            countNode=countNode.getNext();
            count++;
        }

        int length=1;
        int index=count-n;
        if(index==0){
            return head.getNext();
        }
        while(cur.getNext()!=null){
            if(index==length++){
                cur.next = cur.getNext().getNext();
                return head;
            }
            cur=cur.getNext();
        }

        return head;
    }
}
