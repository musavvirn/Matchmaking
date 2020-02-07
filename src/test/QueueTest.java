package test;

import enums.QueueStateEnum;
import model.Queue;
import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    Queue Q = new Queue();

    @Test
    public void test_Activate() {
        Q.setState(QueueStateEnum.INACTIVE);
        Assert.assertTrue(Q.activate());
        Q.setState(QueueStateEnum.EMPTY);
        Assert.assertFalse(Q.activate());
    }

    @Test
    public void test_Deactivate() {
        Q.setState(QueueStateEnum.INACTIVE);
        Assert.assertFalse(Q.deactivate());
        Q.activate();
        Assert.assertTrue(Q.deactivate());
        Assert.assertFalse(Q.deactivate());
    }


}
