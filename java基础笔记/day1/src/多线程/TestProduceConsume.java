package 多线程;
/*
 * 生产者与消费者的问题：
 * 
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处取走产品
 * 店员一次只能持有固定数量的产品(比如：20)，如果生产者试图生产更多的产品，店员会叫生产者停一下
 * 如果店中有空位放产品了再通知生产者继续生产，如果店中没有产品了，店员会告诉消费者等一下
 * 如果店中有产品了再通知消费者来取走产品
 * 
 * 
 * 分析：
 *   1.是否涉及到多线程的问题？是！生产者，消费者
 *   2.是否涉及到共享数据？有！
 *   3.此共享数据是谁？即为产品的数量
 *   4.是否涉及到线程的通信？存在着生产者与消费者的通信
 */



public class TestProduceConsume {

}
