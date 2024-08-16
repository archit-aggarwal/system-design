public class _03_Composition_Example1 {
  public static void main(String[] args) {
    Stack1 stk = new Stack1();
    stk.push(10); stk.push(20);
    stk.push(30); stk.push(40);

    System.out.println(stk.peek());
    System.out.println(stk.pop());
    System.out.println(stk.get(1));

    Stack2 stk2 = new Stack2();
    stk2.push(10); stk2.push(20);
    stk2.push(30); stk2.push(40);

    System.out.println(stk2.peek());
    System.out.println(stk2.pop());
  }
}

class DynamicArray {
  private Integer[] data = new Integer[8];
  private int size = 0;

  public Integer get(int idx){
    if(idx < 0 || idx >= size) return null;
    return data[idx];
  }

  public void push(Integer ele){
    if(size == data.length) {
      Integer[] newData = new Integer[size * 2];
      for(int idx = 0; idx < size; idx++){
        newData[idx] = data[idx];
      }
      data = newData;
    }
    data[size++] = ele;
  }

  public Integer pop(){
    if(size == 0) return null;
    return data[--size];
  }

  public int getSize() {
    return size;
  }
}

class Stack1 extends DynamicArray {
  public Integer peek() {
    if(getSize() == 0) return null;
    return super.get(getSize() - 1);
  }
}


class Stack2 {
  private DynamicArray array = new DynamicArray();

  public void push(Integer ele){
    array.push(ele);
  }

  public Integer pop(){
    return array.pop();
  }

  public Integer peek(){
    int size = array.getSize();
    if(size == 0) return null;
    return array.get(size - 1);
  }
}