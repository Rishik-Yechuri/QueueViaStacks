import java.util.Stack;

public class QueueViaStacks {
    public static void main(String[] args) {
        try
        {
            QueueViaStacks obj = new QueueViaStacks();
            obj.run (args);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
    }
    public void run(String[] args) throws Exception{
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());

    }
    class MyQueue{
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> helperStack = new Stack<>();
        public int poll(){
            if(!mainStack.isEmpty()){
                return mainStack.pop();
            }
            return 0;
        }
        public void add(int data){
            int mainSize = mainStack.size();
            for(int x=0;x<mainSize;x++){
                helperStack.push(mainStack.pop());
            }
            mainStack.push(data);
            int helperSize = helperStack.size();
            for(int x=0;x<helperSize;x++){
                mainStack.push(helperStack.pop());
            }
        }
        public int peek(){
            return mainStack.peek();
        }
    }
}