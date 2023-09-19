package ui;

import java.util.LinkedList;

//node class to hold the order details 
class node {
    int id;
    String item = null;
    double cost;
    int quantity;
    node next = null, pre = null;
}

// Queue class
class uiQueue {
    // head and tail variable to hold the 1st and last node
    node head, tail;
    // totalCost variable to hold the total cost of items ordered
    double totalCost = 0;
    // count variable to count the number of nodes
    int count;
    // token variable
    public int token = 0;
    // type veriable to set what type of order it is
    String type;
    // string to hold usr info
    String[] usr;

    // pushItem method to push ordered item in the queue
    public void pushItem(int i, String x, int q, double c) {
        node temp = new node();
        temp.id = i;
        temp.item = x;
        temp.quantity = q;
        temp.cost = c * q;
        totalCost += temp.cost;
        i++;
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.pre = tail;
            tail.next = temp;
            tail = temp;
        }
        count++;
    }

    // popItem method to pop item from the queue
    public node popItem() {
        node temp = head;
        head = head.next;
        count--;
        return temp;
    }

    // removeItem method to remove an item from the queue by searching the item by
    // name
    public void removeItem(String x) {
        if ((x != null) && (count != 0)) {
            node temp = null;
            if (x == head.item) {
                if (head == tail) {
                    totalCost -= head.cost;
                    head = null;
                    tail = null;
                } else {
                    temp = head;
                    head = head.next;
                    totalCost -= temp.cost;
                    temp = null;
                }
            } else if (tail.item == x) {
                temp = tail;
                tail = tail.pre;
                totalCost -= temp.cost;
                temp = null;
            } else if ((x != head.item) && (x != tail.item)) {
                temp = head;
                while (temp != null) {
                    if (x == temp.item) {
                        break;
                    }
                    temp = temp.next;
                }
                temp.pre = temp.next;
                temp.next.pre = temp.pre;
                totalCost -= temp.cost;
                temp = null;
            } else {

            }
            count--;
        }
    }

    // changeQuantity method to change the quantity of a ordered item
    public void changeQuantity(String x, int q) {
        boolean exists = false;
        node temp = head;
        while (temp != null) {
            if (temp.item == x) {
                exists = true;
                break;
            }
            temp = temp.next;
        }
        if (exists) {
            totalCost -= temp.cost;
            temp.cost = temp.cost / temp.quantity;
            temp.quantity = q;
            temp.cost = temp.cost * q;
            totalCost += temp.cost;
        } else {

        }
    }

    // getItem method to get all the items information from the queue
    public node[] getItems() {
        node re[] = new node[count];
        node temp = head;
        int c = 0;
        while (temp.next != null) {
            re[c] = temp;
            temp = temp.next;
            c++;
        }
        return re;
    }

    public node[] getItems(int i) {
        int idItemCount = 0;
        node temp = head;
        LinkedList<node> list = new LinkedList<node>();
        while (temp != null) {
            if (temp.id == i) {
                list.add(temp);
                idItemCount++;
            }
            temp = temp.next;
        }
        if (idItemCount == 0) {
            return null;
        }
        node[] re = new node[idItemCount];
        for (int x = 0; x < idItemCount; x++) {
            re[x] = list.get(x);
        }
        return re;
    }

    public void clear() {
        totalCost = 0;
        count = 0;
        type = null;
        usr = null;
        head = null;
        tail = null;
    }
}