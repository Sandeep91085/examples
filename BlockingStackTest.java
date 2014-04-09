package examples;

public  class BlockingStackTest {

    final Producer producer;
    final Consumer consumer;

    public BlockingStackTest(int[] producerTasks, int size) {
        BlockingStack stack = new BlockingStack(size);
        producer = new Producer(stack, producerTasks);
        consumer = new Consumer(stack, producerTasks.length);
    }

    /**
    * Implements a Blocking Stack in LIFO manner.
    * The queue take n as an input to create an internal queue of size n tasks.
    */
    private class BlockingStack {
        final int size;
        final int[] tasks;
        int idx;

        public BlockingStack(int size) {
            this.size = size;
            this.tasks = new int[size];
        }

        /**
        * Adds a new task to the end of the stack.
        * The function blocks if the stack is full making sure the function returns only after adding the task.
        */
        public synchronized void add(int task) {
        	//System.out.println("Idx "+ idx+" size "+size);
            if (idx == size-1) {
                try {
                	 //System.out.println("Adding "+idx+"  waiting "+Thread.currentThread().getName());
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(" index "+idx+" Adding "+task+"  CurrentThread "+Thread.currentThread().getName());
            tasks[idx++] = task;
            notifyAll();
        }

        /**
        * Removes a task from the end of the stack.
        * The function blocks if the stack is empty making sure the function returns only after removing the task.
        */
        public synchronized int remove() {
            if (idx > 0) {
                this.notify();
            } else {
                try {
                	//System.out.println("Remove "+idx+" waiting "+Thread.currentThread().getName());
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           // System.out.println("Remove "+idx+" Current THread "+Thread.currentThread().getName());
            return tasks[idx--];
        }
    }

    private class Producer implements Runnable {
        final BlockingStack stack;
        final int[] tasks;

        Producer(BlockingStack stack, int[] tasks) {
            this.stack = stack;
            this.tasks = tasks;
        }

        public synchronized void run() {
            for (int task : tasks) {
                    try {
                    	stack.add(task);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    private class Consumer implements Runnable {
        final BlockingStack stack;
        final int size;

        Consumer(BlockingStack stack, int size) {
            this.stack = stack;
            this.size = size;
        }

        public synchronized void run() {
            int i = 0;
            while (i < size) {
            	try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println("Removed "+stack.remove());
                i++;
            }
        }
    }
}







